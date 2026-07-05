package com.github.steveice10.opennbt.tag.builtin;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/* loaded from: classes.dex */
public class LongTag extends Tag {
    private long value;

    public LongTag(String str) {
        this(str, 0L);
    }

    public LongTag(String str, long j) {
        super(str);
        this.value = j;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public Long getValue() {
        return Long.valueOf(this.value);
    }

    public void setValue(long j) {
        this.value = j;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void read(DataInput dataInput) {
        this.value = dataInput.readLong();
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(this.value);
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    /* renamed from: clone */
    public LongTag mo12clone() {
        return new LongTag(getName(), getValue().longValue());
    }
}
