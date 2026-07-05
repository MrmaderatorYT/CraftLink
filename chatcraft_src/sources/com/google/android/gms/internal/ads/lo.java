package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.a;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.e;

@qj
/* loaded from: classes.dex */
public final class lo<NETWORK_EXTRAS extends com.google.ads.mediation.e, SERVER_PARAMETERS extends MediationServerParameters> implements com.google.ads.mediation.c, com.google.ads.mediation.d {

    /* renamed from: a, reason: collision with root package name */
    private final kq f3251a;

    public lo(kq kqVar) {
        this.f3251a = kqVar;
    }

    @Override // com.google.ads.mediation.c
    public final void a(MediationBannerAdapter<?, ?> mediationBannerAdapter, a.EnumC0064a enumC0064a) {
        String strValueOf = String.valueOf(enumC0064a);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error. ");
        sb.append(strValueOf);
        aan.b(sb.toString());
        bra.a();
        if (!aac.b()) {
            aan.d("#008 Must be called on the main UI thread.", null);
            aac.f1778a.post(new lp(this, enumC0064a));
        } else {
            try {
                this.f3251a.a(lr.a(enumC0064a));
            } catch (RemoteException e) {
                aan.d("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.d
    public final void a(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, a.EnumC0064a enumC0064a) {
        String strValueOf = String.valueOf(enumC0064a);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error ");
        sb.append(strValueOf);
        sb.append(".");
        aan.b(sb.toString());
        bra.a();
        if (!aac.b()) {
            aan.d("#008 Must be called on the main UI thread.", null);
            aac.f1778a.post(new lq(this, enumC0064a));
        } else {
            try {
                this.f3251a.a(lr.a(enumC0064a));
            } catch (RemoteException e) {
                aan.d("#007 Could not call remote method.", e);
            }
        }
    }
}
