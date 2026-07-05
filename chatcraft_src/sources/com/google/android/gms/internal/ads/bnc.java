package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes.dex */
final class bnc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ View f2864a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bnb f2865b;

    bnc(bnb bnbVar, View view) {
        this.f2865b = bnbVar;
        this.f2864a = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2865b.a(this.f2864a);
    }
}
