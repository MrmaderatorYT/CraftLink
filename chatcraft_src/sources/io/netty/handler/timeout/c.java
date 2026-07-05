package io.netty.handler.timeout;

import io.netty.channel.f;
import io.netty.channel.h;
import io.netty.channel.i;
import io.netty.channel.l;
import io.netty.channel.z;
import io.netty.util.concurrent.j;
import io.netty.util.concurrent.p;
import io.netty.util.concurrent.r;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: IdleStateHandler.java */
/* loaded from: classes.dex */
public class c extends f {

    /* renamed from: a, reason: collision with root package name */
    private static final long f4593a = TimeUnit.MILLISECONDS.toNanos(1);
    private final long c;
    private final long d;
    private final long e;
    private ScheduledFuture<?> f;
    private long g;
    private ScheduledFuture<?> i;
    private long j;
    private ScheduledFuture<?> l;
    private byte n;
    private boolean o;

    /* renamed from: b, reason: collision with root package name */
    private final i f4594b = new i() { // from class: io.netty.handler.timeout.c.1
        @Override // io.netty.util.concurrent.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void operationComplete(h hVar) {
            c.this.j = System.nanoTime();
            c.this.k = c.this.m = true;
        }
    };
    private boolean h = true;
    private boolean k = true;
    private boolean m = true;

    public c(long j, long j2, long j3, TimeUnit timeUnit) {
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        if (j <= 0) {
            this.c = 0L;
        } else {
            this.c = Math.max(timeUnit.toNanos(j), f4593a);
        }
        if (j2 <= 0) {
            this.d = 0L;
        } else {
            this.d = Math.max(timeUnit.toNanos(j2), f4593a);
        }
        if (j3 <= 0) {
            this.e = 0L;
        } else {
            this.e = Math.max(timeUnit.toNanos(j3), f4593a);
        }
    }

    @Override // io.netty.channel.k, io.netty.channel.j
    public void handlerAdded(l lVar) {
        if (lVar.a().F() && lVar.a().i()) {
            a(lVar);
        }
    }

    @Override // io.netty.channel.k, io.netty.channel.j
    public void handlerRemoved(l lVar) {
        a();
    }

    @Override // io.netty.channel.o, io.netty.channel.n
    public void channelRegistered(l lVar) {
        if (lVar.a().F()) {
            a(lVar);
        }
        super.channelRegistered(lVar);
    }

    @Override // io.netty.channel.o, io.netty.channel.n
    public void channelActive(l lVar) {
        a(lVar);
        super.channelActive(lVar);
    }

    @Override // io.netty.channel.o, io.netty.channel.n
    public void channelInactive(l lVar) {
        a();
        super.channelInactive(lVar);
    }

    @Override // io.netty.channel.o, io.netty.channel.n
    public void channelRead(l lVar, Object obj) {
        if (this.c > 0 || this.e > 0) {
            this.o = true;
            this.m = true;
            this.h = true;
        }
        lVar.c(obj);
    }

    @Override // io.netty.channel.o, io.netty.channel.n
    public void channelReadComplete(l lVar) {
        if ((this.c > 0 || this.e > 0) && this.o) {
            this.g = System.nanoTime();
            this.o = false;
        }
        lVar.k();
    }

    @Override // io.netty.channel.f, io.netty.channel.t
    public void write(l lVar, Object obj, z zVar) {
        if (this.d > 0 || this.e > 0) {
            z zVarY_ = zVar.y_();
            zVarY_.b((r<? extends p<? super Void>>) this.f4594b);
            lVar.a(obj, zVarY_);
            return;
        }
        lVar.a(obj, zVar);
    }

    private void a(l lVar) {
        switch (this.n) {
            case 1:
            case 2:
                break;
            default:
                this.n = (byte) 1;
                j jVarD = lVar.d();
                long jNanoTime = System.nanoTime();
                this.j = jNanoTime;
                this.g = jNanoTime;
                if (this.c > 0) {
                    this.f = jVarD.schedule(new b(lVar), this.c, TimeUnit.NANOSECONDS);
                }
                if (this.d > 0) {
                    this.i = jVarD.schedule(new RunnableC0107c(lVar), this.d, TimeUnit.NANOSECONDS);
                }
                if (this.e > 0) {
                    this.l = jVarD.schedule(new a(lVar), this.e, TimeUnit.NANOSECONDS);
                    break;
                }
                break;
        }
    }

    private void a() {
        this.n = (byte) 2;
        if (this.f != null) {
            this.f.cancel(false);
            this.f = null;
        }
        if (this.i != null) {
            this.i.cancel(false);
            this.i = null;
        }
        if (this.l != null) {
            this.l.cancel(false);
            this.l = null;
        }
    }

    protected void a(l lVar, io.netty.handler.timeout.b bVar) {
        lVar.b(bVar);
    }

    protected io.netty.handler.timeout.b a(io.netty.handler.timeout.a aVar, boolean z) {
        switch (aVar) {
            case ALL_IDLE:
                return z ? io.netty.handler.timeout.b.e : io.netty.handler.timeout.b.f;
            case READER_IDLE:
                return z ? io.netty.handler.timeout.b.f4591a : io.netty.handler.timeout.b.f4592b;
            case WRITER_IDLE:
                return z ? io.netty.handler.timeout.b.c : io.netty.handler.timeout.b.d;
            default:
                throw new Error();
        }
    }

    /* compiled from: IdleStateHandler.java */
    private final class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private final l f4600b;

        b(l lVar) {
            this.f4600b = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f4600b.a().E()) {
                long jNanoTime = c.this.c;
                if (!c.this.o) {
                    jNanoTime -= System.nanoTime() - c.this.g;
                }
                if (jNanoTime <= 0) {
                    c.this.f = this.f4600b.d().schedule(this, c.this.c, TimeUnit.NANOSECONDS);
                    try {
                        io.netty.handler.timeout.b bVarA = c.this.a(io.netty.handler.timeout.a.READER_IDLE, c.this.h);
                        if (c.this.h) {
                            c.this.h = false;
                        }
                        c.this.a(this.f4600b, bVarA);
                        return;
                    } catch (Throwable th) {
                        this.f4600b.a(th);
                        return;
                    }
                }
                c.this.f = this.f4600b.d().schedule(this, jNanoTime, TimeUnit.NANOSECONDS);
            }
        }
    }

    /* compiled from: IdleStateHandler.java */
    /* renamed from: io.netty.handler.timeout.c$c, reason: collision with other inner class name */
    private final class RunnableC0107c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private final l f4602b;

        RunnableC0107c(l lVar) {
            this.f4602b = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f4602b.a().E()) {
                long jNanoTime = c.this.d - (System.nanoTime() - c.this.j);
                if (jNanoTime <= 0) {
                    c.this.i = this.f4602b.d().schedule(this, c.this.d, TimeUnit.NANOSECONDS);
                    try {
                        io.netty.handler.timeout.b bVarA = c.this.a(io.netty.handler.timeout.a.WRITER_IDLE, c.this.k);
                        if (c.this.k) {
                            c.this.k = false;
                        }
                        c.this.a(this.f4602b, bVarA);
                        return;
                    } catch (Throwable th) {
                        this.f4602b.a(th);
                        return;
                    }
                }
                c.this.i = this.f4602b.d().schedule(this, jNanoTime, TimeUnit.NANOSECONDS);
            }
        }
    }

    /* compiled from: IdleStateHandler.java */
    private final class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private final l f4598b;

        a(l lVar) {
            this.f4598b = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f4598b.a().E()) {
                long jNanoTime = c.this.e;
                if (!c.this.o) {
                    jNanoTime -= System.nanoTime() - Math.max(c.this.g, c.this.j);
                }
                if (jNanoTime <= 0) {
                    c.this.l = this.f4598b.d().schedule(this, c.this.e, TimeUnit.NANOSECONDS);
                    try {
                        io.netty.handler.timeout.b bVarA = c.this.a(io.netty.handler.timeout.a.ALL_IDLE, c.this.m);
                        if (c.this.m) {
                            c.this.m = false;
                        }
                        c.this.a(this.f4598b, bVarA);
                        return;
                    } catch (Throwable th) {
                        this.f4598b.a(th);
                        return;
                    }
                }
                c.this.l = this.f4598b.d().schedule(this, jNanoTime, TimeUnit.NANOSECONDS);
            }
        }
    }
}
