package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class bgd {

    /* renamed from: a, reason: collision with root package name */
    public final int f2635a;

    /* renamed from: b, reason: collision with root package name */
    private final bab[] f2636b;
    private int c;

    public bgd(bab... babVarArr) {
        bjq.b(babVarArr.length > 0);
        this.f2636b = babVarArr;
        this.f2635a = babVarArr.length;
    }

    public final bab a(int i) {
        return this.f2636b[i];
    }

    public final int a(bab babVar) {
        for (int i = 0; i < this.f2636b.length; i++) {
            if (babVar == this.f2636b[i]) {
                return i;
            }
        }
        return -1;
    }

    public final int hashCode() {
        if (this.c == 0) {
            this.c = Arrays.hashCode(this.f2636b) + 527;
        }
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        bgd bgdVar = (bgd) obj;
        return this.f2635a == bgdVar.f2635a && Arrays.equals(this.f2636b, bgdVar.f2636b);
    }
}
