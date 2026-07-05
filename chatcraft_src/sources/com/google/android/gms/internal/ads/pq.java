package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class pq implements pc<ay> {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f3366a;

    public pq(boolean z) {
        this.f3366a = z;
    }

    @Override // com.google.android.gms.internal.ads.pc
    public final /* synthetic */ bh a(ot otVar, JSONObject jSONObject) throws JSONException {
        androidx.b.g gVar = new androidx.b.g();
        androidx.b.g gVar2 = new androidx.b.g();
        abl<ao> ablVarA = otVar.a(jSONObject);
        abl<afu> ablVarA2 = otVar.a(jSONObject, "video");
        JSONArray jSONArray = jSONObject.getJSONArray("custom_assets");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("type");
            if ("string".equals(string)) {
                gVar2.put(jSONObject2.getString("name"), jSONObject2.getString("string_value"));
            } else if ("image".equals(string)) {
                gVar.put(jSONObject2.getString("name"), otVar.a(jSONObject2, "image_value", this.f3366a));
            } else {
                String strValueOf = String.valueOf(string);
                xe.e(strValueOf.length() != 0 ? "Unknown custom asset type: ".concat(strValueOf) : new String("Unknown custom asset type: "));
            }
        }
        afu afuVarA = ot.a(ablVarA2);
        String string2 = jSONObject.getString("custom_template_id");
        androidx.b.g gVar3 = new androidx.b.g();
        for (int i2 = 0; i2 < gVar.size(); i2++) {
            gVar3.put(gVar.b(i2), ((Future) gVar.c(i2)).get());
        }
        return new ay(string2, gVar3, gVar2, ablVarA.get(), afuVarA != null ? afuVarA.b() : null, afuVarA != null ? afuVarA.getView() : null);
    }
}
