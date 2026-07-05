package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
final class n<T> implements Callable<T> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ d f3288a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ l f3289b;

    n(l lVar, d dVar) {
        this.f3289b = lVar;
        this.f3288a = dVar;
    }

    @Override // java.util.concurrent.Callable
    public final T call() {
        return (T) this.f3288a.a(this.f3289b.e);
    }
}
