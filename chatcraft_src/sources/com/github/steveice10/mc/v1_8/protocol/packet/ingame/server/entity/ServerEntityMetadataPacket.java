package com.github.steveice10.mc.v1_8.protocol.packet.ingame.server.entity;

import com.github.steveice10.mc.v1_8.protocol.data.game.EntityMetadata;
import com.github.steveice10.mc.v1_8.protocol.util.v1_8.NetUtil;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.io.IOException;

/* loaded from: classes.dex */
public class ServerEntityMetadataPacket implements Packet {
    private int entityId;
    private EntityMetadata[] metadata;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerEntityMetadataPacket() {
    }

    public ServerEntityMetadataPacket(int i, EntityMetadata[] entityMetadataArr) {
        this.entityId = i;
        this.metadata = entityMetadataArr;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public EntityMetadata[] getMetadata() {
        return this.metadata;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readVarInt();
        this.metadata = NetUtil.readEntityMetadata(netInput);
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) throws IOException {
        netOutput.writeVarInt(this.entityId);
        NetUtil.writeEntityMetadata(netOutput, this.metadata);
    }
}
