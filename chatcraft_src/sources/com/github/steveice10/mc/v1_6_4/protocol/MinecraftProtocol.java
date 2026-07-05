package com.github.steveice10.mc.v1_6_4.protocol;

import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.auth.service.AuthenticationService;
import com.github.steveice10.mc.common.MinecraftPacketProtocol;
import com.github.steveice10.mc.v1_6_4.packet.PacketAnimation;
import com.github.steveice10.mc.v1_6_4.packet.PacketAttachEntity;
import com.github.steveice10.mc.v1_6_4.packet.PacketBlockAction;
import com.github.steveice10.mc.v1_6_4.packet.PacketBlockBreakAnimation;
import com.github.steveice10.mc.v1_6_4.packet.PacketBlockChange;
import com.github.steveice10.mc.v1_6_4.packet.PacketClientChat;
import com.github.steveice10.mc.v1_6_4.packet.PacketClientInfo;
import com.github.steveice10.mc.v1_6_4.packet.PacketClientStatus;
import com.github.steveice10.mc.v1_6_4.packet.PacketCloseWindow;
import com.github.steveice10.mc.v1_6_4.packet.PacketCollectItem;
import com.github.steveice10.mc.v1_6_4.packet.PacketConfirmTransaction;
import com.github.steveice10.mc.v1_6_4.packet.PacketCreativeSlot;
import com.github.steveice10.mc.v1_6_4.packet.PacketDestroyEntity;
import com.github.steveice10.mc.v1_6_4.packet.PacketDisconnect;
import com.github.steveice10.mc.v1_6_4.packet.PacketDisplayScoreboard;
import com.github.steveice10.mc.v1_6_4.packet.PacketEffect;
import com.github.steveice10.mc.v1_6_4.packet.PacketEnchantItem;
import com.github.steveice10.mc.v1_6_4.packet.PacketEntity;
import com.github.steveice10.mc.v1_6_4.packet.PacketEntityAction;
import com.github.steveice10.mc.v1_6_4.packet.PacketEntityAttributes1_6;
import com.github.steveice10.mc.v1_6_4.packet.PacketEntityAttributes1_6_4;
import com.github.steveice10.mc.v1_6_4.packet.PacketEntityEffect;
import com.github.steveice10.mc.v1_6_4.packet.PacketEntityEquipment;
import com.github.steveice10.mc.v1_6_4.packet.PacketEntityHeadYaw;
import com.github.steveice10.mc.v1_6_4.packet.PacketEntityLook;
import com.github.steveice10.mc.v1_6_4.packet.PacketEntityLookRelativeMove;
import com.github.steveice10.mc.v1_6_4.packet.PacketEntityMetadata;
import com.github.steveice10.mc.v1_6_4.packet.PacketEntityRelativeMove;
import com.github.steveice10.mc.v1_6_4.packet.PacketEntityStatus;
import com.github.steveice10.mc.v1_6_4.packet.PacketEntityTeleport;
import com.github.steveice10.mc.v1_6_4.packet.PacketEntityVelocity;
import com.github.steveice10.mc.v1_6_4.packet.PacketExplosion;
import com.github.steveice10.mc.v1_6_4.packet.PacketGameState;
import com.github.steveice10.mc.v1_6_4.packet.PacketHandshake;
import com.github.steveice10.mc.v1_6_4.packet.PacketHealthUpdate;
import com.github.steveice10.mc.v1_6_4.packet.PacketHeldItemChange;
import com.github.steveice10.mc.v1_6_4.packet.PacketIncrementStatistic;
import com.github.steveice10.mc.v1_6_4.packet.PacketItemData;
import com.github.steveice10.mc.v1_6_4.packet.PacketKeepAlive;
import com.github.steveice10.mc.v1_6_4.packet.PacketKeyRequest;
import com.github.steveice10.mc.v1_6_4.packet.PacketKeyResponse;
import com.github.steveice10.mc.v1_6_4.packet.PacketLightning;
import com.github.steveice10.mc.v1_6_4.packet.PacketLogin;
import com.github.steveice10.mc.v1_6_4.packet.PacketMapChunk;
import com.github.steveice10.mc.v1_6_4.packet.PacketMapChunkBulk;
import com.github.steveice10.mc.v1_6_4.packet.PacketMultiBlockChange;
import com.github.steveice10.mc.v1_6_4.packet.PacketNamedSound;
import com.github.steveice10.mc.v1_6_4.packet.PacketOpenTileEditor;
import com.github.steveice10.mc.v1_6_4.packet.PacketOpenWindow;
import com.github.steveice10.mc.v1_6_4.packet.PacketPlayer;
import com.github.steveice10.mc.v1_6_4.packet.PacketPlayerAbilities;
import com.github.steveice10.mc.v1_6_4.packet.PacketPlayerBlockPlace;
import com.github.steveice10.mc.v1_6_4.packet.PacketPlayerDigging;
import com.github.steveice10.mc.v1_6_4.packet.PacketPlayerListItem;
import com.github.steveice10.mc.v1_6_4.packet.PacketPlayerLook;
import com.github.steveice10.mc.v1_6_4.packet.PacketPlayerPosition;
import com.github.steveice10.mc.v1_6_4.packet.PacketPlayerPositionLook;
import com.github.steveice10.mc.v1_6_4.packet.PacketPluginMessage;
import com.github.steveice10.mc.v1_6_4.packet.PacketRemoveEntityEffect;
import com.github.steveice10.mc.v1_6_4.packet.PacketRespawn;
import com.github.steveice10.mc.v1_6_4.packet.PacketScoreboardObjective;
import com.github.steveice10.mc.v1_6_4.packet.PacketServerChat;
import com.github.steveice10.mc.v1_6_4.packet.PacketServerPing;
import com.github.steveice10.mc.v1_6_4.packet.PacketSetExperience;
import com.github.steveice10.mc.v1_6_4.packet.PacketSetSlot;
import com.github.steveice10.mc.v1_6_4.packet.PacketSpawnExpOrb;
import com.github.steveice10.mc.v1_6_4.packet.PacketSpawnMob;
import com.github.steveice10.mc.v1_6_4.packet.PacketSpawnNamedEntity;
import com.github.steveice10.mc.v1_6_4.packet.PacketSpawnObject;
import com.github.steveice10.mc.v1_6_4.packet.PacketSpawnPainting;
import com.github.steveice10.mc.v1_6_4.packet.PacketSpawnParticle;
import com.github.steveice10.mc.v1_6_4.packet.PacketSpawnPosition;
import com.github.steveice10.mc.v1_6_4.packet.PacketSteerVehicle;
import com.github.steveice10.mc.v1_6_4.packet.PacketTabComplete;
import com.github.steveice10.mc.v1_6_4.packet.PacketTeam;
import com.github.steveice10.mc.v1_6_4.packet.PacketTimeUpdate;
import com.github.steveice10.mc.v1_6_4.packet.PacketUpdateScoreboard;
import com.github.steveice10.mc.v1_6_4.packet.PacketUpdateSign;
import com.github.steveice10.mc.v1_6_4.packet.PacketUpdateTileEntity;
import com.github.steveice10.mc.v1_6_4.packet.PacketUseBed;
import com.github.steveice10.mc.v1_6_4.packet.PacketUseEntity;
import com.github.steveice10.mc.v1_6_4.packet.PacketWindowClick;
import com.github.steveice10.mc.v1_6_4.packet.PacketWindowItems;
import com.github.steveice10.mc.v1_6_4.packet.PacketWindowProperty;
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
    private AESEncryption encrypt;
    private PacketHeader header;
    private ProtocolMode mode;
    private GameProfile profile;
    private int versionCode;

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
        this.versionCode = 78;
        this.SKIP_NON_REGISTERED_PACKETS = true;
    }

    public MinecraftProtocol(ProtocolMode protocolMode) {
        this.mode = ProtocolMode.HANDSHAKE;
        this.header = new DefaultPacketHeader();
        this.accessToken = BuildConfig.FLAVOR;
        this.versionCode = 78;
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

    public void setVersionCode(int i) {
        this.versionCode = i;
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

    private void initClientLogin() {
        registerIncoming(0, PacketKeepAlive.class);
        registerOutgoing(0, PacketKeepAlive.class);
        registerIncoming(1, PacketLogin.class);
        registerOutgoing(1, PacketLogin.class);
        registerOutgoing(2, PacketHandshake.class);
        registerIncoming(3, PacketServerChat.class);
        registerOutgoing(3, PacketClientChat.class);
        registerIncoming(4, PacketTimeUpdate.class);
        registerIncoming(5, PacketEntityEquipment.class);
        registerIncoming(6, PacketSpawnPosition.class);
        registerOutgoing(7, PacketUseEntity.class);
        registerIncoming(8, PacketHealthUpdate.class);
        registerIncoming(9, PacketRespawn.class);
        registerOutgoing(10, PacketPlayer.class);
        registerOutgoing(11, PacketPlayerPosition.class);
        registerOutgoing(12, PacketPlayerLook.class);
        registerIncoming(13, PacketPlayerPositionLook.class);
        registerOutgoing(13, PacketPlayerPositionLook.class);
        registerOutgoing(14, PacketPlayerDigging.class);
        registerOutgoing(15, PacketPlayerBlockPlace.class);
        registerOutgoing(16, PacketHeldItemChange.class);
        registerIncoming(16, PacketHeldItemChange.class);
        registerIncoming(17, PacketUseBed.class);
        registerIncoming(18, PacketAnimation.class);
        registerOutgoing(18, PacketAnimation.class);
        registerOutgoing(19, PacketEntityAction.class);
        registerIncoming(20, PacketSpawnNamedEntity.class);
        registerIncoming(22, PacketCollectItem.class);
        registerIncoming(23, PacketSpawnObject.class);
        registerIncoming(24, PacketSpawnMob.class);
        registerIncoming(25, PacketSpawnPainting.class);
        registerIncoming(26, PacketSpawnExpOrb.class);
        registerOutgoing(27, PacketSteerVehicle.class);
        registerIncoming(28, PacketEntityVelocity.class);
        registerIncoming(29, PacketDestroyEntity.class);
        registerIncoming(30, PacketEntity.class);
        registerIncoming(31, PacketEntityRelativeMove.class);
        registerIncoming(32, PacketEntityLook.class);
        registerIncoming(33, PacketEntityLookRelativeMove.class);
        registerIncoming(34, PacketEntityTeleport.class);
        registerIncoming(35, PacketEntityHeadYaw.class);
        registerIncoming(38, PacketEntityStatus.class);
        registerIncoming(39, PacketAttachEntity.class);
        registerIncoming(40, PacketEntityMetadata.class);
        registerIncoming(41, PacketEntityEffect.class);
        registerIncoming(42, PacketRemoveEntityEffect.class);
        registerIncoming(43, PacketSetExperience.class);
        if (this.versionCode < 74) {
            registerIncoming(44, PacketEntityAttributes1_6.class);
        } else {
            registerIncoming(44, PacketEntityAttributes1_6_4.class);
        }
        registerIncoming(51, PacketMapChunk.class);
        registerIncoming(52, PacketMultiBlockChange.class);
        registerIncoming(53, PacketBlockChange.class);
        registerIncoming(54, PacketBlockAction.class);
        registerIncoming(55, PacketBlockBreakAnimation.class);
        registerIncoming(56, PacketMapChunkBulk.class);
        registerIncoming(60, PacketExplosion.class);
        registerIncoming(61, PacketEffect.class);
        registerIncoming(62, PacketNamedSound.class);
        registerIncoming(63, PacketSpawnParticle.class);
        registerIncoming(70, PacketGameState.class);
        registerIncoming(71, PacketLightning.class);
        registerIncoming(100, PacketOpenWindow.class);
        registerIncoming(101, PacketCloseWindow.class);
        registerOutgoing(101, PacketCloseWindow.class);
        registerOutgoing(102, PacketWindowClick.class);
        registerIncoming(103, PacketSetSlot.class);
        registerIncoming(104, PacketWindowItems.class);
        registerIncoming(105, PacketWindowProperty.class);
        registerIncoming(106, PacketConfirmTransaction.class);
        registerOutgoing(106, PacketConfirmTransaction.class);
        registerIncoming(107, PacketCreativeSlot.class);
        registerOutgoing(107, PacketCreativeSlot.class);
        registerOutgoing(108, PacketEnchantItem.class);
        registerIncoming(130, PacketUpdateSign.class);
        registerOutgoing(130, PacketUpdateSign.class);
        registerIncoming(131, PacketItemData.class);
        registerIncoming(132, PacketUpdateTileEntity.class);
        registerIncoming(133, PacketOpenTileEditor.class);
        registerIncoming(200, PacketIncrementStatistic.class);
        registerIncoming(201, PacketPlayerListItem.class);
        registerIncoming(202, PacketPlayerAbilities.class);
        registerIncoming(203, PacketTabComplete.class);
        registerOutgoing(203, PacketTabComplete.class);
        registerOutgoing(204, PacketClientInfo.class);
        registerOutgoing(205, PacketClientStatus.class);
        registerIncoming(206, PacketScoreboardObjective.class);
        registerIncoming(207, PacketUpdateScoreboard.class);
        registerIncoming(208, PacketDisplayScoreboard.class);
        registerIncoming(209, PacketTeam.class);
        registerIncoming(250, PacketPluginMessage.class);
        registerOutgoing(250, PacketPluginMessage.class);
        registerIncoming(252, PacketKeyResponse.class);
        registerOutgoing(252, PacketKeyResponse.class);
        registerIncoming(253, PacketKeyRequest.class);
        registerOutgoing(254, PacketServerPing.class);
        registerIncoming(255, PacketDisconnect.class);
        registerOutgoing(255, PacketDisconnect.class);
    }
}
