package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* loaded from: classes.dex */
final class axn implements axq {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Activity f2378a;

    axn(axh axhVar, Activity activity) {
        this.f2378a = activity;
    }

    @Override // com.google.android.gms.internal.ads.axq
    public final void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStopped(this.f2378a);
    }
}
