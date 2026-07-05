package com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.player;

import com.github.steveice10.mc.v1_9.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9.protocol.data.game.entity.player.Hand;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientPlayerUseItemPacket implements Packet {
    private Hand hand;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientPlayerUseItemPacket() {
    }

    public ClientPlayerUseItemPacket(Hand hand) {
        this.hand = hand;
    }

    public Hand getHand() {
        return this.hand;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.hand = (Hand) MagicValues.key(Hand.class, Integer.valueOf(netInput.readVarInt()));
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.hand)).intValue());
    }
}
