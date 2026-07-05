package io.netty.channel;

import io.netty.channel.ar;
import java.net.SocketAddress;

/* compiled from: Channel.java */
/* loaded from: classes.dex */
public interface d extends v, io.netty.util.d, Comparable<d> {

    /* compiled from: Channel.java */
    public interface a {
        ar.a a();

        void a(ak akVar, z zVar);

        void a(z zVar);

        void a(Object obj, z zVar);

        void a(SocketAddress socketAddress, z zVar);

        void a(SocketAddress socketAddress, SocketAddress socketAddress2, z zVar);

        s b();

        void b(z zVar);

        SocketAddress c();

        void c(z zVar);

        SocketAddress d();

        void e();

        void f();

        void g();

        z i();
    }

    e D();

    boolean E();

    boolean F();

    q G();

    m a();

    w d();

    ak f();

    SocketAddress g();

    SocketAddress h();

    boolean i();

    d k();

    d l();

    a n();
}
