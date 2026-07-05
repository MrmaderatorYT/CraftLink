package com.github.steveice10.mc.v1_8.protocol.packet.ingame.client;

import com.github.steveice10.mc.v1_8.protocol.data.game.Position;
import com.github.steveice10.mc.v1_8.protocol.util.v1_8.NetUtil;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientTabCompletePacket implements Packet {
    private Position position;
    private String text;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientTabCompletePacket() {
    }

    public ClientTabCompletePacket(String str) {
        this(str, null);
    }

    public ClientTabCompletePacket(String str, Position position) {
        this.text = str;
        this.position = position;
    }

    public String getText() {
        return this.text;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.text = netInput.readString();
        this.position = netInput.readBoolean() ? NetUtil.readPosition(netInput) : null;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.text);
        netOutput.writeBoolean(this.position != null);
        if (this.position != null) {
            NetUtil.writePosition(netOutput, this.position);
        }
    }
}
