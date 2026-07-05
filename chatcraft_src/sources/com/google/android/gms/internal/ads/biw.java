package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class biw {

    /* renamed from: a, reason: collision with root package name */
    public final bgf f2715a;

    /* renamed from: b, reason: collision with root package name */
    public final bit f2716b;
    public final Object c;
    public final bai[] d;

    public biw(bgf bgfVar, bit bitVar, Object obj, bai[] baiVarArr) {
        this.f2715a = bgfVar;
        this.f2716b = bitVar;
        this.c = obj;
        this.d = baiVarArr;
    }

    public final boolean a(biw biwVar, int i) {
        return biwVar != null && bkg.a(this.f2716b.a(i), biwVar.f2716b.a(i)) && bkg.a(this.d[i], biwVar.d[i]);
    }
}
