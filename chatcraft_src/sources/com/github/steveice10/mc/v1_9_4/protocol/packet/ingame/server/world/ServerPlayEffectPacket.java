package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.server.world;

import com.github.steveice10.mc.v1_9_4.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.entity.metadata.Position;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.world.block.BlockState;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.world.effect.BonemealGrowEffectData;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.world.effect.BreakBlockEffectData;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.world.effect.BreakPotionEffectData;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.world.effect.ParticleEffect;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.world.effect.RecordEffectData;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.world.effect.SmokeEffectData;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.world.effect.SoundEffect;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.world.effect.WorldEffect;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.world.effect.WorldEffectData;
import com.github.steveice10.mc.v1_9_4.protocol.util.NetUtil;
import com.github.steveice10.mc.v1_9_4.protocol.util.ReflectionToString;
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
        this.effect = (WorldEffect) MagicValues.key(WorldEffect.class, Integer.valueOf(netInput.readInt()));
        this.position = NetUtil.readPosition(netInput);
        int i = netInput.readInt();
        if (this.effect == SoundEffect.RECORD) {
            this.data = new RecordEffectData(i);
        } else if (this.effect == ParticleEffect.SMOKE) {
            this.data = (WorldEffectData) MagicValues.key(SmokeEffectData.class, Integer.valueOf(i));
        } else if (this.effect == ParticleEffect.BREAK_BLOCK) {
            this.data = new BreakBlockEffectData(new BlockState(i & 4095, (i >> 12) & 255));
        } else if (this.effect == ParticleEffect.BREAK_SPLASH_POTION) {
            this.data = new BreakPotionEffectData(i);
        } else if (this.effect == ParticleEffect.BONEMEAL_GROW) {
            this.data = new BonemealGrowEffectData(i);
        }
        this.broadcast = netInput.readBoolean();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        int particleCount;
        netOutput.writeInt(((Integer) MagicValues.value(Integer.class, this.effect)).intValue());
        NetUtil.writePosition(netOutput, this.position);
        if (this.data instanceof RecordEffectData) {
            particleCount = ((RecordEffectData) this.data).getRecordId();
        } else if (this.data instanceof SmokeEffectData) {
            particleCount = ((Integer) MagicValues.value(Integer.class, (SmokeEffectData) this.data)).intValue();
        } else if (this.data instanceof BreakBlockEffectData) {
            particleCount = (((BreakBlockEffectData) this.data).getBlockState().getId() & 4095) | ((((BreakBlockEffectData) this.data).getBlockState().getData() & 255) << 12);
        } else if (this.data instanceof BreakPotionEffectData) {
            particleCount = ((BreakPotionEffectData) this.data).getPotionId();
        } else {
            particleCount = this.data instanceof BonemealGrowEffectData ? ((BonemealGrowEffectData) this.data).getParticleCount() : 0;
        }
        netOutput.writeInt(particleCount);
        netOutput.writeBoolean(this.broadcast);
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
