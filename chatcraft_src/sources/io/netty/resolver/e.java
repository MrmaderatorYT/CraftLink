package io.netty.resolver;

import io.netty.util.concurrent.j;
import io.netty.util.concurrent.y;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: DefaultNameResolver.java */
/* loaded from: classes.dex */
public class e extends f {
    public e(j jVar) {
        super(jVar);
    }

    @Override // io.netty.resolver.i
    protected void a(String str, y<InetAddress> yVar) {
        try {
            yVar.a(InetAddress.getByName(str));
        } catch (UnknownHostException e) {
            yVar.c(e);
        }
    }
}
