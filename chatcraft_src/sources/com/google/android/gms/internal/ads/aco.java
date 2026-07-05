package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class aco implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f1839a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ int f1840b;
    private final /* synthetic */ ach c;

    aco(ach achVar, int i, int i2) {
        this.c = achVar;
        this.f1839a = i;
        this.f1840b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.c.r != null) {
            this.c.r.a(this.f1839a, this.f1840b);
        }
    }
}
