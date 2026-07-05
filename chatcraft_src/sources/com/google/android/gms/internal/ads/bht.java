package com.google.android.gms.internal.ads;

import android.net.Uri;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public final class bht {

    /* renamed from: a, reason: collision with root package name */
    public final long f2687a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2688b;
    private final String c;
    private int d;

    public bht(String str, long j, long j2) {
        this.c = str == null ? BuildConfig.FLAVOR : str;
        this.f2687a = j;
        this.f2688b = j2;
    }

    public final Uri a(String str) {
        return Uri.parse(bkf.a(str, this.c));
    }

    private final String b(String str) {
        return bkf.a(str, this.c);
    }

    public final bht a(bht bhtVar, String str) {
        String strB = b(str);
        if (bhtVar == null || !strB.equals(bhtVar.b(str))) {
            return null;
        }
        if (this.f2688b != -1 && this.f2687a + this.f2688b == bhtVar.f2687a) {
            return new bht(strB, this.f2687a, bhtVar.f2688b != -1 ? this.f2688b + bhtVar.f2688b : -1L);
        }
        if (bhtVar.f2688b == -1 || bhtVar.f2687a + bhtVar.f2688b != this.f2687a) {
            return null;
        }
        return new bht(strB, bhtVar.f2687a, this.f2688b != -1 ? bhtVar.f2688b + this.f2688b : -1L);
    }

    public final int hashCode() {
        if (this.d == 0) {
            this.d = ((((((int) this.f2687a) + 527) * 31) + ((int) this.f2688b)) * 31) + this.c.hashCode();
        }
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        bht bhtVar = (bht) obj;
        return this.f2687a == bhtVar.f2687a && this.f2688b == bhtVar.f2688b && this.c.equals(bhtVar.c);
    }
}
