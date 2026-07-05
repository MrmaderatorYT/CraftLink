package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketBlockAction extends Packet {
    public byte b1;
    public byte b2;
    public int block;
    public int x;
    public int y;
    public int z;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 54;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketBlockAction() {
    }

    public PacketBlockAction(int i, int i2, int i3, byte b2, byte b3, short s) {
        this.x = i;
        this.y = i2;
        this.z = i3;
        this.b1 = b2;
        this.b2 = b3;
        this.block = s;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.x = netInput.readInt();
        this.y = netInput.readShort();
        this.z = netInput.readInt();
        this.b1 = netInput.readByte();
        this.b2 = netInput.readByte();
        this.block = netInput.readUnsignedShort();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.x);
        netOutput.writeShort(this.y);
        netOutput.writeInt(this.z);
        netOutput.writeByte(this.b1);
        netOutput.writeByte(this.b2);
        netOutput.writeShort(this.block);
    }
}
