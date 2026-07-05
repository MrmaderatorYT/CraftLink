package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class awc {

    /* renamed from: a, reason: collision with root package name */
    public static final awc f2337a = new awc(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final awc k = new awc(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final awc l = new awc(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final awc m = new awc(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* renamed from: b, reason: collision with root package name */
    private final double f2338b;
    private final double c;
    private final double d;
    private final double e;
    private final double f;
    private final double g;
    private final double h;
    private final double i;
    private final double j;

    private awc(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.f2338b = d5;
        this.c = d6;
        this.d = d7;
        this.e = d;
        this.f = d2;
        this.g = d3;
        this.h = d4;
        this.i = d8;
        this.j = d9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        awc awcVar = (awc) obj;
        return Double.compare(awcVar.e, this.e) == 0 && Double.compare(awcVar.f, this.f) == 0 && Double.compare(awcVar.g, this.g) == 0 && Double.compare(awcVar.h, this.h) == 0 && Double.compare(awcVar.i, this.i) == 0 && Double.compare(awcVar.j, this.j) == 0 && Double.compare(awcVar.f2338b, this.f2338b) == 0 && Double.compare(awcVar.c, this.c) == 0 && Double.compare(awcVar.d, this.d) == 0;
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f2338b);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.c);
        int i = (((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
        long jDoubleToLongBits3 = Double.doubleToLongBits(this.d);
        int i2 = (i * 31) + ((int) (jDoubleToLongBits3 ^ (jDoubleToLongBits3 >>> 32)));
        long jDoubleToLongBits4 = Double.doubleToLongBits(this.e);
        int i3 = (i2 * 31) + ((int) (jDoubleToLongBits4 ^ (jDoubleToLongBits4 >>> 32)));
        long jDoubleToLongBits5 = Double.doubleToLongBits(this.f);
        int i4 = (i3 * 31) + ((int) (jDoubleToLongBits5 ^ (jDoubleToLongBits5 >>> 32)));
        long jDoubleToLongBits6 = Double.doubleToLongBits(this.g);
        int i5 = (i4 * 31) + ((int) (jDoubleToLongBits6 ^ (jDoubleToLongBits6 >>> 32)));
        long jDoubleToLongBits7 = Double.doubleToLongBits(this.h);
        int i6 = (i5 * 31) + ((int) (jDoubleToLongBits7 ^ (jDoubleToLongBits7 >>> 32)));
        long jDoubleToLongBits8 = Double.doubleToLongBits(this.i);
        int i7 = (i6 * 31) + ((int) (jDoubleToLongBits8 ^ (jDoubleToLongBits8 >>> 32)));
        long jDoubleToLongBits9 = Double.doubleToLongBits(this.j);
        return (i7 * 31) + ((int) ((jDoubleToLongBits9 >>> 32) ^ jDoubleToLongBits9));
    }

    public final String toString() {
        if (equals(f2337a)) {
            return "Rotate 0°";
        }
        if (equals(k)) {
            return "Rotate 90°";
        }
        if (equals(l)) {
            return "Rotate 180°";
        }
        if (equals(m)) {
            return "Rotate 270°";
        }
        double d = this.f2338b;
        double d2 = this.c;
        double d3 = this.d;
        double d4 = this.e;
        double d5 = this.f;
        double d6 = this.g;
        double d7 = this.h;
        double d8 = this.i;
        double d9 = this.j;
        StringBuilder sb = new StringBuilder(260);
        sb.append("Matrix{u=");
        sb.append(d);
        sb.append(", v=");
        sb.append(d2);
        sb.append(", w=");
        sb.append(d3);
        sb.append(", a=");
        sb.append(d4);
        sb.append(", b=");
        sb.append(d5);
        sb.append(", c=");
        sb.append(d6);
        sb.append(", d=");
        sb.append(d7);
        sb.append(", tx=");
        sb.append(d8);
        sb.append(", ty=");
        sb.append(d9);
        sb.append("}");
        return sb.toString();
    }

    public static awc a(ByteBuffer byteBuffer) {
        double d = aaj.d(byteBuffer);
        double d2 = aaj.d(byteBuffer);
        double dE = aaj.e(byteBuffer);
        return new awc(d, d2, aaj.d(byteBuffer), aaj.d(byteBuffer), dE, aaj.e(byteBuffer), aaj.e(byteBuffer), aaj.d(byteBuffer), aaj.d(byteBuffer));
    }
}
