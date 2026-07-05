package b;

import java.io.Closeable;

/* compiled from: Source.java */
/* loaded from: classes.dex */
public interface s extends Closeable {
    long a(c cVar, long j);

    t a();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
