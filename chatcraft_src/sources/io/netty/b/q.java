package io.netty.b;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: PoolArena.java */
/* loaded from: classes.dex */
abstract class q<T> {
    private long A;

    /* renamed from: b, reason: collision with root package name */
    final x f4394b;
    final int c;
    final int d;
    final int e;
    final int f;
    final int g;
    private final int j;
    private final u<T>[] l;
    private final s<T> m;
    private final s<T> n;
    private final s<T> o;
    private final s<T> p;
    private final s<T> q;
    private final s<T> r;
    private final List<t> s;
    private long t;
    private long y;
    private long z;
    static final /* synthetic */ boolean i = !q.class.desiredAssertionStatus();

    /* renamed from: a, reason: collision with root package name */
    static final boolean f4393a = io.netty.util.a.l.f();
    private final io.netty.util.a.f u = io.netty.util.a.l.l();
    private final io.netty.util.a.f v = io.netty.util.a.l.l();
    private final io.netty.util.a.f w = io.netty.util.a.l.l();
    private final io.netty.util.a.f x = io.netty.util.a.l.l();
    private final io.netty.util.a.f B = io.netty.util.a.l.l();
    final AtomicInteger h = new AtomicInteger();
    private final u<T>[] k = j(32);

    /* compiled from: PoolArena.java */
    enum c {
        Tiny,
        Small,
        Normal
    }

    static int a(int i2) {
        return i2 >>> 4;
    }

    static int b(int i2) {
        int i3 = i2 >>> 10;
        int i4 = 0;
        while (i3 != 0) {
            i3 >>>= 1;
            i4++;
        }
        return i4;
    }

    static boolean d(int i2) {
        return (i2 & (-512)) == 0;
    }

    protected abstract r<T> a(int i2, int i3, int i4, int i5);

    protected abstract void a(r<T> rVar);

    protected abstract void a(T t, int i2, T t2, int i3, int i4);

    abstract boolean a();

    protected abstract r<T> g(int i2);

    protected abstract w<T> h(int i2);

    protected q(x xVar, int i2, int i3, int i4, int i5) {
        this.f4394b = xVar;
        this.c = i2;
        this.j = i3;
        this.d = i4;
        this.e = i5;
        this.f = (i2 - 1) ^ (-1);
        for (int i6 = 0; i6 < this.k.length; i6++) {
            this.k[i6] = i(i2);
        }
        this.g = i4 - 9;
        this.l = j(this.g);
        for (int i7 = 0; i7 < this.l.length; i7++) {
            this.l[i7] = i(i2);
        }
        this.r = new s<>(null, 100, Integer.MAX_VALUE, i5);
        this.q = new s<>(this.r, 75, 100, i5);
        this.m = new s<>(this.q, 50, 100, i5);
        this.n = new s<>(this.m, 25, 75, i5);
        this.o = new s<>(this.n, 1, 50, i5);
        this.p = new s<>(this.o, Integer.MIN_VALUE, 25, i5);
        this.r.a(this.q);
        this.q.a(this.m);
        this.m.a(this.n);
        this.n.a(this.o);
        this.o.a((s) null);
        this.p.a(this.p);
        ArrayList arrayList = new ArrayList(6);
        arrayList.add(this.p);
        arrayList.add(this.o);
        arrayList.add(this.n);
        arrayList.add(this.m);
        arrayList.add(this.q);
        arrayList.add(this.r);
        this.s = Collections.unmodifiableList(arrayList);
    }

    private u<T> i(int i2) {
        u<T> uVar = new u<>(i2);
        uVar.f4403b = uVar;
        uVar.c = uVar;
        return uVar;
    }

    private u<T>[] j(int i2) {
        return new u[i2];
    }

    w<T> a(v vVar, int i2, int i3) {
        w<T> wVarH = h(i3);
        a(vVar, wVarH, i2);
        return wVarH;
    }

