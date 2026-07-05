package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import com.github.steveice10.mc.v1_5.util.IOUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketDisplayScoreboard extends Packet {
    public byte position;
    public String scoreboard;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 208;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketDisplayScoreboard() {
    }

    public PacketDisplayScoreboard(byte b2, String str) {
        this.position = b2;
        this.scoreboard = str;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.position = dataInputStream.readByte();
        this.scoreboard = IOUtils.readString(dataInputStream);
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.position);
        IOUtils.writeString(dataOutputStream, this.scoreboard);
    }
}
