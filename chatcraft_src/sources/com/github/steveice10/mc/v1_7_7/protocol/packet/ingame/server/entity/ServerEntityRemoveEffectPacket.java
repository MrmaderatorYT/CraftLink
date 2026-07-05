package com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.server.entity;

import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerEntityRemoveEffectPacket implements Packet {
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
        this.entityId = netInput.readInt();
        this.effect = Effect.values()[netInput.readByte() - 1];
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeInt(this.entityId);
        netOutput.writeByte(this.effect.ordinal() + 1);
    }
}