    boolean c(int i2) {
        return (i2 & this.f) == 0;
    }

    private void a(v vVar, w<T> wVar, int i2) {
        int iB;
        u<T>[] uVarArr;
        int iF = f(i2);
        if (c(iF)) {
            boolean zD = d(iF);
            if (zD) {
                if (vVar.a(this, wVar, i2, iF)) {
                    return;
                }
                iB = a(iF);
                uVarArr = this.k;
            } else {
                if (vVar.b(this, wVar, i2, iF)) {
                    return;
                }
                iB = b(iF);
                uVarArr = this.l;
            }
            u<T> uVar = uVarArr[iB];
            synchronized (uVar) {
                u<T> uVar2 = uVar.c;
                if (uVar2 != uVar) {
                    if (!i && (!uVar2.d || uVar2.e != iF)) {
                        throw new AssertionError();
                    }
                    long jA = uVar2.a();
                    if (!i && jA < 0) {
                        throw new AssertionError();
                    }
                    uVar2.f4402a.b(wVar, jA, i2);
                    if (zD) {
                        this.u.a();
                    } else {
                        this.v.a();
                    }
                    return;
                }
                a(wVar, i2, iF);
                return;
            }
        }
        if (iF <= this.e) {
            if (vVar.c(this, wVar, i2, iF)) {
                return;
            }
            a(wVar, i2, iF);
            return;
        }
        a(wVar, i2);
    }

    private synchronized void a(w<T> wVar, int i2, int i3) {
        if (!this.m.a(wVar, i2, i3) && !this.n.a(wVar, i2, i3) && !this.o.a(wVar, i2, i3) && !this.p.a(wVar, i2, i3) && !this.q.a(wVar, i2, i3)) {
            r<T> rVarA = a(this.c, this.j, this.d, this.e);
            long jA = rVarA.a(i3);
            this.t++;
            if (!i && jA <= 0) {
                throw new AssertionError();
            }
            rVarA.a(wVar, jA, i2);
            this.p.a(rVarA);
            return;
        }
        this.t++;
    }

    private void a(w<T> wVar, int i2) {
        r<T> rVarG = g(i2);
        this.x.a(rVarG.b());
        wVar.a(rVarG, i2);
        this.w.a();
    }

    void a(r<T> rVar, long j, int i2, v vVar) {
        if (rVar.c) {
            int iB = rVar.b();
            a(rVar);
            this.x.a(-iB);
            this.B.a();
            return;
        }
        c cVarK = k(i2);
        if (vVar == null || !vVar.a(this, rVar, j, i2, cVarK)) {
            a(rVar, j, cVarK);
        }
    }

    private c k(int i2) {
        if (c(i2)) {
            return d(i2) ? c.Tiny : c.Small;
        }
        return c.Normal;
    }

    void a(r<T> rVar, long j, c cVar) {
        boolean z;
        synchronized (this) {
            switch (cVar) {
                case Normal:
                    this.A++;
                    break;
                case Small:
                    this.z++;
                    break;
                case Tiny:
                    this.y++;
                    break;
                default:
                    throw new Error();
            }
            z = !rVar.d.a(rVar, j);
        }
        if (z) {
            a(rVar);
        }
    }

    u<T> e(int i2) {
        int i3;
        u<T>[] uVarArr;
        if (d(i2)) {
            i3 = i2 >>> 4;
            uVarArr = this.k;
        } else {
            i3 = 0;
            int i4 = i2 >>> 10;
            while (i4 != 0) {
                i4 >>>= 1;
                i3++;
            }
            uVarArr = this.l;
        }
        return uVarArr[i3];
    }

