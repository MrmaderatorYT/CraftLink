package io.netty.channel;

import java.util.Queue;
import java.util.concurrent.Executor;

/* compiled from: SingleThreadEventLoop.java */
/* loaded from: classes.dex */
public abstract class ax extends io.netty.util.concurrent.ae implements ak {

    /* renamed from: a, reason: collision with root package name */
    protected static final int f4486a = Math.max(16, io.netty.util.a.q.a("io.netty.eventLoop.maxPendingTasks", Integer.MAX_VALUE));

    /* renamed from: b, reason: collision with root package name */
    private final Queue<Runnable> f4487b;

    /* compiled from: SingleThreadEventLoop.java */
    interface a extends Runnable {
    }

    protected ax(al alVar, Executor executor, boolean z) {
        this(alVar, executor, z, f4486a, io.netty.util.concurrent.ab.a());
    }

    protected ax(al alVar, Executor executor, boolean z, int i, io.netty.util.concurrent.aa aaVar) {
        super(alVar, executor, z, i, aaVar);
        this.f4487b = a(i);
    }

    @Override // io.netty.util.concurrent.a, io.netty.util.concurrent.l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ak c() {
        return (ak) super.c();
    }

    @Override // io.netty.channel.al
    public h a(d dVar) {
        return a((z) new af(dVar, this));
    }

    @Override // io.netty.channel.al
    public h a(z zVar) {
        io.netty.util.a.j.a(zVar, "promise");
        zVar.e().n().a((ak) this, zVar);
        return zVar;
    }

    @Override // io.netty.util.concurrent.ae
    protected boolean a(Runnable runnable) {
        return !(runnable instanceof a);
    }

    @Override // io.netty.util.concurrent.ae
    protected void b() {
        b(this.f4487b);
    }

    @Override // io.netty.util.concurrent.ae
    protected boolean d() {
        return super.d() || !this.f4487b.isEmpty();
    }

    @Override // io.netty.util.concurrent.ae
    public int e() {
        return super.e() + this.f4487b.size();
    }
}
