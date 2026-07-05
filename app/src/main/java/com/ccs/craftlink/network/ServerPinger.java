package com.ccs.craftlink.network;

import android.util.Log;

import com.ccs.craftlink.model.MinecraftServer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class ServerPinger {
    private static final String TAG = "ServerPinger";
    private static ServerPinger instance;

    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final BehaviorSubject<ServerStatus> statusSubject = BehaviorSubject.create();

    public static ServerPinger getInstance() {
        if (instance == null) {
            instance = new ServerPinger();
        }
        return instance;
    }

    private ServerPinger() {}

    public Observable<ServerStatus> observeStatus() {
        return statusSubject;
    }

    public void pingServer(MinecraftServer server) {
        Log.i(TAG, "Pinging " + server.getAddress() + ":" + server.getPort());
        statusSubject.onNext(new ServerStatus(server, ServerStatus.Status.PINGING, null, 0, 0, null, null));

        executor.execute(() -> {
            long startTime = System.currentTimeMillis();
            try {
                java.net.Socket socket = new java.net.Socket();
                socket.connect(new java.net.InetSocketAddress(server.getAddress(), server.getPort()), 10000);
                socket.setSoTimeout(10000);

                java.io.DataInputStream in = new java.io.DataInputStream(socket.getInputStream());
                java.io.DataOutputStream out = new java.io.DataOutputStream(socket.getOutputStream());

                int protocolVersion = MinecraftConnection.getProtocolVersion(server.getVersion());
                sendStatusHandshake(out, server.getAddress(), server.getPort(), protocolVersion);
                sendStatusRequest(out);

                byte[] response = readFullPacket(in);
                long latency = System.currentTimeMillis() - startTime;

                if (response != null) {
                    String json = extractJsonString(response);
                    if (json != null) {
                        ServerStatus status = parseStatusResponse(server, json, latency);
                        statusSubject.onNext(status);
                        Log.i(TAG, "Server status: " + status);
                    } else {
                        statusSubject.onNext(new ServerStatus(server, ServerStatus.Status.ERROR, null, latency, 0, "Invalid response", null));
                    }
                } else {
                    statusSubject.onNext(new ServerStatus(server, ServerStatus.Status.OFFLINE, null, latency, 0, "No response", null));
                }

                socket.close();
            } catch (java.net.SocketTimeoutException e) {
                long latency = System.currentTimeMillis() - startTime;
                Log.w(TAG, "Ping timeout for " + server.getAddress());
                statusSubject.onNext(new ServerStatus(server, ServerStatus.Status.OFFLINE, null, latency, 0, "Connection timeout", null));
            } catch (Exception e) {
                long latency = System.currentTimeMillis() - startTime;
                Log.e(TAG, "Ping failed: " + e.getMessage());
                statusSubject.onNext(new ServerStatus(server, ServerStatus.Status.ERROR, null, latency, 0, e.getMessage(), null));
            }
        });
    }

    private ServerStatus parseStatusResponse(MinecraftServer server, String json, long latency) {
        try {
            com.google.gson.JsonObject root = com.google.gson.JsonParser.parseString(json).getAsJsonObject();

            String versionName = "Unknown";
            int protocol = 0;
            if (root.has("version")) {
                com.google.gson.JsonObject version = root.getAsJsonObject("version");
                if (version.has("name")) versionName = version.get("name").getAsString();
                if (version.has("protocol")) protocol = version.get("protocol").getAsInt();
            }

            int maxPlayers = 0;
            int onlinePlayers = 0;
            String playerSample = null;
            if (root.has("players")) {
                com.google.gson.JsonObject players = root.getAsJsonObject("players");
                if (players.has("max")) maxPlayers = players.get("max").getAsInt();
                if (players.has("online")) onlinePlayers = players.get("online").getAsInt();
                if (players.has("sample")) {
                    com.google.gson.JsonArray sample = players.getAsJsonArray("sample");
                    if (sample != null && sample.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < Math.min(sample.size(), 5); i++) {
                            if (i > 0) sb.append(", ");
                            sb.append(sample.get(i).getAsJsonObject().get("name").getAsString());
                        }
                        if (sample.size() > 5) sb.append(" +").append(sample.size() - 5).append(" more");
                        playerSample = sb.toString();
                    }
                }
            }

            String motd = "";
            if (root.has("description")) {
                com.google.gson.JsonObject desc = root.getAsJsonObject("description");
                if (desc.has("text")) motd = desc.get("text").getAsString();
                else if (desc.has("translate")) motd = desc.get("translate").getAsString();
            }
            motd = motd.replaceAll("§[0-9a-fk-or]", "").trim();
            if (motd.isEmpty()) motd = "No MOTD";

            boolean modded = false;
            if (root.has("modinfo")) {
                com.google.gson.JsonObject modinfo = root.getAsJsonObject("modinfo");
                if (modinfo.has("type")) {
                    String type = modinfo.get("type").getAsString();
                    modded = !"vanilla".equalsIgnoreCase(type);
                }
            }

            ServerStatus.Status status = ServerStatus.Status.ONLINE;
            return new ServerStatus(server, status, motd, latency, onlinePlayers, versionName + " (protocol " + protocol + ")", playerSample, maxPlayers, modded);

        } catch (Exception e) {
            Log.e(TAG, "Failed to parse status: " + e.getMessage());
            return new ServerStatus(server, ServerStatus.Status.ONLINE, "Unknown", latency, 0, "Parse error", null);
        }
    }

    private void sendStatusHandshake(java.io.DataOutputStream out, String address, int port, int protocolVersion) throws java.io.IOException {
        byte[] addressBytes = address.getBytes(java.nio.charset.StandardCharsets.UTF_8);
        java.io.ByteArrayOutputStream packet = new java.io.ByteArrayOutputStream();
        writeVarIntToStream(packet, 0x00);
        writeVarIntToStream(packet, protocolVersion);
        writeVarIntToStream(packet, addressBytes.length);
        packet.write(addressBytes);
        packet.write((port >> 8) & 0xFF);
        packet.write(port & 0xFF);
        writeVarIntToStream(packet, 1);

        byte[] data = packet.toByteArray();
        writeVarIntToStream(out, data.length);
        out.write(data);
        out.flush();
    }

    private void sendStatusRequest(java.io.DataOutputStream out) throws java.io.IOException {
        writeVarIntToStream(out, 1);
        out.writeByte(0x00);
        out.flush();
    }

    private byte[] readFullPacket(java.io.DataInputStream in) throws java.io.IOException {
        int length = readVarIntFromStream(in);
        if (length <= 0 || length > 1048576) return null;
        byte[] data = new byte[length];
        in.readFully(data);
        return data;
    }

    private String extractJsonString(byte[] packetData) {
        try {
            java.nio.ByteBuffer buf = java.nio.ByteBuffer.wrap(packetData);
            int packetId = readVarIntFromBuffer(buf);
            if (packetId != 0x00) return null;
            return readMinecraftStringFromBuffer(buf);
        } catch (Exception e) {
            return null;
        }
    }

    private void writeVarIntToStream(java.io.OutputStream out, int value) throws java.io.IOException {
        while ((value & ~0x7F) != 0) {
            out.write((value & 0x7F) | 0x80);
            value >>= 7;
        }
        out.write(value);
    }

    private void writeVarIntToStream(java.io.ByteArrayOutputStream out, int value) {
        while ((value & ~0x7F) != 0) {
            out.write((value & 0x7F) | 0x80);
            value >>= 7;
        }
        out.write(value);
    }

    private int readVarIntFromStream(java.io.DataInputStream in) throws java.io.IOException {
        int value = 0, shift = 0;
        int b;
        do {
            b = in.readUnsignedByte();
            value |= (b & 0x7F) << shift;
            shift += 7;
            if (shift > 35) throw new java.io.IOException("VarInt too big");
        } while ((b & 0x80) != 0);
        return value;
    }

    private int readVarIntFromBuffer(java.nio.ByteBuffer buf) {
        int value = 0, shift = 0;
        byte b;
        do {
            b = buf.get();
            value |= (b & 0x7F) << shift;
            shift += 7;
        } while ((b & 0x80) != 0);
        return value;
    }

    private String readMinecraftStringFromBuffer(java.nio.ByteBuffer buf) {
        int len = readVarIntFromBuffer(buf);
        if (len <= 0 || len > 32767) return null;
        byte[] bytes = new byte[len];
        buf.get(bytes);
        return new String(bytes, java.nio.charset.StandardCharsets.UTF_8);
    }

    public static class ServerStatus {
        public enum Status { PINGING, ONLINE, OFFLINE, ERROR }

        private final MinecraftServer server;
        private final Status status;
        private final String motd;
        private final long latency;
        private final int onlinePlayers;
        private final String versionInfo;
        private final String playerSample;
        private final int maxPlayers;
        private final boolean modded;

        public ServerStatus(MinecraftServer server, Status status, String motd, long latency, int onlinePlayers, String versionInfo, String playerSample) {
            this(server, status, motd, latency, onlinePlayers, versionInfo, playerSample, 0, false);
        }

        public ServerStatus(MinecraftServer server, Status status, String motd, long latency, int onlinePlayers, String versionInfo, String playerSample, int maxPlayers, boolean modded) {
            this.server = server;
            this.status = status;
            this.motd = motd;
            this.latency = latency;
            this.onlinePlayers = onlinePlayers;
            this.versionInfo = versionInfo;
            this.playerSample = playerSample;
            this.maxPlayers = maxPlayers;
            this.modded = modded;
        }

        public MinecraftServer getServer() { return server; }
        public Status getStatus() { return status; }
        public String getMotd() { return motd; }
        public long getLatency() { return latency; }
        public int getOnlinePlayers() { return onlinePlayers; }
        public String getVersionInfo() { return versionInfo; }
        public String getPlayerSample() { return playerSample; }
        public int getMaxPlayers() { return maxPlayers; }
        public boolean isModded() { return modded; }

        public String getDisplayText() {
            switch (status) {
                case PINGING: return "Pinging...";
                case OFFLINE: return "Offline" + (versionInfo != null ? " (" + versionInfo + ")" : "");
                case ERROR: return "Error" + (versionInfo != null ? ": " + versionInfo : "");
                case ONLINE:
                    StringBuilder sb = new StringBuilder();
                    sb.append(onlinePlayers);
                    if (maxPlayers > 0) sb.append("/").append(maxPlayers);
                    sb.append(" players");
                    if (latency > 0) sb.append(" | ").append(latency).append("ms");
                    if (modded) sb.append(" | Modded");
                    return sb.toString();
                default: return "Unknown";
            }
        }

        @Override
        public String toString() {
            return "ServerStatus{server=" + server.getName() + ", status=" + status + ", motd='" + motd + "', latency=" + latency + "ms, players=" + onlinePlayers + "/" + maxPlayers + "}";
        }
    }
}
