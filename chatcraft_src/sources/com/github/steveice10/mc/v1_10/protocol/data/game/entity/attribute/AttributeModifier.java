package com.github.steveice10.mc.v1_10.protocol.data.game.entity.attribute;

import com.github.steveice10.mc.v1_10.protocol.data.MagicValues;
import java.util.UUID;

/* loaded from: classes.dex */
public class AttributeModifier {
    private double amount;
    private ModifierOperation operation;
    private ModifierType type;
    private UUID uuid;

    public AttributeModifier(ModifierType modifierType, double d, ModifierOperation modifierOperation) {
        if (modifierType == ModifierType.DYNAMIC) {
            throw new IllegalArgumentException("Cannot create a dynamic-typed modifier without a UUID.");
        }
        this.type = modifierType;
        this.uuid = (UUID) MagicValues.value(UUID.class, modifierType);
        this.amount = d;
        this.operation = modifierOperation;
    }

    public AttributeModifier(UUID uuid, double d, ModifierOperation modifierOperation) {
        try {
            this.type = (ModifierType) MagicValues.key(ModifierType.class, uuid);
        } catch (IllegalArgumentException unused) {
            this.type = ModifierType.DYNAMIC;
        }
        this.uuid = uuid;
        this.amount = d;
        this.operation = modifierOperation;
    }

    public ModifierType getType() {
        return this.type;
    }

    public UUID getUUID() {
        return this.uuid;
    }

    public double getAmount() {
        return this.amount;
    }

    public ModifierOperation getOperation() {
        return this.operation;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AttributeModifier attributeModifier = (AttributeModifier) obj;
        return Double.compare(attributeModifier.amount, this.amount) == 0 && this.operation == attributeModifier.operation && this.type.equals(attributeModifier.type);
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode();
        long jDoubleToLongBits = Double.doubleToLongBits(this.amount);
        return (((iHashCode * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31) + this.operation.hashCode();
    }
}
