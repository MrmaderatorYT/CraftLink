package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.b;
import com.google.android.gms.ads.b.g;
import com.google.android.gms.ads.b.h;
import com.google.android.gms.ads.b.i;
import com.google.android.gms.ads.b.k;
import com.google.android.gms.ads.c;
import com.google.android.gms.ads.j;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.b;
import com.google.android.gms.ads.mediation.k;
import com.google.android.gms.ads.mediation.l;
import com.google.android.gms.ads.mediation.n;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.internal.ads.aac;
import com.google.android.gms.internal.ads.aan;
import com.google.android.gms.internal.ads.bqa;
import com.google.android.gms.internal.ads.bra;
import com.google.android.gms.internal.ads.bsw;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.zzbiy;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@qj
/* loaded from: classes.dex */
public abstract class AbstractAdViewAdapter implements com.google.android.gms.ads.mediation.MediationBannerAdapter, MediationNativeAdapter, k, n, MediationRewardedVideoAdAdapter, zzbiy {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    private AdView zzhs;
    private com.google.android.gms.ads.g zzht;
    private com.google.android.gms.ads.b zzhu;
    private Context zzhv;
    private com.google.android.gms.ads.g zzhw;
    private com.google.android.gms.ads.reward.mediation.a zzhx;
    private final com.google.android.gms.ads.reward.d zzhy = new com.google.ads.mediation.f(this);

    protected abstract Bundle zza(Bundle bundle, Bundle bundle2);

    private final com.google.android.gms.ads.c zza(Context context, com.google.android.gms.ads.mediation.a aVar, Bundle bundle, Bundle bundle2) {
        c.a aVar2 = new c.a();
        Date dateA = aVar.a();
        if (dateA != null) {
            aVar2.a(dateA);
        }
        int iB = aVar.b();
        if (iB != 0) {
            aVar2.a(iB);
        }
        Set<String> setC = aVar.c();
        if (setC != null) {
            Iterator<String> it = setC.iterator();
            while (it.hasNext()) {
                aVar2.a(it.next());
            }
        }
        Location locationD = aVar.d();
        if (locationD != null) {
            aVar2.a(locationD);
        }
        if (aVar.f()) {
            bra.a();
            aVar2.b(aac.a(context));
        }
        if (aVar.e() != -1) {
            aVar2.a(aVar.e() == 1);
        }
        aVar2.b(aVar.g());
        aVar2.a(AdMobAdapter.class, zza(bundle, bundle2));
        return aVar2.a();
    }

    static final class d extends com.google.android.gms.ads.a implements com.google.android.gms.ads.a.a, bqa {

        /* renamed from: a, reason: collision with root package name */
        private final AbstractAdViewAdapter f1444a;

        /* renamed from: b, reason: collision with root package name */
        private final com.google.android.gms.ads.mediation.c f1445b;

        public d(AbstractAdViewAdapter abstractAdViewAdapter, com.google.android.gms.ads.mediation.c cVar) {
            this.f1444a = abstractAdViewAdapter;
            this.f1445b = cVar;
        }

        @Override // com.google.android.gms.ads.a
        public final void a() {
            this.f1445b.a(this.f1444a);
        }

        @Override // com.google.android.gms.ads.a
        public final void a(int i) {
            this.f1445b.a(this.f1444a, i);
        }

        @Override // com.google.android.gms.ads.a
        public final void b() {
            this.f1445b.b(this.f1444a);
        }

        @Override // com.google.android.gms.ads.a
        public final void c() {
            this.f1445b.c(this.f1444a);
        }

        @Override // com.google.android.gms.ads.a
        public final void d() {
            this.f1445b.d(this.f1444a);
        }

        @Override // com.google.android.gms.ads.a, com.google.android.gms.internal.ads.bqa
        public final void e() {
            this.f1445b.e(this.f1444a);
        }

        @Override // com.google.android.gms.ads.a.a
        public final void a(String str, String str2) {
            this.f1445b.a(this.f1444a, str, str2);
        }
    }

    static final class e extends com.google.android.gms.ads.a implements bqa {

        /* renamed from: a, reason: collision with root package name */
        private final AbstractAdViewAdapter f1446a;

        /* renamed from: b, reason: collision with root package name */
        private final com.google.android.gms.ads.mediation.d f1447b;

        public e(AbstractAdViewAdapter abstractAdViewAdapter, com.google.android.gms.ads.mediation.d dVar) {
            this.f1446a = abstractAdViewAdapter;
            this.f1447b = dVar;
        }

        @Override // com.google.android.gms.ads.a
        public final void a() {
            this.f1447b.a(this.f1446a);
        }

        @Override // com.google.android.gms.ads.a
        public final void a(int i) {
            this.f1447b.a(this.f1446a, i);
        }

        @Override // com.google.android.gms.ads.a
        public final void b() {
            this.f1447b.b(this.f1446a);
        }

        @Override // com.google.android.gms.ads.a
        public final void c() {
            this.f1447b.c(this.f1446a);
        }

        @Override // com.google.android.gms.ads.a
        public final void d() {
            this.f1447b.d(this.f1446a);
        }

