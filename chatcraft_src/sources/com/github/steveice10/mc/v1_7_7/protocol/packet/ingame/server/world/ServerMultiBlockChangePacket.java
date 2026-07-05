package com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_7_7.protocol.data.game.BlockChangeRecord;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerMultiBlockChangePacket implements Packet {
    private BlockChangeRecord[] records;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerMultiBlockChangePacket() {
    }

    public ServerMultiBlockChangePacket(BlockChangeRecord... blockChangeRecordArr) {
        if (blockChangeRecordArr == null || blockChangeRecordArr.length == 0) {
            throw new IllegalArgumentException("Records must contain at least 1 value.");
        }
        this.records = blockChangeRecordArr;
    }

    public BlockChangeRecord[] getRecords() {
        return this.records;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        int i = netInput.readInt();
        int i2 = netInput.readInt();
        this.records = new BlockChangeRecord[netInput.readShort()];
        netInput.readInt();
        for (int i3 = 0; i3 < this.records.length; i3++) {
            short s = netInput.readShort();
            short s2 = netInput.readShort();
            this.records[i3] = new BlockChangeRecord((i << 4) + ((s >> 12) & 15), s & 255, (i2 << 4) + ((s >> 8) & 15), (s2 >> 4) & 4095, s2 & 15);
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        int x = this.records[0].getX() >> 4;
        int z = this.records[0].getZ() >> 4;
        netOutput.writeInt(x);
        netOutput.writeInt(z);
        netOutput.writeShort(this.records.length);
        netOutput.writeInt(this.records.length * 4);
        for (BlockChangeRecord blockChangeRecord : this.records) {
            netOutput.writeShort(((blockChangeRecord.getX() - (x << 4)) << 12) | ((blockChangeRecord.getZ() - (z << 4)) << 8) | blockChangeRecord.getY());
            netOutput.writeShort((blockChangeRecord.getMetadata() & 15) | ((blockChangeRecord.getId() & 4095) << 4));
        }
    }
}
