package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class bgf {

    /* renamed from: a, reason: collision with root package name */
    public static final bgf f2637a = new bgf(new bgd[0]);

    /* renamed from: b, reason: collision with root package name */
    public final int f2638b;
    private final bgd[] c;
    private int d;

    public bgf(bgd... bgdVarArr) {
        this.c = bgdVarArr;
        this.f2638b = bgdVarArr.length;
    }

    public final bgd a(int i) {
        return this.c[i];
    }

    public final int a(bgd bgdVar) {
        for (int i = 0; i < this.f2638b; i++) {
            if (this.c[i] == bgdVar) {
                return i;
            }
        }
        return -1;
    }

    public final int hashCode() {
        if (this.d == 0) {
            this.d = Arrays.hashCode(this.c);
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
        bgf bgfVar = (bgf) obj;
        return this.f2638b == bgfVar.f2638b && Arrays.equals(this.c, bgfVar.c);
    }
}
