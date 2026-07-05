package com.google.gson.c;

import com.google.gson.b.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: TypeToken.java */
/* loaded from: classes.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    final Class<? super T> f4019a;

    /* renamed from: b, reason: collision with root package name */
    final Type f4020b;
    final int c;

    protected a() {
        this.f4020b = a(getClass());
        this.f4019a = (Class<? super T>) b.e(this.f4020b);
        this.c = this.f4020b.hashCode();
    }

    a(Type type) {
        this.f4020b = b.d((Type) com.google.gson.b.a.a(type));
        this.f4019a = (Class<? super T>) b.e(this.f4020b);
        this.c = this.f4020b.hashCode();
    }

    static Type a(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return b.d(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> a() {
        return this.f4019a;
    }

    public final Type b() {
        return this.f4020b;
    }

    public final int hashCode() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && b.a(this.f4020b, ((a) obj).f4020b);
    }

    public final String toString() {
        return b.f(this.f4020b);
    }

    public static a<?> a(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> b(Class<T> cls) {
        return new a<>(cls);
    }
}
