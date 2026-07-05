package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketExplosion extends Packet {
    public byte[] blocks;
    public float radius;
    public float unk1;
    public float unk2;
    public float unk3;
    public double x;
    public double y;
    public double z;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 60;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketExplosion() {
    }

    public PacketExplosion(double d, double d2, double d3, float f, byte[] bArr, float f2, float f3, float f4) {
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.radius = f;
        this.blocks = bArr;
        this.unk1 = f2;
        this.unk2 = f3;
        this.unk3 = f4;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) throws IOException {
        this.x = dataInputStream.readDouble();
        this.y = dataInputStream.readDouble();
        this.z = dataInputStream.readDouble();
        this.radius = dataInputStream.readFloat();
        this.blocks = new byte[dataInputStream.readInt() * 3];
        dataInputStream.readFully(this.blocks);
        this.unk1 = dataInputStream.readFloat();
        this.unk2 = dataInputStream.readFloat();
        this.unk3 = dataInputStream.readFloat();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeDouble(this.x);
        dataOutputStream.writeDouble(this.y);
        dataOutputStream.writeDouble(this.z);
        dataOutputStream.writeFloat(this.radius);
        dataOutputStream.writeInt(this.blocks.length / 3);
        dataOutputStream.write(this.blocks);
        dataOutputStream.writeFloat(this.unk1);
        dataOutputStream.writeFloat(this.unk2);
        dataOutputStream.writeFloat(this.unk3);
    }
}
