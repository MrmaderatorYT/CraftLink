package com.github.steveice10.opennbt.tag.builtin.custom;

import com.github.steveice10.opennbt.tag.builtin.Tag;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/* loaded from: classes.dex */
public class DoubleArrayTag extends Tag {
    private double[] value;

    public DoubleArrayTag(String str) {
        this(str, new double[0]);
    }

    public DoubleArrayTag(String str, double[] dArr) {
        super(str);
        this.value = dArr;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public double[] getValue() {
        return (double[]) this.value.clone();
    }

    public void setValue(double[] dArr) {
        if (dArr == null) {
            return;
        }
        this.value = (double[]) dArr.clone();
    }

    public double getValue(int i) {
        return this.value[i];
    }

    public void setValue(int i, double d) {
        this.value[i] = d;
    }

    public int length() {
        return this.value.length;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void read(DataInput dataInput) {
        this.value = new double[dataInput.readInt()];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = dataInput.readDouble();
        }
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.value.length);
        for (int i = 0; i < this.value.length; i++) {
            dataOutput.writeDouble(this.value[i]);
        }
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    /* renamed from: clone */
    public DoubleArrayTag mo12clone() {
        return new DoubleArrayTag(getName(), getValue());
    }
}
