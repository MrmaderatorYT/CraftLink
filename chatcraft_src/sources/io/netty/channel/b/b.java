package io.netty.channel.b;

import io.netty.channel.a;
import io.netty.channel.ak;
import io.netty.channel.az;
import io.netty.channel.z;
import java.net.SocketAddress;

/* compiled from: AbstractOioChannel.java */
/* loaded from: classes.dex */
public abstract class b extends io.netty.channel.a {

    /* renamed from: a, reason: collision with root package name */
    boolean f4521a;

    /* renamed from: b, reason: collision with root package name */
    private final Runnable f4522b;
    private final Runnable c;

    protected abstract void J();

    protected abstract void a(SocketAddress socketAddress, SocketAddress socketAddress2);

    protected b(io.netty.channel.d dVar) {
        super(dVar);
        this.f4522b = new Runnable() { // from class: io.netty.channel.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.J();
            }
        };
        this.c = new Runnable() { // from class: io.netty.channel.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4521a = false;
            }
        };
    }

    @Override // io.netty.channel.a
    protected a.AbstractC0100a o() {
        return new a();
    }

    /* compiled from: AbstractOioChannel.java */
    private final class a extends a.AbstractC0100a {
        private a() {
            super();
        }

        @Override // io.netty.channel.d.a
        public void a(SocketAddress socketAddress, SocketAddress socketAddress2, z zVar) {
            if (zVar.z_() && d(zVar)) {
                try {
                    boolean zF = b.this.F();
                    b.this.a(socketAddress, socketAddress2);
                    boolean zF2 = b.this.F();
                    e(zVar);
                    if (zF || !zF2) {
                        return;
                    }
                    b.this.d().b();
                } catch (Throwable th) {
                    a(zVar, a(th, socketAddress));
                    j();
                }
            }
        }
    }

    @Override // io.netty.channel.a
    protected boolean a(ak akVar) {
        return akVar instanceof az;
    }

    @Override // io.netty.channel.a
    protected void w() {
        if (this.f4521a) {
            return;
        }
        this.f4521a = true;
        f().execute(this.f4522b);
    }

    protected final void L() {
        if (i()) {
            ak akVarF = f();
            if (akVarF.k()) {
                this.f4521a = false;
                return;
            } else {
                akVarF.execute(this.c);
                return;
            }
        }
        this.f4521a = false;
    }
}
