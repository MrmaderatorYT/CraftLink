package com.github.steveice10.mc.v1_7.protocol.data.game;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Attribute {
    private String key;
    private List<AttributeModifier> modifiers;
    private double value;

    public Attribute(DefaultAttribute defaultAttribute) {
        this(defaultAttribute.getKey(), defaultAttribute.getDefault());
    }

    public Attribute(DefaultAttribute defaultAttribute, double d) {
        this(defaultAttribute.getKey(), d);
    }

    public Attribute(DefaultAttribute defaultAttribute, double d, List<AttributeModifier> list) {
        this(defaultAttribute.getKey(), d, list);
    }

    public Attribute(String str, double d) {
        this(str, d, new ArrayList());
    }

    public Attribute(String str, double d, List<AttributeModifier> list) {
        this.key = str;
        this.value = d;
        this.modifiers = list;
    }

    public String getKey() {
        return this.key;
    }

    public double getValue() {
        return this.value;
    }

    public List<AttributeModifier> getModifiers() {
        return this.modifiers;
    }
}
