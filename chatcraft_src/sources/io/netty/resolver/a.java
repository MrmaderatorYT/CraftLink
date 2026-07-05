package io.netty.resolver;

import io.netty.util.a.t;
import io.netty.util.concurrent.j;
import io.netty.util.concurrent.p;
import io.netty.util.concurrent.y;
import java.net.SocketAddress;
import java.nio.channels.UnsupportedAddressTypeException;

/* compiled from: AbstractAddressResolver.java */
/* loaded from: classes.dex */
public abstract class a<T extends SocketAddress> implements b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final j f4609a;

    /* renamed from: b, reason: collision with root package name */
    private final t f4610b;

    protected abstract void a(T t, y<T> yVar);

    protected abstract boolean c(T t);

    @Override // io.netty.resolver.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    protected a(j jVar, Class<? extends T> cls) {
        this.f4609a = (j) io.netty.util.a.j.a(jVar, "executor");
        this.f4610b = t.a((Class<?>) cls);
    }

    protected j a() {
        return this.f4609a;
    }

    @Override // io.netty.resolver.b
    public boolean a(SocketAddress socketAddress) {
        return this.f4610b.a(socketAddress);
    }

    @Override // io.netty.resolver.b
    public final boolean b(SocketAddress socketAddress) {
        if (!a(socketAddress)) {
            throw new UnsupportedAddressTypeException();
        }
        return c(socketAddress);
    }

    @Override // io.netty.resolver.b
    public final p<T> d(SocketAddress socketAddress) {
        if (!a((SocketAddress) io.netty.util.a.j.a(socketAddress, "address"))) {
            return a().a((Throwable) new UnsupportedAddressTypeException());
        }
        if (b(socketAddress)) {
            return this.f4609a.a((j) socketAddress);
        }
        try {
            y<T> yVarM = a().m();
            a(socketAddress, yVarM);
            return yVarM;
        } catch (Exception e) {
            return a().a((Throwable) e);
        }
    }
}
