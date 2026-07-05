package com.github.steveice10.mc.v1_9_2.protocol.packet.ingame.client.player;

import com.github.steveice10.mc.v1_9_2.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.entity.metadata.Position;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.entity.player.Hand;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.world.block.BlockFace;
import com.github.steveice10.mc.v1_9_2.protocol.util.NetUtil;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientPlayerPlaceBlockPacket implements Packet {
    private float cursorX;
    private float cursorY;
    private float cursorZ;
    private BlockFace face;
    private Hand hand;
    private Position position;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientPlayerPlaceBlockPacket() {
    }

    public ClientPlayerPlaceBlockPacket(Position position, BlockFace blockFace, Hand hand, float f, float f2, float f3) {
        this.position = position;
        this.face = blockFace;
        this.hand = hand;
        this.cursorX = f;
        this.cursorY = f2;
        this.cursorZ = f3;
    }

    public Position getPosition() {
        return this.position;
    }

    public BlockFace getFace() {
        return this.face;
    }

    public Hand getHand() {
        return this.hand;
    }

    public float getCursorX() {
        return this.cursorX;
    }

    public float getCursorY() {
        return this.cursorY;
    }

    public float getCursorZ() {
        return this.cursorZ;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.position = NetUtil.readPosition(netInput);
        this.face = (BlockFace) MagicValues.key(BlockFace.class, Integer.valueOf(netInput.readVarInt()));
        this.hand = (Hand) MagicValues.key(Hand.class, Integer.valueOf(netInput.readVarInt()));
        this.cursorX = netInput.readUnsignedByte() / 16.0f;
        this.cursorY = netInput.readUnsignedByte() / 16.0f;
        this.cursorZ = netInput.readUnsignedByte() / 16.0f;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        NetUtil.writePosition(netOutput, this.position);
        netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.face)).intValue());
        netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.hand)).intValue());
        netOutput.writeByte((int) (this.cursorX * 16.0f));
        netOutput.writeByte((int) (this.cursorY * 16.0f));
        netOutput.writeByte((int) (this.cursorZ * 16.0f));
    }
}
