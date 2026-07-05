package io.netty.channel;

import io.netty.channel.d;
import io.netty.channel.j;
import java.util.concurrent.ConcurrentMap;

/* compiled from: ChannelInitializer.java */
@j.a
/* loaded from: classes.dex */
public abstract class p<C extends d> extends o {
    private static final io.netty.util.a.b.c logger = io.netty.util.a.b.d.a((Class<?>) p.class);
    private final ConcurrentMap<l, Boolean> initMap = io.netty.util.a.l.k();

    protected abstract void initChannel(C c);

    @Override // io.netty.channel.o, io.netty.channel.n
    public final void channelRegistered(l lVar) {
        if (initChannel(lVar)) {
            lVar.b().a();
        } else {
            lVar.f();
        }
    }

    @Override // io.netty.channel.o, io.netty.channel.k, io.netty.channel.j
    public void exceptionCaught(l lVar, Throwable th) {
        logger.b("Failed to initialize a channel. Closing: " + lVar.a(), th);
        lVar.j();
    }

    @Override // io.netty.channel.k, io.netty.channel.j
    public void handlerAdded(l lVar) {
        if (lVar.a().i()) {
            initChannel(lVar);
        }
    }

    private boolean initChannel(l lVar) {
        try {
            if (this.initMap.putIfAbsent(lVar, Boolean.TRUE) != null) {
                return false;
            }
            try {
                initChannel((p<C>) lVar.a());
            } catch (Throwable th) {
                exceptionCaught(lVar, th);
            }
            return true;
        } finally {
            remove(lVar);
        }
    }

    private void remove(l lVar) {
        try {
            w wVarB = lVar.b();
            if (wVarB.b((j) this) != null) {
                wVarB.a((j) this);
            }
        } finally {
            this.initMap.remove(lVar);
        }
    }
}
