package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes.dex */
final class bfk implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ IOException f2616a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bfg f2617b;

    bfk(bfg bfgVar, IOException iOException) {
        this.f2617b = bfgVar;
        this.f2616a = iOException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2617b.e.a(this.f2616a);
    }
}
