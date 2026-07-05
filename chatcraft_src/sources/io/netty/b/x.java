package io.netty.b;

import io.netty.b.q;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: PooledByteBufAllocator.java */
/* loaded from: classes.dex */
public class x extends b {

    /* renamed from: b, reason: collision with root package name */
    public static final x f4412b;
    private static final io.netty.util.a.b.c c = io.netty.util.a.b.d.a((Class<?>) x.class);
    private static final int d;
    private static final int e;
    private static final int f;
    private static final int g;
    private static final int h;
    private static final int i;
    private static final int j;
    private static final int k;
    private static final int l;
    private final q<byte[]>[] m;
    private final q<ByteBuffer>[] n;
    private final int o;
    private final int p;
    private final int q;
    private final List<Object> r;
    private final List<Object> s;
    private final a t;

    static {
        Throwable th;
        int iA = io.netty.util.a.q.a("io.netty.allocator.pageSize", 8192);
        Throwable th2 = null;
        try {
            i(iA);
            th = null;
        } catch (Throwable th3) {
            th = th3;
            iA = 8192;
        }
        f = iA;
        int iA2 = io.netty.util.a.q.a("io.netty.allocator.maxOrder", 11);
        try {
            g(f, iA2);
        } catch (Throwable th4) {
            th2 = th4;
            iA2 = 11;
        }
        g = iA2;
        Runtime runtime = Runtime.getRuntime();
        long jAvailableProcessors = runtime.availableProcessors() * 2;
        long j2 = f << g;
        d = Math.max(0, io.netty.util.a.q.a("io.netty.allocator.numHeapArenas", (int) Math.min(jAvailableProcessors, ((runtime.maxMemory() / j2) / 2) / 3)));
        e = Math.max(0, io.netty.util.a.q.a("io.netty.allocator.numDirectArenas", (int) Math.min(jAvailableProcessors, ((io.netty.util.a.l.i() / j2) / 2) / 3)));
        h = io.netty.util.a.q.a("io.netty.allocator.tinyCacheSize", 512);
        i = io.netty.util.a.q.a("io.netty.allocator.smallCacheSize", 256);
        j = io.netty.util.a.q.a("io.netty.allocator.normalCacheSize", 64);
        k = io.netty.util.a.q.a("io.netty.allocator.maxCachedBufferCapacity", 32768);
        l = io.netty.util.a.q.a("io.netty.allocator.cacheTrimInterval", 8192);
        if (c.b()) {
            c.b("-Dio.netty.allocator.numHeapArenas: {}", Integer.valueOf(d));
            c.b("-Dio.netty.allocator.numDirectArenas: {}", Integer.valueOf(e));
            if (th == null) {
                c.b("-Dio.netty.allocator.pageSize: {}", Integer.valueOf(f));
            } else {
                c.b("-Dio.netty.allocator.pageSize: {}", Integer.valueOf(f), th);
            }
            if (th2 == null) {
                c.b("-Dio.netty.allocator.maxOrder: {}", Integer.valueOf(g));
            } else {
                c.b("-Dio.netty.allocator.maxOrder: {}", Integer.valueOf(g), th2);
            }
            c.b("-Dio.netty.allocator.chunkSize: {}", Integer.valueOf(f << g));
            c.b("-Dio.netty.allocator.tinyCacheSize: {}", Integer.valueOf(h));
            c.b("-Dio.netty.allocator.smallCacheSize: {}", Integer.valueOf(i));
            c.b("-Dio.netty.allocator.normalCacheSize: {}", Integer.valueOf(j));
            c.b("-Dio.netty.allocator.maxCachedBufferCapacity: {}", Integer.valueOf(k));
            c.b("-Dio.netty.allocator.cacheTrimInterval: {}", Integer.valueOf(l));
        }
        f4412b = new x(io.netty.util.a.l.h());
    }

    public x() {
        this(false);
    }

    public x(boolean z) {
        this(z, d, e, f, g);
    }

    public x(boolean z, int i2, int i3, int i4, int i5) {
        this(z, i2, i3, i4, i5, h, i, j);
    }

