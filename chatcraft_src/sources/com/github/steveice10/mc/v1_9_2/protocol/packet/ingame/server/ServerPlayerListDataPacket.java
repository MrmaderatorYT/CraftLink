package com.github.steveice10.mc.v1_9_2.protocol.packet.ingame.server;

import com.github.steveice10.mc.v1_9_2.protocol.data.message.Message;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerPlayerListDataPacket implements Packet {
    private Message footer;
    private Message header;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerPlayerListDataPacket() {
    }

    public ServerPlayerListDataPacket(Message message, Message message2) {
        this.header = message;
        this.footer = message2;
    }

    public Message getHeader() {
        return this.header;
    }

    public Message getFooter() {
        return this.footer;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.header = Message.fromString(netInput.readString());
        this.footer = Message.fromString(netInput.readString());
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.header.toJsonString());
        netOutput.writeString(this.footer.toJsonString());
    }
}
