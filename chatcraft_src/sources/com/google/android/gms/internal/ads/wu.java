package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import javax.annotation.concurrent.GuardedBy;

@qj
/* loaded from: classes.dex */
public final class wu {
    private final String g;
    private final xh h;

    /* renamed from: b, reason: collision with root package name */
    private long f3562b = -1;
    private long c = -1;

    @GuardedBy("mLock")
    private int d = -1;

    /* renamed from: a, reason: collision with root package name */
    int f3561a = -1;
    private long e = 0;
    private final Object f = new Object();

    @GuardedBy("mLock")
    private int i = 0;

    @GuardedBy("mLock")
    private int j = 0;

    public wu(String str, xh xhVar) {
        this.g = str;
        this.h = xhVar;
    }

    public final void a() {
        synchronized (this.f) {
            this.i++;
        }
    }

    public final void b() {
        synchronized (this.f) {
            this.j++;
        }
    }

    public final void a(bqj bqjVar, long j) {
        synchronized (this.f) {
            long jI = this.h.i();
            long jA = com.google.android.gms.ads.internal.ax.l().a();
            if (this.c == -1) {
                if (jA - jI > ((Long) bra.e().a(o.av)).longValue()) {
                    this.f3561a = -1;
                } else {
                    this.f3561a = this.h.j();
                }
                this.c = j;
                this.f3562b = this.c;
            } else {
                this.f3562b = j;
            }
            if (bqjVar == null || bqjVar.c == null || bqjVar.c.getInt("gw", 2) != 1) {
                this.d++;
                this.f3561a++;
                if (this.f3561a == 0) {
                    this.e = 0L;
                    this.h.b(jA);
                } else {
                    this.e = jA - this.h.k();
                }
            }
        }
    }

    public final Bundle a(Context context, String str) {
        Bundle bundle;
        synchronized (this.f) {
            bundle = new Bundle();
            bundle.putString("session_id", this.g);
            bundle.putLong("basets", this.c);
            bundle.putLong("currts", this.f3562b);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.d);
            bundle.putInt("preqs_in_session", this.f3561a);
            bundle.putLong("time_in_session", this.e);
            bundle.putInt("pclick", this.i);
            bundle.putInt("pimp", this.j);
            bundle.putBoolean("support_transparent_background", a(context));
        }
        return bundle;
    }

    private static boolean a(Context context) {
        int identifier = context.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (identifier == 0) {
            xe.d("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.google.android.gms.ads.AdActivity"), 0).theme) {
                return true;
            }
            xe.d("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            xe.e("Fail to fetch AdActivity theme");
            xe.d("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }
}
