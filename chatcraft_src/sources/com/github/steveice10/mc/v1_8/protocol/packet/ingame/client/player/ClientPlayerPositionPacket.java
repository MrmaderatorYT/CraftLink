package com.github.steveice10.mc.v1_8.protocol.packet.ingame.client.player;

/* loaded from: classes.dex */
public class ClientPlayerPositionPacket extends ClientPlayerMovementPacket {
    protected ClientPlayerPositionPacket() {
        this.pos = true;
    }

    public ClientPlayerPositionPacket(boolean z, double d, double d2, double d3) {
        super(z);
        this.pos = true;
        this.x = d;
        this.y = d2;
        this.z = d3;
    }
}
