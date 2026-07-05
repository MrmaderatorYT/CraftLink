package io.netty.channel;

import io.netty.util.l;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* compiled from: ChannelOutboundBuffer.java */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f4556a = !s.class.desiredAssertionStatus();

    /* renamed from: b, reason: collision with root package name */
    private static final io.netty.util.a.b.c f4557b = io.netty.util.a.b.d.a((Class<?>) s.class);
    private static final io.netty.util.concurrent.n<ByteBuffer[]> c = new io.netty.util.concurrent.n<ByteBuffer[]>() { // from class: io.netty.channel.s.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.n
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ByteBuffer[] b() {
            return new ByteBuffer[1024];
        }
    };
    private static final AtomicLongFieldUpdater<s> l;
    private static final AtomicIntegerFieldUpdater<s> n;
    private final d d;
    private a e;
    private a f;
    private a g;
    private int h;
    private int i;
    private long j;
    private boolean k;
    private volatile long m;
    private volatile int o;
    private volatile Runnable p;

    static {
        AtomicIntegerFieldUpdater<s> atomicIntegerFieldUpdaterB = io.netty.util.a.l.b(s.class, "unwritable");
        if (atomicIntegerFieldUpdaterB == null) {
            atomicIntegerFieldUpdaterB = AtomicIntegerFieldUpdater.newUpdater(s.class, "o");
        }
        n = atomicIntegerFieldUpdaterB;
        AtomicLongFieldUpdater<s> atomicLongFieldUpdaterC = io.netty.util.a.l.c(s.class, "totalPendingSize");
        if (atomicLongFieldUpdaterC == null) {
            atomicLongFieldUpdaterC = AtomicLongFieldUpdater.newUpdater(s.class, "m");
        }
        l = atomicLongFieldUpdaterC;
    }

    s(io.netty.channel.a aVar) {
        this.d = aVar;
    }

    public void a(Object obj, int i, z zVar) {
        a aVarA = a.a(obj, i, a(obj), zVar);
        if (this.g == null) {
            this.e = null;
            this.g = aVarA;
        } else {
            this.g.f4562a = aVarA;
            this.g = aVarA;
        }
        if (this.f == null) {
            this.f = aVarA;
        }
        a(i, false);
    }

    public void a() {
        a aVar = this.f;
        if (aVar != null) {
            if (this.e == null) {
                this.e = aVar;
            }
            do {
                this.h++;
                if (!aVar.e.z_()) {
                    a(aVar.a(), false, true);
                }
                aVar = aVar.f4562a;
            } while (aVar != null);
            this.f = null;
        }
    }

    void a(long j) {
        a(j, true);
    }

    private void a(long j, boolean z) {
        if (j != 0 && l.addAndGet(this, j) > this.d.D().g()) {
            b(z);
        }
    }

    void b(long j) {
        a(j, true, true);
    }

    private void a(long j, boolean z, boolean z2) {
        if (j == 0) {
            return;
        }
        long jAddAndGet = l.addAndGet(this, -j);
        if (!z2 || jAddAndGet >= this.d.D().h()) {
            return;
        }
        a(z);
    }

    private static long a(Object obj) {
        if (obj instanceof io.netty.b.i) {
            return ((io.netty.b.i) obj).g();
        }
        if (obj instanceof an) {
            return ((an) obj).b();
        }
        if (obj instanceof io.netty.b.k) {
            return ((io.netty.b.k) obj).a().g();
        }
        return -1L;
    }

    public Object b() {
        a aVar = this.e;
        if (aVar == null) {
            return null;
        }
        return aVar.f4563b;
    }

    public void c(long j) {
        a aVar = this.e;
        if (!f4556a && aVar == null) {
            throw new AssertionError();
        }
        z zVar = aVar.e;
        if (zVar instanceof y) {
            long j2 = aVar.f + j;
            aVar.f = j2;
            ((y) zVar).a(j2, aVar.g);
        }
    }

    public boolean c() {
        a aVar = this.e;
        if (aVar == null) {
            i();
            return false;
        }
        Object obj = aVar.f4563b;
        z zVar = aVar.e;
        int i = aVar.h;
        a(aVar);
        if (!aVar.j) {
            io.netty.util.m.b(obj);
            a(zVar);
            a(i, false, true);
        }
        aVar.b();
        return true;
    }

    public boolean a(Throwable th) {
        return b(th, true);
    }

    private boolean b(Throwable th, boolean z) {
        a aVar = this.e;
        if (aVar == null) {
            i();
            return false;
        }
        Object obj = aVar.f4563b;
        z zVar = aVar.e;
        int i = aVar.h;
        a(aVar);
        if (!aVar.j) {
            io.netty.util.m.b(obj);
            a(zVar, th);
            a(i, false, z);
        }
        aVar.b();
        return true;
    }

    private void a(a aVar) {
        int i = this.h - 1;
        this.h = i;
        if (i == 0) {
            this.e = null;
            if (aVar == this.g) {
                this.g = null;
                this.f = null;
                return;
            }
            return;
        }
        this.e = aVar.f4562a;
    }

    public void d(long j) {
        while (true) {
            Object objB = b();
            if (!(objB instanceof io.netty.b.i)) {
                if (!f4556a && j != 0) {
                    throw new AssertionError();
                }
            } else {
                io.netty.b.i iVar = (io.netty.b.i) objB;
                int iB = iVar.b();
                long jC = iVar.c() - iB;
                if (jC <= j) {
                    if (j != 0) {
                        c(jC);
                        j -= jC;
                    }
                    c();
                } else if (j != 0) {
                    iVar.b(iB + ((int) j));
                    c(j);
                }
            }
        }
        i();
    }

    private void i() {
        int i = this.i;
        if (i > 0) {
            this.i = 0;
            Arrays.fill(c.d(), 0, i, (Object) null);
        }
    }

    public ByteBuffer[] d() throws Throwable {
        io.netty.b.i iVar;
        int iB;
        int iC;
        io.netty.util.a.d dVarB = io.netty.util.a.d.b();
        ByteBuffer[] byteBufferArrA = c.a(dVarB);
        long j = 0;
        int iA = 0;
        for (a aVar = this.e; b(aVar) && (aVar.f4563b instanceof io.netty.b.i); aVar = aVar.f4562a) {
            if (!aVar.j && (iC = iVar.c() - (iB = (iVar = (io.netty.b.i) aVar.f4563b).b())) > 0) {
                if (Integer.MAX_VALUE - iC < j) {
                    break;
                }
                j += iC;
                int iN = aVar.i;
                if (iN == -1) {
                    iN = iVar.N();
                    aVar.i = iN;
                }
                int i = iA + iN;
                if (i > byteBufferArrA.length) {
                    byteBufferArrA = a(byteBufferArrA, i, iA);
                    c.a(dVarB, (io.netty.util.a.d) byteBufferArrA);
                }
                if (iN == 1) {
                    ByteBuffer byteBufferL = aVar.d;
                    if (byteBufferL == null) {
                        byteBufferL = iVar.l(iB, iC);
                        aVar.d = byteBufferL;
                    }
                    byteBufferArrA[iA] = byteBufferL;
                    iA++;
                } else {
                    ByteBuffer[] byteBufferArrZ = aVar.c;
                    if (byteBufferArrZ == null) {
                        byteBufferArrZ = iVar.z();
                        aVar.c = byteBufferArrZ;
                    }
                    iA = a(byteBufferArrZ, byteBufferArrA, iA);
                }
            }
        }
        this.i = iA;
        this.j = j;
        return byteBufferArrA;
    }

    private static int a(ByteBuffer[] byteBufferArr, ByteBuffer[] byteBufferArr2, int i) {
        int length = byteBufferArr.length;
        int i2 = 0;
        while (i2 < length) {
            ByteBuffer byteBuffer = byteBufferArr[i2];
            if (byteBuffer == null) {
                break;
            }
            byteBufferArr2[i] = byteBuffer;
            i2++;
            i++;
        }
        return i;
    }

    private static ByteBuffer[] a(ByteBuffer[] byteBufferArr, int i, int i2) {
        int length = byteBufferArr.length;
        do {
            length <<= 1;
            if (length < 0) {
                throw new IllegalStateException();
            }
        } while (i > length);
        ByteBuffer[] byteBufferArr2 = new ByteBuffer[length];
        System.arraycopy(byteBufferArr, 0, byteBufferArr2, 0, i2);
        return byteBufferArr2;
    }

    public int e() {
        return this.i;
    }

    public long f() {
        return this.j;
    }

    private void a(boolean z) {
        int i;
        int i2;
        do {
            i = this.o;
            i2 = i & (-2);
        } while (!n.compareAndSet(this, i, i2));
        if (i == 0 || i2 != 0) {
            return;
        }
        c(z);
    }

    private void b(boolean z) {
        int i;
        int i2;
        do {
            i = this.o;
            i2 = i | 1;
        } while (!n.compareAndSet(this, i, i2));
        if (i != 0 || i2 == 0) {
            return;
        }
        c(z);
    }

    private void c(boolean z) {
        final w wVarD = this.d.d();
        if (z) {
            Runnable runnable = this.p;
            if (runnable == null) {
                runnable = new Runnable() { // from class: io.netty.channel.s.2
                    @Override // java.lang.Runnable
                    public void run() {
                        wVarD.d();
                    }
                };
                this.p = runnable;
            }
            this.d.f().execute(runnable);
            return;
        }
        wVarD.d();
    }

    public int g() {
        return this.h;
    }

    public boolean h() {
        return this.h == 0;
    }

    void a(Throwable th, boolean z) {
        if (this.k) {
            return;
        }
        try {
            this.k = true;
            do {
            } while (b(th, z));
        } finally {
            this.k = false;
        }
    }

    void a(final ClosedChannelException closedChannelException) {
        if (this.k) {
            this.d.f().execute(new Runnable() { // from class: io.netty.channel.s.3
                @Override // java.lang.Runnable
                public void run() {
                    s.this.a(closedChannelException);
                }
            });
            return;
        }
        this.k = true;
        if (this.d.E()) {
            throw new IllegalStateException("close() must be invoked after the channel is closed.");
        }
        if (!h()) {
            throw new IllegalStateException("close() must be invoked after all flushed writes are handled.");
        }
        try {
            for (a aVarC = this.f; aVarC != null; aVarC = aVarC.c()) {
                l.addAndGet(this, -aVarC.h);
                if (!aVarC.j) {
                    io.netty.util.m.b(aVarC.f4563b);
                    a(aVarC.e, closedChannelException);
                }
            }
            this.k = false;
            i();
        } catch (Throwable th) {
            this.k = false;
            throw th;
        }
    }

    private static void a(z zVar) {
        if (zVar instanceof bb) {
            return;
        }
        io.netty.util.a.n.a(zVar, (Object) null, f4557b);
    }

    private static void a(z zVar, Throwable th) {
        if (zVar instanceof bb) {
            return;
        }
        io.netty.util.a.n.a((io.netty.util.concurrent.y<?>) zVar, th, f4557b);
    }

    private boolean b(a aVar) {
        return (aVar == null || aVar == this.f) ? false : true;
    }

    /* compiled from: ChannelOutboundBuffer.java */
    static final class a {
        private static final io.netty.util.l<a> k = new io.netty.util.l<a>() { // from class: io.netty.channel.s.a.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a b(l.b bVar) {
                return new a(bVar);
            }
        };

        /* renamed from: a, reason: collision with root package name */
        a f4562a;

        /* renamed from: b, reason: collision with root package name */
        Object f4563b;
        ByteBuffer[] c;
        ByteBuffer d;
        z e;
        long f;
        long g;
        int h;
        int i;
        boolean j;
        private final l.b<a> l;

        private a(l.b<a> bVar) {
            this.i = -1;
            this.l = bVar;
        }

        static a a(Object obj, int i, long j, z zVar) {
            a aVarA = k.a();
            aVarA.f4563b = obj;
            aVarA.h = i;
            aVarA.g = j;
            aVarA.e = zVar;
            return aVarA;
        }

        int a() {
            if (this.j) {
                return 0;
            }
            this.j = true;
            int i = this.h;
            io.netty.util.m.b(this.f4563b);
            this.f4563b = io.netty.b.af.c;
            this.h = 0;
            this.g = 0L;
            this.f = 0L;
            this.c = null;
            this.d = null;
            return i;
        }

        void b() {
            this.f4562a = null;
            this.c = null;
            this.d = null;
            this.f4563b = null;
            this.e = null;
            this.f = 0L;
            this.g = 0L;
            this.h = 0;
            this.i = -1;
            this.j = false;
            this.l.a(this);
        }

        a c() {
            a aVar = this.f4562a;
            b();
            return aVar;
        }
    }
}
