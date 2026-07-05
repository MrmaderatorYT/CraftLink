package io.netty.b;

/* compiled from: UnpooledUnsafeHeapByteBuf.java */
/* loaded from: classes.dex */
final class al extends ai {
    al(j jVar, int i, int i2) {
        super(jVar, i, i2);
    }

    @Override // io.netty.b.ai, io.netty.b.a, io.netty.b.i
    public byte f(int i) {
        z(i);
        return g(i);
    }

    @Override // io.netty.b.ai, io.netty.b.a
    protected byte g(int i) {
        return an.a(this.d, i);
    }

    @Override // io.netty.b.ai, io.netty.b.a, io.netty.b.i
    public short i(int i) {
        i(i, 2);
        return j(i);
    }

    @Override // io.netty.b.ai, io.netty.b.a
    protected short j(int i) {
        return an.b(this.d, i);
    }

    @Override // io.netty.b.ai, io.netty.b.a, io.netty.b.i
    public short k(int i) {
        i(i, 2);
        return l(i);
    }

    @Override // io.netty.b.ai, io.netty.b.a
    protected short l(int i) {
        return an.c(this.d, i);
    }

    @Override // io.netty.b.ai, io.netty.b.a, io.netty.b.i
    public int m(int i) {
        i(i, 4);
        return n(i);
    }

    @Override // io.netty.b.ai, io.netty.b.a
    protected int n(int i) {
        return an.d(this.d, i);
    }

    @Override // io.netty.b.ai, io.netty.b.a, io.netty.b.i
    public int o(int i) {
        i(i, 4);
        return p(i);
    }

    @Override // io.netty.b.ai, io.netty.b.a
    protected int p(int i) {
        return an.e(this.d, i);
    }

    @Override // io.netty.b.ai, io.netty.b.a, io.netty.b.i
    public long s(int i) {
        i(i, 8);
        return t(i);
    }

    @Override // io.netty.b.ai, io.netty.b.a
    protected long t(int i) {
        return an.f(this.d, i);
    }

    @Override // io.netty.b.ai, io.netty.b.a, io.netty.b.i
    public i b(int i, int i2) {
        z(i);
        c(i, i2);
        return this;
    }

    @Override // io.netty.b.ai, io.netty.b.a
    protected void c(int i, int i2) {
        an.a(this.d, i, i2);
    }

    @Override // io.netty.b.ai, io.netty.b.a, io.netty.b.i
    public i d(int i, int i2) {
        i(i, 2);
        e(i, i2);
        return this;
    }

    @Override // io.netty.b.ai, io.netty.b.a
    protected void e(int i, int i2) {
        an.b(this.d, i, i2);
    }

    @Override // io.netty.b.ai, io.netty.b.a, io.netty.b.i
    public i f(int i, int i2) {
        i(i, 4);
        g(i, i2);
        return this;
    }

    @Override // io.netty.b.ai, io.netty.b.a
    protected void g(int i, int i2) {
        an.c(this.d, i, i2);
    }

    @Override // io.netty.b.ai, io.netty.b.a, io.netty.b.i
    public i a(int i, long j) {
        i(i, 8);
        b(i, j);
        return this;
    }

    @Override // io.netty.b.ai, io.netty.b.a
    protected void b(int i, long j) {
        an.a(this.d, i, j);
    }

    @Override // io.netty.b.a
    @Deprecated
    protected ae m() {
        if (io.netty.util.a.l.g()) {
            return new ap(this);
        }
        return super.m();
    }
}
