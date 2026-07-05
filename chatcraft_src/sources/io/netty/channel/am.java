package io.netty.channel;

/* compiled from: FailedChannelFuture.java */
/* loaded from: classes.dex */
final class am extends aa {

    /* renamed from: a, reason: collision with root package name */
    private final Throwable f4482a;

    @Override // io.netty.util.concurrent.p
    public boolean l() {
        return false;
    }

    am(d dVar, io.netty.util.concurrent.j jVar, Throwable th) {
        super(dVar, jVar);
        if (th == null) {
            throw new NullPointerException("cause");
        }
        this.f4482a = th;
    }

    @Override // io.netty.util.concurrent.p
    public Throwable k() {
        return this.f4482a;
    }

    @Override // io.netty.channel.aa, io.netty.util.concurrent.e, io.netty.util.concurrent.p
    /* renamed from: f */
    public h h() throws Throwable {
        io.netty.util.a.l.a(this.f4482a);
        return this;
    }

    @Override // io.netty.channel.aa, io.netty.util.concurrent.e, io.netty.util.concurrent.p
    /* renamed from: b */
    public h B_() throws Throwable {
        io.netty.util.a.l.a(this.f4482a);
        return this;
    }
}
