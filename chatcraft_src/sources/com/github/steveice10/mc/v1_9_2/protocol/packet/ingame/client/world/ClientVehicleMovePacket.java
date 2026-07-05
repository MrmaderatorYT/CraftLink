package com.github.steveice10.mc.v1_9_2.protocol.packet.ingame.client.world;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientVehicleMovePacket implements Packet {
    private float pitch;
    private double x;
    private double y;
    private float yaw;
    private double z;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientVehicleMovePacket() {
    }

    public ClientVehicleMovePacket(double d, double d2, double d3, float f, float f2) {
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.yaw = f;
        this.pitch = f2;
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

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.x = netInput.readDouble();
        this.y = netInput.readDouble();
        this.z = netInput.readDouble();
        this.yaw = netInput.readFloat();
        this.pitch = netInput.readFloat();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeDouble(this.x);
        netOutput.writeDouble(this.y);
        netOutput.writeDouble(this.z);
        netOutput.writeFloat(this.yaw);
        netOutput.writeFloat(this.pitch);
    }
}
