package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketCollectItem extends Packet {
    public int collected;
    public int collector;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 22;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketCollectItem() {
    }

    public PacketCollectItem(int i, int i2) {
        this.collected = i;
        this.collector = i2;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.collected = dataInputStream.readInt();
        this.collector = dataInputStream.readInt();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.collected);
        dataOutputStream.writeInt(this.collector);
    }
}
