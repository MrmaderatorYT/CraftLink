package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class rm extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<rm> CREATOR = new rn();
    public final vh A;
    public final List<String> B;
    public final List<String> C;
    public final boolean D;
    public final ro E;
    public final boolean F;
    public String G;
    public final List<String> H;
    public final boolean I;
    public final String J;
    public final vs K;
    public final String L;
    public final boolean M;
    public final boolean N;
    public final boolean O;
    public final int P;
    public final boolean Q;
    public final List<String> R;
    public final boolean S;
    public final String T;
    public String U;
    public boolean V;
    private ri W;
    private final int X;
    private ry Y;
    private Bundle Z;

    /* renamed from: a, reason: collision with root package name */
    public final String f3427a;

    /* renamed from: b, reason: collision with root package name */
    public String f3428b;
    public final List<String> c;
    public final int d;
    public final List<String> e;
    public final long f;
    public final boolean g;
    public final long h;
    public final List<String> i;
    public final long j;
    public final int k;
    public final String l;
    public final long m;
    public final String n;
    public final boolean o;
    public final String p;
    public final String q;
    public final boolean r;
    public final boolean s;
    public final boolean t;
    public final boolean u;
    public final boolean v;
    public String w;
    public final String x;
    public final boolean y;
    public final boolean z;

    public rm(ri riVar, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str7, boolean z8, boolean z9, vh vhVar, List<String> list4, List<String> list5, boolean z10, ro roVar, boolean z11, String str8, List<String> list6, boolean z12, String str9, vs vsVar, String str10, boolean z13, boolean z14, boolean z15, int i2, boolean z16, List<String> list7, boolean z17, String str11, String str12, boolean z18) {
        this(19, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, null, null, str7, z8, z9, vhVar, list4, list5, z10, roVar, z11, str8, list6, z12, str9, vsVar, str10, z13, z14, null, z15, 0, z16, list7, z17, str11, str12, z18);
        this.W = riVar;
    }

    public rm(ri riVar, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, String str5, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str6, boolean z7, boolean z8, vh vhVar, List<String> list4, List<String> list5, boolean z9, ro roVar, boolean z10, String str7, List<String> list6, boolean z11, String str8, vs vsVar, String str9, boolean z12, boolean z13, boolean z14, int i2, boolean z15, List<String> list7, boolean z16, String str10, String str11, boolean z17) {
        this(19, str, str2, list, -2, list2, j, z, -1L, list3, j3, i, str3, j4, str4, false, null, str5, z2, z3, z4, z5, false, null, null, str6, z7, z8, vhVar, list4, list5, z9, roVar, z10, str7, list6, z11, str8, vsVar, str9, z12, z13, null, z14, i2, z15, list7, z16, str10, str11, z17);
        this.W = riVar;
    }

    public rm(int i) {
        this(19, null, null, null, i, null, -1L, false, -1L, null, -1L, -1, null, -1L, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, false, null, null, null, true, false, null, false, 0, false, null, false, null, null, false);
    }

    public rm(int i, long j) {
        this(19, null, null, null, i, null, -1L, false, -1L, null, j, -1, null, -1L, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, false, null, null, null, true, false, null, false, 0, false, null, false, null, null, false);
    }

    rm(int i, String str, String str2, List<String> list, int i2, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i3, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, ry ryVar, String str7, String str8, boolean z8, boolean z9, vh vhVar, List<String> list4, List<String> list5, boolean z10, ro roVar, boolean z11, String str9, List<String> list6, boolean z12, String str10, vs vsVar, String str11, boolean z13, boolean z14, Bundle bundle, boolean z15, int i4, boolean z16, List<String> list7, boolean z17, String str12, String str13, boolean z18) {
        sn snVar;
        this.X = i;
        this.f3427a = str;
        this.f3428b = str2;
        this.c = list != null ? Collections.unmodifiableList(list) : null;
        this.d = i2;
        this.e = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.f = j;
        this.g = z;
        this.h = j2;
        this.i = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.j = j3;
        this.k = i3;
        this.l = str3;
        this.m = j4;
        this.n = str4;
        this.o = z2;
        this.p = str5;
        this.q = str6;
        this.r = z3;
        this.s = z4;
        this.t = z5;
        this.u = z6;
        this.M = z13;
        this.v = z7;
        this.Y = ryVar;
        this.w = str7;
        this.x = str8;
        if (this.f3428b == null && this.Y != null && (snVar = (sn) this.Y.a(sn.CREATOR)) != null && !TextUtils.isEmpty(snVar.f3448a)) {
            this.f3428b = snVar.f3448a;
        }
        this.y = z8;
        this.z = z9;
        this.A = vhVar;
        this.B = list4;
        this.C = list5;
        this.D = z10;
        this.E = roVar;
        this.F = z11;
        this.G = str9;
        this.H = list6;
        this.I = z12;
        this.J = str10;
        this.K = vsVar;
        this.L = str11;
        this.N = z14;
        this.Z = bundle;
        this.O = z15;
        this.P = i4;
        this.Q = z16;
        this.R = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.S = z17;
        this.T = str12;
        this.U = str13;
        this.V = z18;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        if (this.W != null && this.W.f3422a >= 9 && !TextUtils.isEmpty(this.f3428b)) {
            this.Y = new ry(new sn(this.f3428b));
            this.f3428b = null;
        }
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.X);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f3427a, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.f3428b, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 4, this.c, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, this.d);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 6, this.e, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 7, this.f);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 8, this.g);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 9, this.h);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 10, this.i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 11, this.j);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 12, this.k);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 13, this.l, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 14, this.m);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 15, this.n, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 18, this.o);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 19, this.p, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 21, this.q, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 22, this.r);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 23, this.s);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 24, this.t);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 25, this.u);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 26, this.v);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 28, (Parcelable) this.Y, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 29, this.w, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 30, this.x, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 31, this.y);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 32, this.z);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 33, (Parcelable) this.A, i, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 34, this.B, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 35, this.C, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 36, this.D);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 37, (Parcelable) this.E, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 38, this.F);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 39, this.G, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 40, this.H, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 42, this.I);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 43, this.J, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 44, (Parcelable) this.K, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 45, this.L, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 46, this.M);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 47, this.N);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 48, this.Z, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 49, this.O);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 50, this.P);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 51, this.Q);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 52, this.R, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 53, this.S);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 54, this.T, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 55, this.U, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 56, this.V);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
