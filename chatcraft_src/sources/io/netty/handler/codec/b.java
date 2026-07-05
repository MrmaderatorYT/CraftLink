package io.netty.handler.codec;

import io.netty.b.af;
import io.netty.b.i;
import io.netty.b.j;
import io.netty.b.m;
import io.netty.channel.l;
import io.netty.channel.o;
import io.netty.util.a.p;
import java.util.List;

/* compiled from: ByteToMessageDecoder.java */
/* loaded from: classes.dex */
public abstract class b extends o {

    /* renamed from: b, reason: collision with root package name */
    public static final a f4568b = new a() { // from class: io.netty.handler.codec.b.1
        @Override // io.netty.handler.codec.b.a
        public i a(j jVar, i iVar, i iVar2) {
            if (iVar.c() > iVar.a() - iVar2.g() || iVar.C() > 1) {
                iVar = b.a(jVar, iVar, iVar2.g());
            }
            iVar.a(iVar2);
            iVar2.D();
            return iVar;
        }
    };
    public static final a c = new a() { // from class: io.netty.handler.codec.b.2
        @Override // io.netty.handler.codec.b.a
        public i a(j jVar, i iVar, i iVar2) throws Throwable {
            m mVarE;
            if (iVar.C() > 1) {
                i iVarA = b.a(jVar, iVar, iVar2.g());
                iVarA.a(iVar2);
                iVar2.D();
                return iVarA;
            }
            if (iVar instanceof m) {
                mVarE = (m) iVar;
            } else {
                mVarE = jVar.e(Integer.MAX_VALUE);
                mVarE.a(true, iVar);
            }
            mVarE.a(true, iVar2);
            return mVarE;
        }
    };
    i d;
    private boolean e;
    private boolean f;
    private boolean g;
    private int i;

    /* renamed from: a, reason: collision with root package name */
    private a f4569a = f4568b;
    private int h = 16;

    /* compiled from: ByteToMessageDecoder.java */
    public interface a {
        i a(j jVar, i iVar, i iVar2);
    }

    protected void a(l lVar) {
    }

    protected abstract void a(l lVar, i iVar, List<Object> list);

    protected b() {
        d.a(this);
    }

    public boolean a() {
        return this.e;
    }

    @Override // io.netty.channel.k, io.netty.channel.j
    public final void handlerRemoved(l lVar) {
        i iVar = this.d;
        if (iVar != null) {
            this.d = null;
            int iG = iVar.g();
            if (iG > 0) {
                i iVarU = iVar.u(iG);
                iVar.D();
                lVar.c(iVarU);
            } else {
                iVar.D();
            }
            this.i = 0;
            lVar.k();
        }
        a(lVar);
    }

    /* JADX WARN: Finally extract failed */
    @Override // io.netty.channel.o, io.netty.channel.n
    public void channelRead(l lVar, Object obj) {
        if (obj instanceof i) {
            c cVarA = c.a();
            try {
                try {
                    i iVar = (i) obj;
                    this.g = this.d == null;
                    if (this.g) {
                        this.d = iVar;
                    } else {
                        this.d = this.f4569a.a(lVar.c(), this.d, iVar);
                    }
                    c(lVar, this.d, cVarA);
                    if (this.d != null && !this.d.e()) {
                        this.i = 0;
                        this.d.D();
                        this.d = null;
                    } else {
                        int i = this.i + 1;
                        this.i = i;
                        if (i >= this.h) {
                            this.i = 0;
                            b();
                        }
                    }
                    int size = cVarA.size();
                    this.f = !cVarA.b();
                    a(lVar, cVarA, size);
                    cVarA.c();
                    return;
                } catch (DecoderException e) {
                    throw e;
                } catch (Throwable th) {
                    throw new DecoderException(th);
                }
            } catch (Throwable th2) {
                if (this.d != null && !this.d.e()) {
                    this.i = 0;
                    this.d.D();
                    this.d = null;
                } else {
                    int i2 = this.i + 1;
                    this.i = i2;
                    if (i2 >= this.h) {
                        this.i = 0;
                        b();
                    }
                }
                int size2 = cVarA.size();
                this.f = !cVarA.b();
                a(lVar, cVarA, size2);
                cVarA.c();
                throw th2;
            }
        }
        lVar.c(obj);
    }

    static void a(l lVar, List<Object> list, int i) {
        if (list instanceof c) {
            a(lVar, (c) list, i);
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            lVar.c(list.get(i2));
        }
    }

    static void a(l lVar, c cVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            lVar.c(cVar.a(i2));
        }
    }

    @Override // io.netty.channel.o, io.netty.channel.n
    public void channelReadComplete(l lVar) {
        this.i = 0;
        b();
        if (this.f) {
            this.f = false;
            if (!lVar.a().D().e()) {
                lVar.n();
            }
        }
        lVar.k();
    }

    protected final void b() {
        if (this.d == null || this.g || this.d.C() != 1) {
            return;
        }
        this.d.l();
    }

    @Override // io.netty.channel.o, io.netty.channel.n
    public void channelInactive(l lVar) {
        a(lVar, true);
    }

    @Override // io.netty.channel.o, io.netty.channel.n
    public void userEventTriggered(l lVar, Object obj) {
        if (obj instanceof io.netty.channel.c.a) {
            a(lVar, false);
        }
        super.userEventTriggered(lVar, obj);
    }

    private void a(l lVar, boolean z) {
        c cVarA = c.a();
        try {
            try {
                a(lVar, cVarA);
                try {
                    if (this.d != null) {
                        this.d.D();
                        this.d = null;
                    }
                    int size = cVarA.size();
                    a(lVar, cVarA, size);
                    if (size > 0) {
                        lVar.k();
                    }
                    if (z) {
                        lVar.i();
                    }
                } finally {
                }
            } catch (DecoderException e) {
                throw e;
            } catch (Exception e2) {
                throw new DecoderException(e2);
            }
        } catch (Throwable th) {
            try {
                if (this.d != null) {
                    this.d.D();
                    this.d = null;
                }
                int size2 = cVarA.size();
                a(lVar, cVarA, size2);
                if (size2 > 0) {
                    lVar.k();
                }
                if (z) {
                    lVar.i();
                }
                throw th;
            } finally {
            }
        }
    }

    void a(l lVar, List<Object> list) {
        if (this.d != null) {
            c(lVar, this.d, list);
            b(lVar, this.d, list);
        } else {
            b(lVar, af.c, list);
        }
    }

    protected void c(l lVar, i iVar, List<Object> list) {
        while (iVar.e()) {
            try {
                int size = list.size();
                if (size > 0) {
                    a(lVar, list, size);
                    list.clear();
                    if (lVar.t()) {
                        return;
                    } else {
                        size = 0;
                    }
                }
                int iG = iVar.g();
                a(lVar, iVar, list);
                if (lVar.t()) {
                    return;
                }
                if (size == list.size()) {
                    if (iG == iVar.g()) {
                        return;
                    }
                } else {
                    if (iG == iVar.g()) {
                        throw new DecoderException(p.a(getClass()) + ".decode() did not read anything but decoded a message.");
                    }
                    if (a()) {
                        return;
                    }
                }
            } catch (DecoderException e) {
                throw e;
            } catch (Throwable th) {
                throw new DecoderException(th);
            }
        }
    }

    protected void b(l lVar, i iVar, List<Object> list) {
        if (iVar.e()) {
            a(lVar, iVar, list);
        }
    }

    static i a(j jVar, i iVar, int i) {
        i iVarA = jVar.a(iVar.g() + i);
        iVarA.a(iVar);
        iVar.D();
        return iVarA;
    }
}
