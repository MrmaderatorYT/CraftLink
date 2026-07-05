package io.fabric.sdk.android.services.concurrency;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: AsyncTask.java */
/* loaded from: classes.dex */
public abstract class a<Params, Progress, Result> {

    /* renamed from: a, reason: collision with root package name */
    private static final int f4255a = Runtime.getRuntime().availableProcessors();
    private static final int d = f4255a + 1;
    private static final int e = (f4255a * 2) + 1;
    private static final ThreadFactory f = new ThreadFactory() { // from class: io.fabric.sdk.android.services.concurrency.a.1

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f4257a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.f4257a.getAndIncrement());
        }
    };
    private static final BlockingQueue<Runnable> g = new LinkedBlockingQueue(128);

    /* renamed from: b, reason: collision with root package name */
    public static final Executor f4256b = new ThreadPoolExecutor(d, e, 1, TimeUnit.SECONDS, g, f);
    public static final Executor c = new c();
    private static final b h = new b();
    private static volatile Executor i = c;
    private volatile d l = d.PENDING;
    private final AtomicBoolean m = new AtomicBoolean();
    private final AtomicBoolean n = new AtomicBoolean();
    private final e<Params, Result> j = new e<Params, Result>() { // from class: io.fabric.sdk.android.services.concurrency.a.2
        @Override // java.util.concurrent.Callable
        public Result call() throws SecurityException, IllegalArgumentException {
            a.this.n.set(true);
            Process.setThreadPriority(10);
            return (Result) a.this.e(a.this.a((Object[]) this.f4274b));
        }
    };
    private final FutureTask<Result> k = new FutureTask<Result>(this.j) { // from class: io.fabric.sdk.android.services.concurrency.a.3
        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                a.this.d(get());
            } catch (InterruptedException e2) {
                Log.w("AsyncTask", e2);
            } catch (CancellationException unused) {
                a.this.d(null);
            } catch (ExecutionException e3) {
                throw new RuntimeException("An error occured while executing doInBackground()", e3.getCause());
            }
        }
    };

    /* compiled from: AsyncTask.java */
    public enum d {
        PENDING,
        RUNNING,
        FINISHED
    }

    protected abstract Result a(Params... paramsArr);

    protected void a() {
    }

    protected void a(Result result) {
    }

    protected void b(Progress... progressArr) {
    }

    protected void u_() {
    }

    /* compiled from: AsyncTask.java */
    private static class c implements Executor {

        /* renamed from: a, reason: collision with root package name */
        final LinkedList<Runnable> f4266a;

        /* renamed from: b, reason: collision with root package name */
        Runnable f4267b;

        private c() {
            this.f4266a = new LinkedList<>();
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.f4266a.offer(new Runnable() { // from class: io.fabric.sdk.android.services.concurrency.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        c.this.a();
                    }
                }
            });
            if (this.f4267b == null) {
                a();
            }
        }

        protected synchronized void a() {
            Runnable runnablePoll = this.f4266a.poll();
            this.f4267b = runnablePoll;
            if (runnablePoll != null) {
                a.f4256b.execute(this.f4267b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Result result) {
        if (this.n.get()) {
            return;
        }
        e(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Result e(Result result) {
        h.obtainMessage(1, new C0096a(this, result)).sendToTarget();
        return result;
    }

    public final d t_() {
        return this.l;
    }

    protected void b(Result result) {
        u_();
    }

    public final boolean e() {
        return this.m.get();
    }

    public final boolean a(boolean z) {
        this.m.set(true);
        return this.k.cancel(z);
    }

    public final a<Params, Progress, Result> a(Executor executor, Params... paramsArr) {
        if (this.l != d.PENDING) {
            switch (this.l) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.l = d.RUNNING;
        a();
        this.j.f4274b = paramsArr;
        executor.execute(this.k);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Result result) {
        if (e()) {
            b((a<Params, Progress, Result>) result);
        } else {
            a((a<Params, Progress, Result>) result);
        }
        this.l = d.FINISHED;
    }

    /* compiled from: AsyncTask.java */
    private static class b extends Handler {
        public b() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C0096a c0096a = (C0096a) message.obj;
            switch (message.what) {
                case 1:
                    c0096a.f4261a.f(c0096a.f4262b[0]);
                    break;
                case 2:
                    c0096a.f4261a.b((Object[]) c0096a.f4262b);
                    break;
            }
        }
    }

    /* compiled from: AsyncTask.java */
    private static abstract class e<Params, Result> implements Callable<Result> {

        /* renamed from: b, reason: collision with root package name */
        Params[] f4274b;

        private e() {
        }
    }

    /* compiled from: AsyncTask.java */
    /* renamed from: io.fabric.sdk.android.services.concurrency.a$a, reason: collision with other inner class name */
    private static class C0096a<Data> {

        /* renamed from: a, reason: collision with root package name */
        final a f4261a;

        /* renamed from: b, reason: collision with root package name */
        final Data[] f4262b;

        C0096a(a aVar, Data... dataArr) {
            this.f4261a = aVar;
            this.f4262b = dataArr;
        }
    }
}
