package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes.dex */
final class bmm implements bmt {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Activity f2842a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Bundle f2843b;

    bmm(bml bmlVar, Activity activity, Bundle bundle) {
        this.f2842a = activity;
        this.f2843b = bundle;
    }

    @Override // com.google.android.gms.internal.ads.bmt
    public final void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.f2842a, this.f2843b);
    }
}
