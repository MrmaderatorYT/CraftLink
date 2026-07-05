package io.netty.b;

/* compiled from: UnsafeDirectSwappedByteBuf.java */
/* loaded from: classes.dex */
final class ao extends f {
    ao(a aVar) {
        super(aVar);
    }

    private static long d(a aVar, int i) {
        return aVar.M() + i;
    }

    @Override // io.netty.b.f
    protected long c(a aVar, int i) {
        return io.netty.util.a.l.d(d(aVar, i));
    }

    @Override // io.netty.b.f
    protected int b(a aVar, int i) {
        return io.netty.util.a.l.c(d(aVar, i));
    }

    @Override // io.netty.b.f
    protected short a(a aVar, int i) {
        return io.netty.util.a.l.b(d(aVar, i));
    }

    @Override // io.netty.b.f
    protected void a(a aVar, int i, short s) {
        io.netty.util.a.l.a(d(aVar, i), s);
    }

    @Override // io.netty.b.f
    protected void a(a aVar, int i, int i2) {
        io.netty.util.a.l.a(d(aVar, i), i2);
    }

    @Override // io.netty.b.f
    protected void a(a aVar, int i, long j) {
        io.netty.util.a.l.a(d(aVar, i), j);
    }
}
