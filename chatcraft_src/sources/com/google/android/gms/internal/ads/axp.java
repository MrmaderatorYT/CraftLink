package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* loaded from: classes.dex */
final class axp implements axq {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Activity f2381a;

    axp(axh axhVar, Activity activity) {
        this.f2381a = activity;
    }

    @Override // com.google.android.gms.internal.ads.axq
    public final void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityDestroyed(this.f2381a);
    }
}
