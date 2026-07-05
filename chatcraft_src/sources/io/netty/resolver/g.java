package io.netty.resolver;

import io.netty.util.concurrent.j;
import io.netty.util.concurrent.p;
import io.netty.util.concurrent.q;
import io.netty.util.concurrent.y;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* compiled from: InetSocketAddressResolver.java */
/* loaded from: classes.dex */
public class g extends a<InetSocketAddress> {

    /* renamed from: a, reason: collision with root package name */
    final h<InetAddress> f4617a;

    @Override // io.netty.resolver.a
    protected /* bridge */ /* synthetic */ void a(SocketAddress socketAddress, y yVar) {
        a((InetSocketAddress) socketAddress, (y<InetSocketAddress>) yVar);
    }

    public g(j jVar, h<InetAddress> hVar) {
        super(jVar, InetSocketAddress.class);
        this.f4617a = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.resolver.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean c(InetSocketAddress inetSocketAddress) {
        return !inetSocketAddress.isUnresolved();
    }

    protected void a(final InetSocketAddress inetSocketAddress, final y<InetSocketAddress> yVar) {
        this.f4617a.a(inetSocketAddress.getHostName()).b(new q<InetAddress>() { // from class: io.netty.resolver.g.1
            @Override // io.netty.util.concurrent.r
            public void operationComplete(p<InetAddress> pVar) {
                if (pVar.l()) {
                    yVar.a(new InetSocketAddress(pVar.j(), inetSocketAddress.getPort()));
                } else {
                    yVar.c(pVar.k());
                }
            }
        });
    }

    @Override // io.netty.resolver.a, io.netty.resolver.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4617a.close();
    }
}
