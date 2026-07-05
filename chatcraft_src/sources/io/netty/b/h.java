package io.netty.b;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.Iterator;

/* compiled from: AdvancedLeakAwareCompositeByteBuf.java */
/* loaded from: classes.dex */
final class h extends ar {
    private final io.netty.util.o e;

    h(m mVar, io.netty.util.o oVar) {
        super(mVar);
        this.e = oVar;
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public i a(ByteOrder byteOrder) {
        g.a(this.e);
        return G() == byteOrder ? this : new g(super.a(byteOrder), this.e);
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public i x() {
        g.a(this.e);
        return new g(super.x(), this.e);
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public i h(int i, int i2) {
        g.a(this.e);
        return new g(super.h(i, i2), this.e);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: O */
    public m l() {
        g.a(this.e);
        return super.l();
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: D */
    public m e(int i) {
        g.a(this.e);
        return super.e(i);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.a, io.netty.b.i
    public byte f(int i) {
        g.a(this.e);
        return super.f(i);
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public short h(int i) {
        g.a(this.e);
        return super.h(i);
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public short i(int i) {
        g.a(this.e);
        return super.i(i);
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public int m(int i) {
        g.a(this.e);
        return super.m(i);
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public long q(int i) {
        g.a(this.e);
        return super.q(i);
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public long s(int i) {
        g.a(this.e);
        return super.s(i);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.i
    /* renamed from: c */
    public m a(int i, i iVar, int i2, int i3) {
        g.a(this.e);
        return super.a(i, iVar, i2, i3);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.i
    /* renamed from: c */
    public m a(int i, byte[] bArr, int i2, int i3) {
        g.a(this.e);
        return super.a(i, bArr, i2, i3);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.i
    /* renamed from: b */
    public m a(int i, OutputStream outputStream, int i2) {
        g.a(this.e);
        return super.a(i, outputStream, i2);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.i
    public int a(int i, GatheringByteChannel gatheringByteChannel, int i2) {
        g.a(this.e);
        return super.a(i, gatheringByteChannel, i2);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: o */
    public m b(int i, int i2) {
        g.a(this.e);
        return super.b(i, i2);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: p */
    public m d(int i, int i2) {
        g.a(this.e);
        return super.d(i, i2);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: q */
    public m f(int i, int i2) {
        g.a(this.e);
        return super.f(i, i2);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: c */
    public m a(int i, long j) {
        g.a(this.e);
        return super.a(i, j);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.i
    /* renamed from: d */
    public m b(int i, i iVar, int i2, int i3) {
        g.a(this.e);
        return super.b(i, iVar, i2, i3);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.i
    /* renamed from: d */
    public m b(int i, byte[] bArr, int i2, int i3) {
        g.a(this.e);
        return super.b(i, bArr, i2, i3);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.i
    public int a(int i, InputStream inputStream, int i2) {
        g.a(this.e);
        return super.a(i, inputStream, i2);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.i
    public int a(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        g.a(this.e);
        return super.a(i, scatteringByteChannel, i2);
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public boolean o() {
        g.a(this.e);
        return super.o();
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public byte n() {
        g.a(this.e);
        return super.n();
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public short p() {
        g.a(this.e);
        return super.p();
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public short q() {
        g.a(this.e);
        return super.q();
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public int r() {
        g.a(this.e);
        return super.r();
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public int s() {
        g.a(this.e);
        return super.s();
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public long t() {
        g.a(this.e);
        return super.t();
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public char u() {
        g.a(this.e);
        return super.u();
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public float v() {
        g.a(this.e);
        return super.v();
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public double w() {
        g.a(this.e);
        return super.w();
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public i u(int i) {
        g.a(this.e);
        return super.u(i);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: c */
    public m a(byte[] bArr) {
        g.a(this.e);
        return super.a(bArr);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: c */
    public m a(byte[] bArr, int i, int i2) {
        g.a(this.e);
        return super.a(bArr, i, i2);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: b */
    public m a(OutputStream outputStream, int i) {
        g.a(this.e);
        return super.a(outputStream, i);
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public int a(GatheringByteChannel gatheringByteChannel, int i) {
        g.a(this.e);
        return super.a(gatheringByteChannel, i);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: b */
    public m a(boolean z) {
        g.a(this.e);
        return super.a(z);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: E */
    public m v(int i) {
        g.a(this.e);
        return super.v(i);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: F */
    public m w(int i) {
        g.a(this.e);
        return super.w(i);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: G */
    public m x(int i) {
        g.a(this.e);
        return super.x(i);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: b */
    public m a(long j) {
        g.a(this.e);
        return super.a(j);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: H */
    public m y(int i) {
        g.a(this.e);
        return super.y(i);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: b */
    public m a(float f) {
        g.a(this.e);
        return super.a(f);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: b */
    public m a(double d) {
        g.a(this.e);
        return super.a(d);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: c */
    public m a(i iVar) {
        g.a(this.e);
        return super.a(iVar);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.a
    /* renamed from: b */
    public m a(i iVar, int i) {
        g.a(this.e);
        return super.a(iVar, i);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: b */
    public m a(i iVar, int i, int i2) {
        g.a(this.e);
        return super.a(iVar, i, i2);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: d */
    public m b(byte[] bArr) {
        g.a(this.e);
        return super.b(bArr);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.a, io.netty.b.i
    /* renamed from: d */
    public m b(byte[] bArr, int i, int i2) {
        g.a(this.e);
        return super.b(bArr, i, i2);
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public int a(InputStream inputStream, int i) {
        g.a(this.e);
        return super.a(inputStream, i);
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public int a(ScatteringByteChannel scatteringByteChannel, int i) {
        g.a(this.e);
        return super.a(scatteringByteChannel, i);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.i
    public int N() {
        g.a(this.e);
        return super.N();
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public ByteBuffer y() {
        g.a(this.e);
        return super.y();
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.i
    public ByteBuffer m(int i, int i2) {
        g.a(this.e);
        return super.m(i, i2);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.a, io.netty.b.i
    public ByteBuffer[] z() {
        g.a(this.e);
        return super.z();
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.i
    public ByteBuffer[] n(int i, int i2) {
        g.a(this.e);
        return super.n(i, i2);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.i
    public ByteBuffer l(int i, int i2) {
        g.a(this.e);
        return super.l(i, i2);
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.i
    /* renamed from: I */
    public m C(int i) {
        g.a(this.e);
        return super.C(i);
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public short k(int i) {
        g.a(this.e);
        return super.k(i);
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public int o(int i) {
        g.a(this.e);
        return super.o(i);
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public long r(int i) {
        g.a(this.e);
        return super.r(i);
    }

    @Override // io.netty.b.ar, io.netty.b.m
    public m a(boolean z, i iVar) {
        g.a(this.e);
        return super.a(z, iVar);
    }

    @Override // io.netty.b.ar, io.netty.b.m, java.lang.Iterable
    public Iterator<i> iterator() {
        g.a(this.e);
        return super.iterator();
    }

    @Override // io.netty.b.ar, io.netty.b.m
    public m P() {
        g.a(this.e);
        return super.P();
    }

    @Override // io.netty.b.ar, io.netty.b.m, io.netty.b.d, io.netty.b.i, io.netty.util.n
    /* renamed from: c */
    public m b(Object obj) {
        this.e.a(obj);
        return this;
    }

    @Override // io.netty.b.ar, io.netty.b.d, io.netty.util.n
    public boolean D() {
        boolean zD = super.D();
        if (zD) {
            this.e.b();
        } else {
            this.e.a();
        }
        return zD;
    }
}
