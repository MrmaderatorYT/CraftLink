package b;

import java.io.Closeable;
import java.io.Flushable;

/* compiled from: Sink.java */
/* loaded from: classes.dex */
public interface r extends Closeable, Flushable {
    t a();

    void a_(c cVar, long j);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();
}
