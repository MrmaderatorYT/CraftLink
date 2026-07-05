package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class aur {

    /* renamed from: a, reason: collision with root package name */
    protected static final Charset f2285a = Charset.forName("UTF-8");
    private static final Charset c = Charset.forName("ISO-8859-1");

    /* renamed from: b, reason: collision with root package name */
    public static final Object f2286b = new Object();

    public static void a(aun aunVar, aun aunVar2) {
        if (aunVar.Z != null) {
            aunVar2.Z = (aup) aunVar.Z.clone();
        }
    }
}
