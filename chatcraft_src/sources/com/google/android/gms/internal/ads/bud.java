package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class bud implements Parcelable.Creator<buc> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ buc[] newArray(int i) {
        return new buc[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ buc createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        boolean zC = false;
        boolean zC2 = false;
        boolean zC3 = false;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(iA)) {
                case 2:
                    zC = SafeParcelReader.c(parcel, iA);
                    break;
                case 3:
                    zC2 = SafeParcelReader.c(parcel, iA);
                    break;
                case 4:
                    zC3 = SafeParcelReader.c(parcel, iA);
                    break;
                default:
                    SafeParcelReader.b(parcel, iA);
                    break;
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new buc(zC, zC2, zC3);
    }
}
