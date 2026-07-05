package com.crashlytics.android.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BackgroundManager.java */
/* loaded from: classes.dex */
class k {
    private final ScheduledExecutorService c;
    private final List<a> d = new ArrayList();
    private volatile boolean e = true;

    /* renamed from: a, reason: collision with root package name */
    final AtomicReference<ScheduledFuture<?>> f1274a = new AtomicReference<>();

    /* renamed from: b, reason: collision with root package name */
    boolean f1275b = true;

    /* compiled from: BackgroundManager.java */
    public interface a {
        void a();
    }

    public k(ScheduledExecutorService scheduledExecutorService) {
        this.c = scheduledExecutorService;
    }

    public void a(boolean z) {
        this.e = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Iterator<a> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void a(a aVar) {
        this.d.add(aVar);
    }

    public void a() {
        this.f1275b = false;
        ScheduledFuture<?> andSet = this.f1274a.getAndSet(null);
        if (andSet != null) {
            andSet.cancel(false);
        }
    }

    public void b() {
        if (!this.e || this.f1275b) {
            return;
        }
        this.f1275b = true;
        try {
            this.f1274a.compareAndSet(null, this.c.schedule(new Runnable() { // from class: com.crashlytics.android.a.k.1
                @Override // java.lang.Runnable
                public void run() {
                    k.this.f1274a.set(null);
                    k.this.c();
                }
            }, 5000L, TimeUnit.MILLISECONDS));
        } catch (RejectedExecutionException e) {
            io.fabric.sdk.android.c.g().a("Answers", "Failed to schedule background detector", e);
        }
    }
}
