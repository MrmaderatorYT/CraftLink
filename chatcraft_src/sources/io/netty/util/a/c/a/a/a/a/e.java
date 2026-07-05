package io.netty.util.a.c.a.a.a.a;

/* compiled from: MpscLinkedAtomicQueue.java */
/* loaded from: classes.dex */
public final class e<E> extends b<E> {
    public e() {
        c<E> cVar = new c<>();
        b(cVar);
        a(cVar);
    }

    @Override // java.util.Queue
    public final boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        c<E> cVar = new c<>(e);
        a(cVar).a((c) cVar);
        return true;
    }

    @Override // java.util.Queue
    public final E poll() {
        c<E> cVarC;
        c<E> cVarC2 = c();
        c<E> cVarC3 = cVarC2.c();
        if (cVarC3 != null) {
            return a(cVarC2, cVarC3);
        }
        if (cVarC2 == a()) {
            return null;
        }
        do {
            cVarC = cVarC2.c();
        } while (cVarC == null);
        return a(cVarC2, cVarC);
    }

    @Override // java.util.Queue
    public final E peek() {
        c<E> cVarC;
        c<E> cVarC2 = c();
        c<E> cVarC3 = cVarC2.c();
        if (cVarC3 != null) {
            return cVarC3.b();
        }
        if (cVarC2 == a()) {
            return null;
        }
        do {
            cVarC = cVarC2.c();
        } while (cVarC == null);
        return cVarC.b();
    }
}
