package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

/* loaded from: classes.dex */
final class bnf implements ValueCallback<String> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bnd f2868a;

    bnf(bnd bndVar) {
        this.f2868a = bndVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(String str) {
        this.f2868a.d.a(this.f2868a.f2866a, this.f2868a.f2867b, str, this.f2868a.c);
    }
}
