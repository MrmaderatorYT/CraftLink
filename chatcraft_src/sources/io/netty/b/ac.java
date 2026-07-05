package io.netty.b;

import java.nio.ByteOrder;

/* compiled from: SimpleLeakAwareByteBuf.java */
/* loaded from: classes.dex */
final class ac extends aq {

    /* renamed from: b, reason: collision with root package name */
    private final io.netty.util.o f4369b;

    @Override // io.netty.b.aq, io.netty.b.i, io.netty.util.n
    /* renamed from: a */
    public i b(Object obj) {
        return this;
    }

    ac(i iVar, io.netty.util.o oVar) {
        super(iVar);
        this.f4369b = oVar;
    }

    @Override // io.netty.b.aq, io.netty.util.n
    public boolean D() {
        boolean zD = super.D();
        if (zD) {
            this.f4369b.b();
        }
        return zD;
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i a(ByteOrder byteOrder) {
        this.f4369b.a();
        return G() == byteOrder ? this : new ac(super.a(byteOrder), this.f4369b);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i x() {
        return new ac(super.x(), this.f4369b);
    }

    @Override // io.netty.b.aq, io.netty.b.i
    public i h(int i, int i2) {
        return new ac(super.h(i, i2), this.f4369b);
    }
}
