package io.netty.channel.b;

import io.netty.b.i;
import io.netty.channel.an;
import io.netty.channel.ar;
import io.netty.channel.h;
import io.netty.channel.q;
import io.netty.channel.r;
import io.netty.channel.s;
import io.netty.channel.w;
import io.netty.util.a.p;
import java.io.IOException;

/* compiled from: AbstractOioByteChannel.java */
/* loaded from: classes.dex */
public abstract class a extends b {

    /* renamed from: b, reason: collision with root package name */
    private static final q f4518b = new q(false);
    private static final String c = " (expected: " + p.a((Class<?>) i.class) + ", " + p.a((Class<?>) an.class) + ')';

    protected abstract boolean H();

    protected abstract h I();

    protected abstract int K();

    protected abstract int a(i iVar);

    protected abstract void a(an anVar);

    protected abstract void b(i iVar);

    protected a(io.netty.channel.d dVar) {
        super(dVar);
    }

    @Override // io.netty.channel.d
    public q G() {
        return f4518b;
    }

    private void a(w wVar) {
        if (E()) {
            if (Boolean.TRUE.equals(D().a(r.j))) {
                I();
                wVar.b(io.netty.channel.c.a.f4539a);
            } else {
                n().b(n().i());
            }
        }
    }

    private void a(w wVar, i iVar, Throwable th, boolean z, ar.a aVar) {
        if (iVar != null) {
            if (iVar.e()) {
                this.f4521a = false;
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

    /* JADX WARN: Code restructure failed: missing block: B:120:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003e, code lost:
    
        if (r6.e() != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
    
        r6.D();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
    
        if (r7.c() >= 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004a, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004b, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
    
        r2 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004e, code lost:
    
        r4 = null;
        r1 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00ea, code lost:
    
        r6 = false;
        r5 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x011b  */
    @Override // io.netty.channel.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void J() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.b.a.J():void");
    }

    @Override // io.netty.channel.a
    protected void a(s sVar) {
        while (true) {
            Object objB = sVar.b();
            if (objB == null) {
                return;
            }
            if (objB instanceof i) {
                i iVar = (i) objB;
                int iG = iVar.g();
                while (iG > 0) {
                    b(iVar);
                    int iG2 = iVar.g();
                    sVar.c(iG - iG2);
                    iG = iG2;
                }
                sVar.c();
            } else if (objB instanceof an) {
                an anVar = (an) objB;
                long jA = anVar.a();
                a(anVar);
                sVar.c(anVar.a() - jA);
                sVar.c();
            } else {
                sVar.a((Throwable) new UnsupportedOperationException("unsupported message type: " + p.a(objB)));
            }
        }
    }

    @Override // io.netty.channel.a
    protected final Object b(Object obj) {
        if ((obj instanceof i) || (obj instanceof an)) {
            return obj;
        }
        throw new UnsupportedOperationException("unsupported message type: " + p.a(obj) + c);
    }
}
