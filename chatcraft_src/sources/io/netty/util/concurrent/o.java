package io.netty.util.concurrent;

/* compiled from: FastThreadLocalThread.java */
/* loaded from: classes.dex */
public class o extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private io.netty.util.a.d f4747a;

    public o() {
    }

    public o(ThreadGroup threadGroup, Runnable runnable, String str) {
        super(threadGroup, runnable, str);
    }

    public final io.netty.util.a.d a() {
        return this.f4747a;
    }

    public final void a(io.netty.util.a.d dVar) {
        this.f4747a = dVar;
    }
}
