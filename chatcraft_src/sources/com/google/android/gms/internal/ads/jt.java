package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class jt {

    /* renamed from: a, reason: collision with root package name */
    public final String f3209a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3210b;
    public final List<String> c;
    public final String d;
    public final String e;
    public final List<String> f;
    public final List<String> g;
    public final List<String> h;
    public final List<String> i;
    public final List<String> j;
    public final String k;
    public final List<String> l;
    public final List<String> m;
    public final List<String> n;
    public final String o;
    public final String p;
    public final String q;
    public final List<String> r;
    public final String s;
    public final long t;
    private final String u;

    public jt(String str, String str2, List<String> list, String str3, String str4, List<String> list2, List<String> list3, List<String> list4, List<String> list5, String str5, String str6, List<String> list6, List<String> list7, List<String> list8, String str7, String str8, String str9, List<String> list9, String str10, List<String> list10, String str11, long j) {
        this.f3209a = str;
        this.f3210b = null;
        this.c = list;
        this.d = null;
        this.e = null;
        this.f = list2;
        this.g = list3;
        this.h = list4;
        this.i = list5;
        this.k = str5;
        this.l = list6;
        this.m = list7;
        this.n = list8;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.j = list10;
        this.u = null;
        this.t = -1L;
    }

    public jt(JSONObject jSONObject) throws JSONException {
        List<String> listA;
        this.f3210b = jSONObject.optString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.c = Collections.unmodifiableList(arrayList);
        this.d = jSONObject.optString("allocation_id", null);
        com.google.android.gms.ads.internal.ax.y();
        this.f = kc.a(jSONObject, "clickurl");
        com.google.android.gms.ads.internal.ax.y();
        this.g = kc.a(jSONObject, "imp_urls");
        com.google.android.gms.ads.internal.ax.y();
        this.h = kc.a(jSONObject, "downloaded_imp_urls");
        com.google.android.gms.ads.internal.ax.y();
        this.j = kc.a(jSONObject, "fill_urls");
        com.google.android.gms.ads.internal.ax.y();
        this.l = kc.a(jSONObject, "video_start_urls");
        com.google.android.gms.ads.internal.ax.y();
        this.n = kc.a(jSONObject, "video_complete_urls");
        com.google.android.gms.ads.internal.ax.y();
        this.m = kc.a(jSONObject, "video_reward_urls");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("ad");
        if (jSONObjectOptJSONObject != null) {
            com.google.android.gms.ads.internal.ax.y();
            listA = kc.a(jSONObjectOptJSONObject, "manual_impression_urls");
        } else {
            listA = null;
        }
        this.i = listA;
        this.f3209a = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.toString() : null;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("data");
        this.k = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.toString() : null;
        this.e = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("class_name") : null;
        this.o = jSONObject.optString("html_template", null);
        this.p = jSONObject.optString("ad_base_url", null);
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("assets");
        this.q = jSONObjectOptJSONObject3 != null ? jSONObjectOptJSONObject3.toString() : null;
        com.google.android.gms.ads.internal.ax.y();
        this.r = kc.a(jSONObject, "template_ids");
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        this.s = jSONObjectOptJSONObject4 != null ? jSONObjectOptJSONObject4.toString() : null;
        this.u = jSONObject.optString("response_type", null);
        this.t = jSONObject.optLong("ad_network_timeout_millis", -1L);
    }

    public final boolean a() {
        return "banner".equalsIgnoreCase(this.u);
    }

    public final boolean b() {
        return "native".equalsIgnoreCase(this.u);
    }
}
