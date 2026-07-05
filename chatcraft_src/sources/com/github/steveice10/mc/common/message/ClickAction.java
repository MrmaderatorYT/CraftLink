package com.github.steveice10.mc.common.message;

/* loaded from: classes.dex */
public enum ClickAction {
    RUN_COMMAND,
    SUGGEST_COMMAND,
    OPEN_URL,
    OPEN_FILE,
    ReflectionToString;

    public static ClickAction byName(String str) {
        String lowerCase = str.toLowerCase();
        for (ClickAction clickAction : values()) {
            if (clickAction.toString().equals(lowerCase)) {
                return clickAction;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name().toLowerCase();
    }
}
