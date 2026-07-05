package io.netty.util.concurrent;

/* compiled from: EventExecutor.java */
/* loaded from: classes.dex */
public interface j extends l {
    <V> p<V> a(V v);

    <V> p<V> a(Throwable th);

    boolean a(Thread thread);

    boolean k();

    <V> y<V> m();
}
