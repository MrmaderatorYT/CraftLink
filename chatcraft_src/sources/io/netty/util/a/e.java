package io.netty.util.a;

import java.lang.reflect.Method;
import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;

/* compiled from: JavassistTypeParameterMatcherGenerator.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final io.netty.util.a.b.c f4681a = io.netty.util.a.b.d.a((Class<?>) e.class);

    /* renamed from: b, reason: collision with root package name */
    private static final ClassPool f4682b = new ClassPool(true);

    static {
        f4682b.appendClassPath(new ClassClassPath(i.class));
    }

    public static t a(Class<?> cls) {
        ClassLoader classLoaderO = l.o();
        if (classLoaderO == null) {
            classLoaderO = l.p();
        }
        return a(cls, classLoaderO);
    }

    public static t a(Class<?> cls, ClassLoader classLoader) throws NoSuchMethodException, SecurityException {
        String strB = b(cls);
        String str = "io.netty.util.internal.__matchers__." + strB + "Matcher";
        try {
            try {
                try {
                    return (t) Class.forName(str, true, classLoader).newInstance();
                } catch (RuntimeException e) {
                    throw e;
                }
            } catch (Exception unused) {
                CtClass andRename = f4682b.getAndRename(i.class.getName(), str);
                andRename.setModifiers(andRename.getModifiers() | 16);
                andRename.getDeclaredMethod("match").setBody("{ return $1 instanceof " + strB + "; }");
                byte[] bytecode = andRename.toBytecode();
                andRename.detach();
                Method declaredMethod = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, Integer.TYPE, Integer.TYPE);
                declaredMethod.setAccessible(true);
                Class cls2 = (Class) declaredMethod.invoke(classLoader, str, bytecode, 0, Integer.valueOf(bytecode.length));
                if (cls != Object.class) {
                    f4681a.b("Generated: {}", cls2.getName());
                }
                return (t) cls2.newInstance();
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private static String b(Class<?> cls) {
        if (cls.isArray()) {
            return b(cls.getComponentType()) + "[]";
        }
        return cls.getName();
    }

    private e() {
    }
}
