package io.netty.util.a.c.a.a.a;

import java.util.Iterator;

/* compiled from: MpscChunkedArrayQueue.java */
/* loaded from: classes.dex */
public class k<E> extends m<E> {
    private static final long j;
    private static final long k;
    private static final long l;
    private static final Object m;

    static {
        try {
            j = io.netty.util.a.c.a.a.b.c.f4677b.objectFieldOffset(q.class.getDeclaredField("i"));
            try {
                k = io.netty.util.a.c.a.a.b.c.f4677b.objectFieldOffset(m.class.getDeclaredField("h"));
                try {
                    l = io.netty.util.a.c.a.a.b.c.f4677b.objectFieldOffset(l.class.getDeclaredField("d"));
                    m = new Object();
                } catch (NoSuchFieldException e) {
                    throw new RuntimeException(e);
                }
            } catch (NoSuchFieldException e2) {
                throw new RuntimeException(e2);
            }
        } catch (NoSuchFieldException e3) {
            throw new RuntimeException(e3);
        }
    }

    public k(int i, int i2, boolean z) {
        if (i < 2) {
            throw new IllegalArgumentException("Initial capacity must be 2 or more");
        }
        if (i2 < 4) {
            throw new IllegalArgumentException("Max capacity must be 4 or more");
        }
        if (io.netty.util.a.c.a.a.b.b.a(i) >= io.netty.util.a.c.a.a.b.b.a(i2)) {
            throw new IllegalArgumentException("Initial capacity cannot exceed maximum capacity(both rounded up to a power of 2)");
        }
        int iA = io.netty.util.a.c.a.a.b.b.a(i);
        long j2 = (iA - 1) << 1;
        E[] eArr = (E[]) a.a(iA + 1);
        this.c = eArr;
        this.f4669b = j2;
        this.g = eArr;
        this.f = j2;
        this.f4668a = io.netty.util.a.c.a.a.b.b.a(i2) << 1;
        this.e = z;
        d(j2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        while (true) {
            long jC = c();
            long jA = a();
            if ((jA & 1) != 1) {
                long j2 = this.f4669b;
                E[] eArr = this.c;
                if (jC <= jA) {
                    switch (a(j2, eArr, jA, jC)) {
                        case 2:
                            return false;
                        case 3:
                            a(j2, eArr, jA, this.h, this.f4668a, e);
                            return true;
                    }
                }
                if (c(jA, 2 + jA)) {
                    io.netty.util.a.c.a.a.b.d.b(eArr, b(jA, j2), e);
                    return true;
                }
            }
        }
    }

    private int a(long j2, E[] eArr, long j3, long j4) {
        long jB = b();
        long j5 = this.f4668a;
        long jA = a(j2, j5) + jB;
        if (jA > j3) {
            return !d(j4, jA) ? 1 : 0;
        }
        if (jB == j3 - j5) {
            return 2;
        }
        return c(j3, 1 + j3) ? 3 : 1;
    }

    private static long b(long j2, long j3) {
        return io.netty.util.a.c.a.a.b.d.f4678a + ((j2 & j3) << (io.netty.util.a.c.a.a.b.d.f4679b - 1));
    }

    @Override // java.util.Queue
    public E poll() {
        E[] eArr = this.g;
        long j2 = this.h;
        long j3 = this.f;
        long jB = b(j2, j3);
        E e = (E) io.netty.util.a.c.a.a.b.d.a(eArr, jB);
        if (e == null) {
            if (j2 == a()) {
                return null;
            }
            do {
                e = (E) io.netty.util.a.c.a.a.b.d.a(eArr, jB);
            } while (e == null);
        }
        if (e == m) {
            return b(a(eArr, j3), j2);
        }
        io.netty.util.a.c.a.a.b.d.b(eArr, jB, null);
        c(j2 + 2);
        return e;
    }

    @Override // java.util.Queue
    public E peek() {
        E[] eArr = this.g;
        long j2 = this.h;
        long j3 = this.f;
        long jB = b(j2, j3);
        E e = (E) io.netty.util.a.c.a.a.b.d.a(eArr, jB);
        if (e == null && j2 != a()) {
            do {
                e = (E) io.netty.util.a.c.a.a.b.d.a(eArr, jB);
            } while (e == null);
        }
        return e == m ? c(a(eArr, j3), j2) : e;
    }

    private E[] a(E[] eArr, long j2) {
        long jA = a(j2);
        E[] eArr2 = (E[]) ((Object[]) io.netty.util.a.c.a.a.b.d.a(eArr, jA));
        io.netty.util.a.c.a.a.b.d.b(eArr, jA, null);
        return eArr2;
    }

    private long a(long j2) {
        return b(j2 + 2, Long.MAX_VALUE);
    }

    private E b(E[] eArr, long j2) {
        long jD = d(eArr, j2);
        E e = (E) io.netty.util.a.c.a.a.b.d.a(eArr, jD);
        if (e == null) {
            throw new IllegalStateException("new buffer must have at least one element");
        }
        io.netty.util.a.c.a.a.b.d.b(eArr, jD, null);
        c(j2 + 2);
        return e;
    }

    private E c(E[] eArr, long j2) {
        E e = (E) io.netty.util.a.c.a.a.b.d.a(eArr, d(eArr, j2));
        if (e != null) {
            return e;
        }
        throw new IllegalStateException("new buffer must have at least one element");
    }

    private long d(E[] eArr, long j2) {
        this.g = eArr;
        this.f = (eArr.length - 2) << 1;
        return b(j2, this.f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long jB = b();
        while (true) {
            long jA = a();
            long jB2 = b();
            if (jB == jB2) {
                return ((int) (jA - jB2)) >> 1;
            }
            jB = jB2;
        }
    }

    private long a() {
        return io.netty.util.a.c.a.a.b.c.f4677b.getLongVolatile(this, j);
    }

    private long b() {
        return io.netty.util.a.c.a.a.b.c.f4677b.getLongVolatile(this, k);
    }

    private void b(long j2) {
        io.netty.util.a.c.a.a.b.c.f4677b.putOrderedLong(this, j, j2);
    }

    private boolean c(long j2, long j3) {
        return io.netty.util.a.c.a.a.b.c.f4677b.compareAndSwapLong(this, j, j2, j3);
    }

    private void c(long j2) {
        io.netty.util.a.c.a.a.b.c.f4677b.putOrderedLong(this, k, j2);
    }

    private long c() {
        return this.d;
    }

    private boolean d(long j2, long j3) {
        return io.netty.util.a.c.a.a.b.c.f4677b.compareAndSwapLong(this, l, j2, j3);
    }

    private void d(long j2) {
        io.netty.util.a.c.a.a.b.c.f4677b.putOrderedLong(this, l, j2);
    }

    private void a(long j2, E[] eArr, long j3, long j4, long j5, E e) {
        E[] eArr2 = (E[]) a.a(e(eArr, j5));
        this.c = eArr2;
        this.f4669b = (r8 - 2) << 1;
        long jB = b(j3, j2);
        io.netty.util.a.c.a.a.b.d.b(eArr2, b(j3, this.f4669b), e);
        io.netty.util.a.c.a.a.b.d.b(eArr, a(j2), eArr2);
        long j6 = j5 - (j3 - j4);
        if (j6 <= 0) {
            throw new IllegalStateException();
        }
        d(Math.min(j2, j6) + j3);
        io.netty.util.a.c.a.a.b.d.b(eArr, jB, m);
        b(2 + j3);
    }

    private int e(E[] eArr, long j2) {
        int length = eArr.length;
        if (this.e) {
            return eArr.length;
        }
        if (eArr.length - 1 == j2) {
            throw new IllegalStateException();
        }
        return (eArr.length * 2) - 1;
    }

    protected long a(long j2, long j3) {
        return (this.e || 2 + j2 != j3) ? j2 : j3;
    }
}