    public x(boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        super(z);
        this.t = new a();
        this.o = i6;
        this.p = i7;
        this.q = i8;
        int iG = g(i4, i5);
        if (i2 < 0) {
            throw new IllegalArgumentException("nHeapArena: " + i2 + " (expected: >= 0)");
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("nDirectArea: " + i3 + " (expected: >= 0)");
        }
        int i9 = i(i4);
        if (i2 > 0) {
            this.m = h(i2);
            ArrayList arrayList = new ArrayList(this.m.length);
            for (int i10 = 0; i10 < this.m.length; i10++) {
                q.b bVar = new q.b(this, i4, i5, i9, iG);
                this.m[i10] = bVar;
                arrayList.add(bVar);
            }
            this.r = Collections.unmodifiableList(arrayList);
        } else {
            this.m = null;
            this.r = Collections.emptyList();
        }
        if (i3 > 0) {
            this.n = h(i3);
            ArrayList arrayList2 = new ArrayList(this.n.length);
            for (int i11 = 0; i11 < this.n.length; i11++) {
                q.a aVar = new q.a(this, i4, i5, i9, iG);
                this.n[i11] = aVar;
                arrayList2.add(aVar);
            }
            this.s = Collections.unmodifiableList(arrayList2);
            return;
        }
        this.n = null;
        this.s = Collections.emptyList();
    }

    private static <T> q<T>[] h(int i2) {
        return new q[i2];
    }

    private static int i(int i2) {
        if (i2 >= 4096) {
            if (((i2 - 1) & i2) != 0) {
                throw new IllegalArgumentException("pageSize: " + i2 + " (expected: power of 2)");
            }
            return 31 - Integer.numberOfLeadingZeros(i2);
        }
        throw new IllegalArgumentException("pageSize: " + i2 + " (expected: 4096)");
    }

    private static int g(int i2, int i3) {
        if (i3 > 14) {
            throw new IllegalArgumentException("maxOrder: " + i3 + " (expected: 0-14)");
        }
        int i4 = i2;
        for (int i5 = i3; i5 > 0; i5--) {
            if (i4 > 536870912) {
                throw new IllegalArgumentException(String.format("pageSize (%d) << maxOrder (%d) must not exceed %d", Integer.valueOf(i2), Integer.valueOf(i3), 1073741824));
            }
            i4 <<= 1;
        }
        return i4;
    }

    @Override // io.netty.b.b
    protected i d(int i2, int i3) {
        i aiVar;
        v vVarD = this.t.d();
        q<byte[]> qVar = vVarD.f4404a;
        if (qVar != null) {
            aiVar = qVar.a(vVarD, i2, i3);
        } else {
            aiVar = new ai(this, i2, i3);
        }
        return a(aiVar);
    }

    @Override // io.netty.b.b
    protected i e(int i2, int i3) {
        i ahVar;
        v vVarD = this.t.d();
        q<ByteBuffer> qVar = vVarD.f4405b;
        if (qVar != null) {
            ahVar = qVar.a(vVarD, i2, i3);
        } else if (io.netty.util.a.l.f()) {
            ahVar = an.a(this, i2, i3);
        } else {
            ahVar = new ah(this, i2, i3);
        }
        return a(ahVar);
    }

    @Override // io.netty.b.j
    public boolean c() {
        return this.n != null;
    }

    /* compiled from: PooledByteBufAllocator.java */
    final class a extends io.netty.util.concurrent.n<v> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.n
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public synchronized v b() {
            return new v(a(x.this.m), a(x.this.n), x.this.o, x.this.p, x.this.q, x.k, x.l);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.n
        public void a(v vVar) {
            vVar.a();
        }

        private <T> q<T> a(q<T>[] qVarArr) {
            if (qVarArr == null || qVarArr.length == 0) {
                return null;
            }
            q<T> qVar = qVarArr[0];
            for (int i = 1; i < qVarArr.length; i++) {
                q<T> qVar2 = qVarArr[i];
                if (qVar2.h.get() < qVar.h.get()) {
                    qVar = qVar2;
                }
            }
            return qVar;
        }
    }

    final v d() {
        return this.t.d();
    }
}
