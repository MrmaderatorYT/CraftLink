package com.github.steveice10.mc.v1_10.protocol.data.game.world.notify;

/* loaded from: classes.dex */
public class ThunderStrengthValue implements ClientNotificationValue {
    private float strength;

    public ThunderStrengthValue(float f) {
        f = f > 1.0f ? 1.0f : f;
        this.strength = f < 0.0f ? 0.0f : f;
    }

    public float getStrength() {
        return this.strength;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ThunderStrengthValue) && Float.compare(this.strength, ((ThunderStrengthValue) obj).strength) == 0;
    }

    public int hashCode() {
        if (this.strength != 0.0f) {
            return Float.floatToIntBits(this.strength);
        }
        return 0;
    }
}
