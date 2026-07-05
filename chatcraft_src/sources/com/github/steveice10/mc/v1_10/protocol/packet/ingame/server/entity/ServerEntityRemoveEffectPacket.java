package com.github.steveice10.mc.v1_10.protocol.packet.ingame.server.entity;

import com.github.steveice10.mc.v1_10.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_10.protocol.data.game.entity.Effect;
import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerEntityRemoveEffectPacket implements Packet {
    private Effect effect;
    private int entityId;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerEntityRemoveEffectPacket() {
    }

    public ServerEntityRemoveEffectPacket(int i, Effect effect) {
        this.entityId = i;
        this.effect = effect;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public Effect getEffect() {
        return this.effect;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readVarInt();
        this.effect = (Effect) MagicValues.key(Effect.class, Integer.valueOf(netInput.readUnsignedByte()));
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityId);
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.effect)).intValue());
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
