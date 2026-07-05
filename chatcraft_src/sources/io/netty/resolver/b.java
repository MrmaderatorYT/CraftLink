package io.netty.resolver;

import io.netty.util.concurrent.p;
import java.io.Closeable;
import java.net.SocketAddress;

/* compiled from: AddressResolver.java */
/* loaded from: classes.dex */
public interface b<T extends SocketAddress> extends Closeable {
    boolean a(SocketAddress socketAddress);

    boolean b(SocketAddress socketAddress);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    p<T> d(SocketAddress socketAddress);
}
