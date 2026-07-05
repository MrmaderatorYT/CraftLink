package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketLogin extends Packet {
    public static boolean FORGE = false;
    public byte difficulty;
    public int dimension;
    public int entityId;
    public byte gameMode;
    public String levelType;
    public byte maxPlayers;
    public byte unused;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 1;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketLogin() {
    }

    public PacketLogin(int i, String str, byte b2, int i2, byte b3, byte b4, byte b5) {
        this.entityId = i;
        this.levelType = str;
        this.gameMode = b2;
        this.dimension = i2;
        this.difficulty = b3;
        this.unused = b4;
        this.maxPlayers = b5;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readInt();
        this.levelType = netInput.readString();
        this.gameMode = netInput.readByte();
        if (FORGE) {
            this.dimension = netInput.readInt();
        } else {
            this.dimension = netInput.readByte();
        }
        this.difficulty = netInput.readByte();
        this.unused = netInput.readByte();
        this.maxPlayers = netInput.readByte();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.entityId);
        netOutput.writeString(this.levelType);
        netOutput.writeByte(this.gameMode);
        if (FORGE) {
            netOutput.writeInt(this.dimension);
        } else {
            netOutput.writeByte(this.dimension);
        }
        netOutput.writeByte(this.difficulty);
        netOutput.writeByte(this.unused);
        netOutput.writeByte(this.maxPlayers);
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
