package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class bjt {

    /* renamed from: a, reason: collision with root package name */
    private int f2744a;

    /* renamed from: b, reason: collision with root package name */
    private long[] f2745b;

    public bjt() {
        this(32);
    }

    private bjt(int i) {
        this.f2745b = new long[32];
    }

    public final void a(long j) {
        if (this.f2744a == this.f2745b.length) {
            this.f2745b = Arrays.copyOf(this.f2745b, this.f2744a << 1);
        }
        long[] jArr = this.f2745b;
        int i = this.f2744a;
        this.f2744a = i + 1;
        jArr[i] = j;
    }

    public final long a(int i) {
        if (i < 0 || i >= this.f2744a) {
            int i2 = this.f2744a;
            StringBuilder sb = new StringBuilder(46);
            sb.append("Invalid index ");
            sb.append(i);
            sb.append(", size is ");
            sb.append(i2);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        return this.f2745b[i];
    }

    public final int a() {
        return this.f2744a;
    }
}
