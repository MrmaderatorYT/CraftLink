package com.google.android.gms.internal.ads;

import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class pm implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ WeakReference f3360a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ pd f3361b;

    pm(pd pdVar, WeakReference weakReference) {
        this.f3361b = pdVar;
        this.f3360a = weakReference;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        this.f3361b.a((WeakReference<afu>) this.f3360a, true);
    }
}
