package com.github.steveice10.mc.v1_7_7.protocol.data.game;

/* loaded from: classes.dex */
public class DefaultAttribute {
    private double def;
    private String key;
    private double max;
    private double min;
    public static final DefaultAttribute MAX_HEALTH = new DefaultAttribute("generic.maxHealth", 20.0d, 0.0d, Double.MAX_VALUE);
    public static final DefaultAttribute FOLLOW_RANGE = new DefaultAttribute("generic.followRange", 32.0d, 0.0d, 2048.0d);
    public static final DefaultAttribute KNOCKBACK_RESISTANCE = new DefaultAttribute("generic.knockbackResistance", 0.0d, 0.0d, 1.0d);
    public static final DefaultAttribute MOVEMENT_SPEED = new DefaultAttribute("generic.movementSpeed", 0.699999988079071d, 0.0d, Double.MAX_VALUE);
    public static final DefaultAttribute ATTACK_DAMAGE = new DefaultAttribute("generic.attackStrength", 2.0d, 0.0d, Double.MAX_VALUE);
    public static final DefaultAttribute HORSE_JUMP_STRENGTH = new DefaultAttribute("generic.maxHealth", 0.7d, 0.0d, 2.0d);
    public static final DefaultAttribute ZOMBIE_SPAWN_REINFORCEMENTS_CHANCE = new DefaultAttribute("generic.maxHealth", 0.0d, 0.0d, 1.0d);

    private DefaultAttribute(String str, double d, double d2, double d3) {
        this.key = str;
        this.def = d;
        this.min = d2;
        this.max = d3;
    }

    public String getKey() {
        return this.key;
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
