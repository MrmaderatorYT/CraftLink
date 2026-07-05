package com.crashlytics.android.a;

import android.content.Context;
import com.crashlytics.android.a.ab;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: AnswersEventsHandler.java */
/* loaded from: classes.dex */
class e implements io.fabric.sdk.android.services.c.d {

    /* renamed from: a, reason: collision with root package name */
    final ScheduledExecutorService f1255a;

    /* renamed from: b, reason: collision with root package name */
    aa f1256b = new l();
    private final io.fabric.sdk.android.h c;
    private final Context d;
    private final f e;
    private final ae f;
    private final io.fabric.sdk.android.services.network.d g;
    private final p h;

    public e(io.fabric.sdk.android.h hVar, Context context, f fVar, ae aeVar, io.fabric.sdk.android.services.network.d dVar, ScheduledExecutorService scheduledExecutorService, p pVar) {
        this.c = hVar;
        this.d = context;
        this.e = fVar;
        this.f = aeVar;
        this.g = dVar;
        this.f1255a = scheduledExecutorService;
        this.h = pVar;
    }

    public void a(ab.a aVar) throws ExecutionException, InterruptedException {
        a(aVar, false, false);
    }

    public void b(ab.a aVar) throws ExecutionException, InterruptedException {
        a(aVar, false, true);
    }

    public void c(ab.a aVar) throws ExecutionException, InterruptedException {
        a(aVar, true, false);
    }

    public void a(final io.fabric.sdk.android.services.e.b bVar, final String str) {
        b(new Runnable() { // from class: com.crashlytics.android.a.e.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.this.f1256b.a(bVar, str);
                } catch (Exception e) {
                    io.fabric.sdk.android.c.g().e("Answers", "Failed to set analytics settings data", e);
                }
            }
        });
    }

    public void a() {
        b(new Runnable() { // from class: com.crashlytics.android.a.e.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    aa aaVar = e.this.f1256b;
                    e.this.f1256b = new l();
                    aaVar.b();
                } catch (Exception e) {
                    io.fabric.sdk.android.c.g().e("Answers", "Failed to disable events", e);
                }
            }
        });
    }

    @Override // io.fabric.sdk.android.services.c.d
    public void a(String str) {
        b(new Runnable() { // from class: com.crashlytics.android.a.e.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.this.f1256b.a();
                } catch (Exception e) {
                    io.fabric.sdk.android.c.g().e("Answers", "Failed to send events files", e);
                }
            }
        });
    }

    public void b() {
        b(new Runnable() { // from class: com.crashlytics.android.a.e.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ac acVarA = e.this.f.a();
                    x xVarA = e.this.e.a();
                    xVarA.a((io.fabric.sdk.android.services.c.d) e.this);
                    e.this.f1256b = new m(e.this.c, e.this.d, e.this.f1255a, xVarA, e.this.g, acVarA, e.this.h);
                } catch (Exception e) {
                    io.fabric.sdk.android.c.g().e("Answers", "Failed to enable events", e);
                }
            }
        });
    }

    public void c() {
        b(new Runnable() { // from class: com.crashlytics.android.a.e.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.this.f1256b.c();
                } catch (Exception e) {
                    io.fabric.sdk.android.c.g().e("Answers", "Failed to flush events", e);
                }
            }
        });
    }

    void a(final ab.a aVar, boolean z, final boolean z2) throws ExecutionException, InterruptedException {
        Runnable runnable = new Runnable() { // from class: com.crashlytics.android.a.e.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.this.f1256b.a(aVar);
                    if (z2) {
                        e.this.f1256b.c();
                    }
                } catch (Exception e) {
                    io.fabric.sdk.android.c.g().e("Answers", "Failed to process event", e);
                }
            }
        };
        if (z) {
            a(runnable);
        } else {
            b(runnable);
        }
    }

    private void a(Runnable runnable) throws ExecutionException, InterruptedException {
        try {
            this.f1255a.submit(runnable).get();
        } catch (Exception e) {
            io.fabric.sdk.android.c.g().e("Answers", "Failed to run events task", e);
        }
    }

    private void b(Runnable runnable) {
        try {
            this.f1255a.submit(runnable);
        } catch (Exception e) {
            io.fabric.sdk.android.c.g().e("Answers", "Failed to submit events task", e);
        }
    }
}
