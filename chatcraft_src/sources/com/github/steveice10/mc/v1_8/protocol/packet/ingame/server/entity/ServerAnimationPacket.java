package com.github.steveice10.mc.v1_8.protocol.packet.ingame.server.entity;

import com.github.steveice10.mc.v1_8.protocol.data.game.values.MagicValues;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.entity.player.Animation;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerAnimationPacket implements Packet {
    private Animation animation;
    private int entityId;

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
        this.animation = (Animation) MagicValues.key(Animation.class, Byte.valueOf(netInput.readByte()));
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityId);
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.animation)).intValue());
    }
}
