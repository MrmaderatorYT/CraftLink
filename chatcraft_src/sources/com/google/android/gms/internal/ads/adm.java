package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.concurrent.TimeUnit;

@qj
/* loaded from: classes.dex */
public final class adm {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1868a;

    /* renamed from: b, reason: collision with root package name */
    private final String f1869b;
    private final aar c;
    private final z d;
    private final ac e;
    private final long[] g;
    private final String[] h;
    private boolean m;
    private act n;
    private boolean o;
    private boolean p;
    private final yv f = new yy().a("min_1", Double.MIN_VALUE, 1.0d).a("1_5", 1.0d, 5.0d).a("5_10", 5.0d, 10.0d).a("10_20", 10.0d, 20.0d).a("20_30", 20.0d, 30.0d).a("30_max", 30.0d, Double.MAX_VALUE).a();
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private long q = -1;

    public adm(Context context, aar aarVar, String str, ac acVar, z zVar) {
        this.f1868a = context;
        this.c = aarVar;
        this.f1869b = str;
        this.e = acVar;
        this.d = zVar;
        String str2 = (String) bra.e().a(o.u);
        if (str2 == null) {
            this.h = new String[0];
            this.g = new long[0];
            return;
        }
        String[] strArrSplit = TextUtils.split(str2, ",");
        this.h = new String[strArrSplit.length];
        this.g = new long[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            try {
                this.g[i] = Long.parseLong(strArrSplit[i]);
            } catch (NumberFormatException e) {
                xe.c("Unable to parse frame hash target time number.", e);
                this.g[i] = -1;
            }
        }
    }

    public final void a(act actVar) {
        u.a(this.e, this.d, "vpc2");
        this.i = true;
        if (this.e != null) {
            this.e.a("vpn", actVar.a());
        }
        this.n = actVar;
    }

    public final void a() {
        if (!this.i || this.j) {
            return;
        }
        u.a(this.e, this.d, "vfr2");
        this.j = true;
    }

    public final void b() {
        if (!((Boolean) bra.e().a(o.t)).booleanValue() || this.o) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "native-player-metrics");
        bundle.putString("request", this.f1869b);
        bundle.putString("player", this.n.a());
        for (yx yxVar : this.f.a()) {
            String strValueOf = String.valueOf("fps_c_");
            String strValueOf2 = String.valueOf(yxVar.f3618a);
            bundle.putString(strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf), Integer.toString(yxVar.c));
            String strValueOf3 = String.valueOf("fps_p_");
            String strValueOf4 = String.valueOf(yxVar.f3618a);
            bundle.putString(strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3), Double.toString(yxVar.f3619b));
        }
        for (int i = 0; i < this.g.length; i++) {
            String str = this.h[i];
            if (str != null) {
                String strValueOf5 = String.valueOf(Long.valueOf(this.g[i]));
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf5).length() + 3);
                sb.append("fh_");
                sb.append(strValueOf5);
                bundle.putString(sb.toString(), str);
            }
        }
        com.google.android.gms.ads.internal.ax.e().a(this.f1868a, this.c.f1790a, "gmob-apps", bundle, true);
        this.o = true;
    }

    public final void b(act actVar) {
        if (this.k && !this.l) {
            if (xe.a() && !this.l) {
                xe.a("VideoMetricsMixin first frame");
            }
            u.a(this.e, this.d, "vff2");
            this.l = true;
        }
        long jC = com.google.android.gms.ads.internal.ax.l().c();
        if (this.m && this.p && this.q != -1) {
            double nanos = TimeUnit.SECONDS.toNanos(1L);
            double d = jC - this.q;
            Double.isNaN(nanos);
            Double.isNaN(d);
            this.f.a(nanos / d);
        }
        this.p = this.m;
        this.q = jC;
        long jLongValue = ((Long) bra.e().a(o.v)).longValue();
        long currentPosition = actVar.getCurrentPosition();
        for (int i = 0; i < this.h.length; i++) {
            if (this.h[i] == null && jLongValue > Math.abs(currentPosition - this.g[i])) {
                String[] strArr = this.h;
                int i2 = 8;
                Bitmap bitmap = actVar.getBitmap(8, 8);
                long j = 63;
                int i3 = 0;
                long j2 = 0;
                while (i3 < i2) {
                    long j3 = j;
                    int i4 = 0;
                    while (i4 < i2) {
                        int pixel = bitmap.getPixel(i4, i3);
                        j2 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1L : 0L) << ((int) j3);
                        i4++;
                        j3--;
                        i2 = 8;
                    }
                    i3++;
                    j = j3;
                    i2 = 8;
                }
                strArr[i] = String.format("%016X", Long.valueOf(j2));
                return;
            }
        }
    }

    public final void c() {
        this.m = true;
        if (!this.j || this.k) {
            return;
        }
        u.a(this.e, this.d, "vfp2");
        this.k = true;
    }

    public final void d() {
        this.m = false;
    }
}
