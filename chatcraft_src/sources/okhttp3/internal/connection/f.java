package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import okhttp3.ac;
import okhttp3.internal.connection.e;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.j;
import okhttp3.p;
import okhttp3.t;
import okhttp3.v;

/* compiled from: StreamAllocation.java */
/* loaded from: classes.dex */
public final class f {
    static final /* synthetic */ boolean d = !f.class.desiredAssertionStatus();

    /* renamed from: a, reason: collision with root package name */
    public final okhttp3.a f5144a;

    /* renamed from: b, reason: collision with root package name */
    public final okhttp3.e f5145b;
    public final p c;
    private e.a e;
    private ac f;
    private final j g;
    private final Object h;
    private final e i;
    private int j;
    private c k;
    private boolean l;
    private boolean m;
    private boolean n;
    private okhttp3.internal.b.c o;

    public f(j jVar, okhttp3.a aVar, okhttp3.e eVar, p pVar, Object obj) {
        this.g = jVar;
        this.f5144a = aVar;
        this.f5145b = eVar;
        this.c = pVar;
        this.i = new e(aVar, h(), eVar, pVar);
        this.h = obj;
    }

    public okhttp3.internal.b.c a(v vVar, t.a aVar, boolean z) {
        try {
            okhttp3.internal.b.c cVarA = a(aVar.b(), aVar.c(), aVar.d(), vVar.d(), vVar.t(), z).a(vVar, aVar, this);
            synchronized (this.g) {
                this.o = cVarA;
            }
            return cVarA;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    private c a(int i, int i2, int i3, int i4, boolean z, boolean z2) throws Throwable {
        while (true) {
            c cVarA = a(i, i2, i3, i4, z);
            synchronized (this.g) {
                if (cVarA.f5138b == 0) {
                    return cVarA;
                }
                if (cVarA.a(z2)) {
                    return cVarA;
                }
                e();
            }
        }
    }

    private c a(int i, int i2, int i3, int i4, boolean z) throws Throwable {
        Socket socketG;
        Socket socketA;
        c cVar;
        c cVar2;
        c cVar3;
        ac acVarB;
        boolean z2;
        boolean z3;
        synchronized (this.g) {
            if (this.m) {
                throw new IllegalStateException("released");
            }
            if (this.o != null) {
                throw new IllegalStateException("codec != null");
            }
            if (this.n) {
                throw new IOException("Canceled");
            }
            c cVar4 = this.k;
            socketG = g();
            socketA = null;
            if (this.k != null) {
                cVar2 = this.k;
                cVar = null;
            } else {
                cVar = cVar4;
                cVar2 = null;
            }
            if (!this.l) {
                cVar = null;
            }
            if (cVar2 == null) {
                okhttp3.internal.a.f5084a.a(this.g, this.f5144a, this, null);
                if (this.k != null) {
                    cVar3 = this.k;
                    acVarB = null;
                    z2 = true;
                } else {
                    acVarB = this.f;
                    cVar3 = cVar2;
                }
            } else {
                cVar3 = cVar2;
                acVarB = null;
            }
            z2 = false;
        }
        okhttp3.internal.c.a(socketG);
        if (cVar != null) {
            this.c.b(this.f5145b, cVar);
        }
        if (z2) {
            this.c.a(this.f5145b, cVar3);
        }
        if (cVar3 != null) {
            return cVar3;
        }
        if (acVarB != null || (this.e != null && this.e.a())) {
            z3 = false;
        } else {
            this.e = this.i.b();
            z3 = true;
        }
        synchronized (this.g) {
            if (this.n) {
                throw new IOException("Canceled");
            }
            if (z3) {
                List<ac> listC = this.e.c();
                int size = listC.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        break;
                    }
                    ac acVar = listC.get(i5);
                    okhttp3.internal.a.f5084a.a(this.g, this.f5144a, this, acVar);
                    if (this.k != null) {
                        cVar3 = this.k;
                        this.f = acVar;
                        z2 = true;
                        break;
                    }
                    i5++;
                }
            }
            if (!z2) {
                if (acVarB == null) {
                    acVarB = this.e.b();
                }
                this.f = acVarB;
                this.j = 0;
                cVar3 = new c(this.g, acVarB);
                a(cVar3, false);
            }
        }
        if (z2) {
            this.c.a(this.f5145b, cVar3);
            return cVar3;
        }
        cVar3.a(i, i2, i3, i4, z, this.f5145b, this.c);
        h().b(cVar3.a());
        synchronized (this.g) {
            this.l = true;
            okhttp3.internal.a.f5084a.b(this.g, cVar3);
            if (cVar3.d()) {
                socketA = okhttp3.internal.a.f5084a.a(this.g, this.f5144a, this);
                cVar3 = this.k;
            }
        }
        okhttp3.internal.c.a(socketA);
        this.c.a(this.f5145b, cVar3);
        return cVar3;
    }

