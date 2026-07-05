package io.netty.b;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* compiled from: WrappedByteBuf.java */
/* loaded from: classes.dex */
class aq extends i {

    /* renamed from: a, reason: collision with root package name */
    protected final i f4376a;

    protected aq(i iVar) {
        if (iVar == null) {
            throw new NullPointerException("buf");
        }
        this.f4376a = iVar;
    }

    @Override // io.netty.b.i
    public final boolean L() {
        return this.f4376a.L();
    }

    @Override // io.netty.b.i
    public final long M() {
        return this.f4376a.M();
    }

    @Override // io.netty.b.i
    public final int Q() {
        return this.f4376a.Q();
    }

    @Override // io.netty.b.i
    public i C(int i) {
        this.f4376a.C(i);
        return this;
    }

    @Override // io.netty.b.i
    public final int a() {
        return this.f4376a.a();
    }

    @Override // io.netty.b.i
    public final j F() {
        return this.f4376a.F();
    }

    @Override // io.netty.b.i
    public final ByteOrder G() {
        return this.f4376a.G();
    }

    @Override // io.netty.b.i
    public i a(ByteOrder byteOrder) {
        return this.f4376a.a(byteOrder);
    }

    @Override // io.netty.b.i
    public final i A_() {
        return this.f4376a;
    }

    @Override // io.netty.b.i
    public final boolean H() {
        return this.f4376a.H();
    }

    @Override // io.netty.b.i
    public final int b() {
        return this.f4376a.b();
    }

    @Override // io.netty.b.i
    public final i b(int i) {
        this.f4376a.b(i);
        return this;
    }

    @Override // io.netty.b.i
    public final int c() {
        return this.f4376a.c();
    }

    @Override // io.netty.b.i
    public final i c(int i) {
        this.f4376a.c(i);
        return this;
    }

    @Override // io.netty.b.i
    public i a(int i, int i2) {
        this.f4376a.a(i, i2);
        return this;
    }

    @Override // io.netty.b.i
    public final int g() {
        return this.f4376a.g();
    }

    @Override // io.netty.b.i
    public final int h() {
        return this.f4376a.h();
    }

    @Override // io.netty.b.i
    public final int i() {
        return this.f4376a.i();
    }

    @Override // io.netty.b.i
    public final boolean e() {
        return this.f4376a.e();
    }

    @Override // io.netty.b.i
    public final boolean f() {
        return this.f4376a.f();
    }

    @Override // io.netty.b.i
    public final i j() {
        this.f4376a.j();
        return this;
    }

    @Override // io.netty.b.i
    public final i k() {
        this.f4376a.k();
        return this;
    }

    @Override // io.netty.b.i
    public i l() {
        this.f4376a.l();
        return this;
    }

    @Override // io.netty.b.i
    public i e(int i) {
        this.f4376a.e(i);
        return this;
    }

    @Override // io.netty.b.i
    public byte f(int i) {
        return this.f4376a.f(i);
    }

    @Override // io.netty.b.i
    public short h(int i) {
        return this.f4376a.h(i);
    }

    @Override // io.netty.b.i
    public short i(int i) {
        return this.f4376a.i(i);
    }

    @Override // io.netty.b.i
    public short k(int i) {
        return this.f4376a.k(i);
    }

    @Override // io.netty.b.i
    public int m(int i) {
        return this.f4376a.m(i);
    }

    @Override // io.netty.b.i
    public int o(int i) {
        return this.f4376a.o(i);
    }

    @Override // io.netty.b.i
    public long q(int i) {
        return this.f4376a.q(i);
    }

    @Override // io.netty.b.i
    public long r(int i) {
        return this.f4376a.r(i);
    }

    @Override // io.netty.b.i
    public long s(int i) {
        return this.f4376a.s(i);
    }

    @Override // io.netty.b.i
    public i a(int i, i iVar, int i2, int i3) {
        this.f4376a.a(i, iVar, i2, i3);
        return this;
    }

    @Override // io.netty.b.i
    public i a(int i, byte[] bArr, int i2, int i3) {
        this.f4376a.a(i, bArr, i2, i3);
        return this;
    }

    @Override // io.netty.b.i
    public i a(int i, OutputStream outputStream, int i2) {
        this.f4376a.a(i, outputStream, i2);
        return this;
    }

    @Override // io.netty.b.i
    public int a(int i, GatheringByteChannel gatheringByteChannel, int i2) {
        return this.f4376a.a(i, gatheringByteChannel, i2);
    }

    @Override // io.netty.b.i
    public i b(int i, int i2) {
        this.f4376a.b(i, i2);
        return this;
    }

    @Override // io.netty.b.i
    public i d(int i, int i2) {
        this.f4376a.d(i, i2);
        return this;
    }

    @Override // io.netty.b.i
    public i f(int i, int i2) {
        this.f4376a.f(i, i2);
        return this;
    }

    @Override // io.netty.b.i
    public i a(int i, long j) {
        this.f4376a.a(i, j);
        return this;
    }

    @Override // io.netty.b.i
    public i b(int i, i iVar, int i2, int i3) {
        this.f4376a.b(i, iVar, i2, i3);
        return this;
    }

    @Override // io.netty.b.i
    public i b(int i, byte[] bArr, int i2, int i3) {
        this.f4376a.b(i, bArr, i2, i3);
        return this;
    }

    @Override // io.netty.b.i
    public int a(int i, InputStream inputStream, int i2) {
        return this.f4376a.a(i, inputStream, i2);
    }

    @Override // io.netty.b.i
    public int a(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        return this.f4376a.a(i, scatteringByteChannel, i2);
    }

