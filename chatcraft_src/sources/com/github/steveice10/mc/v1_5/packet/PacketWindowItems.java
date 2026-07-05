package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.data.ItemStack;
import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketWindowItems extends Packet {
    public byte id;
    public ItemStack[] items;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 104;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketWindowItems() {
    }

    public PacketWindowItems(byte b2, ItemStack[] itemStackArr) {
        this.id = b2;
        this.items = itemStackArr;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) throws IOException {
        this.id = dataInputStream.readByte();
        this.items = new ItemStack[dataInputStream.readShort()];
        for (int i = 0; i < this.items.length; i++) {
            this.items[i] = new ItemStack();
            this.items[i].read(dataInputStream);
        }
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.id);
        dataOutputStream.writeShort(this.items.length);
        for (ItemStack itemStack : this.items) {
            itemStack.write(dataOutputStream);
        }
    }
}
