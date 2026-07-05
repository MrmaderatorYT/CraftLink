package com.github.steveice10.mc.v1_12_1.protocol;

import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.common.SkipPacket;
import com.github.steveice10.mc.v1_10.protocol.data.SubProtocol;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.ClientChatPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.ClientKeepAlivePacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.ClientPluginMessagePacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.ClientRequestPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.ClientResourcePackStatusPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.ClientSettingsPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.ClientTabCompletePacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.player.ClientPlayerAbilitiesPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.player.ClientPlayerActionPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.player.ClientPlayerChangeHeldItemPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.player.ClientPlayerInteractEntityPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.player.ClientPlayerMovementPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.player.ClientPlayerPositionPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.player.ClientPlayerPositionRotationPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.player.ClientPlayerRotationPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.player.ClientPlayerStatePacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.player.ClientPlayerSwingArmPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.player.ClientPlayerUseItemPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.window.ClientCloseWindowPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.window.ClientConfirmTransactionPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.window.ClientCreativeInventoryActionPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.window.ClientEnchantItemPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.window.ClientWindowActionPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.world.ClientSpectatePacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.world.ClientSteerBoatPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.world.ClientSteerVehiclePacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.world.ClientTeleportConfirmPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.world.ClientUpdateSignPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.world.ClientVehicleMovePacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.ServerBossBarPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.ServerChatPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.ServerCombatPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.ServerDifficultyPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.ServerDisconnectPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.ServerJoinGamePacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.ServerKeepAlivePacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.ServerPlayerListDataPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.ServerPlayerListEntryPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.ServerPluginMessagePacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.ServerResourcePackSendPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.ServerRespawnPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.ServerSetCooldownPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.ServerStatisticsPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.ServerSwitchCameraPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.ServerTabCompletePacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.ServerEntityAnimationPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.ServerEntityAttachPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.ServerEntityDestroyPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.ServerEntityEffectPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.ServerEntityEquipmentPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.ServerEntityHeadLookPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.ServerEntityMetadataPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.ServerEntityMovementPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.ServerEntityPositionPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.ServerEntityPositionRotationPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.ServerEntityPropertiesPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.ServerEntityRemoveEffectPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.ServerEntityRotationPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.ServerEntitySetPassengersPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.ServerEntityStatusPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.ServerEntityTeleportPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.ServerEntityVelocityPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.ServerVehicleMovePacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.player.ServerPlayerAbilitiesPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.player.ServerPlayerChangeHeldItemPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.player.ServerPlayerHealthPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.player.ServerPlayerPositionRotationPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.player.ServerPlayerSetExperiencePacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.player.ServerPlayerUseBedPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.spawn.ServerSpawnExpOrbPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.spawn.ServerSpawnGlobalEntityPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.spawn.ServerSpawnPaintingPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity.spawn.ServerSpawnPlayerPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.scoreboard.ServerDisplayScoreboardPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.scoreboard.ServerScoreboardObjectivePacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.scoreboard.ServerTeamPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.scoreboard.ServerUpdateScorePacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.window.ServerCloseWindowPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.window.ServerConfirmTransactionPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.window.ServerOpenWindowPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.window.ServerSetSlotPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.window.ServerWindowItemsPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.window.ServerWindowPropertyPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.world.ServerBlockBreakAnimPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.world.ServerBlockChangePacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.world.ServerChunkDataPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.world.ServerExplosionPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.world.ServerMapDataPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.world.ServerMultiBlockChangePacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.world.ServerNotifyClientPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.world.ServerOpenTileEntityEditorPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.world.ServerPlayBuiltinSoundPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.world.ServerPlayEffectPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.world.ServerPlaySoundPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.world.ServerSpawnParticlePacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.world.ServerSpawnPositionPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.world.ServerUnloadChunkPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.world.ServerUpdateTileEntityPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.world.ServerUpdateTimePacket;
import com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.world.ServerWorldBorderPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.login.client.EncryptionResponsePacket;
import com.github.steveice10.mc.v1_10.protocol.packet.login.client.LoginStartPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.login.server.EncryptionRequestPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.login.server.LoginDisconnectPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.login.server.LoginSetCompressionPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.login.server.LoginSuccessPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.status.client.StatusPingPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.status.client.StatusQueryPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.status.server.StatusPongPacket;
import com.github.steveice10.mc.v1_10.protocol.packet.status.server.StatusResponsePacket;
import com.github.steveice10.mc.v1_11.protocol.packet.ingame.client.player.ClientPlayerPlaceBlockPacket;
import com.github.steveice10.mc.v1_11.protocol.packet.ingame.server.ServerTitlePacket;
import com.github.steveice10.mc.v1_11.protocol.packet.ingame.server.entity.ServerEntityCollectItemPacket;
import com.github.steveice10.mc.v1_11.protocol.packet.ingame.server.entity.spawn.ServerSpawnMobPacket;
import com.github.steveice10.mc.v1_11.protocol.packet.ingame.server.entity.spawn.ServerSpawnObjectPacket;
import com.github.steveice10.mc.v1_11.protocol.packet.ingame.server.world.ServerBlockValuePacket;
import com.github.steveice10.mc.v1_12.protocol.ingame.client.ingame.client.window.ClientAdvancementTabPacket;
import com.github.steveice10.mc.v1_12.protocol.ingame.client.ingame.client.window.ClientCraftingBookDataPacket;
import com.github.steveice10.mc.v1_12.protocol.ingame.server.windows.ServerAdvancementTabPacket;
import com.github.steveice10.mc.v1_12.protocol.ingame.server.windows.ServerAdvancementsPacket;
import com.github.steveice10.mc.v1_12.protocol.ingame.server.windows.ServerUnlockRecipesPacket;
import com.github.steveice10.mc.v1_12_1.protocol.ingame.client.ingame.client.window.ClientPrepareCraftingGridPacket;
import com.github.steveice10.mc.v1_12_1.protocol.ingame.server.windows.ServerPreparedCraftingGridPacket;
import com.github.steveice10.packetlib.Client;
import com.github.steveice10.packetlib.Session;
import java.net.Proxy;
import java.security.Key;

