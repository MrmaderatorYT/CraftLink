package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
final class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Drawable f1635a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ j f1636b;

    k(j jVar, Drawable drawable) {
        this.f1636b = jVar;
        this.f1635a = drawable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1636b.f1634a.f1626a.getWindow().setBackgroundDrawable(this.f1635a);
    }
}
