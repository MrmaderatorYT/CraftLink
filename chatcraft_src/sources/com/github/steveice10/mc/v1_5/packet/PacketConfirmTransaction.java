package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketConfirmTransaction extends Packet {
    public short action;
    public boolean confirm;
    public byte id;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 106;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketConfirmTransaction() {
    }

    public PacketConfirmTransaction(byte b2, short s, boolean z) {
        this.id = b2;
        this.action = s;
        this.confirm = z;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.id = dataInputStream.readByte();
        this.action = dataInputStream.readShort();
        this.confirm = dataInputStream.readBoolean();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.id);
        dataOutputStream.writeShort(this.action);
        dataOutputStream.writeBoolean(this.confirm);
    }
}
