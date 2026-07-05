package io.netty.b;

import com.github.steveice10.mc.v1_5.util.Constants;
import io.netty.util.IllegalReferenceCountException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* compiled from: AbstractByteBuf.java */
/* loaded from: classes.dex */
public abstract class a extends i {

    /* renamed from: a, reason: collision with root package name */
    static final io.netty.util.p<i> f4367a;
    private static final io.netty.util.a.b.c d = io.netty.util.a.b.d.a((Class<?>) a.class);
    private static final boolean e = io.netty.util.a.q.a("io.netty.buffer.bytebuf.checkAccessible", true);

    /* renamed from: b, reason: collision with root package name */
    int f4368b;
    int c;
    private int f;
    private int g;
    private int h;

    protected abstract void b(int i, long j);

    protected abstract void c(int i, int i2);

    protected abstract void e(int i, int i2);

    protected abstract byte g(int i);

    protected abstract void g(int i, int i2);

    protected abstract short j(int i);

    protected abstract short l(int i);

    protected abstract int n(int i);

    protected abstract int p(int i);

    protected abstract long t(int i);

    static {
        if (d.b()) {
            d.b("-D{}: {}", "io.netty.buffer.bytebuf.checkAccessible", Boolean.valueOf(e));
        }
        f4367a = io.netty.util.q.a().a(i.class);
    }

