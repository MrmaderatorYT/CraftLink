package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class acy implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ acv f1851a;

    acy(acv acvVar) {
        this.f1851a = acvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1851a.a("surfaceCreated", new String[0]);
    }
}
