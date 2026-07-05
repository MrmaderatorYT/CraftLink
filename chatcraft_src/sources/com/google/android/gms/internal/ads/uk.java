package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

@qj
/* loaded from: classes.dex */
public final class uk extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<uk> CREATOR = new ul();

    /* renamed from: a, reason: collision with root package name */
    public final bqj f3489a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3490b;

    public uk(bqj bqjVar, String str) {
        this.f3489a = bqjVar;
        this.f3490b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, (Parcelable) this.f3489a, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.f3490b, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
