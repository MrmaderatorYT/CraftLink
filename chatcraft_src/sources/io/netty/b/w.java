package io.netty.b;

import io.netty.util.l;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: PooledByteBuf.java */
/* loaded from: classes.dex */
abstract class w<T> extends d {
    static final /* synthetic */ boolean k = !w.class.desiredAssertionStatus();
    protected r<T> d;
    protected long e;
    protected T f;
    protected int g;
    protected int h;
    int i;
    v j;
    private final l.b<w<T>> l;
    private ByteBuffer m;

    @Override // io.netty.b.i
    public final i A_() {
        return null;
    }

    protected abstract ByteBuffer c(T t);

    /* JADX WARN: Multi-variable type inference failed */
    protected w(l.b<? extends w<T>> bVar, int i) {
        super(i);
        this.l = bVar;
    }

    void a(r<T> rVar, long j, int i, int i2, int i3, v vVar) {
        if (!k && j < 0) {
            throw new AssertionError();
        }
        if (!k && rVar == null) {
            throw new AssertionError();
        }
        this.d = rVar;
        this.e = j;
        this.f = rVar.f4399b;
        this.g = i;
        this.h = i2;
        this.i = i3;
        this.m = null;
        this.j = vVar;
    }

    void a(r<T> rVar, int i) {
        if (!k && rVar == null) {
            throw new AssertionError();
        }
        this.d = rVar;
        this.e = 0L;
        this.f = rVar.f4399b;
        this.g = 0;
        this.i = i;
        this.h = i;
        this.m = null;
        this.j = null;
    }

    final void D(int i) {
        a(i);
        B(1);
        k(0, 0);
        B();
    }

    @Override // io.netty.b.i
    public final int Q() {
        return this.h;
    }

    @Override // io.netty.b.i
    public final i C(int i) {
        A();
        if (this.d.c) {
            if (i == this.h) {
                return this;
            }
        } else if (i > this.h) {
            if (i <= this.i) {
                this.h = i;
                return this;
            }
        } else {
            if (i >= this.h) {
                return this;
            }
            if (i > (this.i >>> 1)) {
                if (this.i <= 512) {
                    if (i > this.i - 16) {
                        this.h = i;
                        a(Math.min(b(), i), Math.min(c(), i));
                        return this;
                    }
                } else {
                    this.h = i;
                    a(Math.min(b(), i), Math.min(c(), i));
                    return this;
                }
            }
        }
        this.d.f4398a.a((w) this, i, true);
        return this;
    }

    @Override // io.netty.b.i
    public final j F() {
        return this.d.f4398a.f4394b;
    }

    @Override // io.netty.b.i
    public final ByteOrder G() {
        return ByteOrder.BIG_ENDIAN;
    }

    protected final ByteBuffer O() {
        ByteBuffer byteBuffer = this.m;
        if (byteBuffer != null) {
            return byteBuffer;
        }
        ByteBuffer byteBufferC = c((w<T>) this.f);
        this.m = byteBufferC;
        return byteBufferC;
    }

    @Override // io.netty.b.d
    protected final void E() {
        if (this.e >= 0) {
            long j = this.e;
            this.e = -1L;
            this.f = null;
            this.d.f4398a.a(this.d, j, this.i, this.j);
            P();
        }
    }

    private void P() {
        this.l.a(this);
    }

    protected final int E(int i) {
        return this.g + i;
    }
}
