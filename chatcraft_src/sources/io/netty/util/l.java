package io.netty.util;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Recycler.java */
/* loaded from: classes.dex */
public abstract class l<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final io.netty.util.a.b.c f4771a = io.netty.util.a.b.d.a((Class<?>) l.class);

    /* renamed from: b, reason: collision with root package name */
    private static final b f4772b = new b() { // from class: io.netty.util.l.1
        @Override // io.netty.util.l.b
        public void a(Object obj) {
        }
    };
    private static final AtomicInteger c = new AtomicInteger(Integer.MIN_VALUE);
    private static final int d = c.getAndIncrement();
    private static final int e;
    private static final int f;
    private static final int g;
    private static final int h;
    private static final int i;
    private static final int j;
    private static final io.netty.util.concurrent.n<Map<c<?>, d>> p;
    private final int k;
    private final int l;
    private final int m;
    private final int n;
    private final io.netty.util.concurrent.n<c<T>> o;

    /* compiled from: Recycler.java */
    public interface b<T> {
        void a(T t);
    }

    protected abstract T b(b<T> bVar);

    static {
        int iA = io.netty.util.a.q.a("io.netty.recycler.maxCapacityPerThread", io.netty.util.a.q.a("io.netty.recycler.maxCapacity", 32768));
        if (iA < 0) {
            iA = 32768;
        }
        e = iA;
        g = Math.max(2, io.netty.util.a.q.a("io.netty.recycler.maxSharedCapacityFactor", 2));
        h = Math.max(0, io.netty.util.a.q.a("io.netty.recycler.maxDelayedQueuesPerThread", Runtime.getRuntime().availableProcessors() * 2));
        i = io.netty.util.a.h.b(Math.max(io.netty.util.a.q.a("io.netty.recycler.linkCapacity", 16), 16));
        j = io.netty.util.a.h.b(io.netty.util.a.q.a("io.netty.recycler.ratio", 8));
        if (f4771a.b()) {
            if (e == 0) {
                f4771a.a("-Dio.netty.recycler.maxCapacityPerThread: disabled");
                f4771a.a("-Dio.netty.recycler.maxSharedCapacityFactor: disabled");
                f4771a.a("-Dio.netty.recycler.linkCapacity: disabled");
                f4771a.a("-Dio.netty.recycler.ratio: disabled");
            } else {
                f4771a.b("-Dio.netty.recycler.maxCapacityPerThread: {}", Integer.valueOf(e));
                f4771a.b("-Dio.netty.recycler.maxSharedCapacityFactor: {}", Integer.valueOf(g));
                f4771a.b("-Dio.netty.recycler.linkCapacity: {}", Integer.valueOf(i));
                f4771a.b("-Dio.netty.recycler.ratio: {}", Integer.valueOf(j));
            }
        }
        f = Math.min(e, 256);
        p = new io.netty.util.concurrent.n<Map<c<?>, d>>() { // from class: io.netty.util.l.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.concurrent.n
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map<c<?>, d> b() {
                return new WeakHashMap();
            }
        };
    }

    protected l() {
        this(e);
    }

    protected l(int i2) {
        this(i2, g);
    }

    protected l(int i2, int i3) {
        this(i2, i3, j, h);
    }

    protected l(int i2, int i3, int i4, int i5) {
        this.o = new io.netty.util.concurrent.n<c<T>>() { // from class: io.netty.util.l.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.concurrent.n
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c<T> b() {
                return new c<>(l.this, Thread.currentThread(), l.this.k, l.this.l, l.this.m, l.this.n);
            }
        };
        this.m = io.netty.util.a.h.b(i4) - 1;
        if (i2 <= 0) {
            this.k = 0;
            this.l = 1;
            this.n = 0;
        } else {
            this.k = i2;
            this.l = Math.max(1, i3);
            this.n = Math.max(0, i5);
        }
    }

    public final T a() {
        if (this.k == 0) {
            return b(f4772b);
        }
        c<T> cVarD = this.o.d();
        a<T> aVarA = cVarD.a();
        if (aVarA == null) {
            aVarA = cVarD.d();
            ((a) aVarA).e = b(aVarA);
        }
        return (T) ((a) aVarA).e;
    }

    /* compiled from: Recycler.java */
    static final class a<T> implements b<T> {

        /* renamed from: a, reason: collision with root package name */
        boolean f4774a;

        /* renamed from: b, reason: collision with root package name */
        private int f4775b;
        private int c;
        private c<?> d;
        private Object e;

        a(c<?> cVar) {
            this.d = cVar;
        }

        @Override // io.netty.util.l.b
        public void a(Object obj) {
            if (obj != this.e) {
                throw new IllegalArgumentException("object does not belong to handle");
            }
            this.d.a((a<?>) this);
        }
    }

    /* compiled from: Recycler.java */
    private static final class d {
        private a c;
        private a d;
        private d e;
        private final WeakReference<Thread> f;
        private final int g;
        private final AtomicInteger h;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ boolean f4779b = !l.class.desiredAssertionStatus();

        /* renamed from: a, reason: collision with root package name */
        static final d f4778a = new d();

        /* compiled from: Recycler.java */
        private static final class a extends AtomicInteger {

            /* renamed from: a, reason: collision with root package name */
            private final a<?>[] f4780a;

            /* renamed from: b, reason: collision with root package name */
            private int f4781b;
            private a c;

            private a() {
                this.f4780a = new a[l.i];
            }
        }

        private d() {
            this.g = l.c.getAndIncrement();
            this.f = null;
            this.h = null;
        }

        private d(c<?> cVar, Thread thread) {
            this.g = l.c.getAndIncrement();
            a aVar = new a();
            this.d = aVar;
            this.c = aVar;
            this.f = new WeakReference<>(thread);
            synchronized (cVar) {
                this.e = ((c) cVar).l;
                ((c) cVar).l = this;
            }
            this.h = cVar.c;
        }

        static d a(c<?> cVar, Thread thread) {
            if (a(cVar.c, l.i)) {
                return new d(cVar, thread);
            }
            return null;
        }

        private static boolean a(AtomicInteger atomicInteger, int i) {
            int i2;
            if (!f4779b && i < 0) {
                throw new AssertionError();
            }
            do {
                i2 = atomicInteger.get();
                if (i2 < i) {
                    return false;
                }
            } while (!atomicInteger.compareAndSet(i2, i2 - i));
            return true;
        }

        private void a(int i) {
            if (!f4779b && i < 0) {
                throw new AssertionError();
            }
            this.h.addAndGet(i);
        }

        void a(a<?> aVar) {
            ((a) aVar).f4775b = this.g;
            a aVar2 = this.d;
            int i = aVar2.get();
            if (i == l.i) {
                if (!a(this.h, l.i)) {
                    return;
                }
                aVar2 = aVar2.c = new a();
                this.d = aVar2;
                i = aVar2.get();
            }
            aVar2.f4780a[i] = aVar;
            ((a) aVar).d = null;
            aVar2.lazySet(i + 1);
        }

        boolean a() {
            return this.d.f4781b != this.d.get();
        }

        boolean a(c<?> cVar) {
            a aVar = this.c;
            if (aVar == null) {
                return false;
            }
            if (aVar.f4781b == l.i) {
                if (aVar.c == null) {
                    return false;
                }
                aVar = aVar.c;
                this.c = aVar;
            }
            int i = aVar.f4781b;
            int iMin = aVar.get();
            int i2 = iMin - i;
            if (i2 == 0) {
                return false;
            }
            int i3 = ((c) cVar).h;
            int i4 = i2 + i3;
            if (i4 > ((c) cVar).g.length) {
                iMin = Math.min((cVar.a(i4) + i) - i3, iMin);
            }
            if (i == iMin) {
                return false;
            }
            a<?>[] aVarArr = aVar.f4780a;
            a[] aVarArr2 = ((c) cVar).g;
            while (i < iMin) {
                a<?> aVar2 = aVarArr[i];
                if (((a) aVar2).c == 0) {
                    ((a) aVar2).c = ((a) aVar2).f4775b;
                } else if (((a) aVar2).c != ((a) aVar2).f4775b) {
                    throw new IllegalStateException("recycled already");
                }
                aVarArr[i] = null;
                if (!cVar.b(aVar2)) {
                    ((a) aVar2).d = cVar;
                    aVarArr2[i3] = aVar2;
                    i3++;
                }
                i++;
            }
            if (iMin == l.i && aVar.c != null) {
                a(l.i);
                this.c = aVar.c;
            }
            aVar.f4781b = iMin;
            if (((c) cVar).h == i3) {
                return false;
            }
            ((c) cVar).h = i3;
            return true;
        }

        protected void finalize() {
            try {
                super.finalize();
            } finally {
                for (a aVar = this.c; aVar != null; aVar = aVar.c) {
                    a(l.i);
                }
            }
        }
    }

    /* compiled from: Recycler.java */
    static final class c<T> {

        /* renamed from: a, reason: collision with root package name */
        final l<T> f4776a;

        /* renamed from: b, reason: collision with root package name */
        final Thread f4777b;
        final AtomicInteger c;
        final int d;
        private final int e;
        private final int f;
        private a<?>[] g;
        private int h;
        private int i = -1;
        private d j;
        private d k;
        private volatile d l;

        c(l<T> lVar, Thread thread, int i, int i2, int i3, int i4) {
            this.f4776a = lVar;
            this.f4777b = thread;
            this.e = i;
            this.c = new AtomicInteger(Math.max(i / i2, l.i));
            this.g = new a[Math.min(l.f, i)];
            this.f = i3;
            this.d = i4;
        }

        int a(int i) {
            int length = this.g.length;
            int i2 = this.e;
            do {
                length <<= 1;
                if (length >= i) {
                    break;
                }
            } while (length < i2);
            int iMin = Math.min(length, i2);
            if (iMin != this.g.length) {
                this.g = (a[]) Arrays.copyOf(this.g, iMin);
            }
            return iMin;
        }

        a<T> a() {
            int i = this.h;
            if (i == 0) {
                if (!b()) {
                    return null;
                }
                i = this.h;
            }
            int i2 = i - 1;
            a<T> aVar = (a<T>) this.g[i2];
            this.g[i2] = null;
            if (((a) aVar).f4775b == ((a) aVar).c) {
                ((a) aVar).c = 0;
                ((a) aVar).f4775b = 0;
                this.h = i2;
                return aVar;
            }
            throw new IllegalStateException("recycled multiple times");
        }

        boolean b() {
            if (c()) {
                return true;
            }
            this.k = null;
            this.j = this.l;
            return false;
        }

        boolean c() {
            d dVar = this.j;
            boolean z = false;
            if (dVar == null && (dVar = this.l) == null) {
                return false;
            }
            d dVar2 = this.k;
            while (!dVar.a((c<?>) this)) {
                d dVar3 = dVar.e;
                if (dVar.f.get() == null) {
                    if (dVar.a()) {
                        while (dVar.a((c<?>) this)) {
                            z = true;
                        }
                    }
                    if (dVar2 != null) {
                        dVar2.e = dVar3;
                    }
                } else {
                    dVar2 = dVar;
                }
                if (dVar3 == null || z) {
                    dVar = dVar3;
                    break;
                }
                dVar = dVar3;
            }
            z = true;
            this.k = dVar2;
            this.j = dVar;
            return z;
        }

        void a(a<?> aVar) {
            Thread threadCurrentThread = Thread.currentThread();
            if (this.f4777b == threadCurrentThread) {
                c(aVar);
            } else {
                a(aVar, threadCurrentThread);
            }
        }

        private void c(a<?> aVar) {
            if ((((a) aVar).c | ((a) aVar).f4775b) == 0) {
                ((a) aVar).c = ((a) aVar).f4775b = l.d;
                int i = this.h;
                if (i >= this.e || b(aVar)) {
                    return;
                }
                if (i == this.g.length) {
                    this.g = (a[]) Arrays.copyOf(this.g, Math.min(i << 1, this.e));
                }
                this.g[i] = aVar;
                this.h = i + 1;
                return;
            }
            throw new IllegalStateException("recycled already");
        }

        private void a(a<?> aVar, Thread thread) {
            Map map = (Map) l.p.d();
            d dVarA = (d) map.get(this);
            if (dVarA == null) {
                if (map.size() >= this.d) {
                    map.put(this, d.f4778a);
                    return;
                }
                dVarA = d.a((c<?>) this, thread);
                if (dVarA == null) {
                    return;
                } else {
                    map.put(this, dVarA);
                }
            } else if (dVarA == d.f4778a) {
                return;
            }
            dVarA.a(aVar);
        }

        boolean b(a<?> aVar) {
            if (aVar.f4774a) {
                return false;
            }
            int i = this.i + 1;
            this.i = i;
            if ((i & this.f) != 0) {
                return true;
            }
            aVar.f4774a = true;
            return false;
        }

        a<T> d() {
            return new a<>(this);
        }
    }
}
