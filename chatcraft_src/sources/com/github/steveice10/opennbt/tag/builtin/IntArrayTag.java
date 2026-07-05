package com.github.steveice10.opennbt.tag.builtin;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/* loaded from: classes.dex */
public class IntArrayTag extends Tag {
    private int[] value;

    public IntArrayTag(String str) {
        this(str, new int[0]);
    }

    public IntArrayTag(String str, int[] iArr) {
        super(str);
        this.value = iArr;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public int[] getValue() {
        return (int[]) this.value.clone();
    }

    public void setValue(int[] iArr) {
        if (iArr == null) {
            return;
        }
        this.value = (int[]) iArr.clone();
    }

    public int getValue(int i) {
        return this.value[i];
    }

    public void setValue(int i, int i2) {
        this.value[i] = i2;
    }

    public int length() {
        return this.value.length;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void read(DataInput dataInput) {
        this.value = new int[dataInput.readInt()];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = dataInput.readInt();
        }
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.value.length);
        for (int i = 0; i < this.value.length; i++) {
            dataOutput.writeInt(this.value[i]);
        }
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    /* renamed from: clone */
    public IntArrayTag mo12clone() {
        return new IntArrayTag(getName(), getValue());
    }
}
