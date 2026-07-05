package com.github.steveice10.opennbt.tag.builtin;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/* loaded from: classes.dex */
public class IntTag extends Tag {
    private int value;

    public IntTag(String str) {
        this(str, 0);
    }

    public IntTag(String str, int i) {
        super(str);
        this.value = i;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public Integer getValue() {
        return Integer.valueOf(this.value);
    }

    public void setValue(int i) {
        this.value = i;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void read(DataInput dataInput) {
        this.value = dataInput.readInt();
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.value);
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    /* renamed from: clone */
    public IntTag mo12clone() {
        return new IntTag(getName(), getValue().intValue());
    }
}
