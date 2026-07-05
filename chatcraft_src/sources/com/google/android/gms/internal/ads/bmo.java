package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* loaded from: classes.dex */
final class bmo implements bmt {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Activity f2845a;

    bmo(bml bmlVar, Activity activity) {
        this.f2845a = activity;
    }

    @Override // com.google.android.gms.internal.ads.bmt
    public final void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityResumed(this.f2845a);
    }
}
