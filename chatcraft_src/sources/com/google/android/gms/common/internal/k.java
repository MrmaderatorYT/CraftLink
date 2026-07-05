package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class k extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<k> CREATOR = new l();

    /* renamed from: a, reason: collision with root package name */
    Bundle f1734a;

    /* renamed from: b, reason: collision with root package name */
    com.google.android.gms.common.c[] f1735b;

    k(Bundle bundle, com.google.android.gms.common.c[] cVarArr) {
        this.f1734a = bundle;
        this.f1735b = cVarArr;
    }

    public k() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f1734a, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, (Parcelable[]) this.f1735b, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
