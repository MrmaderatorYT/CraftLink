package io.netty.channel;

import java.util.concurrent.TimeUnit;

/* compiled from: VoidChannelPromise.java */
/* loaded from: classes.dex */
final class bb extends io.netty.util.concurrent.c<Void> implements z {

    /* renamed from: a, reason: collision with root package name */
    private final d f4531a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f4532b;

    @Override // io.netty.util.concurrent.y
    public bb a(Void r1) {
        return this;
    }

    @Override // io.netty.util.concurrent.y
    public boolean b(Void r1) {
        return false;
    }

    @Override // io.netty.channel.z
    public boolean c() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return false;
    }

    @Override // io.netty.util.concurrent.p
    public Throwable k() {
        return null;
    }

    @Override // io.netty.util.concurrent.p
    public boolean l() {
        return false;
    }

    @Override // io.netty.channel.z
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public bb v_() {
        return this;
    }

    @Override // io.netty.util.concurrent.p
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public Void j() {
        return null;
    }

    @Override // io.netty.util.concurrent.y
    public boolean z_() {
        return true;
    }

    @Override // io.netty.channel.h
    /* renamed from: a */
    public /* synthetic */ h b(io.netty.util.concurrent.r rVar) {
        return b((io.netty.util.concurrent.r<? extends io.netty.util.concurrent.p<? super Void>>) rVar);
    }

    bb(d dVar, boolean z) {
        if (dVar == null) {
            throw new NullPointerException("channel");
        }
        this.f4531a = dVar;
        this.f4532b = z;
    }

    @Override // io.netty.util.concurrent.p
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public bb b(io.netty.util.concurrent.r<? extends io.netty.util.concurrent.p<? super Void>> rVar) {
        r();
        return this;
    }

    @Override // io.netty.util.concurrent.p
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public bb i() throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        return this;
    }

    @Override // io.netty.util.concurrent.p
    public boolean a(long j, TimeUnit timeUnit) {
        r();
        return false;
    }

    @Override // io.netty.channel.z, io.netty.channel.h
    public d e() {
        return this.f4531a;
    }

    @Override // io.netty.util.concurrent.p
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public bb h() {
        r();
        return this;
    }

    @Override // io.netty.util.concurrent.p
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public bb B_() {
        r();
        return this;
    }

    @Override // io.netty.util.concurrent.y
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public bb c(Throwable th) {
        e(th);
        return this;
    }

    @Override // io.netty.util.concurrent.y
    public boolean b(Throwable th) {
        e(th);
        return false;
    }

    private static void r() {
        throw new IllegalStateException("void future");
    }

    @Override // io.netty.channel.z
    public z y_() {
        af afVar = new af(this.f4531a);
        if (this.f4532b) {
            afVar.b((io.netty.util.concurrent.r<? extends io.netty.util.concurrent.p<? super Void>>) new i() { // from class: io.netty.channel.bb.1
                @Override // io.netty.util.concurrent.r
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void operationComplete(h hVar) {
                    if (hVar.l()) {
                        return;
                    }
                    bb.this.e(hVar.k());
                }
            });
        }
        return afVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Throwable th) {
        if (this.f4532b && this.f4531a.i()) {
            this.f4531a.d().a(th);
        }
    }
}
