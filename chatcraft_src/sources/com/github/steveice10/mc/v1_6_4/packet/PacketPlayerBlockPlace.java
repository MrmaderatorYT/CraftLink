package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.data.StandardItemStack;
import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketPlayerBlockPlace extends Packet {
    public byte cursorX;
    public byte cursorY;
    public byte cursorZ;
    public byte direction;
    public StandardItemStack item;
    public byte[] nbt;
    public int x;
    public int y;
    public int z;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 15;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketPlayerBlockPlace() {
    }

    public PacketPlayerBlockPlace(int i, int i2, int i3, byte b2, StandardItemStack standardItemStack, byte b3, byte b4, byte b5) {
        this.x = i;
        this.y = i2;
        this.z = i3;
        this.direction = b2;
        this.item = standardItemStack;
        this.cursorX = b3;
        this.cursorY = b4;
        this.cursorZ = b5;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.x = netInput.readInt();
        this.y = netInput.readUnsignedByte();
        this.z = netInput.readInt();
        this.direction = netInput.readByte();
        this.item = readItem(netInput);
        this.cursorX = netInput.readByte();
        this.cursorY = netInput.readByte();
        this.cursorZ = netInput.readByte();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.x);
        netOutput.writeByte(this.y);
        netOutput.writeInt(this.z);
        netOutput.writeByte(this.direction);
        if (this.item != null) {
            writeItem(netOutput, this.item);
        }
        netOutput.writeByte(this.cursorX);
        netOutput.writeByte(this.cursorY);
        netOutput.writeByte(this.cursorZ);
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
