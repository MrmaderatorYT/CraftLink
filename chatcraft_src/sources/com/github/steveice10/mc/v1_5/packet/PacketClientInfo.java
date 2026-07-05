package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import com.github.steveice10.mc.v1_5.util.IOUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketClientInfo extends Packet {
    public boolean cape;
    public byte chatFlags;
    public byte difficulty;
    public String locale;
    public byte viewDistance;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 204;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketClientInfo() {
    }

    public PacketClientInfo(String str, byte b2, byte b3, byte b4, boolean z) {
        this.locale = str;
        this.viewDistance = b2;
        this.chatFlags = b3;
        this.difficulty = b4;
        this.cape = z;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.locale = IOUtils.readString(dataInputStream);
        this.viewDistance = dataInputStream.readByte();
        this.chatFlags = dataInputStream.readByte();
        this.difficulty = dataInputStream.readByte();
        this.cape = dataInputStream.readBoolean();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        IOUtils.writeString(dataOutputStream, this.locale);
        dataOutputStream.writeByte(this.viewDistance);
        dataOutputStream.writeByte(this.chatFlags);
        dataOutputStream.writeByte(this.difficulty);
        dataOutputStream.writeBoolean(this.cape);
    }
}
