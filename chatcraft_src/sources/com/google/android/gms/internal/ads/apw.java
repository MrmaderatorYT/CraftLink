package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class apw {

    /* renamed from: a, reason: collision with root package name */
    private final zzbqk f2155a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f2156b;

    private apw(int i) {
        this.f2156b = new byte[i];
        this.f2155a = zzbqk.a(this.f2156b);
    }

    public final apo a() {
        this.f2155a.c();
        return new apy(this.f2156b);
    }

    public final zzbqk b() {
        return this.f2155a;
    }

    /* synthetic */ apw(int i, app appVar) {
        this(i);
    }
}
