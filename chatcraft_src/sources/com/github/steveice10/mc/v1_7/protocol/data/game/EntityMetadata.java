package com.github.steveice10.mc.v1_7.protocol.data.game;

/* loaded from: classes.dex */
public class EntityMetadata {
    private int id;
    private Type type;
    private Object value;

    public enum Type {
        BYTE,
        SHORT,
        INT,
        FLOAT,
        STRING,
        ITEM,
        COORDINATES
    }

    public EntityMetadata(int i, Type type, Object obj) {
        this.id = i;
        this.type = type;
        this.value = obj;
    }

    public int getId() {
        return this.id;
    }

    public Type getType() {
        return this.type;
    }

    public Object getValue() {
        return this.value;
    }
}
