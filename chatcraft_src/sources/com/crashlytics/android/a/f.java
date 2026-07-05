package com.crashlytics.android.a;

import android.content.Context;
import android.os.Looper;

/* compiled from: AnswersFilesManagerProvider.java */
/* loaded from: classes.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    final Context f1265a;

    /* renamed from: b, reason: collision with root package name */
    final io.fabric.sdk.android.services.d.a f1266b;

    public f(Context context, io.fabric.sdk.android.services.d.a aVar) {
        this.f1265a = context;
        this.f1266b = aVar;
    }

    public x a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
        }
        return new x(this.f1265a, new ad(), new io.fabric.sdk.android.services.b.v(), new io.fabric.sdk.android.services.c.g(this.f1265a, this.f1266b.a(), "session_analytics.tap", "session_analytics_to_send"));
    }
}
