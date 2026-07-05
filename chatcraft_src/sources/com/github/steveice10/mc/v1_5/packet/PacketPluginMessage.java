package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import com.github.steveice10.mc.v1_5.util.IOUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketPluginMessage extends Packet {
    public String channel;
    public byte[] data;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 250;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketPluginMessage() {
    }

    public PacketPluginMessage(String str, byte[] bArr) {
        this.channel = str;
        this.data = bArr;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) throws IOException {
        this.channel = IOUtils.readString(dataInputStream);
        this.data = new byte[dataInputStream.readShort()];
        dataInputStream.readFully(this.data);
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        IOUtils.writeString(dataOutputStream, this.channel);
        dataOutputStream.writeShort(this.data.length);
        dataOutputStream.write(this.data);
    }
}
