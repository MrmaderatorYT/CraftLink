package com.crashlytics.android.a;

import android.app.Activity;
import android.os.Bundle;
import com.crashlytics.android.a.ab;
import io.fabric.sdk.android.a;

/* compiled from: AnswersLifecycleCallbacks.java */
/* loaded from: classes.dex */
class g extends a.b {

    /* renamed from: a, reason: collision with root package name */
    private final z f1267a;

    /* renamed from: b, reason: collision with root package name */
    private final k f1268b;

    @Override // io.fabric.sdk.android.a.b
    public void a(Activity activity, Bundle bundle) {
    }

    @Override // io.fabric.sdk.android.a.b
    public void b(Activity activity, Bundle bundle) {
    }

    @Override // io.fabric.sdk.android.a.b
    public void e(Activity activity) {
    }

    public g(z zVar, k kVar) {
        this.f1267a = zVar;
        this.f1268b = kVar;
    }

    @Override // io.fabric.sdk.android.a.b
    public void a(Activity activity) {
        this.f1267a.a(activity, ab.b.START);
    }

    @Override // io.fabric.sdk.android.a.b
    public void b(Activity activity) {
        this.f1267a.a(activity, ab.b.RESUME);
        this.f1268b.a();
    }

    @Override // io.fabric.sdk.android.a.b
    public void c(Activity activity) {
        this.f1267a.a(activity, ab.b.PAUSE);
        this.f1268b.b();
    }

    @Override // io.fabric.sdk.android.a.b
    public void d(Activity activity) {
        this.f1267a.a(activity, ab.b.STOP);
    }
}
