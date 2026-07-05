package com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity;

import com.github.steveice10.mc.v1_10.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_10.protocol.data.game.entity.EquipmentSlot;
import com.github.steveice10.mc.v1_10.protocol.data.game.entity.metadata.ItemStack;
import com.github.steveice10.mc.v1_10.protocol.util.NetUtil;
import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerEntityEquipmentPacket implements Packet {
    private int entityId;
    private ItemStack item;
    private EquipmentSlot slot;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerEntityEquipmentPacket() {
    }

    public ServerEntityEquipmentPacket(int i, EquipmentSlot equipmentSlot, ItemStack itemStack) {
        this.entityId = i;
        this.slot = equipmentSlot;
        this.item = itemStack;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public EquipmentSlot getSlot() {
        return this.slot;
    }

    public ItemStack getItem() {
        return this.item;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readVarInt();
        this.slot = (EquipmentSlot) MagicValues.key(EquipmentSlot.class, Integer.valueOf(netInput.readVarInt()));
        this.item = NetUtil.readItem(netInput);
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityId);
        netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.slot)).intValue());
        NetUtil.writeItem(netOutput, this.item);
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
