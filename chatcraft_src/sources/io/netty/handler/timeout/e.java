package io.netty.handler.timeout;

import io.netty.channel.h;
import io.netty.channel.i;
import io.netty.channel.l;
import io.netty.channel.u;
import io.netty.channel.z;
import io.netty.util.concurrent.p;
import io.netty.util.concurrent.r;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: WriteTimeoutHandler.java */
/* loaded from: classes.dex */
public class e extends u {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f4605a = !e.class.desiredAssertionStatus();

    /* renamed from: b, reason: collision with root package name */
    private static final long f4606b = TimeUnit.MILLISECONDS.toNanos(1);
    private final long c;
    private a d;
    private boolean e;

    public e(int i) {
        this(i, TimeUnit.SECONDS);
    }

    public e(long j, TimeUnit timeUnit) {
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        if (j <= 0) {
            this.c = 0L;
        } else {
            this.c = Math.max(timeUnit.toNanos(j), f4606b);
        }
    }

    @Override // io.netty.channel.u, io.netty.channel.t
    public void write(l lVar, Object obj, z zVar) {
        if (this.c > 0) {
            zVar = zVar.y_();
            a(lVar, zVar);
        }
        lVar.a(obj, zVar);
    }

    @Override // io.netty.channel.k, io.netty.channel.j
    public void handlerRemoved(l lVar) {
        a aVar = this.d;
        this.d = null;
        while (aVar != null) {
            aVar.c.cancel(false);
            a aVar2 = aVar.f4607a;
            aVar.f4607a = null;
            aVar.f4608b = null;
            aVar = aVar2;
        }
    }

    private void a(l lVar, z zVar) {
        a aVar = new a(lVar, zVar);
        aVar.c = lVar.d().schedule(aVar, this.c, TimeUnit.NANOSECONDS);
        if (aVar.c.isDone()) {
            return;
        }
        a(aVar);
        zVar.b((r<? extends p<? super Void>>) aVar);
    }

    private void a(a aVar) {
        if (this.d == null) {
            this.d = aVar;
            return;
        }
        this.d.f4608b = aVar;
        aVar.f4607a = this.d;
        this.d = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        if (aVar == this.d) {
            if (!f4605a && aVar.f4608b != null) {
                throw new AssertionError();
            }
            this.d = this.d.f4607a;
            if (this.d != null) {
                this.d.f4608b = null;
            }
        } else {
            if (aVar.f4607a == null && aVar.f4608b == null) {
                return;
            }
            if (aVar.f4607a == null) {
                aVar.f4608b.f4607a = null;
            } else {
                aVar.f4607a.f4608b = aVar.f4608b;
                aVar.f4608b.f4607a = aVar.f4607a;
            }
        }
        aVar.f4607a = null;
        aVar.f4608b = null;
    }

    protected void a(l lVar) {
        if (this.e) {
            return;
        }
        lVar.a((Throwable) WriteTimeoutException.f4588a);
        lVar.j();
        this.e = true;
    }

    /* compiled from: WriteTimeoutHandler.java */
    private final class a implements i, Runnable {

        /* renamed from: a, reason: collision with root package name */
        a f4607a;

        /* renamed from: b, reason: collision with root package name */
        a f4608b;
        ScheduledFuture<?> c;
        private final l e;
        private final z i;

        a(l lVar, z zVar) {
            this.e = lVar;
            this.i = zVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.i.isDone()) {
                try {
                    e.this.a(this.e);
                } catch (Throwable th) {
                    this.e.a(th);
                }
            }
            e.this.b(this);
        }

        @Override // io.netty.util.concurrent.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void operationComplete(h hVar) {
            this.c.cancel(false);
            e.this.b(this);
        }
    }
}
