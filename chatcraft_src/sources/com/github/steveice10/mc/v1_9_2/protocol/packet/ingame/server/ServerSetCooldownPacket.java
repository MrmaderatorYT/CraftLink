package com.github.steveice10.mc.v1_9_2.protocol.packet.ingame.server;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerSetCooldownPacket implements Packet {
    private int cooldownTicks;
    private int itemId;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerSetCooldownPacket() {
    }

    public ServerSetCooldownPacket(int i, int i2) {
        this.itemId = i;
        this.cooldownTicks = i2;
    }

    public int getItemId() {
        return this.itemId;
    }

    public int getCooldownTicks() {
        return this.cooldownTicks;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.itemId = netInput.readVarInt();
        this.cooldownTicks = netInput.readVarInt();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.itemId);
        netOutput.writeVarInt(this.cooldownTicks);
    }
}
