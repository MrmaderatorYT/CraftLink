package com.github.steveice10.mc.v1_8.protocol.packet.ingame.server.entity.spawn;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerSpawnExpOrbPacket implements Packet {
    private int entityId;
    private int exp;
    private double x;
    private double y;
    private double z;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerSpawnExpOrbPacket() {
    }

    public ServerSpawnExpOrbPacket(int i, double d, double d2, double d3, int i2) {
        this.entityId = i;
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.exp = i2;
    }

    public int getEntityId() {
        return this.entityId;
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

    public int getExp() {
        return this.exp;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readVarInt();
        double d = netInput.readInt();
        Double.isNaN(d);
        this.x = d / 32.0d;
        double d2 = netInput.readInt();
        Double.isNaN(d2);
        this.y = d2 / 32.0d;
        double d3 = netInput.readInt();
        Double.isNaN(d3);
        this.z = d3 / 32.0d;
        this.exp = netInput.readShort();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityId);
        netOutput.writeInt((int) (this.x * 32.0d));
        netOutput.writeInt((int) (this.y * 32.0d));
        netOutput.writeInt((int) (this.z * 32.0d));
        netOutput.writeShort(this.exp);
    }
}
