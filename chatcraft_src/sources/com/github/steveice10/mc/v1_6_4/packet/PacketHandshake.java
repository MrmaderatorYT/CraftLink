package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketHandshake extends Packet {
    public String host;
    public int port;
    public int protocol;
    public String user;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 2;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketHandshake() {
    }

    public PacketHandshake(String str, String str2, int i, int i2) {
        this.user = str;
        this.host = str2;
        this.port = i;
        this.protocol = i2;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.protocol = netInput.readByte();
        this.user = netInput.readString();
        this.host = netInput.readString();
        this.port = netInput.readInt();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.protocol);
        netOutput.writeString(this.user);
        netOutput.writeString(this.host);
        netOutput.writeInt(this.port);
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
