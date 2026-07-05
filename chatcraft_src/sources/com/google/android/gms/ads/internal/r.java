package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.qj;

@qj
/* loaded from: classes.dex */
public final class r extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<r> CREATOR = new s();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1647a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1648b;
    public final boolean c;
    public final float d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    private final String i;

    public r(boolean z, boolean z2, boolean z3, float f, int i, boolean z4, boolean z5, boolean z6) {
        this(z, z2, null, z3, f, i, z4, z5, z6);
    }

    r(boolean z, boolean z2, String str, boolean z3, float f, int i, boolean z4, boolean z5, boolean z6) {
        this.f1647a = z;
        this.f1648b = z2;
        this.i = str;
        this.c = z3;
        this.d = f;
        this.e = i;
        this.f = z4;
        this.g = z5;
        this.h = z6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f1647a);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.f1648b);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, this.i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, this.c);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, this.d);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 7, this.e);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 8, this.f);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 9, this.g);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 10, this.h);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
