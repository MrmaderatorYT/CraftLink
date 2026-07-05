package io.netty.b;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* compiled from: SwappedByteBuf.java */
@Deprecated
/* loaded from: classes.dex */
public class ae extends i {

    /* renamed from: a, reason: collision with root package name */
    private final i f4370a;

    /* renamed from: b, reason: collision with root package name */
    private final ByteOrder f4371b;

    public ae(i iVar) {
        if (iVar == null) {
            throw new NullPointerException("buf");
        }
        this.f4370a = iVar;
        if (iVar.G() == ByteOrder.BIG_ENDIAN) {
            this.f4371b = ByteOrder.LITTLE_ENDIAN;
        } else {
            this.f4371b = ByteOrder.BIG_ENDIAN;
        }
    }

    @Override // io.netty.b.i
    public ByteOrder G() {
        return this.f4371b;
    }

    @Override // io.netty.b.i
    public i a(ByteOrder byteOrder) {
        if (byteOrder != null) {
            return byteOrder == this.f4371b ? this : this.f4370a;
        }
        throw new NullPointerException("endianness");
    }

    @Override // io.netty.b.i
    public i A_() {
        return this.f4370a.A_();
    }

    @Override // io.netty.b.i
    public j F() {
        return this.f4370a.F();
    }

    @Override // io.netty.b.i
    public int Q() {
        return this.f4370a.Q();
    }

    @Override // io.netty.b.i
    public i C(int i) {
        this.f4370a.C(i);
        return this;
    }

    @Override // io.netty.b.i
    public int a() {
        return this.f4370a.a();
    }

    @Override // io.netty.b.i
    public boolean H() {
        return this.f4370a.H();
    }

    @Override // io.netty.b.i
    public int b() {
        return this.f4370a.b();
    }

    @Override // io.netty.b.i
    public i b(int i) {
        this.f4370a.b(i);
        return this;
    }

    @Override // io.netty.b.i
    public int c() {
        return this.f4370a.c();
    }

    @Override // io.netty.b.i
    public i c(int i) {
        this.f4370a.c(i);
        return this;
    }

    @Override // io.netty.b.i
    public i a(int i, int i2) {
        this.f4370a.a(i, i2);
        return this;
    }

    @Override // io.netty.b.i
    public int g() {
        return this.f4370a.g();
    }

    @Override // io.netty.b.i
    public int h() {
        return this.f4370a.h();
    }

    @Override // io.netty.b.i
    public int i() {
        return this.f4370a.i();
    }

    @Override // io.netty.b.i
    public boolean e() {
        return this.f4370a.e();
    }

    @Override // io.netty.b.i
    public boolean f() {
        return this.f4370a.f();
    }

    @Override // io.netty.b.i
    public i j() {
        this.f4370a.j();
        return this;
    }

    @Override // io.netty.b.i
    public i k() {
        this.f4370a.k();
        return this;
    }

    @Override // io.netty.b.i
    public i l() {
        this.f4370a.l();
        return this;
    }

    @Override // io.netty.b.i
    public i e(int i) {
        this.f4370a.e(i);
        return this;
    }

    @Override // io.netty.b.i
    public byte f(int i) {
        return this.f4370a.f(i);
    }

    @Override // io.netty.b.i
    public short h(int i) {
        return this.f4370a.h(i);
    }

    @Override // io.netty.b.i
    public short i(int i) {
        return l.a(this.f4370a.i(i));
    }

    @Override // io.netty.b.i
    public short k(int i) {
        return this.f4370a.i(i);
    }

    @Override // io.netty.b.i
    public int m(int i) {
        return l.a(this.f4370a.m(i));
    }

    @Override // io.netty.b.i
    public int o(int i) {
        return this.f4370a.m(i);
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
        return l.a(this.f4370a.s(i));
    }

    @Override // io.netty.b.i
    public i a(int i, i iVar, int i2, int i3) {
        this.f4370a.a(i, iVar, i2, i3);
        return this;
    }

    @Override // io.netty.b.i
    public i a(int i, byte[] bArr, int i2, int i3) {
        this.f4370a.a(i, bArr, i2, i3);
        return this;
    }

    @Override // io.netty.b.i
    public i a(int i, OutputStream outputStream, int i2) {
        this.f4370a.a(i, outputStream, i2);
        return this;
    }

    @Override // io.netty.b.i
    public int a(int i, GatheringByteChannel gatheringByteChannel, int i2) {
        return this.f4370a.a(i, gatheringByteChannel, i2);
    }

    @Override // io.netty.b.i
    public i b(int i, int i2) {
        this.f4370a.b(i, i2);
        return this;
    }

    @Override // io.netty.b.i
    public i d(int i, int i2) {
        this.f4370a.d(i, l.a((short) i2));
        return this;
    }

    @Override // io.netty.b.i
    public i f(int i, int i2) {
        this.f4370a.f(i, l.a(i2));
        return this;
    }

    @Override // io.netty.b.i
    public i a(int i, long j) {
        this.f4370a.a(i, l.a(j));
        return this;
    }

    @Override // io.netty.b.i
    public i b(int i, i iVar, int i2, int i3) {
        this.f4370a.b(i, iVar, i2, i3);
        return this;
    }

    @Override // io.netty.b.i
    public i b(int i, byte[] bArr, int i2, int i3) {
        this.f4370a.b(i, bArr, i2, i3);
        return this;
    }

    @Override // io.netty.b.i
    public int a(int i, InputStream inputStream, int i2) {
        return this.f4370a.a(i, inputStream, i2);
    }

