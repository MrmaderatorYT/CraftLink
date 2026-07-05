package io.netty.util.a.c.a.a.a.a;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: MpscAtomicArrayQueue.java */
/* loaded from: classes.dex */
public final class d<E> extends a<E> {
    private final AtomicLong c;
    private final AtomicLong d;
    private volatile long e;

    @Override // io.netty.util.a.c.a.a.a.a.a, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // io.netty.util.a.c.a.a.a.a.a, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    public d(int i) {
        super(i);
        this.c = new AtomicLong();
        this.d = new AtomicLong();
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        long jC;
        if (e == null) {
            throw new NullPointerException();
        }
        int i = this.f4662b;
        long j = i + 1;
        long jA = a();
        do {
            jC = c();
            long j2 = jC - j;
            if (jA <= j2) {
                jA = b();
                if (jA <= j2) {
                    return false;
                }
                b(jA);
            }
        } while (!a(jC, 1 + jC));
        a(a(jC, i), (int) e);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long jB = b();
        int iA = a(jB);
        AtomicReferenceArray<E> atomicReferenceArray = this.f4661a;
        E eA = a(atomicReferenceArray, iA);
        if (eA == null) {
            if (jB == c()) {
                return null;
            }
            do {
                eA = a(atomicReferenceArray, iA);
            } while (eA == null);
        }
        a(atomicReferenceArray, iA, null);
        c(jB + 1);
        return eA;
    }

    @Override // java.util.Queue
    public E peek() {
        AtomicReferenceArray<E> atomicReferenceArray = this.f4661a;
        long jB = b();
        int iA = a(jB);
        E eA = a(atomicReferenceArray, iA);
        if (eA == null) {
            if (jB == c()) {
                return null;
            }
            do {
                eA = a(atomicReferenceArray, iA);
            } while (eA == null);
        }
        return eA;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long jB = b();
        while (true) {
            long jC = c();
            long jB2 = b();
            if (jB == jB2) {
                return (int) (jC - jB2);
            }
            jB = jB2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return b() == c();
    }

    private long b() {
        return this.c.get();
    }

    private long c() {
        return this.d.get();
    }

    protected final long a() {
        return this.e;
    }

    protected final void b(long j) {
        this.e = j;
    }

    protected final boolean a(long j, long j2) {
        return this.d.compareAndSet(j, j2);
    }

    protected void c(long j) {
        this.c.lazySet(j);
    }
}
