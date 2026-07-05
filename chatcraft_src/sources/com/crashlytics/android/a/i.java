package com.crashlytics.android.a;

import java.io.File;
import java.util.List;

/* compiled from: AnswersRetryFilesSender.java */
/* loaded from: classes.dex */
class i implements io.fabric.sdk.android.services.c.f {

    /* renamed from: a, reason: collision with root package name */
    private final y f1270a;

    /* renamed from: b, reason: collision with root package name */
    private final v f1271b;

    public static i a(y yVar) {
        return new i(yVar, new v(new io.fabric.sdk.android.services.concurrency.a.e(new u(new io.fabric.sdk.android.services.concurrency.a.c(1000L, 8), 0.1d), new io.fabric.sdk.android.services.concurrency.a.b(5))));
    }

    i(y yVar, v vVar) {
        this.f1270a = yVar;
        this.f1271b = vVar;
    }

    @Override // io.fabric.sdk.android.services.c.f
    public boolean a(List<File> list) {
        long jNanoTime = System.nanoTime();
        if (!this.f1271b.a(jNanoTime)) {
            return false;
        }
        if (this.f1270a.a(list)) {
            this.f1271b.a();
            return true;
        }
        this.f1271b.b(jNanoTime);
        return false;
    }
}
