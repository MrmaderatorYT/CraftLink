package androidx.a.a.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DefaultTaskExecutor.java */
/* loaded from: classes.dex */
public class b extends c {

    /* renamed from: a, reason: collision with root package name */
    private final Object f72a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final ExecutorService f73b = Executors.newFixedThreadPool(2, new ThreadFactory() { // from class: androidx.a.a.a.b.1

        /* renamed from: b, reason: collision with root package name */
        private final AtomicInteger f75b = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.f75b.getAndIncrement())));
            return thread;
        }
    });
    private volatile Handler c;

    @Override // androidx.a.a.a.c
    public void a(Runnable runnable) {
        this.f73b.execute(runnable);
    }

    @Override // androidx.a.a.a.c
    public void b(Runnable runnable) {
        if (this.c == null) {
            synchronized (this.f72a) {
                if (this.c == null) {
                    this.c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.c.post(runnable);
    }

    @Override // androidx.a.a.a.c
    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
