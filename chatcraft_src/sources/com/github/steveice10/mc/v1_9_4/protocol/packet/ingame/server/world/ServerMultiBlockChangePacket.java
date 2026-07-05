package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_9_4.protocol.data.game.entity.metadata.Position;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.world.block.BlockChangeRecord;
import com.github.steveice10.mc.v1_9_4.protocol.util.NetUtil;
import com.github.steveice10.mc.v1_9_4.protocol.util.ReflectionToString;
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
        this.records = new BlockChangeRecord[netInput.readVarInt()];
        for (int i3 = 0; i3 < this.records.length; i3++) {
            short s = netInput.readShort();
            this.records[i3] = new BlockChangeRecord(new Position((i << 4) + ((s >> 12) & 15), s & 255, (i2 << 4) + ((s >> 8) & 15)), NetUtil.readBlockState(netInput));
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        int x = this.records[0].getPosition().getX() >> 4;
        int z = this.records[0].getPosition().getZ() >> 4;
        netOutput.writeInt(x);
        netOutput.writeInt(z);
        netOutput.writeVarInt(this.records.length);
        for (BlockChangeRecord blockChangeRecord : this.records) {
            netOutput.writeShort(((blockChangeRecord.getPosition().getX() - (x << 4)) << 12) | ((blockChangeRecord.getPosition().getZ() - (z << 4)) << 8) | blockChangeRecord.getPosition().getY());
            NetUtil.writeBlockState(netOutput, blockChangeRecord.getBlock());
        }
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
