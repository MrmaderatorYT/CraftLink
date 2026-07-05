package io.fabric.sdk.android.services.e;

import android.content.Context;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Settings.java */
/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<t> f4314a;

    /* renamed from: b, reason: collision with root package name */
    private final CountDownLatch f4315b;
    private s c;
    private boolean d;

    /* compiled from: Settings.java */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final q f4316a = new q();
    }

    public static q a() {
        return a.f4316a;
    }

    private q() {
        this.f4314a = new AtomicReference<>();
        this.f4315b = new CountDownLatch(1);
        this.d = false;
    }

    public synchronized q a(io.fabric.sdk.android.h hVar, io.fabric.sdk.android.services.b.r rVar, io.fabric.sdk.android.services.network.d dVar, String str, String str2, String str3) {
        if (this.d) {
            return this;
        }
        if (this.c == null) {
            Context contextR = hVar.r();
            String strC = rVar.c();
            String strA = new io.fabric.sdk.android.services.b.g().a(contextR);
            String strI = rVar.i();
            this.c = new j(hVar, new w(strA, rVar.g(), rVar.f(), rVar.e(), rVar.b(), io.fabric.sdk.android.services.b.i.a(io.fabric.sdk.android.services.b.i.m(contextR)), str2, str, io.fabric.sdk.android.services.b.l.a(strI).a(), io.fabric.sdk.android.services.b.i.k(contextR)), new io.fabric.sdk.android.services.b.v(), new k(), new i(hVar), new l(hVar, str3, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", strC), dVar));
        }
        this.d = true;
        return this;
    }

    public t b() {
        try {
            this.f4315b.await();
            return this.f4314a.get();
        } catch (InterruptedException unused) {
            io.fabric.sdk.android.c.g().e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    public synchronized boolean c() {
        t tVarA;
        tVarA = this.c.a();
        a(tVarA);
        return tVarA != null;
    }

    public synchronized boolean d() {
        t tVarA;
        tVarA = this.c.a(r.SKIP_CACHE_LOOKUP);
        a(tVarA);
        if (tVarA == null) {
            io.fabric.sdk.android.c.g().e("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        }
        return tVarA != null;
    }

    private void a(t tVar) {
        this.f4314a.set(tVar);
        this.f4315b.countDown();
    }
}
