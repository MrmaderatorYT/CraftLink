package io.netty.util.a.c.a.a.a.a;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: AtomicReferenceArrayQueue.java */
/* loaded from: classes.dex */
abstract class a<E> extends AbstractQueue<E> {

    /* renamed from: a, reason: collision with root package name */
    protected final AtomicReferenceArray<E> f4661a;

    /* renamed from: b, reason: collision with root package name */
    protected final int f4662b;

    protected final int a(long j, int i) {
        return ((int) j) & i;
    }

    public a(int i) {
        int iA = io.netty.util.a.c.a.a.b.b.a(i);
        this.f4662b = iA - 1;
        this.f4661a = new AtomicReferenceArray<>(iA);
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

    protected final int a(long j) {
        return ((int) j) & this.f4662b;
    }

    protected final E a(AtomicReferenceArray<E> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    protected final void a(AtomicReferenceArray<E> atomicReferenceArray, int i, E e) {
        atomicReferenceArray.lazySet(i, e);
    }

    protected final void a(int i, E e) {
        this.f4661a.lazySet(i, e);
    }
}
