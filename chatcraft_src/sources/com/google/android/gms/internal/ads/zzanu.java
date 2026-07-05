package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.a.c;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;

@qj
/* loaded from: classes.dex */
public final class zzanu implements MediationInterstitialAdapter {

    /* renamed from: a, reason: collision with root package name */
    private Activity f3655a;

    /* renamed from: b, reason: collision with root package name */
    private com.google.android.gms.ads.mediation.d f3656b;
    private Uri c;

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(Context context, com.google.android.gms.ads.mediation.d dVar, Bundle bundle, com.google.android.gms.ads.mediation.a aVar, Bundle bundle2) {
        this.f3656b = dVar;
        if (this.f3656b == null) {
            aan.e("Listener not set for mediation. Returning.");
            return;
        }
        if (!(context instanceof Activity)) {
            aan.e("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.f3656b.a(this, 0);
            return;
        }
        if (!(com.google.android.gms.common.util.j.b() && am.a(context))) {
            aan.e("Default browser does not support custom tabs. Bailing out.");
            this.f3656b.a(this, 0);
            return;
        }
        String string = bundle.getString("tab_url");
        if (TextUtils.isEmpty(string)) {
            aan.e("The tab_url retrieved from mediation metadata is empty. Bailing out.");
            this.f3656b.a(this, 0);
        } else {
            this.f3655a = (Activity) context;
            this.c = Uri.parse(string);
            this.f3656b.a(this);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        androidx.browser.a.c cVarA = new c.a().a();
        cVarA.f489a.setData(this.c);
        xn.f3583a.post(new ms(this, new AdOverlayInfoParcel(new com.google.android.gms.ads.internal.overlay.c(cVarA.f489a), null, new mr(this), null, new aar(0, 0, false))));
        com.google.android.gms.ads.internal.ax.i().e();
    }

    @Override // com.google.android.gms.ads.mediation.b
    public final void onDestroy() {
        aan.b("Destroying AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.b
    public final void onPause() {
        aan.b("Pausing AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.b
    public final void onResume() {
        aan.b("Resuming AdMobCustomTabsAdapter adapter.");
    }
}
