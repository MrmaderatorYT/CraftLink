package com.github.steveice10.mc.v1_5.protocol;

import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.auth.service.AuthenticationService;
import com.github.steveice10.mc.common.MinecraftPacketProtocol;
import com.github.steveice10.mc.v1_5.packet.PacketAnimation;
import com.github.steveice10.mc.v1_5.packet.PacketAttachEntity;
import com.github.steveice10.mc.v1_5.packet.PacketBlockAction;
import com.github.steveice10.mc.v1_5.packet.PacketBlockBreakAnimation;
import com.github.steveice10.mc.v1_5.packet.PacketBlockChange;
import com.github.steveice10.mc.v1_5.packet.PacketClientChat;
import com.github.steveice10.mc.v1_5.packet.PacketClientInfo;
import com.github.steveice10.mc.v1_5.packet.PacketClientStatus;
import com.github.steveice10.mc.v1_5.packet.PacketCloseWindow;
import com.github.steveice10.mc.v1_5.packet.PacketCollectItem;
import com.github.steveice10.mc.v1_5.packet.PacketConfirmTransaction;
import com.github.steveice10.mc.v1_5.packet.PacketCreativeSlot;
import com.github.steveice10.mc.v1_5.packet.PacketDestroyEntity;
import com.github.steveice10.mc.v1_5.packet.PacketDisconnect;
import com.github.steveice10.mc.v1_5.packet.PacketDisplayScoreboard;
import com.github.steveice10.mc.v1_5.packet.PacketEffect;
import com.github.steveice10.mc.v1_5.packet.PacketEnchantItem;
import com.github.steveice10.mc.v1_5.packet.PacketEntity;
import com.github.steveice10.mc.v1_5.packet.PacketEntityAction;
import com.github.steveice10.mc.v1_5.packet.PacketEntityEffect;
import com.github.steveice10.mc.v1_5.packet.PacketEntityEquipment;
import com.github.steveice10.mc.v1_5.packet.PacketEntityHeadYaw;
import com.github.steveice10.mc.v1_5.packet.PacketEntityLook;
import com.github.steveice10.mc.v1_5.packet.PacketEntityLookRelativeMove;
import com.github.steveice10.mc.v1_5.packet.PacketEntityMetadata;
import com.github.steveice10.mc.v1_5.packet.PacketEntityRelativeMove;
import com.github.steveice10.mc.v1_5.packet.PacketEntityStatus;
import com.github.steveice10.mc.v1_5.packet.PacketEntityTeleport;
import com.github.steveice10.mc.v1_5.packet.PacketEntityVelocity;
import com.github.steveice10.mc.v1_5.packet.PacketExplosion;
import com.github.steveice10.mc.v1_5.packet.PacketGameState;
import com.github.steveice10.mc.v1_5.packet.PacketHandshake;
import com.github.steveice10.mc.v1_5.packet.PacketHealthUpdate;
import com.github.steveice10.mc.v1_5.packet.PacketHeldItemChange;
import com.github.steveice10.mc.v1_5.packet.PacketIncrementStatistic;
import com.github.steveice10.mc.v1_5.packet.PacketItemData;
import com.github.steveice10.mc.v1_5.packet.PacketKeepAlive;
import com.github.steveice10.mc.v1_5.packet.PacketKeyRequest;
import com.github.steveice10.mc.v1_5.packet.PacketKeyResponse;
import com.github.steveice10.mc.v1_5.packet.PacketLightning;
import com.github.steveice10.mc.v1_5.packet.PacketLogin;
import com.github.steveice10.mc.v1_5.packet.PacketMapChunk;
import com.github.steveice10.mc.v1_5.packet.PacketMapChunkBulk;
import com.github.steveice10.mc.v1_5.packet.PacketMultiBlockChange;
import com.github.steveice10.mc.v1_5.packet.PacketNamedSound;
import com.github.steveice10.mc.v1_5.packet.PacketOpenWindow;
import com.github.steveice10.mc.v1_5.packet.PacketPlayer;
import com.github.steveice10.mc.v1_5.packet.PacketPlayerAbilities;
import com.github.steveice10.mc.v1_5.packet.PacketPlayerBlockPlace;
import com.github.steveice10.mc.v1_5.packet.PacketPlayerDigging;
import com.github.steveice10.mc.v1_5.packet.PacketPlayerListItem;
import com.github.steveice10.mc.v1_5.packet.PacketPlayerLook;
import com.github.steveice10.mc.v1_5.packet.PacketPlayerPosition;
import com.github.steveice10.mc.v1_5.packet.PacketPlayerPositionLook;
import com.github.steveice10.mc.v1_5.packet.PacketPluginMessage;
import com.github.steveice10.mc.v1_5.packet.PacketRemoveEntityEffect;
import com.github.steveice10.mc.v1_5.packet.PacketRespawn;
import com.github.steveice10.mc.v1_5.packet.PacketScoreboardObjective;
import com.github.steveice10.mc.v1_5.packet.PacketServerChat;
import com.github.steveice10.mc.v1_5.packet.PacketServerPing;
import com.github.steveice10.mc.v1_5.packet.PacketSetExperience;
import com.github.steveice10.mc.v1_5.packet.PacketSetSlot;
import com.github.steveice10.mc.v1_5.packet.PacketSpawnExpOrb;
import com.github.steveice10.mc.v1_5.packet.PacketSpawnMob;
import com.github.steveice10.mc.v1_5.packet.PacketSpawnNamedEntity;
import com.github.steveice10.mc.v1_5.packet.PacketSpawnObject;
import com.github.steveice10.mc.v1_5.packet.PacketSpawnPainting;
import com.github.steveice10.mc.v1_5.packet.PacketSpawnPosition;
import com.github.steveice10.mc.v1_5.packet.PacketTabComplete;
import com.github.steveice10.mc.v1_5.packet.PacketTeam;
import com.github.steveice10.mc.v1_5.packet.PacketTimeUpdate;
import com.github.steveice10.mc.v1_5.packet.PacketUpdateScoreboard;
import com.github.steveice10.mc.v1_5.packet.PacketUpdateSign;
import com.github.steveice10.mc.v1_5.packet.PacketUpdateTileEntity;
import com.github.steveice10.mc.v1_5.packet.PacketUseBed;
import com.github.steveice10.mc.v1_5.packet.PacketUseEntity;
import com.github.steveice10.mc.v1_5.packet.PacketWindowClick;
import com.github.steveice10.mc.v1_5.packet.PacketWindowItems;
import com.github.steveice10.mc.v1_5.packet.PacketWindowProperty;
import com.github.steveice10.packetlib.Client;
import com.github.steveice10.packetlib.Server;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.crypt.AESEncryption;
import com.github.steveice10.packetlib.crypt.PacketEncryption;
import com.github.steveice10.packetlib.packet.DefaultPacketHeader;
import com.github.steveice10.packetlib.packet.Packet;
import com.github.steveice10.packetlib.packet.PacketHeader;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.UUID;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public class MinecraftProtocol extends MinecraftPacketProtocol {
    private String accessToken;
    private AESEncryption encrypt;
    private PacketHeader header;
    private ProtocolMode mode;
    private GameProfile profile;

    private void initClientGame() {
    }

    private void initClientStatus() {
    }

    private void initServerGame() {
    }

    private void initServerLogin() {
    }

    private void initServerStatus() {
    }

    @Override // com.github.steveice10.packetlib.packet.PacketProtocol
    public String getSRVRecordPrefix() {
        return "_minecraft";
    }

    private MinecraftProtocol() {
        this.mode = ProtocolMode.HANDSHAKE;
        this.header = new DefaultPacketHeader();
        this.accessToken = BuildConfig.FLAVOR;
        this.SKIP_NON_REGISTERED_PACKETS = true;
    }

    public MinecraftProtocol(ProtocolMode protocolMode) {
        this.mode = ProtocolMode.HANDSHAKE;
        this.header = new DefaultPacketHeader();
        this.accessToken = BuildConfig.FLAVOR;
        this.SKIP_NON_REGISTERED_PACKETS = true;
        if (protocolMode != ProtocolMode.LOGIN && protocolMode != ProtocolMode.STATUS) {
            throw new IllegalArgumentException("Only login and status modes are permitted.");
        }
        this.mode = protocolMode;
        if (protocolMode == ProtocolMode.LOGIN) {
            this.profile = new GameProfile((UUID) null, "Player");
        }
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
        throw new RuntimeException("Not allowed!");
    }

    @Override // com.github.steveice10.packetlib.packet.PacketProtocol
    public void newServerSession(Server server, Session session) {
        throw new RuntimeException("Not allowed!");
    }

    protected void enableEncryption(Key key) {
        try {
            this.encrypt = new AESEncryption(key);
        } catch (GeneralSecurityException e) {
            throw new Error("Failed to enable protocol encryption.", e);
        }
    }

    public ProtocolMode getMode() {
        return this.mode;
    }

    protected void setMode(ProtocolMode protocolMode, boolean z) {
        clearPackets();
        switch (protocolMode) {
            case HANDSHAKE:
                if (z) {
                    initClientHandshake();
                    break;
                } else {
                    initServerHandshake();
                    break;
                }
            case LOGIN:
                if (z) {
                    initClientLogin();
                    break;
                } else {
                    initServerLogin();
                    break;
                }
            case GAME:
                if (z) {
                    initClientGame();
                    break;
                } else {
                    initServerGame();
                    break;
                }
            case STATUS:
                if (z) {
                    initClientStatus();
                    break;
                } else {
                    initServerStatus();
                    break;
                }
        }
        this.mode = protocolMode;
    }

    private void initClientHandshake() {
        registerOutgoing(0, PacketHandshake.class);
    }

    private void initServerHandshake() {
        registerIncoming(0, PacketHandshake.class);
    }

    private void registerPacket(int i, Class<? extends Packet> cls) {
        registerIncoming(i, cls);
        registerOutgoing(i, cls);
    }

    private void initClientLogin() {
        registerPacket(0, PacketKeepAlive.class);
        registerPacket(1, PacketLogin.class);
        registerPacket(2, PacketHandshake.class);
        registerIncoming(3, PacketServerChat.class);
        registerOutgoing(3, PacketClientChat.class);
        registerPacket(4, PacketTimeUpdate.class);
        registerPacket(5, PacketEntityEquipment.class);
        registerPacket(6, PacketSpawnPosition.class);
        registerPacket(7, PacketUseEntity.class);
        registerPacket(8, PacketHealthUpdate.class);
        registerPacket(9, PacketRespawn.class);
        registerPacket(10, PacketPlayer.class);
        registerPacket(11, PacketPlayerPosition.class);
        registerPacket(12, PacketPlayerLook.class);
        registerPacket(13, PacketPlayerPositionLook.class);
        registerPacket(14, PacketPlayerDigging.class);
        registerPacket(15, PacketPlayerBlockPlace.class);
        registerPacket(16, PacketHeldItemChange.class);
        registerPacket(17, PacketUseBed.class);
        registerPacket(18, PacketAnimation.class);
        registerPacket(19, PacketEntityAction.class);
        registerPacket(20, PacketSpawnNamedEntity.class);
        registerPacket(22, PacketCollectItem.class);
        registerPacket(23, PacketSpawnObject.class);
        registerPacket(24, PacketSpawnMob.class);
        registerPacket(25, PacketSpawnPainting.class);
        registerPacket(26, PacketSpawnExpOrb.class);
        registerPacket(28, PacketEntityVelocity.class);
        registerPacket(29, PacketDestroyEntity.class);
        registerPacket(30, PacketEntity.class);
        registerPacket(31, PacketEntityRelativeMove.class);
        registerPacket(32, PacketEntityLook.class);
        registerPacket(33, PacketEntityLookRelativeMove.class);
        registerPacket(34, PacketEntityTeleport.class);
        registerPacket(35, PacketEntityHeadYaw.class);
        registerPacket(38, PacketEntityStatus.class);
        registerPacket(39, PacketAttachEntity.class);
        registerPacket(40, PacketEntityMetadata.class);
        registerPacket(41, PacketEntityEffect.class);
        registerPacket(42, PacketRemoveEntityEffect.class);
        registerPacket(43, PacketSetExperience.class);
        registerPacket(51, PacketMapChunk.class);
        registerPacket(52, PacketMultiBlockChange.class);
        registerPacket(53, PacketBlockChange.class);
        registerPacket(54, PacketBlockAction.class);
        registerPacket(55, PacketBlockBreakAnimation.class);
        registerPacket(56, PacketMapChunkBulk.class);
        registerPacket(60, PacketExplosion.class);
        registerPacket(61, PacketEffect.class);
        registerPacket(62, PacketNamedSound.class);
        registerPacket(70, PacketGameState.class);
        registerPacket(71, PacketLightning.class);
        registerPacket(100, PacketOpenWindow.class);
        registerPacket(101, PacketCloseWindow.class);
        registerPacket(102, PacketWindowClick.class);
        registerPacket(103, PacketSetSlot.class);
        registerPacket(104, PacketWindowItems.class);
        registerPacket(105, PacketWindowProperty.class);
        registerPacket(106, PacketConfirmTransaction.class);
        registerPacket(107, PacketCreativeSlot.class);
        registerPacket(108, PacketEnchantItem.class);
        registerPacket(130, PacketUpdateSign.class);
        registerPacket(131, PacketItemData.class);
        registerPacket(132, PacketUpdateTileEntity.class);
        registerPacket(200, PacketIncrementStatistic.class);
        registerPacket(201, PacketPlayerListItem.class);
        registerPacket(202, PacketPlayerAbilities.class);
        registerPacket(203, PacketTabComplete.class);
        registerPacket(204, PacketClientInfo.class);
        registerPacket(205, PacketClientStatus.class);
        registerPacket(206, PacketScoreboardObjective.class);
        registerPacket(207, PacketUpdateScoreboard.class);
        registerPacket(208, PacketDisplayScoreboard.class);
        registerPacket(209, PacketTeam.class);
        registerPacket(250, PacketPluginMessage.class);
        registerPacket(252, PacketKeyResponse.class);
        registerPacket(253, PacketKeyRequest.class);
        registerPacket(254, PacketServerPing.class);
        registerPacket(255, PacketDisconnect.class);
    }
}
