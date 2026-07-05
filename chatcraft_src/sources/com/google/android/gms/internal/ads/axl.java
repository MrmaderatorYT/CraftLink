package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* loaded from: classes.dex */
final class axl implements axq {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Activity f2376a;

    axl(axh axhVar, Activity activity) {
        this.f2376a = activity;
    }

    @Override // com.google.android.gms.internal.ads.axq
    public final void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityResumed(this.f2376a);
    }
}
