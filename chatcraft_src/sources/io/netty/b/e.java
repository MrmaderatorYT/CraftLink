package io.netty.b;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* compiled from: AbstractUnpooledSlicedByteBuf.java */
/* loaded from: classes.dex */
abstract class e extends c {
    private final i d;
    private final int e;

    void B(int i) {
    }

    e(i iVar, int i, int i2) {
        super(i2);
        a(i, i2, iVar);
        if (iVar instanceof e) {
            e eVar = (e) iVar;
            this.d = eVar.d;
            this.e = eVar.e + i;
        } else if (iVar instanceof n) {
            this.d = iVar.A_();
            this.e = i;
        } else {
            this.d = iVar;
            this.e = i;
        }
        B(i2);
        c(i2);
    }

    @Override // io.netty.b.i
    public i A_() {
        return this.d;
    }

    @Override // io.netty.b.i
    public j F() {
        return A_().F();
    }

    @Override // io.netty.b.i
    @Deprecated
    public ByteOrder G() {
        return A_().G();
    }

    @Override // io.netty.b.i
    public boolean H() {
        return A_().H();
    }

    @Override // io.netty.b.i
    public i C(int i) {
        throw new UnsupportedOperationException("sliced buffer");
    }

    @Override // io.netty.b.i
    public boolean I() {
        return A_().I();
    }

    @Override // io.netty.b.i
    public byte[] J() {
        return A_().J();
    }

    @Override // io.netty.b.i
    public int K() {
        return D(A_().K());
    }

    @Override // io.netty.b.i
    public boolean L() {
        return A_().L();
    }

    @Override // io.netty.b.i
    public long M() {
        return A_().M() + this.e;
    }

    @Override // io.netty.b.a, io.netty.b.i
    public byte f(int i) {
        j(i, 1);
        return A_().f(D(i));
    }

    @Override // io.netty.b.a
    protected byte g(int i) {
        return A_().f(D(i));
    }

    @Override // io.netty.b.a, io.netty.b.i
    public short i(int i) {
        j(i, 2);
        return A_().i(D(i));
    }

    @Override // io.netty.b.a
    protected short j(int i) {
        return A_().i(D(i));
    }

    @Override // io.netty.b.a, io.netty.b.i
    public short k(int i) {
        j(i, 2);
        return A_().k(D(i));
    }

    @Override // io.netty.b.a
    protected short l(int i) {
        return A_().k(D(i));
    }

    @Override // io.netty.b.a, io.netty.b.i
    public int m(int i) {
        j(i, 4);
        return A_().m(D(i));
    }

    @Override // io.netty.b.a
    protected int n(int i) {
        return A_().m(D(i));
    }

    @Override // io.netty.b.a, io.netty.b.i
    public int o(int i) {
        j(i, 4);
        return A_().o(D(i));
    }

    @Override // io.netty.b.a
    protected int p(int i) {
        return A_().o(D(i));
    }

    @Override // io.netty.b.a, io.netty.b.i
    public long s(int i) {
        j(i, 8);
        return A_().s(D(i));
    }

    @Override // io.netty.b.a
    protected long t(int i) {
        return A_().s(D(i));
    }

    @Override // io.netty.b.a, io.netty.b.i
    public i h(int i, int i2) {
        j(i, i2);
        return A_().h(D(i), i2);
    }

    @Override // io.netty.b.i
    public i a(int i, i iVar, int i2, int i3) {
        j(i, i3);
        A_().a(D(i), iVar, i2, i3);
        return this;
    }

    @Override // io.netty.b.i
    public i a(int i, byte[] bArr, int i2, int i3) {
        j(i, i3);
        A_().a(D(i), bArr, i2, i3);
        return this;
    }

    @Override // io.netty.b.a, io.netty.b.i
    public i b(int i, int i2) {
        j(i, 1);
        A_().b(D(i), i2);
        return this;
    }

    @Override // io.netty.b.a
    protected void c(int i, int i2) {
        A_().b(D(i), i2);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public i d(int i, int i2) {
        j(i, 2);
        A_().d(D(i), i2);
        return this;
    }

    @Override // io.netty.b.a
    protected void e(int i, int i2) {
        A_().d(D(i), i2);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public i f(int i, int i2) {
        j(i, 4);
        A_().f(D(i), i2);
        return this;
    }

    @Override // io.netty.b.a
    protected void g(int i, int i2) {
        A_().f(D(i), i2);
    }

    @Override // io.netty.b.a, io.netty.b.i
    public i a(int i, long j) {
        j(i, 8);
        A_().a(D(i), j);
        return this;
    }

    @Override // io.netty.b.a
    protected void b(int i, long j) {
        A_().a(D(i), j);
    }

    @Override // io.netty.b.i
    public i b(int i, byte[] bArr, int i2, int i3) {
        j(i, i3);
        A_().b(D(i), bArr, i2, i3);
        return this;
    }

    @Override // io.netty.b.i
    public i b(int i, i iVar, int i2, int i3) {
        j(i, i3);
        A_().b(D(i), iVar, i2, i3);
        return this;
    }

    @Override // io.netty.b.i
    public i a(int i, OutputStream outputStream, int i2) {
        j(i, i2);
        A_().a(D(i), outputStream, i2);
        return this;
    }

    @Override // io.netty.b.i
    public int a(int i, GatheringByteChannel gatheringByteChannel, int i2) {
        j(i, i2);
        return A_().a(D(i), gatheringByteChannel, i2);
    }

    @Override // io.netty.b.i
    public int a(int i, InputStream inputStream, int i2) {
        j(i, i2);
        return A_().a(D(i), inputStream, i2);
    }

    @Override // io.netty.b.i
    public int a(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        j(i, i2);
        return A_().a(D(i), scatteringByteChannel, i2);
    }

    @Override // io.netty.b.i
    public int N() {
        return A_().N();
    }

    @Override // io.netty.b.c, io.netty.b.i
    public ByteBuffer m(int i, int i2) {
        j(i, i2);
        return A_().m(D(i), i2);
    }

    @Override // io.netty.b.i
    public ByteBuffer[] n(int i, int i2) {
        j(i, i2);
        return A_().n(D(i), i2);
    }

    final int D(int i) {
        return i + this.e;
    }

    static void a(int i, int i2, i iVar) {
        if (io.netty.util.a.h.a(i, i2, iVar.Q())) {
            throw new IndexOutOfBoundsException(iVar + ".slice(" + i + ", " + i2 + ')');
        }
    }
}
