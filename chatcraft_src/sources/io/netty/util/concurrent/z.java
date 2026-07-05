package io.netty.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/* compiled from: PromiseTask.java */
/* loaded from: classes.dex */
class z<V> extends h<V> implements RunnableFuture<V> {

    /* renamed from: a, reason: collision with root package name */
    protected final Callable<V> f4756a;

    @Override // io.netty.util.concurrent.h, io.netty.util.concurrent.y
    public final boolean b(V v) {
        return false;
    }

    @Override // io.netty.util.concurrent.h, io.netty.util.concurrent.y
    public final boolean b(Throwable th) {
        return false;
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    static <T> Callable<T> a(Runnable runnable, T t) {
        return new a(runnable, t);
    }

    /* compiled from: PromiseTask.java */
    private static final class a<T> implements Callable<T> {

        /* renamed from: a, reason: collision with root package name */
        final Runnable f4757a;

        /* renamed from: b, reason: collision with root package name */
        final T f4758b;

        a(Runnable runnable, T t) {
            this.f4757a = runnable;
            this.f4758b = t;
        }

        @Override // java.util.concurrent.Callable
        public T call() {
            this.f4757a.run();
            return this.f4758b;
        }

        public String toString() {
            return "Callable(task: " + this.f4757a + ", result: " + this.f4758b + ')';
        }
    }

    z(j jVar, Runnable runnable, V v) {
        this(jVar, a(runnable, v));
    }

    z(j jVar, Callable<V> callable) {
        super(jVar);
        this.f4756a = callable;
    }

    public final int hashCode() {
        return System.identityHashCode(this);
    }

    public void run() {
        try {
            if (a()) {
                c((z<V>) this.f4756a.call());
            }
        } catch (Throwable th) {
            a(th);
        }
    }

    @Override // io.netty.util.concurrent.h, io.netty.util.concurrent.y
    public final y<V> c(Throwable th) {
        throw new IllegalStateException();
    }

    protected final y<V> a(Throwable th) {
        super.c(th);
        return this;
    }

    @Override // io.netty.util.concurrent.h, io.netty.util.concurrent.y
    public final y<V> a(V v) {
        throw new IllegalStateException();
    }

    protected final y<V> c(V v) {
        super.a((z<V>) v);
        return this;
    }

    @Override // io.netty.util.concurrent.h, io.netty.util.concurrent.y
    public final boolean z_() {
        throw new IllegalStateException();
    }

    protected final boolean a() {
        return super.z_();
    }

    @Override // io.netty.util.concurrent.h
    protected StringBuilder t() {
        StringBuilder sbT = super.t();
        sbT.setCharAt(sbT.length() - 1, ',');
        sbT.append(" task: ");
        sbT.append(this.f4756a);
        sbT.append(')');
        return sbT;
    }
}
