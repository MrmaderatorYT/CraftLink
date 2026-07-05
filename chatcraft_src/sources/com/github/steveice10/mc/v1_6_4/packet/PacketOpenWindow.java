package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketOpenWindow extends Packet {
    public int horseId;
    public byte id;
    public String name;
    public byte slots;
    public byte type;
    public boolean useTitle;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 100;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketOpenWindow() {
    }

    public PacketOpenWindow(byte b2, byte b3, String str, byte b4, boolean z) {
        this(b2, b3, str, b4, z, 0);
    }

    public PacketOpenWindow(byte b2, byte b3, String str, byte b4, boolean z, int i) {
        this.id = b2;
        this.type = b3;
        this.name = str;
        this.slots = b4;
        this.useTitle = z;
        this.horseId = i;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.id = netInput.readByte();
        this.type = netInput.readByte();
        this.name = netInput.readString();
        this.slots = netInput.readByte();
        this.useTitle = netInput.readBoolean();
        if (this.type == 11) {
            this.horseId = netInput.readInt();
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.id);
        netOutput.writeByte(this.type);
        netOutput.writeString(this.name);
        netOutput.writeByte(this.slots);
        netOutput.writeBoolean(this.useTitle);
        if (this.type == 11) {
            netOutput.writeInt(this.horseId);
        }
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
