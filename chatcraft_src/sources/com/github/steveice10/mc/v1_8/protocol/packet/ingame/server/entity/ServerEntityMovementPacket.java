package com.github.steveice10.mc.v1_8.protocol.packet.ingame.server.entity;

import com.github.steveice10.mc.v1_5.util.Constants;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerEntityMovementPacket implements Packet {
    protected int entityId;
    protected double moveX;
    protected double moveY;
    protected double moveZ;
    private boolean onGround;
    protected float pitch;
    protected boolean pos = false;
    protected boolean rot = false;
    protected float yaw;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    protected ServerEntityMovementPacket() {
    }

    public ServerEntityMovementPacket(int i, boolean z) {
        this.entityId = i;
        this.onGround = z;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public double getMovementX() {
        return this.moveX;
    }

    public double getMovementY() {
        return this.moveY;
    }

    public double getMovementZ() {
        return this.moveZ;
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
        this.entityId = netInput.readVarInt();
        if (this.pos) {
            double d = netInput.readByte();
            Double.isNaN(d);
            this.moveX = d / 32.0d;
            double d2 = netInput.readByte();
            Double.isNaN(d2);
            this.moveY = d2 / 32.0d;
            double d3 = netInput.readByte();
            Double.isNaN(d3);
            this.moveZ = d3 / 32.0d;
        }
        if (this.rot) {
            this.yaw = (netInput.readByte() * Constants.AnimationIds.CROUCH) / 256.0f;
            this.pitch = (netInput.readByte() * Constants.AnimationIds.CROUCH) / 256.0f;
        }
        this.onGround = netInput.readBoolean();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityId);
        if (this.pos) {
            netOutput.writeByte((int) (this.moveX * 32.0d));
            netOutput.writeByte((int) (this.moveY * 32.0d));
            netOutput.writeByte((int) (this.moveZ * 32.0d));
        }
        if (this.rot) {
            netOutput.writeByte((byte) ((this.yaw * 256.0f) / 360.0f));
            netOutput.writeByte((byte) ((this.pitch * 256.0f) / 360.0f));
        }
        netOutput.writeBoolean(this.onGround);
    }
}
