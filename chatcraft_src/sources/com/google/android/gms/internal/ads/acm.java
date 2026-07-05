package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class acm implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f1836a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f1837b;
    private final /* synthetic */ ach c;

    acm(ach achVar, String str, String str2) {
        this.c = achVar;
        this.f1836a = str;
        this.f1837b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.c.r != null) {
            this.c.r.a(this.f1836a, this.f1837b);
        }
    }
}
