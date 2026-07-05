package io.netty.util.a.c.a.a.a;

/* compiled from: MpscArrayQueue.java */
/* loaded from: classes.dex */
abstract class j<E> extends g<E> {
    private static final long c;
    private volatile long d;

    static {
        try {
            c = io.netty.util.a.c.a.a.b.c.f4677b.objectFieldOffset(j.class.getDeclaredField("d"));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public j(int i) {
        super(i);
    }

    protected final long d() {
        return this.d;
    }

    protected final boolean b(long j, long j2) {
        return io.netty.util.a.c.a.a.b.c.f4677b.compareAndSwapLong(this, c, j, j2);
    }
}