    int f(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("capacity: " + i2 + " (expected: 0+)");
        }
        if (i2 >= this.e) {
            return i2;
        }
        if (d(i2)) {
            return (i2 & 15) == 0 ? i2 : (i2 & (-16)) + 16;
        }
        int i3 = i2 - 1;
        int i4 = i3 | (i3 >>> 1);
        int i5 = i4 | (i4 >>> 2);
        int i6 = i5 | (i5 >>> 4);
        int i7 = i6 | (i6 >>> 8);
        int i8 = (i7 | (i7 >>> 16)) + 1;
        return i8 < 0 ? i8 >>> 1 : i8;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void a(io.netty.b.w<T> r13, int r14, boolean r15) {
        /*
            r12 = this;
            if (r14 < 0) goto L60
            int r0 = r13.a()
            if (r14 > r0) goto L60
            int r6 = r13.h
            if (r6 != r14) goto Ld
            return
        Ld:
            io.netty.b.r<T> r7 = r13.d
            long r8 = r13.e
            T r2 = r13.f
            int r3 = r13.g
            int r10 = r13.i
            int r11 = r13.b()
            int r0 = r13.c()
            io.netty.b.x r1 = r12.f4394b
            io.netty.b.v r1 = r1.d()
            r12.a(r1, r13, r14)
            if (r14 <= r6) goto L33
            T r4 = r13.f
            int r5 = r13.g
            r1 = r12
            r1.a(r2, r3, r4, r5, r6)
            goto L50
        L33:
            if (r14 >= r6) goto L50
            if (r11 >= r14) goto L4e
            if (r0 <= r14) goto L3a
            goto L3b
        L3a:
            r14 = r0
        L3b:
            int r3 = r3 + r11
            T r4 = r13.f
            int r0 = r13.g
            int r5 = r0 + r11
            int r6 = r14 - r11
            r0 = r12
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r0.a(r1, r2, r3, r4, r5)
            goto L51
        L4e:
            r11 = r14
            goto L51
        L50:
            r14 = r0
        L51:
            r13.a(r11, r14)
            if (r15 == 0) goto L5f
            io.netty.b.v r5 = r13.j
            r0 = r12
            r1 = r7
            r2 = r8
            r4 = r10
            r0.a(r1, r2, r4, r5)
        L5f:
            return
        L60:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r0 = "newCapacity: "
            r15.append(r0)
            r15.append(r14)
            java.lang.String r14 = r15.toString()
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.b.q.a(io.netty.b.w, int, boolean):void");
    }

    public synchronized String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("Chunk(s) at 0~25%:");
        sb.append(io.netty.util.a.p.f4696a);
        sb.append(this.p);
        sb.append(io.netty.util.a.p.f4696a);
        sb.append("Chunk(s) at 0~50%:");
        sb.append(io.netty.util.a.p.f4696a);
        sb.append(this.o);
        sb.append(io.netty.util.a.p.f4696a);
        sb.append("Chunk(s) at 25~75%:");
        sb.append(io.netty.util.a.p.f4696a);
        sb.append(this.n);
        sb.append(io.netty.util.a.p.f4696a);
        sb.append("Chunk(s) at 50~100%:");
        sb.append(io.netty.util.a.p.f4696a);
        sb.append(this.m);
        sb.append(io.netty.util.a.p.f4696a);
        sb.append("Chunk(s) at 75~100%:");
        sb.append(io.netty.util.a.p.f4696a);
        sb.append(this.q);
        sb.append(io.netty.util.a.p.f4696a);
        sb.append("Chunk(s) at 100%:");
        sb.append(io.netty.util.a.p.f4696a);
        sb.append(this.r);
        sb.append(io.netty.util.a.p.f4696a);
        sb.append("tiny subpages:");
        a(sb, (u<?>[]) this.k);
        sb.append(io.netty.util.a.p.f4696a);
        sb.append("small subpages:");
        a(sb, (u<?>[]) this.l);
        sb.append(io.netty.util.a.p.f4696a);
        return sb.toString();
    }

    private static void a(StringBuilder sb, u<?>[] uVarArr) {
        for (int i2 = 0; i2 < uVarArr.length; i2++) {
            u<?> uVar = uVarArr[i2];
            if (uVar.c != uVar) {
                sb.append(io.netty.util.a.p.f4696a);
                sb.append(i2);
                sb.append(": ");
                u uVar2 = uVar.c;
                do {
                    sb.append(uVar2);
                    uVar2 = uVar2.c;
                } while (uVar2 != uVar);
            }
        }
    }

    protected final void finalize() {
        try {
            super.finalize();
            a((u<?>[]) this.l);
            a((u<?>[]) this.k);
            a(this.p, this.o, this.n, this.m, this.q, this.r);
        } catch (Throwable th) {
            a((u<?>[]) this.l);
            a((u<?>[]) this.k);
            a(this.p, this.o, this.n, this.m, this.q, this.r);
            throw th;
        }
    }

    private static void a(u<?>[] uVarArr) {
        for (u<?> uVar : uVarArr) {
            uVar.b();
        }
    }

    private void a(s<T>... sVarArr) {
        for (s<T> sVar : sVarArr) {
            sVar.a(this);
        }
    }

    /* compiled from: PoolArena.java */
    static final class b extends q<byte[]> {
        @Override // io.netty.b.q
        protected void a(r<byte[]> rVar) {
        }

        @Override // io.netty.b.q
        boolean a() {
            return false;
        }

        b(x xVar, int i, int i2, int i3, int i4) {
            super(xVar, i, i2, i3, i4);
        }

        @Override // io.netty.b.q
        protected r<byte[]> a(int i, int i2, int i3, int i4) {
            return new r<>(this, new byte[i4], i, i2, i3, i4);
        }

        @Override // io.netty.b.q
        protected r<byte[]> g(int i) {
            return new r<>(this, new byte[i], i);
        }

        @Override // io.netty.b.q
        protected w<byte[]> h(int i) {
            return f4393a ? ab.G(i) : z.F(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.b.q
        public void a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
            if (i3 == 0) {
                return;
            }
            System.arraycopy(bArr, i, bArr2, i2, i3);
        }
    }

    /* compiled from: PoolArena.java */
    static final class a extends q<ByteBuffer> {
        @Override // io.netty.b.q
        boolean a() {
            return true;
        }

        a(x xVar, int i, int i2, int i3, int i4) {
            super(xVar, i, i2, i3, i4);
        }

        @Override // io.netty.b.q
        protected r<ByteBuffer> a(int i, int i2, int i3, int i4) {
            return new r<>(this, i(i4), i, i2, i3, i4);
        }

        @Override // io.netty.b.q
        protected r<ByteBuffer> g(int i) {
            return new r<>(this, i(i), i);
        }

        private static ByteBuffer i(int i) {
            return io.netty.util.a.l.m() ? io.netty.util.a.l.a(i) : ByteBuffer.allocateDirect(i);
        }

        @Override // io.netty.b.q
        protected void a(r<ByteBuffer> rVar) {
            if (io.netty.util.a.l.m()) {
                io.netty.util.a.l.c(rVar.f4399b);
            } else {
                io.netty.util.a.l.a(rVar.f4399b);
            }
        }

        @Override // io.netty.b.q
        protected w<ByteBuffer> h(int i) {
            if (f4393a) {
                return aa.F(i);
            }
            return y.F(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.b.q
        public void a(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, int i3) {
            if (i3 == 0) {
                return;
            }
            if (f4393a) {
                io.netty.util.a.l.a(io.netty.util.a.l.b(byteBuffer) + i, io.netty.util.a.l.b(byteBuffer2) + i2, i3);
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            ByteBuffer byteBufferDuplicate2 = byteBuffer2.duplicate();
            byteBufferDuplicate.position(i).limit(i + i3);
            byteBufferDuplicate2.position(i2);
            byteBufferDuplicate2.put(byteBufferDuplicate);
        }
    }
}
