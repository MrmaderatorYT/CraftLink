package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes.dex */
public final class axi extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f2371a = eb.f3057a;

    /* renamed from: b, reason: collision with root package name */
    private final BlockingQueue<blc<?>> f2372b;
    private final BlockingQueue<blc<?>> c;
    private final zh d;
    private final a e;
    private volatile boolean f = false;
    private final azj g = new azj(this);

    public axi(BlockingQueue<blc<?>> blockingQueue, BlockingQueue<blc<?>> blockingQueue2, zh zhVar, a aVar) {
        this.f2372b = blockingQueue;
        this.c = blockingQueue2;
        this.d = zhVar;
        this.e = aVar;
    }

    public final void a() {
        this.f = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        if (f2371a) {
            eb.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.d.a();
        while (true) {
            try {
                b();
            } catch (InterruptedException unused) {
                if (this.f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                eb.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private final void b() throws InterruptedException {
        blc<?> blcVarTake = this.f2372b.take();
        blcVarTake.b("cache-queue-take");
        blcVarTake.h();
        awj awjVarA = this.d.a(blcVarTake.f());
        if (awjVarA == null) {
            blcVarTake.b("cache-miss");
            if (this.g.b(blcVarTake)) {
                return;
            }
            this.c.put(blcVarTake);
            return;
        }
        if (awjVarA.a()) {
            blcVarTake.b("cache-hit-expired");
            blcVarTake.a(awjVarA);
            if (this.g.b(blcVarTake)) {
                return;
            }
            this.c.put(blcVarTake);
            return;
        }
        blcVarTake.b("cache-hit");
        brg<?> brgVarA = blcVarTake.a(new bje(awjVarA.f2343a, awjVarA.g));
        blcVarTake.b("cache-hit-parsed");
        if (awjVarA.f < System.currentTimeMillis()) {
            blcVarTake.b("cache-hit-refresh-needed");
            blcVarTake.a(awjVarA);
            brgVarA.d = true;
            if (!this.g.b(blcVarTake)) {
                this.e.a(blcVarTake, brgVarA, new ayi(this, blcVarTake));
                return;
            }
        }
        this.e.a(blcVarTake, brgVarA);
    }
}
