package com.github.steveice10.mc.v1_8.protocol.data.game.values.world.notify;

/* loaded from: classes.dex */
public class RainStrengthValue implements ClientNotificationValue {
    private float strength;

    public RainStrengthValue(float f) {
        f = f > 1.0f ? 1.0f : f;
        this.strength = f < 0.0f ? 0.0f : f;
    }

    public float getStrength() {
        return this.strength;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && Float.compare(((RainStrengthValue) obj).strength, this.strength) == 0;
    }

    public int hashCode() {
        if (this.strength != 0.0f) {
            return Float.floatToIntBits(this.strength);
        }
        return 0;
    }
}
