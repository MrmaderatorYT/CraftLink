package io.netty.util.concurrent;

import java.util.concurrent.TimeUnit;

/* compiled from: CompleteFuture.java */
/* loaded from: classes.dex */
public abstract class e<V> extends c<V> {

    /* renamed from: a, reason: collision with root package name */
    private final j f4727a;

    @Override // io.netty.util.concurrent.p
    public p<V> B_() {
        return this;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // io.netty.util.concurrent.p
    public p<V> h() {
        return this;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    protected e(j jVar) {
        this.f4727a = jVar;
    }

    protected j a() {
        return this.f4727a;
    }

    @Override // io.netty.util.concurrent.p
    public p<V> b(r<? extends p<? super V>> rVar) {
        if (rVar == null) {
            throw new NullPointerException("listener");
        }
        h.a(a(), this, rVar);
        return this;
    }

    @Override // io.netty.util.concurrent.p
    public p<V> i() throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        return this;
    }

    @Override // io.netty.util.concurrent.p
    public boolean a(long j, TimeUnit timeUnit) throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        return true;
    }
}
