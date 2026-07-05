package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.data.StandardItemStack;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketCreativeSlot extends Packet {
    public StandardItemStack clicked;
    public short slot;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 107;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketCreativeSlot() {
    }

    public PacketCreativeSlot(short s, StandardItemStack standardItemStack) {
        this.slot = s;
        this.clicked = standardItemStack;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.slot = netInput.readShort();
        this.clicked = readItem(netInput);
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeShort(this.slot);
        if (this.clicked != null) {
            writeItem(netOutput, this.clicked);
        }
    }
}
