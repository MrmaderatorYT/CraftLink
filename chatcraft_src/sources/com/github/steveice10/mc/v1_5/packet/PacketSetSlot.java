package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.data.ItemStack;
import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketSetSlot extends Packet {
    public byte id;
    public ItemStack item;
    public short slot;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 103;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketSetSlot() {
    }

    public PacketSetSlot(byte b2, short s, ItemStack itemStack) {
        this.id = b2;
        this.slot = s;
        this.item = itemStack;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) throws IOException {
        this.id = dataInputStream.readByte();
        this.slot = dataInputStream.readShort();
        this.item = new ItemStack();
        this.item.read(dataInputStream);
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.id);
        dataOutputStream.writeShort(this.slot);
        if (this.item != null) {
            this.item.write(dataOutputStream);
        }
    }
}
