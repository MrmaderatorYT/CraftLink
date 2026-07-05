package com.github.steveice10.mc.v1_6_4.data;

import java.util.UUID;

/* loaded from: classes.dex */
public class AttributeModifier {
    private double amount;
    private int operation;
    private UUID uid;

    public AttributeModifier(UUID uuid, double d, int i) {
        this.uid = uuid;
        this.amount = d;
        this.operation = i;
    }

    public UUID getUID() {
        return this.uid;
    }

    public double getAmount() {
        return this.amount;
    }

    public int getOperation() {
        return this.operation;
    }
}
