package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketSpawnParticle extends Packet {
    public int count;
    public float offsetX;
    public float offsetY;
    public float offsetZ;
    public String particle;
    public float speed;
    public float x;
    public float y;
    public float z;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 63;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketSpawnParticle() {
    }

    public PacketSpawnParticle(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        this.particle = str;
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.speed = f7;
        this.count = i;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.particle = netInput.readString();
        this.x = netInput.readFloat();
        this.y = netInput.readFloat();
        this.z = netInput.readFloat();
        this.offsetX = netInput.readFloat();
        this.offsetY = netInput.readFloat();
        this.offsetZ = netInput.readFloat();
        this.speed = netInput.readFloat();
        this.count = netInput.readInt();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.particle);
        netOutput.writeFloat(this.x);
        netOutput.writeFloat(this.y);
        netOutput.writeFloat(this.z);
        netOutput.writeFloat(this.offsetX);
        netOutput.writeFloat(this.offsetY);
        netOutput.writeFloat(this.offsetZ);
        netOutput.writeFloat(this.speed);
        netOutput.writeInt(this.count);
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
