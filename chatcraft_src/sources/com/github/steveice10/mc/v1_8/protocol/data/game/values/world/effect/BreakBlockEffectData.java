package com.github.steveice10.mc.v1_8.protocol.data.game.values.world.effect;

/* loaded from: classes.dex */
public class BreakBlockEffectData implements WorldEffectData {
    private int blockId;

    public BreakBlockEffectData(int i) {
        this.blockId = i;
    }

    public int getBlockId() {
        return this.blockId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.blockId == ((BreakBlockEffectData) obj).blockId;
    }

    public int hashCode() {
        return this.blockId;
    }
}
