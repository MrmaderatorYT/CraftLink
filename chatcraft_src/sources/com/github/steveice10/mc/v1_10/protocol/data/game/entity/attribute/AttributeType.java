package com.github.steveice10.mc.v1_10.protocol.data.game.entity.attribute;

/* loaded from: classes.dex */
public enum AttributeType {
    GENERIC_MAX_HEALTH(20.0d, 0.0d, 1024.0d),
    GENERIC_FOLLOW_RANGE(32.0d, 0.0d, 2048.0d),
    GENERIC_KNOCKBACK_RESISTANCE(0.0d, 0.0d, 1.0d),
    GENERIC_MOVEMENT_SPEED(0.699999988079071d, 0.0d, 1024.0d),
    GENERIC_ATTACK_DAMAGE(2.0d, 0.0d, 2048.0d),
    GENERIC_ATTACK_SPEED(4.0d, 0.0d, 1024.0d),
    GENERIC_ARMOR(0.0d, 0.0d, 30.0d),
    GENERIC_ARMOR_TOUGHNESS(0.0d, 0.0d, 20.0d),
    GENERIC_LUCK(0.0d, -1024.0d, 1024.0d),
    HORSE_JUMP_STRENGTH(0.7d, 0.0d, 2.0d),
    ZOMBIE_SPAWN_REINFORCEMENTS(0.0d, 0.0d, 1.0d);

    private double def;
    private double max;
    private double min;

    AttributeType(double d, double d2, double d3) {
        this.def = d;
        this.min = d2;
        this.max = d3;
    }

    public double getDefault() {
        return this.def;
    }

    public double getMin() {
        return this.min;
    }

    public double getMax() {
        return this.max;
    }
}
