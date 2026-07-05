package com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.entity;

/* loaded from: classes.dex */
public class ServerEntityRotationPacket extends ServerEntityMovementPacket {
    protected ServerEntityRotationPacket() {
        this.rot = true;
    }

    public ServerEntityRotationPacket(int i, float f, float f2) {
        super(i);
        this.rot = true;
        this.yaw = f;
        this.pitch = f2;
    }
}
