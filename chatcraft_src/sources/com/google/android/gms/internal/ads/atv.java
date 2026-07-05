package com.google.android.gms.internal.ads;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
final class atv {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f2265a = Logger.getLogger(atv.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private static final Unsafe f2266b = c();
    private static final Class<?> c = apj.b();
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

    private atv() {
    }

    static final class b extends d {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final void a(long j, byte b2) {
            Memory.pokeByte(j, b2);
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final byte a(Object obj, long j) {
            if (atv.w) {
                return atv.k(obj, j);
            }
            return atv.l(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final void a(Object obj, long j, byte b2) {
            if (atv.w) {
                atv.c(obj, j, b2);
            } else {
                atv.d(obj, j, b2);
            }
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final boolean b(Object obj, long j) {
            if (atv.w) {
                return atv.m(obj, j);
            }
            return atv.n(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final void a(Object obj, long j, boolean z) {
            if (atv.w) {
                atv.d(obj, j, z);
            } else {
                atv.e(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final float c(Object obj, long j) {
            return Float.intBitsToFloat(e(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final void a(Object obj, long j, float f) {
            a(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final double d(Object obj, long j) {
            return Double.longBitsToDouble(f(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final void a(Object obj, long j, double d) {
            a(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final void a(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }
    }

    static final class c extends d {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final void a(long j, byte b2) {
            this.f2267a.putByte(j, b2);
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final byte a(Object obj, long j) {
            return this.f2267a.getByte(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final void a(Object obj, long j, byte b2) {
            this.f2267a.putByte(obj, j, b2);
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final boolean b(Object obj, long j) {
            return this.f2267a.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final void a(Object obj, long j, boolean z) {
            this.f2267a.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final float c(Object obj, long j) {
            return this.f2267a.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final void a(Object obj, long j, float f) {
            this.f2267a.putFloat(obj, j, f);
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final double d(Object obj, long j) {
            return this.f2267a.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final void a(Object obj, long j, double d) {
            this.f2267a.putDouble(obj, j, d);
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final void a(byte[] bArr, long j, long j2, long j3) {
            this.f2267a.copyMemory(bArr, atv.i + j, (Object) null, j2, j3);
        }
    }

    static boolean a() {
        return h;
    }

    static abstract class d {

        /* renamed from: a, reason: collision with root package name */
        Unsafe f2267a;

        d(Unsafe unsafe) {
            this.f2267a = unsafe;
        }

        public abstract byte a(Object obj, long j);

        public abstract void a(long j, byte b2);

        public abstract void a(Object obj, long j, byte b2);

        public abstract void a(Object obj, long j, double d);

        public abstract void a(Object obj, long j, float f);

        public abstract void a(Object obj, long j, boolean z);

        public abstract void a(byte[] bArr, long j, long j2, long j3);

        public abstract boolean b(Object obj, long j);

        public abstract float c(Object obj, long j);

        public abstract double d(Object obj, long j);

        public final int e(Object obj, long j) {
            return this.f2267a.getInt(obj, j);
        }

        public final void a(Object obj, long j, int i) {
            this.f2267a.putInt(obj, j, i);
        }

        public final long f(Object obj, long j) {
            return this.f2267a.getLong(obj, j);
        }

        public final void a(Object obj, long j, long j2) {
            this.f2267a.putLong(obj, j, j2);
        }
    }

    static boolean b() {
        return g;
    }

    static final class a extends d {
        a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final void a(long j, byte b2) {
            Memory.pokeByte((int) (j & (-1)), b2);
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final byte a(Object obj, long j) {
            if (atv.w) {
                return atv.k(obj, j);
            }
            return atv.l(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final void a(Object obj, long j, byte b2) {
            if (atv.w) {
                atv.c(obj, j, b2);
            } else {
                atv.d(obj, j, b2);
            }
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final boolean b(Object obj, long j) {
            if (atv.w) {
                return atv.m(obj, j);
            }
            return atv.n(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final void a(Object obj, long j, boolean z) {
            if (atv.w) {
                atv.d(obj, j, z);
            } else {
                atv.e(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final float c(Object obj, long j) {
            return Float.intBitsToFloat(e(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final void a(Object obj, long j, float f) {
            a(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final double d(Object obj, long j) {
            return Double.longBitsToDouble(f(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final void a(Object obj, long j, double d) {
            a(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.android.gms.internal.ads.atv.d
        public final void a(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) (j2 & (-1)), bArr, (int) j, (int) j3);
        }
    }

    private static int a(Class<?> cls) {
        if (h) {
            return f.f2267a.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int b(Class<?> cls) {
        if (h) {
            return f.f2267a.arrayIndexScale(cls);
        }
        return -1;
    }

    static int a(Object obj, long j2) {
        return f.e(obj, j2);
    }

    static void a(Object obj, long j2, int i2) {
        f.a(obj, j2, i2);
    }

    static long b(Object obj, long j2) {
        return f.f(obj, j2);
    }

    static void a(Object obj, long j2, long j3) {
        f.a(obj, j2, j3);
    }

    static boolean c(Object obj, long j2) {
        return f.b(obj, j2);
    }

    static void a(Object obj, long j2, boolean z) {
        f.a(obj, j2, z);
    }

    static float d(Object obj, long j2) {
        return f.c(obj, j2);
    }

    static void a(Object obj, long j2, float f2) {
        f.a(obj, j2, f2);
    }

    static double e(Object obj, long j2) {
        return f.d(obj, j2);
    }

    static void a(Object obj, long j2, double d2) {
        f.a(obj, j2, d2);
    }

    static Object f(Object obj, long j2) {
        return f.f2267a.getObject(obj, j2);
    }

    static void a(Object obj, long j2, Object obj2) {
        f.f2267a.putObject(obj, j2, obj2);
    }

    static byte a(byte[] bArr, long j2) {
        return f.a(bArr, i + j2);
    }

    static void a(byte[] bArr, long j2, byte b2) {
        f.a((Object) bArr, i + j2, b2);
    }

    static void a(byte[] bArr, long j2, long j3, long j4) {
        f.a(bArr, j2, j3, j4);
    }

    static void a(long j2, byte b2) {
        f.a(j2, b2);
    }

    static long a(ByteBuffer byteBuffer) {
        return f.f(byteBuffer, v);
    }

    static Unsafe c() {
        try {
            return (Unsafe) AccessController.doPrivileged(new atw());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean f() {
        if (f2266b == null) {
            return false;
        }
        try {
            Class<?> cls = f2266b.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            cls.getMethod("getInt", Object.class, Long.TYPE);
            cls.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            cls.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
            cls.getMethod("getObject", Object.class, Long.TYPE);
            cls.getMethod("putObject", Object.class, Long.TYPE, Object.class);
            if (apj.a()) {
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
            Logger logger = f2265a;
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(strValueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean g() {
        if (f2266b == null) {
            return false;
        }
        try {
            Class<?> cls = f2266b.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (h() == null) {
                return false;
            }
            if (apj.a()) {
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
            Logger logger = f2265a;
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
        if (!apj.a()) {
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

    private static Field h() {
        Field fieldA;
        if (apj.a() && (fieldA = a((Class<?>) Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldA;
        }
        Field fieldA2 = a((Class<?>) Buffer.class, "address");
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

    /* JADX INFO: Access modifiers changed from: private */
    public static byte k(Object obj, long j2) {
        return (byte) (a(obj, (-4) & j2) >>> ((int) (((j2 ^ (-1)) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte l(Object obj, long j2) {
        return (byte) (a(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = ((((int) j2) ^ (-1)) & 3) << 3;
        a(obj, j3, ((255 & b2) << i2) | (a(obj, j3) & ((255 << i2) ^ (-1))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        a(obj, j3, ((255 & b2) << i2) | (a(obj, j3) & ((255 << i2) ^ (-1))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean m(Object obj, long j2) {
        return k(obj, j2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean n(Object obj, long j2) {
        return l(obj, j2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Object obj, long j2, boolean z) {
        c(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(Object obj, long j2, boolean z) {
        d(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    static {
        d cVar = null;
        if (f2266b != null) {
            if (apj.a()) {
                if (d) {
                    cVar = new b(f2266b);
                } else if (e) {
                    cVar = new a(f2266b);
                }
            } else {
                cVar = new c(f2266b);
            }
        }
        f = cVar;
        g = g();
        h = f();
        i = a((Class<?>) byte[].class);
        j = a((Class<?>) boolean[].class);
        k = b(boolean[].class);
        l = a((Class<?>) int[].class);
        m = b(int[].class);
        n = a((Class<?>) long[].class);
        o = b(long[].class);
        p = a((Class<?>) float[].class);
        q = b(float[].class);
        r = a((Class<?>) double[].class);
        s = b(double[].class);
        t = a((Class<?>) Object[].class);
        u = b(Object[].class);
        Field fieldH = h();
        v = (fieldH == null || f == null) ? -1L : f.f2267a.objectFieldOffset(fieldH);
        w = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }
}
