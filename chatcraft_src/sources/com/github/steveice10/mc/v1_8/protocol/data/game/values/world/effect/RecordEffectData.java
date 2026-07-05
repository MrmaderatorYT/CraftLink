package com.github.steveice10.mc.v1_8.protocol.data.game.values.world.effect;

/* loaded from: classes.dex */
public class RecordEffectData implements WorldEffectData {
    private int recordId;

    public RecordEffectData(int i) {
        this.recordId = i;
    }

    public int getRecordId() {
        return this.recordId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.recordId == ((RecordEffectData) obj).recordId;
    }

    public int hashCode() {
        return this.recordId;
    }
}
