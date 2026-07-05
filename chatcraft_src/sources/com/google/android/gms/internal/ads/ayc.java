package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class ayc implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a, reason: collision with root package name */
    private static final Handler f2402a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    private final Context f2403b;
    private Application c;
    private final PowerManager d;
    private final KeyguardManager e;
    private final axt f;
    private BroadcastReceiver g;
    private WeakReference<ViewTreeObserver> h;
    private WeakReference<View> i;
    private axh j;
    private boolean k = false;
    private int l = -1;
    private long m = -3;

    public ayc(axt axtVar, View view) {
        this.f = axtVar;
        this.f2403b = axtVar.f2387a;
        this.d = (PowerManager) this.f2403b.getSystemService("power");
        this.e = (KeyguardManager) this.f2403b.getSystemService("keyguard");
        if (this.f2403b instanceof Application) {
            this.c = (Application) this.f2403b;
            this.j = new axh((Application) this.f2403b, this);
        }
        a(view);
    }

    final void a(View view) {
        View view2 = this.i != null ? this.i.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            c(view2);
        }
        this.i = new WeakReference<>(view);
        if (view != null) {
            if ((view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true) {
                b(view);
            }
            view.addOnAttachStateChangeListener(this);
            this.m = -2L;
            return;
        }
        this.m = -3L;
    }

    private final void b() {
        f2402a.post(new ayd(this));
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.l = -1;
        b(view);
        c();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.l = -1;
        c();
        b();
        c(view);
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
        this.l = i;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity, 0);
        c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(activity, 0);
        c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(activity, 0);
        c();
        b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(activity, 4);
        c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        c();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        c();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        c();
    }

    public final long a() {
        if (this.m == -2 && this.i.get() == null) {
            this.m = -3L;
        }
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            r9 = this;
            java.lang.ref.WeakReference<android.view.View> r0 = r9.i
            if (r0 != 0) goto L5
            return
        L5:
            java.lang.ref.WeakReference<android.view.View> r0 = r9.i
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            r1 = 0
            if (r0 != 0) goto L17
            r2 = -3
            r9.m = r2
            r9.k = r1
            return
        L17:
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            boolean r2 = r0.getGlobalVisibleRect(r2)
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>()
            boolean r3 = r0.getLocalVisibleRect(r3)
            com.google.android.gms.internal.ads.axt r4 = r9.f
            boolean r4 = r4.j()
            r5 = 1
            if (r4 != 0) goto L5d
            android.app.KeyguardManager r4 = r9.e
            boolean r4 = r4.inKeyguardRestrictedInputMode()
            if (r4 == 0) goto L5b
            android.app.Activity r4 = com.google.android.gms.internal.ads.aya.a(r0)
            if (r4 == 0) goto L57
            android.view.Window r4 = r4.getWindow()
            if (r4 != 0) goto L48
            r4 = 0
            goto L4c
        L48:
            android.view.WindowManager$LayoutParams r4 = r4.getAttributes()
        L4c:
            if (r4 == 0) goto L57
            int r4 = r4.flags
            r6 = 524288(0x80000, float:7.34684E-40)
            r4 = r4 & r6
            if (r4 == 0) goto L57
            r4 = 1
            goto L58
        L57:
            r4 = 0
        L58:
            if (r4 == 0) goto L5b
            goto L5d
        L5b:
            r4 = 0
            goto L5e
        L5d:
            r4 = 1
        L5e:
            int r6 = r0.getWindowVisibility()
            int r7 = r9.l
            r8 = -1
            if (r7 == r8) goto L69
            int r6 = r9.l
        L69:
            int r7 = r0.getVisibility()
            if (r7 != 0) goto L86
            boolean r0 = r0.isShown()
            if (r0 == 0) goto L86
            android.os.PowerManager r0 = r9.d
            boolean r0 = r0.isScreenOn()
            if (r0 == 0) goto L86
            if (r4 == 0) goto L86
            if (r3 == 0) goto L86
            if (r2 == 0) goto L86
            if (r6 != 0) goto L86
            r1 = 1
        L86:
            boolean r0 = r9.k
            if (r0 == r1) goto L97
            if (r1 == 0) goto L91
            long r2 = android.os.SystemClock.elapsedRealtime()
            goto L93
        L91:
            r2 = -2
        L93:
            r9.m = r2
            r9.k = r1
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ayc.c():void");
    }

    private final void b(View view) {
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
            this.g = new aye(this);
            this.f2403b.registerReceiver(this.g, intentFilter);
        }
        if (this.c != null) {
            try {
                this.c.registerActivityLifecycleCallbacks(this.j);
            } catch (Exception unused) {
            }
        }
    }

    private final void c(View view) {
        try {
            if (this.h != null) {
                ViewTreeObserver viewTreeObserver = this.h.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.h = null;
            }
        } catch (Exception unused) {
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception unused2) {
        }
        if (this.g != null) {
            try {
                this.f2403b.unregisterReceiver(this.g);
            } catch (Exception unused3) {
            }
            this.g = null;
        }
        if (this.c != null) {
            try {
                this.c.unregisterActivityLifecycleCallbacks(this.j);
            } catch (Exception unused4) {
            }
        }
    }
}