    protected a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("maxCapacity: " + i + " (expected: >= 0)");
        }
        this.h = i;
    }

    @Override // io.netty.b.i
    public int a() {
        return this.h;
    }

    protected final void a(int i) {
        this.h = i;
    }

    @Override // io.netty.b.i
    public int b() {
        return this.f4368b;
    }

    @Override // io.netty.b.i
    public i b(int i) {
        if (i < 0 || i > this.c) {
            throw new IndexOutOfBoundsException(String.format("readerIndex: %d (expected: 0 <= readerIndex <= writerIndex(%d))", Integer.valueOf(i), Integer.valueOf(this.c)));
        }
        this.f4368b = i;
        return this;
    }

    @Override // io.netty.b.i
    public int c() {
        return this.c;
    }

    @Override // io.netty.b.i
    public i c(int i) {
        if (i < this.f4368b || i > Q()) {
            throw new IndexOutOfBoundsException(String.format("writerIndex: %d (expected: readerIndex(%d) <= writerIndex <= capacity(%d))", Integer.valueOf(i), Integer.valueOf(this.f4368b), Integer.valueOf(Q())));
        }
        this.c = i;
        return this;
    }

    @Override // io.netty.b.i
    public i a(int i, int i2) {
        if (i < 0 || i > i2 || i2 > Q()) {
            throw new IndexOutOfBoundsException(String.format("readerIndex: %d, writerIndex: %d (expected: 0 <= readerIndex <= writerIndex <= capacity(%d))", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(Q())));
        }
        k(i, i2);
        return this;
    }

    public i d() {
        this.c = 0;
        this.f4368b = 0;
        return this;
    }

    @Override // io.netty.b.i
    public boolean e() {
        return this.c > this.f4368b;
    }

    @Override // io.netty.b.i
    public boolean f() {
        return Q() > this.c;
    }

    @Override // io.netty.b.i
    public int g() {
        return this.c - this.f4368b;
    }

    @Override // io.netty.b.i
    public int h() {
        return Q() - this.c;
    }

    @Override // io.netty.b.i
    public int i() {
        return a() - this.c;
    }

    @Override // io.netty.b.i
    public i j() {
        this.f = this.f4368b;
        return this;
    }

    @Override // io.netty.b.i
    public i k() {
        b(this.f);
        return this;
    }

    @Override // io.netty.b.i
    public i l() {
        A();
        if (this.f4368b == 0) {
            return this;
        }
        if (this.f4368b == this.c) {
            d(this.f4368b);
            this.f4368b = 0;
            this.c = 0;
            return this;
        }
        if (this.f4368b >= (Q() >>> 1)) {
            b(0, this, this.f4368b, this.c - this.f4368b);
            this.c -= this.f4368b;
            d(this.f4368b);
            this.f4368b = 0;
        }
        return this;
    }

    protected final void d(int i) {
        int i2 = this.f;
        if (i2 <= i) {
            this.f = 0;
            int i3 = this.g;
            if (i3 <= i) {
                this.g = 0;
                return;
            } else {
                this.g = i3 - i;
                return;
            }
        }
        this.f = i2 - i;
        this.g -= i;
    }

    @Override // io.netty.b.i
    public i e(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(String.format("minWritableBytes: %d (expected: >= 0)", Integer.valueOf(i)));
        }
        B(i);
        return this;
    }

    private void B(int i) {
        if (i <= h()) {
            return;
        }
        if (i > this.h - this.c) {
            throw new IndexOutOfBoundsException(String.format("writerIndex(%d) + minWritableBytes(%d) exceeds maxCapacity(%d): %s", Integer.valueOf(this.c), Integer.valueOf(i), Integer.valueOf(this.h), this));
        }
        C(F().f(this.c + i, this.h));
    }

    @Override // io.netty.b.i
    public i a(ByteOrder byteOrder) {
        if (byteOrder != null) {
            return byteOrder == G() ? this : m();
        }
        throw new NullPointerException("endianness");
    }

    protected ae m() {
        return new ae(this);
    }

    @Override // io.netty.b.i
    public byte f(int i) {
        z(i);
        return g(i);
    }

    @Override // io.netty.b.i
    public short h(int i) {
        return (short) (f(i) & Constants.DimensionIds.NETHER);
    }

    @Override // io.netty.b.i
    public short i(int i) {
        i(i, 2);
        return j(i);
    }

    @Override // io.netty.b.i
    public short k(int i) {
        i(i, 2);
        return l(i);
    }

    @Override // io.netty.b.i
    public int m(int i) {
        i(i, 4);
        return n(i);
    }

    @Override // io.netty.b.i
    public int o(int i) {
        i(i, 4);
        return p(i);
    }

    @Override // io.netty.b.i
    public long q(int i) {
        return m(i) & 4294967295L;
    }

    @Override // io.netty.b.i
    public long r(int i) {
        return o(i) & 4294967295L;
    }

    @Override // io.netty.b.i
    public long s(int i) {
        i(i, 8);
        return t(i);
    }

    @Override // io.netty.b.i
    public i b(int i, int i2) {
        z(i);
        c(i, i2);
        return this;
    }

    @Override // io.netty.b.i
    public i d(int i, int i2) {
        i(i, 2);
        e(i, i2);
        return this;
    }

    @Override // io.netty.b.i
    public i f(int i, int i2) {
        i(i, 4);
        g(i, i2);
        return this;
    }

    @Override // io.netty.b.i
    public i a(int i, long j) {
        i(i, 8);
        b(i, j);
        return this;
    }

    @Override // io.netty.b.i
    public byte n() {
        D(1);
        int i = this.f4368b;
        byte bG = g(i);
        this.f4368b = i + 1;
        return bG;
    }

    @Override // io.netty.b.i
    public boolean o() {
        return n() != 0;
    }

    @Override // io.netty.b.i
    public short p() {
        return (short) (n() & Constants.DimensionIds.NETHER);
    }

    @Override // io.netty.b.i
    public short q() {
        D(2);
        short sJ = j(this.f4368b);
        this.f4368b += 2;
        return sJ;
    }

    @Override // io.netty.b.i
    public int r() {
        return q() & 65535;
    }

    @Override // io.netty.b.i
    public int s() {
        D(4);
        int iN = n(this.f4368b);
        this.f4368b += 4;
        return iN;
    }

    @Override // io.netty.b.i
    public long t() {
        D(8);
        long jT = t(this.f4368b);
        this.f4368b += 8;
        return jT;
    }

    @Override // io.netty.b.i
    public char u() {
        return (char) q();
    }

    @Override // io.netty.b.i
    public float v() {
        return Float.intBitsToFloat(s());
    }

    @Override // io.netty.b.i
    public double w() {
        return Double.longBitsToDouble(t());
    }

    @Override // io.netty.b.i
    public i u(int i) {
        A(i);
        if (i == 0) {
            return af.c;
        }
        i iVarA = F().a(i, this.h);
        iVarA.a(this, this.f4368b, i);
        this.f4368b += i;
        return iVarA;
    }

    @Override // io.netty.b.i
    public i a(byte[] bArr, int i, int i2) {
        A(i2);
        a(this.f4368b, bArr, i, i2);
        this.f4368b += i2;
        return this;
    }

    @Override // io.netty.b.i
    public i a(byte[] bArr) {
        a(bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.b.i
    public int a(GatheringByteChannel gatheringByteChannel, int i) {
        A(i);
        int iA = a(this.f4368b, gatheringByteChannel, i);
        this.f4368b += iA;
        return iA;
    }

    @Override // io.netty.b.i
    public i a(OutputStream outputStream, int i) {
        A(i);
        a(this.f4368b, outputStream, i);
        this.f4368b += i;
        return this;
    }

    @Override // io.netty.b.i
    public i a(boolean z) {
        v(z ? 1 : 0);
        return this;
    }

    @Override // io.netty.b.i
    public i v(int i) {
        A();
        B(1);
        int i2 = this.c;
        this.c = i2 + 1;
        c(i2, i);
        return this;
    }

    @Override // io.netty.b.i
    public i w(int i) {
        A();
        B(2);
        e(this.c, i);
        this.c += 2;
        return this;
    }

    @Override // io.netty.b.i
    public i x(int i) {
        A();
        B(4);
        g(this.c, i);
        this.c += 4;
        return this;
    }

    @Override // io.netty.b.i
    public i a(long j) {
        A();
        B(8);
        b(this.c, j);
        this.c += 8;
        return this;
    }

    @Override // io.netty.b.i
    public i y(int i) {
        w(i);
        return this;
    }

    @Override // io.netty.b.i
    public i a(float f) {
        x(Float.floatToRawIntBits(f));
        return this;
    }

    @Override // io.netty.b.i
    public i a(double d2) {
        a(Double.doubleToRawLongBits(d2));
        return this;
    }

    @Override // io.netty.b.i
    public i b(byte[] bArr, int i, int i2) {
        A();
        e(i2);
        b(this.c, bArr, i, i2);
        this.c += i2;
        return this;
    }

    @Override // io.netty.b.i
    public i b(byte[] bArr) {
        b(bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.b.i
    public i a(i iVar) {
        a(iVar, iVar.g());
        return this;
    }

    public i a(i iVar, int i) {
        if (i > iVar.g()) {
            throw new IndexOutOfBoundsException(String.format("length(%d) exceeds src.readableBytes(%d) where src is: %s", Integer.valueOf(i), Integer.valueOf(iVar.g()), iVar));
        }
        a(iVar, iVar.b(), i);
        iVar.b(iVar.b() + i);
        return this;
    }

    @Override // io.netty.b.i
    public i a(i iVar, int i, int i2) {
        A();
        e(i2);
        b(this.c, iVar, i, i2);
        this.c += i2;
        return this;
    }

    @Override // io.netty.b.i
    public int a(InputStream inputStream, int i) {
        A();
        e(i);
        int iA = a(this.c, inputStream, i);
        if (iA > 0) {
            this.c += iA;
        }
        return iA;
    }

    @Override // io.netty.b.i
    public int a(ScatteringByteChannel scatteringByteChannel, int i) {
        A();
        e(i);
        int iA = a(this.c, scatteringByteChannel, i);
        if (iA > 0) {
            this.c += iA;
        }
        return iA;
    }

    @Override // io.netty.b.i
    public i x() {
        return h(this.f4368b, g());
    }

    @Override // io.netty.b.i
    public i h(int i, int i2) {
        return new aj(this, i, i2);
    }

    @Override // io.netty.b.i
    public ByteBuffer y() {
        return m(this.f4368b, g());
    }

    @Override // io.netty.b.i
    public ByteBuffer[] z() {
        return n(this.f4368b, g());
    }

    @Override // io.netty.b.i
    public int hashCode() {
        return l.a(this);
    }

    @Override // io.netty.b.i
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i) {
            return l.a(this, (i) obj);
        }
        return false;
    }

    @Override // io.netty.b.i, java.lang.Comparable
    /* renamed from: b */
    public int compareTo(i iVar) {
        return l.b(this, iVar);
    }

    @Override // io.netty.b.i
    public String toString() {
        if (C() == 0) {
            return io.netty.util.a.p.a(this) + "(freed)";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(io.netty.util.a.p.a(this));
        sb.append("(ridx: ");
        sb.append(this.f4368b);
        sb.append(", widx: ");
        sb.append(this.c);
        sb.append(", cap: ");
        sb.append(Q());
        if (this.h != Integer.MAX_VALUE) {
            sb.append('/');
            sb.append(this.h);
        }
        i iVarA_ = A_();
        if (iVarA_ != null) {
            sb.append(", unwrapped: ");
            sb.append(iVarA_);
        }
        sb.append(')');
        return sb.toString();
    }

    protected final void z(int i) {
        i(i, 1);
    }

    protected final void i(int i, int i2) {
        A();
        j(i, i2);
    }

    final void j(int i, int i2) {
        if (io.netty.util.a.h.a(i, i2, Q())) {
            throw new IndexOutOfBoundsException(String.format("index: %d, length: %d (expected: range(0, %d))", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(Q())));
        }
    }

    protected final void a(int i, int i2, int i3, int i4) {
        i(i, i2);
        if (io.netty.util.a.h.a(i3, i2, i4)) {
            throw new IndexOutOfBoundsException(String.format("srcIndex: %d, length: %d (expected: range(0, %d))", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i4)));
        }
    }

    protected final void b(int i, int i2, int i3, int i4) {
        i(i, i2);
        if (io.netty.util.a.h.a(i3, i2, i4)) {
            throw new IndexOutOfBoundsException(String.format("dstIndex: %d, length: %d (expected: range(0, %d))", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i4)));
        }
    }

    protected final void A(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("minimumReadableBytes: " + i + " (expected: >= 0)");
        }
        D(i);
    }

    private void D(int i) {
        A();
        if (this.f4368b > this.c - i) {
            throw new IndexOutOfBoundsException(String.format("readerIndex(%d) + length(%d) exceeds writerIndex(%d): %s", Integer.valueOf(this.f4368b), Integer.valueOf(i), Integer.valueOf(this.c), this));
        }
    }

    protected final void A() {
        if (e && C() == 0) {
            throw new IllegalReferenceCountException(0);
        }
    }

    final void k(int i, int i2) {
        this.f4368b = i;
        this.c = i2;
    }

    final void B() {
        this.g = 0;
        this.f = 0;
    }
}
