package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_9_4.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.entity.metadata.Position;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.entity.player.BlockBreakStage;
import com.github.steveice10.mc.v1_9_4.protocol.util.NetUtil;
import com.github.steveice10.mc.v1_9_4.protocol.util.ReflectionToString;
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
        try {
            this.stage = (BlockBreakStage) MagicValues.key(BlockBreakStage.class, Integer.valueOf(netInput.readUnsignedByte()));
        } catch (IllegalArgumentException unused) {
            this.stage = BlockBreakStage.RESET;
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.breakerEntityId);
        NetUtil.writePosition(netOutput, this.position);
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.stage)).intValue());
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
