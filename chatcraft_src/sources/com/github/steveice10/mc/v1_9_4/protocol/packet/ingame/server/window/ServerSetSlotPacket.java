package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.server.window;

import com.github.steveice10.mc.v1_9_4.protocol.data.game.entity.metadata.ItemStack;
import com.github.steveice10.mc.v1_9_4.protocol.util.NetUtil;
import com.github.steveice10.mc.v1_9_4.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerSetSlotPacket implements Packet {
    private ItemStack item;
    private int slot;
    private int windowId;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerSetSlotPacket() {
    }

    public ServerSetSlotPacket(int i, int i2, ItemStack itemStack) {
        this.windowId = i;
        this.slot = i2;
        this.item = itemStack;
    }

    public int getWindowId() {
        return this.windowId;
    }

    public int getSlot() {
        return this.slot;
    }

    public ItemStack getItem() {
        return this.item;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.windowId = netInput.readUnsignedByte();
        this.slot = netInput.readShort();
        this.item = NetUtil.readItem(netInput);
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.windowId);
        netOutput.writeShort(this.slot);
        NetUtil.writeItem(netOutput, this.item);
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