        @Override // com.google.android.gms.ads.a, com.google.android.gms.internal.ads.bqa
        public final void e() {
            this.f1447b.e(this.f1446a);
        }
    }

    static final class f extends com.google.android.gms.ads.a implements g.a, h.a, i.a, i.b, k.a {

        /* renamed from: a, reason: collision with root package name */
        private final AbstractAdViewAdapter f1448a;

        /* renamed from: b, reason: collision with root package name */
        private final com.google.android.gms.ads.mediation.e f1449b;

        public f(AbstractAdViewAdapter abstractAdViewAdapter, com.google.android.gms.ads.mediation.e eVar) {
            this.f1448a = abstractAdViewAdapter;
            this.f1449b = eVar;
        }

        @Override // com.google.android.gms.ads.a
        public final void a() {
        }

        @Override // com.google.android.gms.ads.a
        public final void a(int i) {
            this.f1449b.a(this.f1448a, i);
        }

        @Override // com.google.android.gms.ads.a
        public final void b() {
            this.f1449b.a(this.f1448a);
        }

        @Override // com.google.android.gms.ads.a
        public final void c() {
            this.f1449b.b(this.f1448a);
        }

        @Override // com.google.android.gms.ads.a
        public final void d() {
            this.f1449b.c(this.f1448a);
        }

        @Override // com.google.android.gms.ads.a, com.google.android.gms.internal.ads.bqa
        public final void e() {
            this.f1449b.d(this.f1448a);
        }

        @Override // com.google.android.gms.ads.a
        public final void f() {
            this.f1449b.e(this.f1448a);
        }

        @Override // com.google.android.gms.ads.b.g.a
        public final void a(com.google.android.gms.ads.b.g gVar) {
            this.f1449b.a(this.f1448a, new a(gVar));
        }

        @Override // com.google.android.gms.ads.b.k.a
        public final void a(com.google.android.gms.ads.b.k kVar) {
            this.f1449b.a(this.f1448a, new c(kVar));
        }

        @Override // com.google.android.gms.ads.b.h.a
        public final void a(h hVar) {
            this.f1449b.a(this.f1448a, new b(hVar));
        }

        @Override // com.google.android.gms.ads.b.i.b
        public final void a(i iVar) {
            this.f1449b.a(this.f1448a, iVar);
        }

        @Override // com.google.android.gms.ads.b.i.a
        public final void a(i iVar, String str) {
            this.f1449b.a(this.f1448a, iVar, str);
        }
    }

    static class b extends com.google.android.gms.ads.mediation.h {
        private final h e;

        public b(h hVar) {
            this.e = hVar;
            a(hVar.b().toString());
            a(hVar.c());
            b(hVar.d().toString());
            if (hVar.e() != null) {
                a(hVar.e());
            }
            c(hVar.f().toString());
            d(hVar.g().toString());
            a(true);
            b(true);
            a(hVar.h());
        }

        @Override // com.google.android.gms.ads.mediation.f
        public final void a(View view) {
            if (view instanceof com.google.android.gms.ads.b.e) {
                ((com.google.android.gms.ads.b.e) view).setNativeAd(this.e);
            }
            com.google.android.gms.ads.b.f fVar = com.google.android.gms.ads.b.f.f1476a.get(view);
            if (fVar != null) {
                fVar.a(this.e);
            }
        }
    }

    static class c extends l {

        /* renamed from: a, reason: collision with root package name */
        private final com.google.android.gms.ads.b.k f1443a;

        public c(com.google.android.gms.ads.b.k kVar) {
            this.f1443a = kVar;
            a(kVar.a());
            a(kVar.b());
            b(kVar.c());
            a(kVar.d());
            c(kVar.e());
            d(kVar.f());
            a(kVar.g());
            e(kVar.h());
            f(kVar.i());
            a(kVar.l());
            a(true);
            b(true);
            a(kVar.j());
        }

        @Override // com.google.android.gms.ads.mediation.l
        public final void a(View view, Map<String, View> map, Map<String, View> map2) {
            if (view instanceof com.google.android.gms.ads.b.l) {
                ((com.google.android.gms.ads.b.l) view).setNativeAd(this.f1443a);
                return;
            }
            com.google.android.gms.ads.b.f fVar = com.google.android.gms.ads.b.f.f1476a.get(view);
            if (fVar != null) {
                fVar.a(this.f1443a);
            }
        }
    }

    static class a extends com.google.android.gms.ads.mediation.g {
        private final com.google.android.gms.ads.b.g e;

        public a(com.google.android.gms.ads.b.g gVar) {
            this.e = gVar;
            a(gVar.b().toString());
            a(gVar.c());
            b(gVar.d().toString());
            a(gVar.e());
            c(gVar.f().toString());
            if (gVar.g() != null) {
                a(gVar.g().doubleValue());
            }
            if (gVar.h() != null) {
                d(gVar.h().toString());
            }
            if (gVar.i() != null) {
                e(gVar.i().toString());
            }
            a(true);
            b(true);
            a(gVar.j());
        }

