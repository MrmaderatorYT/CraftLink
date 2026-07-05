package io.netty.util.a.c.a.a.a;

/* compiled from: MpscArrayQueue.java */
/* loaded from: classes.dex */
abstract class f<E> extends i<E> {
    private static final long c;
    private volatile long d;

    static {
        try {
            c = io.netty.util.a.c.a.a.b.c.f4677b.objectFieldOffset(f.class.getDeclaredField("d"));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public f(int i) {
        super(i);
        this.d = i;
    }

    protected final long c() {
        return this.d;
    }

    protected final void c(long j) {
        io.netty.util.a.c.a.a.b.c.f4677b.putOrderedLong(this, c, j);
    }
}
