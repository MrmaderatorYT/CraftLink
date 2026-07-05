package com.google.android.gms.internal.ads;

import android.os.Parcel;

@qj
/* loaded from: classes.dex */
public final class bua extends bqn {
    public bua(bqn bqnVar) {
        super(bqnVar.f2974a, bqnVar.f2975b, bqnVar.c, bqnVar.d, bqnVar.e, bqnVar.f, bqnVar.g, bqnVar.h, bqnVar.i, bqnVar.j);
    }

    @Override // com.google.android.gms.internal.ads.bqn, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f2974a, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.f2975b);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, this.e);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
