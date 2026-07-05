package io.netty.b;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* compiled from: EmptyByteBuf.java */
/* loaded from: classes.dex */
public final class o extends i {

    /* renamed from: a, reason: collision with root package name */
    private static final ByteBuffer f4391a = ByteBuffer.allocateDirect(0);

    /* renamed from: b, reason: collision with root package name */
    private static final long f4392b;
    private final j c;
    private final ByteOrder d;
    private final String e;
    private o f;

    @Override // io.netty.b.i
    public i A_() {
        return null;
    }

    @Override // io.netty.util.n
    public int C() {
        return 1;
    }

    @Override // io.netty.util.n
    public boolean D() {
        return false;
    }

    @Override // io.netty.b.i
    public boolean H() {
        return true;
    }

    @Override // io.netty.b.i
    public boolean I() {
        return true;
    }

    @Override // io.netty.b.i
    public int K() {
        return 0;
    }

    @Override // io.netty.b.i
    public int N() {
        return 1;
    }

    @Override // io.netty.b.i
    public int Q() {
        return 0;
    }

    @Override // io.netty.b.i
    public int a() {
        return 0;
    }

    @Override // io.netty.b.i, io.netty.util.n
    /* renamed from: a */
    public i b(Object obj) {
        return this;
    }

    @Override // io.netty.b.i
    public int b() {
        return 0;
    }

    @Override // io.netty.b.i
    public int c() {
        return 0;
    }

    @Override // io.netty.b.i
    public boolean e() {
        return false;
    }

    @Override // io.netty.b.i
    public boolean f() {
        return false;
    }

    @Override // io.netty.b.i
    public int g() {
        return 0;
    }

    @Override // io.netty.b.i
    public int h() {
        return 0;
    }

    @Override // io.netty.b.i
    public int hashCode() {
        return 0;
    }

    @Override // io.netty.b.i
    public int i() {
        return 0;
    }

    @Override // io.netty.b.i
    public i j() {
        return this;
    }

    @Override // io.netty.b.i
    public i k() {
        return this;
    }

    @Override // io.netty.b.i
    public i l() {
        return this;
    }

    @Override // io.netty.b.i
    public i x() {
        return this;
    }

    static {
        long jB = 0;
        try {
            if (io.netty.util.a.l.f()) {
                jB = io.netty.util.a.l.b(f4391a);
            }
        } catch (Throwable unused) {
        }
        f4392b = jB;
    }

    public o(j jVar) {
        this(jVar, ByteOrder.BIG_ENDIAN);
    }

    private o(j jVar, ByteOrder byteOrder) {
        if (jVar == null) {
            throw new NullPointerException("alloc");
        }
        this.c = jVar;
        this.d = byteOrder;
        StringBuilder sb = new StringBuilder();
        sb.append(io.netty.util.a.p.a(this));
        sb.append(byteOrder == ByteOrder.BIG_ENDIAN ? "BE" : "LE");
        this.e = sb.toString();
    }

    @Override // io.netty.b.i
    public i C(int i) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.b.i
    public j F() {
        return this.c;
    }

    @Override // io.netty.b.i
    public ByteOrder G() {
        return this.d;
    }

    @Override // io.netty.b.i
    public i a(ByteOrder byteOrder) {
        if (byteOrder == null) {
            throw new NullPointerException("endianness");
        }
        if (byteOrder == G()) {
            return this;
        }
        o oVar = this.f;
        if (oVar != null) {
            return oVar;
        }
        o oVar2 = new o(F(), byteOrder);
        this.f = oVar2;
        return oVar2;
    }

    @Override // io.netty.b.i
    public i b(int i) {
        return a(i);
    }

    @Override // io.netty.b.i
    public i c(int i) {
        return a(i);
    }

    @Override // io.netty.b.i
    public i a(int i, int i2) {
        a(i);
        a(i2);
        return this;
    }

