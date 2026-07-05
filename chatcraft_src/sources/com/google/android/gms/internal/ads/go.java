package com.google.android.gms.internal.ads;

import java.util.Arrays;

@qj
/* loaded from: classes.dex */
final class go {

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f3104a;

    go(bqj bqjVar, String str, int i) {
        this.f3104a = com.google.android.gms.ads.internal.bm.a((String) bra.e().a(o.aE), bqjVar, str, i, null);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof go) {
            return Arrays.equals(this.f3104a, ((go) obj).f3104a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f3104a);
    }

    public final String toString() {
        String string = Arrays.toString(this.f3104a);
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 24);
        sb.append("[InterstitialAdPoolKey ");
        sb.append(string);
        sb.append("]");
        return sb.toString();
    }
}
