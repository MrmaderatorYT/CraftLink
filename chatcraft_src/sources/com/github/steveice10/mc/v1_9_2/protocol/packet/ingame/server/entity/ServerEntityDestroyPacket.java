package com.github.steveice10.mc.v1_9_2.protocol.packet.ingame.server.entity;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerEntityDestroyPacket implements Packet {
    private int[] entityIds;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerEntityDestroyPacket() {
    }

    public ServerEntityDestroyPacket(int... iArr) {
        this.entityIds = iArr;
    }

    public int[] getEntityIds() {
        return this.entityIds;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityIds = new int[netInput.readVarInt()];
        for (int i = 0; i < this.entityIds.length; i++) {
            this.entityIds[i] = netInput.readVarInt();
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityIds.length);
        for (int i : this.entityIds) {
            netOutput.writeVarInt(i);
        }
    }
}
