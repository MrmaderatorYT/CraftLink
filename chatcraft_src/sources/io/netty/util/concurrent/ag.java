package io.netty.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* compiled from: ThreadPerTaskExecutor.java */
/* loaded from: classes.dex */
public final class ag implements Executor {

    /* renamed from: a, reason: collision with root package name */
    private final ThreadFactory f4722a;

    public ag(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory");
        }
        this.f4722a = threadFactory;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f4722a.newThread(runnable).start();
    }
}
