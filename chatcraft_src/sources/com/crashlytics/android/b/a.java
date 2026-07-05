package com.crashlytics.android.b;

import io.fabric.sdk.android.c;
import io.fabric.sdk.android.h;
import io.fabric.sdk.android.services.b.m;
import io.fabric.sdk.android.services.b.r;
import java.util.Collections;
import java.util.Map;

/* compiled from: Beta.java */
/* loaded from: classes.dex */
public class a extends h<Boolean> implements m {
    @Override // io.fabric.sdk.android.h
    public String a() {
        return "1.2.10.27";
    }

    @Override // io.fabric.sdk.android.h
    public String b() {
        return "com.crashlytics.sdk.android:beta";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.h
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Boolean f() {
        c.g().a("Beta", "Beta kit initializing...");
        return true;
    }

    @Override // io.fabric.sdk.android.services.b.m
    public Map<r.a, String> e() {
        return Collections.emptyMap();
    }
}
