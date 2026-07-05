package com.google.android.gms.internal.ads;

import java.util.Random;

/* loaded from: classes.dex */
final class gl extends bri {

    /* renamed from: a, reason: collision with root package name */
    private final brh f3100a;

    gl(brh brhVar) {
        this.f3100a = brhVar;
    }

    @Override // com.google.android.gms.internal.ads.brh
    public final void a() {
        if (gu.a()) {
            int iIntValue = ((Integer) bra.e().a(o.aK)).intValue();
            int iIntValue2 = ((Integer) bra.e().a(o.aL)).intValue();
            if (iIntValue <= 0 || iIntValue2 < 0) {
                com.google.android.gms.ads.internal.ax.s().a();
            } else {
                xn.f3583a.postDelayed(gm.f3101a, iIntValue + new Random().nextInt(iIntValue2 + 1));
            }
        }
        this.f3100a.a();
    }

    @Override // com.google.android.gms.internal.ads.brh
    public final void a(int i) {
        this.f3100a.a(i);
    }

    @Override // com.google.android.gms.internal.ads.brh
    public final void b() {
        this.f3100a.b();
    }

    @Override // com.google.android.gms.internal.ads.brh
    public final void c() {
        this.f3100a.c();
    }

    @Override // com.google.android.gms.internal.ads.brh
    public final void d() {
        this.f3100a.d();
    }

    @Override // com.google.android.gms.internal.ads.brh
    public final void e() {
        this.f3100a.e();
    }

    @Override // com.google.android.gms.internal.ads.brh
    public final void f() {
        this.f3100a.f();
    }
}