    @Override // io.netty.b.i
    public int a(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        return this.f4370a.a(i, scatteringByteChannel, i2);
    }

    @Override // io.netty.b.i
    public boolean o() {
        return this.f4370a.o();
    }

    @Override // io.netty.b.i
    public byte n() {
        return this.f4370a.n();
    }

    @Override // io.netty.b.i
    public short p() {
        return this.f4370a.p();
    }

    @Override // io.netty.b.i
    public short q() {
        return l.a(this.f4370a.q());
    }

    @Override // io.netty.b.i
    public int r() {
        return q() & 65535;
    }

    @Override // io.netty.b.i
    public int s() {
        return l.a(this.f4370a.s());
    }

    @Override // io.netty.b.i
    public long t() {
        return l.a(this.f4370a.t());
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
        return this.f4370a.u(i).a(G());
    }

    @Override // io.netty.b.i
    public i a(byte[] bArr) {
        this.f4370a.a(bArr);
        return this;
    }

    @Override // io.netty.b.i
    public i a(byte[] bArr, int i, int i2) {
        this.f4370a.a(bArr, i, i2);
        return this;
    }

    @Override // io.netty.b.i
    public i a(OutputStream outputStream, int i) {
        this.f4370a.a(outputStream, i);
        return this;
    }

    @Override // io.netty.b.i
    public int a(GatheringByteChannel gatheringByteChannel, int i) {
        return this.f4370a.a(gatheringByteChannel, i);
    }

    @Override // io.netty.b.i
    public i a(boolean z) {
        this.f4370a.a(z);
        return this;
    }

    @Override // io.netty.b.i
    public i v(int i) {
        this.f4370a.v(i);
        return this;
    }

    @Override // io.netty.b.i
    public i w(int i) {
        this.f4370a.w(l.a((short) i));
        return this;
    }

    @Override // io.netty.b.i
    public i x(int i) {
        this.f4370a.x(l.a(i));
        return this;
    }

    @Override // io.netty.b.i
    public i a(long j) {
        this.f4370a.a(l.a(j));
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
    public i a(double d) {
        a(Double.doubleToRawLongBits(d));
        return this;
    }

    @Override // io.netty.b.i
    public i a(i iVar) {
        this.f4370a.a(iVar);
        return this;
    }

    @Override // io.netty.b.i
    public i a(i iVar, int i, int i2) {
        this.f4370a.a(iVar, i, i2);
        return this;
    }

    @Override // io.netty.b.i
    public i b(byte[] bArr) {
        this.f4370a.b(bArr);
        return this;
    }

    @Override // io.netty.b.i
    public i b(byte[] bArr, int i, int i2) {
        this.f4370a.b(bArr, i, i2);
        return this;
    }

    @Override // io.netty.b.i
    public int a(InputStream inputStream, int i) {
        return this.f4370a.a(inputStream, i);
    }

    @Override // io.netty.b.i
    public int a(ScatteringByteChannel scatteringByteChannel, int i) {
        return this.f4370a.a(scatteringByteChannel, i);
    }

    @Override // io.netty.b.i
    public i x() {
        return this.f4370a.x().a(this.f4371b);
    }

    @Override // io.netty.b.i
    public i h(int i, int i2) {
        return this.f4370a.h(i, i2).a(this.f4371b);
    }

    @Override // io.netty.b.i
    public int N() {
        return this.f4370a.N();
    }

    @Override // io.netty.b.i
    public ByteBuffer y() {
        return this.f4370a.y().order(this.f4371b);
    }

    @Override // io.netty.b.i
    public ByteBuffer m(int i, int i2) {
        return this.f4370a.m(i, i2).order(this.f4371b);
    }

    @Override // io.netty.b.i
    public ByteBuffer l(int i, int i2) {
        return m(i, i2);
    }

    @Override // io.netty.b.i
    public ByteBuffer[] z() {
        ByteBuffer[] byteBufferArrZ = this.f4370a.z();
        for (int i = 0; i < byteBufferArrZ.length; i++) {
            byteBufferArrZ[i] = byteBufferArrZ[i].order(this.f4371b);
        }
        return byteBufferArrZ;
    }

    @Override // io.netty.b.i
    public ByteBuffer[] n(int i, int i2) {
        ByteBuffer[] byteBufferArrN = this.f4370a.n(i, i2);
        for (int i3 = 0; i3 < byteBufferArrN.length; i3++) {
            byteBufferArrN[i3] = byteBufferArrN[i3].order(this.f4371b);
        }
        return byteBufferArrN;
    }

    @Override // io.netty.b.i
    public boolean I() {
        return this.f4370a.I();
    }

    @Override // io.netty.b.i
    public byte[] J() {
        return this.f4370a.J();
    }

    @Override // io.netty.b.i
    public int K() {
        return this.f4370a.K();
    }

    @Override // io.netty.b.i
    public boolean L() {
        return this.f4370a.L();
    }

    @Override // io.netty.b.i
    public long M() {
        return this.f4370a.M();
    }

    @Override // io.netty.util.n
    public int C() {
        return this.f4370a.C();
    }

    @Override // io.netty.b.i, io.netty.util.n
    /* renamed from: a */
    public i b(Object obj) {
        this.f4370a.b(obj);
        return this;
    }

    @Override // io.netty.util.n
    public boolean D() {
        return this.f4370a.D();
    }

    @Override // io.netty.b.i
    public int hashCode() {
        return this.f4370a.hashCode();
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
        return "Swapped(" + this.f4370a + ')';
    }
}
