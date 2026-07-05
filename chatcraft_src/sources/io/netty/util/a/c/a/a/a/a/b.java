package io.netty.util.a.c.a.a.a.a;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BaseLinkedAtomicQueue.java */
/* loaded from: classes.dex */
abstract class b<E> extends AbstractQueue<E> {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<c<E>> f4663a = new AtomicReference<>();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicReference<c<E>> f4664b = new AtomicReference<>();

    protected final c<E> a() {
        return this.f4663a.get();
    }

    protected final c<E> a(c<E> cVar) {
        return this.f4663a.getAndSet(cVar);
    }

    protected final c<E> b() {
        return this.f4664b.get();
    }

    protected final c<E> c() {
        return this.f4664b.get();
    }

    protected final void b(c<E> cVar) {
        this.f4664b.lazySet(cVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        c<E> cVarB = b();
        c<E> cVarA = a();
        int i = 0;
        while (cVarB != cVarA && cVarB != null && i < Integer.MAX_VALUE) {
            c<E> cVarC = cVarB.c();
            cVarB = cVarC == cVarB ? b() : cVarC;
            i++;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return b() == a();
    }

    protected E a(c<E> cVar, c<E> cVar2) {
        E eA = cVar2.a();
        cVar.a((c) cVar);
        b(cVar2);
        return eA;
    }
}
