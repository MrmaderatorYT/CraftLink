package io.netty.channel;

import java.net.SocketAddress;

/* compiled from: ChannelOutboundHandler.java */
/* loaded from: classes.dex */
public interface t extends j {
    void bind(l lVar, SocketAddress socketAddress, z zVar);

    void close(l lVar, z zVar);

    void connect(l lVar, SocketAddress socketAddress, SocketAddress socketAddress2, z zVar);

    void deregister(l lVar, z zVar);

    void disconnect(l lVar, z zVar);

    void flush(l lVar);

    void read(l lVar);

    void write(l lVar, Object obj, z zVar);
}
