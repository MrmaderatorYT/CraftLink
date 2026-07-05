package io.netty.util.a.c.a.a.b;

/* compiled from: UnsafeRefArrayAccess.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final long f4678a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f4679b;

    static {
        int iArrayIndexScale = c.f4677b.arrayIndexScale(Object[].class);
        if (4 == iArrayIndexScale) {
            f4679b = 2;
        } else if (8 == iArrayIndexScale) {
            f4679b = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        f4678a = c.f4677b.arrayBaseOffset(Object[].class);
    }

    public static <E> void a(E[] eArr, long j, E e) {
        c.f4677b.putObject(eArr, j, e);
    }

    public static <E> void b(E[] eArr, long j, E e) {
        c.f4677b.putOrderedObject(eArr, j, e);
    }

    public static <E> E a(E[] eArr, long j) {
        return (E) c.f4677b.getObjectVolatile(eArr, j);
    }
}
