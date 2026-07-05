package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes.dex */
public final class bhe extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private final BlockingQueue<blc<?>> f2663a;

    /* renamed from: b, reason: collision with root package name */
    private final bge f2664b;
    private final zh c;
    private final a d;
    private volatile boolean e = false;

    public bhe(BlockingQueue<blc<?>> blockingQueue, bge bgeVar, zh zhVar, a aVar) {
        this.f2663a = blockingQueue;
        this.f2664b = bgeVar;
        this.c = zhVar;
        this.d = aVar;
    }

    public final void a() {
        this.e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(10);
        while (true) {
            try {
                b();
            } catch (InterruptedException unused) {
                if (this.e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                eb.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private final void b() throws InterruptedException {
        blc<?> blcVarTake = this.f2663a.take();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            blcVarTake.b("network-queue-take");
            blcVarTake.h();
            TrafficStats.setThreadStatsTag(blcVarTake.d());
            bje bjeVarA = this.f2664b.a(blcVarTake);
            blcVarTake.b("network-http-complete");
            if (bjeVarA.e && blcVarTake.m()) {
                blcVarTake.c("not-modified");
                blcVarTake.n();
                return;
            }
            brg<?> brgVarA = blcVarTake.a(bjeVarA);
            blcVarTake.b("network-parse-complete");
            if (blcVarTake.i() && brgVarA.f3004b != null) {
                this.c.a(blcVarTake.f(), brgVarA.f3004b);
                blcVarTake.b("network-cache-written");
            }
            blcVarTake.l();
            this.d.a(blcVarTake, brgVarA);
            blcVarTake.a(brgVarA);
        } catch (zzae e) {
            e.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
            this.d.a(blcVarTake, e);
            blcVarTake.n();
        } catch (Exception e2) {
            eb.a(e2, "Unhandled exception %s", e2.toString());
            zzae zzaeVar = new zzae(e2);
            zzaeVar.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
            this.d.a(blcVarTake, zzaeVar);
            blcVarTake.n();
        }
    }
}
