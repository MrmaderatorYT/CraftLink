package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketSetExperience extends Packet {
    public short experience;
    public float experienceBar;
    public short level;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 43;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketSetExperience() {
    }

    public PacketSetExperience(float f, short s, short s2) {
        this.experienceBar = f;
        this.level = s;
        this.experience = s2;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.experienceBar = dataInputStream.readFloat();
        this.level = dataInputStream.readShort();
        this.experience = dataInputStream.readShort();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeFloat(this.experienceBar);
        dataOutputStream.writeShort(this.level);
        dataOutputStream.writeShort(this.experience);
    }
}
