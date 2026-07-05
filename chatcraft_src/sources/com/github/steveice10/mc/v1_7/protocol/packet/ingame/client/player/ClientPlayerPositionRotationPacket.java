package com.github.steveice10.mc.v1_7.protocol.packet.ingame.client.player;

/* loaded from: classes.dex */
public class ClientPlayerPositionRotationPacket extends ClientPlayerMovementPacket {
    protected ClientPlayerPositionRotationPacket() {
        this.pos = true;
        this.rot = true;
    }

    public ClientPlayerPositionRotationPacket(boolean z, double d, double d2, double d3, double d4, float f, float f2) {
        super(z);
        this.pos = true;
        this.rot = true;
        this.x = d;
        this.feetY = d2;
        this.headY = d3;
        this.z = d4;
        this.yaw = f;
        this.pitch = f2;
    }
}
