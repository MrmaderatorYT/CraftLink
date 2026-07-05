package com.google.gson;

import java.math.BigInteger;

/* compiled from: JsonPrimitive.java */
/* loaded from: classes.dex */
public final class p extends l {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?>[] f4035a = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* renamed from: b, reason: collision with root package name */
    private Object f4036b;

    public p(Boolean bool) {
        a(bool);
    }

    public p(Number number) {
        a(number);
    }

    public p(String str) {
        a(str);
    }

    p(Object obj) {
        a(obj);
    }

    void a(Object obj) {
        if (obj instanceof Character) {
            this.f4036b = String.valueOf(((Character) obj).charValue());
        } else {
            com.google.gson.b.a.a((obj instanceof Number) || b(obj));
            this.f4036b = obj;
        }
    }

    public boolean a() {
        return this.f4036b instanceof Boolean;
    }

    @Override // com.google.gson.l
    Boolean o() {
        return (Boolean) this.f4036b;
    }

    @Override // com.google.gson.l
    public boolean g() {
        if (a()) {
            return o().booleanValue();
        }
        return Boolean.parseBoolean(c());
    }

    public boolean p() {
        return this.f4036b instanceof Number;
    }

    @Override // com.google.gson.l
    public Number b() {
        return this.f4036b instanceof String ? new com.google.gson.b.g((String) this.f4036b) : (Number) this.f4036b;
    }

    public boolean q() {
        return this.f4036b instanceof String;
    }

    @Override // com.google.gson.l
    public String c() {
        if (p()) {
            return b().toString();
        }
        if (a()) {
            return o().toString();
        }
        return (String) this.f4036b;
    }

    @Override // com.google.gson.l
    public double d() {
        return p() ? b().doubleValue() : Double.parseDouble(c());
    }

    @Override // com.google.gson.l
    public long e() {
        return p() ? b().longValue() : Long.parseLong(c());
    }

    @Override // com.google.gson.l
    public int f() {
        return p() ? b().intValue() : Integer.parseInt(c());
    }

    private static boolean b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : f4035a) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f4036b == null) {
            return 31;
        }
        if (a(this)) {
            long jLongValue = b().longValue();
            return (int) ((jLongValue >>> 32) ^ jLongValue);
        }
        if (this.f4036b instanceof Number) {
            long jDoubleToLongBits = Double.doubleToLongBits(b().doubleValue());
            return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
        }
        return this.f4036b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f4036b == null) {
            return pVar.f4036b == null;
        }
        if (a(this) && a(pVar)) {
            return b().longValue() == pVar.b().longValue();
        }
        if ((this.f4036b instanceof Number) && (pVar.f4036b instanceof Number)) {
            double dDoubleValue = b().doubleValue();
            double dDoubleValue2 = pVar.b().doubleValue();
            if (dDoubleValue != dDoubleValue2) {
                return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
            }
            return true;
        }
        return this.f4036b.equals(pVar.f4036b);
    }

    private static boolean a(p pVar) {
        if (!(pVar.f4036b instanceof Number)) {
            return false;
        }
        Number number = (Number) pVar.f4036b;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }
}
