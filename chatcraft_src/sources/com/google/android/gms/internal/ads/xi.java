package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class xi implements xh {

    /* renamed from: b, reason: collision with root package name */
    private boolean f3575b;
    private abl<?> d;

    @GuardedBy("mLock")
    @Nullable
    private SharedPreferences f;

    @GuardedBy("mLock")
    @Nullable
    private SharedPreferences.Editor g;

    @GuardedBy("mLock")
    @Nullable
    private String j;

    @GuardedBy("mLock")
    @Nullable
    private String k;

    /* renamed from: a, reason: collision with root package name */
    private final Object f3574a = new Object();
    private final List<Runnable> c = new ArrayList();

    @GuardedBy("mLock")
    @Nullable
    private bnb e = null;

    @GuardedBy("mLock")
    private boolean h = false;

    @GuardedBy("mLock")
    private boolean i = true;

    @GuardedBy("mLock")
    private boolean l = false;

    @GuardedBy("mLock")
    private String m = BuildConfig.FLAVOR;

    @GuardedBy("mLock")
    private long n = 0;

    @GuardedBy("mLock")
    private long o = 0;

    @GuardedBy("mLock")
    private long p = 0;

    @GuardedBy("mLock")
    private int q = -1;

    @GuardedBy("mLock")
    private int r = 0;

    @GuardedBy("mLock")
    private Set<String> s = Collections.emptySet();

    @GuardedBy("mLock")
    private JSONObject t = new JSONObject();

    @GuardedBy("mLock")
    private boolean u = true;

    @GuardedBy("mLock")
    private boolean v = true;

    public final void a(final Context context, String str, boolean z) {
        final String str2 = "admob";
        this.d = xl.a(new Runnable(this, context, str2) { // from class: com.google.android.gms.internal.ads.xj

            /* renamed from: a, reason: collision with root package name */
            private final xi f3576a;

            /* renamed from: b, reason: collision with root package name */
            private final Context f3577b;
            private final String c;

            {
                this.f3576a = this;
                this.f3577b = context;
                this.c = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f3576a.a(this.f3577b, this.c);
            }
        });
        this.f3575b = true;
    }

    private final void o() {
        if (this.d == null || this.d.isDone()) {
            return;
        }
        try {
            this.d.get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            xe.c("Interrupted while waiting for preferences loaded.", e);
        } catch (CancellationException | ExecutionException | TimeoutException e2) {
            xe.b("Fail to initialize AdSharedPreferenceManager.", e2);
        }
    }

    private final Bundle p() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("listener_registration_bundle", true);
        synchronized (this.f3574a) {
            bundle.putBoolean("use_https", this.i);
            bundle.putBoolean("content_url_opted_out", this.u);
            bundle.putBoolean("content_vertical_opted_out", this.v);
            bundle.putBoolean("auto_collect_location", this.l);
            bundle.putInt("version_code", this.r);
            bundle.putStringArray("never_pool_slots", (String[]) this.s.toArray(new String[this.s.size()]));
            bundle.putString("app_settings_json", this.m);
            bundle.putLong("app_settings_last_update_ms", this.n);
            bundle.putLong("app_last_background_time_ms", this.o);
            bundle.putInt("request_in_session_count", this.q);
            bundle.putLong("first_ad_req_time_ms", this.p);
            bundle.putString("native_advanced_settings", this.t.toString());
            if (this.j != null) {
                bundle.putString("content_url_hashes", this.j);
            }
            if (this.k != null) {
                bundle.putString("content_vertical_hashes", this.k);
            }
        }
        return bundle;
    }

    private final void a(Bundle bundle) {
        xl.f3579a.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.xk

            /* renamed from: a, reason: collision with root package name */
            private final xi f3578a;

            {
                this.f3578a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f3578a.n();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final void a(boolean z) {
        o();
        synchronized (this.f3574a) {
            if (this.i == z) {
                return;
            }
            this.i = z;
            if (this.g != null) {
                this.g.putBoolean("use_https", z);
                this.g.apply();
            }
            if (!this.h) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("use_https", z);
                a(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final boolean a() {
        boolean z;
        o();
        synchronized (this.f3574a) {
            z = this.i || this.h;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final void b(boolean z) {
        o();
        synchronized (this.f3574a) {
            if (this.u == z) {
                return;
            }
            this.u = z;
            if (this.g != null) {
                this.g.putBoolean("content_url_opted_out", z);
                this.g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("content_url_opted_out", this.u);
            bundle.putBoolean("content_vertical_opted_out", this.v);
            a(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final boolean b() {
        boolean z;
        o();
        synchronized (this.f3574a) {
            z = this.u;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final void a(@Nullable String str) {
        o();
        synchronized (this.f3574a) {
            if (str != null) {
                try {
                    if (!str.equals(this.j)) {
                        this.j = str;
                        if (this.g != null) {
                            this.g.putString("content_url_hashes", str);
                            this.g.apply();
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString("content_url_hashes", str);
                        a(bundle);
                    }
                } finally {
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.xh
    @Nullable
    public final String c() {
        String str;
        o();
        synchronized (this.f3574a) {
            str = this.j;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final void c(boolean z) {
        o();
        synchronized (this.f3574a) {
            if (this.v == z) {
                return;
            }
            this.v = z;
            if (this.g != null) {
                this.g.putBoolean("content_vertical_opted_out", z);
                this.g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("content_url_opted_out", this.u);
            bundle.putBoolean("content_vertical_opted_out", this.v);
            a(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final boolean d() {
        boolean z;
        o();
        synchronized (this.f3574a) {
            z = this.v;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final void b(@Nullable String str) {
        o();
        synchronized (this.f3574a) {
            if (str != null) {
                try {
                    if (!str.equals(this.k)) {
                        this.k = str;
                        if (this.g != null) {
                            this.g.putString("content_vertical_hashes", str);
                            this.g.apply();
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString("content_vertical_hashes", str);
                        a(bundle);
                    }
                } finally {
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.xh
    @Nullable
    public final String e() {
        String str;
        o();
        synchronized (this.f3574a) {
            str = this.k;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final void d(boolean z) {
        o();
        synchronized (this.f3574a) {
            if (this.l == z) {
                return;
            }
            this.l = z;
            if (this.g != null) {
                this.g.putBoolean("auto_collect_location", z);
                this.g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("auto_collect_location", z);
            a(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final boolean f() {
        boolean z;
        o();
        synchronized (this.f3574a) {
            z = this.l;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final void a(int i) {
        o();
        synchronized (this.f3574a) {
            if (this.r == i) {
                return;
            }
            this.r = i;
            if (this.g != null) {
                this.g.putInt("version_code", i);
                this.g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putInt("version_code", i);
            a(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final int g() {
        int i;
        o();
        synchronized (this.f3574a) {
            i = this.r;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final void c(String str) {
        o();
        synchronized (this.f3574a) {
            if (this.s.contains(str)) {
                return;
            }
            this.s.add(str);
            if (this.g != null) {
                this.g.putStringSet("never_pool_slots", this.s);
                this.g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putStringArray("never_pool_slots", (String[]) this.s.toArray(new String[this.s.size()]));
            a(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final void d(String str) {
        o();
        synchronized (this.f3574a) {
            if (this.s.contains(str)) {
                this.s.remove(str);
                if (this.g != null) {
                    this.g.putStringSet("never_pool_slots", this.s);
                    this.g.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putStringArray("never_pool_slots", (String[]) this.s.toArray(new String[this.s.size()]));
                a(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final boolean e(String str) {
        boolean zContains;
        o();
        synchronized (this.f3574a) {
            zContains = this.s.contains(str);
        }
        return zContains;
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final void f(String str) {
        o();
        synchronized (this.f3574a) {
            long jA = com.google.android.gms.ads.internal.ax.l().a();
            this.n = jA;
            if (str != null && !str.equals(this.m)) {
                this.m = str;
                if (this.g != null) {
                    this.g.putString("app_settings_json", str);
                    this.g.putLong("app_settings_last_update_ms", jA);
                    this.g.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putString("app_settings_json", str);
                bundle.putLong("app_settings_last_update_ms", jA);
                a(bundle);
                Iterator<Runnable> it = this.c.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final wo h() {
        wo woVar;
        o();
        synchronized (this.f3574a) {
            woVar = new wo(this.m, this.n);
        }
        return woVar;
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final void a(long j) {
        o();
        synchronized (this.f3574a) {
            if (this.o == j) {
                return;
            }
            this.o = j;
            if (this.g != null) {
                this.g.putLong("app_last_background_time_ms", j);
                this.g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putLong("app_last_background_time_ms", j);
            a(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final long i() {
        long j;
        o();
        synchronized (this.f3574a) {
            j = this.o;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final void b(int i) {
        o();
        synchronized (this.f3574a) {
            if (this.q == i) {
                return;
            }
            this.q = i;
            if (this.g != null) {
                this.g.putInt("request_in_session_count", i);
                this.g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putInt("request_in_session_count", i);
            a(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final int j() {
        int i;
        o();
        synchronized (this.f3574a) {
            i = this.q;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final void b(long j) {
        o();
        synchronized (this.f3574a) {
            if (this.p == j) {
                return;
            }
            this.p = j;
            if (this.g != null) {
                this.g.putLong("first_ad_req_time_ms", j);
                this.g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putLong("first_ad_req_time_ms", j);
            a(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final long k() {
        long j;
        o();
        synchronized (this.f3574a) {
            j = this.p;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final void a(String str, String str2, boolean z) {
        o();
        synchronized (this.f3574a) {
            JSONArray jSONArrayOptJSONArray = this.t.optJSONArray(str);
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
            }
            int length = jSONArrayOptJSONArray.length();
            int i = 0;
            while (true) {
                if (i < jSONArrayOptJSONArray.length()) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject == null) {
                        return;
                    }
                    if (!str2.equals(jSONObjectOptJSONObject.optString("template_id"))) {
                        i++;
                    } else if (z && jSONObjectOptJSONObject.optBoolean("uses_media_view", false) == z) {
                        return;
                    } else {
                        length = i;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", com.google.android.gms.ads.internal.ax.l().a());
                jSONArrayOptJSONArray.put(length, jSONObject);
                this.t.put(str, jSONArrayOptJSONArray);
            } catch (JSONException e) {
                xe.c("Could not update native advanced settings", e);
            }
            if (this.g != null) {
                this.g.putString("native_advanced_settings", this.t.toString());
                this.g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", this.t.toString());
            a(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final JSONObject l() {
        JSONObject jSONObject;
        o();
        synchronized (this.f3574a) {
            jSONObject = this.t;
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.xh
    public final void m() {
        o();
        synchronized (this.f3574a) {
            this.t = new JSONObject();
            if (this.g != null) {
                this.g.remove("native_advanced_settings");
                this.g.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", "{}");
            a(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.xh
    @Nullable
    public final bnb n() {
        if (!this.f3575b || !com.google.android.gms.common.util.j.a()) {
            return null;
        }
        if (b() && d()) {
            return null;
        }
        if (!((Boolean) bra.e().a(o.N)).booleanValue()) {
            return null;
        }
        synchronized (this.f3574a) {
            if (Looper.getMainLooper() == null) {
                return null;
            }
            if (this.e == null) {
                this.e = new bnb();
            }
            this.e.a();
            xe.d("start fetching content...");
            return this.e;
        }
    }

    final /* synthetic */ void a(Context context, String str) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        synchronized (this.f3574a) {
            this.f = sharedPreferences;
            this.g = editorEdit;
            if (com.google.android.gms.common.util.j.i() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                z = true;
            }
            this.h = z;
            this.i = this.f.getBoolean("use_https", this.i);
            this.u = this.f.getBoolean("content_url_opted_out", this.u);
            this.j = this.f.getString("content_url_hashes", this.j);
            this.l = this.f.getBoolean("auto_collect_location", this.l);
            this.v = this.f.getBoolean("content_vertical_opted_out", this.v);
            this.k = this.f.getString("content_vertical_hashes", this.k);
            this.r = this.f.getInt("version_code", this.r);
            this.m = this.f.getString("app_settings_json", this.m);
            this.n = this.f.getLong("app_settings_last_update_ms", this.n);
            this.o = this.f.getLong("app_last_background_time_ms", this.o);
            this.q = this.f.getInt("request_in_session_count", this.q);
            this.p = this.f.getLong("first_ad_req_time_ms", this.p);
            this.s = this.f.getStringSet("never_pool_slots", this.s);
            try {
                this.t = new JSONObject(this.f.getString("native_advanced_settings", "{}"));
            } catch (JSONException e) {
                xe.c("Could not convert native advanced settings to json object", e);
            }
            a(p());
        }
    }
}
