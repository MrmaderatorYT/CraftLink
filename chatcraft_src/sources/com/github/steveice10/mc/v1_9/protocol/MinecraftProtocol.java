package com.github.steveice10.mc.v1_9.protocol;

import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.auth.service.AuthenticationService;
import com.github.steveice10.mc.common.MinecraftPacketProtocol;
import com.github.steveice10.mc.common.SkipPacket;
import com.github.steveice10.mc.v1_9.protocol.data.SubProtocol;
import com.github.steveice10.mc.v1_9.protocol.packet.handshake.client.HandshakePacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.ClientChatPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.ClientKeepAlivePacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.ClientPluginMessagePacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.ClientRequestPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.ClientResourcePackStatusPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.ClientSettingsPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.ClientTabCompletePacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.player.ClientPlayerAbilitiesPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.player.ClientPlayerActionPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.player.ClientPlayerChangeHeldItemPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.player.ClientPlayerInteractEntityPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.player.ClientPlayerMovementPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.player.ClientPlayerPlaceBlockPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.player.ClientPlayerPositionPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.player.ClientPlayerPositionRotationPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.player.ClientPlayerRotationPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.player.ClientPlayerStatePacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.player.ClientPlayerSwingArmPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.player.ClientPlayerUseItemPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.window.ClientCloseWindowPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.window.ClientConfirmTransactionPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.window.ClientCreativeInventoryActionPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.window.ClientEnchantItemPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.window.ClientWindowActionPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.world.ClientSpectatePacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.world.ClientSteerBoatPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.world.ClientSteerVehiclePacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.world.ClientTeleportConfirmPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.world.ClientUpdateSignPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.world.ClientVehicleMovePacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.ServerBossBarPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.ServerChatPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.ServerCombatPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.ServerDifficultyPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.ServerDisconnectPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.ServerJoinGamePacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.ServerKeepAlivePacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.ServerPlayerListDataPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.ServerPlayerListEntryPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.ServerPluginMessagePacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.ServerResourcePackSendPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.ServerRespawnPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.ServerSetCooldownPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.ServerStatisticsPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.ServerSwitchCameraPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.ServerTabCompletePacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.ServerTitlePacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.ServerEntityAnimationPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.ServerEntityAttachPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.ServerEntityCollectItemPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.ServerEntityDestroyPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.ServerEntityEffectPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.ServerEntityEquipmentPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.ServerEntityHeadLookPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.ServerEntityMetadataPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.ServerEntityMovementPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.ServerEntityPositionPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.ServerEntityPositionRotationPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.ServerEntityPropertiesPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.ServerEntityRemoveEffectPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.ServerEntityRotationPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.ServerEntitySetPassengersPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.ServerEntityStatusPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.ServerEntityTeleportPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.ServerEntityVelocityPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.ServerVehicleMovePacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.player.ServerPlayerAbilitiesPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.player.ServerPlayerChangeHeldItemPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.player.ServerPlayerHealthPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.player.ServerPlayerPositionRotationPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.player.ServerPlayerSetExperiencePacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.player.ServerPlayerUseBedPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.spawn.ServerSpawnExpOrbPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.spawn.ServerSpawnGlobalEntityPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.spawn.ServerSpawnMobPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.spawn.ServerSpawnObjectPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.spawn.ServerSpawnPaintingPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.spawn.ServerSpawnPlayerPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.scoreboard.ServerDisplayScoreboardPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.scoreboard.ServerScoreboardObjectivePacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.scoreboard.ServerTeamPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.scoreboard.ServerUpdateScorePacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.window.ServerCloseWindowPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.window.ServerConfirmTransactionPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.window.ServerOpenWindowPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.window.ServerSetSlotPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.window.ServerWindowItemsPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.window.ServerWindowPropertyPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.world.ServerBlockBreakAnimPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.world.ServerBlockChangePacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.world.ServerBlockValuePacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.world.ServerChunkDataPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.world.ServerExplosionPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.world.ServerMapDataPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.world.ServerMultiBlockChangePacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.world.ServerNotifyClientPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.world.ServerOpenTileEntityEditorPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.world.ServerPlayBuiltinSoundPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.world.ServerPlayEffectPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.world.ServerPlaySoundPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.world.ServerSpawnParticlePacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.world.ServerSpawnPositionPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.world.ServerUnloadChunkPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.world.ServerUpdateSignPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.world.ServerUpdateTileEntityPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.world.ServerUpdateTimePacket;
import com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.world.ServerWorldBorderPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.login.client.EncryptionResponsePacket;
import com.github.steveice10.mc.v1_9.protocol.packet.login.client.LoginStartPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.login.server.EncryptionRequestPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.login.server.LoginDisconnectPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.login.server.LoginSetCompressionPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.login.server.LoginSuccessPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.status.client.StatusPingPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.status.client.StatusQueryPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.status.server.StatusPongPacket;
import com.github.steveice10.mc.v1_9.protocol.packet.status.server.StatusResponsePacket;
import com.github.steveice10.packetlib.Client;
import com.github.steveice10.packetlib.Server;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.crypt.AESEncryption;
import com.github.steveice10.packetlib.crypt.PacketEncryption;
import com.github.steveice10.packetlib.packet.DefaultPacketHeader;
import com.github.steveice10.packetlib.packet.PacketHeader;
import java.net.Proxy;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.UUID;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public class MinecraftProtocol extends MinecraftPacketProtocol {
    private String accessToken;
    private AESEncryption encrypt;
    private PacketHeader header;
    private GameProfile profile;
    private SubProtocol subProtocol;

    @Override // com.github.steveice10.packetlib.packet.PacketProtocol
    public String getSRVRecordPrefix() {
        return "_minecraft";
    }

    private MinecraftProtocol() {
        this.subProtocol = SubProtocol.HANDSHAKE;
        this.header = new DefaultPacketHeader();
        this.accessToken = BuildConfig.FLAVOR;
    }

    public MinecraftProtocol(SubProtocol subProtocol) {
        this.subProtocol = SubProtocol.HANDSHAKE;
        this.header = new DefaultPacketHeader();
        this.accessToken = BuildConfig.FLAVOR;
        if (subProtocol != SubProtocol.LOGIN && subProtocol != SubProtocol.STATUS) {
            throw new IllegalArgumentException("Only login and status modes are permitted.");
        }
        this.subProtocol = subProtocol;
        if (subProtocol == SubProtocol.LOGIN) {
            this.profile = new GameProfile((UUID) null, "Player");
        }
    }

    public MinecraftProtocol(String str) {
        this(SubProtocol.LOGIN);
        this.profile = new GameProfile((UUID) null, str);
    }

    public MinecraftProtocol(String str, String str2) {
        this(str, str2, false);
    }

    public MinecraftProtocol(String str, String str2, boolean z) {
        this(str, str2, z, Proxy.NO_PROXY);
    }

    public MinecraftProtocol(String str, String str2, boolean z, Proxy proxy) {
        this(SubProtocol.LOGIN);
        AuthenticationService authenticationService = new AuthenticationService(UUID.randomUUID().toString(), proxy);
        authenticationService.setUsername(str);
        if (z) {
            authenticationService.setAccessToken(str2);
        } else {
            authenticationService.setPassword(str2);
        }
        authenticationService.login();
        this.profile = authenticationService.getSelectedProfile();
        this.accessToken = authenticationService.getAccessToken();
    }

    public MinecraftProtocol(GameProfile gameProfile, String str) {
        this(SubProtocol.LOGIN);
        this.profile = gameProfile;
        this.accessToken = str;
    }

    @Override // com.github.steveice10.mc.common.MinecraftPacketProtocol
    public GameProfile getProfile() {
        return this.profile;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    @Override // com.github.steveice10.packetlib.packet.PacketProtocol
    public PacketHeader getPacketHeader() {
        return this.header;
    }

    @Override // com.github.steveice10.packetlib.packet.PacketProtocol
    public PacketEncryption getEncryption() {
        return this.encrypt;
    }

    @Override // com.github.steveice10.packetlib.packet.PacketProtocol
    public void newClientSession(Client client, Session session) {
        if (this.profile != null) {
            session.setFlag("profile", this.profile);
            session.setFlag("access-token", this.accessToken);
        }
        setSubProtocol(this.subProtocol, true, session);
        session.addListener(new ClientListener());
    }

    @Override // com.github.steveice10.packetlib.packet.PacketProtocol
    public void newServerSession(Server server, Session session) {
        setSubProtocol(SubProtocol.HANDSHAKE, false, session);
        session.addListener(new ServerListener());
    }

    protected void enableEncryption(Key key) {
        try {
            this.encrypt = new AESEncryption(key);
        } catch (GeneralSecurityException e) {
            throw new Error("Failed to enable protocol encryption.", e);
        }
    }

    public SubProtocol getSubProtocol() {
        return this.subProtocol;
    }

    protected void setSubProtocol(SubProtocol subProtocol, boolean z, Session session) {
        clearPackets();
        switch (subProtocol) {
            case HANDSHAKE:
                if (z) {
                    initClientHandshake(session);
                    break;
                } else {
                    initServerHandshake(session);
                    break;
                }
            case LOGIN:
                if (z) {
                    initClientLogin(session);
                    break;
                } else {
                    initServerLogin(session);
                    break;
                }
            case GAME:
                if (z) {
                    initClientGame(session);
                    break;
                } else {
                    initServerGame(session);
                    break;
                }
            case STATUS:
                if (z) {
                    initClientStatus(session);
                    break;
                } else {
                    initServerStatus(session);
                    break;
                }
        }
        this.subProtocol = subProtocol;
    }

    private void initClientHandshake(Session session) {
        registerOutgoing(0, HandshakePacket.class);
    }

    private void initServerHandshake(Session session) {
        registerIncoming(0, HandshakePacket.class);
    }

    private void initClientLogin(Session session) {
        registerIncoming(0, LoginDisconnectPacket.class);
        registerIncoming(1, EncryptionRequestPacket.class);
        registerIncoming(2, LoginSuccessPacket.class);
        registerIncoming(3, LoginSetCompressionPacket.class);
        registerOutgoing(0, LoginStartPacket.class);
        registerOutgoing(1, EncryptionResponsePacket.class);
    }

    private void initServerLogin(Session session) {
        registerIncoming(0, LoginStartPacket.class);
        registerIncoming(1, EncryptionResponsePacket.class);
        registerOutgoing(0, LoginDisconnectPacket.class);
        registerOutgoing(1, EncryptionRequestPacket.class);
        registerOutgoing(2, LoginSuccessPacket.class);
        registerOutgoing(3, LoginSetCompressionPacket.class);
    }

    private void initClientGame(Session session) {
        registerIncoming(0, ServerSpawnObjectPacket.class);
        registerIncoming(1, ServerSpawnExpOrbPacket.class);
        registerIncoming(2, ServerSpawnGlobalEntityPacket.class);
        registerIncoming(3, ServerSpawnMobPacket.class);
        registerIncoming(4, ServerSpawnPaintingPacket.class);
        registerIncoming(5, ServerSpawnPlayerPacket.class);
        registerIncoming(6, ServerEntityAnimationPacket.class);
        registerIncoming(7, ServerStatisticsPacket.class);
        registerIncoming(8, ServerBlockBreakAnimPacket.class);
        registerIncoming(9, ServerUpdateTileEntityPacket.class);
        registerIncoming(10, ServerBlockValuePacket.class);
        registerIncoming(11, ServerBlockChangePacket.class);
        registerIncoming(12, ServerBossBarPacket.class);
        registerIncoming(13, ServerDifficultyPacket.class);
        registerIncoming(14, ServerTabCompletePacket.class);
        registerIncoming(15, ServerChatPacket.class);
        registerIncoming(16, ServerMultiBlockChangePacket.class);
        registerIncoming(17, ServerConfirmTransactionPacket.class);
        registerIncoming(18, ServerCloseWindowPacket.class);
        registerIncoming(19, ServerOpenWindowPacket.class);
        registerIncoming(20, ServerWindowItemsPacket.class);
        registerIncoming(21, ServerWindowPropertyPacket.class);
        registerIncoming(22, ServerSetSlotPacket.class);
        registerIncoming(23, ServerSetCooldownPacket.class);
        registerIncoming(24, ServerPluginMessagePacket.class);
        registerIncoming(25, ServerPlaySoundPacket.class);
        registerIncoming(26, ServerDisconnectPacket.class);
        registerIncoming(27, ServerEntityStatusPacket.class);
        registerIncoming(28, ServerExplosionPacket.class);
        registerIncoming(29, ServerUnloadChunkPacket.class);
        registerIncoming(30, ServerNotifyClientPacket.class);
        registerIncoming(31, ServerKeepAlivePacket.class);
        registerIncoming(32, SkipPacket.class);
        registerIncoming(33, ServerPlayEffectPacket.class);
        registerIncoming(34, ServerSpawnParticlePacket.class);
        registerIncoming(35, ServerJoinGamePacket.class);
        registerIncoming(36, ServerMapDataPacket.class);
        registerIncoming(37, ServerEntityPositionPacket.class);
        registerIncoming(38, ServerEntityPositionRotationPacket.class);
        registerIncoming(39, ServerEntityRotationPacket.class);
        registerIncoming(40, ServerEntityMovementPacket.class);
        registerIncoming(41, ServerVehicleMovePacket.class);
        registerIncoming(42, ServerOpenTileEntityEditorPacket.class);
        registerIncoming(43, ServerPlayerAbilitiesPacket.class);
        registerIncoming(44, ServerCombatPacket.class);
        registerIncoming(45, ServerPlayerListEntryPacket.class);
        registerIncoming(46, ServerPlayerPositionRotationPacket.class);
        registerIncoming(47, ServerPlayerUseBedPacket.class);
        registerIncoming(48, ServerEntityDestroyPacket.class);
        registerIncoming(49, ServerEntityRemoveEffectPacket.class);
        registerIncoming(50, ServerResourcePackSendPacket.class);
        registerIncoming(51, ServerRespawnPacket.class);
        registerIncoming(52, ServerEntityHeadLookPacket.class);
        registerIncoming(53, ServerWorldBorderPacket.class);
        registerIncoming(54, ServerSwitchCameraPacket.class);
        registerIncoming(55, ServerPlayerChangeHeldItemPacket.class);
        registerIncoming(56, ServerDisplayScoreboardPacket.class);
        registerIncoming(57, ServerEntityMetadataPacket.class);
        registerIncoming(58, ServerEntityAttachPacket.class);
        registerIncoming(59, ServerEntityVelocityPacket.class);
        registerIncoming(60, ServerEntityEquipmentPacket.class);
        registerIncoming(61, ServerPlayerSetExperiencePacket.class);
        registerIncoming(62, ServerPlayerHealthPacket.class);
        registerIncoming(63, ServerScoreboardObjectivePacket.class);
        registerIncoming(64, ServerEntitySetPassengersPacket.class);
        registerIncoming(65, SkipPacket.class);
        registerIncoming(66, ServerUpdateScorePacket.class);
        registerIncoming(67, ServerSpawnPositionPacket.class);
        registerIncoming(68, ServerUpdateTimePacket.class);
        registerIncoming(69, ServerTitlePacket.class);
        registerIncoming(70, ServerUpdateSignPacket.class);
        registerIncoming(71, ServerPlayBuiltinSoundPacket.class);
        registerIncoming(72, ServerPlayerListDataPacket.class);
        registerIncoming(73, ServerEntityCollectItemPacket.class);
        registerIncoming(74, ServerEntityTeleportPacket.class);
        registerIncoming(75, ServerEntityPropertiesPacket.class);
        registerIncoming(76, ServerEntityEffectPacket.class);
        registerOutgoing(0, ClientTeleportConfirmPacket.class);
        registerOutgoing(1, ClientTabCompletePacket.class);
        registerOutgoing(2, ClientChatPacket.class);
        registerOutgoing(3, ClientRequestPacket.class);
        registerOutgoing(4, ClientSettingsPacket.class);
        registerOutgoing(5, ClientConfirmTransactionPacket.class);
        registerOutgoing(6, ClientEnchantItemPacket.class);
        registerOutgoing(7, ClientWindowActionPacket.class);
        registerOutgoing(8, ClientCloseWindowPacket.class);
        registerOutgoing(9, ClientPluginMessagePacket.class);
        registerOutgoing(10, ClientPlayerInteractEntityPacket.class);
        registerOutgoing(11, ClientKeepAlivePacket.class);
        registerOutgoing(12, ClientPlayerPositionPacket.class);
        registerOutgoing(13, ClientPlayerPositionRotationPacket.class);
        registerOutgoing(14, ClientPlayerRotationPacket.class);
        registerOutgoing(15, ClientPlayerMovementPacket.class);
        registerOutgoing(16, ClientVehicleMovePacket.class);
        registerOutgoing(17, ClientSteerBoatPacket.class);
        registerOutgoing(18, ClientPlayerAbilitiesPacket.class);
        registerOutgoing(19, ClientPlayerActionPacket.class);
        registerOutgoing(20, ClientPlayerStatePacket.class);
        registerOutgoing(21, ClientSteerVehiclePacket.class);
        registerOutgoing(22, ClientResourcePackStatusPacket.class);
        registerOutgoing(23, ClientPlayerChangeHeldItemPacket.class);
        registerOutgoing(24, ClientCreativeInventoryActionPacket.class);
        registerOutgoing(25, ClientUpdateSignPacket.class);
        registerOutgoing(26, ClientPlayerSwingArmPacket.class);
        registerOutgoing(27, ClientSpectatePacket.class);
        registerOutgoing(28, ClientPlayerPlaceBlockPacket.class);
        registerOutgoing(29, ClientPlayerUseItemPacket.class);
    }

    private void initServerGame(Session session) {
        registerIncoming(0, ClientTeleportConfirmPacket.class);
        registerIncoming(1, ClientTabCompletePacket.class);
        registerIncoming(2, ClientChatPacket.class);
        registerIncoming(3, ClientRequestPacket.class);
        registerIncoming(4, ClientSettingsPacket.class);
        registerIncoming(5, ClientConfirmTransactionPacket.class);
        registerIncoming(6, ClientEnchantItemPacket.class);
        registerIncoming(7, ClientWindowActionPacket.class);
        registerIncoming(8, ClientCloseWindowPacket.class);
        registerIncoming(9, ClientPluginMessagePacket.class);
        registerIncoming(10, ClientPlayerInteractEntityPacket.class);
        registerIncoming(11, ClientKeepAlivePacket.class);
        registerIncoming(12, ClientPlayerPositionPacket.class);
        registerIncoming(13, ClientPlayerPositionRotationPacket.class);
        registerIncoming(14, ClientPlayerRotationPacket.class);
        registerIncoming(15, ClientPlayerMovementPacket.class);
        registerIncoming(16, ClientVehicleMovePacket.class);
        registerIncoming(17, ClientSteerBoatPacket.class);
        registerIncoming(18, ClientPlayerAbilitiesPacket.class);
        registerIncoming(19, ClientPlayerActionPacket.class);
        registerIncoming(20, ClientPlayerStatePacket.class);
        registerIncoming(21, ClientSteerVehiclePacket.class);
        registerIncoming(22, ClientResourcePackStatusPacket.class);
        registerIncoming(23, ClientPlayerChangeHeldItemPacket.class);
        registerIncoming(24, ClientCreativeInventoryActionPacket.class);
        registerIncoming(25, ClientUpdateSignPacket.class);
        registerIncoming(26, ClientPlayerSwingArmPacket.class);
        registerIncoming(27, ClientSpectatePacket.class);
        registerIncoming(28, ClientPlayerPlaceBlockPacket.class);
        registerIncoming(29, ClientPlayerUseItemPacket.class);
        registerOutgoing(0, ServerSpawnObjectPacket.class);
        registerOutgoing(1, ServerSpawnExpOrbPacket.class);
        registerOutgoing(2, ServerSpawnGlobalEntityPacket.class);
        registerOutgoing(3, ServerSpawnMobPacket.class);
        registerOutgoing(4, ServerSpawnPaintingPacket.class);
        registerOutgoing(5, ServerSpawnPlayerPacket.class);
        registerOutgoing(6, ServerEntityAnimationPacket.class);
        registerOutgoing(7, ServerStatisticsPacket.class);
        registerOutgoing(8, ServerBlockBreakAnimPacket.class);
        registerOutgoing(9, ServerUpdateTileEntityPacket.class);
        registerOutgoing(10, ServerBlockValuePacket.class);
        registerOutgoing(11, ServerBlockChangePacket.class);
        registerOutgoing(12, ServerBossBarPacket.class);
        registerOutgoing(13, ServerDifficultyPacket.class);
        registerOutgoing(14, ServerTabCompletePacket.class);
        registerOutgoing(15, ServerChatPacket.class);
        registerOutgoing(16, ServerMultiBlockChangePacket.class);
        registerOutgoing(17, ServerConfirmTransactionPacket.class);
        registerOutgoing(18, ServerCloseWindowPacket.class);
        registerOutgoing(19, ServerOpenWindowPacket.class);
        registerOutgoing(20, ServerWindowItemsPacket.class);
        registerOutgoing(21, ServerWindowPropertyPacket.class);
        registerOutgoing(22, ServerSetSlotPacket.class);
        registerOutgoing(23, ServerSetCooldownPacket.class);
        registerOutgoing(24, ServerPluginMessagePacket.class);
        registerOutgoing(25, ServerPlaySoundPacket.class);
        registerOutgoing(26, ServerDisconnectPacket.class);
        registerOutgoing(27, ServerEntityStatusPacket.class);
        registerOutgoing(28, ServerExplosionPacket.class);
        registerOutgoing(29, ServerUnloadChunkPacket.class);
        registerOutgoing(30, ServerNotifyClientPacket.class);
        registerOutgoing(31, ServerKeepAlivePacket.class);
        registerOutgoing(32, ServerChunkDataPacket.class);
        registerOutgoing(33, ServerPlayEffectPacket.class);
        registerOutgoing(34, ServerSpawnParticlePacket.class);
        registerOutgoing(35, ServerJoinGamePacket.class);
        registerOutgoing(36, ServerMapDataPacket.class);
        registerOutgoing(37, ServerEntityPositionPacket.class);
        registerOutgoing(38, ServerEntityPositionRotationPacket.class);
        registerOutgoing(39, ServerEntityRotationPacket.class);
        registerOutgoing(40, ServerEntityMovementPacket.class);
        registerOutgoing(41, ServerVehicleMovePacket.class);
        registerOutgoing(42, ServerOpenTileEntityEditorPacket.class);
        registerOutgoing(43, ServerPlayerAbilitiesPacket.class);
        registerOutgoing(44, ServerCombatPacket.class);
        registerOutgoing(45, ServerPlayerListEntryPacket.class);
        registerOutgoing(46, ServerPlayerPositionRotationPacket.class);
        registerOutgoing(47, ServerPlayerUseBedPacket.class);
        registerOutgoing(48, ServerEntityDestroyPacket.class);
        registerOutgoing(49, ServerEntityRemoveEffectPacket.class);
        registerOutgoing(50, ServerResourcePackSendPacket.class);
        registerOutgoing(51, ServerRespawnPacket.class);
        registerOutgoing(52, ServerEntityHeadLookPacket.class);
        registerOutgoing(53, ServerWorldBorderPacket.class);
        registerOutgoing(54, ServerSwitchCameraPacket.class);
        registerOutgoing(55, ServerPlayerChangeHeldItemPacket.class);
        registerOutgoing(56, ServerDisplayScoreboardPacket.class);
        registerOutgoing(57, ServerEntityMetadataPacket.class);
        registerOutgoing(58, ServerEntityAttachPacket.class);
        registerOutgoing(59, ServerEntityVelocityPacket.class);
        registerOutgoing(60, ServerEntityEquipmentPacket.class);
        registerOutgoing(61, ServerPlayerSetExperiencePacket.class);
        registerOutgoing(62, ServerPlayerHealthPacket.class);
        registerOutgoing(63, ServerScoreboardObjectivePacket.class);
        registerOutgoing(64, ServerEntitySetPassengersPacket.class);
        registerOutgoing(65, ServerTeamPacket.class);
        registerOutgoing(66, ServerUpdateScorePacket.class);
        registerOutgoing(67, ServerSpawnPositionPacket.class);
        registerOutgoing(68, ServerUpdateTimePacket.class);
        registerOutgoing(69, ServerTitlePacket.class);
        registerOutgoing(70, ServerUpdateSignPacket.class);
        registerOutgoing(71, ServerPlayBuiltinSoundPacket.class);
        registerOutgoing(72, ServerPlayerListDataPacket.class);
        registerOutgoing(73, ServerEntityCollectItemPacket.class);
        registerOutgoing(74, ServerEntityTeleportPacket.class);
        registerOutgoing(75, ServerEntityPropertiesPacket.class);
        registerOutgoing(76, ServerEntityEffectPacket.class);
    }

    private void initClientStatus(Session session) {
        registerIncoming(0, StatusResponsePacket.class);
        registerIncoming(1, StatusPongPacket.class);
        registerOutgoing(0, StatusQueryPacket.class);
        registerOutgoing(1, StatusPingPacket.class);
    }

    private void initServerStatus(Session session) {
        registerIncoming(0, StatusQueryPacket.class);
        registerIncoming(1, StatusPingPacket.class);
        registerOutgoing(0, StatusResponsePacket.class);
        registerOutgoing(1, StatusPongPacket.class);
    }
}
