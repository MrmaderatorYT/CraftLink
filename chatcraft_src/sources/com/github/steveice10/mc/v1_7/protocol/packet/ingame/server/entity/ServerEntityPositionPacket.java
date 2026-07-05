package com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.entity;

/* loaded from: classes.dex */
public class ServerEntityPositionPacket extends ServerEntityMovementPacket {
    protected ServerEntityPositionPacket() {
        this.pos = true;
    }

    public ServerEntityPositionPacket(int i, double d, double d2, double d3) {
        super(i);
        this.pos = true;
        this.moveX = d;
        this.moveY = d2;
        this.moveZ = d3;
    }
}
