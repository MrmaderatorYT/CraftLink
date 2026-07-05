package com.google.android.gms.internal.ads;

import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public final class bki {
    public static boolean a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getEventType() == 3 && xmlPullParser.getName().equals(str);
    }

    public static boolean b(XmlPullParser xmlPullParser, String str) {
        return a(xmlPullParser) && xmlPullParser.getName().equals(str);
    }

    public static boolean a(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 2;
    }
}
