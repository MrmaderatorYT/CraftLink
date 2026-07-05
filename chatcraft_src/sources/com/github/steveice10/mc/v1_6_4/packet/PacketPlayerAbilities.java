package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.event.PacketVisitor;
import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketPlayerAbilities extends Packet {
    public boolean canFly;
    public boolean creative;
    public float flySpeed;
    public boolean flying;
    public boolean god;
    public float walkSpeed;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 202;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketPlayerAbilities() {
    }

    public PacketPlayerAbilities(boolean z, boolean z2, boolean z3, boolean z4, float f, float f2) {
        this.god = z;
        this.flying = z2;
        this.canFly = z3;
        this.creative = z4;
        this.flySpeed = f;
        this.walkSpeed = f2;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        byte b2 = netInput.readByte();
        this.god = getBit(b2, 1);
        this.flying = getBit(b2, 2);
        this.canFly = getBit(b2, 4);
        this.creative = getBit(b2, 8);
        this.flySpeed = netInput.readFloat();
        this.walkSpeed = netInput.readFloat();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(setBit(setBit(setBit(setBit((byte) 0, 1, this.god), 2, this.flying), 4, this.canFly), 8, this.creative));
        netOutput.writeFloat(this.flySpeed);
        netOutput.writeFloat(this.walkSpeed);
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void accept(PacketVisitor packetVisitor) {
        packetVisitor.visit(this);
    }
}
