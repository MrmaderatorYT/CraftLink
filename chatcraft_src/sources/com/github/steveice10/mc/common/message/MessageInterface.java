package com.github.steveice10.mc.common.message;

import com.google.gson.l;
import java.util.List;

/* loaded from: classes.dex */
public interface MessageInterface {
    MessageInterface addExtra(MessageInterface messageInterface);

    MessageInterface clearExtra();

    MessageInterface clone();

    List<MessageInterface> getExtra();

    String getFullText();

    MessageStyle getStyle();

    String getText();

    MessageInterface removeExtra(MessageInterface messageInterface);

    MessageInterface setExtra(List<MessageInterface> list);

    MessageInterface setStyle(MessageStyle messageStyle);

    l toJson();

    String toJsonString();
}
