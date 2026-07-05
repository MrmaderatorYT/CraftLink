package io.netty.b;

import java.nio.ByteOrder;

/* compiled from: SimpleLeakAwareCompositeByteBuf.java */
/* loaded from: classes.dex */
final class ad extends ar {
    private final io.netty.util.o e;

    ad(m mVar, io.netty.util.o oVar) {
        super(mVar);
        this.e = oVar;
    }

    @Override // io.netty.b.ar, io.netty.b.d, io.netty.util.n
    public boolean D() {
        boolean zD = super.D();
        if (zD) {
            this.e.b();
        }
        return zD;
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public i a(ByteOrder byteOrder) {
        this.e.a();
        return G() == byteOrder ? this : new ac(super.a(byteOrder), this.e);
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public i x() {
        return new ac(super.x(), this.e);
    }

    @Override // io.netty.b.ar, io.netty.b.a, io.netty.b.i
    public i h(int i, int i2) {
        return new ac(super.h(i, i2), this.e);
    }
}
