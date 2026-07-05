package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@qj
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private String f3382a = (String) bra.e().a(o.L);

    /* renamed from: b, reason: collision with root package name */
    private Map<String, String> f3383b = new LinkedHashMap();
    private Context c;
    private String d;

    public q(Context context, String str) throws ExecutionException, InterruptedException {
        this.c = null;
        this.d = null;
        this.c = context;
        this.d = str;
        this.f3383b.put("s", "gmob_sdk");
        this.f3383b.put("v", "3");
        this.f3383b.put("os", Build.VERSION.RELEASE);
        this.f3383b.put("sdk", Build.VERSION.SDK);
        Map<String, String> map = this.f3383b;
        com.google.android.gms.ads.internal.ax.e();
        map.put("device", xn.b());
        this.f3383b.put("app", context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        Map<String, String> map2 = this.f3383b;
        com.google.android.gms.ads.internal.ax.e();
        map2.put("is_lite_sdk", xn.l(context) ? "1" : "0");
        Future<ta> futureA = com.google.android.gms.ads.internal.ax.p().a(this.c);
        try {
            futureA.get();
            this.f3383b.put("network_coarse", Integer.toString(futureA.get().o));
            this.f3383b.put("network_fine", Integer.toString(futureA.get().p));
        } catch (Exception e) {
            com.google.android.gms.ads.internal.ax.i().a(e, "CsiConfiguration.CsiConfiguration");
        }
    }

    final String a() {
        return this.f3382a;
    }

    final Context b() {
        return this.c;
    }

    final String c() {
        return this.d;
    }

    final Map<String, String> d() {
        return this.f3383b;
    }
}
