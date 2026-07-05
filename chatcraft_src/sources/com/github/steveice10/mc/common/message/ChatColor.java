package com.github.steveice10.mc.common.message;

/* loaded from: classes.dex */
public enum ChatColor {
    BLACK,
    DARK_BLUE,
    DARK_GREEN,
    DARK_AQUA,
    DARK_RED,
    DARK_PURPLE,
    GOLD,
    GRAY,
    DARK_GRAY,
    BLUE,
    GREEN,
    AQUA,
    RED,
    LIGHT_PURPLE,
    YELLOW,
    WHITE,
    RESET;

    public static ChatColor byName(String str) {
        String lowerCase = str.toLowerCase();
        for (ChatColor chatColor : values()) {
            if (chatColor.toString().equals(lowerCase)) {
                return chatColor;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name().toLowerCase();
    }
}
