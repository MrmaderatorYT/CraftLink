package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class bcn {

    /* renamed from: a, reason: collision with root package name */
    public final int f2518a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f2519b;

    public bcn(int i, byte[] bArr) {
        this.f2519b = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        bcn bcnVar = (bcn) obj;
        return this.f2518a == bcnVar.f2518a && Arrays.equals(this.f2519b, bcnVar.f2519b);
    }

    public final int hashCode() {
        return (this.f2518a * 31) + Arrays.hashCode(this.f2519b);
    }
}
