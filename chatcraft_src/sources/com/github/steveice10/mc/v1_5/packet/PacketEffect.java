package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketEffect extends Packet {
    public int data;
    public int effectId;
    public boolean ignoreVolume;
    public int x;
    public byte y;
    public int z;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 61;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketEffect() {
    }

    public PacketEffect(int i, int i2, byte b2, int i3, int i4, boolean z) {
        this.effectId = i;
        this.x = i2;
        this.y = b2;
        this.z = i3;
        this.data = i4;
        this.ignoreVolume = z;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.effectId = dataInputStream.readInt();
        this.x = dataInputStream.readInt();
        this.y = dataInputStream.readByte();
        this.z = dataInputStream.readInt();
        this.data = dataInputStream.readInt();
        this.ignoreVolume = dataInputStream.readBoolean();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.effectId);
        dataOutputStream.writeInt(this.x);
        dataOutputStream.writeByte(this.y);
        dataOutputStream.writeInt(this.z);
        dataOutputStream.writeInt(this.data);
        dataOutputStream.writeBoolean(this.ignoreVolume);
    }
}
