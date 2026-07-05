package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class bep implements Parcelable.Creator<beo> {
    bep() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ beo[] newArray(int i) {
        return new beo[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ beo createFromParcel(Parcel parcel) {
        return new beo(parcel);
    }
}
