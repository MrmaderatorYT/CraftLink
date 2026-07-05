package com.github.steveice10.mc.v1_7_7.protocol.data.message;

import com.github.steveice10.mc.common.message.ChatColor;
import com.github.steveice10.mc.common.message.ChatFormat;
import com.github.steveice10.mc.common.message.ClickAction;
import com.github.steveice10.mc.common.message.ClickEvent;
import com.github.steveice10.mc.common.message.HoverAction;
import com.github.steveice10.mc.common.message.HoverEvent;
import com.github.steveice10.mc.common.message.MessageInterface;
import com.github.steveice10.mc.common.message.MessageStyle;
import com.google.gson.f;
import com.google.gson.i;
import com.google.gson.l;
import com.google.gson.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class Message implements MessageInterface, Cloneable {
    private MessageStyle style = new MessageStyle();
    private List<MessageInterface> extra = new ArrayList();

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public abstract Message mo7clone();

    @Override // com.github.steveice10.mc.common.message.MessageInterface
    public abstract String getText();

    public static Message fromString(String str) {
        try {
            return fromJson((l) new f().a(str, n.class));
        } catch (Exception unused) {
            return new TextMessage(str);
        }
    }

    public static Message fromJson(l lVar) {
        Message translationMessage;
        if (lVar.j()) {
            return new TextMessage(lVar.c());
        }
        if (lVar.i()) {
            n nVarL = lVar.l();
            if (nVarL.a("text")) {
                translationMessage = new TextMessage(nVarL.b("text").c());
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
                translationMessage = new TranslationMessage(nVarL.b("translate").c(), messageArr);
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
                n nVarL2 = nVarL.b("clickEvent").l();
                messageStyle.setClickEvent(new ClickEvent(ClickAction.byName(nVarL2.b("action").c()), nVarL2.b("value").c()));
            }
            if (nVarL.a("hoverEvent")) {
                n nVarL3 = nVarL.b("hoverEvent").l();
                messageStyle.setHoverEvent(new HoverEvent(HoverAction.byName(nVarL3.b("action").c()), fromJson(nVarL3.b("value"))));
            }
            if (nVarL.a("insertion")) {
                messageStyle.setInsertion(nVarL.b("insertion").c());
            }
            translationMessage.setStyle(messageStyle);
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
                translationMessage.setExtra(arrayList);
            }
            return translationMessage;
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
    public Message addExtra(MessageInterface messageInterface) {
        this.extra.add(messageInterface);
        messageInterface.getStyle().setParent(this.style);
        return this;
    }

    @Override // com.github.steveice10.mc.common.message.MessageInterface
    public Message removeExtra(MessageInterface messageInterface) {
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

    @Override // com.github.steveice10.mc.common.message.MessageInterface
    public String toJsonString() {
        return toJson().toString();
    }

    @Override // com.github.steveice10.mc.common.message.MessageInterface
    public l toJson() {
        n nVar = new n();
        nVar.a("color", this.style.getColor().toString());
        Iterator<ChatFormat> it = this.style.getFormats().iterator();
        while (it.hasNext()) {
            nVar.a(it.next().toString(), (Boolean) true);
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
            Iterator<MessageInterface> it2 = this.extra.iterator();
            while (it2.hasNext()) {
                iVar.a(it2.next().toJson());
            }
            nVar.a("extra", iVar);
        }
        return nVar;
    }
}
