package com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.player;

/* loaded from: classes.dex */
public class ClientPlayerPositionPacket extends ClientPlayerMovementPacket {
    protected ClientPlayerPositionPacket() {
        this.pos = true;
    }

    public ClientPlayerPositionPacket(boolean z, double d, double d2, double d3, double d4) {
        super(z);
        this.pos = true;
        this.x = d;
        this.feetY = d2;
        this.headY = d3;
        this.z = d4;
    }
}
