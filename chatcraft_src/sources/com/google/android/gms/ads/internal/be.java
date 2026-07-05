package com.google.android.gms.ads.internal;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class be implements Callable<String> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ba f1545a;

    be(ba baVar) {
        this.f1545a = baVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() {
        return this.f1545a.e.d.a().a(this.f1545a.e.c);
    }
}
