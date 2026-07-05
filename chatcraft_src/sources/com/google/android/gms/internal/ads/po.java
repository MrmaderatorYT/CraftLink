package com.google.android.gms.internal.ads;

import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.ads.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class po implements pc<au> {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f3362a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f3363b;
    private final boolean c;

    public po(boolean z, boolean z2, boolean z3) {
        this.f3362a = z;
        this.f3363b = z2;
        this.c = z3;
    }

    @Override // com.google.android.gms.internal.ads.pc
    public final /* synthetic */ bh a(ot otVar, JSONObject jSONObject) throws JSONException {
        String string;
        List<abl<at>> listA = otVar.a(jSONObject, "images", false, this.f3362a, this.f3363b);
        abl<at> ablVarA = otVar.a(jSONObject, "app_icon", true, this.f3362a);
        abl<afu> ablVarA2 = otVar.a(jSONObject, "video");
        abl<ao> ablVarA3 = otVar.a(jSONObject);
        ArrayList arrayList = new ArrayList();
        Iterator<abl<at>> it = listA.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().get());
        }
        afu afuVarA = ot.a(ablVarA2);
        String string2 = jSONObject.getString("headline");
        if (this.c) {
            Resources resourcesG = com.google.android.gms.ads.internal.ax.i().g();
            string = resourcesG != null ? resourcesG.getString(a.C0065a.s7) : "Test Ad";
            if (string2 != null) {
                StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 3 + String.valueOf(string2).length());
                sb.append(string);
                sb.append(" : ");
                sb.append(string2);
                string2 = sb.toString();
                string = string2;
            }
        } else {
            string = string2;
        }
        return new au(string, arrayList, jSONObject.getString("body"), ablVarA.get(), jSONObject.getString("call_to_action"), jSONObject.optDouble("rating", -1.0d), jSONObject.optString("store"), jSONObject.optString("price"), ablVarA3.get(), new Bundle(), afuVarA != null ? afuVarA.b() : null, afuVarA != null ? afuVarA.getView() : null, null, null);
    }
}
