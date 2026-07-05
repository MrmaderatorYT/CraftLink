package io.netty.resolver;

import io.netty.util.concurrent.j;
import io.netty.util.concurrent.p;
import io.netty.util.concurrent.y;

/* compiled from: SimpleNameResolver.java */
/* loaded from: classes.dex */
public abstract class i<T> implements h<T> {

    /* renamed from: a, reason: collision with root package name */
    private final j f4620a;

    protected abstract void a(String str, y<T> yVar);

    @Override // io.netty.resolver.h, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    protected i(j jVar) {
        this.f4620a = (j) io.netty.util.a.j.a(jVar, "executor");
    }

    protected j b() {
        return this.f4620a;
    }

    @Override // io.netty.resolver.h
    public final p<T> a(String str) {
        return b(str, b().m());
    }

    public p<T> b(String str, y<T> yVar) {
        io.netty.util.a.j.a(str, "inetHost");
        io.netty.util.a.j.a(yVar, "promise");
        try {
            a(str, yVar);
            return yVar;
        } catch (Exception e) {
            return yVar.c(e);
        }
    }
}
