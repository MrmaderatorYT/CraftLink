package androidx.i;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import androidx.i.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TransitionSet.java */
/* loaded from: classes.dex */
public class q extends m {
    int h;
    private ArrayList<m> j = new ArrayList<>();
    private boolean k = true;
    boolean i = false;
    private int l = 0;

    public q a(int i) {
        switch (i) {
            case 0:
                this.k = true;
                return this;
            case 1:
                this.k = false;
                return this;
            default:
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
    }

    public q a(m mVar) {
        this.j.add(mVar);
        mVar.d = this;
        if (this.f847a >= 0) {
            mVar.a(this.f847a);
        }
        if ((this.l & 1) != 0) {
            mVar.a(d());
        }
        if ((this.l & 2) != 0) {
            mVar.a(n());
        }
        if ((this.l & 4) != 0) {
            mVar.a(l());
        }
        if ((this.l & 8) != 0) {
            mVar.a(m());
        }
        return this;
    }

    public int q() {
        return this.j.size();
    }

    public m b(int i) {
        if (i < 0 || i >= this.j.size()) {
            return null;
        }
        return this.j.get(i);
    }

    @Override // androidx.i.m
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public q a(long j) {
        super.a(j);
        if (this.f847a >= 0) {
            int size = this.j.size();
            for (int i = 0; i < size; i++) {
                this.j.get(i).a(j);
            }
        }
        return this;
    }

    @Override // androidx.i.m
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public q b(long j) {
        return (q) super.b(j);
    }

    @Override // androidx.i.m
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public q a(TimeInterpolator timeInterpolator) {
        this.l |= 1;
        if (this.j != null) {
            int size = this.j.size();
            for (int i = 0; i < size; i++) {
                this.j.get(i).a(timeInterpolator);
            }
        }
        return (q) super.a(timeInterpolator);
    }

    @Override // androidx.i.m
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public q b(View view) {
        for (int i = 0; i < this.j.size(); i++) {
            this.j.get(i).b(view);
        }
        return (q) super.b(view);
    }

    @Override // androidx.i.m
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public q a(m.c cVar) {
        return (q) super.a(cVar);
    }

    @Override // androidx.i.m
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public q c(View view) {
        for (int i = 0; i < this.j.size(); i++) {
            this.j.get(i).c(view);
        }
        return (q) super.c(view);
    }

    @Override // androidx.i.m
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public q b(m.c cVar) {
        return (q) super.b(cVar);
    }

    @Override // androidx.i.m
    public void a(g gVar) {
        super.a(gVar);
        this.l |= 4;
        for (int i = 0; i < this.j.size(); i++) {
            this.j.get(i).a(gVar);
        }
    }

    private void r() {
        a aVar = new a(this);
        Iterator<m> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
        this.h = this.j.size();
    }

    /* compiled from: TransitionSet.java */
    static class a extends n {

        /* renamed from: a, reason: collision with root package name */
        q f862a;

        a(q qVar) {
            this.f862a = qVar;
        }

        @Override // androidx.i.n, androidx.i.m.c
        public void d(m mVar) {
            if (this.f862a.i) {
                return;
            }
            this.f862a.j();
            this.f862a.i = true;
        }

        @Override // androidx.i.n, androidx.i.m.c
        public void a(m mVar) {
            q qVar = this.f862a;
            qVar.h--;
            if (this.f862a.h == 0) {
                this.f862a.i = false;
                this.f862a.k();
            }
            mVar.b(this);
        }
    }

    @Override // androidx.i.m
    protected void a(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        long jC = c();
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            m mVar = this.j.get(i);
            if (jC > 0 && (this.k || i == 0)) {
                long jC2 = mVar.c();
                if (jC2 > 0) {
                    mVar.b(jC2 + jC);
                } else {
                    mVar.b(jC);
                }
            }
            mVar.a(viewGroup, tVar, tVar2, arrayList, arrayList2);
        }
    }

    @Override // androidx.i.m
    protected void e() {
        if (this.j.isEmpty()) {
            j();
            k();
            return;
        }
        r();
        if (!this.k) {
            for (int i = 1; i < this.j.size(); i++) {
                m mVar = this.j.get(i - 1);
                final m mVar2 = this.j.get(i);
                mVar.a(new n() { // from class: androidx.i.q.1
                    @Override // androidx.i.n, androidx.i.m.c
                    public void a(m mVar3) {
                        mVar2.e();
                        mVar3.b(this);
                    }
                });
            }
            m mVar3 = this.j.get(0);
            if (mVar3 != null) {
                mVar3.e();
                return;
            }
            return;
        }
        Iterator<m> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }

    @Override // androidx.i.m
    public void a(s sVar) {
        if (a(sVar.f866b)) {
            Iterator<m> it = this.j.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next.a(sVar.f866b)) {
                    next.a(sVar);
                    sVar.c.add(next);
                }
            }
        }
    }

    @Override // androidx.i.m
    public void b(s sVar) {
        if (a(sVar.f866b)) {
            Iterator<m> it = this.j.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next.a(sVar.f866b)) {
                    next.b(sVar);
                    sVar.c.add(next);
                }
            }
        }
    }

    @Override // androidx.i.m
    void c(s sVar) {
        super.c(sVar);
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            this.j.get(i).c(sVar);
        }
    }

    @Override // androidx.i.m
    public void d(View view) {
        super.d(view);
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            this.j.get(i).d(view);
        }
    }

    @Override // androidx.i.m
    public void e(View view) {
        super.e(view);
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            this.j.get(i).e(view);
        }
    }

    @Override // androidx.i.m
    public void a(p pVar) {
        super.a(pVar);
        this.l |= 2;
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            this.j.get(i).a(pVar);
        }
    }

    @Override // androidx.i.m
    public void a(m.b bVar) {
        super.a(bVar);
        this.l |= 8;
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            this.j.get(i).a(bVar);
        }
    }

    @Override // androidx.i.m
    String a(String str) {
        String strA = super.a(str);
        for (int i = 0; i < this.j.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strA);
            sb.append("\n");
            sb.append(this.j.get(i).a(str + "  "));
            strA = sb.toString();
        }
        return strA;
    }

    @Override // androidx.i.m
    /* renamed from: o */
    public m clone() {
        q qVar = (q) super.clone();
        qVar.j = new ArrayList<>();
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            qVar.a(this.j.get(i).clone());
        }
        return qVar;
    }
}
