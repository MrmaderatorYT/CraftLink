package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketSpawnPainting extends Packet {
    public int direction;
    public int entityId;
    public String title;
    public int x;
    public int y;
    public int z;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 25;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketSpawnPainting() {
    }

    public PacketSpawnPainting(int i, String str, int i2, int i3, int i4, int i5) {
        this.entityId = i;
        this.title = str;
        this.x = i2;
        this.y = i3;
        this.z = i4;
        this.direction = i5;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readInt();
        this.title = netInput.readString();
        this.x = netInput.readInt();
        this.y = netInput.readInt();
        this.z = netInput.readInt();
        this.direction = netInput.readInt();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.entityId);
        netOutput.writeString(this.title);
        netOutput.writeInt(this.x);
        netOutput.writeInt(this.y);
        netOutput.writeInt(this.z);
        netOutput.writeInt(this.direction);
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
