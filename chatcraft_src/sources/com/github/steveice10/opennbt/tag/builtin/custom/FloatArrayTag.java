package com.github.steveice10.opennbt.tag.builtin.custom;

import com.github.steveice10.opennbt.tag.builtin.Tag;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/* loaded from: classes.dex */
public class FloatArrayTag extends Tag {
    private float[] value;

    public FloatArrayTag(String str) {
        this(str, new float[0]);
    }

    public FloatArrayTag(String str, float[] fArr) {
        super(str);
        this.value = fArr;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public float[] getValue() {
        return (float[]) this.value.clone();
    }

    public void setValue(float[] fArr) {
        if (fArr == null) {
            return;
        }
        this.value = (float[]) fArr.clone();
    }

    public float getValue(int i) {
        return this.value[i];
    }

    public void setValue(int i, float f) {
        this.value[i] = f;
    }

    public int length() {
        return this.value.length;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void read(DataInput dataInput) {
        this.value = new float[dataInput.readInt()];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = dataInput.readFloat();
        }
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.value.length);
        for (int i = 0; i < this.value.length; i++) {
            dataOutput.writeFloat(this.value[i]);
        }
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    /* renamed from: clone */
    public FloatArrayTag mo12clone() {
        return new FloatArrayTag(getName(), getValue());
    }
}
