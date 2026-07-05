package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class ber implements Parcelable.Creator<beq> {
    ber() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ beq[] newArray(int i) {
        return new beq[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ beq createFromParcel(Parcel parcel) {
        return new beq(parcel);
    }
}
