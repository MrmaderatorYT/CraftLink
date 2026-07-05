package com.github.steveice10.mc.v1_8.protocol.packet.ingame.client.player;

import com.github.steveice10.mc.v1_8.protocol.data.game.values.MagicValues;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.entity.player.PlayerState;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientPlayerStatePacket implements Packet {
    private int entityId;
    private int jumpBoost;
    private PlayerState state;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientPlayerStatePacket() {
    }

    public ClientPlayerStatePacket(int i, PlayerState playerState) {
        this(i, playerState, 0);
    }

    public ClientPlayerStatePacket(int i, PlayerState playerState, int i2) {
        this.entityId = i;
        this.state = playerState;
        this.jumpBoost = i2;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public PlayerState getState() {
        return this.state;
    }

    public int getJumpBoost() {
        return this.jumpBoost;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readVarInt();
        this.state = (PlayerState) MagicValues.key(PlayerState.class, Integer.valueOf(netInput.readUnsignedByte()));
        this.jumpBoost = netInput.readVarInt();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityId);
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.state)).intValue());
        netOutput.writeVarInt(this.jumpBoost);
    }
}