    private Socket g() {
        if (!d && !Thread.holdsLock(this.g)) {
            throw new AssertionError();
        }
        c cVar = this.k;
        if (cVar == null || !cVar.f5137a) {
            return null;
        }
        return a(false, false, true);
    }

    public void a(boolean z, okhttp3.internal.b.c cVar, long j, IOException iOException) throws IOException {
        c cVar2;
        Socket socketA;
        boolean z2;
        this.c.b(this.f5145b, j);
        synchronized (this.g) {
            if (cVar != null) {
                if (cVar == this.o) {
                    if (!z) {
                        this.k.f5138b++;
                    }
                    cVar2 = this.k;
                    socketA = a(z, false, true);
                    if (this.k != null) {
                        cVar2 = null;
                    }
                    z2 = this.m;
                }
            }
            throw new IllegalStateException("expected " + this.o + " but was " + cVar);
        }
        okhttp3.internal.c.a(socketA);
        if (cVar2 != null) {
            this.c.b(this.f5145b, cVar2);
        }
        if (iOException != null) {
            this.c.a(this.f5145b, iOException);
        } else if (z2) {
            this.c.g(this.f5145b);
        }
    }

    public okhttp3.internal.b.c a() {
        okhttp3.internal.b.c cVar;
        synchronized (this.g) {
            cVar = this.o;
        }
        return cVar;
    }

    private d h() {
        return okhttp3.internal.a.f5084a.a(this.g);
    }

    public ac b() {
        return this.f;
    }

    public synchronized c c() {
        return this.k;
    }

    public void d() throws IOException {
        c cVar;
        Socket socketA;
        synchronized (this.g) {
            cVar = this.k;
            socketA = a(false, true, false);
            if (this.k != null) {
                cVar = null;
            }
        }
        okhttp3.internal.c.a(socketA);
        if (cVar != null) {
            this.c.b(this.f5145b, cVar);
        }
    }

