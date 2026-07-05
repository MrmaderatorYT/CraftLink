package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketAttachEntity extends Packet {
    public int entityId;
    public boolean leash;
    public int vehicleId;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 39;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketAttachEntity() {
    }

    public PacketAttachEntity(int i, int i2, boolean z) {
        this.entityId = i;
        this.vehicleId = i2;
        this.leash = z;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readInt();
        this.vehicleId = netInput.readInt();
        this.leash = netInput.readBoolean();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.entityId);
        netOutput.writeInt(this.vehicleId);
        netOutput.writeBoolean(this.leash);
    }
}
