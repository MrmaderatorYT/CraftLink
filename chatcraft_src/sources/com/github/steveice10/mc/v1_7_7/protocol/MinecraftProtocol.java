package com.github.steveice10.mc.v1_7_7.protocol;

import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.auth.service.AuthenticationService;
import com.github.steveice10.mc.common.MinecraftPacketProtocol;
import com.github.steveice10.mc.common.SkipPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.handshake.client.HandshakePacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.ClientChatPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.ClientKeepAlivePacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.ClientPluginMessagePacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.ClientRequestPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.ClientSettingsPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.ClientTabCompletePacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.player.ClientChangeHeldItemPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.player.ClientPlayerAbilitiesPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.player.ClientPlayerActionPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.player.ClientPlayerAnimationPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.player.ClientPlayerDigPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.player.ClientPlayerInteractEntityPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.player.ClientPlayerMovementPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.player.ClientPlayerPlaceBlockPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.player.ClientPlayerPositionPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.player.ClientPlayerPositionRotationPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.player.ClientPlayerRotationPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.player.ClientSteerVehiclePacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.window.ClientCloseWindowPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.window.ClientConfirmTransactionPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.window.ClientCreativeInventoryActionPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.window.ClientEnchantItemPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.window.ClientWindowActionPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.world.ClientUpdateSignPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.ServerChatPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.ServerDisconnectPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.ServerJoinGamePacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.ServerKeepAlivePacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.ServerPlayerListEntryPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.ServerPluginMessagePacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.ServerRespawnPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.ServerStatisticsPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.ServerTabCompletePacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.ServerAnimationPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.ServerCollectItemPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.ServerDestroyEntitiesPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.ServerEntityAttachPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.ServerEntityEffectPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.ServerEntityEquipmentPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.ServerEntityHeadLookPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.ServerEntityMetadataPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.ServerEntityMovementPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.ServerEntityPositionPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.ServerEntityPositionRotationPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.ServerEntityPropertiesPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.ServerEntityRemoveEffectPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.ServerEntityRotationPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.ServerEntityStatusPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.ServerEntityTeleportPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.ServerEntityVelocityPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.player.ServerChangeHeldItemPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.player.ServerPlayerAbilitiesPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.player.ServerPlayerPositionRotationPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.player.ServerPlayerUseBedPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.player.ServerSetExperiencePacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.player.ServerUpdateHealthPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.spawn.ServerSpawnExpOrbPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.spawn.ServerSpawnGlobalEntityPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.spawn.ServerSpawnMobPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.spawn.ServerSpawnObjectPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.spawn.ServerSpawnPaintingPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.spawn.ServerSpawnPlayerPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.scoreboard.ServerDisplayScoreboardPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.scoreboard.ServerScoreboardObjectivePacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.scoreboard.ServerTeamPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.scoreboard.ServerUpdateScorePacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.window.ServerCloseWindowPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.window.ServerConfirmTransactionPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.window.ServerOpenWindowPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.window.ServerSetSlotPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.window.ServerWindowItemsPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.window.ServerWindowPropertyPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.world.ServerBlockBreakAnimPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.world.ServerBlockChangePacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.world.ServerBlockValuePacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.world.ServerExplosionPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.world.ServerMapDataPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.world.ServerMultiBlockChangePacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.world.ServerMultiChunkDataPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.world.ServerNotifyClientPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.world.ServerOpenTileEntityEditorPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.world.ServerPlayEffectPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.world.ServerPlaySoundPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.world.ServerSpawnParticlePacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.world.ServerSpawnPositionPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.world.ServerUpdateSignPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.world.ServerUpdateTileEntityPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.world.ServerUpdateTimePacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.login.client.EncryptionResponsePacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.login.client.LoginStartPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.login.server.EncryptionRequestPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.login.server.LoginDisconnectPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.login.server.LoginSuccessPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.status.client.StatusPingPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.status.client.StatusQueryPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.status.server.StatusPongPacket;
import com.github.steveice10.mc.v1_7_7.protocol.packet.status.server.StatusResponsePacket;
import com.github.steveice10.packetlib.Client;
import com.github.steveice10.packetlib.Server;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.crypt.AESEncryption;
import com.github.steveice10.packetlib.crypt.PacketEncryption;
import com.github.steveice10.packetlib.packet.DefaultPacketHeader;
import com.github.steveice10.packetlib.packet.PacketHeader;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.UUID;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public class MinecraftProtocol extends MinecraftPacketProtocol {
    private String accessToken;
    private ClientListener clientListener;
    private AESEncryption encrypt;
    private PacketHeader header;
    private ProtocolMode mode;
    private GameProfile profile;

    @Override // com.github.steveice10.packetlib.packet.PacketProtocol
    public String getSRVRecordPrefix() {
        return "_minecraft";
    }

    public boolean needsPacketEncryptor() {
        return true;
    }

    public boolean needsPacketSizer() {
        return true;
    }

    private MinecraftProtocol() {
        this.mode = ProtocolMode.HANDSHAKE;
        this.header = new DefaultPacketHeader();
        this.accessToken = BuildConfig.FLAVOR;
    }

    public MinecraftProtocol(ProtocolMode protocolMode) {
        this.mode = ProtocolMode.HANDSHAKE;
        this.header = new DefaultPacketHeader();
        this.accessToken = BuildConfig.FLAVOR;
        if (protocolMode != ProtocolMode.LOGIN && protocolMode != ProtocolMode.STATUS) {
            throw new IllegalArgumentException("Only login and status modes are permitted.");
        }
        this.mode = protocolMode;
        if (protocolMode == ProtocolMode.LOGIN) {
            this.profile = new GameProfile((UUID) null, "Player");
        }
        this.clientListener = new ClientListener();
    }

    public MinecraftProtocol(String str) {
        this(ProtocolMode.LOGIN);
        this.profile = new GameProfile((UUID) null, str);
    }

    public MinecraftProtocol(String str, String str2, boolean z) {
        this(ProtocolMode.LOGIN);
        AuthenticationService authenticationService = new AuthenticationService(UUID.randomUUID().toString());
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
        this(ProtocolMode.LOGIN);
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
        setMode(this.mode, true, session);
        session.addListener(this.clientListener);
    }

    @Override // com.github.steveice10.packetlib.packet.PacketProtocol
    public void newServerSession(Server server, Session session) {
        setMode(ProtocolMode.HANDSHAKE, false, session);
        session.addListener(new ServerListener());
    }

    public void enableEncryption(Key key) {
        try {
            this.encrypt = new AESEncryption(key);
        } catch (GeneralSecurityException e) {
            throw new Error("Failed to enable protocol encryption.", e);
        }
    }

    public ProtocolMode getMode() {
        return this.mode;
    }

    public void setMode(ProtocolMode protocolMode, boolean z, Session session) {
        clearPackets();
        switch (protocolMode) {
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
        this.mode = protocolMode;
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
        registerOutgoing(0, LoginStartPacket.class);
        registerOutgoing(1, EncryptionResponsePacket.class);
    }

    private void initServerLogin(Session session) {
        registerIncoming(0, LoginStartPacket.class);
        registerIncoming(1, EncryptionResponsePacket.class);
        registerOutgoing(0, LoginDisconnectPacket.class);
        registerOutgoing(1, EncryptionRequestPacket.class);
        registerOutgoing(2, LoginSuccessPacket.class);
    }

    private void initClientGame(Session session) {
        registerIncoming(0, ServerKeepAlivePacket.class);
        registerIncoming(1, ServerJoinGamePacket.class);
        registerIncoming(2, ServerChatPacket.class);
        registerIncoming(3, ServerUpdateTimePacket.class);
        registerIncoming(4, ServerEntityEquipmentPacket.class);
        registerIncoming(5, ServerSpawnPositionPacket.class);
        registerIncoming(6, ServerUpdateHealthPacket.class);
        registerIncoming(7, ServerRespawnPacket.class);
        registerIncoming(8, ServerPlayerPositionRotationPacket.class);
        registerIncoming(9, ServerChangeHeldItemPacket.class);
        registerIncoming(10, ServerPlayerUseBedPacket.class);
        registerIncoming(11, ServerAnimationPacket.class);
        registerIncoming(12, ServerSpawnPlayerPacket.class);
        registerIncoming(13, ServerCollectItemPacket.class);
        registerIncoming(14, ServerSpawnObjectPacket.class);
        registerIncoming(15, ServerSpawnMobPacket.class);
        registerIncoming(16, ServerSpawnPaintingPacket.class);
        registerIncoming(17, ServerSpawnExpOrbPacket.class);
        registerIncoming(18, ServerEntityVelocityPacket.class);
        registerIncoming(19, ServerDestroyEntitiesPacket.class);
        registerIncoming(20, ServerEntityMovementPacket.class);
        registerIncoming(21, ServerEntityPositionPacket.class);
        registerIncoming(22, ServerEntityRotationPacket.class);
        registerIncoming(23, ServerEntityPositionRotationPacket.class);
        registerIncoming(24, ServerEntityTeleportPacket.class);
        registerIncoming(25, ServerEntityHeadLookPacket.class);
        registerIncoming(26, ServerEntityStatusPacket.class);
        registerIncoming(27, ServerEntityAttachPacket.class);
        registerIncoming(28, ServerEntityMetadataPacket.class);
        registerIncoming(29, ServerEntityEffectPacket.class);
        registerIncoming(30, ServerEntityRemoveEffectPacket.class);
        registerIncoming(31, ServerSetExperiencePacket.class);
        registerIncoming(32, ServerEntityPropertiesPacket.class);
        registerIncoming(33, SkipPacket.class);
        registerIncoming(34, ServerMultiBlockChangePacket.class);
        registerIncoming(35, ServerBlockChangePacket.class);
        registerIncoming(36, ServerBlockValuePacket.class);
        registerIncoming(37, ServerBlockBreakAnimPacket.class);
        registerIncoming(38, ServerMultiChunkDataPacket.class);
        registerIncoming(39, ServerExplosionPacket.class);
        registerIncoming(40, ServerPlayEffectPacket.class);
        registerIncoming(41, ServerPlaySoundPacket.class);
        registerIncoming(42, ServerSpawnParticlePacket.class);
        registerIncoming(43, ServerNotifyClientPacket.class);
        registerIncoming(44, ServerSpawnGlobalEntityPacket.class);
        registerIncoming(45, ServerOpenWindowPacket.class);
        registerIncoming(46, ServerCloseWindowPacket.class);
        registerIncoming(47, ServerSetSlotPacket.class);
        registerIncoming(48, ServerWindowItemsPacket.class);
        registerIncoming(49, ServerWindowPropertyPacket.class);
        registerIncoming(50, ServerConfirmTransactionPacket.class);
        registerIncoming(51, ServerUpdateSignPacket.class);
        registerIncoming(52, ServerMapDataPacket.class);
        registerIncoming(53, ServerUpdateTileEntityPacket.class);
        registerIncoming(54, ServerOpenTileEntityEditorPacket.class);
        registerIncoming(55, ServerStatisticsPacket.class);
        registerIncoming(56, ServerPlayerListEntryPacket.class);
        registerIncoming(57, ServerPlayerAbilitiesPacket.class);
        registerIncoming(58, ServerTabCompletePacket.class);
        registerIncoming(59, ServerScoreboardObjectivePacket.class);
        registerIncoming(60, ServerUpdateScorePacket.class);
        registerIncoming(61, ServerDisplayScoreboardPacket.class);
        registerIncoming(62, ServerTeamPacket.class);
        registerIncoming(63, ServerPluginMessagePacket.class);
        registerIncoming(64, ServerDisconnectPacket.class);
        registerOutgoing(0, ClientKeepAlivePacket.class);
        registerOutgoing(1, ClientChatPacket.class);
        registerOutgoing(2, ClientPlayerInteractEntityPacket.class);
        registerOutgoing(3, ClientPlayerMovementPacket.class);
        registerOutgoing(4, ClientPlayerPositionPacket.class);
        registerOutgoing(5, ClientPlayerRotationPacket.class);
        registerOutgoing(6, ClientPlayerPositionRotationPacket.class);
        registerOutgoing(7, ClientPlayerDigPacket.class);
        registerOutgoing(8, ClientPlayerPlaceBlockPacket.class);
        registerOutgoing(9, ClientChangeHeldItemPacket.class);
        registerOutgoing(10, ClientPlayerAnimationPacket.class);
        registerOutgoing(11, ClientPlayerActionPacket.class);
        registerOutgoing(12, ClientSteerVehiclePacket.class);
        registerOutgoing(13, ClientCloseWindowPacket.class);
        registerOutgoing(14, ClientWindowActionPacket.class);
        registerOutgoing(15, ClientConfirmTransactionPacket.class);
        registerOutgoing(16, ClientCreativeInventoryActionPacket.class);
        registerOutgoing(17, ClientEnchantItemPacket.class);
        registerOutgoing(18, ClientUpdateSignPacket.class);
        registerOutgoing(19, ClientPlayerAbilitiesPacket.class);
        registerOutgoing(20, ClientTabCompletePacket.class);
        registerOutgoing(21, ClientSettingsPacket.class);
        registerOutgoing(22, ClientRequestPacket.class);
        registerOutgoing(23, ClientPluginMessagePacket.class);
    }

    private void initServerGame(Session session) {
        registerIncoming(0, ClientKeepAlivePacket.class);
        registerIncoming(1, ClientChatPacket.class);
        registerIncoming(2, ClientPlayerInteractEntityPacket.class);
        registerIncoming(3, ClientPlayerMovementPacket.class);
        registerIncoming(4, ClientPlayerPositionPacket.class);
        registerIncoming(5, ClientPlayerRotationPacket.class);
        registerIncoming(6, ClientPlayerPositionRotationPacket.class);
        registerIncoming(7, ClientPlayerDigPacket.class);
        registerIncoming(8, ClientPlayerPlaceBlockPacket.class);
        registerIncoming(9, ClientChangeHeldItemPacket.class);
        registerIncoming(10, ClientPlayerAnimationPacket.class);
        registerIncoming(11, ClientPlayerActionPacket.class);
        registerIncoming(12, ClientSteerVehiclePacket.class);
        registerIncoming(13, ClientCloseWindowPacket.class);
        registerIncoming(14, ClientWindowActionPacket.class);
        registerIncoming(15, ClientConfirmTransactionPacket.class);
        registerIncoming(16, ClientCreativeInventoryActionPacket.class);
        registerIncoming(17, ClientEnchantItemPacket.class);
        registerIncoming(18, ClientUpdateSignPacket.class);
        registerIncoming(19, ClientPlayerAbilitiesPacket.class);
        registerIncoming(20, ClientTabCompletePacket.class);
        registerIncoming(21, ClientSettingsPacket.class);
        registerIncoming(22, ClientRequestPacket.class);
        registerIncoming(23, ClientPluginMessagePacket.class);
        registerOutgoing(0, ServerKeepAlivePacket.class);
        registerOutgoing(1, ServerJoinGamePacket.class);
        registerOutgoing(2, ServerChatPacket.class);
        registerOutgoing(3, ServerUpdateTimePacket.class);
        registerOutgoing(4, ServerEntityEquipmentPacket.class);
        registerOutgoing(5, ServerSpawnPositionPacket.class);
        registerOutgoing(6, ServerUpdateHealthPacket.class);
        registerOutgoing(7, ServerRespawnPacket.class);
        registerOutgoing(8, ServerPlayerPositionRotationPacket.class);
        registerOutgoing(9, ServerChangeHeldItemPacket.class);
        registerOutgoing(10, ServerPlayerUseBedPacket.class);
        registerOutgoing(11, ServerAnimationPacket.class);
        registerOutgoing(12, ServerSpawnPlayerPacket.class);
        registerOutgoing(13, ServerCollectItemPacket.class);
        registerOutgoing(14, ServerSpawnObjectPacket.class);
        registerOutgoing(15, ServerSpawnMobPacket.class);
        registerOutgoing(16, ServerSpawnPaintingPacket.class);
        registerOutgoing(17, ServerSpawnExpOrbPacket.class);
        registerOutgoing(18, ServerEntityVelocityPacket.class);
        registerOutgoing(19, ServerDestroyEntitiesPacket.class);
        registerOutgoing(20, ServerEntityMovementPacket.class);
        registerOutgoing(21, ServerEntityPositionPacket.class);
        registerOutgoing(22, ServerEntityRotationPacket.class);
        registerOutgoing(23, ServerEntityPositionRotationPacket.class);
        registerOutgoing(24, ServerEntityTeleportPacket.class);
        registerOutgoing(25, ServerEntityHeadLookPacket.class);
        registerOutgoing(26, ServerEntityStatusPacket.class);
        registerOutgoing(27, ServerEntityAttachPacket.class);
        registerOutgoing(28, ServerEntityMetadataPacket.class);
        registerOutgoing(29, ServerEntityEffectPacket.class);
        registerOutgoing(30, ServerEntityRemoveEffectPacket.class);
        registerOutgoing(31, ServerSetExperiencePacket.class);
        registerOutgoing(32, ServerEntityPropertiesPacket.class);
        registerOutgoing(33, SkipPacket.class);
        registerOutgoing(34, ServerMultiBlockChangePacket.class);
        registerOutgoing(35, ServerBlockChangePacket.class);
        registerOutgoing(36, ServerBlockValuePacket.class);
        registerOutgoing(37, ServerBlockBreakAnimPacket.class);
        registerOutgoing(38, ServerMultiChunkDataPacket.class);
        registerOutgoing(39, ServerExplosionPacket.class);
        registerOutgoing(40, ServerPlayEffectPacket.class);
        registerOutgoing(41, ServerPlaySoundPacket.class);
        registerOutgoing(42, ServerSpawnParticlePacket.class);
        registerOutgoing(43, ServerNotifyClientPacket.class);
        registerOutgoing(44, ServerSpawnGlobalEntityPacket.class);
        registerOutgoing(45, ServerOpenWindowPacket.class);
        registerOutgoing(46, ServerCloseWindowPacket.class);
        registerOutgoing(47, ServerSetSlotPacket.class);
        registerOutgoing(48, ServerWindowItemsPacket.class);
        registerOutgoing(49, ServerWindowPropertyPacket.class);
        registerOutgoing(50, ServerConfirmTransactionPacket.class);
        registerOutgoing(51, ServerUpdateSignPacket.class);
        registerOutgoing(52, ServerMapDataPacket.class);
        registerOutgoing(53, ServerUpdateTileEntityPacket.class);
        registerOutgoing(54, ServerOpenTileEntityEditorPacket.class);
        registerOutgoing(55, ServerStatisticsPacket.class);
        registerOutgoing(56, ServerPlayerListEntryPacket.class);
        registerOutgoing(57, ServerPlayerAbilitiesPacket.class);
        registerOutgoing(58, ServerTabCompletePacket.class);
        registerOutgoing(59, ServerScoreboardObjectivePacket.class);
        registerOutgoing(60, ServerUpdateScorePacket.class);
        registerOutgoing(61, ServerDisplayScoreboardPacket.class);
        registerOutgoing(62, ServerTeamPacket.class);
        registerOutgoing(63, ServerPluginMessagePacket.class);
        registerOutgoing(64, ServerDisconnectPacket.class);
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
