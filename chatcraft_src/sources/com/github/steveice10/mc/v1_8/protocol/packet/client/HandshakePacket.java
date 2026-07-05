package com.github.steveice10.mc.v1_8.protocol.packet.client;

import com.github.steveice10.mc.v1_8.protocol.data.game.values.HandshakeIntent;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.MagicValues;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public class HandshakePacket implements Packet {
    private String hostname;
    private HandshakeIntent intent;
    private boolean isFML = false;
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
        StringBuilder sb = new StringBuilder();
        sb.append(this.hostname);
        sb.append(this.isFML ? "\u0000FML\u0000" : BuildConfig.FLAVOR);
        netOutput.writeString(sb.toString());
        netOutput.writeShort(this.port);
        netOutput.writeVarInt(((Integer) MagicValues.value(Integer.class, this.intent)).intValue());
    }

    public boolean isFML() {
        return this.isFML;
    }
}
