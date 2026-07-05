package com.google.android.gms.internal.ads;

@qj
/* loaded from: classes.dex */
public final class ahh {

    /* renamed from: a, reason: collision with root package name */
    public final int f1977a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1978b;
    private final int c;

    public static ahh a(bqn bqnVar) {
        return bqnVar.d ? new ahh(3, 0, 0) : bqnVar.i ? new ahh(2, 0, 0) : bqnVar.h ? a() : a(bqnVar.f, bqnVar.c);
    }

    public static ahh a() {
        return new ahh(0, 0, 0);
    }

    public static ahh a(int i, int i2) {
        return new ahh(1, i, i2);
    }

    public static ahh b() {
        return new ahh(4, 0, 0);
    }

    public static ahh c() {
        return new ahh(5, 0, 0);
    }

    private ahh(int i, int i2, int i3) {
        this.c = i;
        this.f1978b = i2;
        this.f1977a = i3;
    }

    public final boolean d() {
        return this.c == 2;
    }

    public final boolean e() {
        return this.c == 3;
    }

    public final boolean f() {
        return this.c == 0;
    }

    public final boolean g() {
        return this.c == 4;
    }

    public final boolean h() {
        return this.c == 5;
    }
}
