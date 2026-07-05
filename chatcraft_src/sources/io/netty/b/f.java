package io.netty.b;

import java.nio.ByteOrder;

/* compiled from: AbstractUnsafeSwappedByteBuf.java */
/* loaded from: classes.dex */
abstract class f extends ae {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f4379a = !f.class.desiredAssertionStatus();

    /* renamed from: b, reason: collision with root package name */
    private final boolean f4380b;
    private final a c;

    protected abstract short a(a aVar, int i);

    protected abstract void a(a aVar, int i, int i2);

    protected abstract void a(a aVar, int i, long j);

    protected abstract void a(a aVar, int i, short s);

    protected abstract int b(a aVar, int i);

    protected abstract long c(a aVar, int i);

    f(a aVar) {
        super(aVar);
        if (!f4379a && !io.netty.util.a.l.g()) {
            throw new AssertionError();
        }
        this.c = aVar;
        this.f4380b = io.netty.util.a.l.f4686a == (G() == ByteOrder.BIG_ENDIAN);
    }

    @Override // io.netty.b.ae, io.netty.b.i
    public final long s(int i) {
        this.c.i(i, 8);
        long jC = c(this.c, i);
        return this.f4380b ? jC : Long.reverseBytes(jC);
    }

    @Override // io.netty.b.ae, io.netty.b.i
    public final long q(int i) {
        return m(i) & 4294967295L;
    }

    @Override // io.netty.b.ae, io.netty.b.i
    public final int m(int i) {
        this.c.j(i, 4);
        int iB = b(this.c, i);
        return this.f4380b ? iB : Integer.reverseBytes(iB);
    }

    @Override // io.netty.b.ae, io.netty.b.i
    public final short i(int i) {
        this.c.j(i, 2);
        short sA = a(this.c, i);
        return this.f4380b ? sA : Short.reverseBytes(sA);
    }

    @Override // io.netty.b.ae, io.netty.b.i
    public final i d(int i, int i2) {
        this.c.j(i, 2);
        a(this.c, i, this.f4380b ? (short) i2 : Short.reverseBytes((short) i2));
        return this;
    }

    @Override // io.netty.b.ae, io.netty.b.i
    public final i f(int i, int i2) {
        this.c.j(i, 4);
        a aVar = this.c;
        if (!this.f4380b) {
            i2 = Integer.reverseBytes(i2);
        }
        a(aVar, i, i2);
        return this;
    }

    @Override // io.netty.b.ae, io.netty.b.i
    public final i a(int i, long j) {
        this.c.i(i, 8);
        a aVar = this.c;
        if (!this.f4380b) {
            j = Long.reverseBytes(j);
        }
        a(aVar, i, j);
        return this;
    }

    @Override // io.netty.b.ae, io.netty.b.i
    public final i w(int i) {
        this.c.e(2);
        a(this.c, this.c.c, this.f4380b ? (short) i : Short.reverseBytes((short) i));
        this.c.c += 2;
        return this;
    }

    @Override // io.netty.b.ae, io.netty.b.i
    public final i x(int i) {
        this.c.e(4);
        a aVar = this.c;
        int i2 = this.c.c;
        if (!this.f4380b) {
            i = Integer.reverseBytes(i);
        }
        a(aVar, i2, i);
        this.c.c += 4;
        return this;
    }

    @Override // io.netty.b.ae, io.netty.b.i
    public final i a(long j) {
        this.c.e(8);
        a aVar = this.c;
        int i = this.c.c;
        if (!this.f4380b) {
            j = Long.reverseBytes(j);
        }
        a(aVar, i, j);
        this.c.c += 8;
        return this;
    }

    @Override // io.netty.b.ae, io.netty.b.i
    public final i y(int i) {
        w(i);
        return this;
    }

    @Override // io.netty.b.ae, io.netty.b.i
    public final i a(float f) {
        x(Float.floatToRawIntBits(f));
        return this;
    }

    @Override // io.netty.b.ae, io.netty.b.i
    public final i a(double d) {
        a(Double.doubleToRawLongBits(d));
        return this;
    }
}
