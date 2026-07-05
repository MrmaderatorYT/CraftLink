package io.netty.channel;

import io.netty.channel.j;
import java.util.Map;

/* compiled from: ChannelHandlerAdapter.java */
/* loaded from: classes.dex */
public abstract class k implements j {
    boolean added;

    @Override // io.netty.channel.j
    public void handlerAdded(l lVar) {
    }

    @Override // io.netty.channel.j
    public void handlerRemoved(l lVar) {
    }

    public boolean isSharable() {
        Class<?> cls = getClass();
        Map<Class<?>, Boolean> mapK = io.netty.util.a.d.b().k();
        Boolean boolValueOf = mapK.get(cls);
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(cls.isAnnotationPresent(j.a.class));
            mapK.put(cls, boolValueOf);
        }
        return boolValueOf.booleanValue();
    }

    @Override // io.netty.channel.j
    public void exceptionCaught(l lVar, Throwable th) {
        lVar.a(th);
    }
}
