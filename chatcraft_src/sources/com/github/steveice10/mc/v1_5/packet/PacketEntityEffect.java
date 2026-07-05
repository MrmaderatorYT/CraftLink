package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketEntityEffect extends Packet {
    public byte amplifier;
    public short duration;
    public byte effect;
    public int entityId;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 41;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketEntityEffect() {
    }

    public PacketEntityEffect(int i, byte b2, byte b3, short s) {
        this.entityId = i;
        this.effect = b2;
        this.amplifier = b3;
        this.duration = s;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.entityId = dataInputStream.readInt();
        this.effect = dataInputStream.readByte();
        this.amplifier = dataInputStream.readByte();
        this.duration = dataInputStream.readShort();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityId);
        dataOutputStream.writeByte(this.effect);
        dataOutputStream.writeByte(this.amplifier);
        dataOutputStream.writeShort(this.duration);
    }
}
