package com.github.steveice10.mc.v1_8.protocol.packet.ingame.client.player;

/* loaded from: classes.dex */
public class ClientPlayerPositionRotationPacket extends ClientPlayerMovementPacket {
    protected ClientPlayerPositionRotationPacket() {
        this.pos = true;
        this.rot = true;
    }

    public ClientPlayerPositionRotationPacket(boolean z, double d, double d2, double d3, float f, float f2) {
        super(z);
        this.pos = true;
        this.rot = true;
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.yaw = f;
        this.pitch = f2;
    }
}
