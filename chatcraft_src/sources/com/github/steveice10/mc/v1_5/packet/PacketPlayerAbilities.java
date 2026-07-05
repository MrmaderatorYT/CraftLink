package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import com.github.steveice10.mc.v1_5.util.Util;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketPlayerAbilities extends Packet {
    public boolean canFly;
    public boolean creative;
    public byte flySpeed;
    public boolean flying;
    public boolean god;
    public byte walkSpeed;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 202;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketPlayerAbilities() {
    }

    public PacketPlayerAbilities(boolean z, boolean z2, boolean z3, boolean z4, byte b2, byte b3) {
        this.god = z;
        this.flying = z2;
        this.canFly = z3;
        this.creative = z4;
        this.flySpeed = b2;
        this.walkSpeed = b3;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) throws IOException {
        byte b2 = dataInputStream.readByte();
        this.god = Util.getBit(b2, 1);
        this.flying = Util.getBit(b2, 2);
        this.canFly = Util.getBit(b2, 4);
        this.creative = Util.getBit(b2, 8);
        this.flySpeed = dataInputStream.readByte();
        this.walkSpeed = dataInputStream.readByte();
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(Util.setBit(Util.setBit(Util.setBit(Util.setBit((byte) 0, 1, this.god), 2, this.flying), 4, this.canFly), 8, this.creative));
        dataOutputStream.writeByte(this.flySpeed);
        dataOutputStream.writeByte(this.walkSpeed);
    }
}
