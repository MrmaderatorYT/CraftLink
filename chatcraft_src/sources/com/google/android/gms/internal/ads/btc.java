package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

@qj
/* loaded from: classes.dex */
public final class btc extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<btc> CREATOR = new btd();

    /* renamed from: a, reason: collision with root package name */
    public final int f3009a;

    public btc(int i) {
        this.f3009a = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f3009a);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
