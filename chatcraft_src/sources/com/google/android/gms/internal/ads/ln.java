package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class ln<NETWORK_EXTRAS extends com.google.ads.mediation.e, SERVER_PARAMETERS extends MediationServerParameters> extends ko {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.ads.mediation.b<NETWORK_EXTRAS, SERVER_PARAMETERS> f3249a;

    /* renamed from: b, reason: collision with root package name */
    private final NETWORK_EXTRAS f3250b;

    public ln(com.google.ads.mediation.b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar, NETWORK_EXTRAS network_extras) {
        this.f3249a = bVar;
        this.f3250b = network_extras;
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(com.google.android.gms.dynamic.a aVar) {
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(com.google.android.gms.dynamic.a aVar, bqj bqjVar, String str, vc vcVar, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(com.google.android.gms.dynamic.a aVar, bqj bqjVar, String str, String str2, kq kqVar, br brVar, List<String> list) {
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(com.google.android.gms.dynamic.a aVar, vc vcVar, List<String> list) {
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(bqj bqjVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(bqj bqjVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void f() {
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final boolean g() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final kw h() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final kz i() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final boolean m() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final cz n() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final bsw o() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final lc p() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final com.google.android.gms.dynamic.a a() throws RemoteException {
        if (!(this.f3249a instanceof MediationBannerAdapter)) {
            String strValueOf = String.valueOf(this.f3249a.getClass().getCanonicalName());
            aan.e(strValueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(strValueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return com.google.android.gms.dynamic.b.a(((MediationBannerAdapter) this.f3249a).getBannerView());
        } catch (Throwable th) {
            aan.b(BuildConfig.FLAVOR, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(com.google.android.gms.dynamic.a aVar, bqn bqnVar, bqj bqjVar, String str, kq kqVar) throws RemoteException {
        a(aVar, bqnVar, bqjVar, str, null, kqVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.kn
    public final void a(com.google.android.gms.dynamic.a aVar, bqn bqnVar, bqj bqjVar, String str, String str2, kq kqVar) throws RemoteException {
        com.google.ads.b bVar;
        if (!(this.f3249a instanceof MediationBannerAdapter)) {
            String strValueOf = String.valueOf(this.f3249a.getClass().getCanonicalName());
            aan.e(strValueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(strValueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        aan.b("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.f3249a;
            lo loVar = new lo(kqVar);
            Activity activity = (Activity) com.google.android.gms.dynamic.b.a(aVar);
            MediationServerParameters mediationServerParametersA = a(str, bqjVar.g, str2);
            int i = 0;
            com.google.ads.b[] bVarArr = {com.google.ads.b.f1441a, com.google.ads.b.f1442b, com.google.ads.b.c, com.google.ads.b.d, com.google.ads.b.e, com.google.ads.b.f};
            while (true) {
                if (i < 6) {
                    if (bVarArr[i].a() == bqnVar.e && bVarArr[i].b() == bqnVar.f2975b) {
                        bVar = bVarArr[i];
                        break;
                    }
                    i++;
                } else {
                    bVar = new com.google.ads.b(com.google.android.gms.ads.n.a(bqnVar.e, bqnVar.f2975b, bqnVar.f2974a));
                    break;
                }
            }
            mediationBannerAdapter.requestBannerAd(loVar, activity, mediationServerParametersA, bVar, lr.a(bqjVar, a(bqjVar)), this.f3250b);
        } catch (Throwable th) {
            aan.b(BuildConfig.FLAVOR, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final Bundle j() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void a(com.google.android.gms.dynamic.a aVar, bqj bqjVar, String str, kq kqVar) throws RemoteException {
        a(aVar, bqjVar, str, (String) null, kqVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.kn
    public final void a(com.google.android.gms.dynamic.a aVar, bqj bqjVar, String str, String str2, kq kqVar) throws RemoteException {
        if (!(this.f3249a instanceof MediationInterstitialAdapter)) {
            String strValueOf = String.valueOf(this.f3249a.getClass().getCanonicalName());
            aan.e(strValueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(strValueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        aan.b("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.f3249a).requestInterstitialAd(new lo(kqVar), (Activity) com.google.android.gms.dynamic.b.a(aVar), a(str, bqjVar.g, str2), lr.a(bqjVar, a(bqjVar)), this.f3250b);
        } catch (Throwable th) {
            aan.b(BuildConfig.FLAVOR, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final Bundle k() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void b() throws RemoteException {
        if (!(this.f3249a instanceof MediationInterstitialAdapter)) {
            String strValueOf = String.valueOf(this.f3249a.getClass().getCanonicalName());
            aan.e(strValueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(strValueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        aan.b("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.f3249a).showInterstitial();
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
    public final void c() throws RemoteException {
        try {
            this.f3249a.destroy();
        } catch (Throwable th) {
            aan.b(BuildConfig.FLAVOR, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void d() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.kn
    public final void e() throws RemoteException {
        throw new RemoteException();
    }

    private final SERVER_PARAMETERS a(String str, int i, String str2) throws RemoteException {
        HashMap map;
        try {
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                map = new HashMap(jSONObject.length());
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.getString(next));
                }
            } else {
                map = new HashMap(0);
            }
            Class<SERVER_PARAMETERS> serverParametersType = this.f3249a.getServerParametersType();
            if (serverParametersType == null) {
                return null;
            }
            SERVER_PARAMETERS server_parametersNewInstance = serverParametersType.newInstance();
            server_parametersNewInstance.a(map);
            return server_parametersNewInstance;
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
