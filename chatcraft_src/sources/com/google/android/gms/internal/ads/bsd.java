package com.google.android.gms.internal.ads;

import android.os.IInterface;

/* loaded from: classes.dex */
public interface bsd extends IInterface {
    brn createAdLoaderBuilder(com.google.android.gms.dynamic.a aVar, String str, kk kkVar, int i);

    nm createAdOverlay(com.google.android.gms.dynamic.a aVar);

    brs createBannerAdManager(com.google.android.gms.dynamic.a aVar, bqn bqnVar, String str, kk kkVar, int i);

    nw createInAppPurchaseManager(com.google.android.gms.dynamic.a aVar);

    brs createInterstitialAdManager(com.google.android.gms.dynamic.a aVar, bqn bqnVar, String str, kk kkVar, int i);

    ch createNativeAdViewDelegate(com.google.android.gms.dynamic.a aVar, com.google.android.gms.dynamic.a aVar2);

    cm createNativeAdViewHolderDelegate(com.google.android.gms.dynamic.a aVar, com.google.android.gms.dynamic.a aVar2, com.google.android.gms.dynamic.a aVar3);

    ty createRewardedVideoAd(com.google.android.gms.dynamic.a aVar, kk kkVar, int i);

    ty createRewardedVideoAdSku(com.google.android.gms.dynamic.a aVar, int i);

    brs createSearchAdManager(com.google.android.gms.dynamic.a aVar, bqn bqnVar, String str, int i);

    bsk getMobileAdsSettingsManager(com.google.android.gms.dynamic.a aVar);

    bsk getMobileAdsSettingsManagerWithClientJarVersion(com.google.android.gms.dynamic.a aVar, int i);
}
