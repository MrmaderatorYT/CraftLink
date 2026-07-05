package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

/* loaded from: classes.dex */
final class su implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Future f3458a;

    su(sr srVar, Future future) {
        this.f3458a = future;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f3458a.isDone()) {
            return;
        }
        this.f3458a.cancel(true);
    }
}
