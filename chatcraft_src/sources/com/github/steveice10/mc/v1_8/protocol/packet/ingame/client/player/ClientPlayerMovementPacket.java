package com.github.steveice10.mc.v1_8.protocol.packet.ingame.client.player;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientPlayerMovementPacket implements Packet {
    protected boolean onGround;
    protected float pitch;
    protected boolean pos = false;
    protected boolean rot = false;
    protected double x;
    protected double y;
    protected float yaw;
    protected double z;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    protected ClientPlayerMovementPacket() {
    }

    public ClientPlayerMovementPacket(boolean z) {
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

    public double getYaw() {
        return this.yaw;
    }

    public double getPitch() {
        return this.pitch;
    }

    public boolean isOnGround() {
        return this.onGround;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        if (this.pos) {
            this.x = netInput.readDouble();
            this.y = netInput.readDouble();
            this.z = netInput.readDouble();
        }
        if (this.rot) {
            this.yaw = netInput.readFloat();
            this.pitch = netInput.readFloat();
        }
        this.onGround = netInput.readBoolean();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        if (this.pos) {
            netOutput.writeDouble(this.x);
            netOutput.writeDouble(this.y);
            netOutput.writeDouble(this.z);
        }
        if (this.rot) {
            netOutput.writeFloat(this.yaw);
            netOutput.writeFloat(this.pitch);
        }
        netOutput.writeBoolean(this.onGround);
    }
}
