package androidx.fragment.app;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: OneShotPreDrawListener.java */
/* loaded from: classes.dex */
class r implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    private final View f789a;

    /* renamed from: b, reason: collision with root package name */
    private ViewTreeObserver f790b;
    private final Runnable c;

    private r(View view, Runnable runnable) {
        this.f789a = view;
        this.f790b = view.getViewTreeObserver();
        this.c = runnable;
    }

    public static r a(View view, Runnable runnable) {
        r rVar = new r(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(rVar);
        view.addOnAttachStateChangeListener(rVar);
        return rVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        a();
        this.c.run();
        return true;
    }

    public void a() {
        if (this.f790b.isAlive()) {
            this.f790b.removeOnPreDrawListener(this);
        } else {
            this.f789a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f789a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f790b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        a();
    }
}
