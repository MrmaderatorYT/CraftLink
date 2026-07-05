package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.gmsg.HttpClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class se extends xa {

    /* renamed from: a, reason: collision with root package name */
    private static final long f3439a = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: b, reason: collision with root package name */
    private static final Object f3440b = new Object();

    @GuardedBy("sLock")
    private static boolean c = false;
    private static hv d = null;
    private static HttpClient e = null;
    private static com.google.android.gms.ads.internal.gmsg.ah f = null;
    private static com.google.android.gms.ads.internal.gmsg.ac<Object> g = null;
    private final ql h;
    private final rj i;
    private final Object j;
    private final Context k;
    private il l;
    private box m;

    public se(Context context, rj rjVar, ql qlVar, box boxVar) {
        super(true);
        this.j = new Object();
        this.h = qlVar;
        this.k = context;
        this.i = rjVar;
        this.m = boxVar;
        synchronized (f3440b) {
            if (!c) {
                f = new com.google.android.gms.ads.internal.gmsg.ah();
                e = new HttpClient(context.getApplicationContext(), rjVar.j);
                g = new sm();
                d = new hv(this.k.getApplicationContext(), this.i.j, (String) bra.e().a(o.f3306a), new sl(), new sk());
                c = true;
            }
        }
    }

    protected static void a(hk hkVar) {
        hkVar.a("/loadAd", f);
        hkVar.a("/fetchHttpRequest", e);
        hkVar.a("/invalidRequest", g);
    }

    protected static void b(hk hkVar) {
        hkVar.b("/loadAd", f);
        hkVar.b("/fetchHttpRequest", e);
        hkVar.b("/invalidRequest", g);
    }

    @Override // com.google.android.gms.internal.ads.xa
    public final void a() throws ExecutionException, IllegalAccessException, InterruptedException, NoSuchMethodException, TimeoutException, SecurityException, IllegalArgumentException, InvocationTargetException {
        xe.b("SdkLessAdLoaderBackgroundTask started.");
        String strE = com.google.android.gms.ads.internal.ax.E().e(this.k);
        ri riVar = new ri(this.i, -1L, com.google.android.gms.ads.internal.ax.E().c(this.k), com.google.android.gms.ads.internal.ax.E().d(this.k), strE, com.google.android.gms.ads.internal.ax.E().f(this.k));
        rm rmVarA = a(riVar);
        if ((rmVarA.d == -2 || rmVarA.d == 3) && !TextUtils.isEmpty(strE)) {
            com.google.android.gms.ads.internal.ax.E().f(this.k, strE);
        }
        aac.f1778a.post(new sf(this, new wl(riVar, rmVarA, null, null, rmVarA.d, com.google.android.gms.ads.internal.ax.l().b(), rmVarA.m, null, this.m)));
    }

    private final rm a(ri riVar) throws ExecutionException, InterruptedException, TimeoutException {
        com.google.android.gms.ads.internal.ax.e();
        String strA = xn.a();
        JSONObject jSONObjectA = a(riVar, strA);
        if (jSONObjectA == null) {
            return new rm(0);
        }
        long jB = com.google.android.gms.ads.internal.ax.l().b();
        Future<JSONObject> futureA = f.a(strA);
        aac.f1778a.post(new sg(this, jSONObjectA, strA));
        try {
            JSONObject jSONObject = futureA.get(f3439a - (com.google.android.gms.ads.internal.ax.l().b() - jB), TimeUnit.MILLISECONDS);
            if (jSONObject == null) {
                return new rm(-1);
            }
            rm rmVarA = sw.a(this.k, riVar, jSONObject.toString());
            return (rmVarA.d == -3 || !TextUtils.isEmpty(rmVarA.f3428b)) ? rmVarA : new rm(3);
        } catch (InterruptedException | CancellationException unused) {
            return new rm(-1);
        } catch (ExecutionException unused2) {
            return new rm(0);
        } catch (TimeoutException unused3) {
            return new rm(2);
        }
    }

    private final JSONObject a(ri riVar, String str) throws ExecutionException, InterruptedException {
        ta taVar;
        AdvertisingIdClient.Info advertisingIdInfo;
        Bundle bundle = riVar.c.c.getBundle("sdk_less_server_data");
        if (bundle == null) {
            return null;
        }
        try {
            taVar = com.google.android.gms.ads.internal.ax.p().a(this.k).get();
        } catch (Exception e2) {
            xe.c("Error grabbing device info: ", e2);
            taVar = null;
        }
        Context context = this.k;
        sp spVar = new sp();
        spVar.i = riVar;
        spVar.j = taVar;
        JSONObject jSONObjectA = sw.a(context, spVar);
        if (jSONObjectA == null) {
            return null;
        }
        try {
            advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.k);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e3) {
            xe.c("Cannot get advertising id info", e3);
            advertisingIdInfo = null;
        }
        HashMap map = new HashMap();
        map.put("request_id", str);
        map.put("request_param", jSONObjectA);
        map.put("data", bundle);
        if (advertisingIdInfo != null) {
            map.put("adid", advertisingIdInfo.getId());
            map.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 1 : 0));
        }
        try {
            return com.google.android.gms.ads.internal.ax.e().a(map);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.xa
    public final void c_() {
        synchronized (this.j) {
            aac.f1778a.post(new sj(this));
        }
    }
}
