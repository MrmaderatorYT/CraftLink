package com.github.steveice10.mc.v1_8.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_8.protocol.data.game.Position;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.MagicValues;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.entity.player.BlockBreakStage;
import com.github.steveice10.mc.v1_8.protocol.util.v1_8.NetUtil;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerBlockBreakAnimPacket implements Packet {
    private int breakerEntityId;
    private Position position;
    private BlockBreakStage stage;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerBlockBreakAnimPacket() {
    }

    public ServerBlockBreakAnimPacket(int i, Position position, BlockBreakStage blockBreakStage) {
        this.breakerEntityId = i;
        this.position = position;
        this.stage = blockBreakStage;
    }

    public int getBreakerEntityId() {
        return this.breakerEntityId;
    }

    public Position getPosition() {
        return this.position;
    }

    public BlockBreakStage getStage() {
        return this.stage;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.breakerEntityId = netInput.readVarInt();
        this.position = NetUtil.readPosition(netInput);
        this.stage = (BlockBreakStage) MagicValues.key(BlockBreakStage.class, Integer.valueOf(netInput.readUnsignedByte()));
        if (this.stage == null) {
            this.stage = BlockBreakStage.RESET;
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.breakerEntityId);
        NetUtil.writePosition(netOutput, this.position);
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.stage)).intValue());
    }
}
