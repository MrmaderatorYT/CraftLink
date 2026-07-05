package com.github.steveice10.mc.v1_8.protocol.data.game.values.world.block.value;

/* loaded from: classes.dex */
public class GenericBlockValue implements BlockValue {
    private int value;

    public GenericBlockValue(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.value == ((GenericBlockValue) obj).value;
    }

    public int hashCode() {
        return this.value;
    }
}
