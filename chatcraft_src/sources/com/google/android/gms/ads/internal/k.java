package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.bqj;

/* loaded from: classes.dex */
final class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bqj f1615a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ int f1616b;
    private final /* synthetic */ i c;

    k(i iVar, bqj bqjVar, int i) {
        this.c = iVar;
        this.f1615a = bqjVar;
        this.f1616b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.c.t) {
            this.c.b(this.f1615a, this.f1616b);
        }
    }
}
