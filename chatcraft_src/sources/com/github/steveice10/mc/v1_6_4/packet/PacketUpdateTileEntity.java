package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketUpdateTileEntity extends Packet {
    public byte action;
    public byte[] nbt;
    public int x;
    public short y;
    public int z;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 132;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketUpdateTileEntity() {
    }

    public PacketUpdateTileEntity(int i, short s, int i2, byte b2, byte[] bArr) {
        this.x = i;
        this.y = s;
        this.z = i2;
        this.action = b2;
        this.nbt = bArr;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.x = netInput.readInt();
        this.y = netInput.readShort();
        this.z = netInput.readInt();
        this.action = netInput.readByte();
        this.nbt = netInput.readBytes(netInput.readShort());
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.x);
        netOutput.writeShort(this.y);
        netOutput.writeInt(this.z);
        netOutput.writeByte(this.action);
        if (this.nbt != null) {
            netOutput.writeShort(this.nbt.length);
            netOutput.writeBytes(this.nbt);
        }
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
