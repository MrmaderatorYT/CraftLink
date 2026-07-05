package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketMultiBlockChange extends Packet {
    public byte[] data;
    public int records;
    public int x;
    public int z;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 52;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketMultiBlockChange() {
    }

    public PacketMultiBlockChange(int i, int i2, int i3, byte[] bArr) {
        this.x = i;
        this.z = i2;
        this.records = i3;
        this.data = bArr;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.x = netInput.readInt();
        this.z = netInput.readInt();
        this.records = netInput.readShort() & 65535;
        int i = netInput.readInt();
        if (i > 0) {
            this.data = netInput.readBytes(i);
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.x);
        netOutput.writeInt(this.z);
        netOutput.writeShort((short) this.records);
        if (this.data != null) {
            netOutput.writeInt(this.data.length);
            netOutput.writeBytes(this.data);
        } else {
            netOutput.writeInt(0);
        }
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
