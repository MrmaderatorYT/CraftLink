package io.netty.channel;

/* compiled from: CompleteChannelFuture.java */
/* loaded from: classes.dex */
abstract class aa extends io.netty.util.concurrent.e<Void> implements h {

    /* renamed from: a, reason: collision with root package name */
    private final d f4449a;

    @Override // io.netty.util.concurrent.e, io.netty.util.concurrent.p
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h B_() {
        return this;
    }

    @Override // io.netty.util.concurrent.p
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Void j() {
        return null;
    }

    @Override // io.netty.util.concurrent.e, io.netty.util.concurrent.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public h h() {
        return this;
    }

    @Override // io.netty.util.concurrent.e, io.netty.util.concurrent.p
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public h i() {
        return this;
    }

    protected aa(d dVar, io.netty.util.concurrent.j jVar) {
        super(jVar);
        if (dVar == null) {
            throw new NullPointerException("channel");
        }
        this.f4449a = dVar;
    }

    @Override // io.netty.util.concurrent.e
    protected io.netty.util.concurrent.j a() {
        io.netty.util.concurrent.j jVarA = super.a();
        return jVarA == null ? e().f() : jVarA;
    }

    @Override // io.netty.util.concurrent.e, io.netty.util.concurrent.p
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public h b(io.netty.util.concurrent.r<? extends io.netty.util.concurrent.p<? super Void>> rVar) {
        super.b(rVar);
        return this;
    }

    @Override // io.netty.channel.h
    public d e() {
        return this.f4449a;
    }
}
