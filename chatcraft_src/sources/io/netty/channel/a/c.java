package io.netty.channel.a;

import io.netty.channel.a.b;
import io.netty.channel.ar;
import io.netty.channel.av;
import io.netty.channel.s;
import io.netty.channel.w;
import java.io.IOException;
import java.net.PortUnreachableException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AbstractNioMessageChannel.java */
/* loaded from: classes.dex */
public abstract class c extends b {
    boolean e;

    protected boolean I() {
        return false;
    }

    protected abstract int a(List<Object> list);

    protected abstract boolean a(Object obj, s sVar);

    protected c(io.netty.channel.d dVar, SelectableChannel selectableChannel, int i) {
        super(dVar, selectableChannel, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.a
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public b.a o() {
        return new a();
    }

    @Override // io.netty.channel.a.b, io.netty.channel.a
    protected void w() {
        if (this.e) {
            return;
        }
        super.w();
    }

    /* compiled from: AbstractNioMessageChannel.java */
    private final class a extends b.a {
        static final /* synthetic */ boolean c = !c.class.desiredAssertionStatus();
        private final List<Object> g;

        private a() {
            super();
            this.g = new ArrayList();
        }

        @Override // io.netty.channel.a.b.InterfaceC0102b
        public void l() {
            boolean zA;
            boolean z;
            if (!c && !c.this.f().k()) {
                throw new AssertionError();
            }
            io.netty.channel.e eVarD = c.this.D();
            w wVarD = c.this.d();
            ar.a aVarA = c.this.n().a();
            aVarA.a(eVarD);
            Throwable th = null;
            do {
                try {
                    try {
                        int iA = c.this.a(this.g);
                        if (iA == 0) {
                            break;
                        }
                        if (iA < 0) {
                            zA = true;
                            break;
                        }
                        aVarA.a(iA);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } finally {
                    if (!c.this.c && !eVarD.e()) {
                        m();
                    }
                }
            } while (aVarA.d());
            zA = false;
            int size = this.g.size();
            for (int i = 0; i < size; i++) {
                c.this.c = false;
                wVarD.c(this.g.get(i));
            }
            this.g.clear();
            aVarA.b();
            wVarD.c();
            if (th != null) {
                zA = c.this.a(th);
                wVarD.a(th);
            }
            if (zA) {
                c.this.e = true;
                if (c.this.E()) {
                    b(i());
                }
            }
            if (z) {
                return;
            }
        }
    }

    @Override // io.netty.channel.a
    protected void a(s sVar) throws IOException {
        SelectionKey selectionKeyO = O();
        int iInterestOps = selectionKeyO.interestOps();
        while (true) {
            Object objB = sVar.b();
            if (objB == null) {
                if ((iInterestOps & 4) != 0) {
                    selectionKeyO.interestOps(iInterestOps & (-5));
                    return;
                }
                return;
            }
            boolean z = false;
            try {
                int iB = D().b() - 1;
                while (true) {
                    if (iB < 0) {
                        break;
                    }
                    if (a(objB, sVar)) {
                        z = true;
                        break;
                    }
                    iB--;
                }
            } catch (IOException e) {
                if (I()) {
                    sVar.a((Throwable) e);
                } else {
                    throw e;
                }
            }
            if (!z) {
                if ((iInterestOps & 4) == 0) {
                    selectionKeyO.interestOps(iInterestOps | 4);
                    return;
                }
                return;
            }
            sVar.c();
        }
    }

    protected boolean a(Throwable th) {
        return (th instanceof IOException) && !(th instanceof PortUnreachableException) && (this instanceof av);
    }
}
