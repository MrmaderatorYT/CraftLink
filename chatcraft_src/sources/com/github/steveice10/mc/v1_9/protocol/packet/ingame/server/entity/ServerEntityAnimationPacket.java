package com.github.steveice10.mc.v1_9.protocol.packet.ingame.server.entity;

import com.github.steveice10.mc.v1_9.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9.protocol.data.game.entity.player.Animation;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerEntityAnimationPacket implements Packet {
    private Animation animation;
    private int entityId;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerEntityAnimationPacket() {
    }

    public ServerEntityAnimationPacket(int i, Animation animation) {
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
        this.animation = (Animation) MagicValues.key(Animation.class, Integer.valueOf(netInput.readUnsignedByte()));
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityId);
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.animation)).intValue());
    }
}
