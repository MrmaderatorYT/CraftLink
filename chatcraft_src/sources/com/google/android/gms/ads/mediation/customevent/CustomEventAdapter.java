package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.i;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.ads.aan;

@KeepName
/* loaded from: classes.dex */
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {

    /* renamed from: a, reason: collision with root package name */
    private View f1666a;

    /* renamed from: b, reason: collision with root package name */
    private CustomEventBanner f1667b;
    private CustomEventInterstitial c;
    private CustomEventNative d;

    static final class a implements com.google.android.gms.ads.mediation.customevent.b {

        /* renamed from: a, reason: collision with root package name */
        private final CustomEventAdapter f1668a;

        /* renamed from: b, reason: collision with root package name */
        private final com.google.android.gms.ads.mediation.c f1669b;

        public a(CustomEventAdapter customEventAdapter, com.google.android.gms.ads.mediation.c cVar) {
            this.f1668a = customEventAdapter;
            this.f1669b = cVar;
        }
    }

    class b implements d {

        /* renamed from: a, reason: collision with root package name */
        private final CustomEventAdapter f1670a;

        /* renamed from: b, reason: collision with root package name */
        private final com.google.android.gms.ads.mediation.d f1671b;

        public b(CustomEventAdapter customEventAdapter, com.google.android.gms.ads.mediation.d dVar) {
            this.f1670a = customEventAdapter;
            this.f1671b = dVar;
        }
    }

    static class c implements e {

        /* renamed from: a, reason: collision with root package name */
        private final CustomEventAdapter f1672a;

        /* renamed from: b, reason: collision with root package name */
        private final com.google.android.gms.ads.mediation.e f1673b;

        public c(CustomEventAdapter customEventAdapter, com.google.android.gms.ads.mediation.e eVar) {
            this.f1672a = customEventAdapter;
            this.f1673b = eVar;
        }
    }

    private static <T> T a(String str) {
        try {
            return (T) Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(message).length());
            sb.append("Could not instantiate custom event adapter: ");
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            aan.e(sb.toString());
            return null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.b
    public final void onDestroy() {
        if (this.f1667b != null) {
            this.f1667b.a();
        }
        if (this.c != null) {
            this.c.a();
        }
        if (this.d != null) {
            this.d.a();
        }
    }

    @Override // com.google.android.gms.ads.mediation.b
    public final void onPause() {
        if (this.f1667b != null) {
            this.f1667b.b();
        }
        if (this.c != null) {
            this.c.b();
        }
        if (this.d != null) {
            this.d.b();
        }
    }

    @Override // com.google.android.gms.ads.mediation.b
    public final void onResume() {
        if (this.f1667b != null) {
            this.f1667b.c();
        }
        if (this.c != null) {
            this.c.c();
        }
        if (this.d != null) {
            this.d.c();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public final View getBannerView() {
        return this.f1666a;
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public final void requestBannerAd(Context context, com.google.android.gms.ads.mediation.c cVar, Bundle bundle, com.google.android.gms.ads.d dVar, com.google.android.gms.ads.mediation.a aVar, Bundle bundle2) {
        this.f1667b = (CustomEventBanner) a(bundle.getString("class_name"));
        if (this.f1667b == null) {
            cVar.a(this, 0);
        } else {
            this.f1667b.requestBannerAd(context, new a(this, cVar), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), dVar, aVar, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(Context context, com.google.android.gms.ads.mediation.d dVar, Bundle bundle, com.google.android.gms.ads.mediation.a aVar, Bundle bundle2) {
        this.c = (CustomEventInterstitial) a(bundle.getString("class_name"));
        if (this.c == null) {
            dVar.a(this, 0);
        } else {
            this.c.requestInterstitialAd(context, new b(this, dVar), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), aVar, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public final void requestNativeAd(Context context, com.google.android.gms.ads.mediation.e eVar, Bundle bundle, i iVar, Bundle bundle2) {
        this.d = (CustomEventNative) a(bundle.getString("class_name"));
        if (this.d == null) {
            eVar.a(this, 0);
        } else {
            this.d.requestNativeAd(context, new c(this, eVar), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), iVar, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        this.c.showInterstitial();
    }
}
