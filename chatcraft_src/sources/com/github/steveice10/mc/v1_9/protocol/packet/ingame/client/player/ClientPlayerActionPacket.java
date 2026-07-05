package com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.player;

import com.github.steveice10.mc.v1_9.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9.protocol.data.game.entity.metadata.Position;
import com.github.steveice10.mc.v1_9.protocol.data.game.entity.player.PlayerAction;
import com.github.steveice10.mc.v1_9.protocol.data.game.world.block.BlockFace;
import com.github.steveice10.mc.v1_9.protocol.util.NetUtil;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientPlayerActionPacket implements Packet {
    private PlayerAction action;
    private BlockFace face;
    private Position position;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientPlayerActionPacket() {
    }

    public ClientPlayerActionPacket(PlayerAction playerAction, Position position, BlockFace blockFace) {
        this.action = playerAction;
        this.position = position;
        this.face = blockFace;
    }

    public PlayerAction getAction() {
        return this.action;
    }

    public Position getPosition() {
        return this.position;
    }

    public BlockFace getFace() {
        return this.face;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.action = (PlayerAction) MagicValues.key(PlayerAction.class, Integer.valueOf(netInput.readVarInt()));
        this.position = NetUtil.readPosition(netInput);
        this.face = (BlockFace) MagicValues.key(BlockFace.class, Integer.valueOf(netInput.readUnsignedByte()));
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.action)).intValue());
        NetUtil.writePosition(netOutput, this.position);
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.face)).intValue());
    }
}
