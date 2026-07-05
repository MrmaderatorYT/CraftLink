package io.netty.handler.timeout;

import io.netty.channel.l;
import java.util.concurrent.TimeUnit;

/* compiled from: ReadTimeoutHandler.java */
/* loaded from: classes.dex */
public class d extends c {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f4603a = !d.class.desiredAssertionStatus();

    /* renamed from: b, reason: collision with root package name */
    private boolean f4604b;

    public d(int i) {
        this(i, TimeUnit.SECONDS);
    }

    public d(long j, TimeUnit timeUnit) {
        super(j, 0L, 0L, timeUnit);
    }

    @Override // io.netty.handler.timeout.c
    protected final void a(l lVar, b bVar) {
        if (!f4603a && bVar.a() != a.READER_IDLE) {
            throw new AssertionError();
        }
        a(lVar);
    }

    protected void a(l lVar) {
        if (this.f4604b) {
            return;
        }
        lVar.a((Throwable) ReadTimeoutException.f4587a);
        lVar.j();
        this.f4604b = true;
    }
}
