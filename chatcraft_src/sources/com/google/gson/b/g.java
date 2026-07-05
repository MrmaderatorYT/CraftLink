package com.google.gson.b;

import java.math.BigDecimal;

/* compiled from: LazilyParsedNumber.java */
/* loaded from: classes.dex */
public final class g extends Number {

    /* renamed from: a, reason: collision with root package name */
    private final String f3998a;

    public g(String str) {
        this.f3998a = str;
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f3998a);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f3998a);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.f3998a).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f3998a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f3998a).longValue();
        }
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f3998a);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f3998a);
    }

    public String toString() {
        return this.f3998a;
    }

    public int hashCode() {
        return this.f3998a.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f3998a == gVar.f3998a || this.f3998a.equals(gVar.f3998a);
    }
}
