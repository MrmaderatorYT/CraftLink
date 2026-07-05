package io.netty.b;

/* compiled from: AbstractByteBufAllocator.java */
/* loaded from: classes.dex */
public abstract class b implements j {

    /* renamed from: b, reason: collision with root package name */
    private final boolean f4377b;
    private final i c;

    protected abstract i d(int i, int i2);

    protected abstract i e(int i, int i2);

    protected static i a(i iVar) {
        switch (io.netty.util.p.b()) {
            case SIMPLE:
                io.netty.util.o oVarA = a.f4367a.a((io.netty.util.p<i>) iVar);
                if (oVarA != null) {
                    return new ac(iVar, oVarA);
                }
                break;
            case ADVANCED:
            case PARANOID:
                io.netty.util.o oVarA2 = a.f4367a.a((io.netty.util.p<i>) iVar);
                if (oVarA2 != null) {
                    return new g(iVar, oVarA2);
                }
                break;
        }
        return iVar;
    }

    protected static m a(m mVar) {
        switch (io.netty.util.p.b()) {
            case SIMPLE:
                io.netty.util.o oVarA = a.f4367a.a((io.netty.util.p<i>) mVar);
                if (oVarA != null) {
                    return new ad(mVar, oVarA);
                }
                break;
            case ADVANCED:
            case PARANOID:
                io.netty.util.o oVarA2 = a.f4367a.a((io.netty.util.p<i>) mVar);
                if (oVarA2 != null) {
                    return new h(mVar, oVarA2);
                }
                break;
        }
        return mVar;
    }

    protected b(boolean z) {
        this.f4377b = z && io.netty.util.a.l.f();
        this.c = new o(this);
    }

    @Override // io.netty.b.j
    public i a(int i) {
        if (this.f4377b) {
            return d(i);
        }
        return c(i);
    }

    @Override // io.netty.b.j
    public i a(int i, int i2) {
        if (this.f4377b) {
            return c(i, i2);
        }
        return b(i, i2);
    }

    @Override // io.netty.b.j
    public i a() {
        if (io.netty.util.a.l.f()) {
            return d(256);
        }
        return c(256);
    }

    @Override // io.netty.b.j
    public i b(int i) {
        if (io.netty.util.a.l.f()) {
            return d(i);
        }
        return c(i);
    }

    @Override // io.netty.b.j
    public i b() {
        return b(256, Integer.MAX_VALUE);
    }

    @Override // io.netty.b.j
    public i c(int i) {
        return b(i, Integer.MAX_VALUE);
    }

    public i b(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return this.c;
        }
        g(i, i2);
        return d(i, i2);
    }

    @Override // io.netty.b.j
    public i d(int i) {
        return c(i, Integer.MAX_VALUE);
    }

    public i c(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return this.c;
        }
        g(i, i2);
        return e(i, i2);
    }

    @Override // io.netty.b.j
    public m e(int i) {
        if (this.f4377b) {
            return g(i);
        }
        return f(i);
    }

    public m f(int i) {
        return a(new m(this, false, i));
    }

    public m g(int i) {
        return a(new m(this, true, i));
    }

    private static void g(int i, int i2) {
        if (i >= 0) {
            if (i > i2) {
                throw new IllegalArgumentException(String.format("initialCapacity: %d (expected: not greater than maxCapacity(%d)", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        } else {
            throw new IllegalArgumentException("initialCapacity: " + i + " (expectd: 0+)");
        }
    }

    public String toString() {
        return io.netty.util.a.p.a(this) + "(directByDefault: " + this.f4377b + ')';
    }

    @Override // io.netty.b.j
    public int f(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("minNewCapacity: " + i + " (expectd: 0+)");
        }
        if (i > i2) {
            throw new IllegalArgumentException(String.format("minNewCapacity: %d (expected: not greater than maxCapacity(%d)", Integer.valueOf(i), Integer.valueOf(i2)));
        }
        if (i == 4194304) {
            return 4194304;
        }
        if (i > 4194304) {
            int i3 = (i / 4194304) * 4194304;
            return i3 > i2 - 4194304 ? i2 : i3 + 4194304;
        }
        int i4 = 64;
        while (i4 < i) {
            i4 <<= 1;
        }
        return Math.min(i4, i2);
    }
}
