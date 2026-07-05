package io.netty.b;

/* compiled from: UnsafeHeapSwappedByteBuf.java */
/* loaded from: classes.dex */
final class ap extends f {
    ap(a aVar) {
        super(aVar);
    }

    private static int a(i iVar, int i) {
        return iVar.K() + i;
    }

    @Override // io.netty.b.f
    protected long c(a aVar, int i) {
        return io.netty.util.a.l.d(aVar.J(), a((i) aVar, i));
    }

    @Override // io.netty.b.f
    protected int b(a aVar, int i) {
        return io.netty.util.a.l.c(aVar.J(), a((i) aVar, i));
    }

    @Override // io.netty.b.f
    protected short a(a aVar, int i) {
        return io.netty.util.a.l.b(aVar.J(), a((i) aVar, i));
    }

    @Override // io.netty.b.f
    protected void a(a aVar, int i, short s) {
        io.netty.util.a.l.a(aVar.J(), a((i) aVar, i), s);
    }

    @Override // io.netty.b.f
    protected void a(a aVar, int i, int i2) {
        io.netty.util.a.l.a(aVar.J(), a((i) aVar, i), i2);
    }

    @Override // io.netty.b.f
    protected void a(a aVar, int i, long j) {
        io.netty.util.a.l.a(aVar.J(), a((i) aVar, i), j);
    }
}
