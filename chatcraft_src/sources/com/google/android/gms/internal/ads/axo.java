package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes.dex */
final class axo implements axq {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Activity f2379a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Bundle f2380b;

    axo(axh axhVar, Activity activity, Bundle bundle) {
        this.f2379a = activity;
        this.f2380b = bundle;
    }

    @Override // com.google.android.gms.internal.ads.axq
    public final void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.f2379a, this.f2380b);
    }
}
