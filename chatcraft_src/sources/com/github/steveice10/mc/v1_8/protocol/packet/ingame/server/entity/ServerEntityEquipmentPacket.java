package com.github.steveice10.mc.v1_8.protocol.packet.ingame.server.entity;

import com.github.steveice10.mc.v1_8.protocol.data.game.ItemStack;
import com.github.steveice10.mc.v1_8.protocol.util.v1_8.NetUtil;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerEntityEquipmentPacket implements Packet {
    private int entityId;
    private ItemStack item;
    private int slot;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerEntityEquipmentPacket() {
    }

    public ServerEntityEquipmentPacket(int i, int i2, ItemStack itemStack) {
        this.entityId = i;
        this.slot = i2;
        this.item = itemStack;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public int getSlot() {
        return this.slot;
    }

    public ItemStack getItem() {
        return this.item;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readVarInt();
        this.slot = netInput.readShort();
        this.item = NetUtil.readItem(netInput);
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityId);
        netOutput.writeShort(this.slot);
        NetUtil.writeItem(netOutput, this.item);
    }
}
