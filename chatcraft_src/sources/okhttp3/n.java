package okhttp3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.x;

/* compiled from: Dispatcher.java */
/* loaded from: classes.dex */
public final class n {

    @Nullable
    private Runnable c;

    @Nullable
    private ExecutorService d;

    /* renamed from: a, reason: collision with root package name */
    private int f5233a = 64;

    /* renamed from: b, reason: collision with root package name */
    private int f5234b = 5;
    private final Deque<x.a> e = new ArrayDeque();
    private final Deque<x.a> f = new ArrayDeque();
    private final Deque<x> g = new ArrayDeque();

    public synchronized ExecutorService a() {
        if (this.d == null) {
            this.d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), okhttp3.internal.c.a("OkHttp Dispatcher", false));
        }
        return this.d;
    }

    private void c() {
        if (this.f.size() < this.f5233a && !this.e.isEmpty()) {
            Iterator<x.a> it = this.e.iterator();
            while (it.hasNext()) {
                x.a next = it.next();
                if (b(next) < this.f5234b) {
                    it.remove();
                    this.f.add(next);
                    a().execute(next);
                }
                if (this.f.size() >= this.f5233a) {
                    return;
                }
            }
        }
    }

    private int b(x.a aVar) {
        int i = 0;
        for (x.a aVar2 : this.f) {
            if (!aVar2.b().d && aVar2.a().equals(aVar.a())) {
                i++;
            }
        }
        return i;
    }

    synchronized void a(x xVar) {
        this.g.add(xVar);
    }

    void a(x.a aVar) {
        a(this.f, aVar, true);
    }

    void b(x xVar) {
        a(this.g, xVar, false);
    }

    private <T> void a(Deque<T> deque, T t, boolean z) {
        int iB;
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            if (z) {
                c();
            }
            iB = b();
            runnable = this.c;
        }
        if (iB != 0 || runnable == null) {
            return;
        }
        runnable.run();
    }

    public synchronized int b() {
        return this.f.size() + this.g.size();
    }
}
