package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;

@qj
/* loaded from: classes.dex */
public class bqn extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<bqn> CREATOR = new bqo();

    /* renamed from: a, reason: collision with root package name */
    public final String f2974a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2975b;
    public final int c;
    public final boolean d;
    public final int e;
    public final int f;
    public final bqn[] g;
    public final boolean h;
    public final boolean i;
    public boolean j;

    public static int a(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int b(DisplayMetrics displayMetrics) {
        return (int) (c(displayMetrics) * displayMetrics.density);
    }

    private static int c(DisplayMetrics displayMetrics) {
        int i = (int) (displayMetrics.heightPixels / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public static bqn a(Context context) {
        return new bqn("320x50_mb", 0, 0, false, 0, 0, null, true, false, false);
    }

    public static bqn a() {
        return new bqn("reward_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    public bqn() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    public bqn(Context context, com.google.android.gms.ads.d dVar) {
        this(context, new com.google.android.gms.ads.d[]{dVar});
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public bqn(android.content.Context r13, com.google.android.gms.ads.d[] r14) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bqn.<init>(android.content.Context, com.google.android.gms.ads.d[]):void");
    }

    public bqn(bqn bqnVar, bqn[] bqnVarArr) {
        this(bqnVar.f2974a, bqnVar.f2975b, bqnVar.c, bqnVar.d, bqnVar.e, bqnVar.f, bqnVarArr, bqnVar.h, bqnVar.i, bqnVar.j);
    }

    bqn(String str, int i, int i2, boolean z, int i3, int i4, bqn[] bqnVarArr, boolean z2, boolean z3, boolean z4) {
        this.f2974a = str;
        this.f2975b = i;
        this.c = i2;
        this.d = z;
        this.e = i3;
        this.f = i4;
        this.g = bqnVarArr;
        this.h = z2;
        this.i = z3;
        this.j = z4;
    }

    public final com.google.android.gms.ads.d b() {
        return com.google.android.gms.ads.n.a(this.e, this.f2975b, this.f2974a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f2974a, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.f2975b);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, this.c);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, this.d);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, this.e);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 7, this.f);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 8, (Parcelable[]) this.g, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 9, this.h);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 10, this.i);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 11, this.j);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
