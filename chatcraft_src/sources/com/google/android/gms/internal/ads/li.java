package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class li extends ko {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.ads.mediation.b f3241a;

    /* renamed from: b, reason: collision with root package name */
    private lj f3242b;

    public li(com.google.android.gms.ads.mediation.b bVar) {
        this.f3241a = bVar;
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final com.google.android.gms.dynamic.a a() throws RemoteException {
        if (!(this.f3241a instanceof MediationBannerAdapter)) {
            String strValueOf = String.valueOf(this.f3241a.getClass().getCanonicalName());
            aan.e(strValueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(strValueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return com.google.android.gms.dynamic.b.a(((MediationBannerAdapter) this.f3241a).getBannerView());
        } catch (Throwable th) {
            aan.b(BuildConfig.FLAVOR, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(com.google.android.gms.dynamic.a aVar, bqn bqnVar, bqj bqjVar, String str, kq kqVar) throws RemoteException {
        a(aVar, bqnVar, bqjVar, str, null, kqVar);
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(com.google.android.gms.dynamic.a aVar, bqn bqnVar, bqj bqjVar, String str, String str2, kq kqVar) throws RemoteException {
        if (!(this.f3241a instanceof MediationBannerAdapter)) {
            String strValueOf = String.valueOf(this.f3241a.getClass().getCanonicalName());
            aan.e(strValueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(strValueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        aan.b("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.f3241a;
            mediationBannerAdapter.requestBannerAd((Context) com.google.android.gms.dynamic.b.a(aVar), new lj(kqVar), a(str, bqjVar, str2), com.google.android.gms.ads.n.a(bqnVar.e, bqnVar.f2975b, bqnVar.f2974a), new lh(bqjVar.f2970b == -1 ? null : new Date(bqjVar.f2970b), bqjVar.d, bqjVar.e != null ? new HashSet(bqjVar.e) : null, bqjVar.k, a(bqjVar), bqjVar.g, bqjVar.r), bqjVar.m != null ? bqjVar.m.getBundle(mediationBannerAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            aan.b(BuildConfig.FLAVOR, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final Bundle j() {
        if (!(this.f3241a instanceof zzbix)) {
            String strValueOf = String.valueOf(this.f3241a.getClass().getCanonicalName());
            aan.e(strValueOf.length() != 0 ? "Not a v2 MediationBannerAdapter: ".concat(strValueOf) : new String("Not a v2 MediationBannerAdapter: "));
            return new Bundle();
        }
        return ((zzbix) this.f3241a).zzuw();
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(com.google.android.gms.dynamic.a aVar, bqj bqjVar, String str, kq kqVar) throws RemoteException {
        a(aVar, bqjVar, str, (String) null, kqVar);
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(com.google.android.gms.dynamic.a aVar, bqj bqjVar, String str, String str2, kq kqVar) throws RemoteException {
        if (!(this.f3241a instanceof MediationInterstitialAdapter)) {
            String strValueOf = String.valueOf(this.f3241a.getClass().getCanonicalName());
            aan.e(strValueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(strValueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        aan.b("Requesting interstitial ad from adapter.");
        try {
            MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.f3241a;
            mediationInterstitialAdapter.requestInterstitialAd((Context) com.google.android.gms.dynamic.b.a(aVar), new lj(kqVar), a(str, bqjVar, str2), new lh(bqjVar.f2970b == -1 ? null : new Date(bqjVar.f2970b), bqjVar.d, bqjVar.e != null ? new HashSet(bqjVar.e) : null, bqjVar.k, a(bqjVar), bqjVar.g, bqjVar.r), bqjVar.m != null ? bqjVar.m.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            aan.b(BuildConfig.FLAVOR, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final Bundle k() {
        if (!(this.f3241a instanceof zzbiy)) {
            String strValueOf = String.valueOf(this.f3241a.getClass().getCanonicalName());
            aan.e(strValueOf.length() != 0 ? "Not a v2 MediationInterstitialAdapter: ".concat(strValueOf) : new String("Not a v2 MediationInterstitialAdapter: "));
            return new Bundle();
        }
        return ((zzbiy) this.f3241a).getInterstitialAdapterInfo();
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(com.google.android.gms.dynamic.a aVar, bqj bqjVar, String str, String str2, kq kqVar, br brVar, List<String> list) throws RemoteException {
        if (!(this.f3241a instanceof MediationNativeAdapter)) {
            String strValueOf = String.valueOf(this.f3241a.getClass().getCanonicalName());
            aan.e(strValueOf.length() != 0 ? "Not a MediationNativeAdapter: ".concat(strValueOf) : new String("Not a MediationNativeAdapter: "));
            throw new RemoteException();
        }
        try {
            MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) this.f3241a;
            lm lmVar = new lm(bqjVar.f2970b == -1 ? null : new Date(bqjVar.f2970b), bqjVar.d, bqjVar.e != null ? new HashSet(bqjVar.e) : null, bqjVar.k, a(bqjVar), bqjVar.g, brVar, list, bqjVar.r);
            Bundle bundle = bqjVar.m != null ? bqjVar.m.getBundle(mediationNativeAdapter.getClass().getName()) : null;
            this.f3242b = new lj(kqVar);
            mediationNativeAdapter.requestNativeAd((Context) com.google.android.gms.dynamic.b.a(aVar), this.f3242b, a(str, bqjVar, str2), lmVar, bundle);
        } catch (Throwable th) {
            aan.b(BuildConfig.FLAVOR, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final Bundle l() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final kw h() {
        com.google.android.gms.ads.mediation.f fVarA = this.f3242b.a();
        if (fVarA instanceof com.google.android.gms.ads.mediation.g) {
            return new lk((com.google.android.gms.ads.mediation.g) fVarA);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final lc p() {
        com.google.android.gms.ads.mediation.l lVarB = this.f3242b.b();
        if (lVarB != null) {
            return new lt(lVarB);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final kz i() {
        com.google.android.gms.ads.mediation.f fVarA = this.f3242b.a();
        if (fVarA instanceof com.google.android.gms.ads.mediation.h) {
            return new ll((com.google.android.gms.ads.mediation.h) fVarA);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final cz n() {
        com.google.android.gms.ads.b.i iVarC = this.f3242b.c();
        if (iVarC instanceof dc) {
            return ((dc) iVarC).b();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final boolean m() {
        return this.f3241a instanceof InitializableMediationRewardedVideoAdAdapter;
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(com.google.android.gms.dynamic.a aVar, bqj bqjVar, String str, vc vcVar, String str2) throws RemoteException {
        lh lhVar;
        Bundle bundle;
        if (!(this.f3241a instanceof MediationRewardedVideoAdAdapter)) {
            String strValueOf = String.valueOf(this.f3241a.getClass().getCanonicalName());
            aan.e(strValueOf.length() != 0 ? "Not a MediationRewardedVideoAdAdapter: ".concat(strValueOf) : new String("Not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        aan.b("Initialize rewarded video adapter.");
        try {
            MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.f3241a;
            Bundle bundleA = a(str2, bqjVar, (String) null);
            if (bqjVar != null) {
                lh lhVar2 = new lh(bqjVar.f2970b == -1 ? null : new Date(bqjVar.f2970b), bqjVar.d, bqjVar.e != null ? new HashSet(bqjVar.e) : null, bqjVar.k, a(bqjVar), bqjVar.g, bqjVar.r);
                bundle = bqjVar.m != null ? bqjVar.m.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null;
                lhVar = lhVar2;
            } else {
                lhVar = null;
                bundle = null;
            }
            mediationRewardedVideoAdAdapter.initialize((Context) com.google.android.gms.dynamic.b.a(aVar), lhVar, str, new vg(vcVar), bundleA, bundle);
        } catch (Throwable th) {
            aan.b(BuildConfig.FLAVOR, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(com.google.android.gms.dynamic.a aVar, vc vcVar, List<String> list) throws RemoteException {
        if (!(this.f3241a instanceof InitializableMediationRewardedVideoAdAdapter)) {
            String strValueOf = String.valueOf(this.f3241a.getClass().getCanonicalName());
            aan.e(strValueOf.length() != 0 ? "Not an InitializableMediationRewardedVideoAdAdapter: ".concat(strValueOf) : new String("Not an InitializableMediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        aan.b("Initialize rewarded video adapter.");
        try {
            InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.f3241a;
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next(), (bqj) null, (String) null));
            }
            initializableMediationRewardedVideoAdAdapter.initialize((Context) com.google.android.gms.dynamic.b.a(aVar), new vg(vcVar), arrayList);
        } catch (Throwable th) {
            aan.c("Could not initialize rewarded video adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(bqj bqjVar, String str) throws RemoteException {
        a(bqjVar, str, (String) null);
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(bqj bqjVar, String str, String str2) throws RemoteException {
        if (!(this.f3241a instanceof MediationRewardedVideoAdAdapter)) {
            String strValueOf = String.valueOf(this.f3241a.getClass().getCanonicalName());
            aan.e(strValueOf.length() != 0 ? "Not a MediationRewardedVideoAdAdapter: ".concat(strValueOf) : new String("Not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        aan.b("Requesting rewarded video ad from adapter.");
        try {
            MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.f3241a;
            mediationRewardedVideoAdAdapter.loadAd(new lh(bqjVar.f2970b == -1 ? null : new Date(bqjVar.f2970b), bqjVar.d, bqjVar.e != null ? new HashSet(bqjVar.e) : null, bqjVar.k, a(bqjVar), bqjVar.g, bqjVar.r), a(str, bqjVar, str2), bqjVar.m != null ? bqjVar.m.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            aan.b(BuildConfig.FLAVOR, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void f() throws RemoteException {
        if (!(this.f3241a instanceof MediationRewardedVideoAdAdapter)) {
            String strValueOf = String.valueOf(this.f3241a.getClass().getCanonicalName());
            aan.e(strValueOf.length() != 0 ? "Not a MediationRewardedVideoAdAdapter: ".concat(strValueOf) : new String("Not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        aan.b("Show rewarded video ad from adapter.");
        try {
            ((MediationRewardedVideoAdAdapter) this.f3241a).showVideo();
        } catch (Throwable th) {
            aan.b(BuildConfig.FLAVOR, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final boolean g() throws RemoteException {
        if (!(this.f3241a instanceof MediationRewardedVideoAdAdapter)) {
            String strValueOf = String.valueOf(this.f3241a.getClass().getCanonicalName());
            aan.e(strValueOf.length() != 0 ? "Not a MediationRewardedVideoAdAdapter: ".concat(strValueOf) : new String("Not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        aan.b("Check if adapter is initialized.");
        try {
            return ((MediationRewardedVideoAdAdapter) this.f3241a).isInitialized();
        } catch (Throwable th) {
            aan.b(BuildConfig.FLAVOR, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(boolean z) {
        if (!(this.f3241a instanceof com.google.android.gms.ads.mediation.k)) {
            String strValueOf = String.valueOf(this.f3241a.getClass().getCanonicalName());
            aan.d(strValueOf.length() != 0 ? "Not an OnImmersiveModeUpdatedListener: ".concat(strValueOf) : new String("Not an OnImmersiveModeUpdatedListener: "));
        } else {
            try {
                ((com.google.android.gms.ads.mediation.k) this.f3241a).onImmersiveModeUpdated(z);
            } catch (Throwable th) {
                aan.b(BuildConfig.FLAVOR, th);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final bsw o() {
        if (!(this.f3241a instanceof com.google.android.gms.ads.mediation.n)) {
            return null;
        }
        try {
            return ((com.google.android.gms.ads.mediation.n) this.f3241a).getVideoController();
        } catch (Throwable th) {
            aan.b(BuildConfig.FLAVOR, th);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void b() throws RemoteException {
        if (!(this.f3241a instanceof MediationInterstitialAdapter)) {
            String strValueOf = String.valueOf(this.f3241a.getClass().getCanonicalName());
            aan.e(strValueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(strValueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        aan.b("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.f3241a).showInterstitial();
        } catch (Throwable th) {
            aan.b(BuildConfig.FLAVOR, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void c() throws RemoteException {
        try {
            this.f3241a.onDestroy();
        } catch (Throwable th) {
            aan.b(BuildConfig.FLAVOR, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void d() throws RemoteException {
        try {
            this.f3241a.onPause();
        } catch (Throwable th) {
            aan.b(BuildConfig.FLAVOR, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void e() throws RemoteException {
        try {
            this.f3241a.onResume();
        } catch (Throwable th) {
            aan.b(BuildConfig.FLAVOR, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(com.google.android.gms.dynamic.a aVar) {
        Context context = (Context) com.google.android.gms.dynamic.b.a(aVar);
        if (this.f3241a instanceof com.google.android.gms.ads.mediation.j) {
            ((com.google.android.gms.ads.mediation.j) this.f3241a).a(context);
        }
    }

    private final Bundle a(String str, bqj bqjVar, String str2) throws RemoteException {
        Bundle bundle;
        String strValueOf = String.valueOf(str);
        aan.e(strValueOf.length() != 0 ? "Server parameters: ".concat(strValueOf) : new String("Server parameters: "));
        try {
            Bundle bundle2 = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                bundle = new Bundle();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    bundle.putString(next, jSONObject.getString(next));
                }
            } else {
                bundle = bundle2;
            }
            if (this.f3241a instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (bqjVar != null) {
                    bundle.putInt("tagForChildDirectedTreatment", bqjVar.g);
                }
            }
            return bundle;
        } catch (Throwable th) {
            aan.b(BuildConfig.FLAVOR, th);
            throw new RemoteException();
        }
    }

    private static boolean a(bqj bqjVar) {
        if (bqjVar.f) {
            return true;
        }
        bra.a();
        return aac.a();
    }
}
