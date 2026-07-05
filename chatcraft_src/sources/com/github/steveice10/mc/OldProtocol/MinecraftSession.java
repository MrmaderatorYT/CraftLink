package com.github.steveice10.mc.OldProtocol;

import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.common.SilentException;
import com.github.steveice10.mc.v1_5.packet.PacketClientChat;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.event.session.DisconnectedEvent;
import com.github.steveice10.packetlib.event.session.PacketReceivedEvent;
import com.github.steveice10.packetlib.event.session.PacketSentEvent;
import com.github.steveice10.packetlib.event.session.SessionEvent;
import com.github.steveice10.packetlib.event.session.SessionListener;
import com.github.steveice10.packetlib.packet.Packet;
import com.github.steveice10.packetlib.packet.PacketProtocol;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import mattecarra.usavsursschat.c;
import mattecarra.usavsursschat.exception.ConnectionNotRunning;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public abstract class MinecraftSession implements Session {
    protected String MINECRAFT_VERSION_NAME;
    protected int MINECRAFT_VERSION_NUMBER;
    protected InetSocketAddress address;
    protected Thread connectionThread;
    protected StreamNetInput_Old decoder;
    protected String host;
    protected PacketProtocol minecraft_protcol;
    protected int port;
    protected GameProfile profile;
    protected StreamNetOutput_Old streamOut;
    protected String username;
    final List<SessionListener> sessionListener = new ArrayList();
    final HashMap<String, Object> flags = new HashMap<>();
    protected Socket server = null;
    protected volatile boolean restart = false;
    protected ConcurrentLinkedQueue<Packet> actions = new ConcurrentLinkedQueue<>();
    c<String> packets = new c<>(20);

    @Override // com.github.steveice10.packetlib.Session
    public int getCompressionThreshold() {
        return -1;
    }

    @Override // com.github.steveice10.packetlib.Session
    public boolean isConnected() {
        return true;
    }

    protected abstract void login();

    protected abstract void onPacketSent(Packet packet);

    protected abstract boolean receiveAndElaboratePackets(Packet packet);

    @Override // com.github.steveice10.packetlib.Session
    public void setCompressionThreshold(int i) {
    }

    public MinecraftSession(String str, int i, PacketProtocol packetProtocol, GameProfile gameProfile, String str2, int i2) {
        this.port = 25565;
        this.MINECRAFT_VERSION_NUMBER = 61;
        this.MINECRAFT_VERSION_NAME = "1.5.2";
        this.minecraft_protcol = packetProtocol;
        this.username = gameProfile.getName();
        this.profile = gameProfile;
        this.host = str;
        this.port = i;
        this.MINECRAFT_VERSION_NUMBER = i2;
        this.MINECRAFT_VERSION_NAME = str2;
    }

    public void enableEncryption(SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding");
            cipher.init(2, secretKey, new IvParameterSpec(secretKey.getEncoded()));
            this.decoder.enableEncryption(cipher);
            Cipher cipher2 = Cipher.getInstance("AES/CFB8/NoPadding");
            cipher2.init(1, secretKey, new IvParameterSpec(secretKey.getEncoded()));
            this.streamOut.enableEncryption(cipher2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.github.steveice10.packetlib.Session
    public void connect() {
        this.connectionThread = new Thread(new Runnable() { // from class: com.github.steveice10.mc.OldProtocol.MinecraftSession.1
            @Override // java.lang.Runnable
            public void run() throws IOException {
                try {
                    try {
                        MinecraftSession.this.init();
                        while (!MinecraftSession.this.restart && MinecraftSession.this.server != null) {
                            MinecraftSession.this.sendPackets();
                            MinecraftSession.this.receiveAndElaboratePackets();
                        }
                        try {
                            if (MinecraftSession.this.server != null && !MinecraftSession.this.server.isClosed()) {
                                MinecraftSession.this.server.close();
                            }
                            MinecraftSession.this.streamOut.close();
                            MinecraftSession.this.decoder.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (MinecraftSession.this.restart) {
                            return;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            if (MinecraftSession.this.server != null && !MinecraftSession.this.server.isClosed()) {
                                MinecraftSession.this.server.close();
                            }
                            MinecraftSession.this.streamOut.close();
                            MinecraftSession.this.decoder.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        if (MinecraftSession.this.restart) {
                            return;
                        }
                    }
                    MinecraftSession.this.server = null;
                    MinecraftSession.this.streamOut = null;
                    MinecraftSession.this.decoder = null;
                    MinecraftSession.this.profile = null;
                    MinecraftSession.this.username = BuildConfig.FLAVOR;
                    MinecraftSession.this.packets.clear();
                } catch (Throwable th) {
                    try {
                        if (MinecraftSession.this.server != null && !MinecraftSession.this.server.isClosed()) {
                            MinecraftSession.this.server.close();
                        }
                        MinecraftSession.this.streamOut.close();
                        MinecraftSession.this.decoder.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    if (MinecraftSession.this.restart) {
                        throw th;
                    }
                    MinecraftSession.this.server = null;
                    MinecraftSession.this.streamOut = null;
                    MinecraftSession.this.decoder = null;
                    MinecraftSession.this.profile = null;
                    MinecraftSession.this.username = BuildConfig.FLAVOR;
                    MinecraftSession.this.packets.clear();
                    throw th;
                }
            }
        });
        this.connectionThread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() throws Exception {
        try {
            this.packets.clear();
            this.server = new Socket();
            Socket socket = this.server;
            InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getByName(this.host), this.port);
            this.address = inetSocketAddress;
            socket.connect(inetSocketAddress, 10000);
            this.server.setSoTimeout(30000);
            this.server.setTrafficClass(24);
            this.streamOut = new StreamNetOutput_Old(this.server.getOutputStream());
            this.decoder = new StreamNetInput_Old(this.server.getInputStream());
            login();
        } catch (Exception e) {
            callEvent(new DisconnectedEvent(this, "Connection failed! Check the ip!"));
            throw e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void sendPacket(Packet packet) {
        try {
            this.streamOut.writeByte(this.minecraft_protcol.getOutgoingId(packet.getClass()));
            packet.write(this.streamOut);
            this.streamOut.flush();
            try {
                onPacketSent(packet);
            } catch (Exception e) {
                e.printStackTrace();
            }
            callEvent(new PacketSentEvent(this, packet));
        } catch (SilentException e2) {
            e2.printStackTrace();
        }
    }

    protected void receiveAndElaboratePackets() throws Throwable {
        int unsignedByte;
        try {
            unsignedByte = this.decoder.readUnsignedByte();
        } catch (EOFException | IllegalArgumentException e) {
            e = e;
            unsignedByte = -1;
        }
        try {
            Packet packetCreateIncomingPacket = this.minecraft_protcol.createIncomingPacket(unsignedByte);
            this.packets.add(packetCreateIncomingPacket.getClass().getSimpleName());
            packetCreateIncomingPacket.read(this.decoder);
            try {
                if (receiveAndElaboratePackets(packetCreateIncomingPacket)) {
                    callEvent(new PacketReceivedEvent(this, packetCreateIncomingPacket));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (EOFException | IllegalArgumentException e3) {
            e = e3;
            if (unsignedByte != -1) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to read ");
                sb.append(this.MINECRAFT_VERSION_NAME);
                sb.append(". Packet ");
                sb.append(unsignedByte);
                sb.append(" not found. Here you are a list of last packets:");
                sb.append("\n");
                Iterator<String> it = this.packets.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    sb.append("\n");
                }
                System.out.println(sb.toString());
                disconnect("Contact dev! Packet " + unsignedByte + " not found!");
            }
            throw e;
        }
    }

    public void closeConnection() throws IOException {
        try {
            this.restart = true;
            this.address = null;
            this.server.close();
            this.streamOut.close();
            this.decoder.close();
            this.connectionThread.interrupt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void sendPackets() {
        Iterator<Packet> it = this.actions.iterator();
        while (it.hasNext()) {
            sendPacket(it.next());
        }
        this.actions.clear();
    }

    public void chat(String str) {
        this.actions.add(new PacketClientChat(str));
    }

    public void addPacketToQueue(Packet packet) {
        this.actions.add(packet);
    }

    @Override // com.github.steveice10.packetlib.Session
    public void connect(boolean z) {
        connect();
    }

    @Override // com.github.steveice10.packetlib.Session
    public String getHost() {
        return this.host;
    }

    @Override // com.github.steveice10.packetlib.Session
    public int getPort() {
        return this.port;
    }

    @Override // com.github.steveice10.packetlib.Session
    public PacketProtocol getPacketProtocol() {
        return this.minecraft_protcol;
    }

    @Override // com.github.steveice10.packetlib.Session
    public Map<String, Object> getFlags() {
        return this.flags;
    }

    @Override // com.github.steveice10.packetlib.Session
    public boolean hasFlag(String str) {
        return this.flags.containsKey(str);
    }

    @Override // com.github.steveice10.packetlib.Session
    public <T> T getFlag(String str) {
        return (T) this.flags.get(str);
    }

    @Override // com.github.steveice10.packetlib.Session
    public void setFlag(String str, Object obj) {
        this.flags.put(str, obj);
    }

    @Override // com.github.steveice10.packetlib.Session
    public List<SessionListener> getListeners() {
        return this.sessionListener;
    }

    @Override // com.github.steveice10.packetlib.Session
    public void addListener(SessionListener sessionListener) {
        this.sessionListener.add(sessionListener);
    }

    @Override // com.github.steveice10.packetlib.Session
    public void removeListener(SessionListener sessionListener) {
        this.sessionListener.remove(sessionListener);
    }

    @Override // com.github.steveice10.packetlib.Session
    public void callEvent(SessionEvent sessionEvent) {
        Iterator<SessionListener> it = this.sessionListener.iterator();
        while (it.hasNext()) {
            sessionEvent.call(it.next());
        }
    }

    @Override // com.github.steveice10.packetlib.Session
    public int getConnectTimeout() {
        try {
            return this.server.getSoTimeout();
        } catch (SocketException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.github.steveice10.packetlib.Session
    public void setConnectTimeout(int i) throws SocketException {
        try {
            this.server.setSoTimeout(i);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override // com.github.steveice10.packetlib.Session
    public int getReadTimeout() {
        return getConnectTimeout();
    }

    @Override // com.github.steveice10.packetlib.Session
    public void setReadTimeout(int i) throws SocketException {
        setConnectTimeout(i);
    }

    @Override // com.github.steveice10.packetlib.Session
    public int getWriteTimeout() {
        return getConnectTimeout();
    }

    @Override // com.github.steveice10.packetlib.Session
    public void setWriteTimeout(int i) throws SocketException {
        setConnectTimeout(i);
    }

    @Override // com.github.steveice10.packetlib.Session
    public void send(Packet packet) {
        try {
            addPacketToQueue(packet);
        } catch (ConnectionNotRunning e) {
            e.printStackTrace();
        }
    }

    @Override // com.github.steveice10.packetlib.Session
    public SocketAddress getLocalAddress() {
        return this.address;
    }

    @Override // com.github.steveice10.packetlib.Session
    public SocketAddress getRemoteAddress() {
        return this.address;
    }

    @Override // com.github.steveice10.packetlib.Session
    public void disconnect(String str) {
        try {
            if (this.server != null) {
                closeConnection();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        callEvent(new DisconnectedEvent(this, str));
    }

    @Override // com.github.steveice10.packetlib.Session
    public void disconnect(String str, boolean z) {
        disconnect(str);
    }

    @Override // com.github.steveice10.packetlib.Session
    public void disconnect(String str, Throwable th) {
        disconnect(str);
    }

    @Override // com.github.steveice10.packetlib.Session
    public void disconnect(String str, Throwable th, boolean z) {
        disconnect(str);
    }
}
