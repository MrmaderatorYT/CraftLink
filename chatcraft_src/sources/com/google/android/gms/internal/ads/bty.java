package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

@qj
/* loaded from: classes.dex */
public final class bty extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<bty> CREATOR = new btz();

    /* renamed from: a, reason: collision with root package name */
    public final String f3030a;

    public bty(com.google.android.gms.ads.d.a aVar) {
        this.f3030a = aVar.a();
    }

    bty(String str) {
        this.f3030a = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 15, this.f3030a, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
