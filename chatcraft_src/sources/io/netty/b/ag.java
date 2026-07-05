package io.netty.b;

/* compiled from: UnpooledByteBufAllocator.java */
/* loaded from: classes.dex */
public final class ag extends b {

    /* renamed from: b, reason: collision with root package name */
    public static final ag f4374b = new ag(io.netty.util.a.l.h());
    private final boolean c;

    @Override // io.netty.b.j
    public boolean c() {
        return false;
    }

    public ag(boolean z) {
        this(z, false);
    }

    public ag(boolean z, boolean z2) {
        super(z);
        this.c = z2;
    }

    @Override // io.netty.b.b
    protected i d(int i, int i2) {
        return io.netty.util.a.l.f() ? new al(this, i, i2) : new ai(this, i, i2);
    }

    @Override // io.netty.b.b
    protected i e(int i, int i2) {
        i iVarA = io.netty.util.a.l.f() ? an.a(this, i, i2) : new ah(this, i, i2);
        return this.c ? iVarA : a(iVarA);
    }

    @Override // io.netty.b.b
    public m f(int i) {
        m mVar = new m(this, false, i);
        return this.c ? mVar : a(mVar);
    }

    @Override // io.netty.b.b
    public m g(int i) {
        m mVar = new m(this, true, i);
        return this.c ? mVar : a(mVar);
    }
}
