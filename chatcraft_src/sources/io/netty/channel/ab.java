package io.netty.channel;

import java.util.Map;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: DefaultChannelConfig.java */
/* loaded from: classes.dex */
public class ab implements e {

    /* renamed from: b, reason: collision with root package name */
    private static final ap f4450b = ah.f4477a;
    private static final AtomicIntegerFieldUpdater<ab> c;
    private static final AtomicReferenceFieldUpdater<ab, bc> d;

    /* renamed from: a, reason: collision with root package name */
    protected final d f4451a;
    private volatile io.netty.b.j e;
    private volatile ar f;
    private volatile ap g;
    private volatile int h;
    private volatile int i;
    private volatile int j;
    private volatile boolean k;
    private volatile bc l;
    private volatile boolean m;

    protected void k() {
    }

    static {
        AtomicIntegerFieldUpdater<ab> atomicIntegerFieldUpdaterB = io.netty.util.a.l.b(ab.class, "autoRead");
        if (atomicIntegerFieldUpdaterB == null) {
            atomicIntegerFieldUpdaterB = AtomicIntegerFieldUpdater.newUpdater(ab.class, "j");
        }
        c = atomicIntegerFieldUpdaterB;
        AtomicReferenceFieldUpdater<ab, bc> atomicReferenceFieldUpdaterA = io.netty.util.a.l.a(ab.class, "writeBufferWaterMark");
        if (atomicReferenceFieldUpdaterA == null) {
            atomicReferenceFieldUpdaterA = AtomicReferenceFieldUpdater.newUpdater(ab.class, bc.class, "l");
        }
        d = atomicReferenceFieldUpdaterA;
    }

    public ab(d dVar) {
        this(dVar, new c());
    }

    protected ab(d dVar, ar arVar) {
        this.e = io.netty.b.j.f4382a;
        this.g = f4450b;
        this.h = 30000;
        this.i = 16;
        this.j = 1;
        this.k = true;
        this.l = bc.f4534a;
        this.m = true;
        a(arVar, dVar.G());
        this.f4451a = dVar;
    }

    @Override // io.netty.channel.e
    public boolean a(Map<r<?>, ?> map) {
        if (map == null) {
            throw new NullPointerException("options");
        }
        boolean z = true;
        for (Map.Entry<r<?>, ?> entry : map.entrySet()) {
            if (!a((r<r<?>>) entry.getKey(), (r<?>) entry.getValue())) {
                z = false;
            }
        }
        return z;
    }

    @Override // io.netty.channel.e
    public <T> T a(r<T> rVar) {
        if (rVar == null) {
            throw new NullPointerException("option");
        }
        if (rVar == r.d) {
            return (T) Integer.valueOf(a());
        }
        if (rVar == r.e) {
            return (T) Integer.valueOf(j());
        }
        if (rVar == r.f) {
            return (T) Integer.valueOf(b());
        }
        if (rVar == r.f4554a) {
            return (T) c();
        }
        if (rVar == r.f4555b) {
            return (T) d();
        }
        if (rVar == r.k) {
            return (T) Boolean.valueOf(e());
        }
        if (rVar == r.l) {
            return (T) Boolean.valueOf(f());
        }
        if (rVar == r.g) {
            return (T) Integer.valueOf(g());
        }
        if (rVar == r.h) {
            return (T) Integer.valueOf(h());
        }
        if (rVar == r.i) {
            return (T) l();
        }
        if (rVar == r.c) {
            return (T) i();
        }
        if (rVar == r.B) {
            return (T) Boolean.valueOf(m());
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.e
    public <T> boolean a(r<T> rVar, T t) {
        b(rVar, t);
        if (rVar == r.d) {
            j(((Integer) t).intValue());
            return true;
        }
        if (rVar == r.e) {
            k(((Integer) t).intValue());
            return true;
        }
        if (rVar == r.f) {
            l(((Integer) t).intValue());
            return true;
        }
        if (rVar == r.f4554a) {
            b((io.netty.b.j) t);
            return true;
        }
        if (rVar == r.f4555b) {
            b((ar) t);
            return true;
        }
        if (rVar == r.k) {
            g(((Boolean) t).booleanValue());
            return true;
        }
        if (rVar == r.l) {
            h(((Boolean) t).booleanValue());
            return true;
        }
        if (rVar == r.g) {
            m(((Integer) t).intValue());
            return true;
        }
        if (rVar == r.h) {
            n(((Integer) t).intValue());
            return true;
        }
        if (rVar == r.i) {
            b((bc) t);
            return true;
        }
        if (rVar == r.c) {
            b((ap) t);
            return true;
        }
        if (rVar != r.B) {
            return false;
        }
        c(((Boolean) t).booleanValue());
        return true;
    }

    protected <T> void b(r<T> rVar, T t) {
        if (rVar == null) {
            throw new NullPointerException("option");
        }
        rVar.a((r<T>) t);
    }

    @Override // io.netty.channel.e
    public int a() {
        return this.h;
    }

    /* renamed from: a */
    public e j(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(String.format("connectTimeoutMillis: %d (expected: >= 0)", Integer.valueOf(i)));
        }
        this.h = i;
        return this;
    }

    @Deprecated
    public int j() {
        try {
            return ((ao) d()).c();
        } catch (ClassCastException e) {
            throw new IllegalStateException("getRecvByteBufAllocator() must return an object of type MaxMessagesRecvByteBufAllocator", e);
        }
    }

    @Deprecated
    /* renamed from: b */
    public e k(int i) {
        try {
            ((ao) d()).b(i);
            return this;
        } catch (ClassCastException e) {
            throw new IllegalStateException("getRecvByteBufAllocator() must return an object of type MaxMessagesRecvByteBufAllocator", e);
        }
    }

    @Override // io.netty.channel.e
    public int b() {
        return this.i;
    }

    /* renamed from: c */
    public e l(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("writeSpinCount must be a positive integer.");
        }
        this.i = i;
        return this;
    }

