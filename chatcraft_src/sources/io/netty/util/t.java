package io.netty.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ThreadDeathWatcher.java */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    static final ThreadFactory f4795a;

    /* renamed from: b, reason: collision with root package name */
    private static final io.netty.util.a.b.c f4796b = io.netty.util.a.b.d.a((Class<?>) t.class);
    private static final Queue<a> c = io.netty.util.a.l.n();
    private static final b d = new b();
    private static final AtomicBoolean e = new AtomicBoolean();
    private static volatile Thread f;

    static {
        String str = "threadDeathWatcher";
        String strB = io.netty.util.a.q.b("io.netty.serviceThreadPrefix");
        if (!io.netty.util.a.p.a(strB)) {
            str = strB + "threadDeathWatcher";
        }
        f4795a = new io.netty.util.concurrent.i(str, true, 1, null);
    }

    public static void a(Thread thread, Runnable runnable) {
        if (thread == null) {
            throw new NullPointerException("thread");
        }
        if (runnable == null) {
            throw new NullPointerException("task");
        }
        if (!thread.isAlive()) {
            throw new IllegalArgumentException("thread must be alive.");
        }
        a(thread, runnable, true);
    }

    public static void b(Thread thread, Runnable runnable) {
        if (thread == null) {
            throw new NullPointerException("thread");
        }
        if (runnable == null) {
            throw new NullPointerException("task");
        }
        a(thread, runnable, false);
    }

    private static void a(Thread thread, Runnable runnable, boolean z) {
        c.add(new a(thread, runnable, z));
        if (e.compareAndSet(false, true)) {
            Thread threadNewThread = f4795a.newThread(d);
            threadNewThread.start();
            f = threadNewThread;
        }
    }

    private t() {
    }

    /* compiled from: ThreadDeathWatcher.java */
    private static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ boolean f4799a = !t.class.desiredAssertionStatus();

        /* renamed from: b, reason: collision with root package name */
        private final List<a> f4800b;

        private b() {
            this.f4800b = new ArrayList();
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            while (true) {
                a();
                b();
                a();
                b();
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                }
                if (this.f4800b.isEmpty() && t.c.isEmpty()) {
                    boolean zCompareAndSet = t.e.compareAndSet(true, false);
                    if (!f4799a && !zCompareAndSet) {
                        throw new AssertionError();
                    }
                    if (t.c.isEmpty() || !t.e.compareAndSet(false, true)) {
                        return;
                    }
                }
            }
        }

        private void a() {
            while (true) {
                a aVar = (a) t.c.poll();
                if (aVar == null) {
                    return;
                }
                if (aVar.c) {
                    this.f4800b.add(aVar);
                } else {
                    this.f4800b.remove(aVar);
                }
            }
        }

        private void b() {
            List<a> list = this.f4800b;
            int i = 0;
            while (i < list.size()) {
                a aVar = list.get(i);
                if (aVar.f4797a.isAlive()) {
                    i++;
                } else {
                    list.remove(i);
                    try {
                        aVar.f4798b.run();
                    } catch (Throwable th) {
                        t.f4796b.b("Thread death watcher task raised an exception:", th);
                    }
                }
            }
        }
    }

    /* compiled from: ThreadDeathWatcher.java */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        final Thread f4797a;

        /* renamed from: b, reason: collision with root package name */
        final Runnable f4798b;
        final boolean c;

        a(Thread thread, Runnable runnable, boolean z) {
            this.f4797a = thread;
            this.f4798b = runnable;
            this.c = z;
        }

        public int hashCode() {
            return this.f4797a.hashCode() ^ this.f4798b.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f4797a == aVar.f4797a && this.f4798b == aVar.f4798b;
        }
    }
}
