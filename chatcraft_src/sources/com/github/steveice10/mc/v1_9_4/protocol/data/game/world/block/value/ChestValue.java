package com.github.steveice10.mc.v1_9_4.protocol.data.game.world.block.value;

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
        return (obj instanceof ChestValue) && this.viewers == ((ChestValue) obj).viewers;
    }

    public int hashCode() {
        return this.viewers;
    }
}
