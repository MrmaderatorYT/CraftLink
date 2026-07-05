package io.netty.b;

import io.netty.b.q;
import io.netty.util.l;
import java.nio.ByteBuffer;
import java.util.Queue;

/* compiled from: PoolThreadCache.java */
/* loaded from: classes.dex */
final class v {
    private static final io.netty.util.a.b.c c = io.netty.util.a.b.d.a((Class<?>) v.class);

    /* renamed from: a, reason: collision with root package name */
    final q<byte[]> f4404a;

    /* renamed from: b, reason: collision with root package name */
    final q<ByteBuffer> f4405b;
    private final a<byte[]>[] d;
    private final a<byte[]>[] e;
    private final a<ByteBuffer>[] f;
    private final a<ByteBuffer>[] g;
    private final a<byte[]>[] h;
    private final a<ByteBuffer>[] i;
    private final int j;
    private final int k;
    private final int l;
    private int m;
    private final Thread n = Thread.currentThread();
    private final Runnable o = new Runnable() { // from class: io.netty.b.v.1
        @Override // java.lang.Runnable
        public void run() {
            v.this.c();
        }
    };

    private static int a(int i) {
        int i2 = 0;
        while (i > 1) {
            i >>= 1;
            i2++;
        }
        return i2;
    }

    v(q<byte[]> qVar, q<ByteBuffer> qVar2, int i, int i2, int i3, int i4, int i5) {
        if (i4 < 0) {
            throw new IllegalArgumentException("maxCachedBufferCapacity: " + i4 + " (expected: >= 0)");
        }
        if (i5 < 1) {
            throw new IllegalArgumentException("freeSweepAllocationThreshold: " + i5 + " (expected: > 0)");
        }
        this.l = i5;
        this.f4404a = qVar;
        this.f4405b = qVar2;
        if (qVar2 != null) {
            this.f = a(i, 32, q.c.Tiny);
            this.g = a(i2, qVar2.g, q.c.Small);
            this.j = a(qVar2.c);
            this.i = a(i3, i4, qVar2);
            qVar2.h.getAndIncrement();
        } else {
            this.f = null;
            this.g = null;
            this.i = null;
            this.j = -1;
        }
        if (qVar != null) {
            this.d = a(i, 32, q.c.Tiny);
            this.e = a(i2, qVar.g, q.c.Small);
            this.k = a(qVar.c);
            this.h = a(i3, i4, qVar);
            qVar.h.getAndIncrement();
        } else {
            this.d = null;
            this.e = null;
            this.h = null;
            this.k = -1;
        }
        io.netty.util.t.a(this.n, this.o);
    }

    private static <T> a<T>[] a(int i, int i2, q.c cVar) {
        if (i <= 0) {
            return null;
        }
        a<T>[] aVarArr = new a[i2];
        for (int i3 = 0; i3 < aVarArr.length; i3++) {
            aVarArr[i3] = new c(i, cVar);
        }
        return aVarArr;
    }

    private static <T> a<T>[] a(int i, int i2, q<T> qVar) {
        if (i <= 0) {
            return null;
        }
        a<T>[] aVarArr = new a[Math.max(1, a(Math.min(qVar.e, i2) / qVar.c) + 1)];
        for (int i3 = 0; i3 < aVarArr.length; i3++) {
            aVarArr[i3] = new b(i);
        }
        return aVarArr;
    }

    boolean a(q<?> qVar, w<?> wVar, int i, int i2) {
        return a(a(qVar, i2), wVar, i);
    }

    boolean b(q<?> qVar, w<?> wVar, int i, int i2) {
        return a(b(qVar, i2), wVar, i);
    }

    boolean c(q<?> qVar, w<?> wVar, int i, int i2) {
        return a(c(qVar, i2), wVar, i);
    }

    private boolean a(a<?> aVar, w wVar, int i) {
        if (aVar == null) {
            return false;
        }
        boolean zA = aVar.a((w<?>) wVar, i);
        int i2 = this.m + 1;
        this.m = i2;
        if (i2 >= this.l) {
            this.m = 0;
            b();
        }
        return zA;
    }

    boolean a(q<?> qVar, r rVar, long j, int i, q.c cVar) {
        a<?> aVarA = a(qVar, i, cVar);
        if (aVarA == null) {
            return false;
        }
        return aVarA.a((r<?>) rVar, j);
    }

    private a<?> a(q<?> qVar, int i, q.c cVar) {
        switch (cVar) {
            case Normal:
                return c(qVar, i);
            case Small:
                return b(qVar, i);
            case Tiny:
                return a(qVar, i);
            default:
                throw new Error();
        }
    }

    void a() {
        io.netty.util.t.b(this.n, this.o);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int iA = a(this.f) + a(this.g) + a(this.i) + a((a<?>[]) this.d) + a((a<?>[]) this.e) + a((a<?>[]) this.h);
        if (iA > 0 && c.b()) {
            c.b("Freed {} thread-local buffer(s) from thread: {}", Integer.valueOf(iA), this.n.getName());
        }
        if (this.f4405b != null) {
            this.f4405b.h.getAndDecrement();
        }
        if (this.f4404a != null) {
            this.f4404a.h.getAndDecrement();
        }
    }

