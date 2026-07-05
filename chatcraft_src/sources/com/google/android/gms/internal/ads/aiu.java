package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class aiu extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<aiu> CREATOR = new aiv();

    /* renamed from: a, reason: collision with root package name */
    private final int f2009a;

    /* renamed from: b, reason: collision with root package name */
    private final String f2010b;
    private final String c;

    aiu(int i, String str, String str2) {
        this.f2009a = i;
        this.f2010b = str;
        this.c = str2;
    }

    public aiu(String str, String str2) {
        this(1, str, str2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f2009a);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f2010b, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.c, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
