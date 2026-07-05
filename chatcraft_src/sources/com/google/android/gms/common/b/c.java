package com.google.android.gms.common.b;

import android.content.Context;

/* loaded from: classes.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static c f1698b = new c();

    /* renamed from: a, reason: collision with root package name */
    private b f1699a = null;

    private final synchronized b b(Context context) {
        if (this.f1699a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f1699a = new b(context);
        }
        return this.f1699a;
    }

    public static b a(Context context) {
        return f1698b.b(context);
    }
}
