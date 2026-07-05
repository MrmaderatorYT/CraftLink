package io.netty.b;

import com.github.steveice10.mc.v1_5.util.Constants;
import io.netty.util.l;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.util.Locale;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: ByteBufUtil.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    static final j f4383a;
    private static final int d;
    private static final int e;
    private static final io.netty.util.e g;

    /* renamed from: b, reason: collision with root package name */
    private static final io.netty.util.a.b.c f4384b = io.netty.util.a.b.d.a((Class<?>) l.class);
    private static final io.netty.util.concurrent.n<CharBuffer> c = new io.netty.util.concurrent.n<CharBuffer>() { // from class: io.netty.b.l.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.n
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CharBuffer b() {
            return CharBuffer.allocate(1024);
        }
    };
    private static final int f = (int) io.netty.util.f.a(io.netty.util.f.d).maxBytesPerChar();

    static {
        j jVar;
        String strTrim = io.netty.util.a.q.a("io.netty.allocator.type", io.netty.util.a.l.a() ? "unpooled" : "pooled").toLowerCase(Locale.US).trim();
        if ("unpooled".equals(strTrim)) {
            jVar = ag.f4374b;
            f4384b.b("-Dio.netty.allocator.type: {}", strTrim);
        } else if ("pooled".equals(strTrim)) {
            jVar = x.f4412b;
            f4384b.b("-Dio.netty.allocator.type: {}", strTrim);
        } else {
            jVar = x.f4412b;
            f4384b.b("-Dio.netty.allocator.type: pooled (unknown: {})", strTrim);
        }
        f4383a = jVar;
        e = io.netty.util.a.q.a("io.netty.threadLocalDirectBufferSize", 65536);
        f4384b.b("-Dio.netty.threadLocalDirectBufferSize: {}", Integer.valueOf(e));
        d = io.netty.util.a.q.a("io.netty.maxThreadLocalCharBufferSize", 16384);
        f4384b.b("-Dio.netty.maxThreadLocalCharBufferSize: {}", Integer.valueOf(d));
        g = new io.netty.util.e() { // from class: io.netty.b.l.2
        };
    }

    public static String a(byte[] bArr, int i, int i2) {
        return a.b(bArr, i, i2);
    }

    public static int a(i iVar) {
        int i;
        int iA;
        int iG = iVar.g();
        int i2 = iG >>> 2;
        int i3 = iG & 3;
        int iB = iVar.b();
        if (iVar.G() == ByteOrder.BIG_ENDIAN) {
            i = iB;
            iA = 1;
            while (i2 > 0) {
                iA = (iA * 31) + iVar.m(i);
                i += 4;
                i2--;
            }
        } else {
            i = iB;
            iA = 1;
            while (i2 > 0) {
                iA = (iA * 31) + a(iVar.m(i));
                i += 4;
                i2--;
            }
        }
        while (i3 > 0) {
            iA = (iA * 31) + iVar.f(i);
            i3--;
            i++;
        }
        if (iA == 0) {
            return 1;
        }
        return iA;
    }

    public static boolean a(i iVar, int i, i iVar2, int i2, int i3) {
        if (i < 0 || i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("All indexes and lengths must be non-negative");
        }
        if (iVar.c() - i3 < i || iVar2.c() - i3 < i2) {
            return false;
        }
        int i4 = i3 >>> 3;
        if (iVar.G() == iVar2.G()) {
            while (i4 > 0) {
                if (iVar.s(i) != iVar2.s(i2)) {
                    return false;
                }
                i += 8;
                i2 += 8;
                i4--;
            }
        } else {
            while (i4 > 0) {
                if (iVar.s(i) != a(iVar2.s(i2))) {
                    return false;
                }
                i += 8;
                i2 += 8;
                i4--;
            }
        }
        for (int i5 = i3 & 7; i5 > 0; i5--) {
            if (iVar.f(i) != iVar2.f(i2)) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public static boolean a(i iVar, i iVar2) {
        int iG = iVar.g();
        if (iG != iVar2.g()) {
            return false;
        }
        return a(iVar, iVar.b(), iVar2, iVar2.b(), iG);
    }

    public static int b(i iVar, i iVar2) {
        long jC;
        int iG = iVar.g();
        int iG2 = iVar2.g();
        int iMin = Math.min(iG, iG2);
        int i = iMin >>> 2;
        int i2 = iMin & 3;
        int iB = iVar.b();
        int iB2 = iVar2.b();
        if (i > 0) {
            boolean z = iVar.G() == ByteOrder.BIG_ENDIAN;
            int i3 = i << 2;
            if (iVar.G() == iVar2.G()) {
                jC = z ? a(iVar, iVar2, iB, iB2, i3) : b(iVar, iVar2, iB, iB2, i3);
            } else {
                jC = z ? c(iVar, iVar2, iB, iB2, i3) : d(iVar, iVar2, iB, iB2, i3);
            }
            if (jC != 0) {
                return (int) Math.min(2147483647L, jC);
            }
            iB += i3;
            iB2 += i3;
        }
        int i4 = i2 + iB;
        while (iB < i4) {
            int iH = iVar.h(iB) - iVar2.h(iB2);
            if (iH != 0) {
                return iH;
            }
            iB++;
            iB2++;
        }
        return iG - iG2;
    }

    private static long a(i iVar, i iVar2, int i, int i2, int i3) {
        int i4 = i3 + i;
        while (i < i4) {
            long jQ = iVar.q(i) - iVar2.q(i2);
            if (jQ != 0) {
                return jQ;
            }
            i += 4;
            i2 += 4;
        }
        return 0L;
    }

    private static long b(i iVar, i iVar2, int i, int i2, int i3) {
        int i4 = i3 + i;
        while (i < i4) {
            long jR = iVar.r(i) - iVar2.r(i2);
            if (jR != 0) {
                return jR;
            }
            i += 4;
            i2 += 4;
        }
        return 0L;
    }

    private static long c(i iVar, i iVar2, int i, int i2, int i3) {
        int i4 = i3 + i;
        while (i < i4) {
            long jQ = iVar.q(i) - iVar2.r(i2);
            if (jQ != 0) {
                return jQ;
            }
            i += 4;
            i2 += 4;
        }
        return 0L;
    }

    private static long d(i iVar, i iVar2, int i, int i2, int i3) {
        int i4 = i3 + i;
        while (i < i4) {
            long jR = iVar.r(i) - iVar2.q(i2);
            if (jR != 0) {
                return jR;
            }
            i += 4;
            i2 += 4;
        }
        return 0L;
    }

    public static short a(short s) {
        return Short.reverseBytes(s);
    }

    public static int a(int i) {
        return Integer.reverseBytes(i);
    }

    public static long a(long j) {
        return Long.reverseBytes(j);
    }

    public static i a() {
        if (e <= 0) {
            return null;
        }
        if (io.netty.util.a.l.f()) {
            return c.O();
        }
        return b.O();
    }

    /* compiled from: ByteBufUtil.java */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final char[] f4385a = new char[256];

        /* renamed from: b, reason: collision with root package name */
        private static final char[] f4386b = new char[1024];
        private static final String[] c = new String[16];
        private static final String[] d = new String[4096];
        private static final String[] e = new String[256];
        private static final String[] f = new String[16];

        static {
            char[] charArray = "0123456789abcdef".toCharArray();
            for (int i = 0; i < 256; i++) {
                int i2 = i << 1;
                f4386b[i2] = charArray[(i >>> 4) & 15];
                f4386b[i2 + 1] = charArray[i & 15];
            }
            for (int i3 = 0; i3 < c.length; i3++) {
                int length = c.length - i3;
                StringBuilder sb = new StringBuilder(length * 3);
                for (int i4 = 0; i4 < length; i4++) {
                    sb.append("   ");
                }
                c[i3] = sb.toString();
            }
            for (int i5 = 0; i5 < d.length; i5++) {
                StringBuilder sb2 = new StringBuilder(12);
                sb2.append(io.netty.util.a.p.f4696a);
                sb2.append(Long.toHexString(((i5 << 4) & 4294967295L) | 4294967296L));
                sb2.setCharAt(sb2.length() - 9, '|');
                sb2.append('|');
                d[i5] = sb2.toString();
            }
            for (int i6 = 0; i6 < e.length; i6++) {
                e[i6] = ' ' + io.netty.util.a.p.a(i6);
            }
            for (int i7 = 0; i7 < f.length; i7++) {
                int length2 = f.length - i7;
                StringBuilder sb3 = new StringBuilder(length2);
                for (int i8 = 0; i8 < length2; i8++) {
                    sb3.append(' ');
                }
                f[i7] = sb3.toString();
            }
            for (int i9 = 0; i9 < f4385a.length; i9++) {
                if (i9 <= 31 || i9 >= 127) {
                    f4385a[i9] = '.';
                } else {
                    f4385a[i9] = (char) i9;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String b(byte[] bArr, int i, int i2) {
            if (i2 < 0) {
                throw new IllegalArgumentException("length: " + i2);
            }
            if (i2 == 0) {
                return BuildConfig.FLAVOR;
            }
            int i3 = i + i2;
            char[] cArr = new char[i2 << 1];
            int i4 = 0;
            while (i < i3) {
                System.arraycopy(f4386b, (bArr[i] & Constants.DimensionIds.NETHER) << 1, cArr, i4, 2);
                i++;
                i4 += 2;
            }
            return new String(cArr);
        }
    }

    /* compiled from: ByteBufUtil.java */
    static final class c extends ak {
        private static final io.netty.util.l<c> f = new io.netty.util.l<c>() { // from class: io.netty.b.l.c.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c b(l.b<c> bVar) {
                return new c(bVar);
            }
        };
        private final l.b<c> g;

        static c O() {
            c cVarA = f.a();
            cVarA.B(1);
            return cVarA;
        }

        private c(l.b<c> bVar) {
            super(ag.f4374b, 256, Integer.MAX_VALUE);
            this.g = bVar;
        }

        @Override // io.netty.b.ak, io.netty.b.d
        protected void E() {
            if (Q() > l.e) {
                super.E();
            } else {
                d();
                this.g.a(this);
            }
        }
    }

    /* compiled from: ByteBufUtil.java */
    static final class b extends ah {
        private static final io.netty.util.l<b> d = new io.netty.util.l<b>() { // from class: io.netty.b.l.b.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b b(l.b<b> bVar) {
                return new b(bVar);
            }
        };
        private final l.b<b> e;

        static b O() {
            b bVarA = d.a();
            bVarA.B(1);
            return bVarA;
        }

        private b(l.b<b> bVar) {
            super(ag.f4374b, 256, Integer.MAX_VALUE);
            this.e = bVar;
        }

        @Override // io.netty.b.ah, io.netty.b.d
        protected void E() {
            if (Q() > l.e) {
                super.E();
            } else {
                d();
                this.e.a(this);
            }
        }
    }

    private l() {
    }
}
