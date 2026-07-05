package com.nineoldandroids.a;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: PropertyValuesHolder.java */
/* loaded from: classes.dex */
public class i implements Cloneable {
    private static final j i = new c();
    private static final j j = new b();
    private static Class[] k = {Float.TYPE, Float.class, Double.TYPE, Integer.TYPE, Double.class, Integer.class};
    private static Class[] l = {Integer.TYPE, Integer.class, Float.TYPE, Double.TYPE, Float.class, Double.class};
    private static Class[] m = {Double.TYPE, Double.class, Float.TYPE, Integer.TYPE, Float.class, Integer.class};
    private static final HashMap<Class, HashMap<String, Method>> n = new HashMap<>();
    private static final HashMap<Class, HashMap<String, Method>> o = new HashMap<>();

    /* renamed from: a, reason: collision with root package name */
    String f4074a;

    /* renamed from: b, reason: collision with root package name */
    protected com.nineoldandroids.util.c f4075b;
    Method c;
    Class d;
    f e;
    final ReentrantReadWriteLock f;
    final Object[] g;
    private Method h;
    private j p;
    private Object q;

    private i(String str) {
        this.c = null;
        this.h = null;
        this.e = null;
        this.f = new ReentrantReadWriteLock();
        this.g = new Object[1];
        this.f4074a = str;
    }

    private i(com.nineoldandroids.util.c cVar) {
        this.c = null;
        this.h = null;
        this.e = null;
        this.f = new ReentrantReadWriteLock();
        this.g = new Object[1];
        this.f4075b = cVar;
        if (cVar != null) {
            this.f4074a = cVar.a();
        }
    }

    public static i a(String str, int... iArr) {
        return new a(str, iArr);
    }

    public static i a(com.nineoldandroids.util.c<?, Integer> cVar, int... iArr) {
        return new a(cVar, iArr);
    }

    public void a(int... iArr) {
        this.d = Integer.TYPE;
        this.e = f.a(iArr);
    }

    private Method a(Class cls, String str, Class cls2) throws NoSuchMethodException, SecurityException {
        Method declaredMethod;
        Class<?>[] clsArr;
        Method declaredMethod2;
        String strA = a(str, this.f4074a);
        if (cls2 == null) {
            try {
                return cls.getMethod(strA, null);
            } catch (NoSuchMethodException e) {
                try {
                    declaredMethod = cls.getDeclaredMethod(strA, null);
                } catch (NoSuchMethodException unused) {
                    declaredMethod = null;
                }
                try {
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException unused2) {
                    Log.e("PropertyValuesHolder", "Couldn't find no-arg method for property " + this.f4074a + ": " + e);
                    return declaredMethod;
                }
                return declaredMethod;
            }
        }
        Class<?>[] clsArr2 = new Class[1];
        if (this.d.equals(Float.class)) {
            clsArr = k;
        } else if (this.d.equals(Integer.class)) {
            clsArr = l;
        } else if (this.d.equals(Double.class)) {
            clsArr = m;
        } else {
            clsArr = new Class[]{this.d};
        }
        Method method = null;
        for (Class<?> cls3 : clsArr) {
            clsArr2[0] = cls3;
            try {
                Method method2 = cls.getMethod(strA, clsArr2);
                try {
                    this.d = cls3;
                    return method2;
                } catch (NoSuchMethodException unused3) {
                    method = method2;
                    try {
                        declaredMethod2 = cls.getDeclaredMethod(strA, clsArr2);
                    } catch (NoSuchMethodException unused4) {
                    }
                    try {
                        declaredMethod2.setAccessible(true);
                        this.d = cls3;
                        return declaredMethod2;
                    } catch (NoSuchMethodException unused5) {
                        method = declaredMethod2;
                    }
                }
            } catch (NoSuchMethodException unused6) {
            }
        }
        Log.e("PropertyValuesHolder", "Couldn't find setter/getter for property " + this.f4074a + " with value type " + this.d);
        return method;
    }

    private Method a(Class cls, HashMap<Class, HashMap<String, Method>> map, String str, Class cls2) {
        try {
            this.f.writeLock().lock();
            HashMap<String, Method> map2 = map.get(cls);
            Method methodA = map2 != null ? map2.get(this.f4074a) : null;
            if (methodA == null) {
                methodA = a(cls, str, cls2);
                if (map2 == null) {
                    map2 = new HashMap<>();
                    map.put(cls, map2);
                }
                map2.put(this.f4074a, methodA);
            }
            return methodA;
        } finally {
            this.f.writeLock().unlock();
        }
    }

