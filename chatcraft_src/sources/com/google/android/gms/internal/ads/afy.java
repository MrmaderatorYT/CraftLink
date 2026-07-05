package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes.dex */
final class afy implements View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ vv f1946a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ afv f1947b;

    afy(afv afvVar, vv vvVar) {
        this.f1947b = afvVar;
        this.f1946a = vvVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f1947b.a(view, this.f1946a, 10);
    }
}
