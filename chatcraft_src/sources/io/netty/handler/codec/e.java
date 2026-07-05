package io.netty.handler.codec;

import io.netty.b.af;
import io.netty.b.i;
import io.netty.channel.l;
import io.netty.channel.u;
import io.netty.channel.z;
import io.netty.util.a.t;
import io.netty.util.m;
import io.netty.util.n;

/* compiled from: MessageToByteEncoder.java */
/* loaded from: classes.dex */
public abstract class e<I> extends u {

    /* renamed from: a, reason: collision with root package name */
    private final t f4572a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f4573b;

    protected abstract void a(l lVar, I i, i iVar);

    protected e() {
        this(true);
    }

    protected e(boolean z) {
        this.f4572a = t.a(this, e.class, "I");
        this.f4573b = z;
    }

    public boolean a(Object obj) {
        return this.f4572a.a(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    @Override // io.netty.channel.u, io.netty.channel.t
    public void write(l lVar, Object obj, z zVar) throws Throwable {
        n nVar = null;
        try {
            try {
                ?? A = a(obj);
                if (A != 0) {
                    try {
                        i iVarA = a(lVar, (l) obj, this.f4573b);
                        try {
                            a(lVar, (l) obj, iVarA);
                            m.a(obj);
                            if (iVarA.e()) {
                                lVar.a(iVarA, zVar);
                                return;
                            } else {
                                iVarA.D();
                                lVar.a(af.c, zVar);
                                return;
                            }
                        } catch (Throwable th) {
                            m.a(obj);
                            throw th;
                        }
                    } catch (EncoderException e) {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        nVar = A;
                        if (nVar != null) {
                            nVar.D();
                        }
                        throw th;
                    }
                }
                lVar.a(obj, zVar);
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (EncoderException e2) {
            throw e2;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    protected i a(l lVar, I i, boolean z) {
        if (z) {
            return lVar.c().a();
        }
        return lVar.c().b();
    }
}
