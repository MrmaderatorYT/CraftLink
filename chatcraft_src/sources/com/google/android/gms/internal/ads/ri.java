package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class ri extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<ri> CREATOR = new rk();
    public final long A;
    public final String B;
    public final float C;
    public final int D;
    public final int E;
    public final boolean F;
    public final boolean G;
    public final String H;
    public final boolean I;
    public final String J;
    public final boolean K;
    public final int L;
    public final Bundle M;
    public final String N;
    public final btc O;
    public final boolean P;
    public final Bundle Q;
    public final String R;
    public final String S;
    public final String T;
    public final boolean U;
    public final List<Integer> V;
    public final String W;
    public final List<String> X;
    public final int Y;
    public final boolean Z;

    /* renamed from: a, reason: collision with root package name */
    public final int f3422a;
    public final boolean aa;
    public final boolean ab;
    public final ArrayList<String> ac;
    public final String ad;
    public final ey ae;
    public final String af;
    public final Bundle ag;

    /* renamed from: b, reason: collision with root package name */
    public final Bundle f3423b;
    public final bqj c;
    public final bqn d;
    public final String e;
    public final ApplicationInfo f;
    public final PackageInfo g;
    public final String h;
    public final String i;
    public final String j;
    public final aar k;
    public final Bundle l;
    public final int m;
    public final List<String> n;
    public final Bundle o;
    public final boolean p;
    public final int q;
    public final int r;
    public final float s;
    public final String t;
    public final long u;
    public final String v;
    public final List<String> w;
    public final String x;
    public final br y;
    public final List<String> z;

    private ri(Bundle bundle, bqj bqjVar, bqn bqnVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, aar aarVar, Bundle bundle2, int i, List<String> list, List<String> list2, Bundle bundle3, boolean z, int i2, int i3, float f, String str5, long j, String str6, List<String> list3, String str7, br brVar, long j2, String str8, float f2, boolean z2, int i4, int i5, boolean z3, boolean z4, String str9, String str10, boolean z5, int i6, Bundle bundle4, String str11, btc btcVar, boolean z6, Bundle bundle5, String str12, String str13, String str14, boolean z7, List<Integer> list4, String str15, List<String> list5, int i7, boolean z8, boolean z9, boolean z10, ArrayList<String> arrayList, String str16, ey eyVar, String str17, Bundle bundle6) {
        this(24, bundle, bqjVar, bqnVar, str, applicationInfo, packageInfo, str2, str3, str4, aarVar, bundle2, i, list, bundle3, z, i2, i3, f, str5, j, str6, list3, str7, brVar, list2, j2, str8, f2, z2, i4, i5, z3, z4, str9, str10, z5, i6, bundle4, str11, btcVar, z6, bundle5, str12, str13, str14, z7, list4, str15, list5, i7, z8, z9, z10, arrayList, str16, eyVar, str17, bundle6);
    }

    public ri(rj rjVar, long j, String str, String str2, String str3, String str4) {
        this(rjVar.f3424a, rjVar.f3425b, rjVar.c, rjVar.d, rjVar.e, rjVar.f, (String) aaz.a(rjVar.Q, BuildConfig.FLAVOR), rjVar.g, rjVar.h, rjVar.j, rjVar.i, rjVar.k, rjVar.l, rjVar.m, rjVar.o, rjVar.p, rjVar.q, rjVar.r, rjVar.s, rjVar.t, rjVar.u, rjVar.v, rjVar.w, rjVar.x, rjVar.y, j, rjVar.z, rjVar.A, rjVar.B, rjVar.C, rjVar.D, rjVar.E, rjVar.F, (String) aaz.a(rjVar.G, BuildConfig.FLAVOR, 1L, TimeUnit.SECONDS), rjVar.H, rjVar.I, rjVar.J, rjVar.K, rjVar.L, rjVar.M, rjVar.N, rjVar.O, str, str2, str3, rjVar.P, rjVar.R, rjVar.S, rjVar.n, rjVar.T, rjVar.U, rjVar.V, rjVar.W, rjVar.X, rjVar.Y, rjVar.Z, str4, rjVar.aa);
    }

    ri(int i, Bundle bundle, bqj bqjVar, bqn bqnVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, aar aarVar, Bundle bundle2, int i2, List<String> list, Bundle bundle3, boolean z, int i3, int i4, float f, String str5, long j, String str6, List<String> list2, String str7, br brVar, List<String> list3, long j2, String str8, float f2, boolean z2, int i5, int i6, boolean z3, boolean z4, String str9, String str10, boolean z5, int i7, Bundle bundle4, String str11, btc btcVar, boolean z6, Bundle bundle5, String str12, String str13, String str14, boolean z7, List<Integer> list4, String str15, List<String> list5, int i8, boolean z8, boolean z9, boolean z10, ArrayList<String> arrayList, String str16, ey eyVar, String str17, Bundle bundle6) {
        List<String> listUnmodifiableList;
        List<String> listUnmodifiableList2;
        this.f3422a = i;
        this.f3423b = bundle;
        this.c = bqjVar;
        this.d = bqnVar;
        this.e = str;
        this.f = applicationInfo;
        this.g = packageInfo;
        this.h = str2;
        this.i = str3;
        this.j = str4;
        this.k = aarVar;
        this.l = bundle2;
        this.m = i2;
        this.n = list;
        if (list3 == null) {
            listUnmodifiableList = Collections.emptyList();
        } else {
            listUnmodifiableList = Collections.unmodifiableList(list3);
        }
        this.z = listUnmodifiableList;
        this.o = bundle3;
        this.p = z;
        this.q = i3;
        this.r = i4;
        this.s = f;
        this.t = str5;
        this.u = j;
        this.v = str6;
        if (list2 == null) {
            listUnmodifiableList2 = Collections.emptyList();
        } else {
            listUnmodifiableList2 = Collections.unmodifiableList(list2);
        }
        this.w = listUnmodifiableList2;
        this.x = str7;
        this.y = brVar;
        this.A = j2;
        this.B = str8;
        this.C = f2;
        this.I = z2;
        this.D = i5;
        this.E = i6;
        this.F = z3;
        this.G = z4;
        this.H = str9;
        this.J = str10;
        this.K = z5;
        this.L = i7;
        this.M = bundle4;
        this.N = str11;
        this.O = btcVar;
        this.P = z6;
        this.Q = bundle5;
        this.R = str12;
        this.S = str13;
        this.T = str14;
        this.U = z7;
        this.V = list4;
        this.W = str15;
        this.X = list5;
        this.Y = i8;
        this.Z = z8;
        this.aa = z9;
        this.ab = z10;
        this.ac = arrayList;
        this.ad = str16;
        this.ae = eyVar;
        this.af = str17;
        this.ag = bundle6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f3422a);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f3423b, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, (Parcelable) this.c, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, (Parcelable) this.d, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, this.e, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, (Parcelable) this.f, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 7, (Parcelable) this.g, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 8, this.h, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 9, this.i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 10, this.j, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 11, (Parcelable) this.k, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 12, this.l, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 13, this.m);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 14, this.n, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 15, this.o, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 16, this.p);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 18, this.q);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 19, this.r);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 20, this.s);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 21, this.t, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 25, this.u);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 26, this.v, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 27, this.w, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 28, this.x, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 29, (Parcelable) this.y, i, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 30, this.z, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 31, this.A);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 33, this.B, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 34, this.C);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 35, this.D);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 36, this.E);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 37, this.F);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 38, this.G);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 39, this.H, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 40, this.I);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 41, this.J, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 42, this.K);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 43, this.L);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 44, this.M, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 45, this.N, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 46, (Parcelable) this.O, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 47, this.P);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 48, this.Q, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 49, this.R, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 50, this.S, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 51, this.T, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 52, this.U);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 53, this.V, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 54, this.W, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 55, this.X, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 56, this.Y);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 57, this.Z);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 58, this.aa);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 59, this.ab);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 60, this.ac, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 61, this.ad, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 63, (Parcelable) this.ae, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 64, this.af, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 65, this.ag, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
