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
public final class pp implements pc<aw> {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f3364a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f3365b;
    private final boolean c;

    public pp(boolean z, boolean z2, boolean z3) {
        this.f3364a = z;
        this.f3365b = z2;
        this.c = z3;
    }

    @Override // com.google.android.gms.internal.ads.pc
    public final /* synthetic */ bh a(ot otVar, JSONObject jSONObject) throws JSONException {
        String string;
        List<abl<at>> listA = otVar.a(jSONObject, "images", false, this.f3364a, this.f3365b);
        abl<at> ablVarA = otVar.a(jSONObject, "secondary_image", false, this.f3364a);
        abl<ao> ablVarA2 = otVar.a(jSONObject);
        abl<afu> ablVarA3 = otVar.a(jSONObject, "video");
        ArrayList arrayList = new ArrayList();
        Iterator<abl<at>> it = listA.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().get());
        }
        afu afuVarA = ot.a(ablVarA3);
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
        return new aw(string, arrayList, jSONObject.getString("body"), ablVarA.get(), jSONObject.getString("call_to_action"), jSONObject.getString("advertiser"), ablVarA2.get(), new Bundle(), afuVarA != null ? afuVarA.b() : null, afuVarA != null ? afuVarA.getView() : null, null, null);
    }
}
