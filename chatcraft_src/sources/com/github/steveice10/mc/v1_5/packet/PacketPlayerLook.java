package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketPlayerLook extends Packet {
    public boolean grounded;
    public float pitch;
    public float yaw;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 12;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketPlayerLook() {
    }

    public PacketPlayerLook(float f, float f2, boolean z) {
        this.yaw = f;
        this.pitch = f2;
        this.grounded = z;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.yaw = dataInputStream.readFloat();
        this.pitch = dataInputStream.readFloat();
        this.grounded = dataInputStream.readBoolean();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeFloat(this.yaw);
        dataOutputStream.writeFloat(this.pitch);
        dataOutputStream.writeBoolean(this.grounded);
    }
}
