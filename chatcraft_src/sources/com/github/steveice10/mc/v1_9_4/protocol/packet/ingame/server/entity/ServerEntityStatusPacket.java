package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.server.entity;

import com.github.steveice10.mc.v1_9_4.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.entity.EntityStatus;
import com.github.steveice10.mc.v1_9_4.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerEntityStatusPacket implements Packet {
    protected int entityId;
    protected EntityStatus status;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerEntityStatusPacket() {
    }

    public ServerEntityStatusPacket(int i, EntityStatus entityStatus) {
        this.entityId = i;
        this.status = entityStatus;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public EntityStatus getStatus() {
        return this.status;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readInt();
        this.status = (EntityStatus) MagicValues.key(EntityStatus.class, Byte.valueOf(netInput.readByte()));
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.entityId);
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.status)).intValue());
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
