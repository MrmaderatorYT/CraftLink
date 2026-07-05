package com.github.steveice10.mc.v1_7.protocol.packet.ingame.client.player;

/* loaded from: classes.dex */
public class ClientPlayerRotationPacket extends ClientPlayerMovementPacket {
    protected ClientPlayerRotationPacket() {
        this.rot = true;
    }

    public ClientPlayerRotationPacket(boolean z, float f, float f2) {
        super(z);
        this.rot = true;
        this.yaw = f;
        this.pitch = f2;
    }
}
