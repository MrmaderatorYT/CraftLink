package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class ju {

    /* renamed from: a, reason: collision with root package name */
    public final List<jt> f3211a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3212b;
    public final List<String> c;
    public final List<String> d;
    public final List<String> e;
    public final List<String> f;
    public final List<String> g;
    public final boolean h;
    public final String i;
    public final long j;
    public final String k;
    public final int l;
    public final int m;
    public final long n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final boolean r;
    public int s;
    public int t;
    public boolean u;

    public ju(List<jt> list, long j, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, boolean z, String str, long j2, int i, int i2, String str2, int i3, int i4, long j3, boolean z2) {
        this.f3211a = list;
        this.f3212b = j;
        this.c = list2;
        this.d = list3;
        this.e = list4;
        this.f = list5;
        this.g = list6;
        this.h = z;
        this.i = str;
        this.j = -1L;
        this.s = 0;
        this.t = 1;
        this.k = null;
        this.l = 0;
        this.m = -1;
        this.n = -1L;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.u = false;
    }

    public ju(String str) {
        this(new JSONObject(str));
    }

    public ju(JSONObject jSONObject) throws JSONException {
        if (xe.a(2)) {
            String strValueOf = String.valueOf(jSONObject.toString(2));
            xe.a(strValueOf.length() != 0 ? "Mediation Response JSON: ".concat(strValueOf) : new String("Mediation Response JSON: "));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                jt jtVar = new jt(jSONArray.getJSONObject(i2));
                boolean z = true;
                if (jtVar.a()) {
                    this.u = true;
                }
                arrayList.add(jtVar);
                if (i < 0) {
                    Iterator<String> it = jtVar.c.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        i = i2;
                    }
                }
            } catch (JSONException unused) {
            }
        }
        this.s = i;
        this.t = jSONArray.length();
        this.f3211a = Collections.unmodifiableList(arrayList);
        this.i = jSONObject.optString("qdata");
        this.m = jSONObject.optInt("fs_model_type", -1);
        this.n = jSONObject.optLong("timeout_ms", -1L);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("settings");
        if (jSONObjectOptJSONObject != null) {
            this.f3212b = jSONObjectOptJSONObject.optLong("ad_network_timeout_millis", -1L);
            com.google.android.gms.ads.internal.ax.y();
            this.c = kc.a(jSONObjectOptJSONObject, "click_urls");
            com.google.android.gms.ads.internal.ax.y();
            this.d = kc.a(jSONObjectOptJSONObject, "imp_urls");
            com.google.android.gms.ads.internal.ax.y();
            this.e = kc.a(jSONObjectOptJSONObject, "downloaded_imp_urls");
            com.google.android.gms.ads.internal.ax.y();
            this.f = kc.a(jSONObjectOptJSONObject, "nofill_urls");
            com.google.android.gms.ads.internal.ax.y();
            this.g = kc.a(jSONObjectOptJSONObject, "remote_ping_urls");
            this.h = jSONObjectOptJSONObject.optBoolean("render_in_browser", false);
            long jOptLong = jSONObjectOptJSONObject.optLong("refresh", -1L);
            this.j = jOptLong > 0 ? 1000 * jOptLong : -1L;
            vh vhVarA = vh.a(jSONObjectOptJSONObject.optJSONArray("rewards"));
            if (vhVarA == null) {
                this.k = null;
                this.l = 0;
            } else {
                this.k = vhVarA.f3518a;
                this.l = vhVarA.f3519b;
            }
            this.o = jSONObjectOptJSONObject.optBoolean("use_displayed_impression", false);
            this.p = jSONObjectOptJSONObject.optBoolean("allow_pub_rendered_attribution", false);
            this.q = jSONObjectOptJSONObject.optBoolean("allow_pub_owned_ad_view", false);
            this.r = jSONObjectOptJSONObject.optBoolean("allow_custom_click_gesture", false);
            return;
        }
        this.f3212b = -1L;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.j = -1L;
        this.k = null;
        this.l = 0;
        this.o = false;
        this.h = false;
        this.p = false;
        this.q = false;
        this.r = false;
    }
}
