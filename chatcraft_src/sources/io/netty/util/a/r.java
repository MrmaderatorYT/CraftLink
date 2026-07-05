package io.netty.util.a;

import java.lang.Thread;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ThreadLocalRandom.java */
/* loaded from: classes.dex */
public final class r extends Random {

    /* renamed from: b, reason: collision with root package name */
    private static final io.netty.util.a.b.c f4701b = io.netty.util.a.b.d.a((Class<?>) r.class);
    private static final AtomicLong c = new AtomicLong();
    private static volatile long d;
    private static final Thread e;
    private static final BlockingQueue<Long> f;
    private static final long g;
    private static volatile long h;

    /* renamed from: a, reason: collision with root package name */
    boolean f4702a;
    private long i;

    private static long b(long j) {
        long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
        long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
        return j3 ^ (j3 >>> 33);
    }

    static {
        d = ((Long) AccessController.doPrivileged(new PrivilegedAction<Long>() { // from class: io.netty.util.a.r.1
            @Override // java.security.PrivilegedAction
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Long run() {
                return Long.getLong("io.netty.initialSeedUniquifier", 0L);
            }
        })).longValue();
        if (d == 0) {
            if (((Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: io.netty.util.a.r.2
                @Override // java.security.PrivilegedAction
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Boolean run() {
                    return Boolean.valueOf(Boolean.getBoolean("java.util.secureRandomSeed"));
                }
            })).booleanValue()) {
                f = new LinkedBlockingQueue();
                g = System.nanoTime();
                e = new Thread("initialSeedUniquifierGenerator") { // from class: io.netty.util.a.r.3
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        byte[] bArrGenerateSeed = new SecureRandom().generateSeed(8);
                        long unused = r.h = System.nanoTime();
                        r.f.add(Long.valueOf((bArrGenerateSeed[7] & 255) | ((bArrGenerateSeed[0] & 255) << 56) | ((bArrGenerateSeed[1] & 255) << 48) | ((bArrGenerateSeed[2] & 255) << 40) | ((bArrGenerateSeed[3] & 255) << 32) | ((bArrGenerateSeed[4] & 255) << 24) | ((bArrGenerateSeed[5] & 255) << 16) | ((bArrGenerateSeed[6] & 255) << 8)));
                    }
                };
                e.setDaemon(true);
                e.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: io.netty.util.a.r.4
                    @Override // java.lang.Thread.UncaughtExceptionHandler
                    public void uncaughtException(Thread thread, Throwable th) {
                        r.f4701b.b("An exception has been raised by {}", thread.getName(), th);
                    }
                });
                e.start();
                return;
            }
            d = b(System.currentTimeMillis()) ^ b(System.nanoTime());
            e = null;
            f = null;
            g = 0L;
            return;
        }
        e = null;
        f = null;
        g = 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
    
        r4 = r12.longValue();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long a() {
        /*
            long r0 = io.netty.util.a.r.d
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L9
            return r0
        L9:
            java.lang.Class<io.netty.util.a.r> r0 = io.netty.util.a.r.class
            monitor-enter(r0)
            long r4 = io.netty.util.a.r.d     // Catch: java.lang.Throwable -> L91
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 == 0) goto L14
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L91
            return r4
        L14:
            long r6 = io.netty.util.a.r.g     // Catch: java.lang.Throwable -> L91
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Throwable -> L91
            r8 = 3
            long r10 = r1.toNanos(r8)     // Catch: java.lang.Throwable -> L91
            r1 = 0
            long r6 = r6 + r10
            r1 = 0
        L21:
            long r10 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L91
            r12 = 0
            long r10 = r6 - r10
            int r12 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r12 > 0) goto L35
            java.util.concurrent.BlockingQueue<java.lang.Long> r12 = io.netty.util.a.r.f     // Catch: java.lang.InterruptedException -> L5c java.lang.Throwable -> L91
            java.lang.Object r12 = r12.poll()     // Catch: java.lang.InterruptedException -> L5c java.lang.Throwable -> L91
            java.lang.Long r12 = (java.lang.Long) r12     // Catch: java.lang.InterruptedException -> L5c java.lang.Throwable -> L91
            goto L3f
        L35:
            java.util.concurrent.BlockingQueue<java.lang.Long> r12 = io.netty.util.a.r.f     // Catch: java.lang.InterruptedException -> L5c java.lang.Throwable -> L91
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.lang.InterruptedException -> L5c java.lang.Throwable -> L91
            java.lang.Object r12 = r12.poll(r10, r13)     // Catch: java.lang.InterruptedException -> L5c java.lang.Throwable -> L91
            java.lang.Long r12 = (java.lang.Long) r12     // Catch: java.lang.InterruptedException -> L5c java.lang.Throwable -> L91
        L3f:
            if (r12 == 0) goto L47
            long r6 = r12.longValue()     // Catch: java.lang.InterruptedException -> L5c java.lang.Throwable -> L91
            r4 = r6
            goto L64
        L47:
            int r12 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r12 > 0) goto L21
            java.lang.Thread r6 = io.netty.util.a.r.e     // Catch: java.lang.Throwable -> L91
            r6.interrupt()     // Catch: java.lang.Throwable -> L91
            io.netty.util.a.b.c r6 = io.netty.util.a.r.f4701b     // Catch: java.lang.Throwable -> L91
            java.lang.String r7 = "Failed to generate a seed from SecureRandom within {} seconds. Not enough entropy?"
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Throwable -> L91
            r6.c(r7, r8)     // Catch: java.lang.Throwable -> L91
            goto L64
        L5c:
            r1 = 1
            io.netty.util.a.b.c r6 = io.netty.util.a.r.f4701b     // Catch: java.lang.Throwable -> L91
            java.lang.String r7 = "Failed to generate a seed from SecureRandom due to an InterruptedException."
            r6.c(r7)     // Catch: java.lang.Throwable -> L91
        L64:
            r6 = 3627065505421648153(0x3255ecdc33bae119, double:3.253008663204319E-66)
            long r4 = r4 ^ r6
            long r6 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L91
            long r6 = java.lang.Long.reverse(r6)     // Catch: java.lang.Throwable -> L91
            long r4 = r4 ^ r6
            io.netty.util.a.r.d = r4     // Catch: java.lang.Throwable -> L91
            if (r1 == 0) goto L83
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L91
            r1.interrupt()     // Catch: java.lang.Throwable -> L91
            java.lang.Thread r1 = io.netty.util.a.r.e     // Catch: java.lang.Throwable -> L91
            r1.interrupt()     // Catch: java.lang.Throwable -> L91
        L83:
            long r6 = io.netty.util.a.r.h     // Catch: java.lang.Throwable -> L91
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 != 0) goto L8f
            long r1 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L91
            io.netty.util.a.r.h = r1     // Catch: java.lang.Throwable -> L91
        L8f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L91
            return r4
        L91:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L91
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.a.r.a():long");
    }

    private static long e() {
        long j;
        long jA;
        long j2;
        do {
            j = c.get();
            jA = j != 0 ? j : a();
            j2 = 181783497276652981L * jA;
        } while (!c.compareAndSet(j, j2));
        if (j == 0 && f4701b.b()) {
            if (h != 0) {
                f4701b.a(String.format("-Dio.netty.initialSeedUniquifier: 0x%016x (took %d ms)", Long.valueOf(jA), Long.valueOf(TimeUnit.NANOSECONDS.toMillis(h - g))));
            } else {
                f4701b.a(String.format("-Dio.netty.initialSeedUniquifier: 0x%016x", Long.valueOf(jA)));
            }
        }
        return System.nanoTime() ^ j2;
    }

    r() {
        super(e());
        this.f4702a = true;
    }

    public static r b() {
        return d.b().g();
    }

    @Override // java.util.Random
    public void setSeed(long j) {
        if (this.f4702a) {
            throw new UnsupportedOperationException();
        }
        this.i = (j ^ 25214903917L) & 281474976710655L;
    }

    @Override // java.util.Random
    protected int next(int i) {
        this.i = ((this.i * 25214903917L) + 11) & 281474976710655L;
        return (int) (this.i >>> (48 - i));
    }
}
