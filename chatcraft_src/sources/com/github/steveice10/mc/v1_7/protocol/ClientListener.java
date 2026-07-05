package com.github.steveice10.mc.v1_7.protocol;

import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.auth.exception.request.InvalidCredentialsException;
import com.github.steveice10.mc.auth.exception.request.RequestException;
import com.github.steveice10.mc.auth.exception.request.ServiceUnavailableException;
import com.github.steveice10.mc.auth.service.SessionService;
import com.github.steveice10.mc.v1_7.protocol.data.status.ServerStatusInfo;
import com.github.steveice10.mc.v1_7.protocol.data.status.handler.ServerInfoHandler;
import com.github.steveice10.mc.v1_7.protocol.data.status.handler.ServerPingTimeHandler;
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
import com.github.steveice10.packetlib.event.session.ConnectedEvent;
import com.github.steveice10.packetlib.event.session.PacketReceivedEvent;
import com.github.steveice10.packetlib.event.session.PacketSentEvent;
import com.github.steveice10.packetlib.event.session.SessionAdapter;
import java.math.BigInteger;
import javax.crypto.SecretKey;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public class ClientListener extends SessionAdapter {
    private SecretKey key;

    @Override // com.github.steveice10.packetlib.event.session.SessionAdapter, com.github.steveice10.packetlib.event.session.SessionListener
    public void packetReceived(PacketReceivedEvent packetReceivedEvent) {
        MinecraftProtocol minecraftProtocol = (MinecraftProtocol) packetReceivedEvent.getSession().getPacketProtocol();
        if (minecraftProtocol.getMode() == ProtocolMode.LOGIN) {
            if (packetReceivedEvent.getPacket() instanceof EncryptionRequestPacket) {
                EncryptionRequestPacket encryptionRequestPacket = (EncryptionRequestPacket) packetReceivedEvent.getPacket();
                this.key = CryptUtil.generateSharedKey();
                try {
                    new SessionService().joinServer((GameProfile) packetReceivedEvent.getSession().getFlag("profile"), (String) packetReceivedEvent.getSession().getFlag("access-token"), new BigInteger(CryptUtil.getServerIdHash(encryptionRequestPacket.getServerId(), encryptionRequestPacket.getPublicKey(), this.key)).toString(16));
                    packetReceivedEvent.getSession().send(new EncryptionResponsePacket(this.key, encryptionRequestPacket.getPublicKey(), encryptionRequestPacket.getVerifyToken()));
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
            } else if (packetReceivedEvent.getPacket() instanceof LoginSuccessPacket) {
                packetReceivedEvent.getSession().setFlag("profile", ((LoginSuccessPacket) packetReceivedEvent.getPacket()).getProfile());
                minecraftProtocol.setMode(ProtocolMode.GAME, true, packetReceivedEvent.getSession());
            } else if (packetReceivedEvent.getPacket() instanceof LoginDisconnectPacket) {
                packetReceivedEvent.getSession().disconnect(((LoginDisconnectPacket) packetReceivedEvent.getPacket()).getReason().getFullText());
            }
        }
        if (minecraftProtocol.getMode() == ProtocolMode.STATUS) {
            if (packetReceivedEvent.getPacket() instanceof StatusResponsePacket) {
                ServerStatusInfo info = ((StatusResponsePacket) packetReceivedEvent.getPacket()).getInfo();
                ServerInfoHandler serverInfoHandler = (ServerInfoHandler) packetReceivedEvent.getSession().getFlag("server-info-handler");
                if (serverInfoHandler != null) {
                    serverInfoHandler.handle(packetReceivedEvent.getSession(), info);
                }
                packetReceivedEvent.getSession().send(new StatusPingPacket(System.nanoTime() / 1000000));
            } else if (packetReceivedEvent.getPacket() instanceof StatusPongPacket) {
                long jNanoTime = (System.nanoTime() / 1000000) - ((StatusPongPacket) packetReceivedEvent.getPacket()).getPingTime();
                ServerPingTimeHandler serverPingTimeHandler = (ServerPingTimeHandler) packetReceivedEvent.getSession().getFlag("server-ping-time-handler");
                if (serverPingTimeHandler != null) {
                    serverPingTimeHandler.handle(packetReceivedEvent.getSession(), jNanoTime);
                }
                packetReceivedEvent.getSession().disconnect("Finished");
            }
        }
        if (minecraftProtocol.getMode() == ProtocolMode.GAME) {
            if (packetReceivedEvent.getPacket() instanceof ServerKeepAlivePacket) {
                packetReceivedEvent.getSession().send(new ClientKeepAlivePacket(((ServerKeepAlivePacket) packetReceivedEvent.getPacket()).getPingId()));
            } else if (packetReceivedEvent.getPacket() instanceof ServerDisconnectPacket) {
                packetReceivedEvent.getSession().disconnect(((ServerDisconnectPacket) packetReceivedEvent.getPacket()).getReason().getFullText());
            }
        }
    }

    @Override // com.github.steveice10.packetlib.event.session.SessionAdapter, com.github.steveice10.packetlib.event.session.SessionListener
    public void packetSent(PacketSentEvent packetSentEvent) {
        MinecraftProtocol minecraftProtocol = (MinecraftProtocol) packetSentEvent.getSession().getPacketProtocol();
        if (minecraftProtocol.getMode() == ProtocolMode.LOGIN && (packetSentEvent.getPacket() instanceof EncryptionResponsePacket)) {
            minecraftProtocol.enableEncryption(this.key);
        }
    }

    @Override // com.github.steveice10.packetlib.event.session.SessionAdapter, com.github.steveice10.packetlib.event.session.SessionListener
    public void connected(ConnectedEvent connectedEvent) {
        MinecraftProtocol minecraftProtocol = (MinecraftProtocol) connectedEvent.getSession().getPacketProtocol();
        if (minecraftProtocol.getMode() == ProtocolMode.LOGIN) {
            GameProfile gameProfile = (GameProfile) connectedEvent.getSession().getFlag("profile");
            minecraftProtocol.setMode(ProtocolMode.HANDSHAKE, true, connectedEvent.getSession());
            connectedEvent.getSession().send(new HandshakePacket(4, connectedEvent.getSession().getHost(), connectedEvent.getSession().getPort(), 2));
            minecraftProtocol.setMode(ProtocolMode.LOGIN, true, connectedEvent.getSession());
            connectedEvent.getSession().send(new LoginStartPacket(gameProfile != null ? gameProfile.getName() : BuildConfig.FLAVOR));
            return;
        }
        if (minecraftProtocol.getMode() == ProtocolMode.STATUS) {
            minecraftProtocol.setMode(ProtocolMode.HANDSHAKE, true, connectedEvent.getSession());
            connectedEvent.getSession().send(new HandshakePacket(4, connectedEvent.getSession().getHost(), connectedEvent.getSession().getPort(), 1));
            minecraftProtocol.setMode(ProtocolMode.STATUS, true, connectedEvent.getSession());
            connectedEvent.getSession().send(new StatusQueryPacket());
        }
    }
}
