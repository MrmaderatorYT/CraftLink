package com.github.steveice10.mc.v1_8.protocol.data.game.values.world.block.value;

/* loaded from: classes.dex */
public class ChestValue implements BlockValue {
    private int viewers;

    public ChestValue(int i) {
        this.viewers = i;
    }

    public int getViewers() {
        return this.viewers;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.viewers == ((ChestValue) obj).viewers;
    }

    public int hashCode() {
        return this.viewers;
    }
}
