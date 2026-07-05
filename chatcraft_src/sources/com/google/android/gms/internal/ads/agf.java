package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class agf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ age f1957a;

    agf(age ageVar) {
        this.f1957a = ageVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1957a.f1955a.destroy();
    }
}
