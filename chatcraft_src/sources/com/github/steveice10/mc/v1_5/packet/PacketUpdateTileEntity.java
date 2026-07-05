package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketUpdateTileEntity extends Packet {
    public byte action;
    public byte[] nbt;
    public int x;
    public short y;
    public int z;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 132;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketUpdateTileEntity() {
    }

    public PacketUpdateTileEntity(int i, short s, int i2, byte b2, byte[] bArr) {
        this.x = i;
        this.y = s;
        this.z = i2;
        this.action = b2;
        this.nbt = bArr;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) throws IOException {
        this.x = dataInputStream.readInt();
        this.y = dataInputStream.readShort();
        this.z = dataInputStream.readInt();
        this.action = dataInputStream.readByte();
        this.nbt = new byte[dataInputStream.readShort()];
        dataInputStream.readFully(this.nbt);
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.x);
        dataOutputStream.writeShort(this.y);
        dataOutputStream.writeInt(this.z);
        dataOutputStream.writeByte(this.action);
        if (this.nbt != null) {
            dataOutputStream.writeShort(this.nbt.length);
            dataOutputStream.write(this.nbt);
        }
    }
}
