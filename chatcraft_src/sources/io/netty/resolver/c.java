package io.netty.resolver;

import io.netty.util.concurrent.j;
import io.netty.util.concurrent.p;
import io.netty.util.concurrent.q;
import java.io.Closeable;
import java.net.SocketAddress;
import java.util.IdentityHashMap;
import java.util.Map;

/* compiled from: AddressResolverGroup.java */
/* loaded from: classes.dex */
public abstract class c<T extends SocketAddress> implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private static final io.netty.util.a.b.c f4611a = io.netty.util.a.b.d.a((Class<?>) c.class);

    /* renamed from: b, reason: collision with root package name */
    private final Map<j, b<T>> f4612b = new IdentityHashMap();

    protected abstract b<T> b(j jVar);

    protected c() {
    }

    public b<T> a(final j jVar) {
        final b<T> bVarB;
        if (jVar == null) {
            throw new NullPointerException("executor");
        }
        if (jVar.D_()) {
            throw new IllegalStateException("executor not accepting a task");
        }
        synchronized (this.f4612b) {
            bVarB = this.f4612b.get(jVar);
            if (bVarB == null) {
                try {
                    bVarB = b(jVar);
                    this.f4612b.put(jVar, bVarB);
                    jVar.C_().b(new q<Object>() { // from class: io.netty.resolver.c.1
                        @Override // io.netty.util.concurrent.r
                        public void operationComplete(p<Object> pVar) {
                            synchronized (c.this.f4612b) {
                                c.this.f4612b.remove(jVar);
                            }
                            bVarB.close();
                        }
                    });
                } catch (Exception e) {
                    throw new IllegalStateException("failed to create a new resolver", e);
                }
            }
        }
        return bVarB;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        b[] bVarArr;
        synchronized (this.f4612b) {
            bVarArr = (b[]) this.f4612b.values().toArray(new b[this.f4612b.size()]);
            this.f4612b.clear();
        }
        for (b bVar : bVarArr) {
            try {
                bVar.close();
            } catch (Throwable th) {
                f4611a.b("Failed to close a resolver:", th);
            }
        }
    }
}
