package com.github.steveice10.mc.v1_8.protocol.packet.ingame.client.player;

import com.github.steveice10.mc.v1_8.protocol.data.game.Position;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.Face;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.MagicValues;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.entity.player.PlayerAction;
import com.github.steveice10.mc.v1_8.protocol.util.v1_8.NetUtil;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientPlayerActionPacket implements Packet {
    private PlayerAction action;
    private Face face;
    private Position position;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientPlayerActionPacket() {
    }

    public ClientPlayerActionPacket(PlayerAction playerAction, Position position, Face face) {
        this.action = playerAction;
        this.position = position;
        this.face = face;
    }

    public PlayerAction getAction() {
        return this.action;
    }

    public Position getPosition() {
        return this.position;
    }

    public Face getFace() {
        return this.face;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.action = (PlayerAction) MagicValues.key(PlayerAction.class, Integer.valueOf(netInput.readUnsignedByte()));
        this.position = NetUtil.readPosition(netInput);
        this.face = (Face) MagicValues.key(Face.class, Integer.valueOf(netInput.readUnsignedByte()));
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.action)).intValue());
        NetUtil.writePosition(netOutput, this.position);
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.face)).intValue());
    }
}
