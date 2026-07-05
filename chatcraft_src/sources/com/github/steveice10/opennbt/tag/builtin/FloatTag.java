package com.github.steveice10.opennbt.tag.builtin;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/* loaded from: classes.dex */
public class FloatTag extends Tag {
    private float value;

    public FloatTag(String str) {
        this(str, 0.0f);
    }

    public FloatTag(String str, float f) {
        super(str);
        this.value = f;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public Float getValue() {
        return Float.valueOf(this.value);
    }

    public void setValue(float f) {
        this.value = f;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void read(DataInput dataInput) {
        this.value = dataInput.readFloat();
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeFloat(this.value);
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    /* renamed from: clone */
    public FloatTag mo12clone() {
        return new FloatTag(getName(), getValue().floatValue());
    }
}
