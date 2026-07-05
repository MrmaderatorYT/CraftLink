package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.server.entity;

/* loaded from: classes.dex */
public class ServerEntityPositionRotationPacket extends ServerEntityMovementPacket {
    protected ServerEntityPositionRotationPacket() {
        this.pos = true;
        this.rot = true;
    }

    public ServerEntityPositionRotationPacket(int i, double d, double d2, double d3, float f, float f2, boolean z) {
        super(i, z);
        this.pos = true;
        this.rot = true;
        this.moveX = d;
        this.moveY = d2;
        this.moveZ = d3;
        this.yaw = f;
        this.pitch = f2;
    }
}
