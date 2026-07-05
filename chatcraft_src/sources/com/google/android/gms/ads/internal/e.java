package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.aar;
import com.google.android.gms.internal.ads.aax;
import com.google.android.gms.internal.ads.aaz;
import com.google.android.gms.internal.ads.abl;
import com.google.android.gms.internal.ads.abq;
import com.google.android.gms.internal.ads.bra;
import com.google.android.gms.internal.ads.ix;
import com.google.android.gms.internal.ads.jd;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.wo;
import com.google.android.gms.internal.ads.xe;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    private Context f1574b;

    /* renamed from: a, reason: collision with root package name */
    private final Object f1573a = new Object();
    private long c = 0;

    public final void a(Context context, aar aarVar, String str, Runnable runnable) {
        a(context, aarVar, true, null, str, null, runnable);
    }

    final void a(Context context, aar aarVar, boolean z, wo woVar, String str, String str2, Runnable runnable) {
        if (ax.l().b() - this.c < 5000) {
            xe.e("Not retrying to fetch app settings");
            return;
        }
        this.c = ax.l().b();
        boolean z2 = true;
        if (woVar != null) {
            if (!(ax.l().a() - woVar.a() > ((Long) bra.e().a(com.google.android.gms.internal.ads.o.bM)).longValue()) && woVar.b()) {
                z2 = false;
            }
        }
        if (z2) {
            if (context == null) {
                xe.e("Context not provided to fetch application settings");
                return;
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                xe.e("App settings could not be fetched. Required parameters missing");
                return;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            this.f1574b = applicationContext;
            ix ixVarA = ax.t().a(this.f1574b, aarVar).a("google.afma.config.fetchAppSettings", jd.f3191a, jd.f3191a);
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("app_id", str);
                } else if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("ad_unit_id", str2);
                }
                jSONObject.put("is_init", z);
                jSONObject.put("pn", context.getPackageName());
                abl ablVarB = ixVarA.b(jSONObject);
                abl ablVarA = aaz.a(ablVarB, f.f1575a, abq.f1817b);
                if (runnable != null) {
                    ablVarB.a(runnable, abq.f1817b);
                }
                aax.a(ablVarA, "ConfigLoader.maybeFetchNewAppSettings");
            } catch (Exception e) {
                xe.b("Error requesting application settings", e);
            }
        }
    }
}
