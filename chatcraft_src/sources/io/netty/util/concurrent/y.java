package io.netty.util.concurrent;

/* compiled from: Promise.java */
/* loaded from: classes.dex */
public interface y<V> extends p<V> {
    y<V> a(V v);

    boolean b(V v);

    boolean b(Throwable th);

    y<V> c(Throwable th);

    boolean z_();
}
