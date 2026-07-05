package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes.dex */
final class bmr implements bmt {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Activity f2848a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Bundle f2849b;

    bmr(bml bmlVar, Activity activity, Bundle bundle) {
        this.f2848a = activity;
        this.f2849b = bundle;
    }

    @Override // com.google.android.gms.internal.ads.bmt
    public final void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.f2848a, this.f2849b);
    }
}
