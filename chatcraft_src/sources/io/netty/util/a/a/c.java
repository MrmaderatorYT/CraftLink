package io.netty.util.a.a;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

/* compiled from: Striped64.java */
/* loaded from: classes.dex */
abstract class c extends Number {

    /* renamed from: a, reason: collision with root package name */
    static final ThreadLocal<int[]> f4639a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    static final Random f4640b = new Random();
    static final int c = Runtime.getRuntime().availableProcessors();
    private static final Unsafe g;
    private static final long h;
    private static final long i;
    volatile transient a[] d;
    volatile transient long e;
    volatile transient int f;

    abstract long a(long j, long j2);

    /* compiled from: Striped64.java */
    static final class a {

        /* renamed from: b, reason: collision with root package name */
        private static final Unsafe f4641b;
        private static final long c;

        /* renamed from: a, reason: collision with root package name */
        volatile long f4642a;

        a(long j) {
            this.f4642a = j;
        }

        final boolean a(long j, long j2) {
            return f4641b.compareAndSwapLong(this, c, j, j2);
        }

        static {
            try {
                f4641b = c.a();
                c = f4641b.objectFieldOffset(a.class.getDeclaredField("value"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }
    }

    static {
        try {
            g = a();
            h = g.objectFieldOffset(c.class.getDeclaredField("base"));
            i = g.objectFieldOffset(c.class.getDeclaredField("busy"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    c() {
    }

    final boolean b(long j, long j2) {
        return g.compareAndSwapLong(this, h, j, j2);
    }

    final boolean c() {
        return g.compareAndSwapInt(this, i, 0, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0092, code lost:
    
        if (r17.d != r9) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0094, code lost:
    
        r8 = new io.netty.util.a.a.c.a[r10 << 1];
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0099, code lost:
    
        if (r11 >= r10) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009b, code lost:
    
        r8[r11] = r9[r11];
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a2, code lost:
    
        r17.d = r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0027 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void a(long r18, int[] r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.a.a.c.a(long, int[], boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Unsafe a() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e) {
                throw new RuntimeException("Could not initialize intrinsics", e.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: io.netty.util.a.a.c.1
                @Override // java.security.PrivilegedExceptionAction
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Unsafe run() throws IllegalAccessException, IllegalArgumentException {
                    for (Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    throw new NoSuchFieldError("the Unsafe");
                }
            });
        }
    }
}
