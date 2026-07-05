package com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.player;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientPlayerAnimationPacket implements Packet {
    private Animation animation;
    private int entityId;

    public enum Animation {
        SWING_ARM
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientPlayerAnimationPacket() {
    }

    public ClientPlayerAnimationPacket(int i, Animation animation) {
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
        this.entityId = netInput.readInt();
        this.animation = Animation.values()[netInput.readByte() - 1];
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.entityId);
        netOutput.writeByte(this.animation.ordinal() + 1);
    }
}
