package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@qj
/* loaded from: classes.dex */
public final class aaz {
    public static <V> void a(final abl<V> ablVar, final aaw<V> aawVar, Executor executor) {
        ablVar.a(new Runnable(aawVar, ablVar) { // from class: com.google.android.gms.internal.ads.aba

            /* renamed from: a, reason: collision with root package name */
            private final aaw f1793a;

            /* renamed from: b, reason: collision with root package name */
            private final abl f1794b;

            {
                this.f1793a = aawVar;
                this.f1794b = ablVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                aaw aawVar2 = this.f1793a;
                try {
                    aawVar2.a((aaw) this.f1794b.get());
                } catch (InterruptedException e) {
                    e = e;
                    Thread.currentThread().interrupt();
                    aawVar2.a(e);
                } catch (ExecutionException e2) {
                    e = e2.getCause();
                    aawVar2.a(e);
                } catch (Exception e3) {
                    e = e3;
                    aawVar2.a(e);
                }
            }
        }, executor);
    }

    public static <A, B> abl<B> a(final abl<A> ablVar, final aav<A, B> aavVar, Executor executor) {
        final abv abvVar = new abv();
        ablVar.a(new Runnable(abvVar, aavVar, ablVar) { // from class: com.google.android.gms.internal.ads.abb

            /* renamed from: a, reason: collision with root package name */
            private final abv f1795a;

            /* renamed from: b, reason: collision with root package name */
            private final aav f1796b;
            private final abl c;

            {
                this.f1795a = abvVar;
                this.f1796b = aavVar;
                this.c = ablVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                abv abvVar2 = this.f1795a;
                try {
                    abvVar2.b(this.f1796b.a(this.c.get()));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    abvVar2.a(e);
                } catch (CancellationException unused) {
                    abvVar2.cancel(true);
                } catch (ExecutionException e2) {
                    e = e2;
                    Throwable cause = e.getCause();
                    if (cause != null) {
                        e = cause;
                    }
                    abvVar2.a(e);
                } catch (Exception e3) {
                    abvVar2.a(e3);
                }
            }
        }, executor);
        a((abl) abvVar, (Future) ablVar);
        return abvVar;
    }

    public static <A, B> abl<B> a(final abl<A> ablVar, final aau<? super A, ? extends B> aauVar, Executor executor) {
        final abv abvVar = new abv();
        ablVar.a(new Runnable(abvVar, aauVar, ablVar) { // from class: com.google.android.gms.internal.ads.abc

            /* renamed from: a, reason: collision with root package name */
            private final abv f1797a;

            /* renamed from: b, reason: collision with root package name */
            private final aau f1798b;
            private final abl c;

            {
                this.f1797a = abvVar;
                this.f1798b = aauVar;
                this.c = ablVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                aaz.a(this.f1797a, this.f1798b, this.c);
            }
        }, executor);
        a((abl) abvVar, (Future) ablVar);
        return abvVar;
    }

    public static <V> abl<V> a(abl<V> ablVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        final abv abvVar = new abv();
        a((abl) abvVar, (Future) ablVar);
        final ScheduledFuture<?> scheduledFutureSchedule = scheduledExecutorService.schedule(new Runnable(abvVar) { // from class: com.google.android.gms.internal.ads.abd

            /* renamed from: a, reason: collision with root package name */
            private final abv f1799a;

            {
                this.f1799a = abvVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f1799a.a(new TimeoutException());
            }
        }, j, timeUnit);
        a((abl) ablVar, abvVar);
        abvVar.a(new Runnable(scheduledFutureSchedule) { // from class: com.google.android.gms.internal.ads.abe

            /* renamed from: a, reason: collision with root package name */
            private final Future f1800a;

            {
                this.f1800a = scheduledFutureSchedule;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Future future = this.f1800a;
                if (future.isDone()) {
                    return;
                }
                future.cancel(true);
            }
        }, abq.f1817b);
        return abvVar;
    }

    public static <V, X extends Throwable> abl<V> a(final abl<? extends V> ablVar, final Class<X> cls, final aau<? super X, ? extends V> aauVar, final Executor executor) {
        final abv abvVar = new abv();
        a((abl) abvVar, (Future) ablVar);
        ablVar.a(new Runnable(abvVar, ablVar, cls, aauVar, executor) { // from class: com.google.android.gms.internal.ads.abf

            /* renamed from: a, reason: collision with root package name */
            private final abv f1801a;

            /* renamed from: b, reason: collision with root package name */
            private final abl f1802b;
            private final Class c;
            private final aau d;
            private final Executor e;

            {
                this.f1801a = abvVar;
                this.f1802b = ablVar;
                this.c = cls;
                this.d = aauVar;
                this.e = executor;
            }

            @Override // java.lang.Runnable
            public final void run() {
                aaz.a(this.f1801a, this.f1802b, this.c, this.d, this.e);
            }
        }, abq.f1817b);
        return abvVar;
    }

