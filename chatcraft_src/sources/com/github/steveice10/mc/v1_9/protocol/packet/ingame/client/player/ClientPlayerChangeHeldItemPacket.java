package com.github.steveice10.mc.v1_9.protocol.packet.ingame.client.player;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientPlayerChangeHeldItemPacket implements Packet {
    private int slot;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientPlayerChangeHeldItemPacket() {
    }

    public ClientPlayerChangeHeldItemPacket(int i) {
        this.slot = i;
    }

    public int getSlot() {
        return this.slot;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.slot = netInput.readShort();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeShort(this.slot);
    }
}
