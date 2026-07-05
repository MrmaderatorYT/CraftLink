package com.github.steveice10.mc.v1_13.protocol;

import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.common.SkipPacket;
import com.github.steveice10.mc.v1_10.protocol.data.SubProtocol;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.ClientChatPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.ClientRequestPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.player.ClientPlayerMovementPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.player.ClientPlayerPositionPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.player.ClientPlayerPositionRotationPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.player.ClientPlayerRotationPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.ServerChatPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.ServerDisconnectPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.ServerJoinGamePacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.ServerPlayerListDataPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.ServerPlayerListEntryPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.ServerRespawnPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.player.ServerPlayerPositionRotationPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.world.ServerNotifyClientPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.status.client.StatusPingPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.status.client.StatusQueryPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.status.server.StatusPongPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.status.server.StatusResponsePacket;
import com.github.steveice10.mc.v1_12_2.protocol.packet.ingame.client.ClientKeepAlivePacket;
import com.github.steveice10.mc.v1_12_2.protocol.packet.ingame.server.ServerKeepAlivePacket;
import com.github.steveice10.mc.v1_13.protocol.packet.ingame.client.ClientTabCompletePacket;
import com.github.steveice10.mc.v1_13.protocol.packet.ingame.server.ServerTabCompletePacket;
import com.github.steveice10.packetlib.Client;
import com.github.steveice10.packetlib.Session;
import java.net.Proxy;

/* loaded from: classes.dex */
public class MinecraftProtocol extends com.github.steveice10.mc.v1_12_2.protocol.MinecraftProtocol {
    @Override // com.github.steveice10.mc.v1_12_2.protocol.MinecraftProtocol, com.github.steveice10.mc.v1_12_1.protocol.MinecraftProtocol, com.github.steveice10.mc.v1_10.protocol.MinecraftProtocol
    public void initServerGame(Session session) {
    }

    @Override // com.github.steveice10.mc.v1_12_1.protocol.MinecraftProtocol, com.github.steveice10.mc.v1_10.protocol.MinecraftProtocol
    public void initServerStatus(Session session) {
    }

    public MinecraftProtocol(SubProtocol subProtocol) {
        super(subProtocol);
    }

    public MinecraftProtocol(String str) {
        super(str);
    }

    public MinecraftProtocol(String str, String str2) {
        super(str, str2);
    }

    public MinecraftProtocol(String str, String str2, boolean z) {
        super(str, str2, z);
    }

    public MinecraftProtocol(String str, String str2, boolean z, Proxy proxy) {
        super(str, str2, z, proxy);
    }

    public MinecraftProtocol(GameProfile gameProfile, String str) {
        super(gameProfile, str);
    }

    @Override // com.github.steveice10.mc.v1_12_2.protocol.MinecraftProtocol, com.github.steveice10.mc.v1_12_1.protocol.MinecraftProtocol, com.github.steveice10.mc.v1_11_2.protocol.MinecraftProtocol, com.github.steveice10.mc.v1_11.protocol.MinecraftProtocol, com.github.steveice10.mc.v1_10.protocol.MinecraftProtocol, com.github.steveice10.packetlib.packet.PacketProtocol
    public void newClientSession(Client client, Session session) {
        if (this.profile != null) {
            session.setFlag("profile", this.profile);
            session.setFlag("access-token", this.accessToken);
        }
        setSubProtocol(this.subProtocol, true, session);
        session.addListener(new ClientListener());
    }

