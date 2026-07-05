package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

@qj
/* loaded from: classes.dex */
public final class bqc extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<bqc> CREATOR = new bqd();

    /* renamed from: a, reason: collision with root package name */
    private final String f2965a;

    /* renamed from: b, reason: collision with root package name */
    private final String f2966b;

    public bqc(String str, String str2) {
        this.f2965a = str;
        this.f2966b = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f2965a, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f2966b, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
