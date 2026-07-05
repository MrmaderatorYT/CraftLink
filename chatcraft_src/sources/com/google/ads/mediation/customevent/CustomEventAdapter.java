package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.a;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.ads.aan;

@KeepName
/* loaded from: classes.dex */
public final class CustomEventAdapter implements MediationBannerAdapter<com.google.android.gms.ads.mediation.customevent.c, d>, MediationInterstitialAdapter<com.google.android.gms.ads.mediation.customevent.c, d> {

    /* renamed from: a, reason: collision with root package name */
    private View f1452a;

    /* renamed from: b, reason: collision with root package name */
    private CustomEventBanner f1453b;
    private CustomEventInterstitial c;

    static final class a implements com.google.ads.mediation.customevent.b {

        /* renamed from: a, reason: collision with root package name */
        private final CustomEventAdapter f1454a;

        /* renamed from: b, reason: collision with root package name */
        private final com.google.ads.mediation.c f1455b;

        public a(CustomEventAdapter customEventAdapter, com.google.ads.mediation.c cVar) {
            this.f1454a = customEventAdapter;
            this.f1455b = cVar;
        }
    }

    class b implements c {

        /* renamed from: a, reason: collision with root package name */
        private final CustomEventAdapter f1456a;

        /* renamed from: b, reason: collision with root package name */
        private final com.google.ads.mediation.d f1457b;

        public b(CustomEventAdapter customEventAdapter, com.google.ads.mediation.d dVar) {
            this.f1456a = customEventAdapter;
            this.f1457b = dVar;
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

    @Override // com.google.ads.mediation.b
    public final void destroy() {
        if (this.f1453b != null) {
            this.f1453b.a();
        }
        if (this.c != null) {
            this.c.a();
        }
    }

    @Override // com.google.ads.mediation.b
    public final Class<com.google.android.gms.ads.mediation.customevent.c> getAdditionalParametersType() {
        return com.google.android.gms.ads.mediation.customevent.c.class;
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter
    public final View getBannerView() {
        return this.f1452a;
    }

    @Override // com.google.ads.mediation.b
    public final Class<d> getServerParametersType() {
        return d.class;
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter
    public final void requestBannerAd(com.google.ads.mediation.c cVar, Activity activity, d dVar, com.google.ads.b bVar, com.google.ads.mediation.a aVar, com.google.android.gms.ads.mediation.customevent.c cVar2) {
        this.f1453b = (CustomEventBanner) a(dVar.f1459b);
        if (this.f1453b == null) {
            cVar.a(this, a.EnumC0064a.INTERNAL_ERROR);
        } else {
            this.f1453b.requestBannerAd(new a(this, cVar), activity, dVar.f1458a, dVar.c, bVar, aVar, cVar2 == null ? null : cVar2.a(dVar.f1458a));
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(com.google.ads.mediation.d dVar, Activity activity, d dVar2, com.google.ads.mediation.a aVar, com.google.android.gms.ads.mediation.customevent.c cVar) {
        this.c = (CustomEventInterstitial) a(dVar2.f1459b);
        if (this.c == null) {
            dVar.a(this, a.EnumC0064a.INTERNAL_ERROR);
        } else {
            this.c.requestInterstitialAd(new b(this, dVar), activity, dVar2.f1458a, dVar2.c, aVar, cVar == null ? null : cVar.a(dVar2.f1458a));
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        this.c.showInterstitial();
    }
}
