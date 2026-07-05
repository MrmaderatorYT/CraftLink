package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class bob implements Parcelable.Creator<boa> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ boa[] newArray(int i) {
        return new boa[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ boa createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            if (SafeParcelReader.a(iA) == 2) {
                parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.a(parcel, iA, ParcelFileDescriptor.CREATOR);
            } else {
                SafeParcelReader.b(parcel, iA);
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new boa(parcelFileDescriptor);
    }
}
