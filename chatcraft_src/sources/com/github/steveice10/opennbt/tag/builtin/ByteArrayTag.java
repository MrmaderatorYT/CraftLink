package com.github.steveice10.opennbt.tag.builtin;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/* loaded from: classes.dex */
public class ByteArrayTag extends Tag {
    private byte[] value;

    public ByteArrayTag(String str) {
        this(str, new byte[0]);
    }

    public ByteArrayTag(String str, byte[] bArr) {
        super(str);
        this.value = bArr;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public byte[] getValue() {
        return (byte[]) this.value.clone();
    }

    public void setValue(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        this.value = (byte[]) bArr.clone();
    }

    public byte getValue(int i) {
        return this.value[i];
    }

    public void setValue(int i, byte b2) {
        this.value[i] = b2;
    }

    public int length() {
        return this.value.length;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void read(DataInput dataInput) throws IOException {
        this.value = new byte[dataInput.readInt()];
        dataInput.readFully(this.value);
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.value.length);
        dataOutput.write(this.value);
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    /* renamed from: clone */
    public ByteArrayTag mo12clone() {
        return new ByteArrayTag(getName(), getValue());
    }
}
