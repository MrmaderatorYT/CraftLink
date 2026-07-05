package io.netty.channel;

/* compiled from: DefaultChannelPromise.java */
/* loaded from: classes.dex */
public class af extends io.netty.util.concurrent.h<Void> implements z {

    /* renamed from: a, reason: collision with root package name */
    private final d f4473a;

    @Override // io.netty.channel.z
    public z y_() {
        return this;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [io.netty.channel.h, io.netty.channel.z] */
    @Override // io.netty.channel.h
    /* renamed from: a */
    public /* synthetic */ h b(io.netty.util.concurrent.r rVar) {
        return b((io.netty.util.concurrent.r<? extends io.netty.util.concurrent.p<? super Void>>) rVar);
    }

    public af(d dVar) {
        this.f4473a = dVar;
    }

    public af(d dVar, io.netty.util.concurrent.j jVar) {
        super(jVar);
        this.f4473a = dVar;
    }

    @Override // io.netty.util.concurrent.h
    protected io.netty.util.concurrent.j b() {
        io.netty.util.concurrent.j jVarB = super.b();
        return jVarB == null ? e().f() : jVarB;
    }

    @Override // io.netty.channel.z, io.netty.channel.h
    public d e() {
        return this.f4473a;
    }

    public z v_() {
        return a((Void) null);
    }

    @Override // io.netty.util.concurrent.h, io.netty.util.concurrent.y
    public z a(Void r1) {
        super.a((af) r1);
        return this;
    }

    public boolean c() {
        return b((af) null);
    }

    @Override // io.netty.util.concurrent.h, io.netty.util.concurrent.y
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public z c(Throwable th) {
        super.c(th);
        return this;
    }

    @Override // io.netty.util.concurrent.h
    public io.netty.util.concurrent.p<Void> b(io.netty.util.concurrent.r<? extends io.netty.util.concurrent.p<? super Void>> rVar) {
        super.b((io.netty.util.concurrent.r) rVar);
        return this;
    }

    @Override // io.netty.util.concurrent.h
    /* renamed from: w_, reason: merged with bridge method [inline-methods] */
    public z h() throws Throwable {
        super.h();
        return this;
    }

    @Override // io.netty.util.concurrent.h
    /* renamed from: x_, reason: merged with bridge method [inline-methods] */
    public z B_() throws Throwable {
        super.B_();
        return this;
    }

    @Override // io.netty.util.concurrent.h
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public z i() throws InterruptedException {
        super.i();
        return this;
    }

    @Override // io.netty.util.concurrent.h
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public z r() {
        super.r();
        return this;
    }

    @Override // io.netty.util.concurrent.h
    protected void o() {
        if (e().i()) {
            super.o();
        }
    }
}
