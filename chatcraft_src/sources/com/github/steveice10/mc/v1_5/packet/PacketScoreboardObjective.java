package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import com.github.steveice10.mc.v1_5.util.IOUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketScoreboardObjective extends Packet {
    public byte action;
    public String name;
    public String value;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 206;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketScoreboardObjective() {
    }

    public PacketScoreboardObjective(String str, String str2, byte b2) {
        this.name = str;
        this.value = str2;
        this.action = b2;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.name = IOUtils.readString(dataInputStream);
        this.value = IOUtils.readString(dataInputStream);
        this.action = dataInputStream.readByte();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        IOUtils.writeString(dataOutputStream, this.name);
        IOUtils.writeString(dataOutputStream, this.value);
        dataOutputStream.writeByte(this.action);
    }
}
