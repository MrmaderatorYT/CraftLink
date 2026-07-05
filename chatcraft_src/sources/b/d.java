package b;

import java.nio.channels.WritableByteChannel;

/* compiled from: BufferedSink.java */
/* loaded from: classes.dex */
public interface d extends r, WritableByteChannel {
    d b(String str);

    c c();

    d c(byte[] bArr);

    d c(byte[] bArr, int i, int i2);

    @Override // b.r, java.io.Flushable
    void flush();

    d g(int i);

    d h(int i);

    d i(int i);

    d k(long j);

    d l(long j);

    d v();
}
