package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* loaded from: classes.dex */
public final class bfd {

    /* renamed from: a, reason: collision with root package name */
    private final String f2607a;

    /* renamed from: b, reason: collision with root package name */
    private final String f2608b;

    public bfd(String str, String str2) {
        this.f2607a = str;
        this.f2608b = str2;
    }

    public final String a() {
        return this.f2607a;
    }

    public final String b() {
        return this.f2608b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        bfd bfdVar = (bfd) obj;
        return TextUtils.equals(this.f2607a, bfdVar.f2607a) && TextUtils.equals(this.f2608b, bfdVar.f2608b);
    }

    public final int hashCode() {
        return (this.f2607a.hashCode() * 31) + this.f2608b.hashCode();
    }

    public final String toString() {
        String str = this.f2607a;
        String str2 = this.f2608b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20 + String.valueOf(str2).length());
        sb.append("Header[name=");
        sb.append(str);
        sb.append(",value=");
        sb.append(str2);
        sb.append("]");
        return sb.toString();
    }
}
