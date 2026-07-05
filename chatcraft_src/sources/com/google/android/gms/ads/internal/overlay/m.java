package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.ads.aar;

/* loaded from: classes.dex */
public final class m implements Parcelable.Creator<AdOverlayInfoParcel> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdOverlayInfoParcel[] newArray(int i) {
        return new AdOverlayInfoParcel[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdOverlayInfoParcel createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.b(parcel);
        c cVar = null;
        IBinder iBinderH = null;
        IBinder iBinderH2 = null;
        IBinder iBinderH3 = null;
        IBinder iBinderH4 = null;
        String strG = null;
        String strG2 = null;
        IBinder iBinderH5 = null;
        String strG3 = null;
        aar aarVar = null;
        String strG4 = null;
        com.google.android.gms.ads.internal.r rVar = null;
        IBinder iBinderH6 = null;
        boolean zC = false;
        int iD = 0;
        int iD2 = 0;
        while (parcel.dataPosition() < iB) {
            int iA = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(iA)) {
                case 2:
                    cVar = (c) SafeParcelReader.a(parcel, iA, c.CREATOR);
                    break;
                case 3:
                    iBinderH = SafeParcelReader.h(parcel, iA);
                    break;
                case 4:
                    iBinderH2 = SafeParcelReader.h(parcel, iA);
                    break;
                case 5:
                    iBinderH3 = SafeParcelReader.h(parcel, iA);
                    break;
                case 6:
                    iBinderH4 = SafeParcelReader.h(parcel, iA);
                    break;
                case 7:
                    strG = SafeParcelReader.g(parcel, iA);
                    break;
                case 8:
                    zC = SafeParcelReader.c(parcel, iA);
                    break;
                case 9:
                    strG2 = SafeParcelReader.g(parcel, iA);
                    break;
                case 10:
                    iBinderH5 = SafeParcelReader.h(parcel, iA);
                    break;
                case 11:
                    iD = SafeParcelReader.d(parcel, iA);
                    break;
                case 12:
                    iD2 = SafeParcelReader.d(parcel, iA);
                    break;
                case 13:
                    strG3 = SafeParcelReader.g(parcel, iA);
                    break;
                case 14:
                    aarVar = (aar) SafeParcelReader.a(parcel, iA, aar.CREATOR);
                    break;
                case 15:
                default:
                    SafeParcelReader.b(parcel, iA);
                    break;
                case 16:
                    strG4 = SafeParcelReader.g(parcel, iA);
                    break;
                case 17:
                    rVar = (com.google.android.gms.ads.internal.r) SafeParcelReader.a(parcel, iA, com.google.android.gms.ads.internal.r.CREATOR);
                    break;
                case 18:
                    iBinderH6 = SafeParcelReader.h(parcel, iA);
                    break;
            }
        }
        SafeParcelReader.n(parcel, iB);
        return new AdOverlayInfoParcel(cVar, iBinderH, iBinderH2, iBinderH3, iBinderH4, strG, zC, strG2, iBinderH5, iD, iD2, strG3, aarVar, strG4, rVar, iBinderH6);
    }
}
