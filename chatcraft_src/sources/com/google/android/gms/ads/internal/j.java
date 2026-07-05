package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.bqj;

/* loaded from: classes.dex */
final class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bqj f1613a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ i f1614b;

    j(i iVar, bqj bqjVar) {
        this.f1614b = iVar;
        this.f1613a = bqjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f1614b.t) {
            if (this.f1614b.d()) {
                this.f1614b.b(this.f1613a);
            } else {
                this.f1614b.b(this.f1613a, 1);
            }
        }
    }
}
