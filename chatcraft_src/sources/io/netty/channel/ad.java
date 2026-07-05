package io.netty.channel;

import java.lang.reflect.InvocationTargetException;
import java.net.SocketException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: DefaultChannelId.java */
/* loaded from: classes.dex */
public final class ad implements m {
    private static final byte[] d;
    private static final int e;
    private final byte[] g = new byte[28];
    private int h;
    private transient String i;

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f4452a = !ad.class.desiredAssertionStatus();

    /* renamed from: b, reason: collision with root package name */
    private static final io.netty.util.a.b.c f4453b = io.netty.util.a.b.d.a((Class<?>) ad.class);
    private static final Pattern c = Pattern.compile("^(?:[0-9a-fA-F][:-]?){6,8}$");
    private static final AtomicInteger f = new AtomicInteger();

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(m mVar) {
        return 0;
    }

    static {
        int i;
        String strB = io.netty.util.a.q.b("io.netty.processId");
        int iD = -1;
        if (strB != null) {
            try {
                i = Integer.parseInt(strB);
            } catch (NumberFormatException unused) {
                i = -1;
            }
            if (i < 0 || i > 4194304) {
                f4453b.c("-Dio.netty.processId: {} (malformed)", strB);
            } else {
                if (f4453b.b()) {
                    f4453b.b("-Dio.netty.processId: {} (user-set)", Integer.valueOf(i));
                }
                iD = i;
            }
        }
        if (iD < 0) {
            iD = d();
            if (f4453b.b()) {
                f4453b.b("-Dio.netty.processId: {} (auto-detected)", Integer.valueOf(iD));
            }
        }
        e = iD;
        byte[] bArrC = null;
        String strB2 = io.netty.util.a.q.b("io.netty.machineId");
        if (strB2 != null) {
            if (c.matcher(strB2).matches()) {
                bArrC = a(strB2);
                f4453b.b("-Dio.netty.machineId: {} (user-set)", strB2);
            } else {
                f4453b.c("-Dio.netty.machineId: {} (malformed)", strB2);
            }
        }
        if (bArrC == null) {
            bArrC = c();
            if (f4453b.b()) {
                f4453b.b("-Dio.netty.machineId: {} (auto-detected)", io.netty.util.a.g.a(bArrC));
            }
        }
        d = bArrC;
    }

    public static ad b() {
        ad adVar = new ad();
        adVar.e();
        return adVar;
    }

    private static byte[] a(String str) {
        String strReplaceAll = str.replaceAll("[:-]", BuildConfig.FLAVOR);
        byte[] bArr = new byte[8];
        int i = 0;
        while (i < strReplaceAll.length()) {
            int i2 = i + 2;
            bArr[i] = (byte) Integer.parseInt(strReplaceAll.substring(i, i2), 16);
            i = i2;
        }
        return bArr;
    }

    private static byte[] c() throws SocketException {
        byte[] bArrA = io.netty.util.a.g.a();
        if (bArrA != null) {
            return bArrA;
        }
        byte[] bArr = new byte[8];
        io.netty.util.a.r.b().nextBytes(bArr);
        f4453b.c("Failed to find a usable hardware address from the network interfaces; using random bytes: {}", io.netty.util.a.g.a(bArr));
        return bArr;
    }

    private static int d() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        String string;
        int i;
        ClassLoader classLoaderA = io.netty.util.a.l.a((Class<?>) ad.class);
        try {
            Class<?> cls = Class.forName("java.lang.management.ManagementFactory", true, classLoaderA);
            Class<?> cls2 = Class.forName("java.lang.management.RuntimeMXBean", true, classLoaderA);
            string = (String) cls2.getMethod("getName", io.netty.util.a.b.d).invoke(cls.getMethod("getRuntimeMXBean", io.netty.util.a.b.d).invoke(null, io.netty.util.a.b.c), io.netty.util.a.b.c);
        } catch (Exception e2) {
            f4453b.a("Could not invoke ManagementFactory.getRuntimeMXBean().getName(); Android?", (Throwable) e2);
            try {
                string = Class.forName("android.os.Process", true, classLoaderA).getMethod("myPid", io.netty.util.a.b.d).invoke(null, io.netty.util.a.b.c).toString();
            } catch (Exception e3) {
                f4453b.a("Could not invoke Process.myPid(); not Android?", (Throwable) e3);
                string = BuildConfig.FLAVOR;
            }
        }
        int iIndexOf = string.indexOf(64);
        if (iIndexOf >= 0) {
            string = string.substring(0, iIndexOf);
        }
        try {
            i = Integer.parseInt(string);
        } catch (NumberFormatException unused) {
            i = -1;
        }
        if (i >= 0 && i <= 4194304) {
            return i;
        }
        int iNextInt = io.netty.util.a.r.b().nextInt(4194305);
        f4453b.c("Failed to find the current process ID from '{}'; using a random value: {}", string, Integer.valueOf(iNextInt));
        return iNextInt;
    }

    private ad() {
    }

    private void e() {
        System.arraycopy(d, 0, this.g, 0, 8);
        int iA = a(a(a(8, e), f.getAndIncrement()), Long.reverse(System.nanoTime()) ^ System.currentTimeMillis());
        int iNextInt = io.netty.util.a.r.b().nextInt();
        this.h = iNextInt;
        int iA2 = a(iA, iNextInt);
        if (!f4452a && iA2 != this.g.length) {
            throw new AssertionError();
        }
    }

    private int a(int i, int i2) {
        int i3 = i + 1;
        this.g[i] = (byte) (i2 >>> 24);
        int i4 = i3 + 1;
        this.g[i3] = (byte) (i2 >>> 16);
        int i5 = i4 + 1;
        this.g[i4] = (byte) (i2 >>> 8);
        int i6 = i5 + 1;
        this.g[i5] = (byte) i2;
        return i6;
    }

    private int a(int i, long j) {
        int i2 = i + 1;
        this.g[i] = (byte) (j >>> 56);
        int i3 = i2 + 1;
        this.g[i2] = (byte) (j >>> 48);
        int i4 = i3 + 1;
        this.g[i3] = (byte) (j >>> 40);
        int i5 = i4 + 1;
        this.g[i4] = (byte) (j >>> 32);
        int i6 = i5 + 1;
        this.g[i5] = (byte) (j >>> 24);
        int i7 = i6 + 1;
        this.g[i6] = (byte) (j >>> 16);
        int i8 = i7 + 1;
        this.g[i7] = (byte) (j >>> 8);
        int i9 = i8 + 1;
        this.g[i8] = (byte) j;
        return i9;
    }

    @Override // io.netty.channel.m
    public String a() {
        String str = this.i;
        if (str != null) {
            return str;
        }
        String strA = io.netty.b.l.a(this.g, 24, 4);
        this.i = strA;
        return strA;
    }

    public int hashCode() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ad) {
            return Arrays.equals(this.g, ((ad) obj).g);
        }
        return false;
    }

    public String toString() {
        return a();
    }
}
