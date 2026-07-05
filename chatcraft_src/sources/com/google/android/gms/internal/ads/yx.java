package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class yx {

    /* renamed from: a, reason: collision with root package name */
    public final String f3618a;

    /* renamed from: b, reason: collision with root package name */
    public final double f3619b;
    public final int c;
    private final double d;
    private final double e;

    public yx(String str, double d, double d2, double d3, int i) {
        this.f3618a = str;
        this.e = d;
        this.d = d2;
        this.f3619b = d3;
        this.c = i;
    }

    public final String toString() {
        return com.google.android.gms.common.internal.h.a(this).a("name", this.f3618a).a("minBound", Double.valueOf(this.e)).a("maxBound", Double.valueOf(this.d)).a("percent", Double.valueOf(this.f3619b)).a("count", Integer.valueOf(this.c)).toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof yx)) {
            return false;
        }
        yx yxVar = (yx) obj;
        return com.google.android.gms.common.internal.h.a(this.f3618a, yxVar.f3618a) && this.d == yxVar.d && this.e == yxVar.e && this.c == yxVar.c && Double.compare(this.f3619b, yxVar.f3619b) == 0;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.h.a(this.f3618a, Double.valueOf(this.d), Double.valueOf(this.e), Double.valueOf(this.f3619b), Integer.valueOf(this.c));
    }
}
