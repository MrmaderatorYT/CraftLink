package com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_7.protocol.data.game.BlockChangeRecord;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerBlockChangePacket implements Packet {
    private BlockChangeRecord record;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerBlockChangePacket() {
    }

    public ServerBlockChangePacket(BlockChangeRecord blockChangeRecord) {
        this.record = blockChangeRecord;
    }

    public BlockChangeRecord getRecord() {
        return this.record;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.record = new BlockChangeRecord(netInput.readInt(), netInput.readUnsignedByte(), netInput.readInt(), netInput.readVarInt(), netInput.readUnsignedByte());
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.record.getX());
        netOutput.writeByte(this.record.getY());
        netOutput.writeInt(this.record.getZ());
        netOutput.writeVarInt(this.record.getId());
        netOutput.writeByte(this.record.getMetadata());
    }
}
