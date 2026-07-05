package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class bml implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private final Application f2840a;

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference<Application.ActivityLifecycleCallbacks> f2841b;
    private boolean c = false;

    public bml(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.f2841b = new WeakReference<>(activityLifecycleCallbacks);
        this.f2840a = application;
    }

    private final void a(bmt bmtVar) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.f2841b.get();
            if (activityLifecycleCallbacks != null) {
                bmtVar.a(activityLifecycleCallbacks);
            } else {
                if (this.c) {
                    return;
                }
                this.f2840a.unregisterActivityLifecycleCallbacks(this);
                this.c = true;
            }
        } catch (Exception e) {
            xe.b("Error while dispatching lifecycle callback.", e);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(new bmm(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(new bmn(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(new bmo(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(new bmp(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(new bmq(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a(new bmr(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        a(new bms(this, activity));
    }
}
