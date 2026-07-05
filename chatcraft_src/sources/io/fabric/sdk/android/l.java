package io.fabric.sdk.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import io.fabric.sdk.android.services.e.n;
import io.fabric.sdk.android.services.e.q;
import io.fabric.sdk.android.services.e.t;
import io.fabric.sdk.android.services.e.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: Onboarding.java */
/* loaded from: classes.dex */
class l extends h<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    private final io.fabric.sdk.android.services.network.d f4196a = new io.fabric.sdk.android.services.network.b();

    /* renamed from: b, reason: collision with root package name */
    private PackageManager f4197b;
    private String c;
    private PackageInfo d;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private final Future<Map<String, j>> p;
    private final Collection<h> q;

    @Override // io.fabric.sdk.android.h
    public String a() {
        return "1.4.5.28";
    }

    @Override // io.fabric.sdk.android.h
    public String b() {
        return "io.fabric.sdk.android:fabric";
    }

    public l(Future<Map<String, j>> future, Collection<h> collection) {
        this.p = future;
        this.q = collection;
    }

    @Override // io.fabric.sdk.android.h
    protected boolean b_() {
        try {
            this.m = q().i();
            this.f4197b = r().getPackageManager();
            this.c = r().getPackageName();
            this.d = this.f4197b.getPackageInfo(this.c, 0);
            this.k = Integer.toString(this.d.versionCode);
            this.l = this.d.versionName == null ? "0.0" : this.d.versionName;
            this.n = this.f4197b.getApplicationLabel(r().getApplicationInfo()).toString();
            this.o = Integer.toString(r().getApplicationInfo().targetSdkVersion);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            c.g().e("Fabric", "Failed init", e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.h
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Boolean f() throws Throwable {
        Map<String, j> map;
        boolean zA;
        String strK = io.fabric.sdk.android.services.b.i.k(r());
        t tVarG = g();
        if (tVarG != null) {
            try {
                if (this.p != null) {
                    map = this.p.get();
                } else {
                    map = new HashMap<>();
                }
                zA = a(strK, tVarG.f4319a, a(map, this.q).values());
            } catch (Exception e) {
                c.g().e("Fabric", "Error performing auto configuration.", e);
            }
        } else {
            zA = false;
        }
        return Boolean.valueOf(zA);
    }

    private t g() {
        try {
            q.a().a(this, this.i, this.f4196a, this.k, this.l, e()).c();
            return q.a().b();
        } catch (Exception e) {
            c.g().e("Fabric", "Error dealing with settings", e);
            return null;
        }
    }

    Map<String, j> a(Map<String, j> map, Collection<h> collection) {
        for (h hVar : collection) {
            if (!map.containsKey(hVar.b())) {
                map.put(hVar.b(), new j(hVar.b(), hVar.a(), "binary"));
            }
        }
        return map;
    }

    private boolean a(String str, io.fabric.sdk.android.services.e.e eVar, Collection<j> collection) {
        if ("new".equals(eVar.f4300b)) {
            if (b(str, eVar, collection)) {
                return q.a().d();
            }
            c.g().e("Fabric", "Failed to create app with Crashlytics service.", null);
            return false;
        }
        if ("configured".equals(eVar.f4300b)) {
            return q.a().d();
        }
        if (eVar.f) {
            c.g().a("Fabric", "Server says an update is required - forcing a full App update.");
            c(str, eVar, collection);
        }
        return true;
    }

    private boolean b(String str, io.fabric.sdk.android.services.e.e eVar, Collection<j> collection) {
        return new io.fabric.sdk.android.services.e.h(this, e(), eVar.c, this.f4196a).a(a(n.a(r(), str), collection));
    }

    private boolean c(String str, io.fabric.sdk.android.services.e.e eVar, Collection<j> collection) {
        return a(eVar, n.a(r(), str), collection);
    }

    private boolean a(io.fabric.sdk.android.services.e.e eVar, n nVar, Collection<j> collection) {
        return new y(this, e(), eVar.c, this.f4196a).a(a(nVar, collection));
    }

    private io.fabric.sdk.android.services.e.d a(n nVar, Collection<j> collection) {
        Context contextR = r();
        return new io.fabric.sdk.android.services.e.d(new io.fabric.sdk.android.services.b.g().a(contextR), q().c(), this.l, this.k, io.fabric.sdk.android.services.b.i.a(io.fabric.sdk.android.services.b.i.m(contextR)), this.n, io.fabric.sdk.android.services.b.l.a(this.m).a(), this.o, "0", nVar, collection);
    }

    String e() {
        return io.fabric.sdk.android.services.b.i.b(r(), "com.crashlytics.ApiEndpoint");
    }
}
