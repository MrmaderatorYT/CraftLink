package com.google.gson.b;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Primitives.java */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f4008a;

    /* renamed from: b, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f4009b;

    static {
        HashMap map = new HashMap(16);
        HashMap map2 = new HashMap(16);
        a(map, map2, Boolean.TYPE, Boolean.class);
        a(map, map2, Byte.TYPE, Byte.class);
        a(map, map2, Character.TYPE, Character.class);
        a(map, map2, Double.TYPE, Double.class);
        a(map, map2, Float.TYPE, Float.class);
        a(map, map2, Integer.TYPE, Integer.class);
        a(map, map2, Long.TYPE, Long.class);
        a(map, map2, Short.TYPE, Short.class);
        a(map, map2, Void.TYPE, Void.class);
        f4008a = Collections.unmodifiableMap(map);
        f4009b = Collections.unmodifiableMap(map2);
    }

    private static void a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static boolean a(Type type) {
        return f4008a.containsKey(type);
    }

    public static <T> Class<T> a(Class<T> cls) {
        Class<T> cls2 = (Class) f4008a.get(a.a(cls));
        return cls2 == null ? cls : cls2;
    }
}
