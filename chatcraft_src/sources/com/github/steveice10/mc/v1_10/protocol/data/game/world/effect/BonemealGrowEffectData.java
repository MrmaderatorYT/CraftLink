package com.github.steveice10.mc.v1_10.protocol.data.game.world.effect;

/* loaded from: classes.dex */
public class BonemealGrowEffectData implements WorldEffectData {
    private int particleCount;

    public BonemealGrowEffectData(int i) {
        this.particleCount = i;
    }

    public int getParticleCount() {
        return this.particleCount;
    }

    public boolean equals(Object obj) {
        return (obj instanceof BonemealGrowEffectData) && this.particleCount == ((BonemealGrowEffectData) obj).particleCount;
    }

    public int hashCode() {
        return this.particleCount;
    }
}
