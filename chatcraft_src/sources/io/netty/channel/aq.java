package io.netty.channel;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* compiled from: MultithreadEventLoopGroup.java */
/* loaded from: classes.dex */
public abstract class aq extends io.netty.util.concurrent.u implements al {

    /* renamed from: a, reason: collision with root package name */
    private static final io.netty.util.a.b.c f4483a = io.netty.util.a.b.d.a((Class<?>) aq.class);

    /* renamed from: b, reason: collision with root package name */
    private static final int f4484b = Math.max(1, io.netty.util.a.q.a("io.netty.eventLoopThreads", Runtime.getRuntime().availableProcessors() * 2));

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.util.concurrent.u
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract ak b(Executor executor, Object... objArr);

    static {
        if (f4483a.b()) {
            f4483a.b("-Dio.netty.eventLoopThreads: {}", Integer.valueOf(f4484b));
        }
    }

    protected aq(int i, Executor executor, Object... objArr) {
        super(i == 0 ? f4484b : i, executor, objArr);
    }

    @Override // io.netty.util.concurrent.u
    protected ThreadFactory a() {
        return new io.netty.util.concurrent.i(getClass(), 10);
    }

    @Override // io.netty.util.concurrent.u, io.netty.util.concurrent.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ak c() {
        return (ak) super.c();
    }

    @Override // io.netty.channel.al
    public h a(d dVar) {
        return c().a(dVar);
    }

    @Override // io.netty.channel.al
    public h a(z zVar) {
        return c().a(zVar);
    }
}
