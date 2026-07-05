package com.github.steveice10.opennbt.tag.builtin;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/* loaded from: classes.dex */
public class DoubleTag extends Tag {
    private double value;

    public DoubleTag(String str) {
        this(str, 0.0d);
    }

    public DoubleTag(String str, double d) {
        super(str);
        this.value = d;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public Double getValue() {
        return Double.valueOf(this.value);
    }

    public void setValue(double d) {
        this.value = d;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void read(DataInput dataInput) {
        this.value = dataInput.readDouble();
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeDouble(this.value);
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    /* renamed from: clone */
    public DoubleTag mo12clone() {
        return new DoubleTag(getName(), getValue().doubleValue());
    }
}
