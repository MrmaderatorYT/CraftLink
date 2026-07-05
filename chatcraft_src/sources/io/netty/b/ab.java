package io.netty.b;

import io.netty.util.l;

/* compiled from: PooledUnsafeHeapByteBuf.java */
/* loaded from: classes.dex */
final class ab extends z {
    private static final io.netty.util.l<ab> l = new io.netty.util.l<ab>() { // from class: io.netty.b.ab.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ab b(l.b<ab> bVar) {
            return new ab(bVar, 0);
        }
    };

    static ab G(int i) {
        ab abVarA = l.a();
        abVarA.D(i);
        return abVarA;
    }

    private ab(l.b<ab> bVar, int i) {
        super(bVar, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.z, io.netty.b.a
    protected byte g(int i) {
        return an.a((byte[]) this.f, E(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.z, io.netty.b.a
    protected short j(int i) {
        return an.b((byte[]) this.f, E(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.z, io.netty.b.a
    protected short l(int i) {
        return an.c((byte[]) this.f, E(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.z, io.netty.b.a
    protected int n(int i) {
        return an.d((byte[]) this.f, E(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.z, io.netty.b.a
    protected int p(int i) {
        return an.e((byte[]) this.f, E(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.z, io.netty.b.a
    protected long t(int i) {
        return an.f((byte[]) this.f, E(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.z, io.netty.b.a
    protected void c(int i, int i2) {
        an.a((byte[]) this.f, E(i), i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.z, io.netty.b.a
    protected void e(int i, int i2) {
        an.b((byte[]) this.f, E(i), i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.z, io.netty.b.a
    protected void g(int i, int i2) {
        an.c((byte[]) this.f, E(i), i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.b.z, io.netty.b.a
    protected void b(int i, long j) {
        an.a((byte[]) this.f, E(i), j);
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
