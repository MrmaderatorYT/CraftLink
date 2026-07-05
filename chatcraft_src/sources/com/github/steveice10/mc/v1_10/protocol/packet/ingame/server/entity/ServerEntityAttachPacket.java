package com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity;

import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerEntityAttachPacket implements Packet {
    private int attachedToId;
    private int entityId;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerEntityAttachPacket() {
    }

    public ServerEntityAttachPacket(int i, int i2) {
        this.entityId = i;
        this.attachedToId = i2;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public int getAttachedToId() {
        return this.attachedToId;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readInt();
        this.attachedToId = netInput.readInt();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.entityId);
        netOutput.writeInt(this.attachedToId);
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
