package com.github.steveice10.mc.v1_9.protocol.data.game.world.block.value;

/* loaded from: classes.dex */
public class NoteBlockValue implements BlockValue {
    private int pitch;

    public NoteBlockValue(int i) {
        if (i < 0 || i > 24) {
            throw new IllegalArgumentException("Pitch must be between 0 and 24.");
        }
        this.pitch = i;
    }

    public int getPitch() {
        return this.pitch;
    }

    public boolean equals(Object obj) {
        return (obj instanceof NoteBlockValue) && this.pitch == ((NoteBlockValue) obj).pitch;
    }

    public int hashCode() {
        return this.pitch;
    }
}
