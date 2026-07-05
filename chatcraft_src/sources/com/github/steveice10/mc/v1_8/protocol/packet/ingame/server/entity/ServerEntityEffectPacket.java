package com.github.steveice10.mc.v1_8.protocol.packet.ingame.server.entity;

import com.github.steveice10.mc.v1_8.protocol.data.game.values.MagicValues;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.entity.Effect;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerEntityEffectPacket implements Packet {
    private int amplifier;
    private int duration;
    private Effect effect;
    private int entityId;
    private boolean hideParticles;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerEntityEffectPacket() {
    }

    public ServerEntityEffectPacket(int i, Effect effect, int i2, int i3, boolean z) {
        this.entityId = i;
        this.effect = effect;
        this.amplifier = i2;
        this.duration = i3;
        this.hideParticles = z;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public Effect getEffect() {
        return this.effect;
    }

    public int getAmplifier() {
        return this.amplifier;
    }

    public int getDuration() {
        return this.duration;
    }

    public boolean getHideParticles() {
        return this.hideParticles;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readVarInt();
        this.effect = (Effect) MagicValues.key(Effect.class, Byte.valueOf(netInput.readByte()));
        this.amplifier = netInput.readByte();
        this.duration = netInput.readVarInt();
        this.hideParticles = netInput.readBoolean();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityId);
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.effect)).intValue());
        netOutput.writeByte(this.amplifier);
        netOutput.writeVarInt(this.duration);
        netOutput.writeBoolean(this.hideParticles);
    }
}
