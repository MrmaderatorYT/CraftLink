package androidx.recyclerview.widget;

import androidx.core.f.d;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: ViewInfoStore.java */
/* loaded from: classes.dex */
class q {

    /* renamed from: a, reason: collision with root package name */
    final androidx.b.a<RecyclerView.x, a> f1134a = new androidx.b.a<>();

    /* renamed from: b, reason: collision with root package name */
    final androidx.b.d<RecyclerView.x> f1135b = new androidx.b.d<>();

    /* compiled from: ViewInfoStore.java */
    interface b {
        void a(RecyclerView.x xVar);

        void a(RecyclerView.x xVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);

        void b(RecyclerView.x xVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);

        void c(RecyclerView.x xVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);
    }

    q() {
    }

    void a() {
        this.f1134a.clear();
        this.f1135b.c();
    }

    void a(RecyclerView.x xVar, RecyclerView.f.c cVar) {
        a aVarA = this.f1134a.get(xVar);
        if (aVarA == null) {
            aVarA = a.a();
            this.f1134a.put(xVar, aVarA);
        }
        aVarA.f1137b = cVar;
        aVarA.f1136a |= 4;
    }

    boolean a(RecyclerView.x xVar) {
        a aVar = this.f1134a.get(xVar);
        return (aVar == null || (aVar.f1136a & 1) == 0) ? false : true;
    }

    RecyclerView.f.c b(RecyclerView.x xVar) {
        return a(xVar, 4);
    }

    RecyclerView.f.c c(RecyclerView.x xVar) {
        return a(xVar, 8);
    }

    private RecyclerView.f.c a(RecyclerView.x xVar, int i) {
        a aVarC;
        RecyclerView.f.c cVar;
        int iA = this.f1134a.a(xVar);
        if (iA < 0 || (aVarC = this.f1134a.c(iA)) == null || (aVarC.f1136a & i) == 0) {
            return null;
        }
        aVarC.f1136a &= i ^ (-1);
        if (i == 4) {
            cVar = aVarC.f1137b;
        } else if (i == 8) {
            cVar = aVarC.c;
        } else {
            throw new IllegalArgumentException("Must provide flag PRE or POST");
        }
        if ((aVarC.f1136a & 12) == 0) {
            this.f1134a.d(iA);
            a.a(aVarC);
        }
        return cVar;
    }

    void a(long j, RecyclerView.x xVar) {
        this.f1135b.b(j, xVar);
    }

    void b(RecyclerView.x xVar, RecyclerView.f.c cVar) {
        a aVarA = this.f1134a.get(xVar);
        if (aVarA == null) {
            aVarA = a.a();
            this.f1134a.put(xVar, aVarA);
        }
        aVarA.f1136a |= 2;
        aVarA.f1137b = cVar;
    }

    boolean d(RecyclerView.x xVar) {
        a aVar = this.f1134a.get(xVar);
        return (aVar == null || (aVar.f1136a & 4) == 0) ? false : true;
    }

    RecyclerView.x a(long j) {
        return this.f1135b.a(j);
    }

    void c(RecyclerView.x xVar, RecyclerView.f.c cVar) {
        a aVarA = this.f1134a.get(xVar);
        if (aVarA == null) {
            aVarA = a.a();
            this.f1134a.put(xVar, aVarA);
        }
        aVarA.c = cVar;
        aVarA.f1136a |= 8;
    }

    void e(RecyclerView.x xVar) {
        a aVarA = this.f1134a.get(xVar);
        if (aVarA == null) {
            aVarA = a.a();
            this.f1134a.put(xVar, aVarA);
        }
        aVarA.f1136a |= 1;
    }

    void f(RecyclerView.x xVar) {
        a aVar = this.f1134a.get(xVar);
        if (aVar == null) {
            return;
        }
        aVar.f1136a &= -2;
    }

    void a(b bVar) {
        for (int size = this.f1134a.size() - 1; size >= 0; size--) {
            RecyclerView.x xVarB = this.f1134a.b(size);
            a aVarD = this.f1134a.d(size);
            if ((aVarD.f1136a & 3) == 3) {
                bVar.a(xVarB);
            } else if ((aVarD.f1136a & 1) != 0) {
                if (aVarD.f1137b == null) {
                    bVar.a(xVarB);
                } else {
                    bVar.a(xVarB, aVarD.f1137b, aVarD.c);
                }
            } else if ((aVarD.f1136a & 14) == 14) {
                bVar.b(xVarB, aVarD.f1137b, aVarD.c);
            } else if ((aVarD.f1136a & 12) == 12) {
                bVar.c(xVarB, aVarD.f1137b, aVarD.c);
            } else if ((aVarD.f1136a & 4) != 0) {
                bVar.a(xVarB, aVarD.f1137b, null);
            } else if ((aVarD.f1136a & 8) != 0) {
                bVar.b(xVarB, aVarD.f1137b, aVarD.c);
            } else {
                int i = aVarD.f1136a;
            }
            a.a(aVarD);
        }
    }

    void g(RecyclerView.x xVar) {
        int iB = this.f1135b.b() - 1;
        while (true) {
            if (iB < 0) {
                break;
            }
            if (xVar == this.f1135b.c(iB)) {
                this.f1135b.a(iB);
                break;
            }
            iB--;
        }
        a aVarRemove = this.f1134a.remove(xVar);
        if (aVarRemove != null) {
            a.a(aVarRemove);
        }
    }

    void b() {
        a.b();
    }

    public void h(RecyclerView.x xVar) {
        f(xVar);
    }

    /* compiled from: ViewInfoStore.java */
    static class a {
        static d.a<a> d = new d.b(20);

        /* renamed from: a, reason: collision with root package name */
        int f1136a;

        /* renamed from: b, reason: collision with root package name */
        RecyclerView.f.c f1137b;
        RecyclerView.f.c c;

        private a() {
        }

        static a a() {
            a aVarA = d.a();
            return aVarA == null ? new a() : aVarA;
        }

        static void a(a aVar) {
            aVar.f1136a = 0;
            aVar.f1137b = null;
            aVar.c = null;
            d.a(aVar);
        }

        static void b() {
            while (d.a() != null) {
            }
        }
    }
}
