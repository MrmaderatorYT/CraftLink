package com.github.steveice10.mc.v1_9_4.protocol.data.game.entity.metadata;

/* loaded from: classes.dex */
public class Rotation {
    private float pitch;
    private float roll;
    private float yaw;

    public Rotation() {
        this(0.0f, 0.0f, 0.0f);
    }

    public Rotation(float f, float f2, float f3) {
        this.pitch = f;
        this.yaw = f2;
        this.roll = f3;
    }

    public float getPitch() {
        return this.pitch;
    }

    public float getYaw() {
        return this.yaw;
    }

    public float getRoll() {
        return this.roll;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Rotation) {
                Rotation rotation = (Rotation) obj;
                if (Float.compare(this.pitch, rotation.pitch) != 0 || Float.compare(this.yaw, rotation.yaw) != 0 || Float.compare(this.roll, rotation.roll) != 0) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((this.pitch != 0.0f ? Float.floatToIntBits(this.pitch) : 0) * 31) + (this.yaw != 0.0f ? Float.floatToIntBits(this.yaw) : 0)) * 31) + (this.roll != 0.0f ? Float.floatToIntBits(this.roll) : 0);
    }
}
