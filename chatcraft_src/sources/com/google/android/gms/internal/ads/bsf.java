package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class bsf extends azf implements bsd {
    bsf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.bsd
    public final brs createBannerAdManager(com.google.android.gms.dynamic.a aVar, bqn bqnVar, String str, kk kkVar, int i) {
        brs bruVar;
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        azh.a(parcelZ, bqnVar);
        parcelZ.writeString(str);
        azh.a(parcelZ, kkVar);
        parcelZ.writeInt(i);
        Parcel parcelA = a(1, parcelZ);
        IBinder strongBinder = parcelA.readStrongBinder();
        if (strongBinder == null) {
            bruVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (iInterfaceQueryLocalInterface instanceof brs) {
                bruVar = (brs) iInterfaceQueryLocalInterface;
            } else {
                bruVar = new bru(strongBinder);
            }
        }
        parcelA.recycle();
        return bruVar;
    }

    @Override // com.google.android.gms.internal.ads.bsd
    public final brs createInterstitialAdManager(com.google.android.gms.dynamic.a aVar, bqn bqnVar, String str, kk kkVar, int i) {
        brs bruVar;
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        azh.a(parcelZ, bqnVar);
        parcelZ.writeString(str);
        azh.a(parcelZ, kkVar);
        parcelZ.writeInt(i);
        Parcel parcelA = a(2, parcelZ);
        IBinder strongBinder = parcelA.readStrongBinder();
        if (strongBinder == null) {
            bruVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (iInterfaceQueryLocalInterface instanceof brs) {
                bruVar = (brs) iInterfaceQueryLocalInterface;
            } else {
                bruVar = new bru(strongBinder);
            }
        }
        parcelA.recycle();
        return bruVar;
    }

    @Override // com.google.android.gms.internal.ads.bsd
    public final brn createAdLoaderBuilder(com.google.android.gms.dynamic.a aVar, String str, kk kkVar, int i) {
        brn brpVar;
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        parcelZ.writeString(str);
        azh.a(parcelZ, kkVar);
        parcelZ.writeInt(i);
        Parcel parcelA = a(3, parcelZ);
        IBinder strongBinder = parcelA.readStrongBinder();
        if (strongBinder == null) {
            brpVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (iInterfaceQueryLocalInterface instanceof brn) {
                brpVar = (brn) iInterfaceQueryLocalInterface;
            } else {
                brpVar = new brp(strongBinder);
            }
        }
        parcelA.recycle();
        return brpVar;
    }

    @Override // com.google.android.gms.internal.ads.bsd
    public final bsk getMobileAdsSettingsManager(com.google.android.gms.dynamic.a aVar) {
        bsk bsmVar;
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        Parcel parcelA = a(4, parcelZ);
        IBinder strongBinder = parcelA.readStrongBinder();
        if (strongBinder == null) {
            bsmVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (iInterfaceQueryLocalInterface instanceof bsk) {
                bsmVar = (bsk) iInterfaceQueryLocalInterface;
            } else {
                bsmVar = new bsm(strongBinder);
            }
        }
        parcelA.recycle();
        return bsmVar;
    }

    @Override // com.google.android.gms.internal.ads.bsd
    public final ch createNativeAdViewDelegate(com.google.android.gms.dynamic.a aVar, com.google.android.gms.dynamic.a aVar2) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        azh.a(parcelZ, aVar2);
        Parcel parcelA = a(5, parcelZ);
        ch chVarA = ci.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return chVarA;
    }

    @Override // com.google.android.gms.internal.ads.bsd
    public final ty createRewardedVideoAd(com.google.android.gms.dynamic.a aVar, kk kkVar, int i) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        azh.a(parcelZ, kkVar);
        parcelZ.writeInt(i);
        Parcel parcelA = a(6, parcelZ);
        ty tyVarA = tz.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return tyVarA;
    }

    @Override // com.google.android.gms.internal.ads.bsd
    public final nw createInAppPurchaseManager(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        Parcel parcelA = a(7, parcelZ);
        nw nwVarA = ny.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return nwVarA;
    }

    @Override // com.google.android.gms.internal.ads.bsd
    public final nm createAdOverlay(com.google.android.gms.dynamic.a aVar) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        Parcel parcelA = a(8, parcelZ);
        nm nmVarA = nn.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return nmVarA;
    }

    @Override // com.google.android.gms.internal.ads.bsd
    public final bsk getMobileAdsSettingsManagerWithClientJarVersion(com.google.android.gms.dynamic.a aVar, int i) {
        bsk bsmVar;
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        parcelZ.writeInt(i);
        Parcel parcelA = a(9, parcelZ);
        IBinder strongBinder = parcelA.readStrongBinder();
        if (strongBinder == null) {
            bsmVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (iInterfaceQueryLocalInterface instanceof bsk) {
                bsmVar = (bsk) iInterfaceQueryLocalInterface;
            } else {
                bsmVar = new bsm(strongBinder);
            }
        }
        parcelA.recycle();
        return bsmVar;
    }

    @Override // com.google.android.gms.internal.ads.bsd
    public final brs createSearchAdManager(com.google.android.gms.dynamic.a aVar, bqn bqnVar, String str, int i) {
        brs bruVar;
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        azh.a(parcelZ, bqnVar);
        parcelZ.writeString(str);
        parcelZ.writeInt(i);
        Parcel parcelA = a(10, parcelZ);
        IBinder strongBinder = parcelA.readStrongBinder();
        if (strongBinder == null) {
            bruVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (iInterfaceQueryLocalInterface instanceof brs) {
                bruVar = (brs) iInterfaceQueryLocalInterface;
            } else {
                bruVar = new bru(strongBinder);
            }
        }
        parcelA.recycle();
        return bruVar;
    }

    @Override // com.google.android.gms.internal.ads.bsd
    public final cm createNativeAdViewHolderDelegate(com.google.android.gms.dynamic.a aVar, com.google.android.gms.dynamic.a aVar2, com.google.android.gms.dynamic.a aVar3) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        azh.a(parcelZ, aVar2);
        azh.a(parcelZ, aVar3);
        Parcel parcelA = a(11, parcelZ);
        cm cmVarA = cn.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return cmVarA;
    }

    @Override // com.google.android.gms.internal.ads.bsd
    public final ty createRewardedVideoAdSku(com.google.android.gms.dynamic.a aVar, int i) {
        Parcel parcelZ = z();
        azh.a(parcelZ, aVar);
        parcelZ.writeInt(i);
        Parcel parcelA = a(12, parcelZ);
        ty tyVarA = tz.a(parcelA.readStrongBinder());
        parcelA.recycle();
        return tyVarA;
    }
}
