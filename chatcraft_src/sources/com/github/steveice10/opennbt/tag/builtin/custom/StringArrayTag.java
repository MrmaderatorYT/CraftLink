package com.github.steveice10.opennbt.tag.builtin.custom;

import com.github.steveice10.opennbt.tag.builtin.Tag;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/* loaded from: classes.dex */
public class StringArrayTag extends Tag {
    private String[] value;

    public StringArrayTag(String str) {
        this(str, new String[0]);
    }

    public StringArrayTag(String str, String[] strArr) {
        super(str);
        this.value = strArr;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public String[] getValue() {
        return (String[]) this.value.clone();
    }

    public void setValue(String[] strArr) {
        if (strArr == null) {
            return;
        }
        this.value = (String[]) strArr.clone();
    }

    public String getValue(int i) {
        return this.value[i];
    }

    public void setValue(int i, String str) {
        this.value[i] = str;
    }

    public int length() {
        return this.value.length;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void read(DataInput dataInput) {
        this.value = new String[dataInput.readInt()];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = dataInput.readUTF();
        }
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.value.length);
        for (int i = 0; i < this.value.length; i++) {
            dataOutput.writeUTF(this.value[i]);
        }
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    /* renamed from: clone */
    public StringArrayTag mo12clone() {
        return new StringArrayTag(getName(), getValue());
    }
}
