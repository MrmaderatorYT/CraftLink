package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketDestroyEntity extends Packet {
    public int[] entityIds;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 29;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketDestroyEntity() {
    }

    public PacketDestroyEntity(int... iArr) {
        this.entityIds = iArr;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.entityIds = new int[dataInputStream.readByte()];
        for (int i = 0; i < this.entityIds.length; i++) {
            this.entityIds[i] = dataInputStream.readInt();
        }
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.entityIds.length);
        for (int i : this.entityIds) {
            dataOutputStream.writeInt(i);
        }
    }
}
