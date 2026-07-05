package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import com.github.steveice10.mc.v1_5.util.IOUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketHandshake extends Packet {
    public String host;
    public int port;
    public int protocol;
    public String user;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 2;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketHandshake() {
    }

    public PacketHandshake(String str, String str2, int i, int i2) {
        this.protocol = i2;
        this.user = str;
        this.host = str2;
        this.port = i;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.protocol = dataInputStream.readByte();
        this.user = IOUtils.readString(dataInputStream);
        this.host = IOUtils.readString(dataInputStream);
        this.port = dataInputStream.readInt();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.protocol);
        IOUtils.writeString(dataOutputStream, this.user);
        IOUtils.writeString(dataOutputStream, this.host);
        dataOutputStream.writeInt(this.port);
    }
}
