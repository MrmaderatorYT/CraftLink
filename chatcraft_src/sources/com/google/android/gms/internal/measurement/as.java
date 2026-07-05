package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
final class as {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f3691a = Logger.getLogger(as.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private static final Unsafe f3692b = b();
    private static final Class<?> c = aq.b();
    private static final boolean d = c(Long.TYPE);
    private static final boolean e = c(Integer.TYPE);
    private static final d f;
    private static final boolean g;
    private static final boolean h;
    private static final long i;
    private static final long j;
    private static final long k;
    private static final long l;
    private static final long m;
    private static final long n;
    private static final long o;
    private static final long p;
    private static final long q;
    private static final long r;
    private static final long s;
    private static final long t;
    private static final long u;
    private static final long v;
    private static final boolean w;

    static final class a extends d {
        a(Unsafe unsafe) {
            super(unsafe);
        }
    }

    static final class b extends d {
        b(Unsafe unsafe) {
            super(unsafe);
        }
    }

    static final class c extends d {
        c(Unsafe unsafe) {
            super(unsafe);
        }
    }

    static abstract class d {

        /* renamed from: a, reason: collision with root package name */
        Unsafe f3693a;

        d(Unsafe unsafe) {
            this.f3693a = unsafe;
        }
    }

    private as() {
    }

    static boolean a() {
        return h;
    }

    private static int a(Class<?> cls) {
        if (h) {
            return f.f3693a.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int b(Class<?> cls) {
        if (h) {
            return f.f3693a.arrayIndexScale(cls);
        }
        return -1;
    }

    static Unsafe b() {
        try {
            return (Unsafe) AccessController.doPrivileged(new at());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean c() {
        if (f3692b == null) {
            return false;
        }
        try {
            Class<?> cls = f3692b.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            cls.getMethod("getInt", Object.class, Long.TYPE);
            cls.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            cls.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
            cls.getMethod("getObject", Object.class, Long.TYPE);
            cls.getMethod("putObject", Object.class, Long.TYPE, Object.class);
            if (aq.a()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, Long.TYPE);
            cls.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, Long.TYPE);
            cls.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, Long.TYPE);
            cls.getMethod("putFloat", Object.class, Long.TYPE, Float.TYPE);
            cls.getMethod("getDouble", Object.class, Long.TYPE);
            cls.getMethod("putDouble", Object.class, Long.TYPE, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger = f3691a;
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(strValueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean d() {
        if (f3692b == null) {
            return false;
        }
        try {
            Class<?> cls = f3692b.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (e() == null) {
                return false;
            }
            if (aq.a()) {
                return true;
            }
            cls.getMethod("getByte", Long.TYPE);
            cls.getMethod("putByte", Long.TYPE, Byte.TYPE);
            cls.getMethod("getInt", Long.TYPE);
            cls.getMethod("putInt", Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Long.TYPE);
            cls.getMethod("putLong", Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger = f3691a;
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(strValueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static boolean c(Class<?> cls) {
        if (!aq.a()) {
            return false;
        }
        try {
            Class<?> cls2 = c;
            cls2.getMethod("peekLong", cls, Boolean.TYPE);
            cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
            cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
            cls2.getMethod("peekInt", cls, Boolean.TYPE);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field e() {
        Field fieldA;
        if (aq.a() && (fieldA = a(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldA;
        }
        Field fieldA2 = a(Buffer.class, "address");
        if (fieldA2 == null || fieldA2.getType() != Long.TYPE) {
            return null;
        }
        return fieldA2;
    }

    private static Field a(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    static {
        d cVar = null;
        if (f3692b != null) {
            if (aq.a()) {
                if (d) {
                    cVar = new b(f3692b);
                } else if (e) {
                    cVar = new a(f3692b);
                }
            } else {
                cVar = new c(f3692b);
            }
        }
        f = cVar;
        g = d();
        h = c();
        i = a(byte[].class);
        j = a(boolean[].class);
        k = b(boolean[].class);
        l = a(int[].class);
        m = b(int[].class);
        n = a(long[].class);
        o = b(long[].class);
        p = a(float[].class);
        q = b(float[].class);
        r = a(double[].class);
        s = b(double[].class);
        t = a(Object[].class);
        u = b(Object[].class);
        Field fieldE = e();
        v = (fieldE == null || f == null) ? -1L : f.f3693a.objectFieldOffset(fieldE);
        w = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }
}
