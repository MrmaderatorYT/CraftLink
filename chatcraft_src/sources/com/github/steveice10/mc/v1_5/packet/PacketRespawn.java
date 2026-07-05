package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import com.github.steveice10.mc.v1_5.util.IOUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketRespawn extends Packet {
    public byte difficulty;
    public int dimension;
    public byte gameMode;
    public String levelType;
    public short worldHeight;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 9;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketRespawn() {
    }

    public PacketRespawn(int i, byte b2, byte b3, short s, String str) {
        this.dimension = i;
        this.difficulty = b2;
        this.gameMode = b3;
        this.worldHeight = s;
        this.levelType = str;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.dimension = dataInputStream.readInt();
        this.difficulty = dataInputStream.readByte();
        this.gameMode = dataInputStream.readByte();
        this.worldHeight = dataInputStream.readShort();
        this.levelType = IOUtils.readString(dataInputStream);
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.dimension);
        dataOutputStream.writeByte(this.difficulty);
        dataOutputStream.writeByte(this.gameMode);
        dataOutputStream.writeShort(this.worldHeight);
        IOUtils.writeString(dataOutputStream, this.levelType);
    }
}
