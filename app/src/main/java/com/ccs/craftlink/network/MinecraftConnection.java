package com.ccs.craftlink.network;

import android.util.Log;

import com.ccs.craftlink.model.ChatMessage;
import com.ccs.craftlink.model.ItemModel;
import com.ccs.craftlink.model.MinecraftServer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class MinecraftConnection {
    private static final String TAG = "MinecraftConnection";

    public enum ConnectionState {
        DISCONNECTED, CONNECTING, CONNECTED, AUTHENTICATING, PLAYING, ERROR
    }

    private final ExecutorService executor = Executors.newCachedThreadPool();
    private final AtomicBoolean isRunning = new AtomicBoolean(false);
    private final BehaviorSubject<ConnectionState> connectionState = BehaviorSubject.createDefault(ConnectionState.DISCONNECTED);
    private final BehaviorSubject<ChatMessage> chatMessages = BehaviorSubject.create();
    private final BehaviorSubject<ItemModel[]> inventoryObservable = BehaviorSubject.createDefault(new ItemModel[46]);
    
    // Inventory state
    private volatile int selectedHotbarSlot = 0;
    private volatile int[] hotbarSlots = new int[36];

    // Position state
    private volatile double playerX = 0, playerY = 0, playerZ = 0;
    private volatile float playerYaw = 0, playerPitch = 0;
    private volatile boolean isFlying = false;
    private volatile boolean onGround = true;
    private double motionY = 0;
    private double motionX = 0;
    private double motionZ = 0;
    
    private int ticksSinceLastPositionPacket = 0;

    private int currentInventoryStateId = 0;
    private io.reactivex.rxjava3.disposables.Disposable physicsTask;

    private final java.util.concurrent.ConcurrentHashMap<java.util.UUID, String> playerNames = new java.util.concurrent.ConcurrentHashMap<>();

    // State
    private int currentState = 0; // 0=Handshake, 1=Status, 2=Login, 3=Play
    private final BehaviorSubject<double[]> positionObservable = BehaviorSubject.createDefault(new double[]{0, 0, 0});
    
    private int playerEntityId = -1;
    private final PublishSubject<byte[]> packetStream = PublishSubject.create();
    private final PublishSubject<String> serverStatus = PublishSubject.create();

    private enum ProtocolState { UNKNOWN, STATUS, LOGIN, CONFIGURATION, PLAY }

    private static final java.util.Map<String, Integer> VERSION_PROTOCOL_MAP = new java.util.HashMap<>();
    static {
        VERSION_PROTOCOL_MAP.put("1.21.1", 767);
        VERSION_PROTOCOL_MAP.put("1.21", 767);
        VERSION_PROTOCOL_MAP.put("1.20.6", 766);
        VERSION_PROTOCOL_MAP.put("1.20.5", 766);
        VERSION_PROTOCOL_MAP.put("1.20.4", 765);
        VERSION_PROTOCOL_MAP.put("1.20.3", 765);
        VERSION_PROTOCOL_MAP.put("1.20.2", 764);
        VERSION_PROTOCOL_MAP.put("1.20.1", 763);
        VERSION_PROTOCOL_MAP.put("1.20", 763);
        VERSION_PROTOCOL_MAP.put("1.19.4", 762);
        VERSION_PROTOCOL_MAP.put("1.19.3", 761);
        VERSION_PROTOCOL_MAP.put("1.19.2", 760);
        VERSION_PROTOCOL_MAP.put("1.19.1", 760);
        VERSION_PROTOCOL_MAP.put("1.19", 759);
        VERSION_PROTOCOL_MAP.put("1.18.2", 758);
        VERSION_PROTOCOL_MAP.put("1.18.1", 757);
        VERSION_PROTOCOL_MAP.put("1.18", 757);
        VERSION_PROTOCOL_MAP.put("1.17.1", 756);
        VERSION_PROTOCOL_MAP.put("1.17", 755);
        VERSION_PROTOCOL_MAP.put("1.16.5", 754);
        VERSION_PROTOCOL_MAP.put("1.16.4", 754);
        VERSION_PROTOCOL_MAP.put("1.16.3", 753);
        VERSION_PROTOCOL_MAP.put("1.16.2", 751);
        VERSION_PROTOCOL_MAP.put("1.16.1", 736);
        VERSION_PROTOCOL_MAP.put("1.16", 735);
        VERSION_PROTOCOL_MAP.put("1.15.2", 578);
        VERSION_PROTOCOL_MAP.put("1.15.1", 575);
        VERSION_PROTOCOL_MAP.put("1.15", 573);
        VERSION_PROTOCOL_MAP.put("1.14.4", 498);
        VERSION_PROTOCOL_MAP.put("1.14.3", 490);
        VERSION_PROTOCOL_MAP.put("1.14.2", 485);
        VERSION_PROTOCOL_MAP.put("1.14.1", 480);
        VERSION_PROTOCOL_MAP.put("1.14", 477);
        VERSION_PROTOCOL_MAP.put("1.12.2", 340);
        VERSION_PROTOCOL_MAP.put("1.8.9", 47);
    }

    public static int getProtocolVersion(String version) {
        if (version == null || version.isEmpty()) return 765;
        String normalized = version.trim();
        Integer protocol = VERSION_PROTOCOL_MAP.get(normalized);
        if (protocol != null) return protocol;
        for (java.util.Map.Entry<String, Integer> entry : VERSION_PROTOCOL_MAP.entrySet()) {
            if (normalized.startsWith(entry.getKey().substring(0, 4))) {
                return entry.getValue();
            }
        }
        return 765;
    }

    private MinecraftServer currentServer;
    private Thread connectionThread;
    private long lastActivity;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String username = "CraftLink_User";
    private final WorldTracker worldTracker = new WorldTracker();
    private ProtocolState protocolState = ProtocolState.UNKNOWN;
    private int compressionThreshold = -1;

    public Observable<ConnectionState> observeConnectionState() {
        return connectionState;
    }

    public io.reactivex.rxjava3.core.Observable<ChatMessage> getChatObservable() {
        return chatMessages.hide();
    }

    public io.reactivex.rxjava3.core.Observable<ItemModel[]> getInventoryObservable() {
        return inventoryObservable.hide();
    }

    public Observable<byte[]> observePackets() {
        return packetStream;
    }

    public Observable<String> observeServerStatus() {
        return serverStatus;
    }

    public void setUsername(String username) {
        this.username = username;
        Log.d(TAG, "Username set to: " + username);
    }

    public ConnectionState getCurrentState() {
        return connectionState.getValue();
    }

    public MinecraftServer getCurrentServer() {
        return currentServer;
    }

    public WorldTracker getWorldTracker() {
        return worldTracker;
    }

    public void connect(MinecraftServer server) {
        if (isRunning.get()) {
            disconnect();
        }

        currentServer = server;
        isRunning.set(true);
        connectionState.onNext(ConnectionState.CONNECTING);

        connectionThread = new Thread(() -> {
            try {
                performConnection(server);
            } catch (Exception e) {
                Log.e(TAG, "Connection failed: " + e.getMessage(), e);
                connectionState.onNext(ConnectionState.ERROR);
            } finally {
                isRunning.set(false);
                close();
            }
        }, "MC-" + server.getAddress());
        connectionThread.setDaemon(true);
        connectionThread.start();
        
        physicsTask = io.reactivex.rxjava3.core.Observable.interval(50, java.util.concurrent.TimeUnit.MILLISECONDS)
                .observeOn(io.reactivex.rxjava3.schedulers.Schedulers.io())
                .subscribe(tick -> {
                    if (isRunning.get() && getCurrentState() == ConnectionState.PLAYING && currentServer != null) {
                        doPhysicsTick();
                    }
                }, Throwable::printStackTrace);
    }

    private void performConnection(MinecraftServer server) throws IOException {
        Log.i(TAG, "=== STARTING CONNECTION ===");
        Log.i(TAG, "Host: " + server.getAddress() + ":" + server.getPort());
        Log.i(TAG, "Protocol: " + server.getServerType());

        socket = new Socket();
        Log.d(TAG, "Socket created, connecting...");
        socket.connect(new InetSocketAddress(server.getAddress(), server.getPort()), 10000);
        Log.i(TAG, "TCP connected!");
        socket.setSoTimeout(30000);
        socket.setTcpNoDelay(true);

        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(new java.io.BufferedOutputStream(socket.getOutputStream()));

        connectionState.onNext(ConnectionState.CONNECTED);
        lastActivity = System.currentTimeMillis();

        Log.i(TAG, "Using username: " + username);
        int protocolVersion = getProtocolVersion(server.getVersion());
        Log.i(TAG, "Server version: " + server.getVersion() + " -> protocol: " + protocolVersion);
        Log.i(TAG, "Sending handshake (state=2, login)...");
        sendHandshake(out, server.getAddress(), server.getPort(), 2, protocolVersion);
        protocolState = ProtocolState.LOGIN;
        Log.i(TAG, "Sending login start: " + username);
        sendLoginStart(out, username, protocolVersion);
        connectionState.onNext(ConnectionState.AUTHENTICATING);
        Log.i(TAG, "Waiting for server response (LOGIN state)...");

        while (isRunning.get() && !socket.isClosed()) {
            try {
                int packetLength = readVarInt(in);
                Log.d(TAG, "Raw packet length: " + packetLength);
                if (packetLength <= 0 || packetLength > 1048576) {
                    Log.w(TAG, "Invalid packet length: " + packetLength);
                    break;
                }

                byte[] rawPacket = new byte[packetLength];
                in.readFully(rawPacket);
                ByteBuffer packetBuf = ByteBuffer.wrap(rawPacket);

                int packetId;
                byte[] data;

                if (compressionThreshold >= 0) {
                    int dataLength = readVarIntFromBuf(packetBuf);
                    Log.d(TAG, "Compressed packet: dataLength=" + dataLength + " compressionThreshold=" + compressionThreshold);
                    if (dataLength == 0) {
                        packetId = readVarIntFromBuf(packetBuf);
                        data = new byte[packetBuf.remaining()];
                        packetBuf.get(data);
                    } else {
                        byte[] compressed = new byte[packetBuf.remaining()];
                        packetBuf.get(compressed);
                        Log.d(TAG, "Decompressing " + compressed.length + " bytes to " + dataLength + " bytes");
                        byte[] decompressed = decompress(compressed, dataLength);
                        ByteBuffer decBuf = ByteBuffer.wrap(decompressed);
                        packetId = readVarIntFromBuf(decBuf);
                        data = new byte[decBuf.remaining()];
                        decBuf.get(data);
                    }
                } else {
                    packetId = readVarIntFromBuf(packetBuf);
                    data = new byte[packetBuf.remaining()];
                    packetBuf.get(data);
                }

                lastActivity = System.currentTimeMillis();
                handlePacket(packetId, data);

            } catch (java.net.SocketTimeoutException e) {
                Log.w(TAG, "Socket timeout");
            } catch (java.io.EOFException e) {
                if (isRunning.get()) {
                    Log.e(TAG, "Connection closed by server (EOF)");
                    connectionState.onNext(ConnectionState.ERROR);
                }
                break;
            } catch (Exception e) {
                if (isRunning.get()) {
                    Log.e(TAG, "Connection lost: " + e.getMessage(), e);
                    connectionState.onNext(ConnectionState.ERROR);
                }
                break;
            }
        }
    }

    private void handlePacket(int packetId, byte[] data) throws IOException {
        Log.d(TAG, "Packet: id=0x" + Integer.toHexString(packetId) + " len=" + data.length + " state=" + protocolState);

        if (protocolState == ProtocolState.LOGIN) {
            handleLoginPacket(packetId, data);
        } else if (protocolState == ProtocolState.CONFIGURATION) {
            handleConfigurationPacket(packetId, data);
        } else if (protocolState == ProtocolState.PLAY) {
            handlePlayPacket(packetId, data);
        } else if (protocolState == ProtocolState.STATUS) {
            handleStatusPacket(packetId, data);
        }
    }

    private void handleLoginPacket(int packetId, byte[] data) throws IOException {
        switch (packetId) {
            case 0x00: {
                ByteBuffer buf = ByteBuffer.wrap(data);
                String reason = readMinecraftString(buf);
                Log.e(TAG, "LOGIN DISCONNECT: " + reason);
                String message = "Disconnected by server";
                if (reason != null) {
                    try {
                        com.google.gson.JsonObject obj = com.google.gson.JsonParser.parseString(reason).getAsJsonObject();
                        if (obj.has("text")) {
                            message = obj.get("text").getAsString();
                        } else if (obj.has("translate")) {
                            message = obj.get("translate").getAsString();
                        } else {
                            message = reason;
                        }
                    } catch (Exception e) {
                        message = reason;
                    }
                }
                chatMessages.onNext(new ChatMessage("Server", message, ChatMessage.MessageType.SYSTEM));
                connectionState.onNext(ConnectionState.ERROR);
                isRunning.set(false);
                break;
            }
            case 0x01: {
                Log.i(TAG, "Encryption Request received - initializing encryption");
                handleEncryptionRequest(data);
                break;
            }
            case 0x02: {
                Log.i(TAG, "LOGIN SUCCESS!");
                if (getProtocolVersion(currentServer.getVersion()) >= 764) {
                    Log.i(TAG, "Sending Login Acknowledged");
                    sendPacket(0x03, null);
                    protocolState = ProtocolState.CONFIGURATION;
                } else {
                    protocolState = ProtocolState.PLAY;
                    connectionState.onNext(ConnectionState.PLAYING);
                }
                break;
            }
            case 0x03: {
                ByteBuffer buf = ByteBuffer.wrap(data);
                int threshold = readVarIntFromBuf(buf);
                compressionThreshold = threshold;
                Log.i(TAG, "Set Compression: threshold=" + threshold + " (compression " + (threshold >= 0 ? "ENABLED" : "disabled") + ")");
                break;
            }
            default:
                Log.d(TAG, "Unhandled login packet: 0x" + Integer.toHexString(packetId));
                break;
        }
    }

    private void handleEncryptionRequest(byte[] data) throws IOException {
        try {
            ByteBuffer buf = ByteBuffer.wrap(data);
            String serverId = readMinecraftString(buf);
            
            int pubKeyLen = readVarIntFromBuf(buf);
            byte[] pubKeyBytes = new byte[pubKeyLen];
            buf.get(pubKeyBytes);
            
            int tokenLen = readVarIntFromBuf(buf);
            byte[] verifyToken = new byte[tokenLen];
            buf.get(verifyToken);

            java.security.KeyFactory keyFactory = java.security.KeyFactory.getInstance("RSA");
            java.security.PublicKey publicKey = keyFactory.generatePublic(new java.security.spec.X509EncodedKeySpec(pubKeyBytes));

            javax.crypto.KeyGenerator keyGen = javax.crypto.KeyGenerator.getInstance("AES");
            keyGen.init(128);
            javax.crypto.SecretKey secretKey = keyGen.generateKey();

            javax.crypto.Cipher rsaCipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
            rsaCipher.init(javax.crypto.Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptedSecret = rsaCipher.doFinal(secretKey.getEncoded());
            byte[] encryptedToken = rsaCipher.doFinal(verifyToken);

            java.io.ByteArrayOutputStream payload = new java.io.ByteArrayOutputStream();
            writeVarIntToStream(payload, encryptedSecret.length);
            payload.write(encryptedSecret);
            writeVarIntToStream(payload, encryptedToken.length);
            payload.write(encryptedToken);
            sendPacket(0x01, payload.toByteArray());

            javax.crypto.Cipher decryptCipher = javax.crypto.Cipher.getInstance("AES/CFB8/NoPadding");
            decryptCipher.init(javax.crypto.Cipher.DECRYPT_MODE, secretKey, new javax.crypto.spec.IvParameterSpec(secretKey.getEncoded()));
            
            javax.crypto.Cipher encryptCipher = javax.crypto.Cipher.getInstance("AES/CFB8/NoPadding");
            encryptCipher.init(javax.crypto.Cipher.ENCRYPT_MODE, secretKey, new javax.crypto.spec.IvParameterSpec(secretKey.getEncoded()));

            this.in = new DataInputStream(new javax.crypto.CipherInputStream(socket.getInputStream(), decryptCipher));
            this.out = new DataOutputStream(new javax.crypto.CipherOutputStream(socket.getOutputStream(), encryptCipher));

            Log.i(TAG, "Encryption enabled!");
        } catch (Exception e) {
            throw new IOException("Encryption setup failed: " + e.getMessage(), e);
        }
    }

    private void handleConfigurationPacket(int packetId, byte[] data) throws IOException {
        switch (packetId) {
            case 0x02: {
                Log.i(TAG, "Finish Configuration received, acknowledging...");
                sendPacket(0x02, null);
                protocolState = ProtocolState.PLAY;
                connectionState.onNext(ConnectionState.PLAYING);
                break;
            }
            case 0x01: {
                ByteBuffer buf = ByteBuffer.wrap(data);
                String reason = readMinecraftString(buf);
                Log.e(TAG, "CONFIGURATION DISCONNECT: " + reason);
                connectionState.onNext(ConnectionState.ERROR);
                isRunning.set(false);
                break;
            }
            case 0x03: {
                ByteBuffer buf = ByteBuffer.wrap(data);
                long id = buf.getLong();
                byte[] payload = new byte[8];
                ByteBuffer.wrap(payload).putLong(id);
                sendPacket(0x03, payload);
                break;
            }
            default:
                Log.d(TAG, "Unhandled configuration packet: 0x" + Integer.toHexString(packetId));
                break;
        }
    }

    private int getKeepAlivePlayClientboundId(int protocol) {
        if (protocol >= 766) return 0x26; // 1.20.5+
        if (protocol >= 764) return 0x24; // 1.20.2 - 1.20.4
        if (protocol >= 762) return 0x23; // 1.19.4 - 1.20.1
        if (protocol >= 759) return 0x20; // 1.19 - 1.19.3
        if (protocol >= 755) return 0x21; // 1.17 - 1.18.2
        if (protocol >= 735) return 0x1F; // 1.16 - 1.16.5
        if (protocol >= 477) return 0x21; // 1.14 - 1.15.2

        if (protocol >= 340) return 0x1F; // 1.12.2
        if (protocol >= 47) return 0x00; // 1.8.9
        return 0x21;
    }

    private int getKeepAlivePlayServerboundId(int protocol) {
        if (protocol >= 766) return 0x18; // 1.20.5+
        if (protocol == 765) return 0x15; // 1.20.3 - 1.20.4
        if (protocol == 764) return 0x14; // 1.20.2
        if (protocol >= 762) return 0x12; // 1.19.4 - 1.20.1
        if (protocol >= 759) return 0x11; // 1.19 - 1.19.3
        if (protocol >= 755) return 0x0F; // 1.17 - 1.18.2
        if (protocol >= 735) return 0x10; // 1.16 - 1.16.5
        if (protocol >= 477) return 0x0F; // 1.14 - 1.15.2

        if (protocol >= 340) return 0x0B; // 1.12.2
        if (protocol >= 47) return 0x00; // 1.8.9
        return 0x0F;
    }

    private int getDisconnectPlayClientboundId(int protocol) {
        if (protocol >= 766) return 0x1D; // 1.20.5+
        if (protocol >= 764) return 0x1B; // 1.20.2 - 1.20.4
        if (protocol >= 762) return 0x1A; // 1.19.4 - 1.20.1
        if (protocol >= 759) return 0x17; // 1.19 - 1.19.3
        if (protocol >= 755) return 0x1A; // 1.17 - 1.18.2
        if (protocol >= 735) return 0x19; // 1.16 - 1.16.5
        if (protocol >= 477) return 0x1A; // 1.14 - 1.15.2

        if (protocol >= 340) return 0x1A; // 1.12.2
        if (protocol >= 47) return 0x40; // 1.8.9
        return 0x1A;
    }

    private int getPositionClientboundId(int protocol) {
        if (protocol >= 764) return 0x3E; // 1.20.2 - 1.20.4
        if (protocol >= 762) return 0x3C; // 1.19.4 - 1.20.1
        if (protocol >= 761) return 0x38; // 1.19.3
        if (protocol >= 759) return 0x36; // 1.19
        if (protocol >= 755) return 0x38; // 1.17 - 1.18.2
        if (protocol >= 735) return 0x35; // 1.16 - 1.16.5
        if (protocol >= 477) return 0x35; // 1.14 - 1.15.2

        if (protocol >= 340) return 0x2F; // 1.12.2
        if (protocol >= 47) return 0x08; // 1.8.9
        return -1;
    }

    private int getPositionServerboundId(int protocol) {
        if (protocol >= 765) return 0x17; // 1.20.3 - 1.20.4
        if (protocol >= 764) return 0x16; // 1.20.2
        if (protocol >= 762) return 0x14; // 1.19.4 - 1.20.1
        if (protocol >= 759) return 0x13; // 1.19 - 1.19.3
        if (protocol >= 755) return 0x11; // 1.17 - 1.18.2
        if (protocol >= 735) return 0x12; // 1.16 - 1.16.5
        if (protocol >= 477) return 0x11; // 1.14 - 1.15.2

        if (protocol >= 340) return 0x0C; // 1.12.2
        if (protocol >= 47) return 0x04; // 1.8.9
        return -1;
    }
    
    private int getPositionAndRotationServerboundId(int protocol) {
        int posId = getPositionServerboundId(protocol);

        if (protocol >= 477) return posId + 1; // 1.14+
        if (protocol >= 340) return 0x0E; // 1.12.2
        if (protocol >= 47) return 0x06; // 1.8.9
        return posId == -1 ? -1 : posId + 1;
    }
    
    private int getTeleportConfirmServerboundId(int protocol) {
        return 0x00; // Has been 0x00 since 1.9!
    }

    private int getJoinGameClientboundId(int protocol) {
        if (protocol >= 766) return 0x2B; // 1.20.5+
        if (protocol >= 764) return 0x29; // 1.20.2 - 1.20.4
        if (protocol >= 762) return 0x28; // 1.19.4 - 1.20.1
        if (protocol == 761) return 0x27; // 1.19.3
        if (protocol >= 759) return 0x25; // 1.19 - 1.19.2
        if (protocol >= 755) return 0x26; // 1.17 - 1.18.2
        if (protocol >= 735) return 0x24; // 1.16 - 1.16.5

        if (protocol >= 340) return 0x23; // 1.12.2
        if (protocol >= 47) return 0x01; // 1.8.9
        return -1;
    }

    private int getEntityVelocityClientboundId(int protocol) {
        if (protocol >= 766) return 0x56; // 1.20.5+
        if (protocol >= 764) return 0x54; // 1.20.2 - 1.20.4
        if (protocol >= 762) return 0x52; // 1.19.4 - 1.20.1
        if (protocol == 761) return 0x4E; // 1.19.3
        if (protocol >= 759) return 0x4D; // 1.19 - 1.19.2
        if (protocol >= 755) return 0x4F; // 1.17 - 1.18.2
        if (protocol >= 735) return 0x45; // 1.16 - 1.16.5

        if (protocol >= 340) return 0x3E; // 1.12.2
        if (protocol >= 47) return 0x12; // 1.8.9
        return -1;
    }

    private void handlePlayPacket(int packetId, byte[] data) throws IOException {
        int protocol = getProtocolVersion(currentServer.getVersion());
        try {
            if (packetId == getDisconnectPlayClientboundId(protocol)) {
                ByteBuffer buf = ByteBuffer.wrap(data);
                String reason = readMinecraftString(buf);
                Log.e(TAG, "PLAY DISCONNECT: " + reason);
                chatMessages.onNext(new ChatMessage("Server", "Disconnected: " + reason, ChatMessage.MessageType.SYSTEM));
                connectionState.onNext(ConnectionState.ERROR);
                isRunning.set(false);
            } else if (packetId == getKeepAlivePlayClientboundId(protocol)) {
                ByteBuffer buf = ByteBuffer.wrap(data);
                long id = buf.getLong();
                Log.d(TAG, "KeepAlive received, responding...");
                sendKeepAlivePlay(id, protocol);
            } else if (packetId == getChunkDataClientboundId(protocol)) {
                handleChunkData(data, protocol);
            } else if (packetId == getWindowItemsClientboundId(protocol)) {
                handleWindowItems(ByteBuffer.wrap(data), protocol);
            } else if (packetId == getSetSlotClientboundId(protocol)) {
                handleSetSlot(ByteBuffer.wrap(data), protocol);
            } else if (packetId == getPositionClientboundId(protocol)) {
                handlePositionPacket(ByteBuffer.wrap(data), protocol);
            } else if (isChatPacket(packetId, protocol)) {
                handleChatPacket(packetId, data, protocol);
            } else if (packetId == getChunkBatchFinishedClientboundId(protocol)) {
                handleChunkBatchFinished(data, protocol);
            } else if (packetId == getPlayerInfoUpdateClientboundId(protocol)) {
                handlePlayerInfoUpdate(data, protocol);
            } else if (packetId == getJoinGameClientboundId(protocol)) {
                ByteBuffer buf = ByteBuffer.wrap(data);
                playerEntityId = buf.getInt();
                Log.d(TAG, "Join Game parsed, playerEntityId=" + playerEntityId);
            } else if (packetId == getEntityVelocityClientboundId(protocol)) {
                ByteBuffer buf = ByteBuffer.wrap(data);
                int entityId = readVarIntFromBuf(buf);
                if (entityId == playerEntityId) {
                    short vx = buf.getShort();
                    short vy = buf.getShort();
                    short vz = buf.getShort();
                    motionX = vx / 8000.0;
                    motionY = vy / 8000.0;
                    motionZ = vz / 8000.0;
                }
            } else {
                if (data.length <= 10) {
                    Log.d(TAG, "Unknown Play packet 0x" + Integer.toHexString(packetId) + " (len=" + data.length + ")");
                }
            }
            
            if (packetId == getUpdateHealthClientboundId(protocol)) {
                handleUpdateHealth(data);
            }
            if (packetId == getFoodLevelClientboundId(protocol)) {
                handleFoodLevel(data);
            }
        } catch (java.nio.BufferUnderflowException | IllegalArgumentException e) {
            Log.w(TAG, "Failed to parse play packet 0x" + Integer.toHexString(packetId) + " (len=" + data.length + "): " + e.getMessage());
        } catch (Exception e) {
            Log.w(TAG, "Error handling play packet 0x" + Integer.toHexString(packetId), e);
        }
    }

    private boolean isChatPacket(int packetId, int protocol) {
        if (protocol >= 766) return packetId == 0x6C || packetId == 0x39 || packetId == 0x1E; // 1.20.5+
        if (protocol == 765) return packetId == 0x69 || packetId == 0x37 || packetId == 0x1C; // 1.20.3-1.20.4
        if (protocol == 764) return packetId == 0x67 || packetId == 0x37 || packetId == 0x1C; // 1.20.2
        if (protocol >= 762) return packetId == 0x66 || packetId == 0x36 || packetId == 0x1B; // 1.19.4-1.20.1
        if (protocol >= 760) return packetId == 0x62 || packetId == 0x33 || packetId == 0x1A; // 1.19.1-1.19.2
        if (protocol == 759) return packetId == 0x5F || packetId == 0x30; // 1.19
        if (protocol >= 755) return packetId == 0x0F; // 1.17-1.18.2
        if (protocol >= 735) return packetId == 0x0E; // 1.16-1.16.5
        if (protocol >= 477) return packetId == 0x0F; // 1.14-1.15.2
        if (protocol >= 340) return packetId == 0x0F; // 1.12.2
        if (protocol >= 47) return packetId == 0x02; // 1.8.9
        return false;
    }

    private int getPlayerInfoUpdateClientboundId(int protocol) {
        if (protocol >= 766) return 0x3E; // 1.20.5+
        if (protocol >= 765) return 0x3C; // 1.20.3 - 1.20.4
        if (protocol >= 764) return 0x3A; // 1.20.2
        if (protocol >= 762) return 0x39; // 1.19.4-1.20.1
        if (protocol >= 759) return 0x37; // 1.19
        if (protocol >= 755) return 0x36; // 1.17-1.18.2
        if (protocol >= 735) return 0x33; // 1.16-1.16.5

        if (protocol >= 340) return 0x2D; // 1.12.2
        if (protocol >= 47) return 0x38; // 1.8.9
        return -1;
    }

    private int getChunkBatchFinishedClientboundId(int protocol) {
        if (protocol >= 766) return 0x0E; // 1.20.5+
        if (protocol >= 765) return 0x0D; // 1.20.3-1.20.4
        if (protocol == 764) return 0x0C; // 1.20.2
        return -1;
    }

    private int getChunkBatchReceivedServerboundId(int protocol) {
        if (protocol >= 764) return 0x07; // 1.20.2+
        return -1;
    }

    private int getSystemChatClientboundId(int protocol) {
        if (protocol >= 766) return 0x6C;
        if (protocol == 765) return 0x69;
        if (protocol == 764) return 0x67;
        if (protocol >= 762) return 0x66;
        if (protocol >= 760) return 0x62;
        if (protocol == 759) return 0x5F;

        if (protocol >= 340) return 0x0F; // 1.12.2
        if (protocol >= 47) return 0x02; // 1.8.9
        return -1;
    }

    private int getPlayerChatClientboundId(int protocol) {
        if (protocol >= 766) return 0x39;
        if (protocol >= 764) return 0x37;
        if (protocol >= 762) return 0x36;
        if (protocol >= 760) return 0x33;
        if (protocol == 759) return 0x30;

        if (protocol >= 340) return 0x0F; // 1.12.2
        if (protocol >= 47) return 0x02; // 1.8.9
        return -1;
    }

    private void handleChatPacket(int packetId, byte[] data, int protocol) {
        try {
            if (protocol <= 758) { // 1.18.2 and below
                ByteBuffer buf = ByteBuffer.wrap(data);
                String json = readMinecraftString(buf);
                String text = parseJsonChat(json);
                if (!text.isEmpty()) {
                    chatMessages.onNext(new ChatMessage("Server", text, ChatMessage.MessageType.CHAT));
                }
                return;
            }

            if (packetId == getPlayerChatClientboundId(protocol)) {
                if (protocol >= 761) { // 1.19.3+
                    ByteBuffer buf = ByteBuffer.wrap(data);
                    long uuidHigh = buf.getLong(); 
                    long uuidLow = buf.getLong(); // UUID
                    readVarIntFromBuf(buf); // index
                    boolean hasSig = buf.get() != 0;
                    if (hasSig) {
                        buf.position(buf.position() + 256);
                    }
                    String message = readMinecraftString(buf);
                    
                    String senderName = playerNames.get(new java.util.UUID(uuidHigh, uuidLow));
                    if (senderName == null) {
                        senderName = extractNbtStrings(data);
                        if (senderName.isEmpty()) senderName = "Player";
                        senderName = senderName.split(" ")[0]; 
                    }
                    chatMessages.onNext(new ChatMessage(senderName, message, ChatMessage.MessageType.CHAT));
                } else { // 1.19 - 1.19.2
                    ByteBuffer buf = ByteBuffer.wrap(data);
                    String message = readMinecraftString(buf);
                    chatMessages.onNext(new ChatMessage("Player", message, ChatMessage.MessageType.CHAT));
                }
                return;
            }

            if (protocol <= 764 && packetId == getSystemChatClientboundId(protocol)) {
                ByteBuffer buf = ByteBuffer.wrap(data);
                String json = readMinecraftString(buf);
                String text = parseJsonChat(json);
                if (!text.isEmpty()) {
                    chatMessages.onNext(new ChatMessage("Server", text, ChatMessage.MessageType.CHAT));
                }
                return;
            }

            String extracted = extractNbtStrings(data);
            if (!extracted.isEmpty()) {
                chatMessages.onNext(new ChatMessage("Server", extracted, ChatMessage.MessageType.CHAT));
            }
        } catch (Exception e) {
            Log.w(TAG, "Failed to parse chat packet", e);
        }
    }

    private void handlePlayerInfoUpdate(byte[] data, int protocol) {
        try {
            ByteBuffer buf = ByteBuffer.wrap(data);
            if (protocol >= 761) { // 1.19.3+
                int actionMask = readVarIntFromBuf(buf);
                int numPlayers = readVarIntFromBuf(buf);
                for (int i = 0; i < numPlayers; i++) {
                    long uuidHigh = buf.getLong();
                    long uuidLow = buf.getLong();
                    
                    if ((actionMask & 0x01) != 0) { // Add Player
                        String name = readMinecraftString(buf);
                        playerNames.put(new java.util.UUID(uuidHigh, uuidLow), name);
                        int numProps = readVarIntFromBuf(buf);
                        for (int j = 0; j < numProps; j++) {
                            readMinecraftString(buf); readMinecraftString(buf); // Name, Value
                            if (buf.get() != 0) readMinecraftString(buf); // Signature
                        }
                    }
                    if ((actionMask & 0x02) != 0) { // Initialize Chat
                        if (buf.get() != 0) {
                            buf.getLong(); buf.getLong(); buf.getLong();
                            int keyLen = readVarIntFromBuf(buf); buf.position(buf.position() + keyLen);
                            int sigLen = readVarIntFromBuf(buf); buf.position(buf.position() + sigLen);
                        }
                    }
                    if ((actionMask & 0x04) != 0) readVarIntFromBuf(buf); // Game Mode
                    if ((actionMask & 0x08) != 0) buf.get(); // Listed
                    if ((actionMask & 0x10) != 0) readVarIntFromBuf(buf); // Ping
                    if ((actionMask & 0x20) != 0) { // Display Name
                        if (buf.get() != 0) readMinecraftString(buf);
                    }
                }
            } else { // pre-1.19.3
                int action = readVarIntFromBuf(buf);
                if (action == 0) { // Add Player
                    int numPlayers = readVarIntFromBuf(buf);
                    for (int i = 0; i < numPlayers; i++) {
                        long uuidHigh = buf.getLong();
                        long uuidLow = buf.getLong();
                        String name = readMinecraftString(buf);
                        playerNames.put(new java.util.UUID(uuidHigh, uuidLow), name);
                    }
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Error parsing Player Info Update", e);
        }
    }

    private String parseJsonChat(String json) {
        try {
            JsonElement el = JsonParser.parseString(json);
            return extractTextFromJson(el);
        } catch (Exception e) {
            return json;
        }
    }

    private String extractTextFromJson(JsonElement element) {
        StringBuilder sb = new StringBuilder();
        if (element.isJsonPrimitive() && element.getAsJsonPrimitive().isString()) {
            sb.append(element.getAsString());
        } else if (element.isJsonObject()) {
            JsonObject obj = element.getAsJsonObject();
            
            String formattingCode = "";
            if (obj.has("color")) {
                formattingCode += getColorCode(obj.get("color").getAsString());
            }
            if (obj.has("bold") && obj.get("bold").getAsBoolean()) formattingCode += "§l";
            if (obj.has("italic") && obj.get("italic").getAsBoolean()) formattingCode += "§o";
            if (obj.has("underlined") && obj.get("underlined").getAsBoolean()) formattingCode += "§n";
            if (obj.has("strikethrough") && obj.get("strikethrough").getAsBoolean()) formattingCode += "§m";
            if (obj.has("obfuscated") && obj.get("obfuscated").getAsBoolean()) formattingCode += "§k";
            
            if (!formattingCode.isEmpty()) {
                sb.append(formattingCode);
            }

            if (obj.has("text")) sb.append(obj.get("text").getAsString());
            
            if (obj.has("extra")) {
                for (JsonElement child : obj.getAsJsonArray("extra")) {
                    sb.append(extractTextFromJson(child));
                }
            }
            if (obj.has("with")) {
                for (JsonElement child : obj.getAsJsonArray("with")) {
                    sb.append(extractTextFromJson(child));
                }
            }
            
            // Reset after object to prevent bleeding styles if not intended,
            // but usually parent styles apply to children unless overridden.
            // A simple approach is appending a reset code, but let's keep it simple.
        } else if (element.isJsonArray()) {
            for (JsonElement child : element.getAsJsonArray()) {
                sb.append(extractTextFromJson(child));
            }
        }
        return sb.toString();
    }

    private String getColorCode(String colorName) {
        switch (colorName.toLowerCase()) {
            case "black": return "§0";
            case "dark_blue": return "§1";
            case "dark_green": return "§2";
            case "dark_aqua": return "§3";
            case "dark_red": return "§4";
            case "dark_purple": return "§5";
            case "gold": return "§6";
            case "gray": return "§7";
            case "dark_gray": return "§8";
            case "blue": return "§9";
            case "green": return "§a";
            case "aqua": return "§b";
            case "red": return "§c";
            case "light_purple": return "§d";
            case "yellow": return "§e";
            case "white": return "§f";
            case "reset": return "§r";
            default: return "";
        }
    }

    private String extractNbtStrings(byte[] data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length - 2; i++) {
            if (data[i] == 0x08) {
                int len = ((data[i+1] & 0xFF) << 8) | (data[i+2] & 0xFF);
                if (len > 0 && len < 2000 && i + 3 + len <= data.length) {
                    String str = new String(data, i + 3, len, StandardCharsets.UTF_8);
                    if (isValidChatString(str)) {
                        sb.append(str).append(" ");
                        i += 2 + len;
                    }
                }
            }
        }
        return sb.toString().trim();
    }

    private boolean isValidChatString(String str) {
        if (str.isEmpty() || str.length() == 1) return false;
        String[] ignores = {"text", "translate", "color", "bold", "italic", "underlined", "strikethrough", "obfuscated", "extra", "with", "chat.type.announcement", "chat.type.text", "insertion", "clickEvent", "hoverEvent", "fallback"};
        for (String ign : ignores) {
            if (str.equals(ign)) return false;
        }
        int printable = 0;
        for (char c : str.toCharArray()) {
            if (c >= 32 && c <= 126 || c >= 1040 && c <= 1111) printable++;
        }
        return (float) printable / str.length() > 0.8f;
    }

    private int getWindowItemsClientboundId(int protocol) {
        if (protocol >= 764) return 0x13; // 1.20.2 - 1.20.6
        if (protocol >= 762) return 0x12; // 1.19.4 - 1.20.1
        if (protocol >= 759) return 0x11; // 1.19 - 1.19.3
        if (protocol >= 477) return 0x14; // 1.14 - 1.18.2

        if (protocol >= 340) return 0x14; // 1.12.2
        if (protocol >= 47) return 0x30; // 1.8.9
        return -1;
    }

    private int getChunkDataClientboundId(int protocol) {
        if (protocol >= 764) return 0x25; // 1.20.2 - 1.20.6
        if (protocol >= 762) return 0x24; // 1.19.4 - 1.20.1
        if (protocol == 761) return 0x20; // 1.19.3
        if (protocol >= 759) return 0x1F; // 1.19 - 1.19.2
        if (protocol >= 755) return 0x22; // 1.17 - 1.18.2

        if (protocol >= 340) return 0x20; // 1.12.2
        if (protocol >= 47) return 0x21; // 1.8.9
        return 0x21; // 1.16.5 and below
    }

    private int getSetSlotClientboundId(int protocol) {
        if (protocol >= 764) return 0x15; // 1.20.2 - 1.20.6
        if (protocol >= 762) return 0x14; // 1.19.4 - 1.20.1
        if (protocol == 761) return 0x13; // 1.19.3
        if (protocol >= 759) return 0x13; // 1.19 - 1.19.2
        if (protocol >= 755) return 0x16; // 1.17 - 1.18.2

        if (protocol >= 340) return 0x16; // 1.12.2
        if (protocol >= 47) return 0x2F; // 1.8.9
        return 0x15; // 1.16.5 and below
    }

    private int getUpdateHealthClientboundId(int protocol) {
        if (protocol >= 764) return 0x5B; // 1.20.2+
        if (protocol >= 762) return 0x57; // 1.19.4 - 1.20.1
        if (protocol == 761) return 0x53; // 1.19.3
        if (protocol >= 755) return 0x52; // 1.17 - 1.19.2

        if (protocol >= 340) return 0x41; // 1.12.2
        if (protocol >= 47) return 0x06; // 1.8.9
        return 0x49; // 1.16.5 and below
    }

    private int getFoodLevelClientboundId(int protocol) {
        if (protocol >= 764) return 0x5A; // 1.20.2+
        if (protocol >= 762) return 0x56; // 1.19.4 - 1.20.1
        if (protocol == 761) return 0x52; // 1.19.3
        if (protocol >= 755) return 0x51; // 1.17 - 1.19.2

        if (protocol >= 340) return 0x41; // 1.12.2
        if (protocol >= 47) return 0x06; // 1.8.9
        return 0x48; // 1.16.5 and below
    }
    
    private int getClientCommandServerboundId(int protocol) {
        if (protocol >= 764) return 0x08; // 1.20.2+
        if (protocol >= 762) return 0x07; // 1.19.4 - 1.20.1
        if (protocol >= 759) return 0x06; // 1.19 - 1.19.3

        if (protocol >= 340) return 0x16; // 1.12.2
        if (protocol >= 47) return 0x16; // 1.8.9
        return 0x04; // 1.16.5 - 1.18.2
    }

    public Observable<double[]> getPositionObservable() {
        return positionObservable;
    }

    private void handleUpdateHealth(byte[] data) {
        ByteBuffer buf = ByteBuffer.wrap(data);
        float health = buf.getFloat();
        if (health <= 0) {
            try {
                int protocol = getProtocolVersion(currentServer.getVersion());
                sendPacket(getClientCommandServerboundId(protocol), new byte[]{0});
            } catch (Exception e) {
                Log.e(TAG, "Failed to send respawn packet", e);
            }
        }
        com.ccs.craftlink.autofeatures.AutoEatManager.getInstance().onHealthChange((int) health);
    }

    private void handleFoodLevel(byte[] data) {
        ByteBuffer buf = ByteBuffer.wrap(data);
        int foodLevel = buf.getInt();
        float foodSaturation = buf.getFloat();
        Log.d(TAG, "Food level: " + foodLevel + " saturation: " + foodSaturation);
        com.ccs.craftlink.autofeatures.AutoEatManager.getInstance().onFoodLevelChange(foodLevel);
    }

    private void handlePositionPacket(ByteBuffer buf, int protocol) {
        double x = buf.getDouble();
        double y = buf.getDouble();
        double z = buf.getDouble();
        float yaw = buf.getFloat();
        float pitch = buf.getFloat();
        byte flags = buf.get();
        int teleportId = readVarIntFromBuf(buf);

        // Calculate actual position based on flags (relative vs absolute)
        playerX = (flags & 0x01) != 0 ? playerX + x : x;
        playerY = (flags & 0x02) != 0 ? playerY + y : y;
        playerZ = (flags & 0x04) != 0 ? playerZ + z : z;
        playerYaw = (flags & 0x08) != 0 ? playerYaw + yaw : yaw;
        playerPitch = (flags & 0x10) != 0 ? playerPitch + pitch : pitch;

        Log.d(TAG, "Server teleported us to " + playerX + ", " + playerY + ", " + playerZ + " (Teleport ID: " + teleportId + ")");

        positionObservable.onNext(new double[]{playerX, playerY, playerZ});
        sendTeleportConfirm(teleportId, protocol);
        sendPlayerPosition(protocol);
    }

    private void sendTeleportConfirm(int teleportId, int protocol) {
        try {
            int packetId = getTeleportConfirmServerboundId(protocol);
            if (packetId == -1) return;
            
            // Teleport Confirm is just the packet ID and the teleport ID
            java.io.ByteArrayOutputStream payload = new java.io.ByteArrayOutputStream();
            writeVarIntToStream(payload, teleportId);
            
            sendPacket(packetId, payload.toByteArray());
        } catch (Exception e) {
            Log.e(TAG, "Failed to send teleport confirm", e);
        }
    }

    private void handleChunkBatchFinished(byte[] data, int protocol) {
        try {
            int packetId = getChunkBatchReceivedServerboundId(protocol);
            if (packetId == -1) return;
            
            // Chunk Batch Received: float (desired chunks per tick)
            java.io.ByteArrayOutputStream payload = new java.io.ByteArrayOutputStream();
            java.io.DataOutputStream dos = new java.io.DataOutputStream(payload);
            dos.writeFloat(100.0f); // Request chunks as fast as possible
            dos.flush();
            sendPacket(packetId, payload.toByteArray());
            Log.d(TAG, "Sent Chunk Batch Received");
        } catch (Exception e) {
            Log.e(TAG, "Failed to send Chunk Batch Received", e);
        }
    }    public java.util.concurrent.ConcurrentHashMap<java.util.UUID, String> getPlayerNames() {
        return playerNames;
    }

    public void toggleFlying() {
        // Toggle flying. If we are on the ground, we can start flying.
        // If we are in the air, we stop flying.
        isFlying = !isFlying;
        if (!isFlying) {
            motionY = 0;
        }
    }

    public void rotateCamera(float dYaw, float dPitch) {
        playerYaw += dYaw;
        playerPitch += dPitch;
        
        // Clamp pitch
        if (playerPitch > 90) playerPitch = 90;
        if (playerPitch < -90) playerPitch = -90;
        
        // Wrap yaw
        playerYaw = playerYaw % 360;
        
        executor.submit(() -> {
            int protocol = getProtocolVersion(currentServer.getVersion());
            sendPlayerPosition(protocol);
        });
    }

    public void moveRelative(double dx, double dy, double dz) {
        // Calculate true movement vectors based on playerYaw
        double yawRad = Math.toRadians(playerYaw);
        double fwdX = -Math.sin(yawRad);
        double fwdZ = Math.cos(yawRad);
        double rightX = Math.cos(yawRad);
        double rightZ = Math.sin(yawRad);
        
        playerX += dx * rightX + dz * fwdX;
        playerZ += dx * rightZ + dz * fwdZ;
        
        if (isFlying) {
            playerY += dy;
        } else {
            if (dy > 0 && onGround) {
                motionY = 0.42; // Jump velocity
                onGround = false;
            } else if (dy < 0) {
                // Sneaking (crouch) logic could go here, maybe speed modifier?
            }
        }
    }
    
    private void doPhysicsTick() {
        boolean positionChanged = false;
        
        if (!isFlying) {
            motionY -= 0.08; // Gravity
            motionY *= 0.98; // Drag
            
            motionX *= 0.91; // Air friction (or ground friction later)
            motionZ *= 0.91;
            
            if (Math.abs(motionX) < 0.005) motionX = 0;
            if (Math.abs(motionZ) < 0.005) motionZ = 0;
            
            playerX += motionX;
            playerZ += motionZ;
            
            if (motionX != 0 || motionZ != 0) positionChanged = true;
            
            Double groundY = worldTracker.getHeightAt(playerX, playerZ);
            double floor = groundY != null ? groundY + 1.0 : -64.0;
            
            if (playerY + motionY <= floor) {
                if (!onGround || playerY != floor) positionChanged = true;
                playerY = floor;
                motionY = 0;
                onGround = true;
                
                // Extra ground friction
                motionX *= 0.6;
                motionZ *= 0.6;
            } else {
                playerY += motionY;
                onGround = false;
                positionChanged = true;
            }
        } else {
            onGround = false;
            motionY = 0;
            motionX = 0;
            motionZ = 0;
        }
        
        ticksSinceLastPositionPacket++;
        
        if (positionChanged || ticksSinceLastPositionPacket >= 20) {
            if (positionChanged) {
                positionObservable.onNext(new double[]{playerX, playerY, playerZ});
            }
            int protocol = getProtocolVersion(currentServer.getVersion());
            sendPlayerPosition(protocol);
            ticksSinceLastPositionPacket = 0;
        }
    }

    private void sendPlayerPosition(int protocol) {
        try {
            int packetId = getPositionAndRotationServerboundId(protocol);
            if (packetId == -1) return;
            
            ByteBuffer buf = ByteBuffer.allocate(64);
            buf.putDouble(playerX);
            buf.putDouble(playerY);
            buf.putDouble(playerZ);
            buf.putFloat(playerYaw);
            buf.putFloat(playerPitch);
            buf.put((byte) (onGround ? 1 : 0)); // True for OnGround
            
            byte[] payload = new byte[buf.position()];
            buf.flip();
            buf.get(payload);
            
            sendPacket(packetId, payload);
        } catch (Exception e) {
            Log.e(TAG, "Failed to send player position", e);
        }
    }


    private void handleWindowItems(ByteBuffer buf, int protocol) {
        try {
            int windowId = buf.get() & 0xFF;
            if (protocol >= 756) {
                currentInventoryStateId = readVarIntFromBuf(buf); // stateId
                int count = readVarIntFromBuf(buf);
                for (int i = 0; i < count; i++) {
                    ItemModel item = readItemStack(buf, protocol, i);
                    if (windowId == 0 && item != null && i < 46) {
                        updateInventorySlot(i, item);
                    }
                }
            } else {
                int count = buf.getShort() & 0xFFFF;
                for (int i = 0; i < count; i++) {
                    ItemModel item = readItemStack(buf, protocol, i);
                    if (windowId == 0 && item != null && i < 46) {
                        updateInventorySlot(i, item);
                    }
                }
            }
        } catch (Exception e) {
            Log.w(TAG, "Failed to parse window_items: " + e.getMessage());
        }
    }

    private void handleSetSlot(ByteBuffer buf, int protocol) {
        try {
            int windowId = buf.get();
            if (protocol >= 756) {
                currentInventoryStateId = readVarIntFromBuf(buf); // stateId
            }
            int slot = buf.getShort();
            ItemModel item = readItemStack(buf, protocol, slot);
            if (windowId == 0 && item != null && slot >= 0 && slot < 46) {
                updateInventorySlot(slot, item);
            }
        } catch (Exception e) {
            Log.w(TAG, "Failed to parse set_slot: " + e.getMessage());
        }
    }

    private void updateInventorySlot(int slot, ItemModel item) {
        ItemModel[] current = inventoryObservable.getValue();
        if (current == null) current = new ItemModel[46];
        ItemModel[] next = new ItemModel[46];
        System.arraycopy(current, 0, next, 0, 46);
        next[slot] = item;
        inventoryObservable.onNext(next);
    }

    
    private String getFormattedItemName(int protocol, int itemId) {
        String name = com.ccs.craftlink.render.NativeRender.getItemName(protocol, itemId);
        if (name != null && name.startsWith("minecraft:")) {
            return name.substring(10);
        }
        return name != null ? name : "unknown";
    }

    private ItemModel readItemStack(ByteBuffer buf, int protocol, int slotIndex) {
        if (protocol < 393) {
            short itemId = buf.getShort();
            if (itemId == -1) return new ItemModel(slotIndex, 0, 0, "air");
            int count = buf.get();
            short damage = buf.getShort();
            skipNbt(buf, protocol);
            return new ItemModel(slotIndex, itemId, count, getFormattedItemName(protocol, itemId));
        } else {
            boolean present = buf.get() != 0;
            if (!present) return new ItemModel(slotIndex, 0, 0, "air");
            int itemId = readVarIntFromBuf(buf);
            int count = buf.get();
            skipNbt(buf, protocol);
            return new ItemModel(slotIndex, itemId, count, getFormattedItemName(protocol, itemId));
        }
    }

    private void skipNbt(ByteBuffer buf, int protocol) {
        if (!buf.hasRemaining()) return;
        byte type = buf.get();
        if (type == 0) return; // TAG_End

        if (protocol < 764) {
            if (buf.remaining() < 2) return;
            int len = buf.getShort() & 0xFFFF;
            if (buf.remaining() >= len) {
                buf.position(buf.position() + len);
            } else return;
        }
        skipNbtPayload(buf, type, protocol);
    }

    private void skipNbtPayload(ByteBuffer buf, byte type, int protocol) {
        if (!buf.hasRemaining()) return;
        switch (type) {
            case 1: buf.get(); break; // TAG_Byte
            case 2: buf.getShort(); break; // TAG_Short
            case 3: buf.getInt(); break; // TAG_Int
            case 4: buf.getLong(); break; // TAG_Long
            case 5: buf.getFloat(); break; // TAG_Float
            case 6: buf.getDouble(); break; // TAG_Double
            case 7: // TAG_Byte_Array
                int byteLen = buf.getInt();
                buf.position(buf.position() + byteLen);
                break;
            case 8: // TAG_String
                int strLen = buf.getShort() & 0xFFFF;
                buf.position(buf.position() + strLen);
                break;
            case 9: // TAG_List
                byte listType = buf.get();
                int listLen = buf.getInt();
                for (int i = 0; i < listLen && buf.hasRemaining(); i++) {
                    skipNbtPayload(buf, listType, protocol);
                }
                break;
            case 10: // TAG_Compound
                while (buf.hasRemaining()) {
                    byte tagType = buf.get();
                    if (tagType == 0) break; // TAG_End
                    int nameLen = buf.getShort() & 0xFFFF;
                    buf.position(buf.position() + nameLen);
                    skipNbtPayload(buf, tagType, protocol);
                }
                break;
            case 11: // TAG_Int_Array
                int intLen = buf.getInt();
                buf.position(buf.position() + (intLen * 4));
                break;
            case 12: // TAG_Long_Array
                int longLen = buf.getInt();
                buf.position(buf.position() + (longLen * 8));
                break;
        }
    }
    
    private void handleChunkData(byte[] data, int protocol) {
        if (protocol < 393) return; // Legacy chunks are not supported for minimap
        try {
            ByteBuffer buf = ByteBuffer.wrap(data);
            int chunkX = buf.getInt();
            int chunkZ = buf.getInt();
            
            // Read Heightmaps NBT
            if (!buf.hasRemaining()) return;
            byte rootType = buf.get(); // Should be 10 (Compound)
            if (rootType == 0) return;
            
            // Skip root name if protocol < 764
            if (protocol < 764) {
                int rootNameLen = buf.getShort() & 0xFFFF;
                buf.position(buf.position() + rootNameLen);
            }
            
            long[] motionBlocking = null;
            
            // Read Compound tags
            while (buf.hasRemaining()) {
                byte tagType = buf.get();
                if (tagType == 0) break; // TAG_End
                
                int nameLen = buf.getShort() & 0xFFFF;
                byte[] nameBytes = new byte[nameLen];
                buf.get(nameBytes);
                String name = new String(nameBytes, StandardCharsets.UTF_8);
                
                if (name.equals("MOTION_BLOCKING") && tagType == 12) {
                    // Read TAG_Long_Array
                    int longLen = buf.getInt();
                    motionBlocking = new long[longLen];
                    for (int i = 0; i < longLen; i++) {
                        motionBlocking[i] = buf.getLong();
                    }
                } else {
                    skipNbtPayload(buf, tagType, protocol);
                }
            }
            
            if (motionBlocking != null) {
                // Not used anymore for Phase 2.1, but keeping it for reference
            }
            
            // Read Data Size and Data
            int dataSize = readVarIntFromBuf(buf);
            byte[] chunkDataBytes = new byte[dataSize];
            buf.get(chunkDataBytes);
            
            // Send to WorldTracker to parse blocks
            worldTracker.parseChunkData(chunkX, chunkZ, chunkDataBytes);
            
        } catch (Exception e) {
            Log.e(TAG, "Failed to parse chunk data", e);
        }
    }
    

    
    private void sendRespawn() {
        try {
            int protocol = getProtocolVersion(currentServer.getVersion());
            int packetId = getClientCommandServerboundId(protocol);
            
            java.io.ByteArrayOutputStream payload = new java.io.ByteArrayOutputStream();
            writeVarIntToStream(payload, 0); // Action 0: Perform Respawn
            
            sendPacket(packetId, payload.toByteArray());
        } catch (Exception e) {
            Log.e(TAG, "Failed to send respawn command", e);
        }
    }

    private void handleStatusPacket(int packetId, byte[] data) throws IOException {
        switch (packetId) {
            case 0x00: {
                ByteBuffer buf = ByteBuffer.wrap(data);
                String json = readMinecraftString(buf);
                if (json != null) {
                    serverStatus.onNext(json);
                    parseServerStatus(json);
                }
                break;
            }
            case 0x01: {
                ByteBuffer buf = ByteBuffer.wrap(data);
                long id = buf.getLong();
                sendPong(id);
                break;
            }
        }
    }

    private void parseServerStatus(String json) {
        try {
            JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
            JsonObject version = obj.has("version") ? obj.getAsJsonObject("version") : null;
            JsonObject players = obj.has("players") ? obj.getAsJsonObject("players") : null;
            JsonObject description = obj.has("description") ? obj.getAsJsonObject("description") : null;

            String versionName = version != null && version.has("name") ? version.get("name").getAsString() : "Unknown";
            int maxPlayers = players != null && players.has("max") ? players.get("max").getAsInt() : 0;
            int onlinePlayers = players != null && players.has("online") ? players.get("online").getAsInt() : 0;

            String motd = "";
            if (description != null) {
                if (description.has("text")) {
                    motd = description.get("text").getAsString();
                } else if (description.has("translate")) {
                    motd = description.get("translate").getAsString();
                }
            }

            String status = "Version: " + versionName + " | Players: " + onlinePlayers + "/" + maxPlayers;
            if (!motd.isEmpty()) {
                status = motd + "\n" + status;
            }

            Log.i(TAG, "Server status: " + status);
            chatMessages.onNext(new ChatMessage("System", status, ChatMessage.MessageType.SYSTEM));

        } catch (Exception e) {
            Log.e(TAG, "Failed to parse server status", e);
        }
    }

    private void sendHandshake(DataOutputStream out, String address, int port, int nextState, int protocolVersion) throws IOException {
        byte[] addressBytes = address.getBytes(StandardCharsets.UTF_8);

        byte[] packetId = encodeVarInt(0x00);
        byte[] protocolBytes = encodeVarInt(protocolVersion);
        byte[] addressLen = encodeVarInt(addressBytes.length);
        byte[] portBytes = new byte[]{(byte) ((port >> 8) & 0xFF), (byte) (port & 0xFF)};
        byte[] state = encodeVarInt(nextState);

        int payloadLen = packetId.length + protocolBytes.length + addressLen.length +
                addressBytes.length + portBytes.length + state.length;

        writeVarInt(out, payloadLen);
        out.write(packetId);
        out.write(protocolBytes);
        out.write(addressLen);
        out.write(addressBytes);
        out.write(portBytes);
        out.write(state);
        out.flush();

        Log.d(TAG, "Handshake sent to " + address + ":" + port + " state=" + nextState);
    }

    private void sendStatusRequest(DataOutputStream out) throws IOException {
        writeVarInt(out, 1);
        out.writeByte(0x00);
        out.flush();
        Log.d(TAG, "Status request sent");
    }

    private void sendPing(DataOutputStream out, long timestamp) throws IOException {
        byte[] id = encodeVarInt(0x01);
        byte[] payload = new byte[8];
        ByteBuffer.wrap(payload).putLong(timestamp);

        writeVarInt(out, id.length + payload.length);
        out.write(id);
        out.write(payload);
        out.flush();
    }

    private void sendLoginStart(DataOutputStream out, String username, int protocolVersion) throws IOException {
        java.io.ByteArrayOutputStream payload = new java.io.ByteArrayOutputStream();
        byte[] nameBytes = username.getBytes(StandardCharsets.UTF_8);
        writeVarIntToStream(payload, nameBytes.length);
        payload.write(nameBytes);
        
        if (protocolVersion >= 761) {
            java.util.UUID uuid = getOfflineUUID(username);
            ByteBuffer bb = ByteBuffer.allocate(16);
            bb.putLong(uuid.getMostSignificantBits());
            bb.putLong(uuid.getLeastSignificantBits());
            payload.write(bb.array());
            Log.d(TAG, "Login Start sent with UUID: " + uuid);
        }
        
        sendPacket(0x00, payload.toByteArray());
        Log.d(TAG, "Login Start sent: " + username + " (protocol=" + protocolVersion + ")");
    }

    private static java.util.UUID getOfflineUUID(String username) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(("OfflinePlayer:" + username).getBytes(StandardCharsets.UTF_8));
            digest[6] = (byte) ((digest[6] & 0x0f) | 0x30);
            digest[8] = (byte) ((digest[8] & 0x3f) | 0x80);
            ByteBuffer bb = ByteBuffer.wrap(digest);
            return new java.util.UUID(bb.getLong(), bb.getLong());
        } catch (Exception e) {
            return java.util.UUID.randomUUID();
        }
    }

    private void sendPong(long id) throws IOException {
        byte[] payload = new byte[8];
        ByteBuffer.wrap(payload).putLong(id);
        sendPacket(0x01, payload);
    }

    private void sendKeepAlivePlay(long id, int protocol) throws IOException {
        byte[] payload = new byte[8];
        ByteBuffer.wrap(payload).putLong(id);
        sendPacket(getKeepAlivePlayServerboundId(protocol), payload);
    }

    private void sendChatMessage(String message) throws IOException {
        int protocol = getProtocolVersion(currentServer.getVersion());
        java.io.ByteArrayOutputStream payload = new java.io.ByteArrayOutputStream();

        if (protocol >= 761) { // 1.19.3+
            boolean isCommand = message.startsWith("/");
            String actualMessage = isCommand ? message.substring(1) : message;
            
            byte[] msgBytes = actualMessage.getBytes(StandardCharsets.UTF_8);
            writeVarIntToStream(payload, msgBytes.length);
            payload.write(msgBytes);

            ByteBuffer bb = ByteBuffer.allocate(16);
            bb.putLong(System.currentTimeMillis());
            bb.putLong(0L); // salt
            payload.write(bb.array());

            if (isCommand) {
                writeVarIntToStream(payload, 0); // 0 argument signatures
                writeVarIntToStream(payload, 0); // message count/offset
                payload.write(new byte[]{0, 0, 0}); // acknowledged
                sendPacket(0x04, payload.toByteArray()); // Chat Command
            } else {
                payload.write(0); // no signature
                writeVarIntToStream(payload, 0); // message count/offset
                payload.write(new byte[]{0, 0, 0}); // acknowledged
                sendPacket(0x05, payload.toByteArray()); // Chat Message
            }
        } else if (protocol <= 758) { // 1.18.2 and below
            byte[] msgBytes = message.getBytes(StandardCharsets.UTF_8);
            writeVarIntToStream(payload, msgBytes.length);
            payload.write(msgBytes);
            sendPacket(0x03, payload.toByteArray()); // Chat Message
        } else {
            Log.w(TAG, "Chat sending not fully supported for 1.19.0 - 1.19.2");
        }
    }

    public void sendChat(String message) {
        if (!isRunning.get() || getCurrentState() != ConnectionState.PLAYING) return;

        executor.execute(() -> {
            try {
                sendChatMessage(message);
            } catch (Exception e) {
                Log.e(TAG, "Failed to send chat", e);
            }
        });
    }

    public int getSelectedSlot() {
        return selectedHotbarSlot;
    }

    public void selectHotbarSlot(int slot) {
        if (slot < 0 || slot > 8) return;
        selectedHotbarSlot = slot;
        int protocol = getProtocolVersion(currentServer.getVersion());

        executor.execute(() -> {
            try {
                java.io.ByteArrayOutputStream payload = new java.io.ByteArrayOutputStream();
                java.io.DataOutputStream dataOut = new java.io.DataOutputStream(payload);
                dataOut.writeShort(slot);
                sendPacket(getSetHeldItemServerboundId(protocol), payload.toByteArray());
                Log.d(TAG, "Selected hotbar slot: " + slot);
            } catch (Exception e) {
                Log.e(TAG, "Failed to select slot", e);
            }
        });
    }

    public void sendUseItem(int protocol) {
        executor.execute(() -> {
            try {
            int hand = 0; // main hand
            java.io.ByteArrayOutputStream payload = new java.io.ByteArrayOutputStream();
            writeVarIntToStream(payload, hand);
            sendPacket(getUseItemServerboundId(protocol), payload.toByteArray());
            Log.d(TAG, "Use Item packet sent (hand=" + hand + ")");
        } catch (Exception e) {
            Log.e(TAG, "Failed to send use item", e);
        }
        });
    }

    public void dropHeldItem() {
        if (currentServer == null) return;
        int protocol = getProtocolVersion(currentServer.getVersion());
        executor.execute(() -> {
            try {
                java.io.ByteArrayOutputStream payload = new java.io.ByteArrayOutputStream();
                // Status: 4 (Drop Item), 3 (Drop Stack)
                writeVarIntToStream(payload, 4);
                
                // Location (0,0,0) encoded as long
                payload.write(new byte[]{0, 0, 0, 0, 0, 0, 0, 0});
                
                // Face (Byte)
                payload.write(0);
                
                // Sequence (VarInt) - added in 1.19
                if (protocol >= 759) {
                    writeVarIntToStream(payload, 0);
                }
                
                sendPacket(getPlayerActionServerboundId(protocol), payload.toByteArray());
                Log.d(TAG, "Dropped held item");
            } catch (Exception e) {
                Log.e(TAG, "Failed to drop item", e);
            }
        });
    }

    public int[] getInventorySlots() {
        return hotbarSlots.clone();
    }


    private int getClickWindowServerboundId(int protocol) {
        if (protocol >= 766) return 0x0E; // 1.20.5+
        if (protocol >= 764) return 0x0D; // 1.20.2 - 1.20.4
        if (protocol >= 762) return 0x0B; // 1.19.4 - 1.20.1
        if (protocol >= 759) return 0x0A; // 1.19 - 1.19.3
        if (protocol >= 755) return 0x08; // 1.17 - 1.18.2
        if (protocol >= 735) return 0x09; // 1.16 - 1.16.5
        if (protocol >= 340) return 0x07; // 1.12.2
        if (protocol >= 47) return 0x0E;  // 1.8.9
        return 0x08;
    }

    private short actionNumber = 1;


    public void sendClickWindow(int slot, int button, int mode) {
        if (currentServer == null) return;
        int protocol = getProtocolVersion(currentServer.getVersion());
        
        executor.execute(() -> {
            try {
            java.io.ByteArrayOutputStream payload = new java.io.ByteArrayOutputStream();
            java.io.DataOutputStream dataOut = new java.io.DataOutputStream(payload);

            dataOut.writeByte(0); // Window ID 0 (Player Inventory)
            
            if (protocol >= 756) {
                writeVarIntToStream(payload, currentInventoryStateId);
                dataOut.writeShort(slot);
                dataOut.writeByte(button);
                writeVarIntToStream(payload, mode);
                writeVarIntToStream(payload, 0); // changed slots array len 0
                // empty cursor item
                if (protocol >= 393) {
                    dataOut.writeBoolean(false); // present = false
                } else {
                    dataOut.writeShort(-1);
                }
            } else {
                dataOut.writeShort(slot);
                dataOut.writeByte(button);
                dataOut.writeShort(actionNumber++);
                if (protocol >= 755) {
                    dataOut.writeByte(mode); // 1.17 format
                } else if (protocol >= 735) {
                    dataOut.writeByte(mode); // 1.16 uses i8 for mode
                } else {
                    dataOut.writeByte(mode); // 1.8-1.15 uses i8 for mode
                }
                
                // empty cursor item
                if (protocol >= 393) {
                    dataOut.writeBoolean(false); // present = false
                } else {
                    dataOut.writeShort(-1);
                }
            }

            sendPacket(getClickWindowServerboundId(protocol), payload.toByteArray());
        } catch (Exception e) {
            android.util.Log.e(TAG, "Failed to send click window", e);
        }
        });
    }

    private int getSetHeldItemServerboundId(int protocol) {
        if (protocol >= 766) return 0x2F; // 1.20.5+
        if (protocol >= 765) return 0x2C; // 1.20.3 - 1.20.4
        if (protocol >= 764) return 0x2B; // 1.20.2
        if (protocol >= 762) return 0x28; // 1.19.4 - 1.20.1
        if (protocol >= 759) return 0x27; // 1.19 - 1.19.3
        if (protocol >= 755) return 0x25; // 1.17 - 1.18.2
        if (protocol >= 735) return 0x24; // 1.16 - 1.16.5
        if (protocol >= 340) return 0x1A; // 1.12.2
        if (protocol >= 47) return 0x09; // 1.8.9
        return 0x25;
    }

    private int getUseItemServerboundId(int protocol) {
        if (protocol >= 766) return 0x36; // 1.20.5+
        if (protocol >= 765) return 0x36; // 1.20.3 - 1.20.4
        if (protocol >= 764) return 0x35; // 1.20.2
        if (protocol >= 762) return 0x32; // 1.19.4 - 1.20.1
        if (protocol >= 759) return 0x31; // 1.19 - 1.19.3

        if (protocol >= 340) return 0x20; // 1.12.2
        if (protocol >= 47) return 0x08; // 1.8.9
        return 0x2C;
    }

    private int getPlayerActionServerboundId(int protocol) {
        if (protocol >= 766) return 0x22; // 1.20.5+
        if (protocol >= 765) return 0x21; // 1.20.3 - 1.20.4
        if (protocol >= 764) return 0x20; // 1.20.2
        if (protocol >= 762) return 0x1D; // 1.19.4 - 1.20.1
        if (protocol >= 759) return 0x1C; // 1.19 - 1.19.3
        if (protocol >= 755) return 0x1A; // 1.17 - 1.18.2
        if (protocol >= 735) return 0x1B; // 1.16 - 1.16.5
        if (protocol >= 477) return 0x1A; // 1.14 - 1.15.2
        if (protocol >= 340) return 0x14; // 1.12.2
        if (protocol >= 47) return 0x07;  // 1.8.9
        return 0x1A;
    }

    public void pingServer(MinecraftServer server) {
        if (isRunning.get()) {
            disconnect();
        }

        currentServer = server;
        isRunning.set(true);
        connectionState.onNext(ConnectionState.CONNECTING);

        connectionThread = new Thread(() -> {
            try {
                Socket s = new Socket();
                s.connect(new InetSocketAddress(server.getAddress(), server.getPort()), 10000);
                s.setSoTimeout(10000);

                DataInputStream dIn = new DataInputStream(s.getInputStream());
                DataOutputStream dOut = new DataOutputStream(s.getOutputStream());

                sendHandshake(dOut, server.getAddress(), server.getPort(), 1, getProtocolVersion(server.getVersion()));
                sendStatusRequest(dOut);

                int length = readVarInt(dIn);
                int packetId = readVarInt(dIn);
                int remaining = length - varIntSize(packetId);
                byte[] data = new byte[remaining];
                if (remaining > 0) dIn.readFully(data);

                if (packetId == 0x00) {
                    String json = new String(data, StandardCharsets.UTF_8);
                    parseServerStatus(json);
                }

                s.close();
                connectionState.onNext(ConnectionState.DISCONNECTED);
            } catch (Exception e) {
                Log.e(TAG, "Ping failed", e);
                connectionState.onNext(ConnectionState.ERROR);
            } finally {
                isRunning.set(false);
            }
        }, "MC-Ping-" + server.getAddress());
        connectionThread.setDaemon(true);
        connectionThread.start();
    }

    private void parseChatJson(String json) {
        try {
            String text = extractTextFromJson(json);
            if (text != null && !text.isEmpty()) {
                chatMessages.onNext(new ChatMessage("Server", text, ChatMessage.MessageType.SYSTEM));
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to parse chat", e);
        }
    }

    private String extractTextFromJson(String json) {
        try {
            JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
            if (obj.has("text")) {
                return obj.get("text").getAsString();
            }
            if (obj.has("translate")) {
                return obj.get("translate").getAsString();
            }
            return json;
        } catch (Exception e) {
            int idx = json.indexOf("\"text\":");
            if (idx != -1) {
                int start = json.indexOf("\"", idx + 7) + 1;
                int end = json.indexOf("\"", start);
                if (start > 0 && end > start) return json.substring(start, end);
            }
            return json;
        }
    }

    public void disconnect() {
        isRunning.set(false);
        close();
        connectionState.onNext(ConnectionState.DISCONNECTED);
    }

    private void close() {
        if (physicsTask != null && !physicsTask.isDisposed()) {
            physicsTask.dispose();
            physicsTask = null;
        }
        try {
            if (socket != null && !socket.isClosed()) socket.close();
        } catch (IOException ignored) {}
        socket = null;
        in = null;
        out = null;
    }

    public long getLastActivity() {
        return lastActivity;
    }

    public boolean isConnected() {
        return isRunning.get() && getCurrentState() == ConnectionState.PLAYING;
    }

    private static int varIntSize(int value) {
        int size = 0;
        do {
            value >>= 7;
            size++;
        } while (value != 0);
        return size;
    }

    private void sendPacket(int packetId, byte[] payload) throws IOException {
        java.io.ByteArrayOutputStream packetData = new java.io.ByteArrayOutputStream();
        writeVarIntToStream(packetData, packetId);
        if (payload != null) {
            packetData.write(payload);
        }
        byte[] uncompressed = packetData.toByteArray();

        if (compressionThreshold >= 0) {
            if (uncompressed.length >= compressionThreshold) {
                byte[] compressed = compress(uncompressed);
                java.io.ByteArrayOutputStream finalPacket = new java.io.ByteArrayOutputStream();
                writeVarIntToStream(finalPacket, uncompressed.length);
                finalPacket.write(compressed);
                byte[] toSend = finalPacket.toByteArray();
                writeVarInt(out, toSend.length);
                out.write(toSend);
            } else {
                java.io.ByteArrayOutputStream finalPacket = new java.io.ByteArrayOutputStream();
                writeVarIntToStream(finalPacket, 0);
                finalPacket.write(uncompressed);
                byte[] toSend = finalPacket.toByteArray();
                writeVarInt(out, toSend.length);
                out.write(toSend);
            }
        } else {
            writeVarInt(out, uncompressed.length);
            out.write(uncompressed);
        }
        out.flush();
    }

    private static int readVarInt(DataInputStream in) throws IOException {
        int value = 0;
        int shift = 0;
        int b;
        do {
            b = in.readUnsignedByte();
            value |= (b & 0x7F) << shift;
            shift += 7;
            if (shift > 35) throw new IOException("VarInt too big");
        } while ((b & 0x80) != 0);
        return value;
    }

    private static int readVarIntFromBuf(java.nio.ByteBuffer buf) {
        int value = 0;
        int shift = 0;
        byte b;
        do {
            b = buf.get();
            value |= (b & 0x7F) << shift;
            shift += 7;
        } while ((b & 0x80) != 0);
        return value;
    }

    private static byte[] decompress(byte[] compressed, int uncompressedSize) throws IOException {
        try {
            java.util.zip.Inflater inflater = new java.util.zip.Inflater();
            inflater.setInput(compressed);
            byte[] output = new byte[uncompressedSize];
            int decompressedLength = inflater.inflate(output);
            inflater.end();
            if (decompressedLength != uncompressedSize) {
                throw new IOException("Decompressed size mismatch: expected " + uncompressedSize + " got " + decompressedLength);
            }
            return output;
        } catch (java.util.zip.DataFormatException e) {
            throw new IOException("Decompression failed: " + e.getMessage(), e);
        }
    }

    private static byte[] compress(byte[] data) throws IOException {
        java.util.zip.Deflater deflater = new java.util.zip.Deflater();
        deflater.setInput(data);
        deflater.finish();
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            baos.write(buffer, 0, count);
        }
        deflater.end();
        return baos.toByteArray();
    }

    private static void writeVarInt(DataOutputStream out, int value) throws IOException {
        while ((value & ~0x7F) != 0) {
            out.writeByte((value & 0x7F) | 0x80);
            value >>= 7;
        }
        out.writeByte(value);
    }

    private static void writeVarIntToStream(java.io.OutputStream out, int value) throws IOException {
        while ((value & ~0x7F) != 0) {
            out.write((value & 0x7F) | 0x80);
            value >>= 7;
        }
        out.write(value);
    }

    private static byte[] encodeVarInt(int value) {
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        while ((value & ~0x7F) != 0) {
            baos.write((value & 0x7F) | 0x80);
            value >>= 7;
        }
        baos.write(value);
        return baos.toByteArray();
    }

    private static String readMinecraftString(java.nio.ByteBuffer buf) {
        int len = readVarIntFromBuf(buf);
        if (len <= 0 || len > 32767) return null;
        byte[] bytes = new byte[len];
        buf.get(bytes);
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
