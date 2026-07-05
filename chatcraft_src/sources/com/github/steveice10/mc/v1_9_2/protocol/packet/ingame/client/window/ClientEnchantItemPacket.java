package com.github.steveice10.mc.v1_9_2.protocol.packet.ingame.client.window;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientEnchantItemPacket implements Packet {
    private int enchantment;
    private int windowId;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientEnchantItemPacket() {
    }

    public ClientEnchantItemPacket(int i, int i2) {
        this.windowId = i;
        this.enchantment = i2;
    }

    public int getWindowId() {
        return this.windowId;
    }

    public int getEnchantment() {
        return this.enchantment;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.windowId = netInput.readByte();
        this.enchantment = netInput.readByte();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.windowId);
        netOutput.writeByte(this.enchantment);
    }
}
