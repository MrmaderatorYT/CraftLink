package com.github.steveice10.mc.v1_6_4.data;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class EntityAttribute {
    private List<AttributeModifier> modifiers;
    private String name;
    private double value;

    public EntityAttribute(String str, double d) {
        this(str, d, new ArrayList());
    }

    public EntityAttribute(String str, double d, List<AttributeModifier> list) {
        this.name = str;
        this.value = d;
        this.modifiers = list;
    }

    public String getName() {
        return this.name;
    }

    public double getValue() {
        return this.value;
    }

    public List<AttributeModifier> getModifiers() {
        return this.modifiers;
    }

    public void addModifier(AttributeModifier attributeModifier) {
        this.modifiers.add(attributeModifier);
    }
}
