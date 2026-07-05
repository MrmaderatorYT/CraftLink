package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes.dex */
final class ahl implements View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ vv f1984a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ ahi f1985b;

    ahl(ahi ahiVar, vv vvVar) {
        this.f1985b = ahiVar;
        this.f1984a = vvVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f1985b.a(view, this.f1984a, 10);
    }
}
