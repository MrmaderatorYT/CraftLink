package io.netty.resolver;

import io.netty.util.concurrent.j;
import java.net.InetSocketAddress;

/* compiled from: DefaultAddressResolverGroup.java */
/* loaded from: classes.dex */
public final class d extends c<InetSocketAddress> {

    /* renamed from: a, reason: collision with root package name */
    public static final d f4615a = new d();

    private d() {
    }

    @Override // io.netty.resolver.c
    protected b<InetSocketAddress> b(j jVar) {
        return new e(jVar).a();
    }
}
