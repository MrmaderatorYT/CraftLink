package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.b.d;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class jx implements kb {

    /* renamed from: a, reason: collision with root package name */
    private final String f3215a;

    /* renamed from: b, reason: collision with root package name */
    private final kk f3216b;
    private final long c;
    private final ju d;
    private final jt e;
    private bqj f;
    private final bqn g;
    private final Context h;
    private final aar j;
    private final boolean k;
    private final br l;
    private final List<String> m;
    private final List<String> n;
    private final List<String> o;
    private final boolean p;
    private final boolean q;

    @GuardedBy("mLock")
    private kn r;
    private kt t;
    private final Object i = new Object();

    @GuardedBy("mLock")
    private int s = -2;

    public jx(Context context, String str, kk kkVar, ju juVar, jt jtVar, bqj bqjVar, bqn bqnVar, aar aarVar, boolean z, boolean z2, br brVar, List<String> list, List<String> list2, List<String> list3, boolean z3) {
        this.h = context;
        this.f3216b = kkVar;
        this.e = jtVar;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            this.f3215a = b();
        } else {
            this.f3215a = str;
        }
        this.d = juVar;
        if (jtVar.t != -1) {
            this.c = jtVar.t;
        } else if (juVar.f3212b != -1) {
            this.c = juVar.f3212b;
        } else {
            this.c = 10000L;
        }
        this.f = bqjVar;
        this.g = bqnVar;
        this.j = aarVar;
        this.k = z;
        this.p = z2;
        this.l = brVar;
        this.m = list;
        this.n = list2;
        this.o = list3;
        this.q = z3;
    }

    public final void a() {
        synchronized (this.i) {
            try {
            } catch (RemoteException e) {
                xe.c("Could not destroy mediation adapter.", e);
            }
            if (this.r != null) {
                this.r.c();
                this.s = -1;
                this.i.notify();
            } else {
                this.s = -1;
                this.i.notify();
            }
        }
    }

    private final String b() {
        try {
            return !TextUtils.isEmpty(this.e.e) ? this.f3216b.b(this.e.e) ? "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter" : "com.google.ads.mediation.customevent.CustomEventAdapter" : "com.google.ads.mediation.customevent.CustomEventAdapter";
        } catch (RemoteException unused) {
            xe.e("Fail to determine the custom event's version, assuming the old one.");
            return "com.google.ads.mediation.customevent.CustomEventAdapter";
        }
    }

    @Override // com.google.android.gms.internal.ads.kb
    public final void a(int i) {
        synchronized (this.i) {
            this.s = i;
            this.i.notify();
        }
    }

    @Override // com.google.android.gms.internal.ads.kb
    public final void a(int i, kt ktVar) {
        synchronized (this.i) {
            this.s = 0;
            this.t = ktVar;
            this.i.notify();
        }
    }

    private static kn a(com.google.android.gms.ads.mediation.b bVar) {
        return new li(bVar);
    }

    public final ka a(long j, long j2) {
        ka kaVar;
        synchronized (this.i) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            jw jwVar = new jw();
            xn.f3583a.post(new jy(this, jwVar));
            long j3 = this.c;
            while (this.s == -2) {
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                long j4 = j3 - (jElapsedRealtime2 - jElapsedRealtime);
                long j5 = j2 - (jElapsedRealtime2 - j);
                if (j4 <= 0 || j5 <= 0) {
                    xe.d("Timed out waiting for adapter.");
                    this.s = 3;
                } else {
                    try {
                        this.i.wait(Math.min(j4, j5));
                    } catch (InterruptedException unused) {
                        this.s = 5;
                    }
                }
            }
            kaVar = new ka(this.e, this.r, this.f3215a, jwVar, this.s, c(), com.google.android.gms.ads.internal.ax.l().b() - jElapsedRealtime);
        }
        return kaVar;
    }

    @GuardedBy("mLock")
    private final kt c() {
        if (this.s != 0 || !e()) {
            return null;
        }
        try {
            if (b(4) && this.t != null && this.t.a() != 0) {
                return this.t;
            }
        } catch (RemoteException unused) {
            xe.e("Could not get cpm value from MediationResponseMetadata");
        }
        return new jz(f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final kn d() {
        String strValueOf = String.valueOf(this.f3215a);
        xe.d(strValueOf.length() != 0 ? "Instantiating mediation adapter: ".concat(strValueOf) : new String("Instantiating mediation adapter: "));
        if (!this.k && !this.e.b()) {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.f3215a)) {
                return a(new AdMobAdapter());
            }
            if ("com.google.ads.mediation.AdUrlAdapter".equals(this.f3215a)) {
                return a(new AdUrlAdapter());
            }
            if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(this.f3215a)) {
                return new li(new zzanu());
            }
        }
        try {
            return this.f3216b.a(this.f3215a);
        } catch (RemoteException e) {
            String strValueOf2 = String.valueOf(this.f3215a);
            xe.a(strValueOf2.length() != 0 ? "Could not instantiate mediation adapter: ".concat(strValueOf2) : new String("Could not instantiate mediation adapter: "), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void a(jw jwVar) {
        String strA = a(this.e.k);
        try {
            if (this.j.c < 4100000) {
                if (this.g.d) {
                    this.r.a(com.google.android.gms.dynamic.b.a(this.h), this.f, strA, jwVar);
                    return;
                } else {
                    this.r.a(com.google.android.gms.dynamic.b.a(this.h), this.g, this.f, strA, jwVar);
                    return;
                }
            }
            if (!this.k && !this.e.b()) {
                if (this.g.d) {
                    this.r.a(com.google.android.gms.dynamic.b.a(this.h), this.f, strA, this.e.f3209a, jwVar);
                    return;
                }
                if (this.p) {
                    if (this.e.o != null) {
                        this.r.a(com.google.android.gms.dynamic.b.a(this.h), this.f, strA, this.e.f3209a, jwVar, new br(b(this.e.s)), this.e.r);
                        return;
                    } else {
                        this.r.a(com.google.android.gms.dynamic.b.a(this.h), this.g, this.f, strA, this.e.f3209a, jwVar);
                        return;
                    }
                }
                this.r.a(com.google.android.gms.dynamic.b.a(this.h), this.g, this.f, strA, this.e.f3209a, jwVar);
                return;
            }
            ArrayList arrayList = new ArrayList(this.m);
            if (this.n != null) {
                for (String str : this.n) {
                    String str2 = ":false";
                    if (this.o != null && this.o.contains(str)) {
                        str2 = ":true";
                    }
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7 + String.valueOf(str2).length());
                    sb.append("custom:");
                    sb.append(str);
                    sb.append(str2);
                    arrayList.add(sb.toString());
                }
            }
            this.r.a(com.google.android.gms.dynamic.b.a(this.h), this.f, strA, this.e.f3209a, jwVar, this.l, arrayList);
        } catch (RemoteException e) {
            xe.c("Could not request ad from mediation adapter.", e);
            a(5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final boolean b(int i) {
        Bundle bundleJ;
        try {
            if (this.k) {
                bundleJ = this.r.l();
            } else if (this.g.d) {
                bundleJ = this.r.k();
            } else {
                bundleJ = this.r.j();
            }
            return bundleJ != null && (bundleJ.getInt("capabilities", 0) & i) == i;
        } catch (RemoteException unused) {
            xe.e("Could not get adapter info. Returning false");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e() {
        return this.d.m != -1;
    }

    @GuardedBy("mLock")
    private final String a(String str) {
        if (str == null || !e() || b(2)) {
            return str;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.remove("cpm_floor_cents");
            return jSONObject.toString();
        } catch (JSONException unused) {
            xe.e("Could not remove field. Returning the original value");
            return str;
        }
    }

    @GuardedBy("mLock")
    private final int f() {
        if (this.e.k == null) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.e.k);
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.f3215a)) {
                return jSONObject.optInt("cpm_cents", 0);
            }
            int iOptInt = b(2) ? jSONObject.optInt("cpm_floor_cents", 0) : 0;
            return iOptInt == 0 ? jSONObject.optInt("penalized_average_cpm_cents", 0) : iOptInt;
        } catch (JSONException unused) {
            xe.e("Could not convert to json. Returning 0");
            return 0;
        }
    }

    private static com.google.android.gms.ads.b.d b(String str) {
        d.a aVar = new d.a();
        if (str == null) {
            return aVar.a();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = 0;
            aVar.b(jSONObject.optBoolean("multiple_images", false));
            aVar.a(jSONObject.optBoolean("only_urls", false));
            String strOptString = jSONObject.optString("native_image_orientation", "any");
            if ("landscape".equals(strOptString)) {
                i = 2;
            } else if ("portrait".equals(strOptString)) {
                i = 1;
            } else if (!"any".equals(strOptString)) {
                i = -1;
            }
            aVar.a(i);
        } catch (JSONException e) {
            xe.c("Exception occurred when creating native ad options", e);
        }
        return aVar.a();
    }
}
