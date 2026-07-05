package io.netty.channel;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: ChannelHandler.java */
/* loaded from: classes.dex */
public interface j {

    /* compiled from: ChannelHandler.java */
    @Target({ElementType.TYPE})
    @Inherited
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
    }

    @Deprecated
    void exceptionCaught(l lVar, Throwable th);

    void handlerAdded(l lVar);

    void handlerRemoved(l lVar);
}
