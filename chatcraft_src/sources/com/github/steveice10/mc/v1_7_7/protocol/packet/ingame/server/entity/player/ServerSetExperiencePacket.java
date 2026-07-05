package com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity.player;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerSetExperiencePacket implements Packet {
    private float experience;
    private int level;
    private int totalExperience;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerSetExperiencePacket() {
    }

    public ServerSetExperiencePacket(float f, int i, int i2) {
        this.experience = f;
        this.level = i;
        this.totalExperience = i2;
    }

    public float getSlot() {
        return this.experience;
    }

    public int getLevel() {
        return this.level;
    }

    public int getTotalExperience() {
        return this.totalExperience;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.experience = netInput.readFloat();
        this.level = netInput.readShort();
        this.totalExperience = netInput.readShort();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeFloat(this.experience);
        netOutput.writeShort(this.level);
        netOutput.writeShort(this.totalExperience);
    }
}
