package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

@qj
/* loaded from: classes.dex */
public final class sn extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<sn> CREATOR = new so();

    /* renamed from: a, reason: collision with root package name */
    String f3448a;

    public sn(String str) {
        this.f3448a = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f3448a, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
