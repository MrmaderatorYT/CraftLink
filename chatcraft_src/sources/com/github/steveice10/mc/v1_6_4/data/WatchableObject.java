package com.github.steveice10.mc.v1_6_4.data;

/* loaded from: classes.dex */
public class WatchableObject {
    private int id;
    private int type;
    private Object value;

    public WatchableObject(int i, int i2, Object obj) {
        this.type = i;
        this.id = i2;
        this.value = obj;
    }

    public int getType() {
        return this.type;
    }

    public int getId() {
        return this.id;
    }

    public Object getValue() {
        return this.value;
    }
}
