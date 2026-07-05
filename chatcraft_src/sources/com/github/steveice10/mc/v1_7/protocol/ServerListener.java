package com.github.steveice10.mc.v1_7.protocol;

import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.auth.exception.request.RequestException;
import com.github.steveice10.mc.auth.service.SessionService;
import com.github.steveice10.mc.v1_7.protocol.data.status.handler.ServerInfoBuilder;
import com.github.steveice10.mc.v1_7.protocol.packet.handshake.client.HandshakePacket;
import com.github.steveice10.mc.v1_7.protocol.packet.ingame.client.ClientKeepAlivePacket;
import com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.ServerDisconnectPacket;
import com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.ServerKeepAlivePacket;
import com.github.steveice10.mc.v1_7.protocol.packet.login.client.EncryptionResponsePacket;
import com.github.steveice10.mc.v1_7.protocol.packet.login.client.LoginStartPacket;
import com.github.steveice10.mc.v1_7.protocol.packet.login.server.EncryptionRequestPacket;
import com.github.steveice10.mc.v1_7.protocol.packet.login.server.LoginDisconnectPacket;
import com.github.steveice10.mc.v1_7.protocol.packet.login.server.LoginSuccessPacket;
import com.github.steveice10.mc.v1_7.protocol.packet.status.client.StatusPingPacket;
import com.github.steveice10.mc.v1_7.protocol.packet.status.client.StatusQueryPacket;
import com.github.steveice10.mc.v1_7.protocol.packet.status.server.StatusPongPacket;
import com.github.steveice10.mc.v1_7.protocol.packet.status.server.StatusResponsePacket;
import com.github.steveice10.mc.v1_7.protocol.util.CryptUtil;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.event.session.ConnectedEvent;
import com.github.steveice10.packetlib.event.session.DisconnectingEvent;
import com.github.steveice10.packetlib.event.session.PacketReceivedEvent;
import com.github.steveice10.packetlib.event.session.SessionAdapter;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;
import javax.crypto.SecretKey;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public class ServerListener extends SessionAdapter {
    private static KeyPair pair = CryptUtil.generateKeyPair();
    private byte[] verifyToken = new byte[4];
    private String serverId = BuildConfig.FLAVOR;
    private String username = BuildConfig.FLAVOR;
    private long lastPingTime = 0;
    private int lastPingId = 0;

    public ServerListener() {
        new Random().nextBytes(this.verifyToken);
    }

    @Override // com.github.steveice10.packetlib.event.session.SessionAdapter, com.github.steveice10.packetlib.event.session.SessionListener
    public void connected(ConnectedEvent connectedEvent) {
        connectedEvent.getSession().setFlag("ping", 0);
    }

    @Override // com.github.steveice10.packetlib.event.session.SessionAdapter, com.github.steveice10.packetlib.event.session.SessionListener
    public void packetReceived(PacketReceivedEvent packetReceivedEvent) {
        MinecraftProtocol minecraftProtocol = (MinecraftProtocol) packetReceivedEvent.getSession().getPacketProtocol();
        if (minecraftProtocol.getMode() == ProtocolMode.HANDSHAKE && (packetReceivedEvent.getPacket() instanceof HandshakePacket)) {
            HandshakePacket handshakePacket = (HandshakePacket) packetReceivedEvent.getPacket();
            switch (handshakePacket.getIntent()) {
                case 1:
                    minecraftProtocol.setMode(ProtocolMode.STATUS, false, packetReceivedEvent.getSession());
                    break;
                case 2:
                    minecraftProtocol.setMode(ProtocolMode.LOGIN, false, packetReceivedEvent.getSession());
                    if (handshakePacket.getProtocolVersion() > 4) {
                        packetReceivedEvent.getSession().disconnect("Outdated server! I'm still on 1.7.4.");
                        break;
                    } else if (handshakePacket.getProtocolVersion() < 4) {
                        packetReceivedEvent.getSession().disconnect("Outdated client! Please use 1.7.4.");
                        break;
                    }
                    break;
                default:
                    throw new UnsupportedOperationException("Invalid client intent: " + handshakePacket.getIntent());
            }
        }
        if (minecraftProtocol.getMode() == ProtocolMode.LOGIN) {
            if (packetReceivedEvent.getPacket() instanceof LoginStartPacket) {
                this.username = ((LoginStartPacket) packetReceivedEvent.getPacket()).getUsername();
                if (packetReceivedEvent.getSession().hasFlag("verify-users") ? ((Boolean) packetReceivedEvent.getSession().getFlag("verify-users")).booleanValue() : true) {
                    packetReceivedEvent.getSession().send(new EncryptionRequestPacket(this.serverId, pair.getPublic(), this.verifyToken));
                } else {
                    GameProfile gameProfile = new GameProfile(UUID.nameUUIDFromBytes(("OfflinePlayer:" + this.username).getBytes()), this.username);
                    packetReceivedEvent.getSession().send(new LoginSuccessPacket(gameProfile));
                    packetReceivedEvent.getSession().setFlag("profile", gameProfile);
                    minecraftProtocol.setMode(ProtocolMode.GAME, false, packetReceivedEvent.getSession());
                    ServerLoginHandler serverLoginHandler = (ServerLoginHandler) packetReceivedEvent.getSession().getFlag("login-handler");
                    if (serverLoginHandler != null) {
                        serverLoginHandler.loggedIn(packetReceivedEvent.getSession());
                    }
                    new KeepAliveThread(packetReceivedEvent.getSession()).start();
                }
            } else if (packetReceivedEvent.getPacket() instanceof EncryptionResponsePacket) {
                EncryptionResponsePacket encryptionResponsePacket = (EncryptionResponsePacket) packetReceivedEvent.getPacket();
                PrivateKey privateKey = pair.getPrivate();
                if (!Arrays.equals(this.verifyToken, encryptionResponsePacket.getVerifyToken(privateKey))) {
                    throw new IllegalStateException("Invalid nonce!");
                }
                SecretKey secretKey = encryptionResponsePacket.getSecretKey(privateKey);
                minecraftProtocol.enableEncryption(secretKey);
                new UserAuthThread(packetReceivedEvent.getSession(), secretKey).start();
            }
        }
        if (minecraftProtocol.getMode() == ProtocolMode.STATUS) {
            if (packetReceivedEvent.getPacket() instanceof StatusQueryPacket) {
                ServerInfoBuilder serverInfoBuilder = (ServerInfoBuilder) packetReceivedEvent.getSession().getFlag("info-builder");
                if (serverInfoBuilder == null) {
                    packetReceivedEvent.getSession().disconnect("No server info builder set.");
                }
                packetReceivedEvent.getSession().send(new StatusResponsePacket(serverInfoBuilder.buildInfo(packetReceivedEvent.getSession())));
            } else if (packetReceivedEvent.getPacket() instanceof StatusPingPacket) {
                packetReceivedEvent.getSession().send(new StatusPongPacket(((StatusPingPacket) packetReceivedEvent.getPacket()).getPingTime()));
            }
        }
        if (minecraftProtocol.getMode() == ProtocolMode.GAME && (packetReceivedEvent.getPacket() instanceof ClientKeepAlivePacket) && ((ClientKeepAlivePacket) packetReceivedEvent.getPacket()).getPingId() == this.lastPingId) {
            packetReceivedEvent.getSession().setFlag("ping", Long.valueOf((System.nanoTime() / 1000000) - this.lastPingTime));
        }
    }

    @Override // com.github.steveice10.packetlib.event.session.SessionAdapter, com.github.steveice10.packetlib.event.session.SessionListener
    public void disconnecting(DisconnectingEvent disconnectingEvent) {
        MinecraftProtocol minecraftProtocol = (MinecraftProtocol) disconnectingEvent.getSession().getPacketProtocol();
        if (minecraftProtocol.getMode() == ProtocolMode.LOGIN) {
            disconnectingEvent.getSession().send(new LoginDisconnectPacket(disconnectingEvent.getReason()));
        } else if (minecraftProtocol.getMode() == ProtocolMode.GAME) {
            disconnectingEvent.getSession().send(new ServerDisconnectPacket(disconnectingEvent.getReason()));
        }
    }

    private class UserAuthThread extends Thread {
        private SecretKey key;
        private Session session;

        public UserAuthThread(Session session, SecretKey secretKey) {
            this.key = secretKey;
            this.session = session;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            MinecraftProtocol minecraftProtocol = (MinecraftProtocol) this.session.getPacketProtocol();
            try {
                GameProfile profileByServer = new SessionService().getProfileByServer(ServerListener.this.username, new BigInteger(CryptUtil.getServerIdHash(ServerListener.this.serverId, ServerListener.pair.getPublic(), this.key)).toString(16));
                if (profileByServer != null) {
                    this.session.send(new LoginSuccessPacket(profileByServer));
                    this.session.setFlag("profile", profileByServer);
                    minecraftProtocol.setMode(ProtocolMode.GAME, false, this.session);
                    ServerLoginHandler serverLoginHandler = (ServerLoginHandler) this.session.getFlag("login-handler");
                    if (serverLoginHandler != null) {
                        serverLoginHandler.loggedIn(this.session);
                    }
                    ServerListener.this.new KeepAliveThread(this.session).start();
                    return;
                }
                this.session.disconnect("Failed to verify username!");
            } catch (RequestException unused) {
                this.session.disconnect("Authentication servers are down. Please try again later, sorry!");
            }
        }
    }

    private class KeepAliveThread extends Thread {
        private Session session;

        public KeepAliveThread(Session session) {
            this.session = session;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws InterruptedException {
            ServerListener.this.lastPingTime = System.nanoTime() / 1000000;
            while (this.session.isConnected()) {
                long jNanoTime = System.nanoTime() / 1000000;
                if (jNanoTime - ServerListener.this.lastPingTime > 2000) {
                    ServerListener.this.lastPingTime = jNanoTime;
                    ServerListener.this.lastPingId = (int) jNanoTime;
                    this.session.send(new ServerKeepAlivePacket(ServerListener.this.lastPingId));
                }
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
