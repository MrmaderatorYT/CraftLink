package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class bhr {

    /* renamed from: a, reason: collision with root package name */
    public final String f2683a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2684b;
    private final String c;

    public bhr(String str, String str2, String str3) {
        this.f2683a = str;
        this.f2684b = str2;
        this.c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        bhr bhrVar = (bhr) obj;
        return bkg.a(this.f2683a, bhrVar.f2683a) && bkg.a(this.f2684b, bhrVar.f2684b) && bkg.a(this.c, bhrVar.c);
    }

    public final int hashCode() {
        return ((((this.f2683a != null ? this.f2683a.hashCode() : 0) * 31) + (this.f2684b != null ? this.f2684b.hashCode() : 0)) * 31) + (this.c != null ? this.c.hashCode() : 0);
    }
}
