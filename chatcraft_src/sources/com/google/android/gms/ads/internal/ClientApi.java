package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.ads.aar;
import com.google.android.gms.internal.ads.bqn;
import com.google.android.gms.internal.ads.brn;
import com.google.android.gms.internal.ads.brs;
import com.google.android.gms.internal.ads.bse;
import com.google.android.gms.internal.ads.bsk;
import com.google.android.gms.internal.ads.ch;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.nm;
import com.google.android.gms.internal.ads.nw;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.tp;
import com.google.android.gms.internal.ads.ty;
import com.google.android.gms.internal.ads.xn;
import java.util.HashMap;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@Keep
@DynamiteApi
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class ClientApi extends bse {
    @Override // com.google.android.gms.internal.ads.bsd
    public nw createInAppPurchaseManager(com.google.android.gms.dynamic.a aVar) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.bsd
    public ty createRewardedVideoAdSku(com.google.android.gms.dynamic.a aVar, int i) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.bsd
    public bsk getMobileAdsSettingsManager(com.google.android.gms.dynamic.a aVar) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.bsd
    public brs createBannerAdManager(com.google.android.gms.dynamic.a aVar, bqn bqnVar, String str, kk kkVar, int i) {
        Context context = (Context) com.google.android.gms.dynamic.b.a(aVar);
        ax.e();
        return new bv(context, bqnVar, str, kkVar, new aar(14300000, i, true, xn.l(context)), bt.a(context));
    }

    @Override // com.google.android.gms.internal.ads.bsd
    public brs createSearchAdManager(com.google.android.gms.dynamic.a aVar, bqn bqnVar, String str, int i) {
        Context context = (Context) com.google.android.gms.dynamic.b.a(aVar);
        ax.e();
        return new ar(context, bqnVar, str, new aar(14300000, i, true, xn.l(context)));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0036  */
    @Override // com.google.android.gms.internal.ads.bsd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.gms.internal.ads.brs createInterstitialAdManager(com.google.android.gms.dynamic.a r8, com.google.android.gms.internal.ads.bqn r9, java.lang.String r10, com.google.android.gms.internal.ads.kk r11, int r12) {
        /*
            r7 = this;
            java.lang.Object r8 = com.google.android.gms.dynamic.b.a(r8)
            r1 = r8
            android.content.Context r1 = (android.content.Context) r1
            com.google.android.gms.internal.ads.o.a(r1)
            com.google.android.gms.internal.ads.aar r5 = new com.google.android.gms.internal.ads.aar
            com.google.android.gms.ads.internal.ax.e()
            boolean r8 = com.google.android.gms.internal.ads.xn.l(r1)
            r0 = 1
            r2 = 14300000(0xda3360, float:2.0038568E-38)
            r5.<init>(r2, r12, r0, r8)
            java.lang.String r8 = "reward_mb"
            java.lang.String r12 = r9.f2974a
            boolean r8 = r8.equals(r12)
            if (r8 != 0) goto L36
            com.google.android.gms.internal.ads.d<java.lang.Boolean> r12 = com.google.android.gms.internal.ads.o.aC
            com.google.android.gms.internal.ads.l r2 = com.google.android.gms.internal.ads.bra.e()
            java.lang.Object r12 = r2.a(r12)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 != 0) goto L4c
        L36:
            if (r8 == 0) goto L4b
            com.google.android.gms.internal.ads.d<java.lang.Boolean> r8 = com.google.android.gms.internal.ads.o.aD
            com.google.android.gms.internal.ads.l r12 = com.google.android.gms.internal.ads.bra.e()
            java.lang.Object r8 = r12.a(r8)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L4b
            goto L4c
        L4b:
            r0 = 0
        L4c:
            if (r0 == 0) goto L5d
            com.google.android.gms.internal.ads.gs r8 = new com.google.android.gms.internal.ads.gs
            com.google.android.gms.ads.internal.bt r9 = com.google.android.gms.ads.internal.bt.a(r1)
            r0 = r8
            r2 = r10
            r3 = r11
            r4 = r5
            r5 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            return r8
        L5d:
            com.google.android.gms.ads.internal.m r8 = new com.google.android.gms.ads.internal.m
            com.google.android.gms.ads.internal.bt r6 = com.google.android.gms.ads.internal.bt.a(r1)
            r0 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.ClientApi.createInterstitialAdManager(com.google.android.gms.dynamic.a, com.google.android.gms.internal.ads.bqn, java.lang.String, com.google.android.gms.internal.ads.kk, int):com.google.android.gms.internal.ads.brs");
    }

    @Override // com.google.android.gms.internal.ads.bsd
    public brn createAdLoaderBuilder(com.google.android.gms.dynamic.a aVar, String str, kk kkVar, int i) {
        Context context = (Context) com.google.android.gms.dynamic.b.a(aVar);
        ax.e();
        return new l(context, str, kkVar, new aar(14300000, i, true, xn.l(context)), bt.a(context));
    }

    @Override // com.google.android.gms.internal.ads.bsd
    public bsk getMobileAdsSettingsManagerWithClientJarVersion(com.google.android.gms.dynamic.a aVar, int i) {
        Context context = (Context) com.google.android.gms.dynamic.b.a(aVar);
        ax.e();
        return z.a(context, new aar(14300000, i, true, xn.l(context)));
    }

    @Override // com.google.android.gms.internal.ads.bsd
    public ch createNativeAdViewDelegate(com.google.android.gms.dynamic.a aVar, com.google.android.gms.dynamic.a aVar2) {
        return new com.google.android.gms.internal.ads.bt((FrameLayout) com.google.android.gms.dynamic.b.a(aVar), (FrameLayout) com.google.android.gms.dynamic.b.a(aVar2));
    }

    @Override // com.google.android.gms.internal.ads.bsd
    public cm createNativeAdViewHolderDelegate(com.google.android.gms.dynamic.a aVar, com.google.android.gms.dynamic.a aVar2, com.google.android.gms.dynamic.a aVar3) {
        return new com.google.android.gms.internal.ads.bv((View) com.google.android.gms.dynamic.b.a(aVar), (HashMap) com.google.android.gms.dynamic.b.a(aVar2), (HashMap) com.google.android.gms.dynamic.b.a(aVar3));
    }

    @Override // com.google.android.gms.internal.ads.bsd
    public ty createRewardedVideoAd(com.google.android.gms.dynamic.a aVar, kk kkVar, int i) {
        Context context = (Context) com.google.android.gms.dynamic.b.a(aVar);
        ax.e();
        return new tp(context, bt.a(context), kkVar, new aar(14300000, i, true, xn.l(context)));
    }

    @Override // com.google.android.gms.internal.ads.bsd
    public nm createAdOverlay(com.google.android.gms.dynamic.a aVar) {
        Activity activity = (Activity) com.google.android.gms.dynamic.b.a(aVar);
        AdOverlayInfoParcel adOverlayInfoParcelA = AdOverlayInfoParcel.a(activity.getIntent());
        if (adOverlayInfoParcelA == null) {
            return new com.google.android.gms.ads.internal.overlay.r(activity);
        }
        switch (adOverlayInfoParcelA.k) {
        }
        return new com.google.android.gms.ads.internal.overlay.r(activity);
    }
}
