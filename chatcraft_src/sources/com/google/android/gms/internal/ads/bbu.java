package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class bbu implements Parcelable.Creator<bbt> {
    bbu() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ bbt[] newArray(int i) {
        return new bbt[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ bbt createFromParcel(Parcel parcel) {
        return new bbt(parcel);
    }
}
