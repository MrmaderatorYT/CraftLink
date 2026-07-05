package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class bjd {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f2725a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f2726b;
    public final long c;
    public final long d;
    public final long e;
    public final String f;
    public final int g;

    public bjd(Uri uri) {
        this(uri, 0);
    }

    public bjd(Uri uri, int i) {
        this(uri, 0L, -1L, null, i);
    }

    public bjd(Uri uri, long j, long j2, String str) {
        this(uri, j, j, j2, str, 0);
    }

    public bjd(Uri uri, long j, long j2, String str, int i) {
        this(uri, j, j, j2, str, i);
    }

    private bjd(Uri uri, long j, long j2, long j3, String str, int i) {
        this(uri, null, j, j2, j3, str, i);
    }

    public bjd(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i) {
        bjq.a(j >= 0);
        bjq.a(j2 >= 0);
        bjq.a(j3 > 0 || j3 == -1);
        this.f2725a = uri;
        this.f2726b = bArr;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = str;
        this.g = i;
    }

    public final boolean a(int i) {
        return (this.g & 1) == 1;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f2725a);
        String string = Arrays.toString(this.f2726b);
        long j = this.c;
        long j2 = this.d;
        long j3 = this.e;
        String str = this.f;
        int i = this.g;
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 93 + String.valueOf(string).length() + String.valueOf(str).length());
        sb.append("DataSpec[");
        sb.append(strValueOf);
        sb.append(", ");
        sb.append(string);
        sb.append(", ");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append(", ");
        sb.append(j3);
        sb.append(", ");
        sb.append(str);
        sb.append(", ");
        sb.append(i);
        sb.append("]");
        return sb.toString();
    }
}
