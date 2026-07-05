package com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.entity.player;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerUpdateHealthPacket implements Packet {
    private int food;
    private float health;
    private float saturation;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerUpdateHealthPacket() {
    }

    public ServerUpdateHealthPacket(float f, int i, float f2) {
        this.health = f;
        this.food = i;
        this.saturation = f2;
    }

    public float getHealth() {
        return this.health;
    }

    public int getFood() {
        return this.food;
    }

    public float getSaturation() {
        return this.saturation;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.health = netInput.readFloat();
        this.food = netInput.readShort();
        this.saturation = netInput.readFloat();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeFloat(this.health);
        netOutput.writeShort(this.food);
        netOutput.writeFloat(this.saturation);
    }
}