    public static <T> T a(Future<T> future, T t) {
        try {
            return future.get(((Long) bra.e().a(o.ba)).longValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            future.cancel(true);
            xe.c("InterruptedException caught while resolving future.", e);
            Thread.currentThread().interrupt();
            com.google.android.gms.ads.internal.ax.i().b(e, "Futures.resolveFuture");
            return t;
        } catch (Exception e2) {
            future.cancel(true);
            xe.b("Error waiting for future.", e2);
            com.google.android.gms.ads.internal.ax.i().b(e2, "Futures.resolveFuture");
            return t;
        }
    }

    public static <T> T a(Future<T> future, T t, long j, TimeUnit timeUnit) {
        try {
            return future.get(j, timeUnit);
        } catch (InterruptedException e) {
            future.cancel(true);
            xe.c("InterruptedException caught while resolving future.", e);
            Thread.currentThread().interrupt();
            com.google.android.gms.ads.internal.ax.i().b(e, "Futures.resolveFuture");
            return t;
        } catch (Exception e2) {
            future.cancel(true);
            xe.b("Error waiting for future.", e2);
            com.google.android.gms.ads.internal.ax.i().b(e2, "Futures.resolveFuture");
            return t;
        }
    }

    public static <T> abk<T> a(T t) {
        return new abk<>(t);
    }

    public static <T> abi<T> a(Throwable th) {
        return new abi<>(th);
    }

    private static <V> void a(final abl<? extends V> ablVar, final abv<V> abvVar) {
        a((abl) abvVar, (Future) ablVar);
        ablVar.a(new Runnable(abvVar, ablVar) { // from class: com.google.android.gms.internal.ads.abg

            /* renamed from: a, reason: collision with root package name */
            private final abv f1803a;

            /* renamed from: b, reason: collision with root package name */
            private final abl f1804b;

            {
                this.f1803a = abvVar;
                this.f1804b = ablVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                abv abvVar2 = this.f1803a;
                try {
                    abvVar2.b(this.f1804b.get());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    abvVar2.a(e);
                } catch (ExecutionException e2) {
                    abvVar2.a(e2.getCause());
                } catch (Exception e3) {
                    abvVar2.a(e3);
                }
            }
        }, abq.f1817b);
    }

    private static <A, B> void a(final abl<A> ablVar, final Future<B> future) {
        ablVar.a(new Runnable(ablVar, future) { // from class: com.google.android.gms.internal.ads.abh

            /* renamed from: a, reason: collision with root package name */
            private final abl f1805a;

            /* renamed from: b, reason: collision with root package name */
            private final Future f1806b;

            {
                this.f1805a = ablVar;
                this.f1806b = future;
            }

            @Override // java.lang.Runnable
            public final void run() {
                abl ablVar2 = this.f1805a;
                Future future2 = this.f1806b;
                if (ablVar2.isCancelled()) {
                    future2.cancel(true);
                }
            }
        }, abq.f1817b);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static final /* synthetic */ void a(com.google.android.gms.internal.ads.abv r1, com.google.android.gms.internal.ads.abl r2, java.lang.Class r3, com.google.android.gms.internal.ads.aau r4, java.util.concurrent.Executor r5) {
        /*
            java.lang.Object r2 = r2.get()     // Catch: java.lang.Exception -> L8 java.lang.InterruptedException -> La java.util.concurrent.ExecutionException -> L13
            r1.b(r2)     // Catch: java.lang.Exception -> L8 java.lang.InterruptedException -> La java.util.concurrent.ExecutionException -> L13
            return
        L8:
            r2 = move-exception
            goto L18
        La:
            r2 = move-exception
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            goto L18
        L13:
            r2 = move-exception
            java.lang.Throwable r2 = r2.getCause()
        L18:
            boolean r3 = r3.isInstance(r2)
            if (r3 == 0) goto L2a
            com.google.android.gms.internal.ads.abk r2 = a(r2)
            com.google.android.gms.internal.ads.abl r2 = a(r2, r4, r5)
            a(r2, r1)
            return
        L2a:
            r1.a(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aaz.a(com.google.android.gms.internal.ads.abv, com.google.android.gms.internal.ads.abl, java.lang.Class, com.google.android.gms.internal.ads.aau, java.util.concurrent.Executor):void");
    }

    static final /* synthetic */ void a(abv abvVar, aau aauVar, abl ablVar) {
        if (abvVar.isCancelled()) {
            return;
        }
        try {
            a(aauVar.a(ablVar.get()), abvVar);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            abvVar.a(e);
        } catch (CancellationException unused) {
            abvVar.cancel(true);
        } catch (ExecutionException e2) {
            abvVar.a(e2.getCause());
        } catch (Exception e3) {
            abvVar.a(e3);
        }
    }
}
