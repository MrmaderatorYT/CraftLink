package com.github.steveice10.mc.v1_9_2.protocol.packet.handshake.client;

import com.github.steveice10.mc.v1_9_2.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9_2.protocol.data.handshake.HandshakeIntent;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class HandshakePacket implements Packet {
    private String hostname;
    private HandshakeIntent intent;
    private int port;
    private int protocolVersion;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return true;
    }

    private HandshakePacket() {
    }

    public HandshakePacket(int i, String str, int i2, HandshakeIntent handshakeIntent) {
        this.protocolVersion = i;
        this.hostname = str;
        this.port = i2;
        this.intent = handshakeIntent;
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

    public HandshakeIntent getIntent() {
        return this.intent;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.protocolVersion = netInput.readVarInt();
        this.hostname = netInput.readString();
        this.port = netInput.readUnsignedShort();
        this.intent = (HandshakeIntent) MagicValues.key(HandshakeIntent.class, Integer.valueOf(netInput.readVarInt()));
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.protocolVersion);
        netOutput.writeString(this.hostname);
        netOutput.writeShort(this.port);
        netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.intent)).intValue());
    }
}
