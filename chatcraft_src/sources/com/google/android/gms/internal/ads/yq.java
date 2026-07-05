package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class yq {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3610a = new Object();

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("mLock")
    private String f3611b = BuildConfig.FLAVOR;

    @GuardedBy("mLock")
    private String c = BuildConfig.FLAVOR;

    @GuardedBy("mLock")
    private boolean d = false;
    private String e = BuildConfig.FLAVOR;

    public final void a(Context context, String str, String str2) {
        if (!b(context, str, str2)) {
            a(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
            return;
        }
        if ("2".equals(this.e)) {
            xe.b("Creative is not pushed for this device.");
            a(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(this.e)) {
            xe.b("The app is not linked for creative preview.");
            e(context, str, str2);
        } else if ("0".equals(this.e)) {
            xe.b("Device is linked for in app preview.");
            a(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final void a(Context context, String str, String str2, @Nullable String str3) {
        boolean zB = b();
        if (c(context, str, str2)) {
            if (!zB && !TextUtils.isEmpty(str3)) {
                b(context, str2, str3, str);
            }
            xe.b("Device is linked for debug signals.");
            a(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        e(context, str, str2);
    }

    private final boolean b(Context context, String str, String str2) {
        String strD = d(context, c(context, (String) bra.e().a(o.cl), str, str2).toString(), str2);
        if (TextUtils.isEmpty(strD)) {
            xe.b("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(strD.trim());
            String strOptString = jSONObject.optString("gct");
            this.e = jSONObject.optString("status");
            synchronized (this.f3610a) {
                this.c = strOptString;
            }
            return true;
        } catch (JSONException e) {
            xe.c("Fail to get in app preview response json.", e);
            return false;
        }
    }

    private final boolean c(Context context, String str, String str2) {
        String strD = d(context, c(context, (String) bra.e().a(o.cm), str, str2).toString(), str2);
        if (TextUtils.isEmpty(strD)) {
            xe.b("Not linked for debug signals.");
            return false;
        }
        try {
            boolean zEquals = "1".equals(new JSONObject(strD.trim()).optString("debug_mode"));
            synchronized (this.f3610a) {
                this.d = zEquals;
            }
            return zEquals;
        } catch (JSONException e) {
            xe.c("Fail to get debug mode response json.", e);
            return false;
        }
    }

    private static String d(Context context, String str, String str2) {
        HashMap map = new HashMap();
        map.put("User-Agent", com.google.android.gms.ads.internal.ax.e().b(context, str2));
        abl<String> ablVarA = new yz(context).a(str, map);
        try {
            return ablVarA.get(((Integer) bra.e().a(o.co)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            String strValueOf = String.valueOf(str);
            xe.b(strValueOf.length() != 0 ? "Interrupted while retriving a response from: ".concat(strValueOf) : new String("Interrupted while retriving a response from: "), e);
            ablVarA.cancel(true);
            return null;
        } catch (TimeoutException e2) {
            String strValueOf2 = String.valueOf(str);
            xe.b(strValueOf2.length() != 0 ? "Timeout while retriving a response from: ".concat(strValueOf2) : new String("Timeout while retriving a response from: "), e2);
            ablVarA.cancel(true);
            return null;
        } catch (Exception e3) {
            String strValueOf3 = String.valueOf(str);
            xe.b(strValueOf3.length() != 0 ? "Error retriving a response from: ".concat(strValueOf3) : new String("Error retriving a response from: "), e3);
            return null;
        }
    }

    private final void e(Context context, String str, String str2) {
        com.google.android.gms.ads.internal.ax.e();
        xn.a(context, c(context, (String) bra.e().a(o.ck), str, str2));
    }

    public final void b(Context context, String str, String str2, String str3) {
        Uri.Builder builderBuildUpon = c(context, (String) bra.e().a(o.cn), str3, str).buildUpon();
        builderBuildUpon.appendQueryParameter("debugData", str2);
        com.google.android.gms.ads.internal.ax.e();
        xn.a(context, str, builderBuildUpon.build().toString());
    }

    private final Uri c(Context context, String str, String str2, String str3) {
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        builderBuildUpon.appendQueryParameter("linkedDeviceId", a(context));
        builderBuildUpon.appendQueryParameter("adSlotPath", str2);
        builderBuildUpon.appendQueryParameter("afmaVersion", str3);
        return builderBuildUpon.build();
    }

    private final String a(Context context) {
        String str;
        synchronized (this.f3610a) {
            if (TextUtils.isEmpty(this.f3611b)) {
                com.google.android.gms.ads.internal.ax.e();
                this.f3611b = xn.c(context, "debug_signals_id.txt");
                if (TextUtils.isEmpty(this.f3611b)) {
                    com.google.android.gms.ads.internal.ax.e();
                    this.f3611b = xn.a();
                    com.google.android.gms.ads.internal.ax.e();
                    xn.b(context, "debug_signals_id.txt", this.f3611b);
                }
            }
            str = this.f3611b;
        }
        return str;
    }

    public final String a() {
        String str;
        synchronized (this.f3610a) {
            str = this.c;
        }
        return str;
    }

    public final boolean b() {
        boolean z;
        synchronized (this.f3610a) {
            z = this.d;
        }
        return z;
    }

    private final void a(Context context, String str, boolean z, boolean z2) {
        if (!(context instanceof Activity)) {
            xe.d("Can not create dialog without Activity Context");
        } else {
            xn.f3583a.post(new yr(this, context, str, z, z2));
        }
    }
}
