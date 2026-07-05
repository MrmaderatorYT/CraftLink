package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class bw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bj f3039a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bv f3040b;

    bw(bv bvVar, bj bjVar) {
        this.f3040b = bvVar;
        this.f3039a = bjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3040b.a(this.f3039a);
    }
}
