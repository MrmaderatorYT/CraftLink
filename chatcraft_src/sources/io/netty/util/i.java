package io.netty.util;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: DefaultAttributeMap.java */
/* loaded from: classes.dex */
public class i implements d {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater<i, AtomicReferenceArray> f4765a;

    /* renamed from: b, reason: collision with root package name */
    private volatile AtomicReferenceArray<a<?>> f4766b;

    static {
        AtomicReferenceFieldUpdater<i, AtomicReferenceArray> atomicReferenceFieldUpdaterA = io.netty.util.a.l.a(i.class, "attributes");
        if (atomicReferenceFieldUpdaterA == null) {
            atomicReferenceFieldUpdaterA = AtomicReferenceFieldUpdater.newUpdater(i.class, AtomicReferenceArray.class, "b");
        }
        f4765a = atomicReferenceFieldUpdaterA;
    }

    @Override // io.netty.util.d
    public <T> b<T> a(c<T> cVar) {
        if (cVar == null) {
            throw new NullPointerException("key");
        }
        AtomicReferenceArray<a<?>> atomicReferenceArray = this.f4766b;
        if (atomicReferenceArray == null) {
            atomicReferenceArray = new AtomicReferenceArray<>(4);
            if (!f4765a.compareAndSet(this, null, atomicReferenceArray)) {
                atomicReferenceArray = this.f4766b;
            }
        }
        int iB = b(cVar);
        a<?> aVar = atomicReferenceArray.get(iB);
        if (aVar == null) {
            a<?> aVar2 = new a<>();
            a aVar3 = new a(aVar2, cVar);
            ((a) aVar2).e = aVar3;
            aVar3.d = aVar2;
            if (atomicReferenceArray.compareAndSet(iB, null, aVar2)) {
                return aVar3;
            }
            aVar = atomicReferenceArray.get(iB);
        }
        synchronized (aVar) {
            a<?> aVar4 = aVar;
            while (true) {
                a<?> aVar5 = ((a) aVar4).e;
                if (aVar5 == null) {
                    a aVar6 = new a(aVar, cVar);
                    ((a) aVar4).e = aVar6;
                    aVar6.d = aVar4;
                    return aVar6;
                }
                if (((a) aVar5).c == cVar && !((a) aVar5).f) {
                    return aVar5;
                }
                aVar4 = aVar5;
            }
        }
    }

    private static int b(c<?> cVar) {
        return cVar.b() & 3;
    }

    /* compiled from: DefaultAttributeMap.java */
    private static final class a<T> extends AtomicReference<T> implements b<T> {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ boolean f4767a = !i.class.desiredAssertionStatus();

        /* renamed from: b, reason: collision with root package name */
        private final a<?> f4768b;
        private final c<T> c;
        private a<?> d;
        private a<?> e;
        private volatile boolean f;

        a(a<?> aVar, c<T> cVar) {
            this.f4768b = aVar;
            this.c = cVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        a() {
            this.f4768b = this;
            this.c = null;
        }
    }
}
