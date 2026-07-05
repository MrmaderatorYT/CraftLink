package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.bbt;

/* loaded from: classes.dex */
final class bbv implements Parcelable.Creator<bbt.a> {
    bbv() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ bbt.a[] newArray(int i) {
        return new bbt.a[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ bbt.a createFromParcel(Parcel parcel) {
        return new bbt.a(parcel);
    }
}
