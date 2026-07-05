package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
/* loaded from: classes.dex */
public final class v extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<v> CREATOR = new w();

    /* renamed from: a, reason: collision with root package name */
    private final int f1744a;

    v(int i) {
        this.f1744a = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f1744a);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