/* loaded from: classes.dex */
public class MinecraftProtocol extends com.github.steveice10.mc.v1_11_2.protocol.MinecraftProtocol {
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

    @Override // com.github.steveice10.mc.v1_11_2.protocol.MinecraftProtocol, com.github.steveice10.mc.v1_11.protocol.MinecraftProtocol, com.github.steveice10.mc.v1_10.protocol.MinecraftProtocol
    public void setSubProtocol(SubProtocol subProtocol, boolean z, Session session) {
        super.setSubProtocol(subProtocol, z, session);
    }

    @Override // com.github.steveice10.mc.v1_11_2.protocol.MinecraftProtocol, com.github.steveice10.mc.v1_11.protocol.MinecraftProtocol, com.github.steveice10.mc.v1_10.protocol.MinecraftProtocol
    public void enableEncryption(Key key) {
        super.enableEncryption(key);
    }

    @Override // com.github.steveice10.mc.v1_11_2.protocol.MinecraftProtocol, com.github.steveice10.mc.v1_11.protocol.MinecraftProtocol, com.github.steveice10.mc.v1_10.protocol.MinecraftProtocol, com.github.steveice10.packetlib.packet.PacketProtocol
    public void newClientSession(Client client, Session session) {
        if (this.profile != null) {
            session.setFlag("profile", this.profile);
            session.setFlag("access-token", this.accessToken);
        }
        setSubProtocol(this.subProtocol, true, session);
        session.addListener(new ClientListener());
    }

    @Override // com.github.steveice10.mc.v1_10.protocol.MinecraftProtocol
    public void initClientLogin(Session session) {
        registerIncoming(0, LoginDisconnectPacket.class);
        registerIncoming(1, EncryptionRequestPacket.class);
        registerIncoming(2, LoginSuccessPacket.class);
        registerIncoming(3, LoginSetCompressionPacket.class);
        registerOutgoing(0, LoginStartPacket.class);
        registerOutgoing(1, EncryptionResponsePacket.class);
    }

    @Override // com.github.steveice10.mc.v1_10.protocol.MinecraftProtocol
    public void initServerLogin(Session session) {
        registerIncoming(0, LoginStartPacket.class);
        registerIncoming(1, EncryptionResponsePacket.class);
        registerOutgoing(0, LoginDisconnectPacket.class);
        registerOutgoing(1, EncryptionRequestPacket.class);
        registerOutgoing(2, LoginSuccessPacket.class);
        registerOutgoing(3, LoginSetCompressionPacket.class);
    }

