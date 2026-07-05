package io.netty.b;

import io.netty.util.IllegalReferenceCountException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: AbstractReferenceCountedByteBuf.java */
/* loaded from: classes.dex */
public abstract class d extends a {
    private static final AtomicIntegerFieldUpdater<d> d;
    private volatile int e;

    protected abstract void E();

    @Override // io.netty.b.i, io.netty.util.n
    /* renamed from: a */
    public i b(Object obj) {
        return this;
    }

    static {
        AtomicIntegerFieldUpdater<d> atomicIntegerFieldUpdaterB = io.netty.util.a.l.b(d.class, "refCnt");
        if (atomicIntegerFieldUpdaterB == null) {
            atomicIntegerFieldUpdaterB = AtomicIntegerFieldUpdater.newUpdater(d.class, "e");
        }
        d = atomicIntegerFieldUpdaterB;
    }

    protected d(int i) {
        super(i);
        this.e = 1;
    }

    @Override // io.netty.util.n
    public int C() {
        return this.e;
    }

    protected final void B(int i) {
        this.e = i;
    }

    @Override // io.netty.util.n
    public boolean D() {
        return D(1);
    }

    private boolean D(int i) {
        int i2;
        do {
            i2 = this.e;
            if (i2 < i) {
                throw new IllegalReferenceCountException(i2, -i);
            }
        } while (!d.compareAndSet(this, i2, i2 - i));
        if (i2 != i) {
            return false;
        }
        E();
        return true;
    }
}
