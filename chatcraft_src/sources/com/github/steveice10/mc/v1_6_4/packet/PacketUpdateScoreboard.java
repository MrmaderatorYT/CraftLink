package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketUpdateScoreboard extends Packet {
    public byte action;
    public String item;
    public String scoreboard;
    public int value;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 207;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketUpdateScoreboard() {
    }

    public PacketUpdateScoreboard(String str, byte b2, String str2, int i) {
        this.item = str;
        this.action = b2;
        this.scoreboard = str2;
        this.value = i;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.item = netInput.readString();
        this.action = netInput.readByte();
        if (this.action != 1) {
            this.scoreboard = netInput.readString();
            this.value = netInput.readInt();
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.item);
        netOutput.writeByte(this.action);
        if (this.action != 1) {
            netOutput.writeString(this.scoreboard);
            netOutput.writeInt(this.value);
        }
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
