package com.github.steveice10.opennbt.tag.builtin.custom;

import com.github.steveice10.opennbt.tag.builtin.Tag;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/* loaded from: classes.dex */
public class ShortArrayTag extends Tag {
    private short[] value;

    public ShortArrayTag(String str) {
        this(str, new short[0]);
    }

    public ShortArrayTag(String str, short[] sArr) {
        super(str);
        this.value = sArr;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public short[] getValue() {
        return (short[]) this.value.clone();
    }

    public void setValue(short[] sArr) {
        if (sArr == null) {
            return;
        }
        this.value = (short[]) sArr.clone();
    }

    public short getValue(int i) {
        return this.value[i];
    }

    public void setValue(int i, short s) {
        this.value[i] = s;
    }

    public int length() {
        return this.value.length;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void read(DataInput dataInput) {
        this.value = new short[dataInput.readInt()];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = dataInput.readShort();
        }
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.value.length);
        for (int i = 0; i < this.value.length; i++) {
            dataOutput.writeShort(this.value[i]);
        }
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    /* renamed from: clone */
    public ShortArrayTag mo12clone() {
        return new ShortArrayTag(getName(), getValue());
    }
}
