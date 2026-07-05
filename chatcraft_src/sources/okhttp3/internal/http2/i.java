package okhttp3.internal.http2;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.c;

/* compiled from: Http2Writer.java */
/* loaded from: classes.dex */
final class i implements Closeable {

    /* renamed from: b, reason: collision with root package name */
    private static final Logger f5212b = Logger.getLogger(d.class.getName());
    private final b.d c;
    private final boolean d;
    private boolean g;
    private final b.c e = new b.c();

    /* renamed from: a, reason: collision with root package name */
    final c.b f5213a = new c.b(this.e);
    private int f = 16384;

    i(b.d dVar, boolean z) {
        this.c = dVar;
        this.d = z;
    }

    public synchronized void a() {
        if (this.g) {
            throw new IOException("closed");
        }
        if (this.d) {
            if (f5212b.isLoggable(Level.FINE)) {
                f5212b.fine(okhttp3.internal.c.a(">> CONNECTION %s", d.f5180a.f()));
            }
            this.c.c(d.f5180a.i());
            this.c.flush();
        }
    }

    public synchronized void a(l lVar) {
        if (this.g) {
            throw new IOException("closed");
        }
        this.f = lVar.d(this.f);
        if (lVar.c() != -1) {
            this.f5213a.a(lVar.c());
        }
        a(0, 0, (byte) 4, (byte) 1);
        this.c.flush();
    }

    public synchronized void a(int i, int i2, List<b> list) {
        if (this.g) {
            throw new IOException("closed");
        }
        this.f5213a.a(list);
        long jB = this.e.b();
        int iMin = (int) Math.min(this.f - 4, jB);
        long j = iMin;
        a(i, iMin + 4, (byte) 5, jB == j ? (byte) 4 : (byte) 0);
        this.c.g(i2 & Integer.MAX_VALUE);
        this.c.a_(this.e, j);
        if (jB > j) {
            b(i, jB - j);
        }
    }

    public synchronized void b() {
        if (this.g) {
            throw new IOException("closed");
        }
        this.c.flush();
    }

    public synchronized void a(boolean z, int i, int i2, List<b> list) {
        if (this.g) {
            throw new IOException("closed");
        }
        a(z, i, list);
    }

    public synchronized void a(int i, a aVar) {
        if (this.g) {
            throw new IOException("closed");
        }
        if (aVar.l == -1) {
            throw new IllegalArgumentException();
        }
        a(i, 4, (byte) 3, (byte) 0);
        this.c.g(aVar.l);
        this.c.flush();
    }

    public int c() {
        return this.f;
    }

    public synchronized void a(boolean z, int i, b.c cVar, int i2) {
        if (this.g) {
            throw new IOException("closed");
        }
        a(i, z ? (byte) 1 : (byte) 0, cVar, i2);
    }

    void a(int i, byte b2, b.c cVar, int i2) {
        a(i, i2, (byte) 0, b2);
        if (i2 > 0) {
            this.c.a_(cVar, i2);
        }
    }

    public synchronized void b(l lVar) {
        if (this.g) {
            throw new IOException("closed");
        }
        int i = 0;
        a(0, lVar.b() * 6, (byte) 4, (byte) 0);
        while (i < 10) {
            if (lVar.a(i)) {
                this.c.h(i == 4 ? 3 : i == 7 ? 4 : i);
                this.c.g(lVar.b(i));
            }
            i++;
        }
        this.c.flush();
    }

    public synchronized void a(boolean z, int i, int i2) {
        if (this.g) {
            throw new IOException("closed");
        }
        a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
        this.c.g(i);
        this.c.g(i2);
        this.c.flush();
    }

    public synchronized void a(int i, a aVar, byte[] bArr) {
        if (this.g) {
            throw new IOException("closed");
        }
        if (aVar.l == -1) {
            throw d.a("errorCode.httpCode == -1", new Object[0]);
        }
        a(0, bArr.length + 8, (byte) 7, (byte) 0);
        this.c.g(i);
        this.c.g(aVar.l);
        if (bArr.length > 0) {
            this.c.c(bArr);
        }
        this.c.flush();
    }

    public synchronized void a(int i, long j) {
        if (this.g) {
            throw new IOException("closed");
        }
        if (j == 0 || j > 2147483647L) {
            throw d.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        }
        a(i, 4, (byte) 8, (byte) 0);
        this.c.g((int) j);
        this.c.flush();
    }

    public void a(int i, int i2, byte b2, byte b3) {
        if (f5212b.isLoggable(Level.FINE)) {
            f5212b.fine(d.a(false, i, i2, b2, b3));
        }
        if (i2 > this.f) {
            throw d.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(this.f), Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw d.a("reserved bit set: %s", Integer.valueOf(i));
        }
        a(this.c, i2);
        this.c.i(b2 & Constants.DimensionIds.NETHER);
        this.c.i(b3 & Constants.DimensionIds.NETHER);
        this.c.g(i & Integer.MAX_VALUE);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.g = true;
        this.c.close();
    }

    private static void a(b.d dVar, int i) {
        dVar.i((i >>> 16) & 255);
        dVar.i((i >>> 8) & 255);
        dVar.i(i & 255);
    }

    private void b(int i, long j) {
        while (j > 0) {
            int iMin = (int) Math.min(this.f, j);
            long j2 = iMin;
            j -= j2;
            a(i, iMin, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.c.a_(this.e, j2);
        }
    }

    void a(boolean z, int i, List<b> list) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        this.f5213a.a(list);
        long jB = this.e.b();
        int iMin = (int) Math.min(this.f, jB);
        long j = iMin;
        byte b2 = jB == j ? (byte) 4 : (byte) 0;
        if (z) {
            b2 = (byte) (b2 | 1);
        }
        a(i, iMin, (byte) 1, b2);
        this.c.a_(this.e, j);
        if (jB > j) {
            b(i, jB - j);
        }
    }
}
