package com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.player;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerPlayerPositionRotationPacket implements Packet {
    protected boolean onGround;
    protected float pitch;
    protected double x;
    protected double y;
    protected float yaw;
    protected double z;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerPlayerPositionRotationPacket() {
    }

    public ServerPlayerPositionRotationPacket(double d, double d2, double d3, float f, float f2, boolean z) {
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.yaw = f;
        this.pitch = f2;
        this.onGround = z;
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

    public float getYaw() {
        return this.yaw;
    }

    public float getPitch() {
        return this.pitch;
    }

    public boolean isOnGround() {
        return this.onGround;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.x = netInput.readDouble();
        this.y = netInput.readDouble();
        this.z = netInput.readDouble();
        this.yaw = netInput.readFloat();
        this.pitch = netInput.readFloat();
        this.onGround = netInput.readBoolean();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeDouble(this.x);
        netOutput.writeDouble(this.y);
        netOutput.writeDouble(this.z);
        netOutput.writeFloat(this.yaw);
        netOutput.writeFloat(this.pitch);
        netOutput.writeBoolean(this.onGround);
    }
}
