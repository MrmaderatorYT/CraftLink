package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.data.message.Message;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketServerChat extends Packet {
    private Message message;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 3;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet, com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private PacketServerChat() {
    }

    public PacketServerChat(String str) {
        this(Message.fromString(str));
    }

    public PacketServerChat(Message message) {
        this.message = message;
    }

    public Message getMessage() {
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
