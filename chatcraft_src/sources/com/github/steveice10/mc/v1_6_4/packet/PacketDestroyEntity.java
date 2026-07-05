package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketDestroyEntity extends Packet {
    public int[] entityIds;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 29;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketDestroyEntity() {
    }

    public PacketDestroyEntity(int... iArr) {
        this.entityIds = iArr;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityIds = new int[netInput.readByte()];
        for (int i = 0; i < this.entityIds.length; i++) {
            this.entityIds[i] = netInput.readInt();
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.entityIds.length);
        for (int i : this.entityIds) {
            netOutput.writeInt(i);
        }
    }
}
