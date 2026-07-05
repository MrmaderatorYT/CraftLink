package com.github.steveice10.opennbt.tag.builtin;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public class StringTag extends Tag {
    private String value;

    public StringTag(String str) {
        this(str, BuildConfig.FLAVOR);
    }

    public StringTag(String str, String str2) {
        super(str);
        this.value = str2;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void read(DataInput dataInput) {
        this.value = dataInput.readUTF();
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.value);
    }

    @Override // com.github.steveice10.opennbt.tag.builtin.Tag
    /* renamed from: clone */
    public StringTag mo12clone() {
        return new StringTag(getName(), getValue());
    }
}
