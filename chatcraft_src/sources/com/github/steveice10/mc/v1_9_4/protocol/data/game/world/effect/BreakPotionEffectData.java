package com.github.steveice10.mc.v1_9_4.protocol.data.game.world.effect;

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
        return (obj instanceof BreakPotionEffectData) && this.potionId == ((BreakPotionEffectData) obj).potionId;
    }

    public int hashCode() {
        return this.potionId;
    }
}
