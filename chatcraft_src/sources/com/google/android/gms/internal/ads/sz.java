package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class sz {

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f3461a;

    /* renamed from: b, reason: collision with root package name */
    private final String f3462b;
    private final String c;
    private final String d;
    private final boolean e;
    private final String f;
    private final String g;
    private String h;
    private final int i;
    private final boolean j;
    private final JSONObject k;
    private final String l;
    private final boolean m;

    public sz(JSONObject jSONObject) {
        this.h = jSONObject.optString("url");
        this.f3462b = jSONObject.optString("base_uri");
        this.c = jSONObject.optString("post_parameters");
        String strOptString = jSONObject.optString("drt_include");
        this.e = strOptString != null && (strOptString.equals("1") || strOptString.equals("true"));
        this.f = jSONObject.optString("request_id");
        this.d = jSONObject.optString("type");
        String strOptString2 = jSONObject.optString("errors");
        this.f3461a = strOptString2 == null ? null : Arrays.asList(strOptString2.split(","));
        this.i = jSONObject.optInt("valid", 0) == 1 ? -2 : 1;
        this.g = jSONObject.optString("fetched_ad");
        this.j = jSONObject.optBoolean("render_test_ad_label");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("preprocessor_flags");
        this.k = jSONObjectOptJSONObject == null ? new JSONObject() : jSONObjectOptJSONObject;
        this.l = jSONObject.optString("analytics_query_ad_event_id");
        this.m = jSONObject.optBoolean("is_analytics_logging_enabled");
    }

    public final int a() {
        return this.i;
    }

    public final String b() {
        return this.f3462b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.h;
    }

    public final boolean e() {
        return this.e;
    }

    public final String f() {
        return this.g;
    }

    public final boolean g() {
        return this.j;
    }

    public final String h() {
        return this.l;
    }

    public final boolean i() {
        return this.m;
    }
}
