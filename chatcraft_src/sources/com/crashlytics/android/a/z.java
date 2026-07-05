package com.crashlytics.android.a;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.crashlytics.android.a.ab;
import com.crashlytics.android.a.k;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: SessionAnalyticsManager.java */
/* loaded from: classes.dex */
class z implements k.a {

    /* renamed from: a, reason: collision with root package name */
    final e f1291a;

    /* renamed from: b, reason: collision with root package name */
    final io.fabric.sdk.android.a f1292b;
    final k c;
    final h d;
    private final long e;

    public void a(String str) {
    }

    public static z a(io.fabric.sdk.android.h hVar, Context context, io.fabric.sdk.android.services.b.r rVar, String str, String str2, long j) {
        ae aeVar = new ae(context, rVar, str, str2);
        f fVar = new f(context, new io.fabric.sdk.android.services.d.b(hVar));
        io.fabric.sdk.android.services.network.b bVar = new io.fabric.sdk.android.services.network.b(io.fabric.sdk.android.c.g());
        io.fabric.sdk.android.a aVar = new io.fabric.sdk.android.a(context);
        ScheduledExecutorService scheduledExecutorServiceB = io.fabric.sdk.android.services.b.n.b("Answers Events Handler");
        return new z(new e(hVar, context, fVar, aeVar, bVar, scheduledExecutorServiceB, new p(context)), aVar, new k(scheduledExecutorServiceB), h.a(context), j);
    }

    z(e eVar, io.fabric.sdk.android.a aVar, k kVar, h hVar, long j) {
        this.f1291a = eVar;
        this.f1292b = aVar;
        this.c = kVar;
        this.d = hVar;
        this.e = j;
    }

    public void b() throws ExecutionException, InterruptedException {
        this.f1291a.b();
        this.f1292b.a(new g(this, this.c));
        this.c.a(this);
        if (d()) {
            a(this.e);
            this.d.a();
        }
    }

    public void c() {
        this.f1292b.a();
        this.f1291a.a();
    }

    public void a(String str, String str2) throws ExecutionException, InterruptedException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("onCrash called from main thread!!!");
        }
        io.fabric.sdk.android.c.g().a("Answers", "Logged crash");
        this.f1291a.c(ab.a(str, str2));
    }

    public void a(long j) throws ExecutionException, InterruptedException {
        io.fabric.sdk.android.c.g().a("Answers", "Logged install");
        this.f1291a.b(ab.a(j));
    }

    public void a(Activity activity, ab.b bVar) {
        io.fabric.sdk.android.c.g().a("Answers", "Logged lifecycle event: " + bVar.name());
        this.f1291a.a(ab.a(bVar, activity));
    }

    @Override // com.crashlytics.android.a.k.a
    public void a() {
        io.fabric.sdk.android.c.g().a("Answers", "Flush events when app is backgrounded");
        this.f1291a.c();
    }

    public void a(io.fabric.sdk.android.services.e.b bVar, String str) {
        this.c.a(bVar.j);
        this.f1291a.a(bVar, str);
    }

    boolean d() {
        return !this.d.b();
    }
}
