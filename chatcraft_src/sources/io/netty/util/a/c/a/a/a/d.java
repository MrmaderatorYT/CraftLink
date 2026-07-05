package io.netty.util.a.c.a.a.a;

/* compiled from: MpscArrayQueue.java */
/* loaded from: classes.dex */
public class d<E> extends e<E> {
    public d(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        long jD;
        if (e == null) {
            throw new NullPointerException();
        }
        long j = this.f4666a;
        long jC = c();
        do {
            jD = d();
            if (jD >= jC) {
                jC = b() + j + 1;
                if (jD >= jC) {
                    return false;
                }
                c(jC);
            }
        } while (!b(jD, 1 + jD));
        io.netty.util.a.c.a.a.b.d.b(this.f4667b, a(jD, j), e);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long jA = a();
        long jA2 = a(jA);
        E[] eArr = this.f4667b;
        E e = (E) io.netty.util.a.c.a.a.b.d.a(eArr, jA2);
        if (e == null) {
            if (jA == d()) {
                return null;
            }
            do {
                e = (E) io.netty.util.a.c.a.a.b.d.a(eArr, jA2);
            } while (e == null);
        }
        io.netty.util.a.c.a.a.b.d.a(eArr, jA2, null);
        b(jA + 1);
        return e;
    }

    @Override // java.util.Queue
    public E peek() {
        E[] eArr = this.f4667b;
        long jA = a();
        long jA2 = a(jA);
        E e = (E) io.netty.util.a.c.a.a.b.d.a(eArr, jA2);
        if (e == null) {
            if (jA == d()) {
                return null;
            }
            do {
                e = (E) io.netty.util.a.c.a.a.b.d.a(eArr, jA2);
            } while (e == null);
        }
        return e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long jB = b();
        while (true) {
            long jD = d();
            long jB2 = b();
            if (jB == jB2) {
                return (int) (jD - jB2);
            }
            jB = jB2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return b() == d();
    }
}
