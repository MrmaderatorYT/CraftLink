package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;

@qj
/* loaded from: classes.dex */
public final class lj implements com.google.android.gms.ads.mediation.c, com.google.android.gms.ads.mediation.d, com.google.android.gms.ads.mediation.e {

    /* renamed from: a, reason: collision with root package name */
    private final kq f3243a;

    /* renamed from: b, reason: collision with root package name */
    private com.google.android.gms.ads.mediation.f f3244b;
    private com.google.android.gms.ads.mediation.l c;
    private com.google.android.gms.ads.b.i d;

    public lj(kq kqVar) {
        this.f3243a = kqVar;
    }

    @Override // com.google.android.gms.ads.mediation.c
    public final void a(MediationBannerAdapter mediationBannerAdapter, String str, String str2) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onAppEvent.");
        try {
            this.f3243a.a(str, str2);
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.c
    public final void e(MediationBannerAdapter mediationBannerAdapter) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onAdClicked.");
        try {
            this.f3243a.a();
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.c
    public final void c(MediationBannerAdapter mediationBannerAdapter) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onAdClosed.");
        try {
            this.f3243a.b();
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.c
    public final void a(MediationBannerAdapter mediationBannerAdapter, int i) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        StringBuilder sb = new StringBuilder(55);
        sb.append("Adapter called onAdFailedToLoad with error. ");
        sb.append(i);
        aan.b(sb.toString());
        try {
            this.f3243a.a(i);
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.c
    public final void d(MediationBannerAdapter mediationBannerAdapter) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onAdLeftApplication.");
        try {
            this.f3243a.c();
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.c
    public final void b(MediationBannerAdapter mediationBannerAdapter) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onAdOpened.");
        try {
            this.f3243a.d();
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.c
    public final void a(MediationBannerAdapter mediationBannerAdapter) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onAdLoaded.");
        try {
            this.f3243a.e();
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.d
    public final void e(MediationInterstitialAdapter mediationInterstitialAdapter) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onAdClicked.");
        try {
            this.f3243a.a();
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.d
    public final void c(MediationInterstitialAdapter mediationInterstitialAdapter) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onAdClosed.");
        try {
            this.f3243a.b();
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.d
    public final void a(MediationInterstitialAdapter mediationInterstitialAdapter, int i) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        StringBuilder sb = new StringBuilder(55);
        sb.append("Adapter called onAdFailedToLoad with error ");
        sb.append(i);
        sb.append(".");
        aan.b(sb.toString());
        try {
            this.f3243a.a(i);
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.d
    public final void d(MediationInterstitialAdapter mediationInterstitialAdapter) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onAdLeftApplication.");
        try {
            this.f3243a.c();
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.d
    public final void b(MediationInterstitialAdapter mediationInterstitialAdapter) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onAdOpened.");
        try {
            this.f3243a.d();
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.d
    public final void a(MediationInterstitialAdapter mediationInterstitialAdapter) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onAdLoaded.");
        try {
            this.f3243a.e();
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.e
    public final void a(MediationNativeAdapter mediationNativeAdapter, com.google.android.gms.ads.mediation.f fVar) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onAdLoaded.");
        this.f3244b = fVar;
        this.c = null;
        a(mediationNativeAdapter, this.c, this.f3244b);
        try {
            this.f3243a.e();
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.e
    public final void a(MediationNativeAdapter mediationNativeAdapter, com.google.android.gms.ads.mediation.l lVar) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onAdLoaded.");
        this.c = lVar;
        this.f3244b = null;
        a(mediationNativeAdapter, this.c, this.f3244b);
        try {
            this.f3243a.e();
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    private static void a(MediationNativeAdapter mediationNativeAdapter, com.google.android.gms.ads.mediation.l lVar, com.google.android.gms.ads.mediation.f fVar) {
        if (mediationNativeAdapter instanceof AdMobAdapter) {
            return;
        }
        com.google.android.gms.ads.j jVar = new com.google.android.gms.ads.j();
        jVar.a(new lg());
        if (lVar != null && lVar.k()) {
            lVar.a(jVar);
        }
        if (fVar == null || !fVar.h()) {
            return;
        }
        fVar.a(jVar);
    }

    @Override // com.google.android.gms.ads.mediation.e
    public final void a(MediationNativeAdapter mediationNativeAdapter, com.google.android.gms.ads.b.i iVar) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        String strValueOf = String.valueOf(iVar.a());
        aan.b(strValueOf.length() != 0 ? "Adapter called onAdLoaded with template id ".concat(strValueOf) : new String("Adapter called onAdLoaded with template id "));
        this.d = iVar;
        try {
            this.f3243a.e();
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.e
    public final void a(MediationNativeAdapter mediationNativeAdapter, com.google.android.gms.ads.b.i iVar, String str) {
        if (iVar instanceof dc) {
            try {
                this.f3243a.a(((dc) iVar).b(), str);
                return;
            } catch (RemoteException e) {
                aan.d("#007 Could not call remote method.", e);
                return;
            }
        }
        aan.e("Unexpected native custom template ad type.");
    }

    @Override // com.google.android.gms.ads.mediation.e
    public final void a(MediationNativeAdapter mediationNativeAdapter, int i) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        StringBuilder sb = new StringBuilder(55);
        sb.append("Adapter called onAdFailedToLoad with error ");
        sb.append(i);
        sb.append(".");
        aan.b(sb.toString());
        try {
            this.f3243a.a(i);
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.e
    public final void a(MediationNativeAdapter mediationNativeAdapter) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onAdOpened.");
        try {
            this.f3243a.d();
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.e
    public final void b(MediationNativeAdapter mediationNativeAdapter) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onAdClosed.");
        try {
            this.f3243a.b();
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.e
    public final void c(MediationNativeAdapter mediationNativeAdapter) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onAdLeftApplication.");
        try {
            this.f3243a.c();
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.e
    public final void d(MediationNativeAdapter mediationNativeAdapter) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.mediation.f fVar = this.f3244b;
        com.google.android.gms.ads.mediation.l lVar = this.c;
        if (this.d == null) {
            if (fVar == null && lVar == null) {
                aan.d("#007 Could not call remote method.", null);
                return;
            }
            if (lVar != null && !lVar.q()) {
                aan.b("Could not call onAdClicked since setOverrideClickHandling is not set to true");
                return;
            } else if (fVar != null && !fVar.b()) {
                aan.b("Could not call onAdClicked since setOverrideClickHandling is not set to true");
                return;
            }
        }
        aan.b("Adapter called onAdClicked.");
        try {
            this.f3243a.a();
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.e
    public final void e(MediationNativeAdapter mediationNativeAdapter) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.mediation.f fVar = this.f3244b;
        com.google.android.gms.ads.mediation.l lVar = this.c;
        if (this.d == null) {
            if (fVar == null && lVar == null) {
                aan.d("#007 Could not call remote method.", null);
                return;
            }
            if (lVar != null && !lVar.p()) {
                aan.b("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
                return;
            } else if (fVar != null && !fVar.a()) {
                aan.b("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
                return;
            }
        }
        aan.b("Adapter called onAdImpression.");
        try {
            this.f3243a.f();
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    public final com.google.android.gms.ads.mediation.f a() {
        return this.f3244b;
    }

    public final com.google.android.gms.ads.mediation.l b() {
        return this.c;
    }

    public final com.google.android.gms.ads.b.i c() {
        return this.d;
    }
}
