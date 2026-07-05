package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketTimeUpdate extends Packet {
    public long age;
    public long time;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 4;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketTimeUpdate() {
    }

    public PacketTimeUpdate(long j, long j2) {
        this.age = j;
        this.time = j2;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.age = dataInputStream.readLong();
        this.time = dataInputStream.readLong();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeLong(this.age);
        dataOutputStream.writeLong(this.time);
    }
}