    @Override // io.netty.channel.e
    public io.netty.b.j c() {
        return this.e;
    }

    /* renamed from: a */
    public e b(io.netty.b.j jVar) {
        if (jVar == null) {
            throw new NullPointerException("allocator");
        }
        this.e = jVar;
        return this;
    }

    @Override // io.netty.channel.e
    public <T extends ar> T d() {
        return (T) this.f;
    }

    /* renamed from: a */
    public e b(ar arVar) {
        this.f = (ar) io.netty.util.a.j.a(arVar, "allocator");
        return this;
    }

    private void a(ar arVar, q qVar) {
        if (arVar instanceof ao) {
            ((ao) arVar).b(qVar.b());
        } else if (arVar == null) {
            throw new NullPointerException("allocator");
        }
        this.f = arVar;
    }

    @Override // io.netty.channel.e
    public boolean e() {
        return this.j == 1;
    }

    @Override // io.netty.channel.e
    /* renamed from: a */
    public e g(boolean z) {
        boolean z2 = c.getAndSet(this, z ? 1 : 0) == 1;
        if (z && !z2) {
            this.f4451a.l();
        } else if (!z && z2) {
            k();
        }
        return this;
    }

    @Override // io.netty.channel.e
    public boolean f() {
        return this.k;
    }

    /* renamed from: b */
    public e h(boolean z) {
        this.k = z;
        return this;
    }

    @Override // io.netty.channel.e
    public int g() {
        return this.l.b();
    }

    /* renamed from: d */
    public e m(int i) {
        bc bcVar;
        if (i < 0) {
            throw new IllegalArgumentException("writeBufferHighWaterMark must be >= 0");
        }
        do {
            bcVar = this.l;
            if (i < bcVar.a()) {
                throw new IllegalArgumentException("writeBufferHighWaterMark cannot be less than writeBufferLowWaterMark (" + bcVar.a() + "): " + i);
            }
        } while (!d.compareAndSet(this, bcVar, new bc(bcVar.a(), i, false)));
        return this;
    }

    @Override // io.netty.channel.e
    public int h() {
        return this.l.a();
    }

    /* renamed from: e */
    public e n(int i) {
        bc bcVar;
        if (i < 0) {
            throw new IllegalArgumentException("writeBufferLowWaterMark must be >= 0");
        }
        do {
            bcVar = this.l;
            if (i > bcVar.b()) {
                throw new IllegalArgumentException("writeBufferLowWaterMark cannot be greater than writeBufferHighWaterMark (" + bcVar.b() + "): " + i);
            }
        } while (!d.compareAndSet(this, bcVar, new bc(i, bcVar.b(), false)));
        return this;
    }

    /* renamed from: a */
    public e b(bc bcVar) {
        this.l = (bc) io.netty.util.a.j.a(bcVar, "writeBufferWaterMark");
        return this;
    }

    public bc l() {
        return this.l;
    }

    @Override // io.netty.channel.e
    public ap i() {
        return this.g;
    }

    /* renamed from: a */
    public e b(ap apVar) {
        if (apVar == null) {
            throw new NullPointerException("estimator");
        }
        this.g = apVar;
        return this;
    }

    private e c(boolean z) {
        this.m = z;
        return this;
    }

    private boolean m() {
        return this.m;
    }
}
