package com.github.steveice10.mc.v1_9.protocol.packet.ingame.server;

import com.github.steveice10.mc.v1_9.protocol.data.message.Message;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerDisconnectPacket implements Packet {
    private Message message;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return true;
    }

    private ServerDisconnectPacket() {
    }

    public ServerDisconnectPacket(String str) {
        this(Message.fromString(str));
    }

    public ServerDisconnectPacket(Message message) {
        this.message = message;
    }

    public Message getReason() {
        return this.message;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.message = Message.fromString(netInput.readString());
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.message.toJsonString());
    }
}
