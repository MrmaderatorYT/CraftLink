package com.github.steveice10.mc.v1_9_2.protocol.packet.ingame.server.entity;

import com.github.steveice10.mc.v1_9_2.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9_2.protocol.data.game.entity.Effect;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerEntityEffectPacket implements Packet {
    private boolean ambient;
    private int amplifier;
    private int duration;
    private Effect effect;
    private int entityId;
    private boolean showParticles;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerEntityEffectPacket() {
    }

    public ServerEntityEffectPacket(int i, Effect effect, int i2, int i3, boolean z, boolean z2) {
        this.entityId = i;
        this.effect = effect;
        this.amplifier = i2;
        this.duration = i3;
        this.ambient = z;
        this.showParticles = z2;
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

    public boolean isAmbient() {
        return this.ambient;
    }

    public boolean getShowParticles() {
        return this.showParticles;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.entityId = netInput.readVarInt();
        try {
            this.effect = (Effect) MagicValues.key(Effect.class, Byte.valueOf(netInput.readByte()));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.amplifier = netInput.readByte();
        this.duration = netInput.readVarInt();
        byte b2 = netInput.readByte();
        this.ambient = (b2 & 1) == 1;
        this.showParticles = (b2 & 2) == 2;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeVarInt(this.entityId);
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.effect)).intValue());
        netOutput.writeByte(this.amplifier);
        netOutput.writeVarInt(this.duration);
        int i = this.ambient ? 1 : 0;
        if (this.showParticles) {
            i |= 2;
        }
        netOutput.writeByte(i);
    }
}
