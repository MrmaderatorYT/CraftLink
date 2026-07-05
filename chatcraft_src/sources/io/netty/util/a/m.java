package io.netty.util.a;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import sun.misc.Unsafe;

/* compiled from: PlatformDependent0.java */
/* loaded from: classes.dex */
final class m {

    /* renamed from: a, reason: collision with root package name */
    static final Unsafe f4689a;

    /* renamed from: b, reason: collision with root package name */
    private static final io.netty.util.a.b.c f4690b = io.netty.util.a.b.d.a((Class<?>) m.class);
    private static final long c;
    private static final long d;
    private static final Constructor<?> e;
    private static final boolean f;

    static {
        Field field;
        final Unsafe unsafe;
        long jAllocateMemory;
        boolean zBooleanValue;
        final ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(1);
        Object objDoPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.a.m.1
            @Override // java.security.PrivilegedAction
            public Object run() throws NoSuchFieldException {
                try {
                    Field declaredField = Buffer.class.getDeclaredField("address");
                    declaredField.setAccessible(true);
                    if (declaredField.getLong(byteBufferAllocateDirect) == 0) {
                        return null;
                    }
                    return declaredField;
                } catch (IllegalAccessException e2) {
                    return e2;
                } catch (NoSuchFieldException e3) {
                    return e3;
                } catch (SecurityException e4) {
                    return e4;
                }
            }
        });
        Constructor<?> constructor = null;
        if (objDoPrivileged instanceof Field) {
            field = (Field) objDoPrivileged;
            f4690b.a("java.nio.Buffer.address: available");
        } else {
            f4690b.a("java.nio.Buffer.address: unavailable", (Throwable) objDoPrivileged);
            field = null;
        }
        if (field != null) {
            Object objDoPrivileged2 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.a.m.2
                @Override // java.security.PrivilegedAction
                public Object run() throws NoSuchFieldException {
                    try {
                        Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
                        declaredField.setAccessible(true);
                        return declaredField.get(null);
                    } catch (IllegalAccessException e2) {
                        return e2;
                    } catch (NoSuchFieldException e3) {
                        return e3;
                    } catch (SecurityException e4) {
                        return e4;
                    }
                }
            });
            if (objDoPrivileged2 instanceof Exception) {
                f4690b.a("sun.misc.Unsafe.theUnsafe: unavailable", (Throwable) objDoPrivileged2);
                unsafe = null;
            } else {
                unsafe = (Unsafe) objDoPrivileged2;
                f4690b.a("sun.misc.Unsafe.theUnsafe: available");
            }
            if (unsafe != null) {
                Object objDoPrivileged3 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.a.m.3
                    @Override // java.security.PrivilegedAction
                    public Object run() throws NoSuchMethodException, SecurityException {
                        try {
                            unsafe.getClass().getDeclaredMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
                            return null;
                        } catch (NoSuchMethodException e2) {
                            return e2;
                        } catch (SecurityException e3) {
                            return e3;
                        }
                    }
                });
                if (objDoPrivileged3 == null) {
                    f4690b.a("sun.misc.Unsafe.copyMemory: available");
                } else {
                    f4690b.a("sun.misc.Unsafe.copyMemory: unavailable", (Throwable) objDoPrivileged3);
                    unsafe = null;
                }
            }
        } else {
            unsafe = null;
        }
        f4689a = unsafe;
        if (unsafe == null) {
            c = -1L;
            d = -1L;
            f = false;
            e = null;
        } else {
            try {
                Object objDoPrivileged4 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.a.m.4
                    @Override // java.security.PrivilegedAction
                    public Object run() throws NoSuchMethodException, SecurityException {
                        try {
                            Constructor<?> declaredConstructor = byteBufferAllocateDirect.getClass().getDeclaredConstructor(Long.TYPE, Integer.TYPE);
                            declaredConstructor.setAccessible(true);
                            return declaredConstructor;
                        } catch (NoSuchMethodException e2) {
                            return e2;
                        } catch (SecurityException e3) {
                            return e3;
                        }
                    }
                });
                if (objDoPrivileged4 instanceof Constructor) {
                    jAllocateMemory = f4689a.allocateMemory(1L);
                    try {
                        ((Constructor) objDoPrivileged4).newInstance(Long.valueOf(jAllocateMemory), 1);
                        Constructor<?> constructor2 = (Constructor) objDoPrivileged4;
                        f4690b.a("direct buffer constructor: available");
                        constructor = constructor2;
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                    } catch (Throwable th) {
                        th = th;
                        if (jAllocateMemory != -1) {
                            f4689a.freeMemory(jAllocateMemory);
                        }
                        throw th;
                    }
                } else {
                    f4690b.a("direct buffer constructor: unavailable", (Throwable) objDoPrivileged4);
                    jAllocateMemory = -1;
                }
                if (jAllocateMemory != -1) {
                    f4689a.freeMemory(jAllocateMemory);
                }
                e = constructor;
                c = a(field);
                d = f4689a.arrayBaseOffset(byte[].class);
                Object objDoPrivileged5 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.a.m.5
                    @Override // java.security.PrivilegedAction
                    public Object run() throws NoSuchMethodException, SecurityException {
                        try {
                            Method declaredMethod = Class.forName("java.nio.Bits", false, l.p()).getDeclaredMethod("unaligned", new Class[0]);
                            declaredMethod.setAccessible(true);
                            return declaredMethod.invoke(null, new Object[0]);
                        } catch (ClassNotFoundException e2) {
                            return e2;
                        } catch (IllegalAccessException e3) {
                            return e3;
                        } catch (NoSuchMethodException e4) {
                            return e4;
                        } catch (SecurityException e5) {
                            return e5;
                        } catch (InvocationTargetException e6) {
                            return e6;
                        }
                    }
                });
                if (objDoPrivileged5 instanceof Boolean) {
                    zBooleanValue = ((Boolean) objDoPrivileged5).booleanValue();
                    f4690b.b("java.nio.Bits.unaligned: available, {}", Boolean.valueOf(zBooleanValue));
                } else {
                    boolean zMatches = q.a("os.arch", BuildConfig.FLAVOR).matches("^(i[3-6]86|x86(_64)?|x64|amd64)$");
                    f4690b.a("java.nio.Bits.unaligned: unavailable, " + zMatches, (Throwable) objDoPrivileged5);
                    zBooleanValue = zMatches;
                }
                f = zBooleanValue;
            } catch (Throwable th2) {
                th = th2;
                jAllocateMemory = -1;
            }
        }
        f4690b.b("java.nio.DirectByteBuffer.<init>(long, int): {}", e != null ? "available" : "unavailable");
        a(byteBufferAllocateDirect);
    }

    static boolean a() {
        return f;
    }

    static boolean b() {
        return f4689a != null;
    }

    static void a(Throwable th) {
        f4689a.throwException((Throwable) j.a(th, "cause"));
    }

    static boolean c() {
        return e != null;
    }

    static ByteBuffer a(ByteBuffer byteBuffer, int i) {
        return a(f4689a.reallocateMemory(b(byteBuffer), i), i);
    }

    static ByteBuffer a(int i) {
        return a(f4689a.allocateMemory(i), i);
    }

    static ByteBuffer a(long j, int i) {
        j.a(j, "address");
        j.a(i, "capacity");
        try {
            return (ByteBuffer) e.newInstance(Long.valueOf(j), Integer.valueOf(i));
        } catch (Throwable th) {
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new Error(th);
        }
    }

    static void a(ByteBuffer byteBuffer) {
        a.a(byteBuffer);
    }

    static long b(ByteBuffer byteBuffer) {
        return b(byteBuffer, c);
    }

    static long d() {
        return d;
    }

    static Object a(Object obj, long j) {
        return f4689a.getObject(obj, j);
    }

    private static long b(Object obj, long j) {
        return f4689a.getLong(obj, j);
    }

    static long a(Field field) {
        return f4689a.objectFieldOffset(field);
    }

    static byte a(long j) {
        return f4689a.getByte(j);
    }

    static short b(long j) {
        return f4689a.getShort(j);
    }

    static int c(long j) {
        return f4689a.getInt(j);
    }

    static long d(long j) {
        return f4689a.getLong(j);
    }

    static byte a(byte[] bArr, int i) {
        return f4689a.getByte(bArr, d + i);
    }

    static short b(byte[] bArr, int i) {
        return f4689a.getShort(bArr, d + i);
    }

    static int c(byte[] bArr, int i) {
        return f4689a.getInt(bArr, d + i);
    }

    static long d(byte[] bArr, int i) {
        return f4689a.getLong(bArr, d + i);
    }

    static void a(long j, byte b2) {
        f4689a.putByte(j, b2);
    }

    static void a(long j, short s) {
        f4689a.putShort(j, s);
    }

    static void b(long j, int i) {
        f4689a.putInt(j, i);
    }

    static void a(long j, long j2) {
        f4689a.putLong(j, j2);
    }

    static void a(byte[] bArr, int i, byte b2) {
        f4689a.putByte(bArr, d + i, b2);
    }

    static void a(byte[] bArr, int i, short s) {
        f4689a.putShort(bArr, d + i, s);
    }

    static void a(byte[] bArr, int i, int i2) {
        f4689a.putInt(bArr, d + i, i2);
    }

    static void a(byte[] bArr, int i, long j) {
        f4689a.putLong(bArr, i + d, j);
    }

    static void a(long j, long j2, long j3) {
        while (j3 > 0) {
            long jMin = Math.min(j3, 1048576L);
            f4689a.copyMemory(j, j2, jMin);
            j3 -= jMin;
            j += jMin;
            j2 += jMin;
        }
    }

    static void a(Object obj, long j, Object obj2, long j2, long j3) {
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        while (j6 > 0) {
            long jMin = Math.min(j6, 1048576L);
            f4689a.copyMemory(obj, j4, obj2, j5, jMin);
            j6 -= jMin;
            j4 += jMin;
            j5 += jMin;
        }
    }

    static <U, W> AtomicReferenceFieldUpdater<U, W> a(Class<? super U> cls, String str) {
        return new x(f4689a, cls, str);
    }

    static <T> AtomicIntegerFieldUpdater<T> b(Class<? super T> cls, String str) {
        return new v(f4689a, cls, str);
    }

    static <T> AtomicLongFieldUpdater<T> c(Class<? super T> cls, String str) {
        return new w(f4689a, cls, str);
    }

    static ClassLoader a(final Class<?> cls) {
        if (System.getSecurityManager() == null) {
            return cls.getClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.a.m.6
            @Override // java.security.PrivilegedAction
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ClassLoader run() {
                return cls.getClassLoader();
            }
        });
    }

    static ClassLoader e() {
        if (System.getSecurityManager() == null) {
            return Thread.currentThread().getContextClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.a.m.7
            @Override // java.security.PrivilegedAction
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ClassLoader run() {
                return Thread.currentThread().getContextClassLoader();
            }
        });
    }

    static ClassLoader f() {
        if (System.getSecurityManager() == null) {
            return ClassLoader.getSystemClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.a.m.8
            @Override // java.security.PrivilegedAction
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }

    static int g() {
        return f4689a.addressSize();
    }

    static void e(long j) {
        f4689a.freeMemory(j);
    }

    private m() {
    }
}
