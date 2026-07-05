package io.netty.util.concurrent;

/* compiled from: FailedFuture.java */
/* loaded from: classes.dex */
public final class m<V> extends e<V> {

    /* renamed from: a, reason: collision with root package name */
    private final Throwable f4744a;

    @Override // io.netty.util.concurrent.p
    public V j() {
        return null;
    }

    @Override // io.netty.util.concurrent.p
    public boolean l() {
        return false;
    }

    public m(j jVar, Throwable th) {
        super(jVar);
        if (th == null) {
            throw new NullPointerException("cause");
        }
        this.f4744a = th;
    }

    @Override // io.netty.util.concurrent.p
    public Throwable k() {
        return this.f4744a;
    }

    @Override // io.netty.util.concurrent.e, io.netty.util.concurrent.p
    public p<V> h() throws Throwable {
        io.netty.util.a.l.a(this.f4744a);
        return this;
    }

    @Override // io.netty.util.concurrent.e, io.netty.util.concurrent.p
    public p<V> B_() throws Throwable {
        io.netty.util.a.l.a(this.f4744a);
        return this;
    }
}
