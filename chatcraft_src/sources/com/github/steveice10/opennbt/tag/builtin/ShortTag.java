package com.github.steveice10.opennbt.tag.builtin;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/* loaded from: classes.dex */
public class ShortTag extends Tag {
    private short value;

    public ShortTag(String str) {
        this(str, (short) 0);
    }

    public ShortTag(String str, short s) {
        super(str);
        this.value = s;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public Short getValue() {
        return Short.valueOf(this.value);
    }

    public void setValue(short s) {
        this.value = s;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void read(DataInput dataInput) {
        this.value = dataInput.readShort();
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeShort(this.value);
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    /* renamed from: clone */
    public ShortTag mo12clone() {
        return new ShortTag(getName(), getValue().shortValue());
    }
}