    @Override // io.netty.b.i
    public boolean o() {
        return this.f4376a.o();
    }

    @Override // io.netty.b.i
    public byte n() {
        return this.f4376a.n();
    }

    @Override // io.netty.b.i
    public short p() {
        return this.f4376a.p();
    }

    @Override // io.netty.b.i
    public short q() {
        return this.f4376a.q();
    }

    @Override // io.netty.b.i
    public int r() {
        return this.f4376a.r();
    }

    @Override // io.netty.b.i
    public int s() {
        return this.f4376a.s();
    }

    @Override // io.netty.b.i
    public long t() {
        return this.f4376a.t();
    }

    @Override // io.netty.b.i
    public char u() {
        return this.f4376a.u();
    }

    @Override // io.netty.b.i
    public float v() {
        return this.f4376a.v();
    }

    @Override // io.netty.b.i
    public double w() {
        return this.f4376a.w();
    }

    @Override // io.netty.b.i
    public i u(int i) {
        return this.f4376a.u(i);
    }

    @Override // io.netty.b.i
    public i a(byte[] bArr) {
        this.f4376a.a(bArr);
        return this;
    }

    @Override // io.netty.b.i
    public i a(byte[] bArr, int i, int i2) {
        this.f4376a.a(bArr, i, i2);
        return this;
    }

    @Override // io.netty.b.i
    public i a(OutputStream outputStream, int i) {
        this.f4376a.a(outputStream, i);
        return this;
    }

    @Override // io.netty.b.i
    public int a(GatheringByteChannel gatheringByteChannel, int i) {
        return this.f4376a.a(gatheringByteChannel, i);
    }

    @Override // io.netty.b.i
    public i a(boolean z) {
        this.f4376a.a(z);
        return this;
    }

    @Override // io.netty.b.i
    public i v(int i) {
        this.f4376a.v(i);
        return this;
    }

    @Override // io.netty.b.i
    public i w(int i) {
        this.f4376a.w(i);
        return this;
    }

    @Override // io.netty.b.i
    public i x(int i) {
        this.f4376a.x(i);
        return this;
    }

    @Override // io.netty.b.i
    public i a(long j) {
        this.f4376a.a(j);
        return this;
    }

    @Override // io.netty.b.i
    public i y(int i) {
        this.f4376a.y(i);
        return this;
    }

    @Override // io.netty.b.i
    public i a(float f) {
        this.f4376a.a(f);
        return this;
    }

    @Override // io.netty.b.i
    public i a(double d) {
        this.f4376a.a(d);
        return this;
    }

    @Override // io.netty.b.i
    public i a(i iVar) {
        this.f4376a.a(iVar);
        return this;
    }

    @Override // io.netty.b.i
    public i a(i iVar, int i, int i2) {
        this.f4376a.a(iVar, i, i2);
        return this;
    }

    @Override // io.netty.b.i
    public i b(byte[] bArr) {
        this.f4376a.b(bArr);
        return this;
    }

    @Override // io.netty.b.i
    public i b(byte[] bArr, int i, int i2) {
        this.f4376a.b(bArr, i, i2);
        return this;
    }

    @Override // io.netty.b.i
    public int a(InputStream inputStream, int i) {
        return this.f4376a.a(inputStream, i);
    }

    @Override // io.netty.b.i
    public int a(ScatteringByteChannel scatteringByteChannel, int i) {
        return this.f4376a.a(scatteringByteChannel, i);
    }

    @Override // io.netty.b.i
    public i x() {
        return this.f4376a.x();
    }

    @Override // io.netty.b.i
    public i h(int i, int i2) {
        return this.f4376a.h(i, i2);
    }

    @Override // io.netty.b.i
    public int N() {
        return this.f4376a.N();
    }

    @Override // io.netty.b.i
    public ByteBuffer y() {
        return this.f4376a.y();
    }

    @Override // io.netty.b.i
    public ByteBuffer m(int i, int i2) {
        return this.f4376a.m(i, i2);
    }

    @Override // io.netty.b.i
    public ByteBuffer[] z() {
        return this.f4376a.z();
    }

    @Override // io.netty.b.i
    public ByteBuffer[] n(int i, int i2) {
        return this.f4376a.n(i, i2);
    }

    @Override // io.netty.b.i
    public ByteBuffer l(int i, int i2) {
        return this.f4376a.l(i, i2);
    }

    @Override // io.netty.b.i
    public boolean I() {
        return this.f4376a.I();
    }

    @Override // io.netty.b.i
    public byte[] J() {
        return this.f4376a.J();
    }

    @Override // io.netty.b.i
    public int K() {
        return this.f4376a.K();
    }

    @Override // io.netty.b.i
    public int hashCode() {
        return this.f4376a.hashCode();
    }

    @Override // io.netty.b.i
    public boolean equals(Object obj) {
        return this.f4376a.equals(obj);
    }

    @Override // io.netty.b.i, java.lang.Comparable
    /* renamed from: b */
    public int compareTo(i iVar) {
        return this.f4376a.compareTo(iVar);
    }

    @Override // io.netty.b.i
    public String toString() {
        return io.netty.util.a.p.a(this) + '(' + this.f4376a.toString() + ')';
    }

    @Override // io.netty.b.i, io.netty.util.n
    /* renamed from: a */
    public i b(Object obj) {
        this.f4376a.b(obj);
        return this;
    }

    @Override // io.netty.util.n
    public final int C() {
        return this.f4376a.C();
    }

    @Override // io.netty.util.n
    public boolean D() {
        return this.f4376a.D();
    }
}
