package com.github.steveice10.mc.v1_8.protocol.packet.login.server;

import com.github.steveice10.mc.v1_8.protocol.data.message.Message;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class LoginDisconnectPacket implements Packet {
    private Message message;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return true;
    }

    private LoginDisconnectPacket() {
    }

    public LoginDisconnectPacket(String str) {
        this(Message.fromString(str));
    }

    public LoginDisconnectPacket(Message message) {
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
