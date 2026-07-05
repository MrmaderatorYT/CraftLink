package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import com.github.steveice10.mc.v1_5.util.IOUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketLogin extends Packet {
    public byte difficulty;
    public byte dimension;
    public int entityId;
    public byte gameMode;
    public String levelType;
    public byte maxPlayers;
    public byte unused;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 1;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketLogin() {
    }

    public PacketLogin(int i, String str, byte b2, byte b3, byte b4, byte b5, byte b6) {
        this.entityId = i;
        this.levelType = str;
        this.gameMode = b2;
        this.dimension = b3;
        this.difficulty = b4;
        this.unused = b5;
        this.maxPlayers = b6;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.entityId = dataInputStream.readInt();
        this.levelType = IOUtils.readString(dataInputStream);
        this.gameMode = dataInputStream.readByte();
        this.dimension = dataInputStream.readByte();
        this.difficulty = dataInputStream.readByte();
        this.unused = dataInputStream.readByte();
        this.maxPlayers = dataInputStream.readByte();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityId);
        IOUtils.writeString(dataOutputStream, this.levelType);
        dataOutputStream.writeByte(this.gameMode);
        dataOutputStream.writeByte(this.dimension);
        dataOutputStream.writeByte(this.difficulty);
        dataOutputStream.writeByte(this.unused);
        dataOutputStream.writeByte(this.maxPlayers);
    }
}
