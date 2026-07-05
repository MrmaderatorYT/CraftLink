package com.github.steveice10.mc.v1_8.protocol.packet.ingame.server.entity.spawn;

import com.github.steveice10.mc.v1_8.protocol.data.game.values.MagicValues;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.entity.GlobalEntityType;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerSpawnGlobalEntityPacket implements Packet {
    private int entityId;
    private GlobalEntityType type;
    private int x;
    private int y;
    private int z;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerSpawnGlobalEntityPacket() {
    }

    public ServerSpawnGlobalEntityPacket(int i, GlobalEntityType globalEntityType, int i2, int i3, int i4) {
        this.entityId = i;
        this.type = globalEntityType;
        this.x = i2;
        this.y = i3;
        this.z = i4;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public GlobalEntityType getType() {
        return this.type;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readVarInt();
        this.type = (GlobalEntityType) MagicValues.key(GlobalEntityType.class, Byte.valueOf(netInput.readByte()));
        this.x = netInput.readInt();
        this.y = netInput.readInt();
        this.z = netInput.readInt();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityId);
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.type)).intValue());
        netOutput.writeInt(this.x);
        netOutput.writeInt(this.y);
        netOutput.writeInt(this.z);
    }
}
