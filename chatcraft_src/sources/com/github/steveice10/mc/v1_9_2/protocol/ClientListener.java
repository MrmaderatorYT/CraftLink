package com.github.steveice10.mc.v1_9_2.protocol;

import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.auth.exception.request.InvalidCredentialsException;
import com.github.steveice10.mc.auth.exception.request.RequestException;
import com.github.steveice10.mc.auth.exception.request.ServiceUnavailableException;
import com.github.steveice10.mc.auth.service.SessionService;
import com.github.steveice10.mc.v1_9_2.protocol.data.SubProtocol;
import com.github.steveice10.mc.v1_9_2.protocol.data.handshake.HandshakeIntent;
import com.github.steveice10.mc.v1_9_2.protocol.data.status.ServerStatusInfo;
import com.github.steveice10.mc.v1_9_2.protocol.data.status.handler.ServerInfoHandler;
import com.github.steveice10.mc.v1_9_2.protocol.data.status.handler.ServerPingTimeHandler;
import com.github.steveice10.mc.v1_9_2.protocol.packet.handshake.client.HandshakePacket;
import com.github.steveice10.mc.v1_9_2.protocol.packet.ingame.client.ClientKeepAlivePacket;
import com.github.steveice10.mc.v1_9_2.protocol.packet.ingame.server.ServerDisconnectPacket;
import com.github.steveice10.mc.v1_9_2.protocol.packet.ingame.server.ServerKeepAlivePacket;
import com.github.steveice10.mc.v1_9_2.protocol.packet.ingame.server.ServerSetCompressionPacket;
import com.github.steveice10.mc.v1_9_2.protocol.packet.login.client.EncryptionResponsePacket;
import com.github.steveice10.mc.v1_9_2.protocol.packet.login.client.LoginStartPacket;
import com.github.steveice10.mc.v1_9_2.protocol.packet.login.server.EncryptionRequestPacket;
import com.github.steveice10.mc.v1_9_2.protocol.packet.login.server.LoginDisconnectPacket;
import com.github.steveice10.mc.v1_9_2.protocol.packet.login.server.LoginSetCompressionPacket;
import com.github.steveice10.mc.v1_9_2.protocol.packet.login.server.LoginSuccessPacket;
import com.github.steveice10.mc.v1_9_2.protocol.packet.status.client.StatusPingPacket;
import com.github.steveice10.mc.v1_9_2.protocol.packet.status.client.StatusQueryPacket;
import com.github.steveice10.mc.v1_9_2.protocol.packet.status.server.StatusPongPacket;
import com.github.steveice10.mc.v1_9_2.protocol.packet.status.server.StatusResponsePacket;
import com.github.steveice10.mc.v1_9_2.protocol.util.CryptUtil;
import com.github.steveice10.packetlib.event.session.ConnectedEvent;
import com.github.steveice10.packetlib.event.session.PacketReceivedEvent;
import com.github.steveice10.packetlib.event.session.SessionAdapter;
import java.math.BigInteger;
import java.net.Proxy;
import java.security.NoSuchAlgorithmException;
import javax.crypto.SecretKey;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public class ClientListener extends SessionAdapter {
    @Override // com.github.steveice10.packetlib.event.session.SessionAdapter, com.github.steveice10.packetlib.event.session.SessionListener
    public void packetReceived(PacketReceivedEvent packetReceivedEvent) throws NoSuchAlgorithmException {
        MinecraftProtocol minecraftProtocol = (MinecraftProtocol) packetReceivedEvent.getSession().getPacketProtocol();
        if (minecraftProtocol.getSubProtocol() == SubProtocol.LOGIN) {
            if (packetReceivedEvent.getPacket() instanceof EncryptionRequestPacket) {
                EncryptionRequestPacket encryptionRequestPacket = (EncryptionRequestPacket) packetReceivedEvent.getPacket();
                SecretKey secretKeyGenerateSharedKey = CryptUtil.generateSharedKey();
                Proxy proxy = (Proxy) packetReceivedEvent.getSession().getFlag("auth-proxy");
                if (proxy == null) {
                    proxy = Proxy.NO_PROXY;
                }
                try {
                    new SessionService(proxy).joinServer((GameProfile) packetReceivedEvent.getSession().getFlag("profile"), (String) packetReceivedEvent.getSession().getFlag("access-token"), new BigInteger(CryptUtil.getServerIdHash(encryptionRequestPacket.getServerId(), encryptionRequestPacket.getPublicKey(), secretKeyGenerateSharedKey)).toString(16));
                    packetReceivedEvent.getSession().send(new EncryptionResponsePacket(secretKeyGenerateSharedKey, encryptionRequestPacket.getPublicKey(), encryptionRequestPacket.getVerifyToken()));
                    minecraftProtocol.enableEncryption(secretKeyGenerateSharedKey);
                    return;
                } catch (InvalidCredentialsException e) {
                    packetReceivedEvent.getSession().disconnect("Login failed: Invalid login session.", e);
                    return;
                } catch (ServiceUnavailableException e2) {
                    packetReceivedEvent.getSession().disconnect("Login failed: Authentication service unavailable.", e2);
                    return;
                } catch (RequestException e3) {
                    packetReceivedEvent.getSession().disconnect("Login failed: Authentication error: " + e3.getMessage(), e3);
                    return;
                }
            }
            if (packetReceivedEvent.getPacket() instanceof LoginSuccessPacket) {
                packetReceivedEvent.getSession().setFlag("profile", ((LoginSuccessPacket) packetReceivedEvent.getPacket()).getProfile());
                minecraftProtocol.setSubProtocol(SubProtocol.GAME, true, packetReceivedEvent.getSession());
                return;
            } else if (packetReceivedEvent.getPacket() instanceof LoginDisconnectPacket) {
                packetReceivedEvent.getSession().disconnect(((LoginDisconnectPacket) packetReceivedEvent.getPacket()).getReason().getFullText());
                return;
            } else {
                if (packetReceivedEvent.getPacket() instanceof LoginSetCompressionPacket) {
                    packetReceivedEvent.getSession().setCompressionThreshold(((LoginSetCompressionPacket) packetReceivedEvent.getPacket()).getThreshold());
                    return;
                }
                return;
            }
        }
        if (minecraftProtocol.getSubProtocol() == SubProtocol.STATUS) {
            if (packetReceivedEvent.getPacket() instanceof StatusResponsePacket) {
                ServerStatusInfo info = ((StatusResponsePacket) packetReceivedEvent.getPacket()).getInfo();
                ServerInfoHandler serverInfoHandler = (ServerInfoHandler) packetReceivedEvent.getSession().getFlag("server-info-handler");
                if (serverInfoHandler != null) {
                    serverInfoHandler.handle(packetReceivedEvent.getSession(), info);
                }
                packetReceivedEvent.getSession().send(new StatusPingPacket(System.currentTimeMillis()));
                return;
            }
            if (packetReceivedEvent.getPacket() instanceof StatusPongPacket) {
                long jCurrentTimeMillis = System.currentTimeMillis() - ((StatusPongPacket) packetReceivedEvent.getPacket()).getPingTime();
                ServerPingTimeHandler serverPingTimeHandler = (ServerPingTimeHandler) packetReceivedEvent.getSession().getFlag("server-ping-time-handler");
                if (serverPingTimeHandler != null) {
                    serverPingTimeHandler.handle(packetReceivedEvent.getSession(), jCurrentTimeMillis);
                }
                packetReceivedEvent.getSession().disconnect("Finished");
                return;
            }
            return;
        }
        if (minecraftProtocol.getSubProtocol() == SubProtocol.GAME) {
            if (packetReceivedEvent.getPacket() instanceof ServerKeepAlivePacket) {
                packetReceivedEvent.getSession().send(new ClientKeepAlivePacket(((ServerKeepAlivePacket) packetReceivedEvent.getPacket()).getPingId()));
            } else if (packetReceivedEvent.getPacket() instanceof ServerDisconnectPacket) {
                packetReceivedEvent.getSession().disconnect(((ServerDisconnectPacket) packetReceivedEvent.getPacket()).getReason().getFullText());
            } else if (packetReceivedEvent.getPacket() instanceof ServerSetCompressionPacket) {
                packetReceivedEvent.getSession().setCompressionThreshold(((ServerSetCompressionPacket) packetReceivedEvent.getPacket()).getThreshold());
            }
        }
    }

    @Override // com.github.steveice10.packetlib.event.session.SessionAdapter, com.github.steveice10.packetlib.event.session.SessionListener
    public void connected(ConnectedEvent connectedEvent) {
        MinecraftProtocol minecraftProtocol = (MinecraftProtocol) connectedEvent.getSession().getPacketProtocol();
        if (minecraftProtocol.getSubProtocol() == SubProtocol.LOGIN) {
            GameProfile gameProfile = (GameProfile) connectedEvent.getSession().getFlag("profile");
            minecraftProtocol.setSubProtocol(SubProtocol.HANDSHAKE, true, connectedEvent.getSession());
            connectedEvent.getSession().send(new HandshakePacket(109, connectedEvent.getSession().getHost(), connectedEvent.getSession().getPort(), HandshakeIntent.LOGIN));
            minecraftProtocol.setSubProtocol(SubProtocol.LOGIN, true, connectedEvent.getSession());
            connectedEvent.getSession().send(new LoginStartPacket(gameProfile != null ? gameProfile.getName() : BuildConfig.FLAVOR));
            return;
        }
        if (minecraftProtocol.getSubProtocol() == SubProtocol.STATUS) {
            minecraftProtocol.setSubProtocol(SubProtocol.HANDSHAKE, true, connectedEvent.getSession());
            connectedEvent.getSession().send(new HandshakePacket(109, connectedEvent.getSession().getHost(), connectedEvent.getSession().getPort(), HandshakeIntent.STATUS));
            minecraftProtocol.setSubProtocol(SubProtocol.STATUS, true, connectedEvent.getSession());
            connectedEvent.getSession().send(new StatusQueryPacket());
        }
    }
}
