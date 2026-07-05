package com.github.steveice10.mc.v1_6_4.data.message;

import com.google.gson.l;
import com.google.gson.n;
import com.google.gson.p;

/* loaded from: classes.dex */
public class TextMessage extends Message {
    private String text;

    public TextMessage(String str) {
        this.text = str;
    }

    @Override // com.github.steveice10.mc.v1_6_4.data.message.Message, com.github.steveice10.mc.common.message.MessageInterface
    public String getText() {
        return this.text;
    }

    @Override // com.github.steveice10.mc.v1_6_4.data.message.Message
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TextMessage mo5clone() {
        return (TextMessage) new TextMessage(getText()).setStyle(getStyle().m2clone()).setExtra(getExtra());
    }

    @Override // com.github.steveice10.mc.v1_6_4.data.message.Message, com.github.steveice10.mc.common.message.MessageInterface
    public l toJson() {
        if (getStyle().isDefault() && getExtra().isEmpty()) {
            return new p(this.text);
        }
        l json = super.toJson();
        if (!json.i()) {
            return json;
        }
        n nVarL = json.l();
        nVarL.a("text", this.text);
        return nVarL;
    }
}
