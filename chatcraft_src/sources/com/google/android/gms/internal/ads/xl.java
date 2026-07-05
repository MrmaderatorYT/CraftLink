package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@qj
/* loaded from: classes.dex */
public final class xl {

    /* renamed from: a, reason: collision with root package name */
    public static final abp f3579a = abq.a(new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10, TimeUnit.SECONDS, new SynchronousQueue(), a("Default")));

    /* renamed from: b, reason: collision with root package name */
    public static final abp f3580b;
    public static final ScheduledExecutorService c;

    public static <T> abl<T> a(Callable<T> callable) {
        return f3579a.submit(callable);
    }

    private static ThreadFactory a(String str) {
        return new xm(str);
    }

    public static abl<?> a(Runnable runnable) {
        return f3579a.submit(runnable);
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), a("Loader"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f3580b = abq.a(threadPoolExecutor);
        c = new ScheduledThreadPoolExecutor(3, a("Schedule"));
    }
}
