package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

@qj
/* loaded from: classes.dex */
abstract class acg {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<View> f1831a;

    public acg(View view) {
        this.f1831a = new WeakReference<>(view);
    }

    protected abstract void a(ViewTreeObserver viewTreeObserver);

    protected abstract void b(ViewTreeObserver viewTreeObserver);

    public final void a() {
        ViewTreeObserver viewTreeObserverC = c();
        if (viewTreeObserverC != null) {
            a(viewTreeObserverC);
        }
    }

    public final void b() {
        ViewTreeObserver viewTreeObserverC = c();
        if (viewTreeObserverC != null) {
            b(viewTreeObserverC);
        }
    }

    private final ViewTreeObserver c() {
        ViewTreeObserver viewTreeObserver;
        View view = this.f1831a.get();
        if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return null;
        }
        return viewTreeObserver;
    }
}
