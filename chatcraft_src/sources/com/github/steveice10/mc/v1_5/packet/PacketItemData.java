package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketItemData extends Packet {
    public short damage;
    public byte[] data;
    public short item;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 131;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketItemData() {
    }

    public PacketItemData(short s, short s2, byte[] bArr) {
        this.item = s;
        this.damage = s2;
        this.data = bArr;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) throws IOException {
        this.item = dataInputStream.readShort();
        this.damage = dataInputStream.readShort();
        this.data = new byte[dataInputStream.readShort()];
        dataInputStream.readFully(this.data);
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.item);
        dataOutputStream.writeShort(this.damage);
        dataOutputStream.writeShort(this.data.length);
        dataOutputStream.write(this.data);
    }
}
