package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.server.entity;

import com.github.steveice10.mc.v1_9_4.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerEntityVelocityPacket implements Packet {
    private int entityId;
    private double motX;
    private double motY;
    private double motZ;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerEntityVelocityPacket() {
    }

    public ServerEntityVelocityPacket(int i, double d, double d2, double d3) {
        this.entityId = i;
        this.motX = d;
        this.motY = d2;
        this.motZ = d3;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public double getMotionX() {
        return this.motX;
    }

    public double getMotionY() {
        return this.motY;
    }

    public double getMotionZ() {
        return this.motZ;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readVarInt();
        double d = netInput.readShort();
        Double.isNaN(d);
        this.motX = d / 8000.0d;
        double d2 = netInput.readShort();
        Double.isNaN(d2);
        this.motY = d2 / 8000.0d;
        double d3 = netInput.readShort();
        Double.isNaN(d3);
        this.motZ = d3 / 8000.0d;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityId);
        netOutput.writeShort((int) (this.motX * 8000.0d));
        netOutput.writeShort((int) (this.motY * 8000.0d));
        netOutput.writeShort((int) (this.motZ * 8000.0d));
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
