package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* loaded from: classes.dex */
final class axm implements axq {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Activity f2377a;

    axm(axh axhVar, Activity activity) {
        this.f2377a = activity;
    }

    @Override // com.google.android.gms.internal.ads.axq
    public final void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.f2377a);
    }
}
