package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class bbe implements ab {

    /* renamed from: a, reason: collision with root package name */
    private int f2484a;

    /* renamed from: b, reason: collision with root package name */
    private int f2485b;
    private final int c;
    private final float d;

    public bbe() {
        this(2500, 1, 1.0f);
    }

    private bbe(int i, int i2, float f) {
        this.f2484a = 2500;
        this.c = 1;
        this.d = 1.0f;
    }

    @Override // com.google.android.gms.internal.ads.ab
    public final int a() {
        return this.f2484a;
    }

    @Override // com.google.android.gms.internal.ads.ab
    public final int b() {
        return this.f2485b;
    }

    @Override // com.google.android.gms.internal.ads.ab
    public final void a(zzae zzaeVar) throws zzae {
        this.f2485b++;
        this.f2484a += (int) (this.f2484a * this.d);
        if (!(this.f2485b <= this.c)) {
            throw zzaeVar;
        }
    }
}
