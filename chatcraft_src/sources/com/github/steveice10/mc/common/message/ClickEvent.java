package com.github.steveice10.mc.common.message;

/* loaded from: classes.dex */
public class ClickEvent implements Cloneable {
    private ClickAction action;
    private String value;

    public ClickEvent(ClickAction clickAction, String str) {
        this.action = clickAction;
        this.value = str;
    }

    public ClickAction getAction() {
        return this.action;
    }

    public String getValue() {
        return this.value;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ClickEvent m0clone() {
        return new ClickEvent(this.action, this.value);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ClickEvent) {
            ClickEvent clickEvent = (ClickEvent) obj;
            if (this.action == clickEvent.action && this.value.equals(clickEvent.value)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.action.hashCode() * 31) + this.value.hashCode();
    }
}
