package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

@qj
/* loaded from: classes.dex */
public final class aar extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<aar> CREATOR = new aas();

    /* renamed from: a, reason: collision with root package name */
    public String f1790a;

    /* renamed from: b, reason: collision with root package name */
    public int f1791b;
    public int c;
    public boolean d;
    public boolean e;

    public aar(int i, int i2, boolean z) {
        this(i, i2, z, false, false);
    }

    public aar(int i, int i2, boolean z, boolean z2) {
        this(14300000, i2, true, false, z2);
    }

    private aar(int i, int i2, boolean z, boolean z2, boolean z3) {
        String str = z ? "0" : "1";
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 36);
        sb.append("afma-sdk-a-v");
        sb.append(i);
        sb.append(".");
        sb.append(i2);
        sb.append(".");
        sb.append(str);
        this(sb.toString(), i, i2, z, z3);
    }

    aar(String str, int i, int i2, boolean z, boolean z2) {
        this.f1790a = str;
        this.f1791b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }

    public static aar a() {
        return new aar(12451009, 12451009, true);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f1790a, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.f1791b);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, this.c);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, this.d);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, this.e);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
