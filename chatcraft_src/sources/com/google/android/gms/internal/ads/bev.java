package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class bev implements Parcelable.Creator<beu> {
    bev() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ beu[] newArray(int i) {
        return new beu[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ beu createFromParcel(Parcel parcel) {
        return new beu(parcel);
    }
}
