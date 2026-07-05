package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketUseEntity extends Packet {
    public boolean leftclick;
    public int target;
    public int user;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 7;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketUseEntity() {
    }

    public PacketUseEntity(int i, int i2, boolean z) {
        this.user = i;
        this.target = i2;
        this.leftclick = z;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.user = dataInputStream.readInt();
        this.target = dataInputStream.readInt();
        this.leftclick = dataInputStream.readBoolean();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.user);
        dataOutputStream.writeInt(this.target);
        dataOutputStream.writeBoolean(this.leftclick);
    }
}
