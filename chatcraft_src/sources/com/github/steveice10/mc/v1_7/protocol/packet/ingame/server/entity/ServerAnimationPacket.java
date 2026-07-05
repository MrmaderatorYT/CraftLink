package com.github.steveice10.mc.v1_7.protocol.packet.ingame.server.entity;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerAnimationPacket implements Packet {
    private Animation animation;
    private int entityId;

    public enum Animation {
        SWING_ARM,
        DAMAGE,
        LEAVE_BED,
        EAT_FOOD,
        CRITICAL_HIT,
        ENCHANTMENT_CRITICAL_HIT
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerAnimationPacket() {
    }

    public ServerAnimationPacket(int i, Animation animation) {
        this.entityId = i;
        this.animation = animation;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public Animation getAnimation() {
        return this.animation;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readVarInt();
        this.animation = Animation.values()[netInput.readByte()];
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityId);
        netOutput.writeByte(this.animation.ordinal());
    }
}
