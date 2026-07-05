package io.netty.util.a.c.a.a.a;

/* compiled from: MpscArrayQueue.java */
/* loaded from: classes.dex */
abstract class e<E> extends h<E> {
    private static final long d;
    protected long c;

    static {
        try {
            d = io.netty.util.a.c.a.a.b.c.f4677b.objectFieldOffset(e.class.getDeclaredField("c"));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public e(int i) {
        super(i);
    }

    protected final long a() {
        return this.c;
    }

    protected final long b() {
        return io.netty.util.a.c.a.a.b.c.f4677b.getLongVolatile(this, d);
    }

    protected void b(long j) {
        io.netty.util.a.c.a.a.b.c.f4677b.putOrderedLong(this, d, j);
    }
}
