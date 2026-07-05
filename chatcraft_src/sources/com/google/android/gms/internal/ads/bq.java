package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class bq implements com.google.android.gms.ads.internal.gmsg.ac<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ pn f2962a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bl f2963b;

    bq(bl blVar, pn pnVar) {
        this.f2963b = blVar;
        this.f2962a = pnVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final void zza(Object obj, Map<String, String> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : map.keySet()) {
                jSONObject.put(str, map.get(str));
            }
            jSONObject.put("id", this.f2963b.f2788b);
            this.f2962a.a("sendMessageToNativeJs", jSONObject);
        } catch (JSONException e) {
            xe.b("Unable to dispatch sendMessageToNativeJs event", e);
        }
    }
}
