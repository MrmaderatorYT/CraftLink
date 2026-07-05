package io.netty.util.a.c.a.a.a.a;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: LinkedQueueAtomicNode.java */
/* loaded from: classes.dex */
public final class c<E> extends AtomicReference<c<E>> {

    /* renamed from: a, reason: collision with root package name */
    private E f4665a;

    c() {
    }

    c(E e) {
        a((c<E>) e);
    }

    public E a() {
        E eB = b();
        a((c<E>) null);
        return eB;
    }

    public E b() {
        return this.f4665a;
    }

    public void a(E e) {
        this.f4665a = e;
    }

    public void a(c<E> cVar) {
        lazySet(cVar);
    }

    public c<E> c() {
        return get();
    }
}
