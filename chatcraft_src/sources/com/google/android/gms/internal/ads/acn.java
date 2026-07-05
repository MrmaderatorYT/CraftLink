package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class acn implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ach f1838a;

    acn(ach achVar) {
        this.f1838a = achVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1838a.r != null) {
            this.f1838a.r.a();
        }
    }
}
