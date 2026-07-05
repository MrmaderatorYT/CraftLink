package io.netty.channel;

import java.net.SocketAddress;

/* compiled from: ChannelDuplexHandler.java */
/* loaded from: classes.dex */
public class f extends o implements t {
    @Override // io.netty.channel.t
    public void bind(l lVar, SocketAddress socketAddress, z zVar) {
        lVar.a(socketAddress, zVar);
    }

    @Override // io.netty.channel.t
    public void connect(l lVar, SocketAddress socketAddress, SocketAddress socketAddress2, z zVar) {
        lVar.a(socketAddress, socketAddress2, zVar);
    }

    @Override // io.netty.channel.t
    public void disconnect(l lVar, z zVar) {
        lVar.a(zVar);
    }

    @Override // io.netty.channel.t
    public void close(l lVar, z zVar) {
        lVar.b(zVar);
    }

    @Override // io.netty.channel.t
    public void deregister(l lVar, z zVar) {
        lVar.c(zVar);
    }

    @Override // io.netty.channel.t
    public void read(l lVar) {
        lVar.n();
    }

    @Override // io.netty.channel.t
    public void write(l lVar, Object obj, z zVar) {
        lVar.a(obj, zVar);
    }

    @Override // io.netty.channel.t
    public void flush(l lVar) {
        lVar.o();
    }
}
