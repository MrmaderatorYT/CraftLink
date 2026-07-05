package io.netty.util;

import io.netty.util.g;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ConstantPool.java */
/* loaded from: classes.dex */
public abstract class h<T extends g<T>> {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentMap<String, T> f4763a = io.netty.util.a.l.k();

    /* renamed from: b, reason: collision with root package name */
    private AtomicInteger f4764b = new AtomicInteger(1);

    protected abstract T b(int i, String str);

    public T a(Class<?> cls, String str) {
        if (cls == null) {
            throw new NullPointerException("firstNameComponent");
        }
        if (str == null) {
            throw new NullPointerException("secondNameComponent");
        }
        return (T) a(cls.getName() + '#' + str);
    }

    public T a(String str) {
        c(str);
        return (T) b(str);
    }

    private T b(String str) {
        T t = this.f4763a.get(str);
        if (t != null) {
            return t;
        }
        T t2 = (T) b(a(), str);
        T t3 = (T) this.f4763a.putIfAbsent(str, t2);
        return t3 == null ? t2 : t3;
    }

    private String c(String str) {
        io.netty.util.a.j.a(str, "name");
        if (str.isEmpty()) {
            throw new IllegalArgumentException("empty name");
        }
        return str;
    }

    @Deprecated
    public final int a() {
        return this.f4764b.getAndIncrement();
    }
}
