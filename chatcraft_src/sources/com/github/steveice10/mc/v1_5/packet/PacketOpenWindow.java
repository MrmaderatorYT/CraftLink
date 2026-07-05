package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import com.github.steveice10.mc.v1_5.util.IOUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketOpenWindow extends Packet {
    public byte id;
    public String name;
    public byte slots;
    public byte type;
    public boolean useTitle;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 100;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketOpenWindow() {
    }

    public PacketOpenWindow(byte b2, byte b3, String str, byte b4, boolean z) {
        this.id = b2;
        this.type = b3;
        this.name = str;
        this.slots = b4;
        this.useTitle = z;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.id = dataInputStream.readByte();
        this.type = dataInputStream.readByte();
        this.name = IOUtils.readString(dataInputStream);
        this.slots = dataInputStream.readByte();
        this.useTitle = dataInputStream.readBoolean();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.id);
        dataOutputStream.writeByte(this.type);
        IOUtils.writeString(dataOutputStream, this.name);
        dataOutputStream.writeByte(this.slots);
        dataOutputStream.writeBoolean(this.useTitle);
    }
}
