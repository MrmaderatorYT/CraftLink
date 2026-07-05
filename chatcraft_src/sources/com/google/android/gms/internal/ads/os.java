package com.google.android.gms.internal.ads;

import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class os implements pc<as> {
    @Override // com.google.android.gms.internal.ads.pc
    public final /* synthetic */ bh a(ot otVar, JSONObject jSONObject) {
        abl<afu> ablVarA;
        JSONObject jSONObjectA = zl.a(jSONObject, "html_containers", "instream");
        if (jSONObjectA == null) {
            ablVarA = otVar.a(jSONObject, "video");
        } else {
            ablVarA = otVar.a(jSONObjectA.optString("base_url"), jSONObjectA.optString("html"), true);
        }
        afu afuVarA = ot.a(ablVarA);
        if (afuVarA == null) {
            xe.e("Can not get video view for instream ad.");
            return null;
        }
        return new as(afuVarA);
    }
}
