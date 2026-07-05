package com.github.steveice10.mc.v1_10.protocol.data.game.window.property;

/* loaded from: classes.dex */
public enum EnchantmentTableProperty implements WindowProperty {
    LEVEL_SLOT_1,
    LEVEL_SLOT_2,
    LEVEL_SLOT_3,
    XP_SEED,
    ENCHANTMENT_SLOT_1,
    ENCHANTMENT_SLOT_2,
    ENCHANTMENT_SLOT_3;

    public static int getEnchantment(int i, int i2) {
        return i | (i2 << 8);
    }

    public static int getEnchantmentLevel(int i) {
        return i >> 8;
    }

    public static int getEnchantmentType(int i) {
        return i & 255;
    }
}