    @Override // com.github.steveice10.mc.v1_11.protocol.MinecraftProtocol, com.github.steveice10.mc.v1_10.protocol.MinecraftProtocol
    public void initClientGame(Session session) {
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
        registerIncoming(16, SkipPacket.class);
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
        registerIncoming(37, ServerEntityMovementPacket.class);
        registerIncoming(38, ServerEntityPositionPacket.class);
        registerIncoming(39, ServerEntityPositionRotationPacket.class);
        registerIncoming(40, ServerEntityRotationPacket.class);
        registerIncoming(41, ServerVehicleMovePacket.class);
        registerIncoming(42, ServerOpenTileEntityEditorPacket.class);
        registerIncoming(43, ServerPreparedCraftingGridPacket.class);
        registerIncoming(44, ServerPlayerAbilitiesPacket.class);
        registerIncoming(45, ServerCombatPacket.class);
        registerIncoming(46, ServerPlayerListEntryPacket.class);
        registerIncoming(47, ServerPlayerPositionRotationPacket.class);
        registerIncoming(48, ServerPlayerUseBedPacket.class);
        registerIncoming(49, ServerUnlockRecipesPacket.class);
        registerIncoming(50, ServerEntityDestroyPacket.class);
        registerIncoming(51, ServerEntityRemoveEffectPacket.class);
        registerIncoming(52, ServerResourcePackSendPacket.class);
        registerIncoming(53, ServerRespawnPacket.class);
        registerIncoming(54, ServerEntityHeadLookPacket.class);
        registerIncoming(55, ServerAdvancementTabPacket.class);
        registerIncoming(56, ServerWorldBorderPacket.class);
        registerIncoming(57, ServerSwitchCameraPacket.class);
        registerIncoming(58, ServerPlayerChangeHeldItemPacket.class);
        registerIncoming(59, ServerDisplayScoreboardPacket.class);
        registerIncoming(60, ServerEntityMetadataPacket.class);
        registerIncoming(61, ServerEntityAttachPacket.class);
        registerIncoming(62, ServerEntityVelocityPacket.class);
        registerIncoming(63, ServerEntityEquipmentPacket.class);
        registerIncoming(64, ServerPlayerSetExperiencePacket.class);
        registerIncoming(65, ServerPlayerHealthPacket.class);
        registerIncoming(66, ServerScoreboardObjectivePacket.class);
        registerIncoming(67, ServerEntitySetPassengersPacket.class);
        registerIncoming(68, ServerTeamPacket.class);
        registerIncoming(69, ServerUpdateScorePacket.class);
        registerIncoming(70, ServerSpawnPositionPacket.class);
        registerIncoming(71, ServerUpdateTimePacket.class);
        registerIncoming(72, ServerTitlePacket.class);
        registerIncoming(73, ServerPlayBuiltinSoundPacket.class);
        registerIncoming(74, ServerPlayerListDataPacket.class);
        registerIncoming(75, ServerEntityCollectItemPacket.class);
        registerIncoming(76, ServerEntityTeleportPacket.class);
        registerIncoming(77, ServerAdvancementsPacket.class);
        registerIncoming(78, ServerEntityPropertiesPacket.class);
        registerIncoming(79, ServerEntityEffectPacket.class);
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
        registerOutgoing(12, ClientPlayerMovementPacket.class);
        registerOutgoing(13, ClientPlayerPositionPacket.class);
        registerOutgoing(14, ClientPlayerPositionRotationPacket.class);
        registerOutgoing(15, ClientPlayerRotationPacket.class);
        registerOutgoing(16, ClientVehicleMovePacket.class);
        registerOutgoing(17, ClientSteerBoatPacket.class);
        registerOutgoing(18, ClientPrepareCraftingGridPacket.class);
        registerOutgoing(19, ClientPlayerAbilitiesPacket.class);
        registerOutgoing(20, ClientPlayerActionPacket.class);
        registerOutgoing(21, ClientPlayerStatePacket.class);
        registerOutgoing(22, ClientSteerVehiclePacket.class);
        registerOutgoing(23, ClientCraftingBookDataPacket.class);
        registerOutgoing(24, ClientResourcePackStatusPacket.class);
        registerOutgoing(25, ClientAdvancementTabPacket.class);
        registerOutgoing(26, ClientPlayerChangeHeldItemPacket.class);
        registerOutgoing(27, ClientCreativeInventoryActionPacket.class);
        registerOutgoing(28, ClientUpdateSignPacket.class);
        registerOutgoing(29, ClientPlayerSwingArmPacket.class);
        registerOutgoing(30, ClientSpectatePacket.class);
        registerOutgoing(31, ClientPlayerPlaceBlockPacket.class);
        registerOutgoing(32, ClientPlayerUseItemPacket.class);
    }

