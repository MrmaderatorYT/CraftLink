package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.server.entity;

import com.github.steveice10.mc.v1_5.util.Constants;
import com.github.steveice10.mc.v1_9_4.protocol.util.ReflectionToString;
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
            double d = netInput.readShort();
            Double.isNaN(d);
            this.moveX = d / 4096.0d;
            double d2 = netInput.readShort();
            Double.isNaN(d2);
            this.moveY = d2 / 4096.0d;
            double d3 = netInput.readShort();
            Double.isNaN(d3);
            this.moveZ = d3 / 4096.0d;
        }
        if (this.rot) {
            this.yaw = (netInput.readByte() * Constants.AnimationIds.CROUCH) / 256.0f;
            this.pitch = (netInput.readByte() * Constants.AnimationIds.CROUCH) / 256.0f;
        }
        if (this.pos || this.rot) {
            this.onGround = netInput.readBoolean();
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityId);
        if (this.pos) {
            netOutput.writeShort((int) (this.moveX * 4096.0d));
            netOutput.writeShort((int) (this.moveY * 4096.0d));
            netOutput.writeShort((int) (this.moveZ * 4096.0d));
        }
        if (this.rot) {
            netOutput.writeByte((byte) ((this.yaw * 256.0f) / 360.0f));
            netOutput.writeByte((byte) ((this.pitch * 256.0f) / 360.0f));
        }
        if (this.pos || this.rot) {
            netOutput.writeBoolean(this.onGround);
        }
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
