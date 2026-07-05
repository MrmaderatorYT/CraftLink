package com.google.android.gms.internal.ads;

import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
final class op implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ CountDownLatch f3320a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ oo f3321b;

    op(oo ooVar, CountDownLatch countDownLatch) {
        this.f3321b = ooVar;
        this.f3320a = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f3321b.d) {
            this.f3321b.m = com.google.android.gms.ads.internal.t.a(this.f3321b.l, this.f3321b.g, this.f3320a);
        }
    }
}
