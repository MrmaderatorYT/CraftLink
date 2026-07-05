package io.netty.resolver;

import io.netty.util.concurrent.p;
import java.io.Closeable;

/* compiled from: NameResolver.java */
/* loaded from: classes.dex */
public interface h<T> extends Closeable {
    p<T> a(String str);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
