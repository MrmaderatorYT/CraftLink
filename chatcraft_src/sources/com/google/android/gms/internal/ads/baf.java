package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class baf {

    /* renamed from: a, reason: collision with root package name */
    public static final baf f2445a = new baf(1.0f, 1.0f);

    /* renamed from: b, reason: collision with root package name */
    public final float f2446b;
    public final float c;
    private final int d;

    public baf(float f, float f2) {
        this.f2446b = f;
        this.c = f2;
        this.d = Math.round(f * 1000.0f);
    }

    public final long a(long j) {
        return j * this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        baf bafVar = (baf) obj;
        return this.f2446b == bafVar.f2446b && this.c == bafVar.c;
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.f2446b) + 527) * 31) + Float.floatToRawIntBits(this.c);
    }
}
