package io.netty.channel.a;

import io.netty.b.i;
import io.netty.channel.a.b;
import io.netty.channel.an;
import io.netty.channel.ar;
import io.netty.channel.h;
import io.netty.channel.q;
import io.netty.channel.r;
import io.netty.channel.s;
import io.netty.channel.w;
import io.netty.util.a.p;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

/* compiled from: AbstractNioByteChannel.java */
/* loaded from: classes.dex */
public abstract class a extends b {
    private static final q e = new q(false, 16);
    private static final String f = " (expected: " + p.a((Class<?>) i.class) + ", " + p.a((Class<?>) an.class) + ')';
    private Runnable g;

    protected abstract h H();

    protected abstract int a(i iVar);

    protected abstract long a(an anVar);

    protected abstract int b(i iVar);

    protected a(io.netty.channel.d dVar, SelectableChannel selectableChannel) {
        super(dVar, selectableChannel, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.a
    /* renamed from: I */
    public b.a o() {
        return new C0101a();
    }

    @Override // io.netty.channel.d
    public q G() {
        return e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AbstractNioByteChannel.java */
    /* renamed from: io.netty.channel.a.a$a, reason: collision with other inner class name */
    public class C0101a extends b.a {
        protected C0101a() {
            super();
        }

        private void a(w wVar) {
            if (a.this.E()) {
                if (Boolean.TRUE.equals(a.this.D().a(r.j))) {
                    a.this.H();
                    SelectionKey selectionKeyO = a.this.O();
                    selectionKeyO.interestOps(selectionKeyO.interestOps() & (a.this.f4434a ^ (-1)));
                    wVar.b(io.netty.channel.c.a.f4539a);
                    return;
                }
                b(i());
            }
        }

        private void a(w wVar, i iVar, Throwable th, boolean z, ar.a aVar) {
            if (iVar != null) {
                if (iVar.e()) {
                    a.this.c = false;
                    wVar.c(iVar);
                } else {
                    iVar.D();
                }
            }
            aVar.b();
            wVar.c();
            wVar.a(th);
            if (z || (th instanceof IOException)) {
                a(wVar);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0036, code lost:
        
            r2 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0048, code lost:
        
            r7.b();
            r3.c();
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x004e, code lost:
        
            if (r2 == false) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
        
            a(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
        
            if (r9.c.c != false) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x005d, code lost:
        
            if (r0.e() != false) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
        
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
        
            r5 = r1;
            r6 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x006f, code lost:
        
            a(r3, r4, r5, r6, r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0081, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x002d, code lost:
        
            r5.D();
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0034, code lost:
        
            if (r7.c() >= 0) goto L46;
         */
        @Override // io.netty.channel.a.b.InterfaceC0102b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void l() {
            /*
                r9 = this;
                io.netty.channel.a.a r0 = io.netty.channel.a.a.this
                io.netty.channel.e r0 = r0.D()
                io.netty.channel.a.a r1 = io.netty.channel.a.a.this
                io.netty.channel.w r3 = r1.d()
                io.netty.b.j r1 = r0.c()
                io.netty.channel.ar$a r7 = r9.a()
                r7.a(r0)
            L17:
                r2 = 0
                r4 = 0
                io.netty.b.i r5 = r7.a(r1)     // Catch: java.lang.Throwable -> L69 java.lang.Throwable -> L6b
                io.netty.channel.a.a r6 = io.netty.channel.a.a.this     // Catch: java.lang.Throwable -> L64 java.lang.Throwable -> L69
                int r6 = r6.a(r5)     // Catch: java.lang.Throwable -> L64 java.lang.Throwable -> L69
                r7.b(r6)     // Catch: java.lang.Throwable -> L64 java.lang.Throwable -> L69
                int r6 = r7.c()     // Catch: java.lang.Throwable -> L64 java.lang.Throwable -> L69
                r8 = 1
                if (r6 > 0) goto L38
                r5.D()     // Catch: java.lang.Throwable -> L64 java.lang.Throwable -> L69
                int r1 = r7.c()     // Catch: java.lang.Throwable -> L69 java.lang.Throwable -> L6b
                if (r1 >= 0) goto L48
                r2 = 1
                goto L48
            L38:
                r7.a(r8)     // Catch: java.lang.Throwable -> L64 java.lang.Throwable -> L69
                io.netty.channel.a.a r6 = io.netty.channel.a.a.this     // Catch: java.lang.Throwable -> L64 java.lang.Throwable -> L69
                r6.c = r2     // Catch: java.lang.Throwable -> L64 java.lang.Throwable -> L69
                r3.c(r5)     // Catch: java.lang.Throwable -> L64 java.lang.Throwable -> L69
                boolean r5 = r7.d()     // Catch: java.lang.Throwable -> L69 java.lang.Throwable -> L6b
                if (r5 != 0) goto L17
            L48:
                r7.b()     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L69
                r3.c()     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L69
                if (r2 == 0) goto L53
                r9.a(r3)     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L69
            L53:
                io.netty.channel.a.a r1 = io.netty.channel.a.a.this
                boolean r1 = r1.c
                if (r1 != 0) goto L81
                boolean r0 = r0.e()
                if (r0 != 0) goto L81
                goto L7e
            L60:
                r1 = move-exception
                r5 = r1
                r6 = r2
                goto L6e
            L64:
                r1 = move-exception
                r4 = r5
                r6 = 0
                r5 = r1
                goto L6e
            L69:
                r1 = move-exception
                goto L82
            L6b:
                r1 = move-exception
                r5 = r1
                r6 = 0
            L6e:
                r2 = r9
                r2.a(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L69
                io.netty.channel.a.a r1 = io.netty.channel.a.a.this
                boolean r1 = r1.c
                if (r1 != 0) goto L81
                boolean r0 = r0.e()
                if (r0 != 0) goto L81
            L7e:
                r9.m()
            L81:
                return
            L82:
                io.netty.channel.a.a r2 = io.netty.channel.a.a.this
                boolean r2 = r2.c
                if (r2 != 0) goto L91
                boolean r0 = r0.e()
                if (r0 != 0) goto L91
                r9.m()
            L91:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.a.a.C0101a.l():void");
        }
    }

    @Override // io.netty.channel.a
    protected void a(s sVar) {
        int iB = -1;
        boolean z = false;
        while (true) {
            Object objB = sVar.b();
            if (objB == null) {
                K();
                return;
            }
            long j = 0;
            boolean z2 = true;
            if (objB instanceof i) {
                i iVar = (i) objB;
                if (iVar.g() == 0) {
                    sVar.c();
                } else {
                    if (iB == -1) {
                        iB = D().b();
                    }
                    int i = iB - 1;
                    while (true) {
                        if (i < 0) {
                            break;
                        }
                        int iB2 = b(iVar);
                        if (iB2 == 0) {
                            z = true;
                            break;
                        }
                        j += iB2;
                        if (!iVar.e()) {
                            break;
                        } else {
                            i--;
                        }
                    }
                    z2 = false;
                    sVar.c(j);
                    if (!z2) {
                        break;
                    } else {
                        sVar.c();
                    }
                }
            } else if (objB instanceof an) {
                an anVar = (an) objB;
                boolean z3 = anVar.a() >= anVar.b();
                if (!z3) {
                    if (iB == -1) {
                        iB = D().b();
                    }
                    int i2 = iB - 1;
                    long j2 = 0;
                    while (true) {
                        if (i2 < 0) {
                            break;
                        }
                        long jA = a(anVar);
                        if (jA == 0) {
                            z = true;
                            break;
                        }
                        j2 += jA;
                        if (anVar.a() >= anVar.b()) {
                            z3 = true;
                            break;
                        }
                        i2--;
                    }
                    sVar.c(j2);
                }
                if (!z3) {
                    break;
                } else {
                    sVar.c();
                }
            } else {
                throw new Error();
            }
        }
        a(z);
    }

    @Override // io.netty.channel.a
    protected final Object b(Object obj) {
        if (obj instanceof i) {
            i iVar = (i) obj;
            return iVar.H() ? obj : c(iVar);
        }
        if (obj instanceof an) {
            return obj;
        }
        throw new UnsupportedOperationException("unsupported message type: " + p.a(obj) + f);
    }

    protected final void a(boolean z) {
        if (z) {
            J();
            return;
        }
        Runnable runnable = this.g;
        if (runnable == null) {
            runnable = new Runnable() { // from class: io.netty.channel.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.k();
                }
            };
            this.g = runnable;
        }
        f().execute(runnable);
    }

    protected final void J() {
        SelectionKey selectionKeyO = O();
        if (selectionKeyO.isValid()) {
            int iInterestOps = selectionKeyO.interestOps();
            if ((iInterestOps & 4) == 0) {
                selectionKeyO.interestOps(iInterestOps | 4);
            }
        }
    }

    protected final void K() {
        SelectionKey selectionKeyO = O();
        if (selectionKeyO.isValid()) {
            int iInterestOps = selectionKeyO.interestOps();
            if ((iInterestOps & 4) != 0) {
                selectionKeyO.interestOps(iInterestOps & (-5));
            }
        }
    }
}
