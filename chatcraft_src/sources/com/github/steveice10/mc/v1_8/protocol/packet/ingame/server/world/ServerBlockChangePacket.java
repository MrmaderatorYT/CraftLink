package com.github.steveice10.mc.v1_8.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_8.protocol.data.game.Position;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.world.block.BlockChangeRecord;
import com.github.steveice10.mc.v1_8.protocol.util.v1_8.NetUtil;
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
        Position position = NetUtil.readPosition(netInput);
        int varInt = netInput.readVarInt();
        this.record = new BlockChangeRecord(position, varInt >> 4, varInt & 15);
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        NetUtil.writePosition(netOutput, this.record.getPosition());
        netOutput.writeVarInt((this.record.getId() << 4) | (this.record.getData() & 15));
    }
}
