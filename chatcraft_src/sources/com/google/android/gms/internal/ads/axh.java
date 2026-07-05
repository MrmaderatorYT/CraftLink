package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class axh implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private final Application f2369a;

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference<Application.ActivityLifecycleCallbacks> f2370b;
    private boolean c = false;

    public axh(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.f2370b = new WeakReference<>(activityLifecycleCallbacks);
        this.f2369a = application;
    }

    private final void a(axq axqVar) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.f2370b.get();
            if (activityLifecycleCallbacks != null) {
                axqVar.a(activityLifecycleCallbacks);
            } else {
                if (this.c) {
                    return;
                }
                this.f2369a.unregisterActivityLifecycleCallbacks(this);
                this.c = true;
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(new axj(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(new axk(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(new axl(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(new axm(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(new axn(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a(new axo(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        a(new axp(this, activity));
    }
}
