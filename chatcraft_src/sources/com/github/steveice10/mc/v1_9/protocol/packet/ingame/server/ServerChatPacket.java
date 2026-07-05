package com.github.steveice10.mc.v1_9.protocol.packet.ingame.server;

import com.github.steveice10.mc.v1_9.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9.protocol.data.game.MessageType;
import com.github.steveice10.mc.v1_9.protocol.data.message.Message;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerChatPacket implements Packet {
    private Message message;
    private MessageType type;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerChatPacket() {
    }

    public ServerChatPacket(String str) {
        this(Message.fromString(str));
    }

    public ServerChatPacket(Message message) {
        this(message, MessageType.SYSTEM);
    }

    public ServerChatPacket(String str, MessageType messageType) {
        this(Message.fromString(str), messageType);
    }

    public ServerChatPacket(Message message, MessageType messageType) {
        this.message = message;
        this.type = messageType;
    }

    public Message getMessage() {
        return this.message;
    }

    public MessageType getType() {
        return this.type;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.message = Message.fromString(netInput.readString());
        this.type = (MessageType) MagicValues.key(MessageType.class, Byte.valueOf(netInput.readByte()));
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.message.toJsonString());
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.type)).intValue());
    }
}
