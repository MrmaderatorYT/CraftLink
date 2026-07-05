package com.github.steveice10.opennbt.tag.builtin;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/* loaded from: classes.dex */
public class ByteTag extends Tag {
    private byte value;

    public ByteTag(String str) {
        this(str, (byte) 0);
    }

    public ByteTag(String str, byte b2) {
        super(str);
        this.value = b2;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public Byte getValue() {
        return Byte.valueOf(this.value);
    }

    public void setValue(byte b2) {
        this.value = b2;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void read(DataInput dataInput) {
        this.value = dataInput.readByte();
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(this.value);
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    /* renamed from: clone */
    public ByteTag mo12clone() {
        return new ByteTag(getName(), getValue().byteValue());
    }
}
