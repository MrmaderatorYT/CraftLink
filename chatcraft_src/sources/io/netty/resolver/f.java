package io.netty.resolver;

import io.netty.util.concurrent.j;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/* compiled from: InetNameResolver.java */
/* loaded from: classes.dex */
public abstract class f extends i<InetAddress> {

    /* renamed from: a, reason: collision with root package name */
    private volatile b<InetSocketAddress> f4616a;

    protected f(j jVar) {
        super(jVar);
    }

    public b<InetSocketAddress> a() {
        b<InetSocketAddress> gVar = this.f4616a;
        if (gVar == null) {
            synchronized (this) {
                gVar = this.f4616a;
                if (gVar == null) {
                    gVar = new g(b(), this);
                    this.f4616a = gVar;
                }
            }
        }
        return gVar;
    }
}
