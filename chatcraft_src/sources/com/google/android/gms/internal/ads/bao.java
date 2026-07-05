package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import java.util.Arrays;

@TargetApi(21)
/* loaded from: classes.dex */
public final class bao {

    /* renamed from: a, reason: collision with root package name */
    private static final bao f2456a = new bao(new int[]{2}, 2);

    /* renamed from: b, reason: collision with root package name */
    private final int[] f2457b;
    private final int c;

    private bao(int[] iArr, int i) {
        this.f2457b = Arrays.copyOf(iArr, iArr.length);
        Arrays.sort(this.f2457b);
        this.c = 2;
    }

    public final boolean a(int i) {
        return Arrays.binarySearch(this.f2457b, i) >= 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bao)) {
            return false;
        }
        bao baoVar = (bao) obj;
        return Arrays.equals(this.f2457b, baoVar.f2457b) && this.c == baoVar.c;
    }

    public final int hashCode() {
        return this.c + (Arrays.hashCode(this.f2457b) * 31);
    }

    public final String toString() {
        int i = this.c;
        String string = Arrays.toString(this.f2457b);
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 67);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i);
        sb.append(", supportedEncodings=");
        sb.append(string);
        sb.append("]");
        return sb.toString();
    }
}
