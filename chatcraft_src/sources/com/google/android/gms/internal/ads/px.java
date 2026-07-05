package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class px implements com.google.android.gms.ads.internal.gmsg.ac<afu> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ afu f3378a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ abv f3379b;
    private final /* synthetic */ pr c;

    px(pr prVar, afu afuVar, abv abvVar) {
        this.c = prVar;
        this.f3378a = afuVar;
        this.f3379b = abvVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final /* synthetic */ void zza(afu afuVar, Map map) {
        JSONObject jSONObject;
        boolean z;
        try {
            String str = (String) map.get("success");
            String str2 = (String) map.get("failure");
            if (!TextUtils.isEmpty(str2)) {
                jSONObject = new JSONObject(str2);
                z = false;
            } else {
                jSONObject = new JSONObject(str);
                z = true;
            }
            if (this.c.h.equals(jSONObject.optString("ads_id", BuildConfig.FLAVOR))) {
                this.f3378a.b("/nativeAdPreProcess", this);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("success", z);
                jSONObject2.put("json", jSONObject);
                this.f3379b.b(jSONObject2);
            }
        } catch (Throwable th) {
            xe.b("Error while preprocessing json.", th);
            this.f3379b.a(th);
        }
    }
}