        @Override // com.google.android.gms.ads.mediation.f
        public final void a(View view) {
            if (view instanceof com.google.android.gms.ads.b.e) {
                ((com.google.android.gms.ads.b.e) view).setNativeAd(this.e);
            }
            com.google.android.gms.ads.b.f fVar = com.google.android.gms.ads.b.f.f1476a.get(view);
            if (fVar != null) {
                fVar.a(this.e);
            }
        }
    }

    @Override // com.google.android.gms.ads.mediation.b
    public void onDestroy() {
        if (this.zzhs != null) {
            this.zzhs.c();
            this.zzhs = null;
        }
        if (this.zzht != null) {
            this.zzht = null;
        }
        if (this.zzhu != null) {
            this.zzhu = null;
        }
        if (this.zzhw != null) {
            this.zzhw = null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.b
    public void onPause() {
        if (this.zzhs != null) {
            this.zzhs.b();
        }
    }

    @Override // com.google.android.gms.ads.mediation.b
    public void onResume() {
        if (this.zzhs != null) {
            this.zzhs.a();
        }
    }

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public void requestBannerAd(Context context, com.google.android.gms.ads.mediation.c cVar, Bundle bundle, com.google.android.gms.ads.d dVar, com.google.android.gms.ads.mediation.a aVar, Bundle bundle2) {
        this.zzhs = new AdView(context);
        this.zzhs.setAdSize(new com.google.android.gms.ads.d(dVar.b(), dVar.a()));
        this.zzhs.setAdUnitId(getAdUnitId(bundle));
        this.zzhs.setAdListener(new d(this, cVar));
        this.zzhs.a(zza(context, aVar, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public View getBannerView() {
        return this.zzhs;
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void requestInterstitialAd(Context context, com.google.android.gms.ads.mediation.d dVar, Bundle bundle, com.google.android.gms.ads.mediation.a aVar, Bundle bundle2) {
        this.zzht = new com.google.android.gms.ads.g(context);
        this.zzht.a(getAdUnitId(bundle));
        this.zzht.a(new e(this, dVar));
        this.zzht.a(zza(context, aVar, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.k
    public void onImmersiveModeUpdated(boolean z) {
        if (this.zzht != null) {
            this.zzht.b(z);
        }
        if (this.zzhw != null) {
            this.zzhw.b(z);
        }
    }

    @Override // com.google.android.gms.ads.mediation.n
    public bsw getVideoController() {
        j videoController;
        if (this.zzhs == null || (videoController = this.zzhs.getVideoController()) == null) {
            return null;
        }
        return videoController.a();
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void showInterstitial() {
        this.zzht.c();
    }

    @Override // com.google.android.gms.internal.ads.zzbiy
    public Bundle getInterstitialAdapterInfo() {
        return new b.a().a(1).a();
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void requestNativeAd(Context context, com.google.android.gms.ads.mediation.e eVar, Bundle bundle, com.google.android.gms.ads.mediation.i iVar, Bundle bundle2) {
        f fVar = new f(this, eVar);
        b.a aVarA = new b.a(context, bundle.getString(AD_UNIT_ID_PARAMETER)).a((com.google.android.gms.ads.a) fVar);
        com.google.android.gms.ads.b.d dVarH = iVar.h();
        if (dVarH != null) {
            aVarA.a(dVarH);
        }
        if (iVar.j()) {
            aVarA.a((k.a) fVar);
        }
        if (iVar.i()) {
            aVarA.a((g.a) fVar);
        }
        if (iVar.k()) {
            aVarA.a((h.a) fVar);
        }
        if (iVar.l()) {
            for (String str : iVar.m().keySet()) {
                aVarA.a(str, fVar, iVar.m().get(str).booleanValue() ? fVar : null);
            }
        }
        this.zzhu = aVarA.a();
        this.zzhu.a(zza(context, iVar, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public void initialize(Context context, com.google.android.gms.ads.mediation.a aVar, String str, com.google.android.gms.ads.reward.mediation.a aVar2, Bundle bundle, Bundle bundle2) {
        this.zzhv = context.getApplicationContext();
        this.zzhx = aVar2;
        this.zzhx.a(this);
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public void loadAd(com.google.android.gms.ads.mediation.a aVar, Bundle bundle, Bundle bundle2) {
        if (this.zzhv == null || this.zzhx == null) {
            aan.c("AdMobAdapter.loadAd called before initialize.");
            return;
        }
        this.zzhw = new com.google.android.gms.ads.g(this.zzhv);
        this.zzhw.a(true);
        this.zzhw.a(getAdUnitId(bundle));
        this.zzhw.a(this.zzhy);
        this.zzhw.a(new g(this));
        this.zzhw.a(zza(this.zzhv, aVar, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public void showVideo() {
        this.zzhw.c();
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public boolean isInitialized() {
        return this.zzhx != null;
    }

    static /* synthetic */ com.google.android.gms.ads.g zza(AbstractAdViewAdapter abstractAdViewAdapter, com.google.android.gms.ads.g gVar) {
        abstractAdViewAdapter.zzhw = null;
        return null;
    }
}
