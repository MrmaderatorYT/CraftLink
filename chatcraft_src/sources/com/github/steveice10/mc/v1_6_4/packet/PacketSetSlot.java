package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.data.StandardItemStack;
import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketSetSlot extends Packet {
    public byte id;
    public StandardItemStack item;
    public short slot;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 103;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketSetSlot() {
    }

    public PacketSetSlot(byte b2, short s, StandardItemStack standardItemStack) {
        this.id = b2;
        this.slot = s;
        this.item = standardItemStack;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.id = netInput.readByte();
        this.slot = netInput.readShort();
        this.item = readItem(netInput);
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.id);
        netOutput.writeShort(this.slot);
        if (this.item != null) {
            writeItem(netOutput, this.item);
        }
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
