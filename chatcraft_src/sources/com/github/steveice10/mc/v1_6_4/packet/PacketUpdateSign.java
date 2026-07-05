package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketUpdateSign extends Packet {
    public String[] lines;
    public int x;
    public short y;
    public int z;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 130;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketUpdateSign() {
    }

    public PacketUpdateSign(int i, short s, int i2, String[] strArr) {
        this.x = i;
        this.y = s;
        this.z = i2;
        this.lines = strArr;
        if (this.lines == null || this.lines.length != 4) {
            throw new IllegalArgumentException("Line array size must be 4!");
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.x = netInput.readInt();
        this.y = netInput.readShort();
        this.z = netInput.readInt();
        this.lines = new String[4];
        this.lines[0] = netInput.readString();
        this.lines[1] = netInput.readString();
        this.lines[2] = netInput.readString();
        this.lines[3] = netInput.readString();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.x);
        netOutput.writeShort(this.y);
        netOutput.writeInt(this.z);
        netOutput.writeString(this.lines[0]);
        netOutput.writeString(this.lines[1]);
        netOutput.writeString(this.lines[2]);
        netOutput.writeString(this.lines[3]);
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
