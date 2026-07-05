package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketRespawn extends Packet {
    public byte difficulty;
    public int dimension;
    public byte gameMode;
    public String levelType;
    public short worldHeight;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 9;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
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

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.dimension = netInput.readInt();
        this.difficulty = netInput.readByte();
        this.gameMode = netInput.readByte();
        this.worldHeight = netInput.readShort();
        this.levelType = netInput.readString();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.dimension);
        netOutput.writeByte(this.difficulty);
        netOutput.writeByte(this.gameMode);
        netOutput.writeShort(this.worldHeight);
        netOutput.writeString(this.levelType);
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
