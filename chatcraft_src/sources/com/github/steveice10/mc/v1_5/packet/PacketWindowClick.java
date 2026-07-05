package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.data.ItemStack;
import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketWindowClick extends Packet {
    public short action;
    public ItemStack clicked;
    public byte id;
    public byte mousebutton;
    public boolean shift;
    public short slot;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 102;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketWindowClick() {
    }

    public PacketWindowClick(byte b2, short s, byte b3, short s2, boolean z, ItemStack itemStack) {
        this.id = b2;
        this.slot = s;
        this.mousebutton = b3;
        this.action = s2;
        this.shift = z;
        this.clicked = itemStack;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) throws IOException {
        this.id = dataInputStream.readByte();
        this.slot = dataInputStream.readShort();
        this.mousebutton = dataInputStream.readByte();
        this.action = dataInputStream.readShort();
        this.shift = dataInputStream.readBoolean();
        this.clicked = new ItemStack();
        this.clicked.read(dataInputStream);
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.id);
        dataOutputStream.writeShort(this.slot);
        dataOutputStream.writeByte(this.mousebutton);
        dataOutputStream.writeShort(this.action);
        dataOutputStream.writeBoolean(this.shift);
        if (this.clicked != null) {
            this.clicked.write(dataOutputStream);
        }
    }
}
