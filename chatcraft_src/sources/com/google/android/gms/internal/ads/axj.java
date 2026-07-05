package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes.dex */
final class axj implements axq {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Activity f2373a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Bundle f2374b;

    axj(axh axhVar, Activity activity, Bundle bundle) {
        this.f2373a = activity;
        this.f2374b = bundle;
    }

    @Override // com.google.android.gms.internal.ads.axq
    public final void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.f2373a, this.f2374b);
    }
}
