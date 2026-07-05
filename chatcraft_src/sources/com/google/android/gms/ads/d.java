package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.aac;
import com.google.android.gms.internal.ads.bqn;
import com.google.android.gms.internal.ads.bra;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f1484a = new d(ModuleDescriptor.MODULE_VERSION, 50, "320x50_mb");

    /* renamed from: b, reason: collision with root package name */
    public static final d f1485b = new d(468, 60, "468x60_as");
    public static final d c = new d(ModuleDescriptor.MODULE_VERSION, 100, "320x100_as");
    public static final d d = new d(728, 90, "728x90_as");
    public static final d e = new d(300, 250, "300x250_as");
    public static final d f = new d(160, 600, "160x600_as");
    public static final d g = new d(-1, -2, "smart_banner");
    public static final d h = new d(-3, -4, "fluid");
    public static final d i = new d(50, 50, "50x50_mb");
    public static final d j = new d(-3, 0, "search_v2");
    private final int k;
    private final int l;
    private final String m;

    public d(int i2, int i3) {
        String strValueOf = i2 == -1 ? "FULL" : String.valueOf(i2);
        String strValueOf2 = i3 == -2 ? "AUTO" : String.valueOf(i3);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 4 + String.valueOf(strValueOf2).length());
        sb.append(strValueOf);
        sb.append("x");
        sb.append(strValueOf2);
        sb.append("_as");
        this(i2, i3, sb.toString());
    }

    d(int i2, int i3, String str) {
        if (i2 < 0 && i2 != -1 && i2 != -3) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Invalid width for AdSize: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i3 < 0 && i3 != -2 && i3 != -4) {
            StringBuilder sb2 = new StringBuilder(38);
            sb2.append("Invalid height for AdSize: ");
            sb2.append(i3);
            throw new IllegalArgumentException(sb2.toString());
        }
        this.k = i2;
        this.l = i3;
        this.m = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.k == dVar.k && this.l == dVar.l && this.m.equals(dVar.m);
    }

    public final int a() {
        return this.l;
    }

    public final int a(Context context) {
        switch (this.l) {
            case -4:
            case -3:
                return -1;
            case -2:
                return bqn.b(context.getResources().getDisplayMetrics());
            default:
                bra.a();
                return aac.a(context, this.l);
        }
    }

    public final int b() {
        return this.k;
    }

    public final int b(Context context) {
        int i2 = this.k;
        if (i2 == -1) {
            return bqn.a(context.getResources().getDisplayMetrics());
        }
        switch (i2) {
            case -4:
            case -3:
                return -1;
            default:
                bra.a();
                return aac.a(context, this.k);
        }
    }

    public final int hashCode() {
        return this.m.hashCode();
    }

    public final boolean c() {
        return this.k == -3 && this.l == -4;
    }

    public final String toString() {
        return this.m;
    }
}
