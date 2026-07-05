package com.github.steveice10.mc.v1_9_2.protocol.packet.ingame.client;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientPluginMessagePacket implements Packet {
    private String channel;
    private byte[] data;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientPluginMessagePacket() {
    }

    public ClientPluginMessagePacket(String str, byte[] bArr) {
        this.channel = str;
        this.data = bArr;
    }

    public String getChannel() {
        return this.channel;
    }

    public byte[] getData() {
        return this.data;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.channel = netInput.readString();
        this.data = netInput.readBytes(netInput.available());
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.channel);
        netOutput.writeBytes(this.data);
    }
}
