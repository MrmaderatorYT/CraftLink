package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;

@qj
/* loaded from: classes.dex */
public final class aab {

    /* renamed from: a, reason: collision with root package name */
    private final View f1776a;

    /* renamed from: b, reason: collision with root package name */
    private Activity f1777b;
    private boolean c;
    private boolean d;
    private boolean e;
    private ViewTreeObserver.OnGlobalLayoutListener f;
    private ViewTreeObserver.OnScrollChangedListener g;

    public aab(Activity activity, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.f1777b = activity;
        this.f1776a = view;
        this.f = onGlobalLayoutListener;
        this.g = onScrollChangedListener;
    }

    public final void a(Activity activity) {
        this.f1777b = activity;
    }

    public final void a() {
        this.e = true;
        if (this.d) {
            e();
        }
    }

    public final void b() {
        this.e = false;
        f();
    }

    public final void c() {
        this.d = true;
        if (this.e) {
            e();
        }
    }

    public final void d() {
        this.d = false;
        f();
    }

    private final void e() {
        if (this.c) {
            return;
        }
        if (this.f != null) {
            if (this.f1777b != null) {
                Activity activity = this.f1777b;
                ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.f;
                ViewTreeObserver viewTreeObserverB = b(activity);
                if (viewTreeObserverB != null) {
                    viewTreeObserverB.addOnGlobalLayoutListener(onGlobalLayoutListener);
                }
            }
            com.google.android.gms.ads.internal.ax.D();
            acd.a(this.f1776a, this.f);
        }
        if (this.g != null) {
            if (this.f1777b != null) {
                Activity activity2 = this.f1777b;
                ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = this.g;
                ViewTreeObserver viewTreeObserverB2 = b(activity2);
                if (viewTreeObserverB2 != null) {
                    viewTreeObserverB2.addOnScrollChangedListener(onScrollChangedListener);
                }
            }
            com.google.android.gms.ads.internal.ax.D();
            acd.a(this.f1776a, this.g);
        }
        this.c = true;
    }

    private final void f() {
        if (this.f1777b != null && this.c) {
            if (this.f != null) {
                Activity activity = this.f1777b;
                ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.f;
                ViewTreeObserver viewTreeObserverB = b(activity);
                if (viewTreeObserverB != null) {
                    com.google.android.gms.ads.internal.ax.g().a(viewTreeObserverB, onGlobalLayoutListener);
                }
            }
            if (this.g != null) {
                Activity activity2 = this.f1777b;
                ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = this.g;
                ViewTreeObserver viewTreeObserverB2 = b(activity2);
                if (viewTreeObserverB2 != null) {
                    viewTreeObserverB2.removeOnScrollChangedListener(onScrollChangedListener);
                }
            }
            this.c = false;
        }
    }

    private static ViewTreeObserver b(Activity activity) {
        Window window;
        View decorView;
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return null;
        }
        return decorView.getViewTreeObserver();
    }
}
