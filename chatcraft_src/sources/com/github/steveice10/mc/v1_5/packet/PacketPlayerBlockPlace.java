package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.data.ItemStack;
import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketPlayerBlockPlace extends Packet {
    public byte cursorX;
    public byte cursorY;
    public byte cursorZ;
    public byte direction;
    public ItemStack item;
    public byte[] nbt;
    public int x;
    public int y;
    public int z;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 15;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketPlayerBlockPlace() {
    }

    public PacketPlayerBlockPlace(int i, int i2, int i3, byte b2, ItemStack itemStack, byte b3, byte b4, byte b5) {
        this.x = i;
        this.y = i2;
        this.z = i3;
        this.direction = b2;
        this.item = itemStack;
        this.cursorX = b3;
        this.cursorY = b4;
        this.cursorZ = b5;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) throws IOException {
        this.x = dataInputStream.readInt();
        this.y = dataInputStream.readUnsignedByte();
        this.z = dataInputStream.readInt();
        this.direction = dataInputStream.readByte();
        this.item = new ItemStack();
        this.item.read(dataInputStream);
        this.cursorX = dataInputStream.readByte();
        this.cursorY = dataInputStream.readByte();
        this.cursorZ = dataInputStream.readByte();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.x);
        dataOutputStream.writeByte(this.y);
        dataOutputStream.writeInt(this.z);
        dataOutputStream.writeByte(this.direction);
        if (this.item != null) {
            this.item.write(dataOutputStream);
        }
        dataOutputStream.writeByte(this.cursorX);
        dataOutputStream.writeByte(this.cursorY);
        dataOutputStream.writeByte(this.cursorZ);
    }
}
