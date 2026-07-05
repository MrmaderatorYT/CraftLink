package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketExplosion extends Packet {
    public byte[] blocks;
    public float radius;
    public float unk1;
    public float unk2;
    public float unk3;
    public double x;
    public double y;
    public double z;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 60;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketExplosion() {
    }

    public PacketExplosion(double d, double d2, double d3, float f, byte[] bArr, float f2, float f3, float f4) {
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.radius = f;
        this.blocks = bArr;
        this.unk1 = f2;
        this.unk2 = f3;
        this.unk3 = f4;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.x = netInput.readDouble();
        this.y = netInput.readDouble();
        this.z = netInput.readDouble();
        this.radius = netInput.readFloat();
        this.blocks = netInput.readBytes(netInput.readInt() * 3);
        this.unk1 = netInput.readFloat();
        this.unk2 = netInput.readFloat();
        this.unk3 = netInput.readFloat();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeDouble(this.x);
        netOutput.writeDouble(this.y);
        netOutput.writeDouble(this.z);
        netOutput.writeFloat(this.radius);
        netOutput.writeInt(this.blocks.length / 3);
        netOutput.writeBytes(this.blocks);
        netOutput.writeFloat(this.unk1);
        netOutput.writeFloat(this.unk2);
        netOutput.writeFloat(this.unk3);
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
