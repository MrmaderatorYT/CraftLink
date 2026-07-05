package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class bkl implements Parcelable.Creator<bkk> {
    bkl() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ bkk[] newArray(int i) {
        return new bkk[0];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ bkk createFromParcel(Parcel parcel) {
        return new bkk(parcel);
    }
}
