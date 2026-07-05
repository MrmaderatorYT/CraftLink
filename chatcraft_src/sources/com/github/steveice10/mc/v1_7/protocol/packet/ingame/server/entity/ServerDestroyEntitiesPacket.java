package com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.entity;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerDestroyEntitiesPacket implements Packet {
    private int[] entityIds;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerDestroyEntitiesPacket() {
    }

    public ServerDestroyEntitiesPacket(int... iArr) {
        this.entityIds = iArr;
    }

    public int[] getEntityIds() {
        return this.entityIds;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityIds = new int[netInput.readByte()];
        for (int i = 0; i < this.entityIds.length; i++) {
            this.entityIds[i] = netInput.readInt();
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.entityIds.length);
        for (int i : this.entityIds) {
            netOutput.writeInt(i);
        }
    }
}
