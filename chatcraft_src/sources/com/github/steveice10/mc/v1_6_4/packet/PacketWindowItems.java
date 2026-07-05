package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.data.StandardItemStack;
import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketWindowItems extends Packet {
    public byte id;
    public StandardItemStack[] items;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 104;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketWindowItems() {
    }

    public PacketWindowItems(byte b2, StandardItemStack[] standardItemStackArr) {
        this.id = b2;
        this.items = standardItemStackArr;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.id = netInput.readByte();
        this.items = new StandardItemStack[netInput.readShort()];
        for (int i = 0; i < this.items.length; i++) {
            this.items[i] = readItem(netInput);
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.id);
        netOutput.writeShort(this.items.length);
        for (StandardItemStack standardItemStack : this.items) {
            writeItem(netOutput, standardItemStack);
        }
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
