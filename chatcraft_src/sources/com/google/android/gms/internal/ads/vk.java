package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class vk implements vv {

    /* renamed from: a, reason: collision with root package name */
    private static List<Future<Void>> f3520a = Collections.synchronizedList(new ArrayList());

    /* renamed from: b, reason: collision with root package name */
    private static ScheduledExecutorService f3521b = Executors.newSingleThreadScheduledExecutor();

    @GuardedBy("mLock")
    private final avh c;

    @GuardedBy("mLock")
    private final LinkedHashMap<String, avn> d;
    private final Context g;
    private final vx h;
    private boolean i;
    private final vs j;
    private final vy k;

    @GuardedBy("mLock")
    private final List<String> e = new ArrayList();

    @GuardedBy("mLock")
    private final List<String> f = new ArrayList();
    private final Object l = new Object();
    private HashSet<String> m = new HashSet<>();
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;

    public vk(Context context, aar aarVar, vs vsVar, String str, vx vxVar) {
        com.google.android.gms.common.internal.i.a(vsVar, "SafeBrowsing config is not present.");
        this.g = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.d = new LinkedHashMap<>();
        this.h = vxVar;
        this.j = vsVar;
        Iterator<String> it = this.j.e.iterator();
        while (it.hasNext()) {
            this.m.add(it.next().toLowerCase(Locale.ENGLISH));
        }
        this.m.remove("cookie".toLowerCase(Locale.ENGLISH));
        avh avhVar = new avh();
        avhVar.f2307a = 8;
        avhVar.f2308b = str;
        avhVar.c = str;
        avhVar.d = new avi();
        avhVar.d.f2309a = this.j.f3528a;
        avo avoVar = new avo();
        avoVar.f2320a = aarVar.f1790a;
        avoVar.c = Boolean.valueOf(com.google.android.gms.common.b.c.a(this.g).a());
        long jB = com.google.android.gms.common.d.a().b(this.g);
        if (jB > 0) {
            avoVar.f2321b = Long.valueOf(jB);
        }
        avhVar.h = avoVar;
        this.c = avhVar;
        this.k = new vy(this.g, this.j.h, this);
    }

    static final /* synthetic */ Void d(String str) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.vv
    public final vs a() {
        return this.j;
    }

    @Override // com.google.android.gms.internal.ads.vv
    public final void a(String str) {
        synchronized (this.l) {
            this.c.f = str;
        }
    }

    @Override // com.google.android.gms.internal.ads.vv
    public final boolean b() {
        return com.google.android.gms.common.util.j.f() && this.j.c && !this.o;
    }

    @Override // com.google.android.gms.internal.ads.vv
    public final void a(View view) {
        if (this.j.c && !this.o) {
            com.google.android.gms.ads.internal.ax.e();
            Bitmap bitmapB = xn.b(view);
            if (bitmapB == null) {
                vu.a("Failed to capture the webview bitmap.");
            } else {
                this.o = true;
                xn.a(new vn(this, bitmapB));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.vv
    public final void a(String str, Map<String, String> map, int i) {
        synchronized (this.l) {
            if (i == 3) {
                try {
                    this.p = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.d.containsKey(str)) {
                if (i == 3) {
                    this.d.get(str).d = Integer.valueOf(i);
                }
                return;
            }
            avn avnVar = new avn();
            avnVar.d = Integer.valueOf(i);
            avnVar.f2318a = Integer.valueOf(this.d.size());
            avnVar.f2319b = str;
            avnVar.c = new avk();
            if (this.m.size() > 0 && map != null) {
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    try {
                        String key = entry.getKey() != null ? entry.getKey() : BuildConfig.FLAVOR;
                        String value = entry.getValue() != null ? entry.getValue() : BuildConfig.FLAVOR;
                        if (this.m.contains(key.toLowerCase(Locale.ENGLISH))) {
                            avj avjVar = new avj();
                            avjVar.f2310a = key.getBytes("UTF-8");
                            avjVar.f2311b = value.getBytes("UTF-8");
                            arrayList.add(avjVar);
                        }
                    } catch (UnsupportedEncodingException unused) {
                        vu.a("Cannot convert string to bytes, skip header.");
                    }
                }
                avj[] avjVarArr = new avj[arrayList.size()];
                arrayList.toArray(avjVarArr);
                avnVar.c.f2312a = avjVarArr;
            }
            this.d.put(str, avnVar);
        }
    }

    final void b(String str) {
        synchronized (this.l) {
            this.e.add(str);
        }
    }

    final void c(String str) {
        synchronized (this.l) {
            this.f.add(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.vv
    public final String[] a(String[] strArr) {
        return (String[]) this.k.a(strArr).toArray(new String[0]);
    }

    @Override // com.google.android.gms.internal.ads.vv
    public final void c() {
        this.n = true;
    }

    private final avn e(String str) {
        avn avnVar;
        synchronized (this.l) {
            avnVar = this.d.get(str);
        }
        return avnVar;
    }

    @Override // com.google.android.gms.internal.ads.vv
    public final void d() {
        synchronized (this.l) {
            abl ablVarA = aaz.a(this.h.a(this.g, this.d.keySet()), new aau(this) { // from class: com.google.android.gms.internal.ads.vl

                /* renamed from: a, reason: collision with root package name */
                private final vk f3522a;

                {
                    this.f3522a = this;
                }

                @Override // com.google.android.gms.internal.ads.aau
                public final abl a(Object obj) {
                    return this.f3522a.a((Map) obj);
                }
            }, abq.f1817b);
            abl ablVarA2 = aaz.a(ablVarA, 10L, TimeUnit.SECONDS, f3521b);
            aaz.a(ablVarA, new vo(this, ablVarA2), abq.f1817b);
            f3520a.add(ablVarA2);
        }
    }

    private final abl<Void> f() {
        abl<Void> ablVarA;
        if (!((this.i && this.j.g) || (this.p && this.j.f) || (!this.i && this.j.d))) {
            return aaz.a((Object) null);
        }
        synchronized (this.l) {
            this.c.e = new avn[this.d.size()];
            this.d.values().toArray(this.c.e);
            this.c.i = (String[]) this.e.toArray(new String[0]);
            this.c.j = (String[]) this.f.toArray(new String[0]);
            if (vu.a()) {
                String str = this.c.f2308b;
                String str2 = this.c.f;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 53 + String.valueOf(str2).length());
                sb.append("Sending SB report\n  url: ");
                sb.append(str);
                sb.append("\n  clickUrl: ");
                sb.append(str2);
                sb.append("\n  resources: \n");
                StringBuilder sb2 = new StringBuilder(sb.toString());
                for (avn avnVar : this.c.e) {
                    sb2.append("    [");
                    sb2.append(avnVar.e.length);
                    sb2.append("] ");
                    sb2.append(avnVar.f2319b);
                }
                vu.a(sb2.toString());
            }
            abl<String> ablVarA2 = new yz(this.g).a(1, this.j.f3529b, null, aus.a(this.c));
            if (vu.a()) {
                ablVarA2.a(new vp(this), xl.f3579a);
            }
            ablVarA = aaz.a(ablVarA2, vm.f3523a, abq.f1817b);
        }
        return ablVarA;
    }

    final /* synthetic */ abl a(Map map) {
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray jSONArrayOptJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (jSONArrayOptJSONArray != null) {
                        synchronized (this.l) {
                            int length = jSONArrayOptJSONArray.length();
                            avn avnVarE = e(str);
                            if (avnVarE == null) {
                                String strValueOf = String.valueOf(str);
                                vu.a(strValueOf.length() != 0 ? "Cannot find the corresponding resource object for ".concat(strValueOf) : new String("Cannot find the corresponding resource object for "));
                            } else {
                                avnVarE.e = new String[length];
                                for (int i = 0; i < length; i++) {
                                    avnVarE.e[i] = jSONArrayOptJSONArray.getJSONObject(i).getString("threat_type");
                                }
                                this.i = (length > 0) | this.i;
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                if (((Boolean) bra.e().a(o.bU)).booleanValue()) {
                    xe.a("Failed to get SafeBrowsing metadata", e);
                }
                return aaz.a((Throwable) new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.i) {
            synchronized (this.l) {
                this.c.f2307a = 9;
            }
        }
        return f();
    }
}
