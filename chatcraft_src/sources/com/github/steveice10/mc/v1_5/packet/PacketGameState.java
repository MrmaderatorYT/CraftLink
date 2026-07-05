package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketGameState extends Packet {
    public byte gamemode;
    public byte reason;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 70;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketGameState() {
    }

    public PacketGameState(byte b2, byte b3) {
        this.reason = b2;
        this.gamemode = b3;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.reason = dataInputStream.readByte();
        this.gamemode = dataInputStream.readByte();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.reason);
        dataOutputStream.writeByte(this.gamemode);
    }
}
