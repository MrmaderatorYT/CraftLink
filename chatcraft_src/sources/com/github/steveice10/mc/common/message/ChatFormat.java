package com.github.steveice10.mc.common.message;

/* loaded from: classes.dex */
public enum ChatFormat {
    BOLD,
    UNDERLINED,
    STRIKETHROUGH,
    ITALIC,
    OBFUSCATED,
    ChatColor;

    public static ChatFormat byName(String str) {
        String lowerCase = str.toLowerCase();
        for (ChatFormat chatFormat : values()) {
            if (chatFormat.toString().equals(lowerCase)) {
                return chatFormat;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name().toLowerCase();
    }
}