    @Override // com.github.steveice10.mc.v1_12_2.protocol.MinecraftProtocol, com.github.steveice10.mc.v1_12_1.protocol.MinecraftProtocol, com.github.steveice10.mc.v1_11.protocol.MinecraftProtocol, com.github.steveice10.mc.v1_10.protocol.MinecraftProtocol
    public void initClientGame(Session session) {
        registerIncoming(0, SkipPacket.class);
        registerIncoming(1, SkipPacket.class);
        registerIncoming(2, SkipPacket.class);
        registerIncoming(3, SkipPacket.class);
        registerIncoming(4, SkipPacket.class);
        registerIncoming(5, SkipPacket.class);
        registerIncoming(6, SkipPacket.class);
        registerIncoming(7, SkipPacket.class);
        registerIncoming(8, SkipPacket.class);
        registerIncoming(9, SkipPacket.class);
        registerIncoming(10, SkipPacket.class);
        registerIncoming(11, SkipPacket.class);
        registerIncoming(12, SkipPacket.class);
        registerIncoming(13, SkipPacket.class);
        registerIncoming(14, ServerChatPacket.class);
        registerIncoming(15, SkipPacket.class);
        registerIncoming(16, ServerTabCompletePacket.class);
        registerIncoming(17, SkipPacket.class);
        registerIncoming(18, SkipPacket.class);
        registerIncoming(19, SkipPacket.class);
        registerIncoming(20, SkipPacket.class);
        registerIncoming(21, SkipPacket.class);
        registerIncoming(22, SkipPacket.class);
        registerIncoming(23, SkipPacket.class);
        registerIncoming(24, SkipPacket.class);
        registerIncoming(25, SkipPacket.class);
        registerIncoming(26, SkipPacket.class);
        registerIncoming(27, ServerDisconnectPacket.class);
        registerIncoming(28, SkipPacket.class);
        registerIncoming(29, SkipPacket.class);
        registerIncoming(30, SkipPacket.class);
        registerIncoming(31, SkipPacket.class);
        registerIncoming(32, ServerNotifyClientPacket.class);
        registerIncoming(33, ServerKeepAlivePacket.class);
        registerIncoming(34, SkipPacket.class);
        registerIncoming(35, SkipPacket.class);
        registerIncoming(36, SkipPacket.class);
        registerIncoming(37, ServerJoinGamePacket.class);
        registerIncoming(38, SkipPacket.class);
        registerIncoming(39, SkipPacket.class);
        registerIncoming(40, SkipPacket.class);
        registerIncoming(41, SkipPacket.class);
        registerIncoming(42, SkipPacket.class);
        registerIncoming(43, SkipPacket.class);
        registerIncoming(44, SkipPacket.class);
        registerIncoming(45, SkipPacket.class);
        registerIncoming(46, SkipPacket.class);
        registerIncoming(47, SkipPacket.class);
        registerIncoming(48, ServerPlayerListEntryPacket.class);
        registerIncoming(49, SkipPacket.class);
        registerIncoming(50, ServerPlayerPositionRotationPacket.class);
        registerIncoming(51, SkipPacket.class);
        registerIncoming(52, SkipPacket.class);
        registerIncoming(53, SkipPacket.class);
        registerIncoming(54, SkipPacket.class);
        registerIncoming(55, SkipPacket.class);
        registerIncoming(56, ServerRespawnPacket.class);
        registerIncoming(57, SkipPacket.class);
        registerIncoming(59, SkipPacket.class);
        registerIncoming(60, SkipPacket.class);
        registerIncoming(61, SkipPacket.class);
        registerIncoming(62, SkipPacket.class);
        registerIncoming(63, SkipPacket.class);
        registerIncoming(64, SkipPacket.class);
        registerIncoming(65, SkipPacket.class);
        registerIncoming(66, SkipPacket.class);
        registerIncoming(67, SkipPacket.class);
        registerIncoming(68, SkipPacket.class);
        registerIncoming(69, SkipPacket.class);
        registerIncoming(70, SkipPacket.class);
        registerIncoming(71, SkipPacket.class);
        registerIncoming(72, SkipPacket.class);
        registerIncoming(73, SkipPacket.class);
        registerIncoming(74, SkipPacket.class);
        registerIncoming(75, SkipPacket.class);
        registerIncoming(76, SkipPacket.class);
        registerIncoming(77, SkipPacket.class);
        registerIncoming(78, ServerPlayerListDataPacket.class);
        registerIncoming(79, SkipPacket.class);
        registerIncoming(80, SkipPacket.class);
        registerIncoming(81, SkipPacket.class);
        registerIncoming(82, SkipPacket.class);
        registerIncoming(83, SkipPacket.class);
        registerIncoming(84, SkipPacket.class);
        registerIncoming(85, SkipPacket.class);
        registerOutgoing(2, ClientChatPacket.class);
        registerOutgoing(3, ClientRequestPacket.class);
        registerOutgoing(5, ClientTabCompletePacket.class);
        registerOutgoing(14, ClientKeepAlivePacket.class);
        registerOutgoing(15, ClientPlayerMovementPacket.class);
        registerOutgoing(16, ClientPlayerPositionPacket.class);
        registerOutgoing(17, ClientPlayerPositionRotationPacket.class);
        registerOutgoing(18, ClientPlayerRotationPacket.class);
    }

    @Override // com.github.steveice10.mc.v1_12_1.protocol.MinecraftProtocol, com.github.steveice10.mc.v1_10.protocol.MinecraftProtocol
    public void initClientStatus(Session session) {
        registerIncoming(0, StatusResponsePacket.class);
        registerIncoming(1, StatusPongPacket.class);
        registerOutgoing(0, StatusQueryPacket.class);
        registerOutgoing(1, StatusPingPacket.class);
    }
}