    @Override // io.netty.b.i
    public i e(int i) {
        if (i >= 0) {
            if (i == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("minWritableBytes: " + i + " (expected: >= 0)");
    }

    @Override // io.netty.b.i
    public byte f(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public short h(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public short i(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public short k(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public int m(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public int o(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public long q(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public long r(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public long s(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public i a(int i, i iVar, int i2, int i3) {
        return c(i, i3);
    }

    @Override // io.netty.b.i
    public i a(int i, byte[] bArr, int i2, int i3) {
        return c(i, i3);
    }

    @Override // io.netty.b.i
    public i a(int i, OutputStream outputStream, int i2) {
        return c(i, i2);
    }

    @Override // io.netty.b.i
    public int a(int i, GatheringByteChannel gatheringByteChannel, int i2) {
        c(i, i2);
        return 0;
    }

    @Override // io.netty.b.i
    public i b(int i, int i2) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public i d(int i, int i2) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public i f(int i, int i2) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public i a(int i, long j) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public i b(int i, i iVar, int i2, int i3) {
        return c(i, i3);
    }

    @Override // io.netty.b.i
    public i b(int i, byte[] bArr, int i2, int i3) {
        return c(i, i3);
    }

    @Override // io.netty.b.i
    public int a(int i, InputStream inputStream, int i2) {
        c(i, i2);
        return 0;
    }

    @Override // io.netty.b.i
    public int a(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        c(i, i2);
        return 0;
    }

    @Override // io.netty.b.i
    public boolean o() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public byte n() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public short p() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public short q() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public int r() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public int s() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public long t() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public char u() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public float v() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public double w() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public i u(int i) {
        return d(i);
    }

    @Override // io.netty.b.i
    public i a(byte[] bArr) {
        return d(bArr.length);
    }

    @Override // io.netty.b.i
    public i a(byte[] bArr, int i, int i2) {
        return d(i2);
    }

    @Override // io.netty.b.i
    public i a(OutputStream outputStream, int i) {
        return d(i);
    }

    @Override // io.netty.b.i
    public int a(GatheringByteChannel gatheringByteChannel, int i) {
        d(i);
        return 0;
    }

    @Override // io.netty.b.i
    public i a(boolean z) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public i v(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public i w(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public i x(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public i a(long j) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public i y(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public i a(float f) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public i a(double d) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public i a(i iVar) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.b.i
    public i a(i iVar, int i, int i2) {
        return d(i2);
    }

    @Override // io.netty.b.i
    public i b(byte[] bArr) {
        return d(bArr.length);
    }

    @Override // io.netty.b.i
    public i b(byte[] bArr, int i, int i2) {
        return d(i2);
    }

    @Override // io.netty.b.i
    public int a(InputStream inputStream, int i) {
        d(i);
        return 0;
    }

    @Override // io.netty.b.i
    public int a(ScatteringByteChannel scatteringByteChannel, int i) {
        d(i);
        return 0;
    }

    @Override // io.netty.b.i
    public i h(int i, int i2) {
        return c(i, i2);
    }

    @Override // io.netty.b.i
    public ByteBuffer y() {
        return f4391a;
    }

    @Override // io.netty.b.i
    public ByteBuffer m(int i, int i2) {
        c(i, i2);
        return y();
    }

    @Override // io.netty.b.i
    public ByteBuffer[] z() {
        return new ByteBuffer[]{f4391a};
    }

    @Override // io.netty.b.i
    public ByteBuffer[] n(int i, int i2) {
        c(i, i2);
        return z();
    }

    @Override // io.netty.b.i
    public ByteBuffer l(int i, int i2) {
        return f4391a;
    }

    @Override // io.netty.b.i
    public byte[] J() {
        return io.netty.util.a.b.f4643a;
    }

    @Override // io.netty.b.i
    public boolean L() {
        return f4392b != 0;
    }

    @Override // io.netty.b.i
    public long M() {
        if (L()) {
            return f4392b;
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.b.i
    public boolean equals(Object obj) {
        return (obj instanceof i) && !((i) obj).e();
    }

    @Override // io.netty.b.i, java.lang.Comparable
    /* renamed from: b */
    public int compareTo(i iVar) {
        return iVar.e() ? -1 : 0;
    }

    @Override // io.netty.b.i
    public String toString() {
        return this.e;
    }

    private i a(int i) {
        if (i == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException();
    }

    private i c(int i, int i2) {
        if (i2 >= 0) {
            if (i == 0 && i2 == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("length: " + i2);
    }

    private i d(int i) {
        if (i >= 0) {
            if (i == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("length: " + i + " (expected: >= 0)");
    }
}
