package com.github.steveice10.mc.v1_10.protocol.packet.ingame.client.window;

import com.github.steveice10.mc.v1_10.protocol.data.game.entity.metadata.ItemStack;
import com.github.steveice10.mc.v1_10.protocol.util.NetUtil;
import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientCreativeInventoryActionPacket implements Packet {
    private ItemStack clicked;
    private int slot;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientCreativeInventoryActionPacket() {
    }

    public ClientCreativeInventoryActionPacket(int i, ItemStack itemStack) {
        this.slot = i;
        this.clicked = itemStack;
    }

    public int getSlot() {
        return this.slot;
    }

    public ItemStack getClickedItem() {
        return this.clicked;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.slot = netInput.readShort();
        this.clicked = NetUtil.readItem(netInput);
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeShort(this.slot);
        NetUtil.writeItem(netOutput, this.clicked);
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
