package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class bit {

    /* renamed from: a, reason: collision with root package name */
    public final int f2712a;

    /* renamed from: b, reason: collision with root package name */
    private final bir[] f2713b;
    private int c;

    public bit(bir... birVarArr) {
        this.f2713b = birVarArr;
        this.f2712a = birVarArr.length;
    }

    public final bir a(int i) {
        return this.f2713b[i];
    }

    public final bir[] a() {
        return (bir[]) this.f2713b.clone();
    }

    public final int hashCode() {
        if (this.c == 0) {
            this.c = Arrays.hashCode(this.f2713b) + 527;
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
        return Arrays.equals(this.f2713b, ((bit) obj).f2713b);
    }
}
