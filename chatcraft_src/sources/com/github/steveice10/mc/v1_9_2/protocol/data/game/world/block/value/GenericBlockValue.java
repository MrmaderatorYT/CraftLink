package com.github.steveice10.mc.v1_9_2.protocol.data.game.world.block.value;

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
        return (obj instanceof GenericBlockValue) && this.value == ((GenericBlockValue) obj).value;
    }

    public int hashCode() {
        return this.value;
    }
}
