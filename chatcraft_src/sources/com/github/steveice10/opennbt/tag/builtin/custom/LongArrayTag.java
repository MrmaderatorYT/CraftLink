package com.github.steveice10.opennbt.tag.builtin.custom;

import com.github.steveice10.opennbt.tag.builtin.Tag;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/* loaded from: classes.dex */
public class LongArrayTag extends Tag {
    private long[] value;

    public LongArrayTag(String str) {
        this(str, new long[0]);
    }

    public LongArrayTag(String str, long[] jArr) {
        super(str);
        this.value = jArr;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public long[] getValue() {
        return (long[]) this.value.clone();
    }

    public void setValue(long[] jArr) {
        if (jArr == null) {
            return;
        }
        this.value = (long[]) jArr.clone();
    }

    public long getValue(int i) {
        return this.value[i];
    }

    public void setValue(int i, long j) {
        this.value[i] = j;
    }

    public int length() {
        return this.value.length;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void read(DataInput dataInput) {
        this.value = new long[dataInput.readInt()];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = dataInput.readLong();
        }
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.value.length);
        for (int i = 0; i < this.value.length; i++) {
            dataOutput.writeLong(this.value[i]);
        }
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    /* renamed from: clone */
    public LongArrayTag mo12clone() {
        return new LongArrayTag(getName(), getValue());
    }
}
