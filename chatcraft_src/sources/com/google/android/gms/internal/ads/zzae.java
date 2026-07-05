package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public class zzae extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private final bje f3653a;

    /* renamed from: b, reason: collision with root package name */
    private long f3654b;

    public zzae() {
        this.f3653a = null;
    }

    public zzae(bje bjeVar) {
        this.f3653a = bjeVar;
    }

    public zzae(String str) {
        super(str);
        this.f3653a = null;
    }

    public zzae(Throwable th) {
        super(th);
        this.f3653a = null;
    }

    final void a(long j) {
        this.f3654b = j;
    }
}
