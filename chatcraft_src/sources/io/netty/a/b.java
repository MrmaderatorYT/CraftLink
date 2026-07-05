package io.netty.a;

import io.netty.a.a;
import io.netty.channel.al;
import io.netty.channel.d;
import io.netty.channel.r;
import io.netty.util.a.j;
import io.netty.util.a.p;
import java.net.SocketAddress;
import java.util.Map;

/* compiled from: AbstractBootstrapConfig.java */
/* loaded from: classes.dex */
public abstract class b<B extends a<B, C>, C extends io.netty.channel.d> {

    /* renamed from: a, reason: collision with root package name */
    protected final B f4348a;

    protected b(B b2) {
        this.f4348a = (B) j.a(b2, "bootstrap");
    }

    public final SocketAddress a() {
        return this.f4348a.i();
    }

    public final e<? extends C> b() {
        return this.f4348a.j();
    }

    public final io.netty.channel.j c() {
        return this.f4348a.k();
    }

    public final Map<r<?>, Object> d() {
        return this.f4348a.l();
    }

    public final Map<io.netty.util.c<?>, Object> e() {
        return this.f4348a.m();
    }

    public final al f() {
        return this.f4348a.e();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(p.a(this));
        sb.append('(');
        al alVarF = f();
        if (alVarF != null) {
            sb.append("group: ");
            sb.append(p.a(alVarF));
            sb.append(", ");
        }
        e<? extends C> eVarB = b();
        if (eVarB != null) {
            sb.append("channelFactory: ");
            sb.append(eVarB);
            sb.append(", ");
        }
        SocketAddress socketAddressA = a();
        if (socketAddressA != null) {
            sb.append("localAddress: ");
            sb.append(socketAddressA);
            sb.append(", ");
        }
        Map<r<?>, Object> mapD = d();
        if (!mapD.isEmpty()) {
            sb.append("options: ");
            sb.append(mapD);
            sb.append(", ");
        }
        Map<io.netty.util.c<?>, Object> mapE = e();
        if (!mapE.isEmpty()) {
            sb.append("attrs: ");
            sb.append(mapE);
            sb.append(", ");
        }
        io.netty.channel.j jVarC = c();
        if (jVarC != null) {
            sb.append("handler: ");
            sb.append(jVarC);
            sb.append(", ");
        }
        if (sb.charAt(sb.length() - 1) == '(') {
            sb.append(')');
        } else {
            sb.setCharAt(sb.length() - 2, ')');
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
