package com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientRequestPacket implements Packet {
    private Request request;

    public enum Request {
        RESPAWN,
        STATS,
        OPEN_INVENTORY_ACHIEVEMENT
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientRequestPacket() {
    }

    public ClientRequestPacket(Request request) {
        this.request = request;
    }

    public Request getRequest() {
        return this.request;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.request = Request.values()[netInput.readByte()];
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.request.ordinal());
    }
}
