package com.google.android.gms.internal.ads;

import android.os.Bundle;

@qj
/* loaded from: classes.dex */
public final class gr {

    /* renamed from: a, reason: collision with root package name */
    private static gr f3109a = new gr();

    /* renamed from: b, reason: collision with root package name */
    private int f3110b;
    private int c;
    private int d;
    private int e;
    private int f;

    public static gr a() {
        return f3109a;
    }

    final void a(int i) {
        this.f3110b += i;
    }

    final void b() {
        this.c++;
    }

    final void c() {
        this.d++;
    }

    final void d() {
        this.e++;
    }

    final void e() {
        this.f++;
    }

    public final int f() {
        return this.c;
    }

    public final int g() {
        return this.d;
    }

    public final int h() {
        return this.e;
    }

    public final int i() {
        return this.f;
    }

    public final Bundle j() {
        Bundle bundle = new Bundle();
        bundle.putInt("ipl", this.f3110b);
        bundle.putInt("ipds", this.c);
        bundle.putInt("ipde", this.d);
        bundle.putInt("iph", this.e);
        bundle.putInt("ipm", this.f);
        return bundle;
    }
}
