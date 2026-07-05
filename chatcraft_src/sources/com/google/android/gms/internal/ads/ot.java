package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class ot implements Callable<wk> {

    /* renamed from: a, reason: collision with root package name */
    private static long f3326a = 10;

    /* renamed from: b, reason: collision with root package name */
    private final Context f3327b;
    private final yz c;
    private final com.google.android.gms.ads.internal.ad d;
    private final axe e;
    private final pn f;
    private final wl h;
    private final ac i;
    private JSONObject m;
    private final Object g = new Object();
    private boolean j = false;
    private int k = -2;
    private List<String> l = null;
    private String n = null;
    private String o = null;

    public ot(Context context, com.google.android.gms.ads.internal.ad adVar, yz yzVar, axe axeVar, wl wlVar, ac acVar) {
        this.f3327b = context;
        this.d = adVar;
        this.c = yzVar;
        this.h = wlVar;
        this.e = axeVar;
        this.i = acVar;
        this.f = adVar.I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040 A[Catch: Exception -> 0x0209, TimeoutException -> 0x0210, InterruptedException | CancellationException | ExecutionException | JSONException -> 0x0217, TryCatch #2 {InterruptedException | CancellationException | ExecutionException | JSONException -> 0x0217, TimeoutException -> 0x0210, Exception -> 0x0209, blocks: (B:3:0x0002, B:5:0x000e, B:7:0x002a, B:9:0x0032, B:12:0x003a, B:15:0x0044, B:17:0x005c, B:20:0x0071, B:23:0x007b, B:32:0x00af, B:36:0x00b9, B:38:0x00d3, B:40:0x00dd, B:42:0x00e5, B:45:0x00f1, B:64:0x016e, B:69:0x017a, B:79:0x01a8, B:81:0x01c8, B:82:0x01ce, B:84:0x01e8, B:86:0x01ec, B:87:0x01fb, B:78:0x01a4, B:72:0x018a, B:73:0x0191, B:75:0x0197, B:46:0x00f8, B:48:0x0100, B:49:0x010a, B:51:0x0112, B:52:0x011c, B:54:0x0124, B:56:0x0143, B:57:0x0149, B:59:0x015b, B:61:0x0166, B:60:0x0160, B:62:0x016a, B:25:0x0081, B:27:0x0089, B:28:0x008e, B:30:0x009a, B:31:0x009f, B:14:0x0040), top: B:100:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005c A[Catch: Exception -> 0x0209, TimeoutException -> 0x0210, InterruptedException | CancellationException | ExecutionException | JSONException -> 0x0217, TryCatch #2 {InterruptedException | CancellationException | ExecutionException | JSONException -> 0x0217, TimeoutException -> 0x0210, Exception -> 0x0209, blocks: (B:3:0x0002, B:5:0x000e, B:7:0x002a, B:9:0x0032, B:12:0x003a, B:15:0x0044, B:17:0x005c, B:20:0x0071, B:23:0x007b, B:32:0x00af, B:36:0x00b9, B:38:0x00d3, B:40:0x00dd, B:42:0x00e5, B:45:0x00f1, B:64:0x016e, B:69:0x017a, B:79:0x01a8, B:81:0x01c8, B:82:0x01ce, B:84:0x01e8, B:86:0x01ec, B:87:0x01fb, B:78:0x01a4, B:72:0x018a, B:73:0x0191, B:75:0x0197, B:46:0x00f8, B:48:0x0100, B:49:0x010a, B:51:0x0112, B:52:0x011c, B:54:0x0124, B:56:0x0143, B:57:0x0149, B:59:0x015b, B:61:0x0166, B:60:0x0160, B:62:0x016a, B:25:0x0081, B:27:0x0089, B:28:0x008e, B:30:0x009a, B:31:0x009f, B:14:0x0040), top: B:100:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0221  */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.wk call() throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 553
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ot.call():com.google.android.gms.internal.ads.wk");
    }

    private static afu b(abl<afu> ablVar) {
        try {
            return ablVar.get(((Integer) bra.e().a(o.bA)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            aan.c(BuildConfig.FLAVOR, e);
            Thread.currentThread().interrupt();
            return null;
        } catch (CancellationException | ExecutionException | TimeoutException e2) {
            aan.c(BuildConfig.FLAVOR, e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(cz czVar, String str) {
        try {
            dj djVarC = this.d.c(czVar.b());
            if (djVarC != null) {
                djVarC.a(czVar, str);
            }
        } catch (RemoteException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40);
            sb.append("Failed to call onCustomClick for asset ");
            sb.append(str);
            sb.append(".");
            xe.c(sb.toString(), e);
        }
    }

    private final wk a(bh bhVar, boolean z) {
        int i;
        synchronized (this.g) {
            i = (bhVar == null && this.k == -2) ? 0 : this.k;
        }
        return new wk(this.h.f3545a.c, null, this.h.f3546b.c, i, this.h.f3546b.e, this.l, this.h.f3546b.k, this.h.f3546b.j, this.h.f3545a.i, false, null, null, null, null, null, 0L, this.h.d, this.h.f3546b.f, this.h.f, this.h.g, this.h.f3546b.n, this.m, i != -2 ? null : bhVar, null, null, null, this.h.f3546b.D, this.h.f3546b.E, null, this.h.f3546b.H, this.n, this.h.i, this.h.f3546b.O, this.h.j, z, this.h.f3546b.R, this.h.f3546b.S, this.o, this.h.f3546b.V);
    }

    public final abl<ao> a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("attribution");
        if (jSONObjectOptJSONObject == null) {
            return aaz.a((Object) null);
        }
        String strOptString = jSONObjectOptJSONObject.optString("text");
        int iOptInt = jSONObjectOptJSONObject.optInt("text_size", -1);
        Integer numB = b(jSONObjectOptJSONObject, "text_color");
        Integer numB2 = b(jSONObjectOptJSONObject, "bg_color");
        int iOptInt2 = jSONObjectOptJSONObject.optInt("animation_ms", 1000);
        int iOptInt3 = jSONObjectOptJSONObject.optInt("presentation_ms", 4000);
        int i = (this.h.f3545a.y == null || this.h.f3545a.y.f2996a < 2) ? 1 : this.h.f3545a.y.e;
        boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("allow_pub_rendering");
        List<abl<at>> arrayList = new ArrayList<>();
        if (jSONObjectOptJSONObject.optJSONArray("images") != null) {
            arrayList = a(jSONObjectOptJSONObject, "images", false, false, true);
        } else {
            arrayList.add(a(jSONObjectOptJSONObject, "image", false, false));
        }
        abv abvVar = new abv();
        int size = arrayList.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Iterator<abl<at>> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a(new pb(atomicInteger, size, abvVar, arrayList), xl.f3579a);
            arrayList = arrayList;
        }
        return aaz.a(abvVar, new oz(this, strOptString, numB2, numB, iOptInt, iOptInt3, iOptInt2, i, zOptBoolean), xl.f3579a);
    }

    private static Integer b(JSONObject jSONObject, String str) throws JSONException {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final Future<at> a(JSONObject jSONObject, String str, boolean z) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        boolean zOptBoolean = jSONObject2.optBoolean("require", true);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return a(jSONObject2, zOptBoolean, z);
    }

    public final abl<at> a(JSONObject jSONObject, String str, boolean z, boolean z2) {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return a(jSONObject2, z, z2);
    }

    public final List<abl<at>> a(JSONObject jSONObject, String str, boolean z, boolean z2, boolean z3) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
            a(0, false);
            return arrayList;
        }
        int length = z3 ? jSONArrayOptJSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            arrayList.add(a(jSONObject2, false, z2));
        }
        return arrayList;
    }

    private final abl<at> a(JSONObject jSONObject, boolean z, boolean z2) throws JSONException {
        String strOptString;
        if (z) {
            strOptString = jSONObject.getString("url");
        } else {
            strOptString = jSONObject.optString("url");
        }
        double dOptDouble = jSONObject.optDouble("scale", 1.0d);
        boolean zOptBoolean = jSONObject.optBoolean("is_transparent", true);
        if (TextUtils.isEmpty(strOptString)) {
            a(0, z);
            return aaz.a((Object) null);
        }
        if (z2) {
            return aaz.a(new at(null, Uri.parse(strOptString), dOptDouble));
        }
        return this.c.a(strOptString, new pa(this, z, dOptDouble, zOptBoolean, strOptString));
    }

    public final abl<afu> a(JSONObject jSONObject, String str) {
        final JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject == null) {
            return aaz.a((Object) null);
        }
        if (TextUtils.isEmpty(jSONObjectOptJSONObject.optString("vast_xml"))) {
            xe.e("Required field 'vast_xml' is missing");
            return aaz.a((Object) null);
        }
        final pd pdVarA = a(this.f3327b, this.e, this.h, this.i, this.d);
        final boolean zEquals = "instream".equals(jSONObject.optString("type"));
        final abv abvVar = new abv();
        abq.f1816a.execute(new Runnable(pdVarA, zEquals, jSONObjectOptJSONObject, abvVar) { // from class: com.google.android.gms.internal.ads.pe

            /* renamed from: a, reason: collision with root package name */
            private final pd f3346a;

            /* renamed from: b, reason: collision with root package name */
            private final boolean f3347b;
            private final JSONObject c;
            private final abv d;

            {
                this.f3346a = pdVarA;
                this.f3347b = zEquals;
                this.c = jSONObjectOptJSONObject;
                this.d = abvVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f3346a.a(this.f3347b, this.c, this.d);
            }
        });
        return abvVar;
    }

    public final abl<afu> a(final String str, final String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return aaz.a((Object) null);
        }
        final pd pdVarA = a(this.f3327b, this.e, this.h, this.i, this.d);
        final abv abvVar = new abv();
        final boolean z2 = true;
        abq.f1816a.execute(new Runnable(pdVarA, z2, abvVar, str, str2) { // from class: com.google.android.gms.internal.ads.pf

            /* renamed from: a, reason: collision with root package name */
            private final pd f3348a;

            /* renamed from: b, reason: collision with root package name */
            private final boolean f3349b = true;
            private final abv c;
            private final String d;
            private final String e;

            {
                this.f3348a = pdVarA;
                this.c = abvVar;
                this.d = str;
                this.e = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f3348a.a(this.f3349b, this.c, this.d, this.e);
            }
        });
        return abvVar;
    }

    private final boolean b() {
        boolean z;
        synchronized (this.g) {
            z = this.j;
        }
        return z;
    }

    private final void a(int i) {
        synchronized (this.g) {
            this.j = true;
            this.k = i;
        }
    }

    public final void a(int i, boolean z) {
        if (z) {
            a(i);
        }
    }

    static afu a(abl<afu> ablVar) {
        try {
            return ablVar.get(((Integer) bra.e().a(o.bz)).intValue(), TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            xe.c("InterruptedException occurred while waiting for video to load", e);
            Thread.currentThread().interrupt();
            return null;
        } catch (CancellationException | ExecutionException | TimeoutException e2) {
            xe.c("Exception occurred while waiting for video to load", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <V> List<V> b(List<abl<V>> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<abl<V>> it = list.iterator();
        while (it.hasNext()) {
            V v = it.next().get();
            if (v != null) {
                arrayList.add(v);
            }
        }
        return arrayList;
    }

    private static pd a(Context context, axe axeVar, wl wlVar, ac acVar, com.google.android.gms.ads.internal.ad adVar) {
        return new pd(context, axeVar, wlVar, acVar, adVar);
    }

    final /* synthetic */ abl a(String str, Object obj) {
        com.google.android.gms.ads.internal.ax.f();
        afu afuVarA = aga.a(this.f3327b, ahh.a(), "native-omid", false, false, this.e, this.h.f3545a.k, this.i, null, this.d.i(), this.h.i);
        final abu abuVarA = abu.a(afuVarA);
        afuVarA.w().a(new ahc(abuVarA) { // from class: com.google.android.gms.internal.ads.ov

            /* renamed from: a, reason: collision with root package name */
            private final abu f3330a;

            {
                this.f3330a = abuVarA;
            }

            @Override // com.google.android.gms.internal.ads.ahc
            public final void a(boolean z) {
                this.f3330a.a();
            }
        });
        afuVarA.loadData(str, "text/html", "UTF-8");
        return abuVarA;
    }
}
