package com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.window;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerWindowPropertyPacket implements Packet {
    private int property;
    private int value;
    private int windowId;

    public static class Property {
        public static final int ENCHANTMENT_SLOT_1 = 0;
        public static final int ENCHANTMENT_SLOT_2 = 1;
        public static final int ENCHANTMENT_SLOT_3 = 2;
        public static final int FURNACE_FUEL = 1;
        public static final int FURNACE_PROGRESS = 0;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerWindowPropertyPacket() {
    }

    public ServerWindowPropertyPacket(int i, int i2, int i3) {
        this.windowId = i;
        this.property = i2;
        this.value = i3;
    }

    public int getWindowId() {
        return this.windowId;
    }

    public int getProperty() {
        return this.property;
    }

    public int getValue() {
        return this.value;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.windowId = netInput.readUnsignedByte();
        this.property = netInput.readShort();
        this.value = netInput.readShort();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.windowId);
        netOutput.writeShort(this.property);
        netOutput.writeShort(this.value);
    }
}
