package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.server.window;

import com.github.steveice10.mc.v1_9_4.protocol.data.game.entity.metadata.ItemStack;
import com.github.steveice10.mc.v1_9_4.protocol.util.NetUtil;
import com.github.steveice10.mc.v1_9_4.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerWindowItemsPacket implements Packet {
    private ItemStack[] items;
    private int windowId;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerWindowItemsPacket() {
    }

    public ServerWindowItemsPacket(int i, ItemStack[] itemStackArr) {
        this.windowId = i;
        this.items = itemStackArr;
    }

    public int getWindowId() {
        return this.windowId;
    }

    public ItemStack[] getItems() {
        return this.items;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.windowId = netInput.readUnsignedByte();
        this.items = new ItemStack[netInput.readShort()];
        for (int i = 0; i < this.items.length; i++) {
            this.items[i] = NetUtil.readItem(netInput);
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.windowId);
        netOutput.writeShort(this.items.length);
        for (ItemStack itemStack : this.items) {
            NetUtil.writeItem(netOutput, itemStack);
        }
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
