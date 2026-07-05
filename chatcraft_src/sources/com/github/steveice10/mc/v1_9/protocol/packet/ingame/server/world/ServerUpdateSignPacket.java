package com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_9.protocol.data.game.entity.metadata.Position;
import com.github.steveice10.mc.v1_9.protocol.data.message.Message;
import com.github.steveice10.mc.v1_9.protocol.util.NetUtil;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerUpdateSignPacket implements Packet {
    private Message[] lines;
    private Position position;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerUpdateSignPacket() {
    }

    public ServerUpdateSignPacket(Position position, String[] strArr) {
        this(position, toMessages(strArr));
    }

    public ServerUpdateSignPacket(Position position, Message[] messageArr) {
        if (messageArr.length != 4) {
            throw new IllegalArgumentException("Lines must contain exactly 4 strings!");
        }
        this.position = position;
        this.lines = messageArr;
    }

    private static Message[] toMessages(String[] strArr) {
        Message[] messageArr = new Message[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            messageArr[i] = Message.fromString(strArr[i]);
        }
        return messageArr;
    }

    public Position getPosition() {
        return this.position;
    }

    public Message[] getLines() {
        return this.lines;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.position = NetUtil.readPosition(netInput);
        this.lines = new Message[4];
        for (int i = 0; i < this.lines.length; i++) {
            this.lines[i] = Message.fromString(netInput.readString());
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        NetUtil.writePosition(netOutput, this.position);
        for (Message message : this.lines) {
            netOutput.writeString(message.toJsonString());
        }
    }
}
