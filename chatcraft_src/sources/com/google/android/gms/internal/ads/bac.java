package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class bac implements Parcelable.Creator<bab> {
    bac() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ bab[] newArray(int i) {
        return new bab[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ bab createFromParcel(Parcel parcel) {
        return new bab(parcel);
    }
}
