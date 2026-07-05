package com.github.steveice10.mc.common.message;

/* loaded from: classes.dex */
public enum HoverAction {
    SHOW_TEXT,
    SHOW_ITEM,
    SHOW_ACHIEVEMENT,
    SHOW_ENTITY;

    public static HoverAction byName(String str) {
        String lowerCase = str.toLowerCase();
        for (HoverAction hoverAction : values()) {
            if (hoverAction.toString().equals(lowerCase)) {
                return hoverAction;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name().toLowerCase();
    }
}
