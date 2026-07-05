package io.netty.handler.timeout;

import io.netty.channel.ChannelException;

/* loaded from: classes.dex */
public class TimeoutException extends ChannelException {
    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    TimeoutException() {
    }
}
