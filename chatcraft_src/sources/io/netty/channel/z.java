package io.netty.channel;

/* compiled from: ChannelPromise.java */
/* loaded from: classes.dex */
public interface z extends h, io.netty.util.concurrent.y<Void> {
    z a(Throwable th);

    @Override // io.netty.util.concurrent.p
    io.netty.util.concurrent.p<Void> b(io.netty.util.concurrent.r<? extends io.netty.util.concurrent.p<? super Void>> rVar);

    boolean c();

    @Override // io.netty.channel.h
    d e();

    z v_();

    z y_();
}
