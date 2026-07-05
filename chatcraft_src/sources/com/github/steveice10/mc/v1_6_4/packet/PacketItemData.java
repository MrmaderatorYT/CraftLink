package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketItemData extends Packet {
    public short damage;
    public byte[] data;
    public short item;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 131;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketItemData() {
    }

    public PacketItemData(short s, short s2, byte[] bArr) {
        this.item = s;
        this.damage = s2;
        this.data = bArr;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.item = netInput.readShort();
        this.damage = netInput.readShort();
        this.data = netInput.readBytes(netInput.readShort());
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeShort(this.item);
        netOutput.writeShort(this.damage);
        netOutput.writeShort(this.data.length);
        netOutput.writeBytes(this.data);
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
