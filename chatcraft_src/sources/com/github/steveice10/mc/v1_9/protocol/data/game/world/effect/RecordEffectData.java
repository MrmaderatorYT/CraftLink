package com.github.steveice10.mc.v1_9.protocol.data.game.world.effect;

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
        return (obj instanceof RecordEffectData) && this.recordId == ((RecordEffectData) obj).recordId;
    }

    public int hashCode() {
        return this.recordId;
    }
}
