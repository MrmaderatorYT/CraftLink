package io.netty.b;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* compiled from: AdvancedLeakAwareByteBuf.java */
/* loaded from: classes.dex */
final class g extends aq {
    private final io.netty.util.o d;
    private static final io.netty.util.a.b.c c = io.netty.util.a.b.d.a((Class<?>) g.class);

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f4381b = io.netty.util.a.q.a("io.netty.leakDetection.acquireAndReleaseOnly", false);

    static {
        if (c.b()) {
            c.b("-D{}: {}", "io.netty.leakDetection.acquireAndReleaseOnly", Boolean.valueOf(f4381b));
        }
    }

    g(i iVar, io.netty.util.o oVar) {
        super(iVar);
        this.d = oVar;
    }

    static void a(io.netty.util.o oVar) {
        if (f4381b) {
            return;
        }
        oVar.a();
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i a(ByteOrder byteOrder) {
        a(this.d);
        return G() == byteOrder ? this : new g(super.a(byteOrder), this.d);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i x() {
        a(this.d);
        return new g(super.x(), this.d);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i h(int i, int i2) {
        a(this.d);
        return new g(super.h(i, i2), this.d);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i l() {
        a(this.d);
        return super.l();
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i e(int i) {
        a(this.d);
        return super.e(i);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public byte f(int i) {
        a(this.d);
        return super.f(i);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public short h(int i) {
        a(this.d);
        return super.h(i);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public short i(int i) {
        a(this.d);
        return super.i(i);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public int m(int i) {
        a(this.d);
        return super.m(i);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public long q(int i) {
        a(this.d);
        return super.q(i);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public long s(int i) {
        a(this.d);
        return super.s(i);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i a(int i, i iVar, int i2, int i3) {
        a(this.d);
        return super.a(i, iVar, i2, i3);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i a(int i, byte[] bArr, int i2, int i3) {
        a(this.d);
        return super.a(i, bArr, i2, i3);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i a(int i, OutputStream outputStream, int i2) {
        a(this.d);
        return super.a(i, outputStream, i2);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public int a(int i, GatheringByteChannel gatheringByteChannel, int i2) {
        a(this.d);
        return super.a(i, gatheringByteChannel, i2);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i b(int i, int i2) {
        a(this.d);
        return super.b(i, i2);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i d(int i, int i2) {
        a(this.d);
        return super.d(i, i2);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i f(int i, int i2) {
        a(this.d);
        return super.f(i, i2);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i a(int i, long j) {
        a(this.d);
        return super.a(i, j);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i b(int i, i iVar, int i2, int i3) {
        a(this.d);
        return super.b(i, iVar, i2, i3);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i b(int i, byte[] bArr, int i2, int i3) {
        a(this.d);
        return super.b(i, bArr, i2, i3);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public int a(int i, InputStream inputStream, int i2) {
        a(this.d);
        return super.a(i, inputStream, i2);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public int a(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        a(this.d);
        return super.a(i, scatteringByteChannel, i2);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public boolean o() {
        a(this.d);
        return super.o();
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public byte n() {
        a(this.d);
        return super.n();
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public short p() {
        a(this.d);
        return super.p();
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public short q() {
        a(this.d);
        return super.q();
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public int r() {
        a(this.d);
        return super.r();
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public int s() {
        a(this.d);
        return super.s();
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public long t() {
        a(this.d);
        return super.t();
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public char u() {
        a(this.d);
        return super.u();
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public float v() {
        a(this.d);
        return super.v();
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public double w() {
        a(this.d);
        return super.w();
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i u(int i) {
        a(this.d);
        return super.u(i);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i a(byte[] bArr) {
        a(this.d);
        return super.a(bArr);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i a(byte[] bArr, int i, int i2) {
        a(this.d);
        return super.a(bArr, i, i2);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i a(OutputStream outputStream, int i) {
        a(this.d);
        return super.a(outputStream, i);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public int a(GatheringByteChannel gatheringByteChannel, int i) {
        a(this.d);
        return super.a(gatheringByteChannel, i);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i a(boolean z) {
        a(this.d);
        return super.a(z);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i v(int i) {
        a(this.d);
        return super.v(i);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i w(int i) {
        a(this.d);
        return super.w(i);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i x(int i) {
        a(this.d);
        return super.x(i);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i a(long j) {
        a(this.d);
        return super.a(j);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i y(int i) {
        a(this.d);
        return super.y(i);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i a(float f) {
        a(this.d);
        return super.a(f);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i a(double d) {
        a(this.d);
        return super.a(d);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i a(i iVar) {
        a(this.d);
        return super.a(iVar);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i a(i iVar, int i, int i2) {
        a(this.d);
        return super.a(iVar, i, i2);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i b(byte[] bArr) {
        a(this.d);
        return super.b(bArr);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i b(byte[] bArr, int i, int i2) {
        a(this.d);
        return super.b(bArr, i, i2);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public int a(InputStream inputStream, int i) {
        a(this.d);
        return super.a(inputStream, i);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public int a(ScatteringByteChannel scatteringByteChannel, int i) {
        a(this.d);
        return super.a(scatteringByteChannel, i);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public int N() {
        a(this.d);
        return super.N();
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public ByteBuffer y() {
        a(this.d);
        return super.y();
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public ByteBuffer m(int i, int i2) {
        a(this.d);
        return super.m(i, i2);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public ByteBuffer[] z() {
        a(this.d);
        return super.z();
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public ByteBuffer[] n(int i, int i2) {
        a(this.d);
        return super.n(i, i2);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public ByteBuffer l(int i, int i2) {
        a(this.d);
        return super.l(i, i2);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i C(int i) {
        a(this.d);
        return super.C(i);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public short k(int i) {
        a(this.d);
        return super.k(i);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public int o(int i) {
        a(this.d);
        return super.o(i);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public long r(int i) {
        a(this.d);
        return super.r(i);
    }

    @Override // io.netty.b.aq, io.netty.b.i, io.netty.util.n
    /* renamed from: a */
    public i b(Object obj) {
        this.d.a(obj);
        return this;
    }

    @Override // io.netty.b.aq, io.netty.util.n
    public boolean D() {
        boolean zD = super.D();
        if (zD) {
            this.d.b();
        } else {
            this.d.a();
        }
        return zD;
    }
}