    void a(Class cls) {
        this.c = a(cls, n, "set", this.d);
    }

    private void b(Class cls) {
        this.h = a(cls, o, "get", null);
    }

    void a(Object obj) {
        if (this.f4075b != null) {
            try {
                this.f4075b.a(obj);
                Iterator<e> it = this.e.e.iterator();
                while (it.hasNext()) {
                    e next = it.next();
                    if (!next.a()) {
                        next.a(this.f4075b.a(obj));
                    }
                }
                return;
            } catch (ClassCastException unused) {
                Log.e("PropertyValuesHolder", "No such property (" + this.f4075b.a() + ") on target object " + obj + ". Trying reflection instead");
                this.f4075b = null;
            }
        }
        Class<?> cls = obj.getClass();
        if (this.c == null) {
            a((Class) cls);
        }
        Iterator<e> it2 = this.e.e.iterator();
        while (it2.hasNext()) {
            e next2 = it2.next();
            if (!next2.a()) {
                if (this.h == null) {
                    b((Class) cls);
                }
                try {
                    next2.a(this.h.invoke(obj, new Object[0]));
                } catch (IllegalAccessException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                } catch (InvocationTargetException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }
    }

    @Override // 
    /* renamed from: a */
    public i clone() {
        try {
            i iVar = (i) super.clone();
            iVar.f4074a = this.f4074a;
            iVar.f4075b = this.f4075b;
            iVar.e = this.e.clone();
            iVar.p = this.p;
            return iVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    void b(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f4075b != null) {
            this.f4075b.a(obj, d());
        }
        if (this.c != null) {
            try {
                this.g[0] = d();
                this.c.invoke(obj, this.g);
            } catch (IllegalAccessException e) {
                Log.e("PropertyValuesHolder", e.toString());
            } catch (InvocationTargetException e2) {
                Log.e("PropertyValuesHolder", e2.toString());
            }
        }
    }

    void b() {
        if (this.p == null) {
            this.p = this.d == Integer.class ? i : this.d == Float.class ? j : null;
        }
        if (this.p != null) {
            this.e.a(this.p);
        }
    }

    void a(float f) {
        this.q = this.e.a(f);
    }

    public void a(com.nineoldandroids.util.c cVar) {
        this.f4075b = cVar;
    }

    public String c() {
        return this.f4074a;
    }

    Object d() {
        return this.q;
    }

    public String toString() {
        return this.f4074a + ": " + this.e.toString();
    }

    static String a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        return str + Character.toUpperCase(str2.charAt(0)) + str2.substring(1);
    }

    /* compiled from: PropertyValuesHolder.java */
    static class a extends i {
        d h;
        int i;
        private com.nineoldandroids.util.b j;

        public a(String str, int... iArr) {
            super(str);
            a(iArr);
        }

        public a(com.nineoldandroids.util.c cVar, int... iArr) {
            super(cVar);
            a(iArr);
            if (cVar instanceof com.nineoldandroids.util.b) {
                this.j = (com.nineoldandroids.util.b) this.f4075b;
            }
        }

        @Override // com.nineoldandroids.a.i
        public void a(int... iArr) {
            super.a(iArr);
            this.h = (d) this.e;
        }

        @Override // com.nineoldandroids.a.i
        void a(float f) {
            this.i = this.h.b(f);
        }

        @Override // com.nineoldandroids.a.i
        Object d() {
            return Integer.valueOf(this.i);
        }

        @Override // com.nineoldandroids.a.i
        /* renamed from: e, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = (a) super.clone();
            aVar.h = (d) aVar.e;
            return aVar;
        }

        @Override // com.nineoldandroids.a.i
        void b(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (this.j != null) {
                this.j.a((com.nineoldandroids.util.b) obj, this.i);
                return;
            }
            if (this.f4075b != null) {
                this.f4075b.a(obj, Integer.valueOf(this.i));
                return;
            }
            if (this.c != null) {
                try {
                    this.g[0] = Integer.valueOf(this.i);
                    this.c.invoke(obj, this.g);
                } catch (IllegalAccessException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                } catch (InvocationTargetException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }

        @Override // com.nineoldandroids.a.i
        void a(Class cls) {
            if (this.f4075b != null) {
                return;
            }
            super.a(cls);
        }
    }
}
