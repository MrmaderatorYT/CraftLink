package com.github.steveice10.mc.v1_6_4.event;

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

/* loaded from: classes.dex */
public interface PacketVisitor {
    void visit(PacketAnimation packetAnimation);

    void visit(PacketAttachEntity packetAttachEntity);

    void visit(PacketBlockAction packetBlockAction);

    void visit(PacketBlockBreakAnimation packetBlockBreakAnimation);

    void visit(PacketBlockChange packetBlockChange);

    void visit(PacketClientChat packetClientChat);

    void visit(PacketClientInfo packetClientInfo);

    void visit(PacketClientStatus packetClientStatus);

    void visit(PacketCloseWindow packetCloseWindow);

    void visit(PacketCollectItem packetCollectItem);

    void visit(PacketConfirmTransaction packetConfirmTransaction);

    void visit(PacketCreativeSlot packetCreativeSlot);

    void visit(PacketDestroyEntity packetDestroyEntity);

    void visit(PacketDisconnect packetDisconnect);

    void visit(PacketDisplayScoreboard packetDisplayScoreboard);

    void visit(PacketEffect packetEffect);

    void visit(PacketEnchantItem packetEnchantItem);

    void visit(PacketEntity packetEntity);

    void visit(PacketEntityAction packetEntityAction);

    void visit(PacketEntityAttributes1_6_4 packetEntityAttributes1_6_4);

    void visit(PacketEntityEffect packetEntityEffect);

    void visit(PacketEntityEquipment packetEntityEquipment);

    void visit(PacketEntityHeadYaw packetEntityHeadYaw);

    void visit(PacketEntityLook packetEntityLook);

    void visit(PacketEntityLookRelativeMove packetEntityLookRelativeMove);

    void visit(PacketEntityMetadata packetEntityMetadata);

    void visit(PacketEntityRelativeMove packetEntityRelativeMove);

    void visit(PacketEntityStatus packetEntityStatus);

    void visit(PacketEntityTeleport packetEntityTeleport);

    void visit(PacketEntityVelocity packetEntityVelocity);

    void visit(PacketExplosion packetExplosion);

    void visit(PacketGameState packetGameState);

    void visit(PacketHandshake packetHandshake);

    void visit(PacketHealthUpdate packetHealthUpdate);

    void visit(PacketHeldItemChange packetHeldItemChange);

    void visit(PacketIncrementStatistic packetIncrementStatistic);

    void visit(PacketItemData packetItemData);

    void visit(PacketKeepAlive packetKeepAlive);

    void visit(PacketKeyRequest packetKeyRequest);

    void visit(PacketKeyResponse packetKeyResponse);

    void visit(PacketLightning packetLightning);

    void visit(PacketLogin packetLogin);

    void visit(PacketMapChunk packetMapChunk);

    void visit(PacketMapChunkBulk packetMapChunkBulk);

    void visit(PacketMultiBlockChange packetMultiBlockChange);

    void visit(PacketNamedSound packetNamedSound);

    void visit(PacketOpenTileEditor packetOpenTileEditor);

    void visit(PacketOpenWindow packetOpenWindow);

    void visit(PacketPlayer packetPlayer);

    void visit(PacketPlayerAbilities packetPlayerAbilities);

    void visit(PacketPlayerBlockPlace packetPlayerBlockPlace);

    void visit(PacketPlayerDigging packetPlayerDigging);

    void visit(PacketPlayerListItem packetPlayerListItem);

    void visit(PacketPlayerLook packetPlayerLook);

    void visit(PacketPlayerPosition packetPlayerPosition);

    void visit(PacketPlayerPositionLook packetPlayerPositionLook);

    void visit(PacketPluginMessage packetPluginMessage);

    void visit(PacketRemoveEntityEffect packetRemoveEntityEffect);

    void visit(PacketRespawn packetRespawn);

    void visit(PacketScoreboardObjective packetScoreboardObjective);

    void visit(PacketServerPing packetServerPing);

    void visit(PacketSetExperience packetSetExperience);

    void visit(PacketSetSlot packetSetSlot);

    void visit(PacketSpawnExpOrb packetSpawnExpOrb);

    void visit(PacketSpawnMob packetSpawnMob);

    void visit(PacketSpawnNamedEntity packetSpawnNamedEntity);

    void visit(PacketSpawnObject packetSpawnObject);

    void visit(PacketSpawnPainting packetSpawnPainting);

    void visit(PacketSpawnParticle packetSpawnParticle);

    void visit(PacketSpawnPosition packetSpawnPosition);

    void visit(PacketSteerVehicle packetSteerVehicle);

    void visit(PacketTabComplete packetTabComplete);

    void visit(PacketTeam packetTeam);

    void visit(PacketTimeUpdate packetTimeUpdate);

    void visit(PacketUpdateScoreboard packetUpdateScoreboard);

    void visit(PacketUpdateSign packetUpdateSign);

    void visit(PacketUpdateTileEntity packetUpdateTileEntity);

    void visit(PacketUseBed packetUseBed);

    void visit(PacketUseEntity packetUseEntity);

    void visit(PacketWindowClick packetWindowClick);

    void visit(PacketWindowItems packetWindowItems);

    void visit(PacketWindowProperty packetWindowProperty);
}
