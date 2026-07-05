package io.netty.channel;

/* compiled from: ChannelInboundHandler.java */
/* loaded from: classes.dex */
public interface n extends j {
    void channelActive(l lVar);

    void channelInactive(l lVar);

    void channelRead(l lVar, Object obj);

    void channelReadComplete(l lVar);

    void channelRegistered(l lVar);

    void channelUnregistered(l lVar);

    void channelWritabilityChanged(l lVar);

    void userEventTriggered(l lVar, Object obj);
}
