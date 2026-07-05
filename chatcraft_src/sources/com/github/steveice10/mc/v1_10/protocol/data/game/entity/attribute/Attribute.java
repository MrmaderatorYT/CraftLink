package com.github.steveice10.mc.v1_10.protocol.data.game.entity.attribute;

import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Attribute {
    private List<AttributeModifier> modifiers;
    private AttributeType type;
    private double value;

    public Attribute(AttributeType attributeType) {
        this(attributeType, attributeType.getDefault());
    }

    public Attribute(AttributeType attributeType, double d) {
        this(attributeType, d, new ArrayList());
    }

    public Attribute(AttributeType attributeType, double d, List<AttributeModifier> list) {
        this.type = attributeType;
        this.value = d;
        this.modifiers = list;
    }

    public AttributeType getType() {
        return this.type;
    }

    public double getValue() {
        return this.value;
    }

    public List<AttributeModifier> getModifiers() {
        return new ArrayList(this.modifiers);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Attribute attribute = (Attribute) obj;
        return Double.compare(attribute.value, this.value) == 0 && this.modifiers.equals(attribute.modifiers) && this.type == attribute.type;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode();
        long jDoubleToLongBits = Double.doubleToLongBits(this.value);
        return (((iHashCode * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
