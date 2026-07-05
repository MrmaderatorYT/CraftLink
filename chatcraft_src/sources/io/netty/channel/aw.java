package io.netty.channel;

/* compiled from: SimpleChannelInboundHandler.java */
/* loaded from: classes.dex */
public abstract class aw<I> extends o {
    private final boolean autoRelease;
    private final io.netty.util.a.t matcher;

    protected abstract void channelRead0(l lVar, I i);

    protected aw() {
        this(true);
    }

    protected aw(boolean z) {
        this.matcher = io.netty.util.a.t.a(this, aw.class, "I");
        this.autoRelease = z;
    }

    protected aw(Class<? extends I> cls) {
        this(cls, true);
    }

    protected aw(Class<? extends I> cls, boolean z) {
        this.matcher = io.netty.util.a.t.a((Class<?>) cls);
        this.autoRelease = z;
    }

    public boolean acceptInboundMessage(Object obj) {
        return this.matcher.a(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.o, io.netty.channel.n
    public void channelRead(l lVar, Object obj) {
        boolean z = true;
        try {
            if (acceptInboundMessage(obj)) {
                channelRead0(lVar, obj);
            } else {
                z = false;
                lVar.c(obj);
            }
        } finally {
            if (this.autoRelease && 1 != 0) {
                io.netty.util.m.a(obj);
            }
        }
    }
}
