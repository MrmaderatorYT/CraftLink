package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.data.ItemStack;
import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketCreativeSlot extends Packet {
    public ItemStack clicked;
    public short slot;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 107;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketCreativeSlot() {
    }

    public PacketCreativeSlot(short s, ItemStack itemStack) {
        this.slot = s;
        this.clicked = itemStack;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) throws IOException {
        this.slot = dataInputStream.readShort();
        this.clicked = new ItemStack();
        this.clicked.read(dataInputStream);
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.slot);
        if (this.clicked != null) {
            this.clicked.write(dataOutputStream);
        }
    }
}