    public void e() throws IOException {
        c cVar;
        Socket socketA;
        synchronized (this.g) {
            cVar = this.k;
            socketA = a(true, false, false);
            if (this.k != null) {
                cVar = null;
            }
        }
        okhttp3.internal.c.a(socketA);
        if (cVar != null) {
            this.c.b(this.f5145b, cVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.net.Socket a(boolean r2, boolean r3, boolean r4) {
        /*
            r1 = this;
            boolean r0 = okhttp3.internal.connection.f.d
            if (r0 != 0) goto L13
            okhttp3.j r0 = r1.g
            boolean r0 = java.lang.Thread.holdsLock(r0)
            if (r0 == 0) goto Ld
            goto L13
        Ld:
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L13:
            r0 = 0
            if (r4 == 0) goto L18
            r1.o = r0
        L18:
            r4 = 1
            if (r3 == 0) goto L1d
            r1.m = r4
        L1d:
            okhttp3.internal.connection.c r3 = r1.k
            if (r3 == 0) goto L63
            if (r2 == 0) goto L27
            okhttp3.internal.connection.c r2 = r1.k
            r2.f5137a = r4
        L27:
            okhttp3.internal.b.c r2 = r1.o
            if (r2 != 0) goto L63
            boolean r2 = r1.m
            if (r2 != 0) goto L35
            okhttp3.internal.connection.c r2 = r1.k
            boolean r2 = r2.f5137a
            if (r2 == 0) goto L63
        L35:
            okhttp3.internal.connection.c r2 = r1.k
            r1.b(r2)
            okhttp3.internal.connection.c r2 = r1.k
            java.util.List<java.lang.ref.Reference<okhttp3.internal.connection.f>> r2 = r2.d
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L5f
            okhttp3.internal.connection.c r2 = r1.k
            long r3 = java.lang.System.nanoTime()
            r2.e = r3
            okhttp3.internal.a r2 = okhttp3.internal.a.f5084a
            okhttp3.j r3 = r1.g
            okhttp3.internal.connection.c r4 = r1.k
            boolean r2 = r2.a(r3, r4)
            if (r2 == 0) goto L5f
            okhttp3.internal.connection.c r2 = r1.k
            java.net.Socket r2 = r2.b()
            goto L60
        L5f:
            r2 = r0
        L60:
            r1.k = r0
            goto L64
        L63:
            r2 = r0
        L64:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.f.a(boolean, boolean, boolean):java.net.Socket");
    }

    public void a(IOException iOException) throws IOException {
        boolean z;
        c cVar;
        Socket socketA;
        synchronized (this.g) {
            if (iOException instanceof StreamResetException) {
                StreamResetException streamResetException = (StreamResetException) iOException;
                if (streamResetException.f5169a == okhttp3.internal.http2.a.REFUSED_STREAM) {
                    this.j++;
                }
                if (streamResetException.f5169a != okhttp3.internal.http2.a.REFUSED_STREAM || this.j > 1) {
                    this.f = null;
                    z = true;
                }
                z = false;
            } else {
                if (this.k != null && (!this.k.d() || (iOException instanceof ConnectionShutdownException))) {
                    if (this.k.f5138b == 0) {
                        if (this.f != null && iOException != null) {
                            this.i.a(this.f, iOException);
                        }
                        this.f = null;
                    }
                    z = true;
                }
                z = false;
            }
            cVar = this.k;
            socketA = a(z, false, true);
            if (this.k != null || !this.l) {
                cVar = null;
            }
        }
        okhttp3.internal.c.a(socketA);
        if (cVar != null) {
            this.c.b(this.f5145b, cVar);
        }
    }

    public void a(c cVar, boolean z) {
        if (!d && !Thread.holdsLock(this.g)) {
            throw new AssertionError();
        }
        if (this.k != null) {
            throw new IllegalStateException();
        }
        this.k = cVar;
        this.l = z;
        cVar.d.add(new a(this, this.h));
    }

    private void b(c cVar) {
        int size = cVar.d.size();
        for (int i = 0; i < size; i++) {
            if (cVar.d.get(i).get() == this) {
                cVar.d.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public Socket a(c cVar) {
        if (!d && !Thread.holdsLock(this.g)) {
            throw new AssertionError();
        }
        if (this.o != null || this.k.d.size() != 1) {
            throw new IllegalStateException();
        }
        Reference<f> reference = this.k.d.get(0);
        Socket socketA = a(true, false, false);
        this.k = cVar;
        cVar.d.add(reference);
        return socketA;
    }

    public boolean f() {
        return this.f != null || (this.e != null && this.e.a()) || this.i.a();
    }

    public String toString() {
        c cVarC = c();
        return cVarC != null ? cVarC.toString() : this.f5144a.toString();
    }

    /* compiled from: StreamAllocation.java */
    public static final class a extends WeakReference<f> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f5146a;

        a(f fVar, Object obj) {
            super(fVar);
            this.f5146a = obj;
        }
    }
}
