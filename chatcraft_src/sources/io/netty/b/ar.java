package io.netty.b;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.Iterator;

/* compiled from: WrappedCompositeByteBuf.java */
/* loaded from: classes.dex */
class ar extends m {
    private final m e;

    ar(m mVar) {
        super(mVar.F());
        this.e = mVar;
    }

    @Override // io.netty.b.d, io.netty.util.n
    public boolean D() {
        return this.e.D();
    }

    @Override // io.netty.b.a, io.netty.b.i
    public final int a() {
        return this.e.a();
    }

    @Override // io.netty.b.a, io.netty.b.i
    public final int b() {
        return this.e.b();
    }

    @Override // io.netty.b.a, io.netty.b.i
    public final int c() {
        return this.e.c();
    }

    @Override // io.netty.b.a, io.netty.b.i
    public final boolean e() {
        return this.e.e();
    }

    @Override // io.netty.b.a, io.netty.b.i
    public final boolean f() {
        return this.e.f();
    }

    @Override // io.netty.b.a, io.netty.b.i
    public final int g() {
        return this.e.g();
    }

    @Override // io.netty.b.a, io.netty.b.i
    public final int h() {
        return this.e.h();
    }

    @Override // io.netty.b.a, io.netty.b.i
    public final int i() {
        return this.e.i();
    }

