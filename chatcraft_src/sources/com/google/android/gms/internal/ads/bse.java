package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;

/* loaded from: classes.dex */
public abstract class bse extends azg implements bsd {
    public bse() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    public static bsd asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
        if (iInterfaceQueryLocalInterface instanceof bsd) {
            return (bsd) iInterfaceQueryLocalInterface;
        }
        return new bsf(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.azg
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                brs brsVarCreateBannerAdManager = createBannerAdManager(a.AbstractBinderC0069a.a(parcel.readStrongBinder()), (bqn) azh.a(parcel, bqn.CREATOR), parcel.readString(), kl.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                azh.a(parcel2, brsVarCreateBannerAdManager);
                return true;
            case 2:
                brs brsVarCreateInterstitialAdManager = createInterstitialAdManager(a.AbstractBinderC0069a.a(parcel.readStrongBinder()), (bqn) azh.a(parcel, bqn.CREATOR), parcel.readString(), kl.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                azh.a(parcel2, brsVarCreateInterstitialAdManager);
                return true;
            case 3:
                brn brnVarCreateAdLoaderBuilder = createAdLoaderBuilder(a.AbstractBinderC0069a.a(parcel.readStrongBinder()), parcel.readString(), kl.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                azh.a(parcel2, brnVarCreateAdLoaderBuilder);
                return true;
            case 4:
                bsk mobileAdsSettingsManager = getMobileAdsSettingsManager(a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                azh.a(parcel2, mobileAdsSettingsManager);
                return true;
            case 5:
                ch chVarCreateNativeAdViewDelegate = createNativeAdViewDelegate(a.AbstractBinderC0069a.a(parcel.readStrongBinder()), a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                azh.a(parcel2, chVarCreateNativeAdViewDelegate);
                return true;
            case 6:
                ty tyVarCreateRewardedVideoAd = createRewardedVideoAd(a.AbstractBinderC0069a.a(parcel.readStrongBinder()), kl.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                azh.a(parcel2, tyVarCreateRewardedVideoAd);
                return true;
            case 7:
                nw nwVarCreateInAppPurchaseManager = createInAppPurchaseManager(a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                azh.a(parcel2, nwVarCreateInAppPurchaseManager);
                return true;
            case 8:
                nm nmVarCreateAdOverlay = createAdOverlay(a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                azh.a(parcel2, nmVarCreateAdOverlay);
                return true;
            case 9:
                bsk mobileAdsSettingsManagerWithClientJarVersion = getMobileAdsSettingsManagerWithClientJarVersion(a.AbstractBinderC0069a.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                azh.a(parcel2, mobileAdsSettingsManagerWithClientJarVersion);
                return true;
            case 10:
                brs brsVarCreateSearchAdManager = createSearchAdManager(a.AbstractBinderC0069a.a(parcel.readStrongBinder()), (bqn) azh.a(parcel, bqn.CREATOR), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                azh.a(parcel2, brsVarCreateSearchAdManager);
                return true;
            case 11:
                cm cmVarCreateNativeAdViewHolderDelegate = createNativeAdViewHolderDelegate(a.AbstractBinderC0069a.a(parcel.readStrongBinder()), a.AbstractBinderC0069a.a(parcel.readStrongBinder()), a.AbstractBinderC0069a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                azh.a(parcel2, cmVarCreateNativeAdViewHolderDelegate);
                return true;
            case 12:
                ty tyVarCreateRewardedVideoAdSku = createRewardedVideoAdSku(a.AbstractBinderC0069a.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                azh.a(parcel2, tyVarCreateRewardedVideoAdSku);
                return true;
            default:
                return false;
        }
    }
}
