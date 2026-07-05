package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class aae extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f1780a;

    aae(aad aadVar, String str) {
        this.f1780a = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        new aaq().a(this.f1780a);
    }
}
