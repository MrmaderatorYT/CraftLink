package com.google.android.gms.common;

import android.content.Context;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final int f1702a = e.f1704a;

    /* renamed from: b, reason: collision with root package name */
    private static final d f1703b = new d();

    public static d a() {
        return f1703b;
    }

    d() {
    }

    public int a(Context context) {
        return a(context, f1702a);
    }

    public int a(Context context, int i) {
        int iA = e.a(context, i);
        if (e.b(context, iA)) {
            return 18;
        }
        return iA;
    }

    public int b(Context context) {
        return e.b(context);
    }
}
