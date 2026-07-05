package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class adj {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1866a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1867b;
    public final int c;
    public final int d;
    public final String e;
    public final int f;
    public final int g;
    public final int h;
    public final boolean i;
    public final boolean j;

    public adj(String str) {
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        this.f1866a = a(jSONObject, "aggressive_media_codec_release", o.B);
        this.f1867b = b(jSONObject, "byte_buffer_precache_limit", o.m);
        this.c = b(jSONObject, "exo_cache_buffer_size", o.p);
        this.d = b(jSONObject, "exo_connect_timeout_millis", o.i);
        this.e = c(jSONObject, "exo_player_version", o.h);
        this.f = b(jSONObject, "exo_read_timeout_millis", o.j);
        this.g = b(jSONObject, "load_check_interval_bytes", o.k);
        this.h = b(jSONObject, "player_precache_limit", o.l);
        this.i = a(jSONObject, "use_cache_data_source", o.bZ);
        this.j = a(jSONObject, "use_dash", false);
    }

    private static boolean a(JSONObject jSONObject, String str, d<Boolean> dVar) {
        return a(jSONObject, str, ((Boolean) bra.e().a(dVar)).booleanValue());
    }

    private static boolean a(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null) {
            try {
                return jSONObject.getBoolean(str);
            } catch (JSONException unused) {
            }
        }
        return z;
    }

    private static int b(JSONObject jSONObject, String str, d<Integer> dVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
            }
        }
        return ((Integer) bra.e().a(dVar)).intValue();
    }

    private static String c(JSONObject jSONObject, String str, d<String> dVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException unused) {
            }
        }
        return (String) bra.e().a(dVar);
    }
}
