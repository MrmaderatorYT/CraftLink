package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.data.StandardItemStack;
import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketWindowClick extends Packet {
    public short action;
    public StandardItemStack clicked;
    public byte id;
    public byte mousebutton;
    public boolean shift;
    public short slot;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 102;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketWindowClick() {
    }

    public PacketWindowClick(byte b2, short s, byte b3, short s2, boolean z, StandardItemStack standardItemStack) {
        this.id = b2;
        this.slot = s;
        this.mousebutton = b3;
        this.action = s2;
        this.shift = z;
        this.clicked = standardItemStack;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.id = netInput.readByte();
        this.slot = netInput.readShort();
        this.mousebutton = netInput.readByte();
        this.action = netInput.readShort();
        this.shift = netInput.readBoolean();
        this.clicked = readItem(netInput);
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.id);
        netOutput.writeShort(this.slot);
        netOutput.writeByte(this.mousebutton);
        netOutput.writeShort(this.action);
        netOutput.writeBoolean(this.shift);
        if (this.clicked != null) {
            writeItem(netOutput, this.clicked);
        }
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
