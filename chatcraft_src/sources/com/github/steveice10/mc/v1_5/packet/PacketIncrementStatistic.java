package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketIncrementStatistic extends Packet {
    public byte amount;
    public int statistic;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 200;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketIncrementStatistic() {
    }

    public PacketIncrementStatistic(int i, byte b2) {
        this.statistic = i;
        this.amount = b2;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.statistic = dataInputStream.readInt();
        this.amount = dataInputStream.readByte();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.statistic);
        dataOutputStream.writeByte(this.amount);
    }
}
