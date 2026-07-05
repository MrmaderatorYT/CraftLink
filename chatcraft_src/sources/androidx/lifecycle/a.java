package androidx.lifecycle;

import androidx.lifecycle.e;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ClassesInfoCache.java */
/* loaded from: classes.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    static a f908a = new a();

    /* renamed from: b, reason: collision with root package name */
    private final Map<Class, C0052a> f909b = new HashMap();
    private final Map<Class, Boolean> c = new HashMap();

    a() {
    }

    boolean a(Class cls) {
        if (this.c.containsKey(cls)) {
            return this.c.get(cls).booleanValue();
        }
        Method[] methodArrC = c(cls);
        for (Method method : methodArrC) {
            if (((n) method.getAnnotation(n.class)) != null) {
                a(cls, methodArrC);
                return true;
            }
        }
        this.c.put(cls, false);
        return false;
    }

    private Method[] c(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    C0052a b(Class cls) {
        C0052a c0052a = this.f909b.get(cls);
        return c0052a != null ? c0052a : a(cls, null);
    }

    private void a(Map<b, e.a> map, b bVar, e.a aVar, Class cls) {
        e.a aVar2 = map.get(bVar);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(bVar, aVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + bVar.f913b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }

    private C0052a a(Class cls, Method[] methodArr) {
        int i;
        C0052a c0052aB;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (c0052aB = b(superclass)) != null) {
            map.putAll(c0052aB.f911b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, e.a> entry : b(cls2).f911b.entrySet()) {
                a(map, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = c(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            n nVar = (n) method.getAnnotation(n.class);
            if (nVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(g.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i = 1;
                }
                e.a aVarA = nVar.a();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(e.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (aVarA != e.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                a(map, new b(i, method), aVarA, cls);
                z = true;
            }
        }
        C0052a c0052a = new C0052a(map);
        this.f909b.put(cls, c0052a);
        this.c.put(cls, Boolean.valueOf(z));
        return c0052a;
    }

    /* compiled from: ClassesInfoCache.java */
    /* renamed from: androidx.lifecycle.a$a, reason: collision with other inner class name */
    static class C0052a {

        /* renamed from: a, reason: collision with root package name */
        final Map<e.a, List<b>> f910a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        final Map<b, e.a> f911b;

        C0052a(Map<b, e.a> map) {
            this.f911b = map;
            for (Map.Entry<b, e.a> entry : map.entrySet()) {
                e.a value = entry.getValue();
                List<b> arrayList = this.f910a.get(value);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f910a.put(value, arrayList);
                }
                arrayList.add(entry.getKey());
            }
        }

        void a(g gVar, e.a aVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            a(this.f910a.get(aVar), gVar, aVar, obj);
            a(this.f910a.get(e.a.ON_ANY), gVar, aVar, obj);
        }

        private static void a(List<b> list, g gVar, e.a aVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(gVar, aVar, obj);
                }
            }
        }
    }

    /* compiled from: ClassesInfoCache.java */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        final int f912a;

        /* renamed from: b, reason: collision with root package name */
        final Method f913b;

        b(int i, Method method) {
            this.f912a = i;
            this.f913b = method;
            this.f913b.setAccessible(true);
        }

        void a(g gVar, e.a aVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                switch (this.f912a) {
                    case 0:
                        this.f913b.invoke(obj, new Object[0]);
                        return;
                    case 1:
                        this.f913b.invoke(obj, gVar);
                        return;
                    case 2:
                        this.f913b.invoke(obj, gVar, aVar);
                        return;
                    default:
                        return;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f912a == bVar.f912a && this.f913b.getName().equals(bVar.f913b.getName());
        }

        public int hashCode() {
            return (this.f912a * 31) + this.f913b.getName().hashCode();
        }
    }
}
