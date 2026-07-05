package io.netty.util.a;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TypeParameterMatcher.java */
/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    private static final t f4703a = new i();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f4704b = new Object();

    public abstract boolean a(Object obj);

    public static t a(Class<?> cls) {
        Map<Class<?>, t> mapH = d.b().h();
        t tVarA = mapH.get(cls);
        if (tVarA == null) {
            if (cls == Object.class) {
                tVarA = f4703a;
            } else if (l.j()) {
                try {
                    tVarA = e.a(cls);
                    tVarA.a(f4704b);
                } catch (Exception | IllegalAccessError unused) {
                    tVarA = null;
                }
            }
            if (tVarA == null) {
                tVarA = new a(cls);
            }
            mapH.put(cls, tVarA);
        }
        return tVarA;
    }

    public static t a(Object obj, Class<?> cls, String str) {
        Map<Class<?>, Map<String, t>> mapI = d.b().i();
        Class<?> cls2 = obj.getClass();
        Map<String, t> map = mapI.get(cls2);
        if (map == null) {
            map = new HashMap<>();
            mapI.put(cls2, map);
        }
        t tVar = map.get(str);
        if (tVar != null) {
            return tVar;
        }
        t tVarA = a(b(obj, cls, str));
        map.put(str, tVarA);
        return tVarA;
    }

    private static Class<?> b(Object obj, Class<?> cls, String str) {
        Class<?> cls2 = obj.getClass();
        String name = str;
        Class<?> cls3 = cls;
        do {
            Class<?> superclass = cls2;
            while (superclass.getSuperclass() != cls3) {
                superclass = superclass.getSuperclass();
                if (superclass == null) {
                    return a(cls2, name);
                }
            }
            int i = -1;
            TypeVariable<Class<? super Object>>[] typeParameters = superclass.getSuperclass().getTypeParameters();
            int i2 = 0;
            while (true) {
                if (i2 >= typeParameters.length) {
                    break;
                }
                if (name.equals(typeParameters[i2].getName())) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i < 0) {
                throw new IllegalStateException("unknown type parameter '" + name + "': " + cls3);
            }
            Type genericSuperclass = superclass.getGenericSuperclass();
            if (!(genericSuperclass instanceof ParameterizedType)) {
                return Object.class;
            }
            Type rawType = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[i];
            if (rawType instanceof ParameterizedType) {
                rawType = ((ParameterizedType) rawType).getRawType();
            }
            if (rawType instanceof Class) {
                return (Class) rawType;
            }
            if (rawType instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) rawType).getGenericComponentType();
                if (genericComponentType instanceof ParameterizedType) {
                    genericComponentType = ((ParameterizedType) genericComponentType).getRawType();
                }
                if (genericComponentType instanceof Class) {
                    return Array.newInstance((Class<?>) genericComponentType, 0).getClass();
                }
            }
            if (rawType instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) rawType;
                if (!(typeVariable.getGenericDeclaration() instanceof Class)) {
                    return Object.class;
                }
                cls3 = (Class) typeVariable.getGenericDeclaration();
                name = typeVariable.getName();
            } else {
                return a(cls2, name);
            }
        } while (cls3.isAssignableFrom(cls2));
        return Object.class;
    }

    private static Class<?> a(Class<?> cls, String str) {
        throw new IllegalStateException("cannot determine the type of the type parameter '" + str + "': " + cls);
    }

    /* compiled from: TypeParameterMatcher.java */
    private static final class a extends t {

        /* renamed from: a, reason: collision with root package name */
        private final Class<?> f4705a;

        a(Class<?> cls) {
            this.f4705a = cls;
        }

        @Override // io.netty.util.a.t
        public boolean a(Object obj) {
            return this.f4705a.isInstance(obj);
        }
    }

    protected t() {
    }
}
