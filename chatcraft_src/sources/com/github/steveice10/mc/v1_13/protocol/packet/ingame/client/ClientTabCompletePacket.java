package com.github.steveice10.mc.v1_13.protocol.packet.ingame.client;

import com.github.steveice10.mc.common.MinecraftPacket;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class ClientTabCompletePacket extends MinecraftPacket {
    private String text;
    private int transactionId;

    private ClientTabCompletePacket() {
    }

    public ClientTabCompletePacket(int i, String str) {
        this.transactionId = i;
        this.text = str;
    }

    public int getTransactionId() {
        return this.transactionId;
    }

    public String getText() {
        return this.text;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.transactionId = netInput.readVarInt();
        this.text = netInput.readString();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.transactionId);
        netOutput.writeString(this.text);
    }
}
