package com.github.steveice10.mc.v1_8.protocol.data.game.values.world.effect;

/* loaded from: classes.dex */
public class BreakPotionEffectData implements WorldEffectData {
    private int potionId;

    public BreakPotionEffectData(int i) {
        this.potionId = i;
    }

    public int getPotionId() {
        return this.potionId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.potionId == ((BreakPotionEffectData) obj).potionId;
    }

    public int hashCode() {
        return this.potionId;
    }
}
