package com.github.steveice10.mc.v1_9_2.protocol.packet.ingame.server.entity;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerEntityCollectItemPacket implements Packet {
    private int collectedEntityId;
    private int collectorEntityId;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerEntityCollectItemPacket() {
    }

    public ServerEntityCollectItemPacket(int i, int i2) {
        this.collectedEntityId = i;
        this.collectorEntityId = i2;
    }

    public int getCollectedEntityId() {
        return this.collectedEntityId;
    }

    public int getCollectorEntityId() {
        return this.collectorEntityId;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.collectedEntityId = netInput.readVarInt();
        this.collectorEntityId = netInput.readVarInt();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.collectedEntityId);
        netOutput.writeVarInt(this.collectorEntityId);
    }
}
