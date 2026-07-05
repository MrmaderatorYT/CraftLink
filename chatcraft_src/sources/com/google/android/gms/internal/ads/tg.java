package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import org.json.JSONException;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class tg extends ti {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3472a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final Context f3473b;
    private SharedPreferences c;
    private final ix<JSONObject, JSONObject> d;

    public tg(Context context, ix<JSONObject, JSONObject> ixVar) {
        this.f3473b = context.getApplicationContext();
        this.d = ixVar;
    }

    @Override // com.google.android.gms.internal.ads.ti
    public final abl<Void> a() throws JSONException {
        synchronized (this.f3472a) {
            if (this.c == null) {
                this.c = this.f3473b.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (com.google.android.gms.ads.internal.ax.l().a() - this.c.getLong("js_last_update", 0L) < ((Long) bra.e().a(o.bu)).longValue()) {
            return aaz.a((Object) null);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", aar.a().f1790a);
            jSONObject.put("mf", bra.e().a(o.bv));
            jSONObject.put("cl", "220701481");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("dynamite_version", DynamiteModule.b(this.f3473b, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", 12451009);
            return aaz.a(this.d.b(jSONObject), new aav(this) { // from class: com.google.android.gms.internal.ads.th

                /* renamed from: a, reason: collision with root package name */
                private final tg f3474a;

                {
                    this.f3474a = this;
                }

                @Override // com.google.android.gms.internal.ads.aav
                public final Object a(Object obj) {
                    return this.f3474a.a((JSONObject) obj);
                }
            }, abq.f1817b);
        } catch (JSONException e) {
            xe.b("Unable to populate SDK Core Constants parameters.", e);
            return aaz.a((Object) null);
        }
    }

    final /* synthetic */ Void a(JSONObject jSONObject) {
        o.a(this.f3473b, 1, jSONObject);
        this.c.edit().putLong("js_last_update", com.google.android.gms.ads.internal.ax.l().a()).apply();
        return null;
    }
}
