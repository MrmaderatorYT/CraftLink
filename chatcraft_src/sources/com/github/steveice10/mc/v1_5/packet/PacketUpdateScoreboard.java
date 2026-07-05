package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import com.github.steveice10.mc.v1_5.util.IOUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketUpdateScoreboard extends Packet {
    public byte action;
    public String item;
    public String scoreboard;
    public int value;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 207;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketUpdateScoreboard() {
    }

    public PacketUpdateScoreboard(String str, byte b2, String str2, int i) {
        this.item = str;
        this.action = b2;
        this.scoreboard = str2;
        this.value = i;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.item = IOUtils.readString(dataInputStream);
        this.action = dataInputStream.readByte();
        if (this.action != 1) {
            this.scoreboard = IOUtils.readString(dataInputStream);
            this.value = dataInputStream.readInt();
        }
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        IOUtils.writeString(dataOutputStream, this.item);
        dataOutputStream.writeByte(this.action);
        if (this.action != 1) {
            IOUtils.writeString(dataOutputStream, this.scoreboard);
            dataOutputStream.writeInt(this.value);
        }
    }
}
