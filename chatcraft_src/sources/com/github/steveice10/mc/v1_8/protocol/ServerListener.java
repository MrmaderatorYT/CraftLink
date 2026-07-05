package com.github.steveice10.mc.v1_8.protocol;

import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.auth.exception.request.RequestException;
import com.github.steveice10.mc.auth.service.SessionService;
import com.github.steveice10.mc.v1_8.protocol.data.SubProtocol;
import com.github.steveice10.mc.v1_8.protocol.data.status.handler.ServerInfoBuilder;
import com.github.steveice10.mc.v1_8.protocol.packet.client.HandshakePacket;
import com.github.steveice10.mc.v1_8.protocol.packet.ingame.client.ClientKeepAlivePacket;
import com.github.steveice10.mc.v1_8.protocol.packet.ingame.server.ServerDisconnectPacket;
import com.github.steveice10.mc.v1_8.protocol.packet.ingame.server.ServerKeepAlivePacket;
import com.github.steveice10.mc.v1_8.protocol.packet.login.client.EncryptionResponsePacket;
import com.github.steveice10.mc.v1_8.protocol.packet.login.client.LoginStartPacket;
import com.github.steveice10.mc.v1_8.protocol.packet.login.server.EncryptionRequestPacket;
import com.github.steveice10.mc.v1_8.protocol.packet.login.server.LoginDisconnectPacket;
import com.github.steveice10.mc.v1_8.protocol.packet.login.server.LoginSetCompressionPacket;
import com.github.steveice10.mc.v1_8.protocol.packet.login.server.LoginSuccessPacket;
import com.github.steveice10.mc.v1_8.protocol.packet.status.client.StatusPingPacket;
import com.github.steveice10.mc.v1_8.protocol.packet.status.client.StatusQueryPacket;
import com.github.steveice10.mc.v1_8.protocol.packet.status.server.StatusPongPacket;
import com.github.steveice10.mc.v1_8.protocol.packet.status.server.StatusResponsePacket;
import com.github.steveice10.mc.v1_8.protocol.util.CryptUtil;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.event.session.ConnectedEvent;
import com.github.steveice10.packetlib.event.session.DisconnectingEvent;
import com.github.steveice10.packetlib.event.session.PacketReceivedEvent;
import com.github.steveice10.packetlib.event.session.SessionAdapter;
import java.math.BigInteger;
import java.net.Proxy;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;
import javax.crypto.SecretKey;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public class ServerListener extends SessionAdapter {
    private static final KeyPair KEY_PAIR = CryptUtil.generateKeyPair();
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
        if (minecraftProtocol.getSubProtocol() == SubProtocol.HANDSHAKE && (packetReceivedEvent.getPacket() instanceof HandshakePacket)) {
            HandshakePacket handshakePacket = (HandshakePacket) packetReceivedEvent.getPacket();
            switch (handshakePacket.getIntent()) {
                case STATUS:
                    minecraftProtocol.setSubProtocol(SubProtocol.STATUS, false, packetReceivedEvent.getSession());
                    break;
                case LOGIN:
                    minecraftProtocol.setSubProtocol(SubProtocol.LOGIN, false, packetReceivedEvent.getSession());
                    if (handshakePacket.getProtocolVersion() > 47) {
                        packetReceivedEvent.getSession().disconnect("Outdated server! I'm still on 1.8.8.");
                        break;
                    } else if (handshakePacket.getProtocolVersion() < 47) {
                        packetReceivedEvent.getSession().disconnect("Outdated client! Please use 1.8.8.");
                        break;
                    }
                    break;
                default:
                    throw new UnsupportedOperationException("Invalid client intent: " + handshakePacket.getIntent());
            }
        }
        if (minecraftProtocol.getSubProtocol() == SubProtocol.LOGIN) {
            if (packetReceivedEvent.getPacket() instanceof LoginStartPacket) {
                this.username = ((LoginStartPacket) packetReceivedEvent.getPacket()).getUsername();
                if (packetReceivedEvent.getSession().hasFlag("verify-users") ? ((Boolean) packetReceivedEvent.getSession().getFlag("verify-users")).booleanValue() : true) {
                    packetReceivedEvent.getSession().send(new EncryptionRequestPacket(this.serverId, KEY_PAIR.getPublic(), this.verifyToken));
                } else {
                    new Thread(new UserAuthTask(packetReceivedEvent.getSession(), null)).start();
                }
            } else if (packetReceivedEvent.getPacket() instanceof EncryptionResponsePacket) {
                EncryptionResponsePacket encryptionResponsePacket = (EncryptionResponsePacket) packetReceivedEvent.getPacket();
                PrivateKey privateKey = KEY_PAIR.getPrivate();
                if (!Arrays.equals(this.verifyToken, encryptionResponsePacket.getVerifyToken(privateKey))) {
                    packetReceivedEvent.getSession().disconnect("Invalid nonce!");
                    return;
                } else {
                    SecretKey secretKey = encryptionResponsePacket.getSecretKey(privateKey);
                    minecraftProtocol.enableEncryption(secretKey);
                    new Thread(new UserAuthTask(packetReceivedEvent.getSession(), secretKey)).start();
                }
            }
        }
        if (minecraftProtocol.getSubProtocol() == SubProtocol.STATUS) {
            if (packetReceivedEvent.getPacket() instanceof StatusQueryPacket) {
                ServerInfoBuilder serverInfoBuilder = (ServerInfoBuilder) packetReceivedEvent.getSession().getFlag("info-builder");
                if (serverInfoBuilder == null) {
                    packetReceivedEvent.getSession().disconnect("No server info builder set.");
                    return;
                }
                packetReceivedEvent.getSession().send(new StatusResponsePacket(serverInfoBuilder.buildInfo(packetReceivedEvent.getSession())));
            } else if (packetReceivedEvent.getPacket() instanceof StatusPingPacket) {
                packetReceivedEvent.getSession().send(new StatusPongPacket(((StatusPingPacket) packetReceivedEvent.getPacket()).getPingTime()));
            }
        }
        if (minecraftProtocol.getSubProtocol() == SubProtocol.GAME && (packetReceivedEvent.getPacket() instanceof ClientKeepAlivePacket) && ((ClientKeepAlivePacket) packetReceivedEvent.getPacket()).getPingId() == this.lastPingId) {
            packetReceivedEvent.getSession().setFlag("ping", Long.valueOf(System.currentTimeMillis() - this.lastPingTime));
        }
    }

    @Override // com.github.steveice10.packetlib.event.session.SessionAdapter, com.github.steveice10.packetlib.event.session.SessionListener
    public void disconnecting(DisconnectingEvent disconnectingEvent) {
        MinecraftProtocol minecraftProtocol = (MinecraftProtocol) disconnectingEvent.getSession().getPacketProtocol();
        if (minecraftProtocol.getSubProtocol() == SubProtocol.LOGIN) {
            disconnectingEvent.getSession().send(new LoginDisconnectPacket(disconnectingEvent.getReason()));
        } else if (minecraftProtocol.getSubProtocol() == SubProtocol.GAME) {
            disconnectingEvent.getSession().send(new ServerDisconnectPacket(disconnectingEvent.getReason()));
        }
    }

    private class UserAuthTask implements Runnable {
        private SecretKey key;
        private Session session;

        public UserAuthTask(Session session, SecretKey secretKey) {
            this.key = secretKey;
            this.session = session;
        }

        @Override // java.lang.Runnable
        public void run() {
            GameProfile gameProfile;
            if (!(this.session.hasFlag("verify-users") ? ((Boolean) this.session.getFlag("verify-users")).booleanValue() : true) || this.key == null) {
                gameProfile = new GameProfile(UUID.nameUUIDFromBytes(("OfflinePlayer:" + ServerListener.this.username).getBytes()), ServerListener.this.username);
            } else {
                Proxy proxy = (Proxy) this.session.getFlag("auth-proxy");
                if (proxy == null) {
                    proxy = Proxy.NO_PROXY;
                }
                try {
                    gameProfile = new SessionService(proxy).getProfileByServer(ServerListener.this.username, new BigInteger(CryptUtil.getServerIdHash(ServerListener.this.serverId, ServerListener.KEY_PAIR.getPublic(), this.key)).toString(16));
                    if (gameProfile == null) {
                        this.session.disconnect("Failed to verify username.");
                    }
                } catch (RequestException e) {
                    this.session.disconnect("Failed to make session service request.", e);
                    return;
                }
            }
            int iIntValue = ((Integer) this.session.getFlag("compression-threshold")).intValue();
            this.session.send(new LoginSetCompressionPacket(iIntValue));
            this.session.setCompressionThreshold(iIntValue);
            this.session.send(new LoginSuccessPacket(gameProfile));
            this.session.setFlag("profile", gameProfile);
            ((MinecraftProtocol) this.session.getPacketProtocol()).setSubProtocol(SubProtocol.GAME, false, this.session);
            ServerLoginHandler serverLoginHandler = (ServerLoginHandler) this.session.getFlag("login-handler");
            if (serverLoginHandler != null) {
                serverLoginHandler.loggedIn(this.session);
            }
            new Thread(ServerListener.this.new KeepAliveTask(this.session)).start();
        }
    }

    private class KeepAliveTask implements Runnable {
        private Session session;

        public KeepAliveTask(Session session) {
            this.session = session;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            while (this.session.isConnected()) {
                ServerListener.this.lastPingTime = System.currentTimeMillis();
                ServerListener.this.lastPingId = (int) ServerListener.this.lastPingTime;
                this.session.send(new ServerKeepAlivePacket(ServerListener.this.lastPingId));
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException unused) {
                    return;
                }
            }
        }
    }
}
