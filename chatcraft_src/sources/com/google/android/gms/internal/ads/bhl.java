package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class bhl implements bgv {

    /* renamed from: a, reason: collision with root package name */
    private final bjb f2671a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2672b;

    public bhl(bjb bjbVar) {
        this(bjbVar, 1);
    }

    private bhl(bjb bjbVar, int i) {
        this.f2671a = bjbVar;
        this.f2672b = 1;
    }

    @Override // com.google.android.gms.internal.ads.bgv
    public final bgu a(bjm bjmVar, bho bhoVar, int i, int[] iArr, bir birVar, int i2, long j, boolean z, boolean z2) {
        return new bhk(bjmVar, bhoVar, i, iArr, birVar, i2, this.f2671a.a(), j, this.f2672b, z, z2);
    }
}
