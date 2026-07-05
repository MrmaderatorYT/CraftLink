package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.server.entity;

/* loaded from: classes.dex */
public class ServerEntityPositionPacket extends ServerEntityMovementPacket {
    protected ServerEntityPositionPacket() {
        this.pos = true;
    }

    public ServerEntityPositionPacket(int i, double d, double d2, double d3, boolean z) {
        super(i, z);
        this.pos = true;
        this.moveX = d;
        this.moveY = d2;
        this.moveZ = d3;
    }
}
