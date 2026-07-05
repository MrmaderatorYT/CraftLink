package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.wk;

/* loaded from: classes.dex */
final class bj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bi f1551a;

    bj(bi biVar) {
        this.f1551a = biVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1551a.c.b(new wk(this.f1551a.f1549a, null, null, null, null, null, null, null));
    }
}
