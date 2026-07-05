package io.netty.util;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;

/* compiled from: NetUtil.java */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final Inet4Address f4769a;

    /* renamed from: b, reason: collision with root package name */
    public static final Inet6Address f4770b;
    public static final InetAddress c;
    public static final NetworkInterface d;
    public static final int e;
    private static final boolean f = Boolean.getBoolean("java.net.preferIPv4Stack");
    private static final boolean g = Boolean.getBoolean("java.net.preferIPv6Addresses");
    private static final io.netty.util.a.b.c h = io.netty.util.a.b.d.a((Class<?>) k.class);

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00dc, code lost:
    
        r7 = r5.nextElement();
        r2 = r4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0117  */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Object, java.net.Inet6Address] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.net.InetAddress] */
    /* JADX WARN: Type inference failed for: r3v10, types: [io.netty.util.a.b.c] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.net.InetAddress] */
    static {
        /*
            Method dump skipped, instructions count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.k.<clinit>():void");
    }

    private k() {
    }
}
