package io.netty.b;

import java.nio.ByteBuffer;

/* compiled from: AbstractDerivedByteBuf.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class c extends a {
    protected c(int i) {
        super(i);
    }

    @Override // io.netty.util.n
    public final int C() {
        return A_().C();
    }

    @Override // io.netty.b.i, io.netty.util.n
    /* renamed from: a */
    public final i b(Object obj) {
        A_().b(obj);
        return this;
    }

    @Override // io.netty.util.n
    public final boolean D() {
        return A_().D();
    }

    @Override // io.netty.b.i
    public ByteBuffer l(int i, int i2) {
        return m(i, i2);
    }

    @Override // io.netty.b.i
    public ByteBuffer m(int i, int i2) {
        return A_().m(i, i2);
    }
}
