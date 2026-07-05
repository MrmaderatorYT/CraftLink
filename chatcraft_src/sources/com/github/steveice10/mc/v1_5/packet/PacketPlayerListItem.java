package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import com.github.steveice10.mc.v1_5.util.IOUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketPlayerListItem extends Packet {
    public String name;
    public boolean online;
    public short ping;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 201;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketPlayerListItem() {
    }

    public PacketPlayerListItem(String str, boolean z, short s) {
        this.name = str;
        this.online = z;
        this.ping = s;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.name = IOUtils.readString(dataInputStream);
        this.online = dataInputStream.readBoolean();
        this.ping = dataInputStream.readShort();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        IOUtils.writeString(dataOutputStream, this.name);
        dataOutputStream.writeBoolean(this.online);
        dataOutputStream.writeShort(this.ping);
    }
}
