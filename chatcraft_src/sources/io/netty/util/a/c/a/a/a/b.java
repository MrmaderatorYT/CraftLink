package io.netty.util.a.c.a.a.a;

import java.util.Iterator;

/* compiled from: ConcurrentCircularArrayQueue.java */
/* loaded from: classes.dex */
public abstract class b<E> extends c<E> {

    /* renamed from: a, reason: collision with root package name */
    protected final long f4666a;

    /* renamed from: b, reason: collision with root package name */
    protected final E[] f4667b;

    public b(int i) {
        int iA = io.netty.util.a.c.a.a.b.b.a(i);
        this.f4666a = iA - 1;
        this.f4667b = (E[]) s.a(iA);
    }

    protected final long a(long j) {
        return a(j, this.f4666a);
    }

    protected static long a(long j, long j2) {
        return s.a(j, j2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }
}
