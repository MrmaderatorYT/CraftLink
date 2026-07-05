package com.github.steveice10.mc.v1_9_2.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_9_2.protocol.data.game.world.block.BlockChangeRecord;
import com.github.steveice10.mc.v1_9_2.protocol.util.NetUtil;
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
        this.record = new BlockChangeRecord(NetUtil.readPosition(netInput), NetUtil.readBlockState(netInput));
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        NetUtil.writePosition(netOutput, this.record.getPosition());
        NetUtil.writeBlockState(netOutput, this.record.getBlock());
    }
}
