package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
/* loaded from: classes.dex */
public final class vg implements com.google.android.gms.ads.reward.mediation.a {

    /* renamed from: a, reason: collision with root package name */
    private final vc f3517a;

    public vg(vc vcVar) {
        this.f3517a = vcVar;
    }

    @Override // com.google.android.gms.ads.reward.mediation.a
    public final void a(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onInitializationSucceeded.");
        try {
            this.f3517a.a(com.google.android.gms.dynamic.b.a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.a
    public final void b(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onAdLoaded.");
        try {
            this.f3517a.b(com.google.android.gms.dynamic.b.a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.a
    public final void c(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onAdOpened.");
        try {
            this.f3517a.c(com.google.android.gms.dynamic.b.a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.a
    public final void d(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onVideoStarted.");
        try {
            this.f3517a.d(com.google.android.gms.dynamic.b.a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.a
    public final void e(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onAdClosed.");
        try {
            this.f3517a.e(com.google.android.gms.dynamic.b.a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.a
    public final void a(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, com.google.android.gms.ads.reward.b bVar) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onRewarded.");
        try {
            if (bVar != null) {
                this.f3517a.a(com.google.android.gms.dynamic.b.a(mediationRewardedVideoAdAdapter), new vh(bVar));
            } else {
                this.f3517a.a(com.google.android.gms.dynamic.b.a(mediationRewardedVideoAdAdapter), new vh(BuildConfig.FLAVOR, 1));
            }
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.a
    public final void a(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onAdFailedToLoad.");
        try {
            this.f3517a.b(com.google.android.gms.dynamic.b.a(mediationRewardedVideoAdAdapter), i);
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.a
    public final void f(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onAdLeftApplication.");
        try {
            this.f3517a.g(com.google.android.gms.dynamic.b.a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.a
    public final void g(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onVideoCompleted.");
        try {
            this.f3517a.h(com.google.android.gms.dynamic.b.a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.a
    public final void a(Bundle bundle) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        aan.b("Adapter called onAdMetadataChanged.");
        try {
            this.f3517a.a(bundle);
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }
}
