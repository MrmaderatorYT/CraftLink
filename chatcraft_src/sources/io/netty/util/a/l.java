package io.netty.util.a;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Locale;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: PlatformDependent.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f4686a;
    private static volatile Boolean g;
    private static final boolean l;
    private static final boolean m;
    private static final long n;
    private static final long o;
    private static final boolean p;
    private static final File q;
    private static final int r;
    private static final int s;
    private static final boolean t;
    private static final AtomicLong u;
    private static final long v;

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ boolean f4687b = !l.class.desiredAssertionStatus();
    private static final io.netty.util.a.b.c c = io.netty.util.a.b.d.a((Class<?>) l.class);
    private static final Pattern d = Pattern.compile("\\s*-XX:MaxDirectMemorySize\\s*=\\s*([0-9]+)\\s*([kKmMgG]?)\\s*$");
    private static final boolean e = s();
    private static final boolean f = t();
    private static final int h = v();
    private static final boolean i = !a();
    private static final boolean j = w();
    private static final boolean k = x();

    static {
        l = k && h < 8;
        m = k && !q.a("io.netty.noPreferDirect", false);
        n = y();
        o = m.d();
        p = z();
        q = A();
        r = B();
        s = C();
        f4686a = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
        if (c.b()) {
            c.b("-Dio.netty.noPreferDirect: {}", Boolean.valueOf(!m));
        }
        if (!f() && !a() && !j) {
            c.b("Your platform does not provide complete low-level API for accessing direct buffers reliably. Unless explicitly requested, heap buffer will always be preferred to avoid potential system unstability.");
        }
        long jA = q.a("io.netty.maxDirectMemory", -1L);
        if (jA == 0 || !f() || !m.c()) {
            t = false;
            u = null;
        } else {
            t = true;
            if (jA < 0) {
                jA = y();
                if (jA <= 0) {
                    u = null;
                } else {
                    u = new AtomicLong();
                }
            } else {
                u = new AtomicLong();
            }
        }
        v = jA;
        c.b("io.netty.maxDirectMemory: {} bytes", Long.valueOf(jA));
    }

    public static boolean a() {
        return e;
    }

    public static boolean b() {
        return f;
    }

    public static boolean c() {
        if (g == null) {
            synchronized (l.class) {
                if (g == null) {
                    g = Boolean.valueOf(u());
                }
            }
        }
        return g.booleanValue();
    }

    public static int d() {
        return h;
    }

    public static boolean e() {
        return i;
    }

    public static boolean f() {
        return k;
    }

    public static boolean g() {
        return m.a();
    }

    public static boolean h() {
        return m;
    }

    public static long i() {
        return n;
    }

    public static boolean j() {
        return p;
    }

    public static void a(Throwable th) throws Throwable {
        if (f()) {
            m.a(th);
        } else {
            b(th);
        }
    }

    private static <E extends Throwable> void b(Throwable th) throws Throwable {
        throw th;
    }

    public static <K, V> ConcurrentMap<K, V> k() {
        if (l) {
            return new io.netty.util.a.a.a();
        }
        return new ConcurrentHashMap();
    }

    public static f l() {
        if (k) {
            return new io.netty.util.a.a.b();
        }
        return new a();
    }

    public static void a(ByteBuffer byteBuffer) {
        if (!f() || a()) {
            return;
        }
        m.a(byteBuffer);
    }

    public static long b(ByteBuffer byteBuffer) {
        return m.b(byteBuffer);
    }

    public static byte a(long j2) {
        return m.a(j2);
    }

    public static short b(long j2) {
        return m.b(j2);
    }

    public static int c(long j2) {
        return m.c(j2);
    }

    public static long d(long j2) {
        return m.d(j2);
    }

    public static byte a(byte[] bArr, int i2) {
        return m.a(bArr, i2);
    }

    public static short b(byte[] bArr, int i2) {
        return m.b(bArr, i2);
    }

    public static int c(byte[] bArr, int i2) {
        return m.c(bArr, i2);
    }

    public static long d(byte[] bArr, int i2) {
        return m.d(bArr, i2);
    }

    public static void a(long j2, byte b2) {
        m.a(j2, b2);
    }

    public static void a(long j2, short s2) {
        m.a(j2, s2);
    }

    public static void a(long j2, int i2) {
        m.b(j2, i2);
    }

    public static void a(long j2, long j3) {
        m.a(j2, j3);
    }

    public static void a(byte[] bArr, int i2, byte b2) {
        m.a(bArr, i2, b2);
    }

    public static void a(byte[] bArr, int i2, short s2) {
        m.a(bArr, i2, s2);
    }

    public static void a(byte[] bArr, int i2, int i3) {
        m.a(bArr, i2, i3);
    }

    public static void a(byte[] bArr, int i2, long j2) {
        m.a(bArr, i2, j2);
    }

    public static void a(long j2, long j3, long j4) {
        m.a(j2, j3, j4);
    }

    public static void a(byte[] bArr, int i2, long j2, long j3) {
        m.a(bArr, o + i2, null, j2, j3);
    }

    public static void a(long j2, byte[] bArr, int i2, long j3) {
        m.a(null, j2, bArr, o + i2, j3);
    }

    public static ByteBuffer a(int i2) throws Throwable {
        if (!f4687b && !t) {
            throw new AssertionError();
        }
        d(i2);
        try {
            return m.a(i2);
        } catch (Throwable th) {
            e(i2);
            a(th);
            return null;
        }
    }

    public static ByteBuffer a(ByteBuffer byteBuffer, int i2) throws Throwable {
        if (!f4687b && !t) {
            throw new AssertionError();
        }
        int iCapacity = i2 - byteBuffer.capacity();
        d(iCapacity);
        try {
            return m.a(byteBuffer, i2);
        } catch (Throwable th) {
            e(iCapacity);
            a(th);
            return null;
        }
    }

    public static void c(ByteBuffer byteBuffer) {
        if (!f4687b && !t) {
            throw new AssertionError();
        }
        int iCapacity = byteBuffer.capacity();
        m.e(m.b(byteBuffer));
        e(iCapacity);
    }

    private static void d(int i2) {
        long j2;
        long j3;
        if (u != null) {
            do {
                j2 = u.get();
                j3 = i2 + j2;
                if (j3 > v) {
                    throw new k("failed to allocate " + i2 + " byte(s) of direct memory (used: " + j2 + ", max: " + v + ')');
                }
            } while (!u.compareAndSet(j2, j3));
        }
    }

    private static void e(int i2) {
        if (u != null) {
            long jAddAndGet = u.addAndGet(-i2);
            if (!f4687b && jAddAndGet < 0) {
                throw new AssertionError();
            }
        }
    }

    public static boolean m() {
        return t;
    }

    public static <U, W> AtomicReferenceFieldUpdater<U, W> a(Class<? super U> cls, String str) {
        if (!f()) {
            return null;
        }
        try {
            return m.a(cls, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <T> AtomicIntegerFieldUpdater<T> b(Class<? super T> cls, String str) {
        if (!f()) {
            return null;
        }
        try {
            return m.b(cls, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <T> AtomicLongFieldUpdater<T> c(Class<? super T> cls, String str) {
        if (!f()) {
            return null;
        }
        try {
            return m.c(cls, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* compiled from: PlatformDependent.java */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final boolean f4688a;

        static {
            if ((l.f() ? AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.a.l.b.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    return io.netty.util.a.c.a.a.b.c.f4677b;
                }
            }) : null) == null) {
                l.c.a("org.jctools-core.MpscChunkedArrayQueue: unavailable");
                f4688a = false;
            } else {
                l.c.a("org.jctools-core.MpscChunkedArrayQueue: available");
                f4688a = true;
            }
        }

        static <T> Queue<T> a(int i) {
            if (f4688a) {
                return new io.netty.util.a.c.a.a.a.k(1024, Math.max(Math.min(i, 1073741824), 2048), true);
            }
            return new io.netty.util.a.c.a.a.a.a.e();
        }
    }

    public static <T> Queue<T> n() {
        return b(1048576);
    }

    public static <T> Queue<T> b(int i2) {
        return b.a(i2);
    }

    public static <T> Queue<T> c(int i2) {
        return f() ? new io.netty.util.a.c.a.a.a.d(i2) : new io.netty.util.a.c.a.a.a.a.d(i2);
    }

    public static ClassLoader a(Class<?> cls) {
        return m.a(cls);
    }

    public static ClassLoader o() {
        return m.e();
    }

    public static ClassLoader p() {
        return m.f();
    }

    private static boolean s() {
        boolean z = false;
        try {
            Class.forName("android.app.Application", false, p());
            z = true;
        } catch (Throwable unused) {
        }
        if (z) {
            c.a("Platform: Android");
        }
        return z;
    }

    private static boolean t() {
        boolean zContains = q.a("os.name", BuildConfig.FLAVOR).toLowerCase(Locale.US).contains("win");
        if (zContains) {
            c.a("Platform: Windows");
        }
        return zContains;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x005f A[EXC_TOP_SPLITTER, PHI: r7 r8
      0x005f: PHI (r7v2 java.lang.String) = (r7v8 java.lang.String), (r7v5 java.lang.String) binds: [B:40:0x0084, B:17:0x005d] A[DONT_GENERATE, DONT_INLINE]
      0x005f: PHI (r8v6 java.lang.Process) = (r8v4 java.lang.Process), (r8v10 java.lang.Process) binds: [B:40:0x0084, B:17:0x005d] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean u() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.a.l.u():boolean");
    }

    private static int v() {
        int iQ = a() ? 6 : q();
        c.b("Java version: {}", Integer.valueOf(iQ));
        return iQ;
    }

    static int q() {
        try {
            return a((String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: io.netty.util.a.l.1
                @Override // java.security.PrivilegedAction
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public String run() {
                    return System.getProperty("java.specification.version");
                }
            }));
        } catch (SecurityException e2) {
            c.a("security exception while reading java.specification.version", (Throwable) e2);
            return 6;
        }
    }

    static int a(String str) {
        String[] strArrSplit = str.split("\\.");
        int[] iArr = new int[strArrSplit.length];
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            iArr[i2] = Integer.parseInt(strArrSplit[i2]);
        }
        if (iArr[0] == 1) {
            if (f4687b || iArr[1] >= 6) {
                return iArr[1];
            }
            throw new AssertionError();
        }
        return iArr[0];
    }

    private static boolean w() {
        boolean zA;
        boolean zA2 = q.a("io.netty.noUnsafe", false);
        c.b("-Dio.netty.noUnsafe: {}", Boolean.valueOf(zA2));
        if (zA2) {
            c.a("sun.misc.Unsafe: unavailable (io.netty.noUnsafe)");
            return true;
        }
        if (q.a("io.netty.tryUnsafe")) {
            zA = q.a("io.netty.tryUnsafe", true);
        } else {
            zA = q.a("org.jboss.netty.tryUnsafe", true);
        }
        if (zA) {
            return false;
        }
        c.a("sun.misc.Unsafe: unavailable (io.netty.tryUnsafe/org.jboss.netty.tryUnsafe)");
        return true;
    }

    private static boolean x() {
        if (a()) {
            c.a("sun.misc.Unsafe: unavailable (Android)");
            return false;
        }
        if (j) {
            return false;
        }
        try {
            boolean zB = m.b();
            c.b("sun.misc.Unsafe: {}", zB ? "available" : "unavailable");
            return zB;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0078, code lost:
    
        r9 = java.lang.Long.parseLong(r8.group(1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0081, code lost:
    
        r0 = r8.group(2).charAt(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x008b, code lost:
    
        if (r0 == 'G') goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008f, code lost:
    
        if (r0 == 'K') goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0093, code lost:
    
        if (r0 == 'M') goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0097, code lost:
    
        if (r0 == 'g') goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009b, code lost:
    
        if (r0 == 'k') goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009f, code lost:
    
        if (r0 == 'm') goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a3, code lost:
    
        r9 = r9 * 1048576;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a9, code lost:
    
        r9 = r9 * 1024;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ae, code lost:
    
        r9 = r9 * 1073741824;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static long y() {
        /*
            r0 = 0
            r1 = 0
            r3 = 1
            r4 = 0
            java.lang.String r5 = "sun.misc.VM"
            java.lang.ClassLoader r6 = p()     // Catch: java.lang.Throwable -> L24
            java.lang.Class r5 = java.lang.Class.forName(r5, r3, r6)     // Catch: java.lang.Throwable -> L24
            java.lang.String r6 = "maxDirectMemory"
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch: java.lang.Throwable -> L24
            java.lang.reflect.Method r5 = r5.getDeclaredMethod(r6, r7)     // Catch: java.lang.Throwable -> L24
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L24
            java.lang.Object r5 = r5.invoke(r0, r6)     // Catch: java.lang.Throwable -> L24
            java.lang.Number r5 = (java.lang.Number) r5     // Catch: java.lang.Throwable -> L24
            long r5 = r5.longValue()     // Catch: java.lang.Throwable -> L24
            goto L25
        L24:
            r5 = r1
        L25:
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 <= 0) goto L2a
            return r5
        L2a:
            java.lang.String r7 = "java.lang.management.ManagementFactory"
            java.lang.ClassLoader r8 = p()     // Catch: java.lang.Throwable -> Lb4
            java.lang.Class r7 = java.lang.Class.forName(r7, r3, r8)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r8 = "java.lang.management.RuntimeMXBean"
            java.lang.ClassLoader r9 = p()     // Catch: java.lang.Throwable -> Lb4
            java.lang.Class r8 = java.lang.Class.forName(r8, r3, r9)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r9 = "getRuntimeMXBean"
            java.lang.Class[] r10 = new java.lang.Class[r4]     // Catch: java.lang.Throwable -> Lb4
            java.lang.reflect.Method r7 = r7.getDeclaredMethod(r9, r10)     // Catch: java.lang.Throwable -> Lb4
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> Lb4
            java.lang.Object r0 = r7.invoke(r0, r9)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r7 = "getInputArguments"
            java.lang.Class[] r9 = new java.lang.Class[r4]     // Catch: java.lang.Throwable -> Lb4
            java.lang.reflect.Method r7 = r8.getDeclaredMethod(r7, r9)     // Catch: java.lang.Throwable -> Lb4
            java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> Lb4
            java.lang.Object r0 = r7.invoke(r0, r8)     // Catch: java.lang.Throwable -> Lb4
            java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Throwable -> Lb4
            int r7 = r0.size()     // Catch: java.lang.Throwable -> Lb4
            int r7 = r7 - r3
        L61:
            if (r7 < 0) goto Lb4
            java.util.regex.Pattern r8 = io.netty.util.a.l.d     // Catch: java.lang.Throwable -> Lb4
            java.lang.Object r9 = r0.get(r7)     // Catch: java.lang.Throwable -> Lb4
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch: java.lang.Throwable -> Lb4
            java.util.regex.Matcher r8 = r8.matcher(r9)     // Catch: java.lang.Throwable -> Lb4
            boolean r9 = r8.matches()     // Catch: java.lang.Throwable -> Lb4
            if (r9 != 0) goto L78
            int r7 = r7 + (-1)
            goto L61
        L78:
            java.lang.String r0 = r8.group(r3)     // Catch: java.lang.Throwable -> Lb4
            long r9 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Throwable -> Lb4
            r0 = 2
            java.lang.String r0 = r8.group(r0)     // Catch: java.lang.Throwable -> La1
            char r0 = r0.charAt(r4)     // Catch: java.lang.Throwable -> La1
            r3 = 71
            if (r0 == r3) goto Lae
            r3 = 75
            if (r0 == r3) goto La9
            r3 = 77
            if (r0 == r3) goto La3
            r3 = 103(0x67, float:1.44E-43)
            if (r0 == r3) goto Lae
            r3 = 107(0x6b, float:1.5E-43)
            if (r0 == r3) goto La9
            r3 = 109(0x6d, float:1.53E-43)
            if (r0 == r3) goto La3
        La1:
            r5 = r9
            goto Lb4
        La3:
            r3 = 1048576(0x100000, double:5.180654E-318)
            long r9 = r9 * r3
            goto La1
        La9:
            r3 = 1024(0x400, double:5.06E-321)
            long r9 = r9 * r3
            goto La1
        Lae:
            r3 = 1073741824(0x40000000, double:5.304989477E-315)
            long r9 = r9 * r3
            goto La1
        Lb4:
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 > 0) goto Lcc
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()
            long r5 = r0.maxMemory()
            io.netty.util.a.b.c r0 = io.netty.util.a.l.c
            java.lang.String r1 = "maxDirectMemory: {} bytes (maybe)"
            java.lang.Long r2 = java.lang.Long.valueOf(r5)
            r0.b(r1, r2)
            goto Ld7
        Lcc:
            io.netty.util.a.b.c r0 = io.netty.util.a.l.c
            java.lang.String r1 = "maxDirectMemory: {} bytes"
            java.lang.Long r2 = java.lang.Long.valueOf(r5)
            r0.b(r1, r2)
        Ld7:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.a.l.y():long");
    }

    private static boolean z() {
        if (a()) {
            return false;
        }
        boolean zA = q.a("io.netty.noJavassist", false);
        c.b("-Dio.netty.noJavassist: {}", Boolean.valueOf(zA));
        if (zA) {
            c.a("Javassist: unavailable (io.netty.noJavassist)");
            return false;
        }
        try {
            e.a(Object.class, a((Class<?>) l.class));
            c.a("Javassist: available");
            return true;
        } catch (Throwable unused) {
            c.a("Javassist: unavailable");
            c.a("You don't have Javassist in your class path or you don't have enough permission to load dynamically generated classes.  Please check the configuration for better performance.");
            return false;
        }
    }

    private static File A() {
        File file;
        File fileB;
        try {
            fileB = b(q.b("io.netty.tmpdir"));
        } catch (Throwable unused) {
        }
        if (fileB != null) {
            c.b("-Dio.netty.tmpdir: {}", fileB);
            return fileB;
        }
        File fileB2 = b(q.b("java.io.tmpdir"));
        if (fileB2 != null) {
            c.b("-Dio.netty.tmpdir: {} (java.io.tmpdir)", fileB2);
            return fileB2;
        }
        if (b()) {
            File fileB3 = b(System.getenv("TEMP"));
            if (fileB3 != null) {
                c.b("-Dio.netty.tmpdir: {} (%TEMP%)", fileB3);
                return fileB3;
            }
            String str = System.getenv("USERPROFILE");
            if (str != null) {
                File fileB4 = b(str + "\\AppData\\Local\\Temp");
                if (fileB4 != null) {
                    c.b("-Dio.netty.tmpdir: {} (%USERPROFILE%\\AppData\\Local\\Temp)", fileB4);
                    return fileB4;
                }
                File fileB5 = b(str + "\\Local Settings\\Temp");
                if (fileB5 != null) {
                    c.b("-Dio.netty.tmpdir: {} (%USERPROFILE%\\Local Settings\\Temp)", fileB5);
                    return fileB5;
                }
            }
        } else {
            File fileB6 = b(System.getenv("TMPDIR"));
            if (fileB6 != null) {
                c.b("-Dio.netty.tmpdir: {} ($TMPDIR)", fileB6);
                return fileB6;
            }
        }
        if (b()) {
            file = new File("C:\\Windows\\Temp");
        } else {
            file = new File("/tmp");
        }
        c.c("Failed to get the temporary directory; falling back to: {}", file);
        return file;
    }

    private static File b(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        file.mkdirs();
        if (!file.isDirectory()) {
            return null;
        }
        try {
            return file.getAbsoluteFile();
        } catch (Exception unused) {
            return file;
        }
    }

    private static int B() {
        int iA = q.a("io.netty.bitMode", 0);
        if (iA > 0) {
            c.b("-Dio.netty.bitMode: {}", Integer.valueOf(iA));
            return iA;
        }
        int iA2 = q.a("sun.arch.data.model", 0);
        if (iA2 > 0) {
            c.b("-Dio.netty.bitMode: {} (sun.arch.data.model)", Integer.valueOf(iA2));
            return iA2;
        }
        int iA3 = q.a("com.ibm.vm.bitmode", 0);
        if (iA3 > 0) {
            c.b("-Dio.netty.bitMode: {} (com.ibm.vm.bitmode)", Integer.valueOf(iA3));
            return iA3;
        }
        String strTrim = q.a("os.arch", BuildConfig.FLAVOR).toLowerCase(Locale.US).trim();
        if ("amd64".equals(strTrim) || "x86_64".equals(strTrim)) {
            iA3 = 64;
        } else if ("i386".equals(strTrim) || "i486".equals(strTrim) || "i586".equals(strTrim) || "i686".equals(strTrim)) {
            iA3 = 32;
        }
        if (iA3 > 0) {
            c.b("-Dio.netty.bitMode: {} (os.arch: {})", Integer.valueOf(iA3), strTrim);
        }
        Matcher matcher = Pattern.compile("([1-9][0-9]+)-?bit").matcher(q.a("java.vm.name", BuildConfig.FLAVOR).toLowerCase(Locale.US));
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 64;
    }

    private static int C() {
        if (f()) {
            return m.g();
        }
        return -1;
    }

    /* compiled from: PlatformDependent.java */
    private static final class a extends AtomicLong implements f {
        private a() {
        }

        @Override // io.netty.util.a.f
        public void a(long j) {
            addAndGet(j);
        }

        @Override // io.netty.util.a.f
        public void a() {
            incrementAndGet();
        }
    }

    private l() {
    }
}
