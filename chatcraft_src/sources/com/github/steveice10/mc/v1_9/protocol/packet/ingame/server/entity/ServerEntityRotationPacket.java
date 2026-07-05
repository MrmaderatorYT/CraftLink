package com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity;

/* loaded from: classes.dex */
public class ServerEntityRotationPacket extends ServerEntityMovementPacket {
    protected ServerEntityRotationPacket() {
        this.rot = true;
    }

    public ServerEntityRotationPacket(int i, float f, float f2, boolean z) {
        super(i, z);
        this.rot = true;
        this.yaw = f;
        this.pitch = f2;
    }
}
