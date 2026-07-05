package com.github.steveice10.mc.v1_9.protocol.data.game.entity.attribute;

/* loaded from: classes.dex */
public enum AttributeType {
    MAX_HEALTH(20.0d, 0.0d, 1024.0d),
    FOLLOW_RANGE(32.0d, 0.0d, 2048.0d),
    KNOCKBACK_RESISTANCE(0.0d, 0.0d, 1.0d),
    MOVEMENT_SPEED(0.699999988079071d, 0.0d, 1024.0d),
    ATTACK_DAMAGE(2.0d, 0.0d, 2048.0d),
    ATTACK_SPEED(4.0d, 0.0d, 1024.0d),
    ARMOR(0.0d, 0.0d, 30.0d),
    LUCK(0.0d, -1024.0d, 1024.0d),
    HORSE_JUMP_STRENGTH(0.7d, 0.0d, 2.0d),
    ARMOR_TOUGHNESS(0.0d, 0.0d, 30.0d),
    ZOMBIE_SPAWN_REINFORCEMENTS_CHANCE(0.0d, 0.0d, 1.0d);

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
