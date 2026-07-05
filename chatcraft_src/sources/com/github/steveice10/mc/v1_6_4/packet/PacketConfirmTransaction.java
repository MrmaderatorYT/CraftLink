package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketConfirmTransaction extends Packet {
    public short action;
    public boolean confirm;
    public byte id;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 106;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketConfirmTransaction() {
    }

    public PacketConfirmTransaction(byte b2, short s, boolean z) {
        this.id = b2;
        this.action = s;
        this.confirm = z;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.id = netInput.readByte();
        this.action = netInput.readShort();
        this.confirm = netInput.readBoolean();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.id);
        netOutput.writeShort(this.action);
        netOutput.writeBoolean(this.confirm);
    }
}
