package com.github.steveice10.mc.v1_9.protocol.data.game.entity.type.object;

/* loaded from: classes.dex */
public class SplashPotionData implements ObjectData {
    private int potionData;

    public SplashPotionData(int i) {
        this.potionData = i;
    }

    public int getPotionData() {
        return this.potionData;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.potionData == ((SplashPotionData) obj).potionData;
    }

    public int hashCode() {
        return this.potionData;
    }
}
