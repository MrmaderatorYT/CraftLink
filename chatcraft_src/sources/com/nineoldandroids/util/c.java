package com.nineoldandroids.util;

/* compiled from: Property.java */
/* loaded from: classes.dex */
public abstract class c<T, V> {

    /* renamed from: a, reason: collision with root package name */
    private final String f4079a;

    /* renamed from: b, reason: collision with root package name */
    private final Class<V> f4080b;

    public abstract V a(T t);

    public c(Class<V> cls, String str) {
        this.f4079a = str;
        this.f4080b = cls;
    }

    public void a(T t, V v) {
        throw new UnsupportedOperationException("Property " + a() + " is read-only");
    }

    public String a() {
        return this.f4079a;
    }
}
