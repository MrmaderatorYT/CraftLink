package io.netty.util.a.c.a.a.a;

/* compiled from: SparsePaddedCircularArrayOffsetCalculator.java */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    static final int f4672a = Integer.getInteger("io.netty.util.internal.shaded.org.jctools.sparse.shift", 0).intValue();
    private static final int c = io.netty.util.a.c.a.a.b.d.f4679b + f4672a;

    /* renamed from: b, reason: collision with root package name */
    private static final long f4673b = r.f4671b;

    public static <E> E[] a(int i) {
        return (E[]) new Object[(i << f4672a) + (r.f4670a * 2)];
    }

    public static long a(long j, long j2) {
        return f4673b + ((j & j2) << c);
    }
}
