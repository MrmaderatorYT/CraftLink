package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class rp implements Parcelable.Creator<ro> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ro[] newArray(int i) {
        return new ro[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ro createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        boolean zC = false;
        ArrayList<String> arrayListM = null;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(iA)) {
                case 2:
                    zC = SafeParcelReader.c(parcel, iA);
                    break;
                case 3:
                    arrayListM = SafeParcelReader.m(parcel, iA);
                    break;
                default:
                    SafeParcelReader.b(parcel, iA);
                    break;
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new ro(zC, arrayListM);
    }
}
