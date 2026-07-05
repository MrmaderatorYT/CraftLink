package com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerEntityEffectPacket implements Packet {
    private int amplifier;
    private int duration;
    private Effect effect;
    private int entityId;

    public enum Effect {
        SPEED,
        SLOWNESS,
        DIG_SPEED,
        DIG_SLOWNESS,
        DAMAGE_BOOST,
        HEAL,
        DAMAGE,
        ENHANCED_JUMP,
        CONFUSION,
        REGENERATION,
        RESISTANCE,
        FIRE_RESISTANCE,
        WATER_BREATHING,
        INVISIBILITY,
        BLINDNESS,
        NIGHT_VISION,
        HUNGER,
        WEAKNESS,
        POISON,
        WITHER_EFFECT,
        HEALTH_BOOST,
        ABSORPTION,
        SATURATION
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerEntityEffectPacket() {
    }

    public ServerEntityEffectPacket(int i, Effect effect, int i2, int i3) {
        this.entityId = i;
        this.effect = effect;
        this.amplifier = i2;
        this.duration = i3;
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

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readInt();
        this.effect = Effect.values()[netInput.readByte() - 1];
        this.amplifier = netInput.readByte();
        this.duration = netInput.readShort();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.entityId);
        netOutput.writeByte(this.effect.ordinal() + 1);
        netOutput.writeByte(this.amplifier);
        netOutput.writeShort(this.duration);
    }
}
