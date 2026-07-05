package com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity.spawn;

import com.github.steveice10.mc.v1_9.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9.protocol.data.game.entity.type.GlobalEntityType;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerSpawnGlobalEntityPacket implements Packet {
    private int entityId;
    private GlobalEntityType type;
    private double x;
    private double y;
    private double z;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerSpawnGlobalEntityPacket() {
    }

    public ServerSpawnGlobalEntityPacket(int i, GlobalEntityType globalEntityType, double d, double d2, double d3) {
        this.entityId = i;
        this.type = globalEntityType;
        this.x = d;
        this.y = d2;
        this.z = d3;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public GlobalEntityType getType() {
        return this.type;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readVarInt();
        this.type = (GlobalEntityType) MagicValues.key(GlobalEntityType.class, Byte.valueOf(netInput.readByte()));
        this.x = netInput.readDouble();
        this.y = netInput.readDouble();
        this.z = netInput.readDouble();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityId);
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.type)).intValue());
        netOutput.writeDouble(this.x);
        netOutput.writeDouble(this.y);
        netOutput.writeDouble(this.z);
    }
}
