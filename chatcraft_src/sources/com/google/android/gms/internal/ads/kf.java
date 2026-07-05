package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class kf implements Callable<ka> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ jx f3224a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ ke f3225b;

    kf(ke keVar, jx jxVar) {
        this.f3225b = keVar;
        this.f3224a = jxVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final ka call() {
        synchronized (this.f3225b.i) {
            if (this.f3225b.j) {
                return null;
            }
            return this.f3224a.a(this.f3225b.f, this.f3225b.g);
        }
    }
}
