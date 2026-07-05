package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketBlockChange extends Packet {
    public short block;
    public byte data;
    public int x;
    public int y;
    public int z;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 53;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketBlockChange() {
    }

    public PacketBlockChange(int i, int i2, int i3, short s, byte b2) {
        this.x = i;
        this.y = i2;
        this.z = i3;
        this.block = s;
        this.data = b2;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.x = netInput.readInt();
        this.y = netInput.readByte();
        this.z = netInput.readInt();
        this.block = netInput.readShort();
        this.data = netInput.readByte();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.x);
        netOutput.writeByte(this.y);
        netOutput.writeInt(this.z);
        netOutput.writeShort(this.block);
        netOutput.writeByte(this.data);
    }
}
