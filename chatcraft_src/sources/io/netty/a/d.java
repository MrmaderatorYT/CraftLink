package io.netty.a;

import java.net.SocketAddress;

/* compiled from: BootstrapConfig.java */
/* loaded from: classes.dex */
public final class d extends b<c, io.netty.channel.d> {
    d(c cVar) {
        super(cVar);
    }

    public SocketAddress g() {
        return ((c) this.f4348a).r();
    }

    public io.netty.resolver.c<?> h() {
        return ((c) this.f4348a).s();
    }

    @Override // io.netty.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.setLength(sb.length() - 1);
        sb.append(", resolver: ");
        sb.append(h());
        SocketAddress socketAddressG = g();
        if (socketAddressG != null) {
            sb.append(", remoteAddress: ");
            sb.append(socketAddressG);
        }
        sb.append(')');
        return sb.toString();
    }
}
