package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes.dex */
final class auv {

    /* renamed from: a, reason: collision with root package name */
    final int f2289a;

    /* renamed from: b, reason: collision with root package name */
    final byte[] f2290b;

    auv(int i, byte[] bArr) {
        this.f2289a = i;
        this.f2290b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof auv)) {
            return false;
        }
        auv auvVar = (auv) obj;
        return this.f2289a == auvVar.f2289a && Arrays.equals(this.f2290b, auvVar.f2290b);
    }

    public final int hashCode() {
        return ((this.f2289a + 527) * 31) + Arrays.hashCode(this.f2290b);
    }
}
