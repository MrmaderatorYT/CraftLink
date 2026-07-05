package com.google.android.gms.internal.ads;

import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class pl implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ WeakReference f3358a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ pd f3359b;

    pl(pd pdVar, WeakReference weakReference) {
        this.f3359b = pdVar;
        this.f3358a = weakReference;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f3359b.a((WeakReference<afu>) this.f3358a, false);
    }
}
