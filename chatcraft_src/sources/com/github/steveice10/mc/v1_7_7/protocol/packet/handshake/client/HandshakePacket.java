package com.github.steveice10.mc.v1_7_7.protocol.packet.handshake.client;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class HandshakePacket implements Packet {
    private String hostname;
    private int intent;
    private int port;
    private int protocolVersion;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return true;
    }

    private HandshakePacket() {
    }

    public HandshakePacket(int i, String str, int i2, int i3) {
        this.protocolVersion = i;
        this.hostname = str;
        this.port = i2;
        this.intent = i3;
    }

    public int getProtocolVersion() {
        return this.protocolVersion;
    }

    public String getHostName() {
        return this.hostname;
    }

    public int getPort() {
        return this.port;
    }

    public int getIntent() {
        return this.intent;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.protocolVersion = netInput.readVarInt();
        this.hostname = netInput.readString();
        this.port = netInput.readUnsignedShort();
        this.intent = netInput.readVarInt();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.protocolVersion);
        netOutput.writeString(this.hostname);
        netOutput.writeShort(this.port);
        netOutput.writeVarInt(this.intent);
    }
}
