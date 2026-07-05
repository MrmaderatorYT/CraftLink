package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* loaded from: classes.dex */
final class bms implements bmt {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Activity f2850a;

    bms(bml bmlVar, Activity activity) {
        this.f2850a = activity;
    }

    @Override // com.google.android.gms.internal.ads.bmt
    public final void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityDestroyed(this.f2850a);
    }
}
