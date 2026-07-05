package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class brg<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f3003a;

    /* renamed from: b, reason: collision with root package name */
    public final awj f3004b;
    public final zzae c;
    public boolean d;

    public static <T> brg<T> a(T t, awj awjVar) {
        return new brg<>(t, awjVar);
    }

    public static <T> brg<T> a(zzae zzaeVar) {
        return new brg<>(zzaeVar);
    }

    private brg(T t, awj awjVar) {
        this.d = false;
        this.f3003a = t;
        this.f3004b = awjVar;
        this.c = null;
    }

    private brg(zzae zzaeVar) {
        this.d = false;
        this.f3003a = null;
        this.f3004b = null;
        this.c = zzaeVar;
    }
}
