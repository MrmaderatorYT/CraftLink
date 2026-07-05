package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class bnq {

    /* renamed from: a, reason: collision with root package name */
    final long f2880a;

    /* renamed from: b, reason: collision with root package name */
    final String f2881b;
    final int c;

    bnq(long j, String str, int i) {
        this.f2880a = j;
        this.f2881b = str;
        this.c = i;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof bnq)) {
            return false;
        }
        bnq bnqVar = (bnq) obj;
        return bnqVar.f2880a == this.f2880a && bnqVar.c == this.c;
    }

    public final int hashCode() {
        return (int) this.f2880a;
    }
}
