package io.fabric.sdk.android.services.e;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONObject;

/* compiled from: DefaultSettingsController.java */
/* loaded from: classes.dex */
class j implements s {

    /* renamed from: a, reason: collision with root package name */
    private final w f4304a;

    /* renamed from: b, reason: collision with root package name */
    private final v f4305b;
    private final io.fabric.sdk.android.services.b.k c;
    private final g d;
    private final x e;
    private final io.fabric.sdk.android.h f;
    private final io.fabric.sdk.android.services.d.c g;

    public j(io.fabric.sdk.android.h hVar, w wVar, io.fabric.sdk.android.services.b.k kVar, v vVar, g gVar, x xVar) {
        this.f = hVar;
        this.f4304a = wVar;
        this.c = kVar;
        this.f4305b = vVar;
        this.d = gVar;
        this.e = xVar;
        this.g = new io.fabric.sdk.android.services.d.d(this.f);
    }

    @Override // io.fabric.sdk.android.services.e.s
    public t a() {
        return a(r.USE_CACHE);
    }

    @Override // io.fabric.sdk.android.services.e.s
    public t a(r rVar) {
        JSONObject jSONObjectA;
        t tVarB = null;
        if (!new io.fabric.sdk.android.services.b.q().f(this.f.r())) {
            io.fabric.sdk.android.c.g().a("Fabric", "Not fetching settings, because data collection is disabled by Firebase.");
            return null;
        }
        try {
            if (!io.fabric.sdk.android.c.h() && !d()) {
                tVarB = b(rVar);
            }
            if (tVarB == null && (jSONObjectA = this.e.a(this.f4304a)) != null) {
                t tVarA = this.f4305b.a(this.c, jSONObjectA);
                try {
                    this.d.a(tVarA.g, jSONObjectA);
                    a(jSONObjectA, "Loaded settings: ");
                    a(b());
                    tVarB = tVarA;
                } catch (Exception e) {
                    e = e;
                    tVarB = tVarA;
                    io.fabric.sdk.android.c.g().e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", e);
                    return tVarB;
                }
            }
            if (tVarB == null) {
                return b(r.IGNORE_CACHE_EXPIRATION);
            }
        } catch (Exception e2) {
            e = e2;
        }
        return tVarB;
    }

    private t b(r rVar) {
        t tVar = null;
        try {
            if (!r.SKIP_CACHE_LOOKUP.equals(rVar)) {
                JSONObject jSONObjectA = this.d.a();
                if (jSONObjectA != null) {
                    t tVarA = this.f4305b.a(this.c, jSONObjectA);
                    if (tVarA != null) {
                        a(jSONObjectA, "Loaded cached settings: ");
                        long jA = this.c.a();
                        if (r.IGNORE_CACHE_EXPIRATION.equals(rVar) || !tVarA.a(jA)) {
                            try {
                                io.fabric.sdk.android.c.g().a("Fabric", "Returning cached settings.");
                                tVar = tVarA;
                            } catch (Exception e) {
                                e = e;
                                tVar = tVarA;
                                io.fabric.sdk.android.c.g().e("Fabric", "Failed to get cached settings", e);
                                return tVar;
                            }
                        } else {
                            io.fabric.sdk.android.c.g().a("Fabric", "Cached settings have expired.");
                        }
                    } else {
                        io.fabric.sdk.android.c.g().e("Fabric", "Failed to transform cached settings data.", null);
                    }
                } else {
                    io.fabric.sdk.android.c.g().a("Fabric", "No cached settings data found.");
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
        return tVar;
    }

    private void a(JSONObject jSONObject, String str) {
        io.fabric.sdk.android.c.g().a("Fabric", str + jSONObject.toString());
    }

    String b() {
        return io.fabric.sdk.android.services.b.i.a(io.fabric.sdk.android.services.b.i.m(this.f.r()));
    }

    String c() {
        return this.g.a().getString("existing_instance_identifier", BuildConfig.FLAVOR);
    }

    @SuppressLint({"CommitPrefEdits"})
    boolean a(String str) {
        SharedPreferences.Editor editorB = this.g.b();
        editorB.putString("existing_instance_identifier", str);
        return this.g.a(editorB);
    }

    boolean d() {
        return !c().equals(b());
    }
}
