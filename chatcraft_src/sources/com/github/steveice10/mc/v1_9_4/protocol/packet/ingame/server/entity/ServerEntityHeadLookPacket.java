package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.server.entity;

import com.github.steveice10.mc.v1_5.util.Constants;
import com.github.steveice10.mc.v1_9_4.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerEntityHeadLookPacket implements Packet {
    private int entityId;
    private float headYaw;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerEntityHeadLookPacket() {
    }

    public ServerEntityHeadLookPacket(int i, float f) {
        this.entityId = i;
        this.headYaw = f;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public float getHeadYaw() {
        return this.headYaw;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readVarInt();
        this.headYaw = (netInput.readByte() * Constants.AnimationIds.CROUCH) / 256.0f;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityId);
        netOutput.writeByte((byte) ((this.headYaw * 256.0f) / 360.0f));
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
