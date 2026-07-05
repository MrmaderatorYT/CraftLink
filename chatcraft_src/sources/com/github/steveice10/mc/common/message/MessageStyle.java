package com.github.steveice10.mc.common.message;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class MessageStyle implements Cloneable {
    private static final MessageStyle DEFAULT = new MessageStyle();
    private ClickEvent click;
    private HoverEvent hover;
    private String insertion;
    private ChatColor color = ChatColor.WHITE;
    private List<ChatFormat> formats = new ArrayList();
    private MessageStyle parent = DEFAULT;

    public boolean isDefault() {
        return equals(DEFAULT);
    }

    public ChatColor getColor() {
        return this.color;
    }

    public MessageStyle setColor(ChatColor chatColor) {
        this.color = chatColor;
        return this;
    }

    public List<ChatFormat> getFormats() {
        return new ArrayList(this.formats);
    }

    public MessageStyle setFormats(List<ChatFormat> list) {
        this.formats = new ArrayList(list);
        return this;
    }

    public ClickEvent getClickEvent() {
        return this.click;
    }

    public MessageStyle setClickEvent(ClickEvent clickEvent) {
        this.click = clickEvent;
        return this;
    }

    public HoverEvent getHoverEvent() {
        return this.hover;
    }

    public MessageStyle setHoverEvent(HoverEvent hoverEvent) {
        this.hover = hoverEvent;
        return this;
    }

    public String getInsertion() {
        return this.insertion;
    }

    public MessageStyle setInsertion(String str) {
        this.insertion = str;
        return this;
    }

    public MessageStyle getParent() {
        return this.parent;
    }

    public MessageStyle setParent(MessageStyle messageStyle) {
        if (messageStyle == null) {
            messageStyle = DEFAULT;
        }
        this.parent = messageStyle;
        return this;
    }

    public MessageStyle addFormat(ChatFormat chatFormat) {
        this.formats.add(chatFormat);
        return this;
    }

    public MessageStyle removeFormat(ChatFormat chatFormat) {
        this.formats.remove(chatFormat);
        return this;
    }

    public MessageStyle clearFormats() {
        this.formats.clear();
        return this;
    }

    public String toString() {
        return "MessageStyle{color=" + this.color + ",formats=" + this.formats + ",clickEvent=" + this.click + ",hoverEvent=" + this.hover + ",insertion=" + this.insertion + "}";
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public MessageStyle m2clone() {
        return new MessageStyle().setParent(this.parent).setColor(this.color).setFormats(this.formats).setClickEvent(this.click != null ? this.click.m0clone() : null).setHoverEvent(this.hover != null ? this.hover.m1clone() : null).setInsertion(this.insertion);
    }

    public boolean equals(Object obj) {
        if (obj instanceof MessageStyle) {
            MessageStyle messageStyle = (MessageStyle) obj;
            if (this.color == messageStyle.color && this.formats.equals(messageStyle.formats) && (this.click == null ? messageStyle.click == null : this.click.equals(messageStyle.click)) && (this.hover == null ? messageStyle.hover == null : this.hover.equals(messageStyle.hover)) && (this.insertion == null ? messageStyle.insertion == null : this.insertion.equals(messageStyle.insertion)) && this.parent.equals(messageStyle.parent)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.color.hashCode() * 31) + this.formats.hashCode()) * 31) + (this.click != null ? this.click.hashCode() : 0)) * 31) + (this.hover != null ? this.hover.hashCode() : 0)) * 31) + (this.insertion != null ? this.insertion.hashCode() : 0)) * 31) + this.parent.hashCode();
    }
}