    @Override // com.github.steveice10.mc.v1_10.protocol.MinecraftProtocol
    public void initServerGame(Session session) {
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
        registerIncoming(12, ClientPlayerMovementPacket.class);
        registerIncoming(13, ClientPlayerPositionPacket.class);
        registerIncoming(14, ClientPlayerPositionRotationPacket.class);
        registerIncoming(15, ClientPlayerRotationPacket.class);
        registerIncoming(16, ClientVehicleMovePacket.class);
        registerIncoming(17, ClientSteerBoatPacket.class);
        registerIncoming(18, ClientPrepareCraftingGridPacket.class);
        registerIncoming(19, ClientPlayerAbilitiesPacket.class);
        registerIncoming(20, ClientPlayerActionPacket.class);
        registerIncoming(21, ClientPlayerStatePacket.class);
        registerIncoming(22, ClientSteerVehiclePacket.class);
        registerIncoming(23, ClientCraftingBookDataPacket.class);
        registerIncoming(24, ClientResourcePackStatusPacket.class);
        registerIncoming(25, ClientAdvancementTabPacket.class);
        registerIncoming(26, ClientPlayerChangeHeldItemPacket.class);
        registerIncoming(27, ClientCreativeInventoryActionPacket.class);
        registerIncoming(28, ClientUpdateSignPacket.class);
        registerIncoming(29, ClientPlayerSwingArmPacket.class);
        registerIncoming(30, ClientSpectatePacket.class);
        registerIncoming(31, ClientPlayerPlaceBlockPacket.class);
        registerIncoming(32, ClientPlayerUseItemPacket.class);
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
        registerOutgoing(37, ServerEntityMovementPacket.class);
        registerOutgoing(38, ServerEntityPositionPacket.class);
        registerOutgoing(39, ServerEntityPositionRotationPacket.class);
        registerOutgoing(40, ServerEntityRotationPacket.class);
        registerOutgoing(41, ServerVehicleMovePacket.class);
        registerOutgoing(42, ServerOpenTileEntityEditorPacket.class);
        registerOutgoing(43, ServerPreparedCraftingGridPacket.class);
        registerOutgoing(44, ServerPlayerAbilitiesPacket.class);
        registerOutgoing(45, ServerCombatPacket.class);
        registerOutgoing(46, ServerPlayerListEntryPacket.class);
        registerOutgoing(47, ServerPlayerPositionRotationPacket.class);
        registerOutgoing(48, ServerPlayerUseBedPacket.class);
        registerOutgoing(49, ServerUnlockRecipesPacket.class);
        registerOutgoing(50, ServerEntityDestroyPacket.class);
        registerOutgoing(51, ServerEntityRemoveEffectPacket.class);
        registerOutgoing(52, ServerResourcePackSendPacket.class);
        registerOutgoing(53, ServerRespawnPacket.class);
        registerOutgoing(54, ServerEntityHeadLookPacket.class);
        registerOutgoing(55, ServerAdvancementTabPacket.class);
        registerOutgoing(56, ServerWorldBorderPacket.class);
        registerOutgoing(57, ServerSwitchCameraPacket.class);
        registerOutgoing(58, ServerPlayerChangeHeldItemPacket.class);
        registerOutgoing(59, ServerDisplayScoreboardPacket.class);
        registerOutgoing(60, ServerEntityMetadataPacket.class);
        registerOutgoing(61, ServerEntityAttachPacket.class);
        registerOutgoing(62, ServerEntityVelocityPacket.class);
        registerOutgoing(63, ServerEntityEquipmentPacket.class);
        registerOutgoing(64, ServerPlayerSetExperiencePacket.class);
        registerOutgoing(65, ServerPlayerHealthPacket.class);
        registerOutgoing(66, ServerScoreboardObjectivePacket.class);
        registerOutgoing(67, ServerEntitySetPassengersPacket.class);
        registerOutgoing(68, ServerTeamPacket.class);
        registerOutgoing(69, ServerUpdateScorePacket.class);
        registerOutgoing(70, ServerSpawnPositionPacket.class);
        registerOutgoing(71, ServerUpdateTimePacket.class);
        registerOutgoing(72, ServerTitlePacket.class);
        registerOutgoing(73, ServerPlayBuiltinSoundPacket.class);
        registerOutgoing(74, ServerPlayerListDataPacket.class);
        registerOutgoing(75, ServerEntityCollectItemPacket.class);
        registerOutgoing(76, ServerEntityTeleportPacket.class);
        registerOutgoing(77, ServerAdvancementsPacket.class);
        registerOutgoing(78, ServerEntityPropertiesPacket.class);
        registerOutgoing(79, ServerEntityEffectPacket.class);
    }

    @Override // com.github.steveice10.mc.v1_10.protocol.MinecraftProtocol
    public void initClientStatus(Session session) {
        registerIncoming(0, StatusResponsePacket.class);
        registerIncoming(1, StatusPongPacket.class);
        registerOutgoing(0, StatusQueryPacket.class);
        registerOutgoing(1, StatusPingPacket.class);
    }

    @Override // com.github.steveice10.mc.v1_10.protocol.MinecraftProtocol
    public void initServerStatus(Session session) {
        registerIncoming(0, StatusQueryPacket.class);
        registerIncoming(1, StatusPingPacket.class);
        registerOutgoing(0, StatusResponsePacket.class);
        registerOutgoing(1, StatusPongPacket.class);
    }
}
