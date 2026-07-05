package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class abv<T> implements abl<T> {

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("mLock")
    private T f1822b;

    @GuardedBy("mLock")
    private Throwable c;

    @GuardedBy("mLock")
    private boolean d;

    @GuardedBy("mLock")
    private boolean e;

    /* renamed from: a, reason: collision with root package name */
    private final Object f1821a = new Object();
    private final abm f = new abm();

    @Override // com.google.android.gms.internal.ads.abl
    public final void a(Runnable runnable, Executor executor) {
        this.f.a(runnable, executor);
    }

    public final void b(T t) {
        synchronized (this.f1821a) {
            if (this.e) {
                return;
            }
            if (a()) {
                com.google.android.gms.ads.internal.ax.i().b(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.set");
                return;
            }
            this.d = true;
            this.f1822b = t;
            this.f1821a.notifyAll();
            this.f.a();
        }
    }

    public final void a(Throwable th) {
        synchronized (this.f1821a) {
            if (this.e) {
                return;
            }
            if (a()) {
                com.google.android.gms.ads.internal.ax.i().b(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.setException");
                return;
            }
            this.c = th;
            this.f1821a.notifyAll();
            this.f.a();
        }
    }

    @Override // java.util.concurrent.Future
    public T get() {
        T t;
        synchronized (this.f1821a) {
            if (!a()) {
                try {
                    this.f1821a.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.c != null) {
                throw new ExecutionException(this.c);
            }
            if (this.e) {
                throw new CancellationException("SettableFuture was cancelled.");
            }
            t = this.f1822b;
        }
        return t;
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) {
        T t;
        synchronized (this.f1821a) {
            if (!a()) {
                try {
                    long millis = timeUnit.toMillis(j);
                    if (millis != 0) {
                        this.f1821a.wait(millis);
                    }
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.c != null) {
                throw new ExecutionException(this.c);
            }
            if (!this.d) {
                throw new TimeoutException("SettableFuture timed out.");
            }
            if (this.e) {
                throw new CancellationException("SettableFuture was cancelled.");
            }
            t = this.f1822b;
        }
        return t;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        if (!z) {
            return false;
        }
        synchronized (this.f1821a) {
            if (a()) {
                return false;
            }
            this.e = true;
            this.d = true;
            this.f1821a.notifyAll();
            this.f.a();
            return true;
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        boolean z;
        synchronized (this.f1821a) {
            z = this.e;
        }
        return z;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        boolean zA;
        synchronized (this.f1821a) {
            zA = a();
        }
        return zA;
    }

    @GuardedBy("mLock")
    private final boolean a() {
        return this.c != null || this.d;
    }
}
