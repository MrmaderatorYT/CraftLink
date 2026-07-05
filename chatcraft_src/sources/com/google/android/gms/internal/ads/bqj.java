package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import javax.annotation.Nullable;

@qj
/* loaded from: classes.dex */
public final class bqj extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<bqj> CREATOR = new bql();

    /* renamed from: a, reason: collision with root package name */
    public final int f2969a;

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    public final long f2970b;
    public final Bundle c;

    @Deprecated
    public final int d;
    public final List<String> e;
    public final boolean f;
    public final int g;
    public final boolean h;
    public final String i;
    public final bty j;
    public final Location k;
    public final String l;
    public final Bundle m;
    public final Bundle n;
    public final List<String> o;
    public final String p;
    public final String q;

    @Deprecated
    public final boolean r;

    @Nullable
    public final bqc s;
    public final int t;

    @Nullable
    public final String u;

    public bqj(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, bty btyVar, Location location, String str2, Bundle bundle2, Bundle bundle3, List<String> list2, String str3, String str4, boolean z3, bqc bqcVar, int i4, @Nullable String str5) {
        this.f2969a = i;
        this.f2970b = j;
        this.c = bundle == null ? new Bundle() : bundle;
        this.d = i2;
        this.e = list;
        this.f = z;
        this.g = i3;
        this.h = z2;
        this.i = str;
        this.j = btyVar;
        this.k = location;
        this.l = str2;
        this.m = bundle2 == null ? new Bundle() : bundle2;
        this.n = bundle3;
        this.o = list2;
        this.p = str3;
        this.q = str4;
        this.r = z3;
        this.s = bqcVar;
        this.t = i4;
        this.u = str5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f2969a);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f2970b);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.c, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, this.d);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 5, this.e, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, this.f);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 7, this.g);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 8, this.h);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 9, this.i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 10, (Parcelable) this.j, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 11, (Parcelable) this.k, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 12, this.l, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 13, this.m, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 14, this.n, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 15, this.o, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 16, this.p, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 17, this.q, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 18, this.r);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 19, (Parcelable) this.s, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 20, this.t);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 21, this.u, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bqj)) {
            return false;
        }
        bqj bqjVar = (bqj) obj;
        return this.f2969a == bqjVar.f2969a && this.f2970b == bqjVar.f2970b && com.google.android.gms.common.internal.h.a(this.c, bqjVar.c) && this.d == bqjVar.d && com.google.android.gms.common.internal.h.a(this.e, bqjVar.e) && this.f == bqjVar.f && this.g == bqjVar.g && this.h == bqjVar.h && com.google.android.gms.common.internal.h.a(this.i, bqjVar.i) && com.google.android.gms.common.internal.h.a(this.j, bqjVar.j) && com.google.android.gms.common.internal.h.a(this.k, bqjVar.k) && com.google.android.gms.common.internal.h.a(this.l, bqjVar.l) && com.google.android.gms.common.internal.h.a(this.m, bqjVar.m) && com.google.android.gms.common.internal.h.a(this.n, bqjVar.n) && com.google.android.gms.common.internal.h.a(this.o, bqjVar.o) && com.google.android.gms.common.internal.h.a(this.p, bqjVar.p) && com.google.android.gms.common.internal.h.a(this.q, bqjVar.q) && this.r == bqjVar.r && this.t == bqjVar.t && com.google.android.gms.common.internal.h.a(this.u, bqjVar.u);
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.h.a(Integer.valueOf(this.f2969a), Long.valueOf(this.f2970b), this.c, Integer.valueOf(this.d), this.e, Boolean.valueOf(this.f), Integer.valueOf(this.g), Boolean.valueOf(this.h), this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, Boolean.valueOf(this.r), Integer.valueOf(this.t), this.u);
    }

    public final bqj a() {
        Bundle bundle = this.m.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle == null) {
            bundle = this.c;
            this.m.putBundle("com.google.ads.mediation.admob.AdMobAdapter", this.c);
        }
        return new bqj(this.f2969a, this.f2970b, bundle, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u);
    }
}
