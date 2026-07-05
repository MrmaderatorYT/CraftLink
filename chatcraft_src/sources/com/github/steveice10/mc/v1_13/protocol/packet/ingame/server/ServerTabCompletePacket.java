package com.github.steveice10.mc.v1_13.protocol.packet.ingame.server;

import com.github.steveice10.mc.common.MinecraftPacket;
import com.github.steveice10.mc.v1_10.protocol.data.message.Message;
import com.github.steveice10.mc.v1_10.protocol.data.message.TextMessage;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class ServerTabCompletePacket extends MinecraftPacket {
    private int length;
    private String[] matches;
    private int start;
    private Message[] tooltips;
    private int transactionId;

    private ServerTabCompletePacket() {
    }

    public ServerTabCompletePacket(int i, int i2, int i3, String[] strArr, Message[] messageArr) {
        if (messageArr.length != strArr.length) {
            throw new IllegalArgumentException("Length of matches and tooltips must be equal.");
        }
        this.transactionId = i;
        this.start = i2;
        this.length = i3;
        this.matches = strArr;
        this.tooltips = messageArr;
    }

    public int getTransactionId() {
        return this.transactionId;
    }

    public int getStart() {
        return this.start;
    }

    public int getLength() {
        return this.length;
    }

    public String[] getMatches() {
        return this.matches;
    }

    public Message[] getTooltips() {
        return this.tooltips;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.transactionId = netInput.readVarInt();
        this.start = netInput.readVarInt();
        this.length = netInput.readVarInt();
        this.matches = new String[netInput.readVarInt()];
        this.tooltips = new TextMessage[this.matches.length];
        for (int i = 0; i < this.matches.length; i++) {
            this.matches[i] = netInput.readString();
            if (netInput.readBoolean()) {
                this.tooltips[i] = Message.fromString(netInput.readString());
            }
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.transactionId);
        netOutput.writeVarInt(this.start);
        netOutput.writeVarInt(this.length);
        netOutput.writeVarInt(this.matches.length);
        for (int i = 0; i < this.matches.length; i++) {
            netOutput.writeString(this.matches[i]);
            Message message = this.tooltips[i];
            if (message != null) {
                netOutput.writeBoolean(true);
                netOutput.writeString(message.toJsonString());
            } else {
                netOutput.writeBoolean(false);
            }
        }
    }
}
