package io.netty.util.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: Future.java */
/* loaded from: classes.dex */
public interface p<V> extends Future<V> {
    p<V> B_();

    boolean a(long j, TimeUnit timeUnit);

    p<V> b(r<? extends p<? super V>> rVar);

    p<V> h();

    p<V> i();

    V j();

    Throwable k();

    boolean l();
}
