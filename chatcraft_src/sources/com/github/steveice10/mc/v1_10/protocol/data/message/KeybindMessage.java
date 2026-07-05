package com.github.steveice10.mc.v1_10.protocol.data.message;

import com.google.gson.l;
import com.google.gson.n;

/* loaded from: classes.dex */
public class KeybindMessage extends Message {
    private String keybind;

    public KeybindMessage(String str) {
        this.keybind = str;
    }

    public String getKeybind() {
        return this.keybind;
    }

    @Override // com.github.steveice10.mc.v1_10.protocol.data.message.Message, com.github.steveice10.mc.common.message.MessageInterface
    public String getText() {
        return this.keybind;
    }

    @Override // com.github.steveice10.mc.v1_10.protocol.data.message.Message
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public KeybindMessage mo3clone() {
        return (KeybindMessage) new KeybindMessage(getKeybind()).setStyle(getStyle().m2clone()).setExtra(getExtra());
    }

    @Override // com.github.steveice10.mc.v1_10.protocol.data.message.Message, com.github.steveice10.mc.common.message.MessageInterface
    public l toJson() {
        l json = super.toJson();
        if (!json.i()) {
            return json;
        }
        n nVarL = json.l();
        nVarL.a("keybind", this.keybind);
        return nVarL;
    }

    @Override // com.github.steveice10.mc.v1_10.protocol.data.message.Message
    public boolean equals(Object obj) {
        return (obj instanceof KeybindMessage) && super.equals(obj) && this.keybind.equals(((KeybindMessage) obj).keybind);
    }

    @Override // com.github.steveice10.mc.v1_10.protocol.data.message.Message
    public int hashCode() {
        return (super.hashCode() * 31) + this.keybind.hashCode();
    }
}
