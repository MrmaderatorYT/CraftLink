package com.github.steveice10.mc.v1_8.protocol.data.game.attribute;

import com.github.steveice10.mc.v1_8.protocol.data.game.values.MagicValues;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.entity.ModifierOperation;
import com.github.steveice10.mc.v1_8.protocol.data.game.values.entity.ModifierType;
import java.util.UUID;

/* loaded from: classes.dex */
public class AttributeModifier {
    private double amount;
    private ModifierOperation operation;
    private ModifierType type;
    private UUID uuid;

    public AttributeModifier(ModifierType modifierType, double d, ModifierOperation modifierOperation) {
        this.type = modifierType;
        this.uuid = (UUID) MagicValues.value(UUID.class, modifierType);
        this.amount = d;
        this.operation = modifierOperation;
    }

    public AttributeModifier(UUID uuid, double d, ModifierOperation modifierOperation) {
        this.type = (ModifierType) MagicValues.key(ModifierType.class, uuid);
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
        return Double.compare(attributeModifier.amount, this.amount) == 0 && this.operation == attributeModifier.operation && this.type == attributeModifier.type;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode();
        long jDoubleToLongBits = Double.doubleToLongBits(this.amount);
        return (((iHashCode * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31) + this.operation.hashCode();
    }
}
