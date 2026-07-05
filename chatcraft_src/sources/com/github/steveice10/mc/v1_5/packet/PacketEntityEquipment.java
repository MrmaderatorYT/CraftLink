package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.data.ItemStack;
import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketEntityEquipment extends Packet {
    public int entityId;
    public ItemStack item;
    public short slot;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 5;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketEntityEquipment() {
    }

    public PacketEntityEquipment(int i, short s, ItemStack itemStack) {
        this.entityId = i;
        this.slot = s;
        this.item = itemStack;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public short getSlot() {
        return this.slot;
    }

    public ItemStack getItem() {
        return this.item;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) throws IOException {
        this.entityId = dataInputStream.readInt();
        this.slot = dataInputStream.readShort();
        this.item = new ItemStack();
        this.item.read(dataInputStream);
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityId);
        dataOutputStream.writeShort(this.slot);
        this.item.write(dataOutputStream);
    }
}
