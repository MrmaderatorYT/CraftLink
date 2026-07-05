package io.netty.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: PoolChunkList.java */
/* loaded from: classes.dex */
final class s<T> implements t {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f4400a = !s.class.desiredAssertionStatus();

    /* renamed from: b, reason: collision with root package name */
    private static final Iterator<Object> f4401b = Collections.emptyList().iterator();
    private final s<T> c;
    private final int d;
    private final int e;
    private final int f;
    private r<T> g;
    private s<T> h;

    s(s<T> sVar, int i, int i2, int i3) {
        if (!f4400a && i > i2) {
            throw new AssertionError();
        }
        this.c = sVar;
        this.d = i;
        this.e = i2;
        this.f = a(i, i3);
    }

    private static int a(int i, int i2) {
        int iA = a(i);
        if (iA == 100) {
            return 0;
        }
        return (int) ((i2 * (100 - iA)) / 100);
    }

    void a(s<T> sVar) {
        if (!f4400a && this.h != null) {
            throw new AssertionError();
        }
        this.h = sVar;
    }

    boolean a(w<T> wVar, int i, int i2) {
        if (this.g == null || i2 > this.f) {
            return false;
        }
        r<T> rVar = this.g;
        do {
            long jA = rVar.a(i2);
            if (jA < 0) {
                rVar = rVar.f;
            } else {
                rVar.a(wVar, jA, i);
                if (rVar.a() < this.e) {
                    return true;
                }
                e(rVar);
                this.c.a(rVar);
                return true;
            }
        } while (rVar != null);
        return false;
    }

    boolean a(r<T> rVar, long j) {
        rVar.a(j);
        if (rVar.a() >= this.d) {
            return true;
        }
        e(rVar);
        return d(rVar);
    }

    private boolean c(r<T> rVar) {
        if (!f4400a && rVar.a() >= this.e) {
            throw new AssertionError();
        }
        if (rVar.a() < this.d) {
            return d(rVar);
        }
        b(rVar);
        return true;
    }

    private boolean d(r<T> rVar) {
        if (this.h == null) {
            if (f4400a || rVar.a() == 0) {
                return false;
            }
            throw new AssertionError();
        }
        return this.h.c(rVar);
    }

    void a(r<T> rVar) {
        if (rVar.a() >= this.e) {
            this.c.a(rVar);
        } else {
            b(rVar);
        }
    }

    void b(r<T> rVar) {
        rVar.d = this;
        if (this.g == null) {
            this.g = rVar;
            rVar.e = null;
            rVar.f = null;
        } else {
            rVar.e = null;
            rVar.f = this.g;
            this.g.e = rVar;
            this.g = rVar;
        }
    }

    private void e(r<T> rVar) {
        if (rVar == this.g) {
            this.g = rVar.f;
            if (this.g != null) {
                this.g.e = null;
                return;
            }
            return;
        }
        r<T> rVar2 = rVar.f;
        rVar.e.f = rVar2;
        if (rVar2 != null) {
            rVar2.e = rVar.e;
        }
    }

    private static int a(int i) {
        return Math.max(1, i);
    }

    @Override // java.lang.Iterable
    public Iterator<Object> iterator() {
        if (this.g == null) {
            return f4401b;
        }
        ArrayList arrayList = new ArrayList();
        r<T> rVar = this.g;
        do {
            arrayList.add(rVar);
            rVar = rVar.f;
        } while (rVar != null);
        return arrayList.iterator();
    }

    public String toString() {
        if (this.g == null) {
            return "none";
        }
        StringBuilder sb = new StringBuilder();
        r<T> rVar = this.g;
        while (true) {
            sb.append(rVar);
            rVar = rVar.f;
            if (rVar != null) {
                sb.append(io.netty.util.a.p.f4696a);
            } else {
                return sb.toString();
            }
        }
    }

    void a(q<T> qVar) {
        for (r<T> rVar = this.g; rVar != null; rVar = rVar.f) {
            qVar.a(rVar);
        }
        this.g = null;
    }
}
