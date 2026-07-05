package b;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: GzipSource.java */
/* loaded from: classes.dex */
public final class j implements s {

    /* renamed from: b, reason: collision with root package name */
    private final e f1173b;
    private final Inflater c;
    private final k d;

    /* renamed from: a, reason: collision with root package name */
    private int f1172a = 0;
    private final CRC32 e = new CRC32();

    public j(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.c = new Inflater(true);
        this.f1173b = l.a(sVar);
        this.d = new k(this.f1173b, this.c);
    }

    @Override // b.s
    public long a(c cVar, long j) throws DataFormatException, IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return 0L;
        }
        if (this.f1172a == 0) {
            b();
            this.f1172a = 1;
        }
        if (this.f1172a == 1) {
            long j2 = cVar.f1165b;
            long jA = this.d.a(cVar, j);
            if (jA != -1) {
                a(cVar, j2, jA);
                return jA;
            }
            this.f1172a = 2;
        }
        if (this.f1172a == 2) {
            c();
            this.f1172a = 3;
            if (!this.f1173b.e()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    private void b() throws IOException {
        this.f1173b.a(10L);
        byte b2 = this.f1173b.c().b(3L);
        boolean z = ((b2 >> 1) & 1) == 1;
        if (z) {
            a(this.f1173b.c(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.f1173b.i());
        this.f1173b.h(8L);
        if (((b2 >> 2) & 1) == 1) {
            this.f1173b.a(2L);
            if (z) {
                a(this.f1173b.c(), 0L, 2L);
            }
            long jK = this.f1173b.c().k();
            this.f1173b.a(jK);
            if (z) {
                a(this.f1173b.c(), 0L, jK);
            }
            this.f1173b.h(jK);
        }
        if (((b2 >> 3) & 1) == 1) {
            long jA = this.f1173b.a((byte) 0);
            if (jA == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.f1173b.c(), 0L, jA + 1);
            }
            this.f1173b.h(jA + 1);
        }
        if (((b2 >> 4) & 1) == 1) {
            long jA2 = this.f1173b.a((byte) 0);
            if (jA2 == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.f1173b.c(), 0L, jA2 + 1);
            }
            this.f1173b.h(jA2 + 1);
        }
        if (z) {
            a("FHCRC", this.f1173b.k(), (short) this.e.getValue());
            this.e.reset();
        }
    }

    private void c() throws IOException {
        a("CRC", this.f1173b.l(), (int) this.e.getValue());
        a("ISIZE", this.f1173b.l(), (int) this.c.getBytesWritten());
    }

    @Override // b.s
    public t a() {
        return this.f1173b.a();
    }

    @Override // b.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.d.close();
    }

    private void a(c cVar, long j, long j2) {
        o oVar = cVar.f1164a;
        while (j >= oVar.c - oVar.f1188b) {
            j -= oVar.c - oVar.f1188b;
            oVar = oVar.f;
        }
        while (j2 > 0) {
            int iMin = (int) Math.min(oVar.c - r6, j2);
            this.e.update(oVar.f1187a, (int) (oVar.f1188b + j), iMin);
            j2 -= iMin;
            oVar = oVar.f;
            j = 0;
        }
    }

    private void a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
