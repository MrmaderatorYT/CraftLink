package com.google.gson.b;

import com.google.gson.JsonIOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* compiled from: ConstructorConstructor.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Type, com.google.gson.h<?>> f3971a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.gson.b.b.b f3972b = com.google.gson.b.b.b.a();

    public c(Map<Type, com.google.gson.h<?>> map) {
        this.f3971a = map;
    }

    public <T> i<T> a(com.google.gson.c.a<T> aVar) throws NoSuchMethodException, SecurityException {
        final Type typeB = aVar.b();
        Class<? super T> clsA = aVar.a();
        final com.google.gson.h<?> hVar = this.f3971a.get(typeB);
        if (hVar != null) {
            return new i<T>() { // from class: com.google.gson.b.c.1
                @Override // com.google.gson.b.i
                public T a() {
                    return (T) hVar.a(typeB);
                }
            };
        }
        final com.google.gson.h<?> hVar2 = this.f3971a.get(clsA);
        if (hVar2 != null) {
            return new i<T>() { // from class: com.google.gson.b.c.7
                @Override // com.google.gson.b.i
                public T a() {
                    return (T) hVar2.a(typeB);
                }
            };
        }
        i<T> iVarA = a(clsA);
        if (iVarA != null) {
            return iVarA;
        }
        i<T> iVarA2 = a(typeB, clsA);
        return iVarA2 != null ? iVarA2 : b(typeB, clsA);
    }

    private <T> i<T> a(Class<? super T> cls) throws NoSuchMethodException, SecurityException {
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.f3972b.a(declaredConstructor);
            }
            return new i<T>() { // from class: com.google.gson.b.c.8
                @Override // com.google.gson.b.i
                public T a() {
                    try {
                        return (T) declaredConstructor.newInstance(null);
                    } catch (IllegalAccessException e) {
                        throw new AssertionError(e);
                    } catch (InstantiationException e2) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e2);
                    } catch (InvocationTargetException e3) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e3.getTargetException());
                    }
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> i<T> a(final Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new i<T>() { // from class: com.google.gson.b.c.9
                    @Override // com.google.gson.b.i
                    public T a() {
                        return (T) new TreeSet();
                    }
                };
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new i<T>() { // from class: com.google.gson.b.c.10
                    @Override // com.google.gson.b.i
                    public T a() {
                        if (type instanceof ParameterizedType) {
                            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                            if (type2 instanceof Class) {
                                return (T) EnumSet.noneOf((Class) type2);
                            }
                            throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                        }
                        throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                    }
                };
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new i<T>() { // from class: com.google.gson.b.c.11
                    @Override // com.google.gson.b.i
                    public T a() {
                        return (T) new LinkedHashSet();
                    }
                };
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new i<T>() { // from class: com.google.gson.b.c.12
                    @Override // com.google.gson.b.i
                    public T a() {
                        return (T) new ArrayDeque();
                    }
                };
            }
            return new i<T>() { // from class: com.google.gson.b.c.13
                @Override // com.google.gson.b.i
                public T a() {
                    return (T) new ArrayList();
                }
            };
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
            return new i<T>() { // from class: com.google.gson.b.c.14
                @Override // com.google.gson.b.i
                public T a() {
                    return (T) new ConcurrentSkipListMap();
                }
            };
        }
        if (ConcurrentMap.class.isAssignableFrom(cls)) {
            return new i<T>() { // from class: com.google.gson.b.c.2
                @Override // com.google.gson.b.i
                public T a() {
                    return (T) new ConcurrentHashMap();
                }
            };
        }
        if (SortedMap.class.isAssignableFrom(cls)) {
            return new i<T>() { // from class: com.google.gson.b.c.3
                @Override // com.google.gson.b.i
                public T a() {
                    return (T) new TreeMap();
                }
            };
        }
        if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(com.google.gson.c.a.a(((ParameterizedType) type).getActualTypeArguments()[0]).a())) {
            return new i<T>() { // from class: com.google.gson.b.c.4
                @Override // com.google.gson.b.i
                public T a() {
                    return (T) new LinkedHashMap();
                }
            };
        }
        return new i<T>() { // from class: com.google.gson.b.c.5
            @Override // com.google.gson.b.i
            public T a() {
                return (T) new h();
            }
        };
    }

    private <T> i<T> b(final Type type, final Class<? super T> cls) {
        return new i<T>() { // from class: com.google.gson.b.c.6
            private final m d = m.a();

            @Override // com.google.gson.b.i
            public T a() {
                try {
                    return (T) this.d.a(cls);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + type + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e);
                }
            }
        };
    }

    public String toString() {
        return this.f3971a.toString();
    }
}