    @Override // io.netty.b.a, io.netty.b.i
    public i a(ByteOrder byteOrder) {
        return this.e.a(byteOrder);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public short h(int i) {
        return this.e.h(i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public short i(int i) {
        return this.e.i(i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public short k(int i) {
        return this.e.k(i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public int m(int i) {
        return this.e.m(i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public int o(int i) {
        return this.e.o(i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public long q(int i) {
        return this.e.q(i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public long r(int i) {
        return this.e.r(i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public long s(int i) {
        return this.e.s(i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public byte n() {
        return this.e.n();
    }

    @Override // io.netty.b.a, io.netty.b.i
    public boolean o() {
        return this.e.o();
    }

    @Override // io.netty.b.a, io.netty.b.i
    public short p() {
        return this.e.p();
    }

    @Override // io.netty.b.a, io.netty.b.i
    public short q() {
        return this.e.q();
    }

    @Override // io.netty.b.a, io.netty.b.i
    public int r() {
        return this.e.r();
    }

    @Override // io.netty.b.a, io.netty.b.i
    public int s() {
        return this.e.s();
    }

    @Override // io.netty.b.a, io.netty.b.i
    public long t() {
        return this.e.t();
    }

    @Override // io.netty.b.a, io.netty.b.i
    public char u() {
        return this.e.u();
    }

    @Override // io.netty.b.a, io.netty.b.i
    public float v() {
        return this.e.v();
    }

    @Override // io.netty.b.a, io.netty.b.i
    public double w() {
        return this.e.w();
    }

    @Override // io.netty.b.a, io.netty.b.i
    public i u(int i) {
        return this.e.u(i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public i x() {
        return this.e.x();
    }

    @Override // io.netty.b.a, io.netty.b.i
    public i h(int i, int i2) {
        return this.e.h(i, i2);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public ByteBuffer y() {
        return this.e.y();
    }

    @Override // io.netty.b.a, io.netty.b.i
    public final int hashCode() {
        return this.e.hashCode();
    }

    @Override // io.netty.b.a, io.netty.b.i
    public final boolean equals(Object obj) {
        return this.e.equals(obj);
    }

    @Override // io.netty.b.a, io.netty.b.i, java.lang.Comparable
    /* renamed from: b */
    public final int compareTo(i iVar) {
        return this.e.compareTo(iVar);
    }

    @Override // io.netty.b.d, io.netty.util.n
    public final int C() {
        return this.e.C();
    }

    @Override // io.netty.b.a, io.netty.b.i
    public int a(GatheringByteChannel gatheringByteChannel, int i) {
        return this.e.a(gatheringByteChannel, i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public int a(InputStream inputStream, int i) {
        return this.e.a(inputStream, i);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public int a(ScatteringByteChannel scatteringByteChannel, int i) {
        return this.e.a(scatteringByteChannel, i);
    }

    @Override // io.netty.b.m
    public m a(boolean z, i iVar) throws Throwable {
        this.e.a(z, iVar);
        return this;
    }

    @Override // io.netty.b.m, java.lang.Iterable
    public Iterator<i> iterator() {
        return this.e.iterator();
    }

    @Override // io.netty.b.m, io.netty.b.i
    public final boolean H() {
        return this.e.H();
    }

    @Override // io.netty.b.m, io.netty.b.i
    public final boolean I() {
        return this.e.I();
    }

    @Override // io.netty.b.m, io.netty.b.i
    public final byte[] J() {
        return this.e.J();
    }

    @Override // io.netty.b.m, io.netty.b.i
    public final int K() {
        return this.e.K();
    }

    @Override // io.netty.b.m, io.netty.b.i
    public final boolean L() {
        return this.e.L();
    }

    @Override // io.netty.b.m, io.netty.b.i
    public final long M() {
        return this.e.M();
    }

    @Override // io.netty.b.m, io.netty.b.i
    public final int Q() {
        return this.e.Q();
    }

    @Override // io.netty.b.m, io.netty.b.i
    /* renamed from: I */
    public m C(int i) throws Throwable {
        this.e.C(i);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.i
    public final j F() {
        return this.e.F();
    }

    @Override // io.netty.b.m, io.netty.b.i
    public final ByteOrder G() {
        return this.e.G();
    }

    @Override // io.netty.b.m
    public final int J(int i) {
        return this.e.J(i);
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    public byte f(int i) {
        return this.e.f(i);
    }

    @Override // io.netty.b.m, io.netty.b.a
    protected final byte g(int i) {
        return this.e.g(i);
    }

    @Override // io.netty.b.m, io.netty.b.a
    protected final short j(int i) {
        return this.e.j(i);
    }

    @Override // io.netty.b.m, io.netty.b.a
    protected final short l(int i) {
        return this.e.l(i);
    }

    @Override // io.netty.b.m, io.netty.b.a
    protected final int n(int i) {
        return this.e.n(i);
    }

    @Override // io.netty.b.m, io.netty.b.a
    protected final int p(int i) {
        return this.e.p(i);
    }

    @Override // io.netty.b.m, io.netty.b.a
    protected final long t(int i) {
        return this.e.t(i);
    }

    @Override // io.netty.b.m, io.netty.b.i
    /* renamed from: c */
    public m a(int i, byte[] bArr, int i2, int i3) {
        this.e.a(i, bArr, i2, i3);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.i
    /* renamed from: c */
    public m a(int i, i iVar, int i2, int i3) {
        this.e.a(i, iVar, i2, i3);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.i
    public int a(int i, GatheringByteChannel gatheringByteChannel, int i2) {
        return this.e.a(i, gatheringByteChannel, i2);
    }

    @Override // io.netty.b.m, io.netty.b.i
    /* renamed from: b */
    public m a(int i, OutputStream outputStream, int i2) {
        this.e.a(i, outputStream, i2);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: o */
    public m b(int i, int i2) {
        this.e.b(i, i2);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a
    protected final void c(int i, int i2) {
        this.e.c(i, i2);
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: p */
    public m d(int i, int i2) {
        this.e.d(i, i2);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a
    protected final void e(int i, int i2) {
        this.e.e(i, i2);
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: q */
    public m f(int i, int i2) {
        this.e.f(i, i2);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a
    protected final void g(int i, int i2) {
        this.e.g(i, i2);
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: c */
    public m a(int i, long j) {
        this.e.a(i, j);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a
    protected final void b(int i, long j) {
        this.e.b(i, j);
    }

    @Override // io.netty.b.m, io.netty.b.i
    /* renamed from: d */
    public m b(int i, byte[] bArr, int i2, int i3) {
        this.e.b(i, bArr, i2, i3);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.i
    /* renamed from: d */
    public m b(int i, i iVar, int i2, int i3) {
        this.e.b(i, iVar, i2, i3);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.i
    public int a(int i, InputStream inputStream, int i2) {
        return this.e.a(i, inputStream, i2);
    }

    @Override // io.netty.b.m, io.netty.b.i
    public int a(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        return this.e.a(i, scatteringByteChannel, i2);
    }

    @Override // io.netty.b.m, io.netty.b.i
    public int N() {
        return this.e.N();
    }

    @Override // io.netty.b.m, io.netty.b.i
    public ByteBuffer l(int i, int i2) {
        return this.e.l(i, i2);
    }

    @Override // io.netty.b.m, io.netty.b.i
    public ByteBuffer m(int i, int i2) {
        return this.e.m(i, i2);
    }

    @Override // io.netty.b.m, io.netty.b.i
    public ByteBuffer[] n(int i, int i2) {
        return this.e.n(i, i2);
    }

    @Override // io.netty.b.m
    public m P() {
        this.e.P();
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    public final String toString() {
        return this.e.toString();
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: K */
    public final m b(int i) {
        this.e.b(i);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: L */
    public final m c(int i) {
        this.e.c(i);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: r */
    public final m a(int i, int i2) {
        this.e.a(i, i2);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a
    /* renamed from: R */
    public final m d() {
        this.e.d();
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: S */
    public final m j() {
        this.e.j();
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: T */
    public final m k() {
        this.e.k();
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: D */
    public m e(int i) {
        this.e.e(i);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: c */
    public m a(byte[] bArr) {
        this.e.a(bArr);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: c */
    public m a(byte[] bArr, int i, int i2) {
        this.e.a(bArr, i, i2);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: b */
    public m a(OutputStream outputStream, int i) {
        this.e.a(outputStream, i);
        return this;
    }

    @Override // io.netty.b.a
    protected ae m() {
        return this.e.m();
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: b */
    public m a(boolean z) {
        this.e.a(z);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: E */
    public m v(int i) {
        this.e.v(i);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: F */
    public m w(int i) {
        this.e.w(i);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: G */
    public m x(int i) {
        this.e.x(i);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: b */
    public m a(long j) {
        this.e.a(j);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: H */
    public m y(int i) {
        this.e.y(i);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: b */
    public m a(float f) {
        this.e.a(f);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: b */
    public m a(double d) {
        this.e.a(d);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: c */
    public m a(i iVar) {
        this.e.a(iVar);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a
    /* renamed from: b */
    public m a(i iVar, int i) {
        this.e.a(iVar, i);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: b */
    public m a(i iVar, int i, int i2) {
        this.e.a(iVar, i, i2);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: d */
    public m b(byte[] bArr) {
        this.e.b(bArr);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: d */
    public m b(byte[] bArr, int i, int i2) {
        this.e.b(bArr, i, i2);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.d, io.netty.b.i, io.netty.util.n
    /* renamed from: c */
    public m b(Object obj) {
        this.e.b(obj);
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    public ByteBuffer[] z() {
        return this.e.z();
    }

    @Override // io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: O */
    public m l() {
        this.e.l();
        return this;
    }

    @Override // io.netty.b.m, io.netty.b.d
    public final void E() {
        this.e.E();
    }

    @Override // io.netty.b.m, io.netty.b.i
    public final i A_() {
        return this.e;
    }
}
