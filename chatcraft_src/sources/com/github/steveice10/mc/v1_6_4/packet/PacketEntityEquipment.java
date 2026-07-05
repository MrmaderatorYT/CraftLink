package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.data.StandardItemStack;
import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketEntityEquipment extends Packet {
    public int entityId;
    public StandardItemStack item;
    public short slot;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 5;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketEntityEquipment() {
    }

    public PacketEntityEquipment(int i, short s, StandardItemStack standardItemStack) {
        this.entityId = i;
        this.slot = s;
        this.item = standardItemStack;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public short getSlot() {
        return this.slot;
    }

    public StandardItemStack getItem() {
        return this.item;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readInt();
        this.slot = netInput.readShort();
        this.item = readItem(netInput);
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.entityId);
        netOutput.writeShort(this.slot);
        writeItem(netOutput, this.item);
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
