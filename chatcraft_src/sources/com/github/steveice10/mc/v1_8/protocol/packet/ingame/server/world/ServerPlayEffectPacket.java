package com.github.steveice10.mc.v1_8.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_8.protocol.data.game.Position;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.MagicValues;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.world.effect.BreakBlockEffectData;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.world.effect.BreakPotionEffectData;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.world.effect.HardLandingEffectData;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.world.effect.ParticleEffect;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.world.effect.RecordEffectData;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.world.effect.SmokeEffectData;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.world.effect.SoundEffect;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.world.effect.WorldEffect;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.world.effect.WorldEffectData;
import com.github.steveice10.mc.v1_8.protocol.util.v1_8.NetUtil;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ServerPlayEffectPacket implements Packet {
    private boolean broadcast;
    private WorldEffectData data;
    private WorldEffect effect;
    private Position position;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ServerPlayEffectPacket() {
    }

    public ServerPlayEffectPacket(WorldEffect worldEffect, Position position, WorldEffectData worldEffectData) {
        this(worldEffect, position, worldEffectData, false);
    }

    public ServerPlayEffectPacket(WorldEffect worldEffect, Position position, WorldEffectData worldEffectData, boolean z) {
        this.effect = worldEffect;
        this.position = position;
        this.data = worldEffectData;
        this.broadcast = z;
    }

    public WorldEffect getEffect() {
        return this.effect;
    }

    public Position getPosition() {
        return this.position;
    }

    public WorldEffectData getData() {
        return this.data;
    }

    public boolean getBroadcast() {
        return this.broadcast;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        int i = netInput.readInt();
        if (i >= 2000) {
            this.effect = (WorldEffect) MagicValues.key(ParticleEffect.class, Integer.valueOf(i));
        } else {
            this.effect = (WorldEffect) MagicValues.key(SoundEffect.class, Integer.valueOf(i));
        }
        this.position = NetUtil.readPosition(netInput);
        int i2 = netInput.readInt();
        if (this.effect == SoundEffect.PLAY_RECORD) {
            this.data = new RecordEffectData(i2);
        } else if (this.effect == ParticleEffect.SMOKE) {
            this.data = (WorldEffectData) MagicValues.key(SmokeEffectData.class, Integer.valueOf(i2));
        } else if (this.effect == ParticleEffect.BREAK_BLOCK) {
            this.data = new BreakBlockEffectData(i2);
        } else if (this.effect == ParticleEffect.BREAK_SPLASH_POTION) {
            this.data = new BreakPotionEffectData(i2);
        } else if (this.effect == ParticleEffect.HARD_LANDING_DUST) {
            this.data = new HardLandingEffectData(i2);
        }
        this.broadcast = netInput.readBoolean();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        int iIntValue;
        int damagingDistance = 0;
        if (this.effect instanceof ParticleEffect) {
            iIntValue = ((Integer) MagicValues.value(Integer.class, (ParticleEffect) this.effect)).intValue();
        } else {
            iIntValue = this.effect instanceof SoundEffect ? ((Integer) MagicValues.value(Integer.class, (SoundEffect) this.effect)).intValue() : 0;
        }
        netOutput.writeInt(iIntValue);
        NetUtil.writePosition(netOutput, this.position);
        if (this.data instanceof RecordEffectData) {
            damagingDistance = ((RecordEffectData) this.data).getRecordId();
        } else if (this.data instanceof SmokeEffectData) {
            damagingDistance = ((Integer) MagicValues.value(Integer.class, (SmokeEffectData) this.data)).intValue();
        } else if (this.data instanceof BreakBlockEffectData) {
            damagingDistance = ((BreakBlockEffectData) this.data).getBlockId();
        } else if (this.data instanceof BreakPotionEffectData) {
            damagingDistance = ((BreakPotionEffectData) this.data).getPotionId();
        } else if (this.data instanceof HardLandingEffectData) {
            damagingDistance = ((HardLandingEffectData) this.data).getDamagingDistance();
        }
        netOutput.writeInt(damagingDistance);
        netOutput.writeBoolean(this.broadcast);
    }
}
