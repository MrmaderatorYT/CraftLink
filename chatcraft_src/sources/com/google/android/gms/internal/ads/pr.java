package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class pr implements pn<afu> {

    /* renamed from: a, reason: collision with root package name */
    private abl<afu> f3367a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.android.gms.ads.internal.gmsg.b f3368b;
    private final bk c;
    private final Context d;
    private final aar e;
    private final com.google.android.gms.ads.internal.ad f;
    private final axe g;
    private String h;

    public pr(Context context, com.google.android.gms.ads.internal.ad adVar, String str, axe axeVar, aar aarVar) {
        xe.d("Webview loading for native ads.");
        this.d = context;
        this.f = adVar;
        this.g = axeVar;
        this.e = aarVar;
        this.h = str;
        com.google.android.gms.ads.internal.ax.f();
        abl<afu> ablVarA = aga.a(this.d, this.e, (String) bra.e().a(o.bx), this.g, this.f.i());
        this.f3368b = new com.google.android.gms.ads.internal.gmsg.b(this.d);
        this.c = new bk(adVar, str);
        this.f3367a = aaz.a(ablVarA, new aau(this) { // from class: com.google.android.gms.internal.ads.ps

            /* renamed from: a, reason: collision with root package name */
            private final pr f3369a;

            {
                this.f3369a = this;
            }

            @Override // com.google.android.gms.internal.ads.aau
            public final abl a(Object obj) {
                return this.f3369a.a((afu) obj);
            }
        }, abq.f1817b);
        aax.a(this.f3367a, "WebViewNativeAdsUtil.constructor");
    }

    @Override // com.google.android.gms.internal.ads.pn
    public final abl<JSONObject> a(final JSONObject jSONObject) {
        return aaz.a(this.f3367a, new aau(this, jSONObject) { // from class: com.google.android.gms.internal.ads.pt

            /* renamed from: a, reason: collision with root package name */
            private final pr f3370a;

            /* renamed from: b, reason: collision with root package name */
            private final JSONObject f3371b;

            {
                this.f3370a = this;
                this.f3371b = jSONObject;
            }

            @Override // com.google.android.gms.internal.ads.aau
            public final abl a(Object obj) {
                return this.f3370a.d(this.f3371b, (afu) obj);
            }
        }, abq.f1816a);
    }

    @Override // com.google.android.gms.internal.ads.pn
    public final abl<JSONObject> b(final JSONObject jSONObject) {
        return aaz.a(this.f3367a, new aau(this, jSONObject) { // from class: com.google.android.gms.internal.ads.pu

            /* renamed from: a, reason: collision with root package name */
            private final pr f3372a;

            /* renamed from: b, reason: collision with root package name */
            private final JSONObject f3373b;

            {
                this.f3372a = this;
                this.f3373b = jSONObject;
            }

            @Override // com.google.android.gms.internal.ads.aau
            public final abl a(Object obj) {
                return this.f3372a.c(this.f3373b, (afu) obj);
            }
        }, abq.f1816a);
    }

    @Override // com.google.android.gms.internal.ads.pn
    public final abl<JSONObject> c(final JSONObject jSONObject) {
        return aaz.a(this.f3367a, new aau(this, jSONObject) { // from class: com.google.android.gms.internal.ads.pv

            /* renamed from: a, reason: collision with root package name */
            private final pr f3374a;

            /* renamed from: b, reason: collision with root package name */
            private final JSONObject f3375b;

            {
                this.f3374a = this;
                this.f3375b = jSONObject;
            }

            @Override // com.google.android.gms.internal.ads.aau
            public final abl a(Object obj) {
                return this.f3374a.b(this.f3375b, (afu) obj);
            }
        }, abq.f1816a);
    }

    @Override // com.google.android.gms.internal.ads.pn
    public final abl<JSONObject> d(final JSONObject jSONObject) {
        return aaz.a(this.f3367a, new aau(this, jSONObject) { // from class: com.google.android.gms.internal.ads.pw

            /* renamed from: a, reason: collision with root package name */
            private final pr f3376a;

            /* renamed from: b, reason: collision with root package name */
            private final JSONObject f3377b;

            {
                this.f3376a = this;
                this.f3377b = jSONObject;
            }

            @Override // com.google.android.gms.internal.ads.aau
            public final abl a(Object obj) {
                return this.f3376a.a(this.f3377b, (afu) obj);
            }
        }, abq.f1816a);
    }

    @Override // com.google.android.gms.internal.ads.pn
    public final void a(String str, com.google.android.gms.ads.internal.gmsg.ac<? super afu> acVar) {
        aaz.a(this.f3367a, new pz(this, str, acVar), abq.f1816a);
    }

    @Override // com.google.android.gms.internal.ads.pn
    public final void b(String str, com.google.android.gms.ads.internal.gmsg.ac<? super afu> acVar) {
        aaz.a(this.f3367a, new qa(this, str, acVar), abq.f1816a);
    }

    @Override // com.google.android.gms.internal.ads.pn
    public final void a(String str, JSONObject jSONObject) {
        aaz.a(this.f3367a, new qb(this, str, jSONObject), abq.f1816a);
    }

    @Override // com.google.android.gms.internal.ads.pn
    public final void a() {
        aaz.a(this.f3367a, new qc(this), abq.f1816a);
    }

    final /* synthetic */ abl a(JSONObject jSONObject, afu afuVar) throws JSONException {
        jSONObject.put("ads_id", this.h);
        afuVar.b("google.afma.nativeAds.handleDownloadedImpressionPing", jSONObject);
        return aaz.a(new JSONObject());
    }

    final /* synthetic */ abl b(JSONObject jSONObject, afu afuVar) throws JSONException {
        jSONObject.put("ads_id", this.h);
        afuVar.b("google.afma.nativeAds.handleImpressionPing", jSONObject);
        return aaz.a(new JSONObject());
    }

    final /* synthetic */ abl c(JSONObject jSONObject, afu afuVar) throws JSONException {
        jSONObject.put("ads_id", this.h);
        afuVar.b("google.afma.nativeAds.handleClickGmsg", jSONObject);
        return aaz.a(new JSONObject());
    }

    final /* synthetic */ abl d(JSONObject jSONObject, afu afuVar) throws JSONException {
        jSONObject.put("ads_id", this.h);
        abv abvVar = new abv();
        afuVar.a("/nativeAdPreProcess", new px(this, afuVar, abvVar));
        afuVar.b("google.afma.nativeAds.preProcessJsonGmsg", jSONObject);
        return abvVar;
    }

    final /* synthetic */ abl a(afu afuVar) {
        xe.d("Javascript has loaded for native ads.");
        afuVar.w().a(this.f, this.f, this.f, this.f, this.f, false, null, new com.google.android.gms.ads.internal.bu(this.d, null, null), null, null);
        afuVar.a("/logScionEvent", this.f3368b);
        afuVar.a("/logScionEvent", this.c);
        return aaz.a(afuVar);
    }
}
