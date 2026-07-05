package org.xbill.DNS;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintStream;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ExtendedResolver.java */
/* loaded from: classes.dex */
public class z implements bv {

    /* renamed from: a, reason: collision with root package name */
    private List f5442a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5443b = false;
    private int c = 0;
    private int d = 3;

    static int a(z zVar, int i) {
        zVar.c = i;
        return i;
    }

    static List a(z zVar) {
        return zVar.f5442a;
    }

    static boolean b(z zVar) {
        return zVar.f5443b;
    }

    static int c(z zVar) {
        int i = zVar.c;
        zVar.c = i + 1;
        return i;
    }

    static int d(z zVar) {
        return zVar.c;
    }

    static int e(z zVar) {
        return zVar.d;
    }

    /* compiled from: ExtendedResolver.java */
    private static class a implements bx {

        /* renamed from: a, reason: collision with root package name */
        bv[] f5444a;

        /* renamed from: b, reason: collision with root package name */
        int[] f5445b;
        Object[] c;
        int d;
        int e;
        boolean f;
        au g;
        au h;
        Throwable i;
        bx j;

        public a(z zVar, au auVar) {
            List listA = z.a(zVar);
            this.f5444a = (bv[]) listA.toArray(new bv[listA.size()]);
            if (z.b(zVar)) {
                int length = this.f5444a.length;
                int iC = z.c(zVar) % length;
                if (z.d(zVar) > length) {
                    z.a(zVar, z.d(zVar) % length);
                }
                if (iC > 0) {
                    bv[] bvVarArr = new bv[length];
                    for (int i = 0; i < length; i++) {
                        bvVarArr[i] = this.f5444a[(i + iC) % length];
                    }
                    this.f5444a = bvVarArr;
                }
            }
            this.f5445b = new int[this.f5444a.length];
            this.c = new Object[this.f5444a.length];
            this.d = z.e(zVar);
            this.g = auVar;
        }

        public void a(int i) {
            int[] iArr = this.f5445b;
            iArr[i] = iArr[i] + 1;
            this.e++;
            try {
                this.c[i] = this.f5444a[i].a(this.g, this);
            } catch (Throwable th) {
                synchronized (this) {
                    this.i = th;
                    this.f = true;
                    if (this.j == null) {
                        notifyAll();
                    }
                }
            }
        }

        public au a() throws IOException {
            try {
                int[] iArr = this.f5445b;
                iArr[0] = iArr[0] + 1;
                this.e++;
                this.c[0] = new Object();
                return this.f5444a[0].a(this.g);
            } catch (Exception e) {
                a(this.c[0], e);
                synchronized (this) {
                    while (!this.f) {
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                    if (this.h != null) {
                        return this.h;
                    }
                    if (this.i instanceof IOException) {
                        throw ((IOException) this.i);
                    }
                    if (this.i instanceof RuntimeException) {
                        throw ((RuntimeException) this.i);
                    }
                    if (this.i instanceof Error) {
                        throw ((Error) this.i);
                    }
                    throw new IllegalStateException("ExtendedResolver failure");
                }
            }
        }

        public void a(bx bxVar) {
            this.j = bxVar;
            a(0);
        }

        @Override // org.xbill.DNS.bx
        public void a(Object obj, au auVar) {
            if (bk.b("verbose")) {
                System.err.println("ExtendedResolver: received message");
            }
            synchronized (this) {
                if (this.f) {
                    return;
                }
                this.h = auVar;
                this.f = true;
                if (this.j == null) {
                    notifyAll();
                } else {
                    this.j.a(this, this.h);
                }
            }
        }

        @Override // org.xbill.DNS.bx
        public void a(Object obj, Exception exc) {
            if (bk.b("verbose")) {
                PrintStream printStream = System.err;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("ExtendedResolver: got ");
                stringBuffer.append(exc);
                printStream.println(stringBuffer.toString());
            }
            synchronized (this) {
                this.e--;
                if (this.f) {
                    return;
                }
                boolean z = false;
                int i = 0;
                while (i < this.c.length && this.c[i] != obj) {
                    i++;
                }
                if (i == this.c.length) {
                    return;
                }
                if (this.f5445b[i] == 1 && i < this.f5444a.length - 1) {
                    z = true;
                }
                if (exc instanceof InterruptedIOException) {
                    if (this.f5445b[i] < this.d) {
                        a(i);
                    }
                    if (this.i == null) {
                        this.i = exc;
                    }
                } else if (!(exc instanceof SocketException) || this.i == null || (this.i instanceof InterruptedIOException)) {
                    this.i = exc;
                }
                if (this.f) {
                    return;
                }
                if (z) {
                    a(i + 1);
                }
                if (this.f) {
                    return;
                }
                if (this.e == 0) {
                    this.f = true;
                    if (this.j == null) {
                        notifyAll();
                        return;
                    }
                }
                if (this.f) {
                    if (!(this.i instanceof Exception)) {
                        this.i = new RuntimeException(this.i.getMessage());
                    }
                    this.j.a(this, (Exception) this.i);
                }
            }
        }
    }

    private void a() {
        this.f5442a = new ArrayList();
    }

    public z() {
        a();
        String[] strArrA = bw.e().a();
        if (strArrA != null) {
            for (String str : strArrA) {
                ci ciVar = new ci(str);
                ciVar.a(5);
                this.f5442a.add(ciVar);
            }
            return;
        }
        this.f5442a.add(new ci());
    }

    @Override // org.xbill.DNS.bv
    public void a(int i, int i2) {
        for (int i3 = 0; i3 < this.f5442a.size(); i3++) {
            ((bv) this.f5442a.get(i3)).a(i, i2);
        }
    }

    @Override // org.xbill.DNS.bv
    public void a(int i) {
        a(i, 0);
    }

    @Override // org.xbill.DNS.bv
    public au a(au auVar) {
        return new a(this, auVar).a();
    }

    @Override // org.xbill.DNS.bv
    public Object a(au auVar, bx bxVar) {
        a aVar = new a(this, auVar);
        aVar.a(bxVar);
        return aVar;
    }
}
