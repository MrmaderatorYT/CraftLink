package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class bm implements com.google.android.gms.ads.internal.gmsg.ac<Object> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bl f2826a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ pn f2827b;

    bm(bl blVar, pn pnVar) {
        this.f2826a = blVar;
        this.f2827b = pnVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final void zza(Object obj, final Map<String, String> map) {
        afu afuVar = (afu) this.f2826a.f2787a.get();
        if (afuVar == null) {
            this.f2827b.b("/loadHtml", this);
            return;
        }
        ahb ahbVarW = afuVar.w();
        final pn pnVar = this.f2827b;
        ahbVarW.a(new ahc(this, map, pnVar) { // from class: com.google.android.gms.internal.ads.bn

            /* renamed from: a, reason: collision with root package name */
            private final bm f2860a;

            /* renamed from: b, reason: collision with root package name */
            private final Map f2861b;
            private final pn c;

            {
                this.f2860a = this;
                this.f2861b = map;
                this.c = pnVar;
            }

            @Override // com.google.android.gms.internal.ads.ahc
            public final void a(boolean z) throws JSONException {
                bm bmVar = this.f2860a;
                Map map2 = this.f2861b;
                pn pnVar2 = this.c;
                bmVar.f2826a.f2788b = (String) map2.get("id");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("messageType", "htmlLoaded");
                    jSONObject.put("id", bmVar.f2826a.f2788b);
                    pnVar2.a("sendMessageToNativeJs", jSONObject);
                } catch (JSONException e) {
                    xe.b("Unable to dispatch sendMessageToNativeJs event", e);
                }
            }
        });
        String str = map.get("overlayHtml");
        String str2 = map.get("baseUrl");
        if (TextUtils.isEmpty(str2)) {
            afuVar.loadData(str, "text/html", "UTF-8");
        } else {
            afuVar.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
        }
    }
}
