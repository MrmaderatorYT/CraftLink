package com.github.steveice10.mc.v1_9.protocol.data.message;

import com.github.steveice10.mc.common.message.MessageStyle;
import com.google.gson.i;
import com.google.gson.l;
import com.google.gson.n;
import java.util.Arrays;
import mattecarra.usavsursschat.d;

/* loaded from: classes.dex */
public class TranslationMessage extends Message {
    private String translationKey;
    private Message[] translationParams;

    public TranslationMessage(String str, Message... messageArr) {
        this.translationKey = str;
        this.translationParams = messageArr;
        this.translationParams = getTranslationParams();
        for (Message message : this.translationParams) {
            message.getStyle().setParent(getStyle());
        }
    }

    public String getTranslationKey() {
        return this.translationKey;
    }

    public Message[] getTranslationParams() {
        Message[] messageArr = (Message[]) Arrays.copyOf(this.translationParams, this.translationParams.length);
        for (int i = 0; i < messageArr.length; i++) {
            messageArr[i] = messageArr[i].mo4clone();
        }
        return messageArr;
    }

    private String getStringWithoutTranslation() {
        StringBuilder sb = new StringBuilder();
        for (Message message : this.translationParams) {
            sb.append(message);
            sb.append(" ");
        }
        return sb.length() <= 1 ? sb.toString() : sb.substring(0, sb.length() - 1);
    }

    @Override // com.github.steveice10.mc.v1_9.protocol.data.message.Message, com.github.steveice10.mc.common.message.MessageInterface
    public Message setStyle(MessageStyle messageStyle) {
        super.setStyle(messageStyle);
        for (Message message : this.translationParams) {
            message.getStyle().setParent(getStyle());
        }
        return this;
    }

    @Override // com.github.steveice10.mc.v1_9.protocol.data.message.Message, com.github.steveice10.mc.common.message.MessageInterface
    public String getText() {
        int i;
        char cCharAt;
        try {
            String strA = d.a(this.translationKey);
            if (strA == null) {
                System.out.println("Cannot find translation: " + this.translationKey);
                return getStringWithoutTranslation();
            }
            if (this.translationParams.length == 0 || !strA.contains("%")) {
                return strA;
            }
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            int i3 = 0;
            while (i2 < strA.length()) {
                char cCharAt2 = strA.charAt(i2);
                if (cCharAt2 == '%' && i2 < strA.length() - 1 && (((cCharAt = strA.charAt((i = i2 + 1))) == 's' || cCharAt == 'd') && i3 < this.translationParams.length)) {
                    sb.append(this.translationParams[i3].getFullText());
                    i3++;
                    i2 = i;
                } else {
                    sb.append(cCharAt2);
                }
                i2++;
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return getStringWithoutTranslation();
        }
    }

    @Override // com.github.steveice10.mc.v1_9.protocol.data.message.Message
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TranslationMessage mo9clone() {
        return (TranslationMessage) new TranslationMessage(getTranslationKey(), getTranslationParams()).setStyle(getStyle().m2clone()).setExtra(getExtra());
    }

    @Override // com.github.steveice10.mc.v1_9.protocol.data.message.Message, com.github.steveice10.mc.common.message.MessageInterface
    public l toJson() {
        l json = super.toJson();
        if (!json.i()) {
            return json;
        }
        n nVarL = json.l();
        nVarL.a("translate", this.translationKey);
        i iVar = new i();
        for (Message message : this.translationParams) {
            iVar.a(message.toJson());
        }
        nVarL.a("with", iVar);
        return nVarL;
    }

    @Override // com.github.steveice10.mc.v1_9.protocol.data.message.Message
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        TranslationMessage translationMessage = (TranslationMessage) obj;
        return this.translationKey.equals(translationMessage.translationKey) && Arrays.equals(this.translationParams, translationMessage.translationParams);
    }

    @Override // com.github.steveice10.mc.v1_9.protocol.data.message.Message
    public int hashCode() {
        return (((super.hashCode() * 31) + this.translationKey.hashCode()) * 31) + Arrays.hashCode(this.translationParams);
    }
}
