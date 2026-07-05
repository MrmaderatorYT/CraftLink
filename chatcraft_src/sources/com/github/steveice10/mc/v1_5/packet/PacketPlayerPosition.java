package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketPlayerPosition extends Packet {
    public boolean grounded;
    public double stance;
    public double x;
    public double y;
    public double z;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 11;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketPlayerPosition() {
    }

    public PacketPlayerPosition(double d, double d2, double d3, double d4, boolean z) {
        this.x = d;
        this.y = d2;
        this.stance = d3;
        this.z = d4;
        this.grounded = z;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.x = dataInputStream.readDouble();
        this.y = dataInputStream.readDouble();
        this.stance = dataInputStream.readDouble();
        this.z = dataInputStream.readDouble();
        this.grounded = dataInputStream.readBoolean();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeDouble(this.x);
        dataOutputStream.writeDouble(this.y);
        dataOutputStream.writeDouble(this.stance);
        dataOutputStream.writeDouble(this.z);
        dataOutputStream.writeBoolean(this.grounded);
    }
}
