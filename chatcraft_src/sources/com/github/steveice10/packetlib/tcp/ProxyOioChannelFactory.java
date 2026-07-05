package com.github.steveice10.packetlib.tcp;

import io.netty.channel.c.b.b;
import io.netty.channel.g;
import java.net.Proxy;
import java.net.Socket;

/* loaded from: classes.dex */
public class ProxyOioChannelFactory implements g<b> {
    private Proxy proxy;

    public ProxyOioChannelFactory(Proxy proxy) {
        this.proxy = proxy;
    }

    @Override // io.netty.a.e
    public b newChannel() {
        return new b(new Socket(this.proxy));
    }
}
