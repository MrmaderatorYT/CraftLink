package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: Lifecycling.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static Map<Class, Integer> f922a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static Map<Class, List<Constructor<? extends c>>> f923b = new HashMap();

    static d a(Object obj) {
        if (obj instanceof b) {
            return new FullLifecycleObserverAdapter((b) obj);
        }
        if (obj instanceof d) {
            return (d) obj;
        }
        Class<?> cls = obj.getClass();
        if (b(cls) == 2) {
            List<Constructor<? extends c>> list = f923b.get(cls);
            if (list.size() == 1) {
                return new SingleGeneratedAdapterObserver(a(list.get(0), obj));
            }
            c[] cVarArr = new c[list.size()];
            for (int i = 0; i < list.size(); i++) {
                cVarArr[i] = a(list.get(i), obj);
            }
            return new CompositeGeneratedAdaptersObserver(cVarArr);
        }
        return new ReflectiveGenericLifecycleObserver(obj);
    }

    private static c a(Constructor<? extends c> constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    private static Constructor<? extends c> a(Class<?> cls) throws NoSuchMethodException, SecurityException {
        try {
            Package r0 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r0 != null ? r0.getName() : BuildConfig.FLAVOR;
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String strA = a(canonicalName);
            if (!name.isEmpty()) {
                strA = name + "." + strA;
            }
            Constructor declaredConstructor = Class.forName(strA).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private static int b(Class<?> cls) throws NoSuchMethodException, SecurityException {
        if (f922a.containsKey(cls)) {
            return f922a.get(cls).intValue();
        }
        int iC = c(cls);
        f922a.put(cls, Integer.valueOf(iC));
        return iC;
    }

    private static int c(Class<?> cls) throws NoSuchMethodException, SecurityException {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends c> constructorA = a(cls);
        if (constructorA != null) {
            f923b.put(cls, Collections.singletonList(constructorA));
            return 2;
        }
        if (a.f908a.a(cls)) {
            return 1;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        ArrayList arrayList = null;
        if (d(superclass)) {
            if (b(superclass) == 1) {
                return 1;
            }
            arrayList = new ArrayList(f923b.get(superclass));
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (d(cls2)) {
                if (b(cls2) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.addAll(f923b.get(cls2));
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f923b.put(cls, arrayList);
        return 2;
    }

    private static boolean d(Class<?> cls) {
        return cls != null && f.class.isAssignableFrom(cls);
    }

    public static String a(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }
}
