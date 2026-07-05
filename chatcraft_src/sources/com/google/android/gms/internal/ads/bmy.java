package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@TargetApi(14)
/* loaded from: classes.dex */
final class bmy implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private Activity f2857a;

    /* renamed from: b, reason: collision with root package name */
    private Context f2858b;
    private Runnable h;
    private long j;
    private final Object c = new Object();
    private boolean d = true;
    private boolean e = false;

    @GuardedBy("mLock")
    private final List<bna> f = new ArrayList();

    @GuardedBy("mLock")
    private final List<bno> g = new ArrayList();
    private boolean i = false;

    bmy() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    public final void a(Application application, Context context) {
        if (this.i) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this);
        if (context instanceof Activity) {
            a((Activity) context);
        }
        this.f2858b = application;
        this.j = ((Long) bra.e().a(o.au)).longValue();
        this.i = true;
    }

    public final void a(bna bnaVar) {
        synchronized (this.c) {
            this.f.add(bnaVar);
        }
    }

    public final Activity a() {
        return this.f2857a;
    }

    public final Context b() {
        return this.f2858b;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(activity);
        this.e = false;
        boolean z = !this.d;
        this.d = true;
        if (this.h != null) {
            xn.f3583a.removeCallbacks(this.h);
        }
        synchronized (this.c) {
            Iterator<bno> it = this.g.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a(activity);
                } catch (Exception e) {
                    com.google.android.gms.ads.internal.ax.i().a(e, "AppActivityTracker.ActivityListener.onActivityResumed");
                    aan.b(BuildConfig.FLAVOR, e);
                }
            }
            if (z) {
                Iterator<bna> it2 = this.f.iterator();
                while (it2.hasNext()) {
                    try {
                        it2.next().a(true);
                    } catch (Exception e2) {
                        aan.b(BuildConfig.FLAVOR, e2);
                    }
                }
            } else {
                xe.b("App is still foreground.");
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(activity);
        synchronized (this.c) {
            Iterator<bno> it = this.g.iterator();
            while (it.hasNext()) {
                try {
                    it.next().b(activity);
                } catch (Exception e) {
                    com.google.android.gms.ads.internal.ax.i().a(e, "AppActivityTracker.ActivityListener.onActivityPaused");
                    aan.b(BuildConfig.FLAVOR, e);
                }
            }
        }
        this.e = true;
        if (this.h != null) {
            xn.f3583a.removeCallbacks(this.h);
        }
        Handler handler = xn.f3583a;
        bmz bmzVar = new bmz(this);
        this.h = bmzVar;
        handler.postDelayed(bmzVar, this.j);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.c) {
            if (this.f2857a == null) {
                return;
            }
            if (this.f2857a.equals(activity)) {
                this.f2857a = null;
            }
            Iterator<bno> it = this.g.iterator();
            while (it.hasNext()) {
                try {
                    if (it.next().c(activity)) {
                        it.remove();
                    }
                } catch (Exception e) {
                    com.google.android.gms.ads.internal.ax.i().a(e, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                    aan.b(BuildConfig.FLAVOR, e);
                }
            }
        }
    }

    private final void a(Activity activity) {
        synchronized (this.c) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.f2857a = activity;
            }
        }
    }

    static /* synthetic */ boolean a(bmy bmyVar, boolean z) {
        bmyVar.d = false;
        return false;
    }
}
