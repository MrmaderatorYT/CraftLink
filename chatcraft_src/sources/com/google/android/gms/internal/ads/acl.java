package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class acl implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ach f1835a;

    acl(ach achVar) {
        this.f1835a = achVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1835a.r != null) {
            this.f1835a.r.e();
        }
    }
}
