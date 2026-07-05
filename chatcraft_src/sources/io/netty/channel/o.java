package io.netty.channel;

/* compiled from: ChannelInboundHandlerAdapter.java */
/* loaded from: classes.dex */
public class o extends k implements n {
    @Override // io.netty.channel.n
    public void channelRegistered(l lVar) {
        lVar.f();
    }

    @Override // io.netty.channel.n
    public void channelUnregistered(l lVar) {
        lVar.g();
    }

    public void channelActive(l lVar) {
        lVar.h();
    }

    public void channelInactive(l lVar) {
        lVar.i();
    }

    public void channelRead(l lVar, Object obj) {
        lVar.c(obj);
    }

    @Override // io.netty.channel.n
    public void channelReadComplete(l lVar) {
        lVar.k();
    }

    @Override // io.netty.channel.n
    public void userEventTriggered(l lVar, Object obj) {
        lVar.b(obj);
    }

    @Override // io.netty.channel.n
    public void channelWritabilityChanged(l lVar) {
        lVar.l();
    }

    @Override // io.netty.channel.k, io.netty.channel.j
    public void exceptionCaught(l lVar, Throwable th) {
        lVar.a(th);
    }
}
