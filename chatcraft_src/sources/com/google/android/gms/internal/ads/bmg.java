package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

@qj
@TargetApi(14)
/* loaded from: classes.dex */
public final class bmg implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a, reason: collision with root package name */
    private static final long f2834a = ((Long) bra.e().a(o.aW)).longValue();

    /* renamed from: b, reason: collision with root package name */
    private final Context f2835b;
    private Application c;
    private final WindowManager d;
    private final PowerManager e;
    private final KeyguardManager f;
    private BroadcastReceiver g;
    private WeakReference<ViewTreeObserver> h;
    private WeakReference<View> i;
    private bml j;
    private zr k = new zr(f2834a);
    private boolean l = false;
    private int m = -1;
    private final HashSet<bmk> n = new HashSet<>();
    private final DisplayMetrics o;
    private final Rect p;

    public bmg(Context context, View view) {
        this.f2835b = context.getApplicationContext();
        this.d = (WindowManager) context.getSystemService("window");
        this.e = (PowerManager) this.f2835b.getSystemService("power");
        this.f = (KeyguardManager) context.getSystemService("keyguard");
        if (this.f2835b instanceof Application) {
            this.c = (Application) this.f2835b;
            this.j = new bml((Application) this.f2835b, this);
        }
        this.o = context.getResources().getDisplayMetrics();
        this.p = new Rect();
        this.p.right = this.d.getDefaultDisplay().getWidth();
        this.p.bottom = this.d.getDefaultDisplay().getHeight();
        View view2 = this.i != null ? this.i.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            b(view2);
        }
        this.i = new WeakReference<>(view);
        if (view != null) {
            if (com.google.android.gms.ads.internal.ax.g().a(view)) {
                a(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    public final void a(bmk bmkVar) {
        this.n.add(bmkVar);
        a(3);
    }

    public final void b(bmk bmkVar) {
        this.n.remove(bmkVar);
    }

    private final void b() {
        com.google.android.gms.ads.internal.ax.e();
        xn.f3583a.post(new bmh(this));
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.m = -1;
        a(view);
        a(3);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.m = -1;
        a(3);
        b();
        b(view);
    }

    private final void a(Activity activity, int i) {
        Window window;
        if (this.i == null || (window = activity.getWindow()) == null) {
            return;
        }
        View viewPeekDecorView = window.peekDecorView();
        View view = this.i.get();
        if (view == null || viewPeekDecorView == null || view.getRootView() != viewPeekDecorView.getRootView()) {
            return;
        }
        this.m = i;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity, 0);
        a(3);
        b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(activity, 0);
        a(3);
        b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(activity, 0);
        a(3);
        b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(activity, 4);
        a(3);
        b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(3);
        b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a(3);
        b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        a(3);
        b();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        a(2);
        b();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        a(1);
    }

    public final void a() {
        a(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i) {
        boolean z;
        boolean z2;
        if (this.n.size() == 0 || this.i == null) {
            return;
        }
        View view = this.i.get();
        boolean z3 = i == 1;
        boolean z4 = view == null;
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        Rect rect3 = new Rect();
        Rect rect4 = new Rect();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        if (view != null) {
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect2);
            boolean localVisibleRect = view.getLocalVisibleRect(rect3);
            view.getHitRect(rect4);
            try {
                view.getLocationOnScreen(iArr);
                view.getLocationInWindow(iArr2);
            } catch (Exception e) {
                xe.b("Failure getting view location.", e);
            }
            rect.left = iArr[0];
            rect.top = iArr[1];
            rect.right = rect.left + view.getWidth();
            rect.bottom = rect.top + view.getHeight();
            z = globalVisibleRect;
            z2 = localVisibleRect;
        } else {
            z = false;
            z2 = false;
        }
        int windowVisibility = view != null ? view.getWindowVisibility() : 8;
        if (this.m != -1) {
            windowVisibility = this.m;
        }
        boolean z5 = !z4 && com.google.android.gms.ads.internal.ax.e().a(view, this.e, this.f) && z && z2 && windowVisibility == 0;
        if (z3 && !this.k.a() && z5 == this.l) {
            return;
        }
        if (z5 || this.l || i != 1) {
            bmj bmjVar = new bmj(com.google.android.gms.ads.internal.ax.l().b(), this.e.isScreenOn(), view != null ? com.google.android.gms.ads.internal.ax.g().a(view) : false, view != null ? view.getWindowVisibility() : 8, a(this.p), a(rect), a(rect2), z, a(rect3), z2, a(rect4), this.o.density, z5);
            Iterator<bmk> it = this.n.iterator();
            while (it.hasNext()) {
                it.next().a(bmjVar);
            }
            this.l = z5;
        }
    }

    private final Rect a(Rect rect) {
        return new Rect(b(rect.left), b(rect.top), b(rect.right), b(rect.bottom));
    }

    private final int b(int i) {
        return (int) (i / this.o.density);
    }

    private final void a(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.h = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.g == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.g = new bmi(this);
            com.google.android.gms.ads.internal.ax.B().a(this.f2835b, this.g, intentFilter);
        }
        if (this.c != null) {
            try {
                this.c.registerActivityLifecycleCallbacks(this.j);
            } catch (Exception e) {
                xe.b("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    private final void b(View view) {
        try {
            if (this.h != null) {
                ViewTreeObserver viewTreeObserver = this.h.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.h = null;
            }
        } catch (Exception e) {
            xe.b("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e2) {
            xe.b("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        if (this.g != null) {
            try {
                com.google.android.gms.ads.internal.ax.B().a(this.f2835b, this.g);
            } catch (IllegalStateException e3) {
                xe.b("Failed trying to unregister the receiver", e3);
            } catch (Exception e4) {
                com.google.android.gms.ads.internal.ax.i().a(e4, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.g = null;
        }
        if (this.c != null) {
            try {
                this.c.unregisterActivityLifecycleCallbacks(this.j);
            } catch (Exception e5) {
                xe.b("Error registering activity lifecycle callbacks.", e5);
            }
        }
    }
}
