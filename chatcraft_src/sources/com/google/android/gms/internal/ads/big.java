package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class big {

    /* renamed from: a, reason: collision with root package name */
    public final String f2698a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2699b;

    public big(String str, String str2) {
        this.f2698a = str;
        this.f2699b = str2;
    }

    public final String toString() {
        String str = this.f2698a;
        String str2 = this.f2699b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        return sb.toString();
    }
}
