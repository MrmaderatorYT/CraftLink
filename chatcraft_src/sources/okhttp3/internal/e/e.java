package okhttp3.internal.e;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: OptionalMethod.java */
/* loaded from: classes.dex */
class e<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f5162a;

    /* renamed from: b, reason: collision with root package name */
    private final String f5163b;
    private final Class[] c;

    e(Class<?> cls, String str, Class... clsArr) {
        this.f5162a = cls;
        this.f5163b = str;
        this.c = clsArr;
    }

    public boolean a(T t) {
        return a(t.getClass()) != null;
    }

    public Object a(T t, Object... objArr) throws NoSuchMethodException, SecurityException {
        Method methodA = a(t.getClass());
        if (methodA == null) {
            return null;
        }
        try {
            return methodA.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public Object b(T t, Object... objArr) {
        try {
            return a(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object c(T t, Object... objArr) throws NoSuchMethodException, SecurityException {
        Method methodA = a(t.getClass());
        if (methodA == null) {
            throw new AssertionError("Method " + this.f5163b + " not supported for object " + t);
        }
        try {
            return methodA.invoke(t, objArr);
        } catch (IllegalAccessException e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + methodA);
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    public Object d(T t, Object... objArr) {
        try {
            return c(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    private Method a(Class<?> cls) throws NoSuchMethodException, SecurityException {
        if (this.f5163b == null) {
            return null;
        }
        Method methodA = a(cls, this.f5163b, this.c);
        if (methodA == null || this.f5162a == null || this.f5162a.isAssignableFrom(methodA.getReturnType())) {
            return methodA;
        }
        return null;
    }

    private static Method a(Class<?> cls, String str, Class[] clsArr) throws NoSuchMethodException, SecurityException {
        Method method;
        try {
            method = cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
        }
        try {
            if ((method.getModifiers() & 1) != 0) {
                return method;
            }
            return null;
        } catch (NoSuchMethodException unused2) {
            return method;
        }
    }
}