    private static int a(a<?>[] aVarArr) {
        if (aVarArr == null) {
            return 0;
        }
        int iA = 0;
        for (a<?> aVar : aVarArr) {
            iA += a(aVar);
        }
        return iA;
    }

    private static int a(a<?> aVar) {
        if (aVar == null) {
            return 0;
        }
        return aVar.a();
    }

    void b() {
        b(this.f);
        b(this.g);
        b(this.i);
        b((a<?>[]) this.d);
        b((a<?>[]) this.e);
        b((a<?>[]) this.h);
    }

    private static void b(a<?>[] aVarArr) {
        if (aVarArr == null) {
            return;
        }
        for (a<?> aVar : aVarArr) {
            b(aVar);
        }
    }

    private static void b(a<?> aVar) {
        if (aVar == null) {
            return;
        }
        aVar.b();
    }

    private a<?> a(q<?> qVar, int i) {
        int iA = q.a(i);
        if (qVar.a()) {
            return a(this.f, iA);
        }
        return a(this.d, iA);
    }

    private a<?> b(q<?> qVar, int i) {
        int iB = q.b(i);
        if (qVar.a()) {
            return a(this.g, iB);
        }
        return a(this.e, iB);
    }

    private a<?> c(q<?> qVar, int i) {
        if (qVar.a()) {
            return a(this.i, a(i >> this.j));
        }
        return a(this.h, a(i >> this.k));
    }

    private static <T> a<T> a(a<T>[] aVarArr, int i) {
        if (aVarArr == null || i > aVarArr.length - 1) {
            return null;
        }
        return aVarArr[i];
    }

    /* compiled from: PoolThreadCache.java */
    private static final class c<T> extends a<T> {
        c(int i, q.c cVar) {
            super(i, cVar);
        }

        @Override // io.netty.b.v.a
        protected void a(r<T> rVar, long j, w<T> wVar, int i) {
            rVar.b(wVar, j, i);
        }
    }

    /* compiled from: PoolThreadCache.java */
    private static final class b<T> extends a<T> {
        b(int i) {
            super(i, q.c.Normal);
        }

        @Override // io.netty.b.v.a
        protected void a(r<T> rVar, long j, w<T> wVar, int i) {
            rVar.a(wVar, j, i);
        }
    }

    /* compiled from: PoolThreadCache.java */
    private static abstract class a<T> {
        private static final io.netty.util.l<C0099a> e = new io.netty.util.l<C0099a>() { // from class: io.netty.b.v.a.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0099a b(l.b<C0099a> bVar) {
                return new C0099a(bVar);
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private final int f4408a;

        /* renamed from: b, reason: collision with root package name */
        private final Queue<C0099a<T>> f4409b;
        private final q.c c;
        private int d;

        protected abstract void a(r<T> rVar, long j, w<T> wVar, int i);

        a(int i, q.c cVar) {
            this.f4408a = io.netty.util.a.h.b(i);
            this.f4409b = io.netty.util.a.l.c(this.f4408a);
            this.c = cVar;
        }

        public final boolean a(r<T> rVar, long j) {
            C0099a<T> c0099aB = b(rVar, j);
            boolean zOffer = this.f4409b.offer(c0099aB);
            if (!zOffer) {
                c0099aB.a();
            }
            return zOffer;
        }

        public final boolean a(w<T> wVar, int i) {
            C0099a<T> c0099aPoll = this.f4409b.poll();
            if (c0099aPoll == null) {
                return false;
            }
            a(c0099aPoll.f4411b, c0099aPoll.c, wVar, i);
            c0099aPoll.a();
            this.d++;
            return true;
        }

        public final int a() {
            return a(Integer.MAX_VALUE);
        }

        private int a(int i) {
            int i2 = 0;
            while (i2 < i) {
                C0099a<T> c0099aPoll = this.f4409b.poll();
                if (c0099aPoll == null) {
                    return i2;
                }
                a(c0099aPoll);
                i2++;
            }
            return i2;
        }

        public final void b() {
            int i = this.f4408a - this.d;
            this.d = 0;
            if (i > 0) {
                a(i);
            }
        }

        private void a(C0099a c0099a) {
            r<T> rVar = c0099a.f4411b;
            long j = c0099a.c;
            c0099a.a();
            rVar.f4398a.a(rVar, j, this.c);
        }

        /* compiled from: PoolThreadCache.java */
        /* renamed from: io.netty.b.v$a$a, reason: collision with other inner class name */
        static final class C0099a<T> {

            /* renamed from: a, reason: collision with root package name */
            final l.b<C0099a<?>> f4410a;

            /* renamed from: b, reason: collision with root package name */
            r<T> f4411b;
            long c = -1;

            C0099a(l.b<C0099a<?>> bVar) {
                this.f4410a = bVar;
            }

            void a() {
                this.f4411b = null;
                this.c = -1L;
                this.f4410a.a(this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static C0099a b(r<?> rVar, long j) {
            C0099a c0099aA = e.a();
            c0099aA.f4411b = rVar;
            c0099aA.c = j;
            return c0099aA;
        }
    }
}
