package com.github.steveice10.mc.v1_10.protocol.data.message;

import com.github.steveice10.mc.common.message.ChatColor;
import com.github.steveice10.mc.common.message.ChatFormat;
import com.github.steveice10.mc.common.message.ClickAction;
import com.github.steveice10.mc.common.message.ClickEvent;
import com.github.steveice10.mc.common.message.HoverAction;
import com.github.steveice10.mc.common.message.HoverEvent;
import com.github.steveice10.mc.common.message.MessageInterface;
import com.github.steveice10.mc.common.message.MessageStyle;
import com.google.gson.i;
import com.google.gson.l;
import com.google.gson.n;
import com.google.gson.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class Message implements MessageInterface, Cloneable {
    private MessageStyle style = new MessageStyle();
    private List<MessageInterface> extra = new ArrayList();

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public abstract Message mo3clone();

    @Override // com.github.steveice10.mc.common.message.MessageInterface
    public abstract String getText();

    public static Message fromString(String str) {
        try {
            return fromJson(new o().a(str));
        } catch (Exception unused) {
            return new TextMessage(str);
        }
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1013)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:967)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:118)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
     */
    public static Message fromJson(l lVar) {
        Message keybindMessage;
        if (lVar.j()) {
            return new TextMessage(lVar.c());
        }
        if (lVar.i()) {
            n nVarL = lVar.l();
            if (nVarL.a("text")) {
                keybindMessage = new TextMessage(nVarL.b("text").c());
            } else if (nVarL.a("translate")) {
                Message[] messageArr = new Message[0];
                if (nVarL.a("with")) {
                    i iVarM = nVarL.b("with").m();
                    Message[] messageArr2 = new Message[iVarM.a()];
                    for (int i = 0; i < iVarM.a(); i++) {
                        l lVarA = iVarM.a(i);
                        if (lVarA.j()) {
                            messageArr2[i] = new TextMessage(lVarA.c());
                        } else {
                            messageArr2[i] = fromJson(lVarA.l());
                        }
                    }
                    messageArr = messageArr2;
                }
                keybindMessage = new TranslationMessage(nVarL.b("translate").c(), messageArr);
            } else if (nVarL.a("keybind")) {
                keybindMessage = new KeybindMessage(nVarL.b("keybind").c());
            } else {
                throw new IllegalArgumentException("Unknown message type in json: " + nVarL.toString());
            }
            MessageStyle messageStyle = new MessageStyle();
            if (nVarL.a("color")) {
                messageStyle.setColor(ChatColor.byName(nVarL.b("color").c()));
            }
            for (ChatFormat chatFormat : ChatFormat.values()) {
                if (nVarL.a(chatFormat.toString()) && nVarL.b(chatFormat.toString()).g()) {
                    messageStyle.addFormat(chatFormat);
                }
            }
            if (nVarL.a("clickEvent")) {
                try {
                    n nVarL2 = nVarL.b("clickEvent").l();
                    messageStyle.setClickEvent(new ClickEvent(ClickAction.byName(nVarL2.b("action").c()), nVarL2.b("value").c()));
                } catch (Throwable unused) {
                }
            }
            if (nVarL.a("hoverEvent")) {
                try {
                    n nVarL3 = nVarL.b("hoverEvent").l();
                    messageStyle.setHoverEvent(new HoverEvent(HoverAction.byName(nVarL3.b("action").c()), fromJson(nVarL3.b("value"))));
                } catch (Throwable unused2) {
                }
            }
            if (nVarL.a("insertion")) {
                messageStyle.setInsertion(nVarL.b("insertion").c());
            }
            keybindMessage.setStyle(messageStyle);
            if (nVarL.a("extra")) {
                i iVarM2 = nVarL.b("extra").m();
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < iVarM2.a(); i2++) {
                    l lVarA2 = iVarM2.a(i2);
                    if (lVarA2.j()) {
                        arrayList.add(new TextMessage(lVarA2.c()));
                    } else {
                        arrayList.add(fromJson(lVarA2.l()));
                    }
                }
                keybindMessage.setExtra(arrayList);
            }
            return keybindMessage;
        }
        throw new IllegalArgumentException("Cannot convert " + lVar.getClass().getSimpleName() + " to a message.");
    }

    @Override // com.github.steveice10.mc.common.message.MessageInterface
    public String getFullText() {
        StringBuilder sb = new StringBuilder(getText());
        Iterator<MessageInterface> it = this.extra.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getFullText());
        }
        return sb.toString();
    }

    @Override // com.github.steveice10.mc.common.message.MessageInterface
    public MessageStyle getStyle() {
        return this.style;
    }

    @Override // com.github.steveice10.mc.common.message.MessageInterface
    public Message setStyle(MessageStyle messageStyle) {
        this.style = messageStyle;
        return this;
    }

    @Override // com.github.steveice10.mc.common.message.MessageInterface
    public List<MessageInterface> getExtra() {
        return new ArrayList(this.extra);
    }

    @Override // com.github.steveice10.mc.common.message.MessageInterface
    public MessageInterface setExtra(List<MessageInterface> list) {
        this.extra = new ArrayList(list);
        Iterator<MessageInterface> it = this.extra.iterator();
        while (it.hasNext()) {
            it.next().getStyle().setParent(this.style);
        }
        return this;
    }

    @Override // com.github.steveice10.mc.common.message.MessageInterface
    public MessageInterface addExtra(MessageInterface messageInterface) {
        this.extra.add(messageInterface);
        messageInterface.getStyle().setParent(this.style);
        return this;
    }

    @Override // com.github.steveice10.mc.common.message.MessageInterface
    public MessageInterface removeExtra(MessageInterface messageInterface) {
        this.extra.remove(messageInterface);
        messageInterface.getStyle().setParent(null);
        return this;
    }

    @Override // com.github.steveice10.mc.common.message.MessageInterface
    public Message clearExtra() {
        Iterator<MessageInterface> it = this.extra.iterator();
        while (it.hasNext()) {
            it.next().getStyle().setParent(null);
        }
        this.extra.clear();
        return this;
    }

    public String toString() {
        return getFullText();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Message message = (Message) obj;
        return this.extra.equals(message.extra) && this.style.equals(message.style);
    }

    public int hashCode() {
        return (this.style.hashCode() * 31) + this.extra.hashCode();
    }

    @Override // com.github.steveice10.mc.common.message.MessageInterface
    public String toJsonString() {
        return toJson().toString();
    }

    @Override // com.github.steveice10.mc.common.message.MessageInterface
    public l toJson() {
        n nVar = new n();
        nVar.a("color", this.style.getColor().toString());
        for (ChatFormat chatFormat : this.style.getFormats()) {
            if (chatFormat != null) {
                nVar.a(chatFormat.toString(), (Boolean) true);
            }
        }
        if (this.style.getClickEvent() != null) {
            n nVar2 = new n();
            nVar2.a("action", this.style.getClickEvent().getAction().toString());
            nVar2.a("value", this.style.getClickEvent().getValue());
            nVar.a("clickEvent", nVar2);
        }
        if (this.style.getHoverEvent() != null) {
            n nVar3 = new n();
            nVar3.a("action", this.style.getHoverEvent().getAction().toString());
            nVar3.a("value", this.style.getHoverEvent().getValue().toJson());
            nVar.a("hoverEvent", nVar3);
        }
        if (this.style.getInsertion() != null) {
            nVar.a("insertion", this.style.getInsertion());
        }
        if (this.extra.size() > 0) {
            i iVar = new i();
            Iterator<MessageInterface> it = this.extra.iterator();
            while (it.hasNext()) {
                iVar.a(it.next().toJson());
            }
            nVar.a("extra", iVar);
        }
        return nVar;
    }
}
