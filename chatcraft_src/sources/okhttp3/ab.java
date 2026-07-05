package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import javax.annotation.Nullable;

/* compiled from: ResponseBody.java */
/* loaded from: classes.dex */
public abstract class ab implements Closeable {
    public abstract long a();

    public abstract b.e b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        okhttp3.internal.c.a(b());
    }

    public static ab a(@Nullable u uVar, byte[] bArr) {
        return a(uVar, bArr.length, new b.c().c(bArr));
    }

    public static ab a(@Nullable final u uVar, final long j, final b.e eVar) {
        if (eVar == null) {
            throw new NullPointerException("source == null");
        }
        return new ab() { // from class: okhttp3.ab.1
            @Override // okhttp3.ab
            public long a() {
                return j;
            }

            @Override // okhttp3.ab
            public b.e b() {
                return eVar;
            }
        };
    }
}
