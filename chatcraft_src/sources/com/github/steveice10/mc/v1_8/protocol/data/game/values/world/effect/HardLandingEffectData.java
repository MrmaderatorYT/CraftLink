package com.github.steveice10.mc.v1_8.protocol.data.game.values.world.effect;

/* loaded from: classes.dex */
public class HardLandingEffectData implements WorldEffectData {
    private int damagingDistance;

    public HardLandingEffectData(int i) {
        this.damagingDistance = i;
    }

    public int getDamagingDistance() {
        return this.damagingDistance;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.damagingDistance == ((HardLandingEffectData) obj).damagingDistance;
    }

    public int hashCode() {
        return this.damagingDistance;
    }
}
