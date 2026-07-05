package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface avv extends Closeable {
    int a(ByteBuffer byteBuffer);

    long a();

    ByteBuffer a(long j, long j2);

    void a(long j);

    long b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
