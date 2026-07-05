package com.github.steveice10.opennbt.tag.builtin;

import java.io.DataInput;
import java.io.DataOutput;
import java.lang.reflect.Array;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public abstract class Tag implements Cloneable {
    private String name;

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public abstract Tag mo12clone();

    public abstract Object getValue();

    public abstract void read(DataInput dataInput);

    public abstract void write(DataOutput dataOutput);

    public Tag(String str) {
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }

    public boolean equals(Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (!(obj instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) obj;
        if (!getName().equals(tag.getName())) {
            return false;
        }
        if (getValue() == null) {
            return tag.getValue() == null;
        }
        if (tag.getValue() == null) {
            return false;
        }
        if (getValue().getClass().isArray() && tag.getValue().getClass().isArray()) {
            int length = Array.getLength(getValue());
            if (Array.getLength(tag.getValue()) != length) {
                return false;
            }
            for (int i = 0; i < length; i++) {
                Object obj2 = Array.get(getValue(), i);
                Object obj3 = Array.get(tag.getValue(), i);
                if ((obj2 == null && obj3 != null) || (obj2 != null && !obj2.equals(obj3))) {
                    return false;
                }
            }
            return true;
        }
        return getValue().equals(tag.getValue());
    }

    public String toString() {
        String str = (getName() == null || getName().equals(BuildConfig.FLAVOR)) ? BuildConfig.FLAVOR : "(" + getName() + ")";
        String string = BuildConfig.FLAVOR;
        if (getValue() != null) {
            string = getValue().toString();
            if (getValue().getClass().isArray()) {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                for (int i = 0; i < Array.getLength(getValue()); i++) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(Array.get(getValue(), i));
                }
                sb.append("]");
                string = sb.toString();
            }
        }
        return getClass().getSimpleName() + str + " { " + string + " }";
    }
}
