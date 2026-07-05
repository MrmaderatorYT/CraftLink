package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketWindowProperty extends Packet {
    public byte id;
    public short prop;
    public short value;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 105;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketWindowProperty() {
    }

    public PacketWindowProperty(byte b2, short s, short s2) {
        this.id = b2;
        this.prop = s;
        this.value = s2;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.id = dataInputStream.readByte();
        this.prop = dataInputStream.readShort();
        this.value = dataInputStream.readShort();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.id);
        dataOutputStream.writeShort(this.prop);
        dataOutputStream.writeShort(this.value);
    }
}
