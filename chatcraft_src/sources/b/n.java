package b;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: RealBufferedSource.java */
/* loaded from: classes.dex */
final class n implements e {

    /* renamed from: a, reason: collision with root package name */
    public final c f1184a = new c();

    /* renamed from: b, reason: collision with root package name */
    public final s f1185b;
    boolean c;

    n(s sVar) {
        if (sVar == null) {
            throw new NullPointerException("source == null");
        }
        this.f1185b = sVar;
    }

    @Override // b.e
    public c c() {
        return this.f1184a;
    }

    @Override // b.s
    public long a(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.f1184a.f1165b == 0 && this.f1185b.a(this.f1184a, 8192L) == -1) {
            return -1L;
        }
        return this.f1184a.a(cVar, Math.min(j, this.f1184a.f1165b));
    }

    @Override // b.e
    public boolean e() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        return this.f1184a.e() && this.f1185b.a(this.f1184a, 8192L) == -1;
    }

    @Override // b.e
    public void a(long j) throws EOFException {
        if (!b(j)) {
            throw new EOFException();
        }
    }

    public boolean b(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (this.f1184a.f1165b < j) {
            if (this.f1185b.a(this.f1184a, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // b.e
    public byte h() throws EOFException {
        a(1L);
        return this.f1184a.h();
    }

    @Override // b.e
    public f c(long j) throws EOFException {
        a(j);
        return this.f1184a.c(j);
    }

    @Override // b.e
    public byte[] r() {
        this.f1184a.a(this.f1185b);
        return this.f1184a.r();
    }

    @Override // b.e
    public byte[] g(long j) throws EOFException {
        a(j);
        return this.f1184a.g(j);
    }

    @Override // b.e
    public void a(byte[] bArr) throws EOFException {
        try {
            a(bArr.length);
            this.f1184a.a(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.f1184a.f1165b > 0) {
                int iA = this.f1184a.a(bArr, i, (int) this.f1184a.f1165b);
                if (iA == -1) {
                    throw new AssertionError();
                }
                i += iA;
            }
            throw e;
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        if (this.f1184a.f1165b == 0 && this.f1185b.a(this.f1184a, 8192L) == -1) {
            return -1;
        }
        return this.f1184a.read(byteBuffer);
    }

    @Override // b.e
    public String q() {
        return e(Long.MAX_VALUE);
    }

    @Override // b.e
    public String e(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long jA = a((byte) 10, 0L, j2);
        if (jA != -1) {
            return this.f1184a.f(jA);
        }
        if (j2 < Long.MAX_VALUE && b(j2) && this.f1184a.b(j2 - 1) == 13 && b(1 + j2) && this.f1184a.b(j2) == 10) {
            return this.f1184a.f(j2);
        }
        c cVar = new c();
        this.f1184a.a(cVar, 0L, Math.min(32L, this.f1184a.b()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f1184a.b(), j) + " content=" + cVar.o().f() + (char) 8230);
    }

    @Override // b.e
    public short i() throws EOFException {
        a(2L);
        return this.f1184a.i();
    }

    @Override // b.e
    public short k() throws EOFException {
        a(2L);
        return this.f1184a.k();
    }

    @Override // b.e
    public int j() throws EOFException {
        a(4L);
        return this.f1184a.j();
    }

    @Override // b.e
    public int l() throws EOFException {
        a(4L);
        return this.f1184a.l();
    }

    @Override // b.e
    public long m() throws EOFException {
        byte b2;
        a(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!b(i2)) {
                break;
            }
            b2 = this.f1184a.b(i);
            if ((b2 < 48 || b2 > 57) && !(i == 0 && b2 == 45)) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(b2)));
        }
        return this.f1184a.m();
    }

    @Override // b.e
    public long n() throws EOFException {
        byte b2;
        a(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!b(i2)) {
                break;
            }
            b2 = this.f1184a.b(i);
            if ((b2 < 48 || b2 > 57) && ((b2 < 97 || b2 > 102) && (b2 < 65 || b2 > 70))) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(b2)));
        }
        return this.f1184a.n();
    }

    @Override // b.e
    public void h(long j) throws EOFException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.f1184a.f1165b == 0 && this.f1185b.a(this.f1184a, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.f1184a.b());
            this.f1184a.h(jMin);
            j -= jMin;
        }
    }

    @Override // b.e
    public long a(byte b2) {
        return a(b2, 0L, Long.MAX_VALUE);
    }

    public long a(byte b2, long j, long j2) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long jA = this.f1184a.a(b2, j, j2);
            if (jA != -1) {
                return jA;
            }
            long j3 = this.f1184a.f1165b;
            if (j3 >= j2 || this.f1185b.a(this.f1184a, 8192L) == -1) {
                return -1L;
            }
            j = Math.max(j, j3);
        }
        return -1L;
    }

    @Override // b.e
    public boolean a(long j, f fVar) {
        return a(j, fVar, 0, fVar.h());
    }

    public boolean a(long j, f fVar, int i, int i2) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || i < 0 || i2 < 0 || fVar.h() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = i3 + j;
            if (!b(1 + j2) || this.f1184a.b(j2) != fVar.a(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // b.e
    public InputStream f() {
        return new InputStream() { // from class: b.n.1
            @Override // java.io.InputStream
            public int read() throws IOException {
                if (n.this.c) {
                    throw new IOException("closed");
                }
                if (n.this.f1184a.f1165b == 0 && n.this.f1185b.a(n.this.f1184a, 8192L) == -1) {
                    return -1;
                }
                return n.this.f1184a.h() & Constants.DimensionIds.NETHER;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (n.this.c) {
                    throw new IOException("closed");
                }
                u.a(bArr.length, i, i2);
                if (n.this.f1184a.f1165b == 0 && n.this.f1185b.a(n.this.f1184a, 8192L) == -1) {
                    return -1;
                }
                return n.this.f1184a.a(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                if (n.this.c) {
                    throw new IOException("closed");
                }
                return (int) Math.min(n.this.f1184a.f1165b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                n.this.close();
            }

            public String toString() {
                return n.this + ".inputStream()";
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    @Override // b.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.f1185b.close();
        this.f1184a.s();
    }

    @Override // b.s
    public t a() {
        return this.f1185b.a();
    }

    public String toString() {
        return "buffer(" + this.f1185b + ")";
    }
}
