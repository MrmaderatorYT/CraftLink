package com.github.steveice10.mc.v1_9_2.protocol.packet.ingame.client;

import com.github.steveice10.mc.v1_9_2.protocol.data.game.entity.metadata.Position;
import com.github.steveice10.mc.v1_9_2.protocol.util.NetUtil;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientTabCompletePacket implements Packet {
    private boolean assumeCommand;
    private Position lookingAt;
    private String text;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientTabCompletePacket() {
    }

    public ClientTabCompletePacket(String str, boolean z) {
        this(str, z, null);
    }

    public ClientTabCompletePacket(String str, boolean z, Position position) {
        this.text = str;
        this.assumeCommand = z;
        this.lookingAt = position;
    }

    public String getText() {
        return this.text;
    }

    public boolean getAssumeCommand() {
        return this.assumeCommand;
    }

    public Position getLookingAt() {
        return this.lookingAt;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.text = netInput.readString();
        this.assumeCommand = netInput.readBoolean();
        this.lookingAt = netInput.readBoolean() ? NetUtil.readPosition(netInput) : null;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.text);
        netOutput.writeBoolean(this.assumeCommand);
        netOutput.writeBoolean(this.lookingAt != null);
        if (this.lookingAt != null) {
            NetUtil.writePosition(netOutput, this.lookingAt);
        }
    }
}
