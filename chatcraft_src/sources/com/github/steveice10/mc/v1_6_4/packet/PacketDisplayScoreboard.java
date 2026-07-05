package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketDisplayScoreboard extends Packet {
    public byte position;
    public String scoreboard;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 208;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketDisplayScoreboard() {
    }

    public PacketDisplayScoreboard(byte b2, String str) {
        this.position = b2;
        this.scoreboard = str;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.position = netInput.readByte();
        this.scoreboard = netInput.readString();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.position);
        netOutput.writeString(this.scoreboard);
    }
}
