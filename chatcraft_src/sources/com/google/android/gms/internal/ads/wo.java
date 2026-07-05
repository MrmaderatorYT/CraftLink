package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class wo {

    /* renamed from: a, reason: collision with root package name */
    private final long f3551a;

    /* renamed from: b, reason: collision with root package name */
    private final List<String> f3552b = new ArrayList();
    private final List<String> c = new ArrayList();
    private final Map<String, ju> d = new HashMap();
    private String e;
    private String f;
    private JSONObject g;
    private boolean h;

    public wo(String str, long j) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        this.h = false;
        this.f = str;
        this.f3551a = j;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.g = new JSONObject(str);
            if (this.g.optInt("status", -1) != 1) {
                this.h = false;
                xe.e("App settings could not be fetched successfully.");
                return;
            }
            this.h = true;
            this.e = this.g.optString("app_id");
            JSONArray jSONArrayOptJSONArray = this.g.optJSONArray("ad_unit_id_settings");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i);
                    String strOptString = jSONObject.optString("format");
                    String strOptString2 = jSONObject.optString("ad_unit_id");
                    if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                        if ("interstitial".equalsIgnoreCase(strOptString)) {
                            this.c.add(strOptString2);
                        } else if ("rewarded".equalsIgnoreCase(strOptString) && (jSONObjectOptJSONObject = jSONObject.optJSONObject("mediation_config")) != null) {
                            this.d.put(strOptString2, new ju(jSONObjectOptJSONObject));
                        }
                    }
                }
            }
            JSONArray jSONArrayOptJSONArray2 = this.g.optJSONArray("persistable_banner_ad_unit_ids");
            if (jSONArrayOptJSONArray2 != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    this.f3552b.add(jSONArrayOptJSONArray2.optString(i2));
                }
            }
        } catch (JSONException e) {
            xe.c("Exception occurred while processing app setting json", e);
            com.google.android.gms.ads.internal.ax.i().a(e, "AppSettings.parseAppSettingsJson");
        }
    }

    public final long a() {
        return this.f3551a;
    }

    public final boolean b() {
        return this.h;
    }

    public final String c() {
        return this.f;
    }

    public final String d() {
        return this.e;
    }

    public final Map<String, ju> e() {
        return this.d;
    }
}
