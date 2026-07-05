package com.github.steveice10.mc.common.message;

/* loaded from: classes.dex */
public class HoverEvent implements Cloneable {
    private HoverAction action;
    private MessageInterface value;

    public HoverEvent(HoverAction hoverAction, MessageInterface messageInterface) {
        this.action = hoverAction;
        this.value = messageInterface;
    }

    public HoverAction getAction() {
        return this.action;
    }

    public MessageInterface getValue() {
        return this.value;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public HoverEvent m1clone() {
        return new HoverEvent(this.action, this.value.clone());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HoverEvent hoverEvent = (HoverEvent) obj;
        return this.action == hoverEvent.action && this.value.equals(hoverEvent.value);
    }

    public int hashCode() {
        return (this.action.hashCode() * 31) + this.value.hashCode();
    }
}
