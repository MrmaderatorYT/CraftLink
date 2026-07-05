package okhttp3;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.connection.f;

/* compiled from: ConnectionPool.java */
/* loaded from: classes.dex */
public final class j {
    static final /* synthetic */ boolean c = !j.class.desiredAssertionStatus();
    private static final Executor d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), okhttp3.internal.c.a("OkHttp ConnectionPool", true));

    /* renamed from: a, reason: collision with root package name */
    final okhttp3.internal.connection.d f5223a;

    /* renamed from: b, reason: collision with root package name */
    boolean f5224b;
    private final int e;
    private final long f;
    private final Runnable g;
    private final Deque<okhttp3.internal.connection.c> h;

    public j() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public j(int i, long j, TimeUnit timeUnit) {
        this.g = new Runnable() { // from class: okhttp3.j.1
            @Override // java.lang.Runnable
            public void run() throws IOException {
                while (true) {
                    long jA = j.this.a(System.nanoTime());
                    if (jA == -1) {
                        return;
                    }
                    if (jA > 0) {
                        long j2 = jA / 1000000;
                        long j3 = jA - (1000000 * j2);
                        synchronized (j.this) {
                            try {
                                j.this.wait(j2, (int) j3);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.h = new ArrayDeque();
        this.f5223a = new okhttp3.internal.connection.d();
        this.e = i;
        this.f = timeUnit.toNanos(j);
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
    }

    @Nullable
    okhttp3.internal.connection.c a(a aVar, okhttp3.internal.connection.f fVar, ac acVar) {
        if (!c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (okhttp3.internal.connection.c cVar : this.h) {
            if (cVar.a(aVar, acVar)) {
                fVar.a(cVar, true);
                return cVar;
            }
        }
        return null;
    }

    @Nullable
    Socket a(a aVar, okhttp3.internal.connection.f fVar) {
        if (!c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (okhttp3.internal.connection.c cVar : this.h) {
            if (cVar.a(aVar, null) && cVar.d() && cVar != fVar.c()) {
                return fVar.a(cVar);
            }
        }
        return null;
    }

    void a(okhttp3.internal.connection.c cVar) {
        if (!c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.f5224b) {
            this.f5224b = true;
            d.execute(this.g);
        }
        this.h.add(cVar);
    }

    boolean b(okhttp3.internal.connection.c cVar) {
        if (!c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (cVar.f5137a || this.e == 0) {
            this.h.remove(cVar);
            return true;
        }
        notifyAll();
        return false;
    }

    long a(long j) throws IOException {
        synchronized (this) {
            long j2 = Long.MIN_VALUE;
            okhttp3.internal.connection.c cVar = null;
            int i = 0;
            int i2 = 0;
            for (okhttp3.internal.connection.c cVar2 : this.h) {
                if (a(cVar2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - cVar2.e;
                    if (j3 > j2) {
                        cVar = cVar2;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f && i <= this.e) {
                if (i > 0) {
                    return this.f - j2;
                }
                if (i2 > 0) {
                    return this.f;
                }
                this.f5224b = false;
                return -1L;
            }
            this.h.remove(cVar);
            okhttp3.internal.c.a(cVar.b());
            return 0L;
        }
    }

    private int a(okhttp3.internal.connection.c cVar, long j) {
        List<Reference<okhttp3.internal.connection.f>> list = cVar.d;
        int i = 0;
        while (i < list.size()) {
            Reference<okhttp3.internal.connection.f> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                okhttp3.internal.e.f.c().a("A connection to " + cVar.a().a().a() + " was leaked. Did you forget to close a response body?", ((f.a) reference).f5146a);
                list.remove(i);
                cVar.f5137a = true;
                if (list.isEmpty()) {
                    cVar.e = j - this.f;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
