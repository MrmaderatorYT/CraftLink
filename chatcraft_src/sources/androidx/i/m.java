package androidx.i;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: Transition.java */
/* loaded from: classes.dex */
public abstract class m implements Cloneable {
    private b H;
    private androidx.b.a<String, String> I;
    p g;
    private ArrayList<s> y;
    private ArrayList<s> z;
    private static final int[] h = {2, 1, 3, 4};
    private static final g i = new g() { // from class: androidx.i.m.1
        @Override // androidx.i.g
        public Path a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    };
    private static ThreadLocal<androidx.b.a<Animator, a>> A = new ThreadLocal<>();
    private String j = getClass().getName();
    private long k = -1;

    /* renamed from: a, reason: collision with root package name */
    long f847a = -1;
    private TimeInterpolator l = null;

    /* renamed from: b, reason: collision with root package name */
    ArrayList<Integer> f848b = new ArrayList<>();
    ArrayList<View> c = new ArrayList<>();
    private ArrayList<String> m = null;
    private ArrayList<Class> n = null;
    private ArrayList<Integer> o = null;
    private ArrayList<View> p = null;
    private ArrayList<Class> q = null;
    private ArrayList<String> r = null;
    private ArrayList<Integer> s = null;
    private ArrayList<View> t = null;
    private ArrayList<Class> u = null;
    private t v = new t();
    private t w = new t();
    q d = null;
    private int[] x = h;
    private ViewGroup B = null;
    boolean e = false;
    ArrayList<Animator> f = new ArrayList<>();
    private int C = 0;
    private boolean D = false;
    private boolean E = false;
    private ArrayList<c> F = null;
    private ArrayList<Animator> G = new ArrayList<>();
    private g J = i;

    /* compiled from: Transition.java */
    public static abstract class b {
    }

    /* compiled from: Transition.java */
    public interface c {
        void a(m mVar);

        void b(m mVar);

        void c(m mVar);

        void d(m mVar);
    }

    public Animator a(ViewGroup viewGroup, s sVar, s sVar2) {
        return null;
    }

    public abstract void a(s sVar);

    public String[] a() {
        return null;
    }

    public abstract void b(s sVar);

    public m a(long j) {
        this.f847a = j;
        return this;
    }

    public long b() {
        return this.f847a;
    }

    public m b(long j) {
        this.k = j;
        return this;
    }

    public long c() {
        return this.k;
    }

    public m a(TimeInterpolator timeInterpolator) {
        this.l = timeInterpolator;
        return this;
    }

    public TimeInterpolator d() {
        return this.l;
    }

    private void a(androidx.b.a<View, s> aVar, androidx.b.a<View, s> aVar2) {
        s sVarRemove;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View viewB = aVar.b(size);
            if (viewB != null && a(viewB) && (sVarRemove = aVar2.remove(viewB)) != null && sVarRemove.f866b != null && a(sVarRemove.f866b)) {
                this.y.add(aVar.d(size));
                this.z.add(sVarRemove);
            }
        }
    }

    private void a(androidx.b.a<View, s> aVar, androidx.b.a<View, s> aVar2, androidx.b.d<View> dVar, androidx.b.d<View> dVar2) {
        View viewA;
        int iB = dVar.b();
        for (int i2 = 0; i2 < iB; i2++) {
            View viewC = dVar.c(i2);
            if (viewC != null && a(viewC) && (viewA = dVar2.a(dVar.b(i2))) != null && a(viewA)) {
                s sVar = aVar.get(viewC);
                s sVar2 = aVar2.get(viewA);
                if (sVar != null && sVar2 != null) {
                    this.y.add(sVar);
                    this.z.add(sVar2);
                    aVar.remove(viewC);
                    aVar2.remove(viewA);
                }
            }
        }
    }

    private void a(androidx.b.a<View, s> aVar, androidx.b.a<View, s> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            View viewValueAt = sparseArray.valueAt(i2);
            if (viewValueAt != null && a(viewValueAt) && (view = sparseArray2.get(sparseArray.keyAt(i2))) != null && a(view)) {
                s sVar = aVar.get(viewValueAt);
                s sVar2 = aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.y.add(sVar);
                    this.z.add(sVar2);
                    aVar.remove(viewValueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void a(androidx.b.a<View, s> aVar, androidx.b.a<View, s> aVar2, androidx.b.a<String, View> aVar3, androidx.b.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i2 = 0; i2 < size; i2++) {
            View viewC = aVar3.c(i2);
            if (viewC != null && a(viewC) && (view = aVar4.get(aVar3.b(i2))) != null && a(view)) {
                s sVar = aVar.get(viewC);
                s sVar2 = aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.y.add(sVar);
                    this.z.add(sVar2);
                    aVar.remove(viewC);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void b(androidx.b.a<View, s> aVar, androidx.b.a<View, s> aVar2) {
        for (int i2 = 0; i2 < aVar.size(); i2++) {
            s sVarC = aVar.c(i2);
            if (a(sVarC.f866b)) {
                this.y.add(sVarC);
                this.z.add(null);
            }
        }
        for (int i3 = 0; i3 < aVar2.size(); i3++) {
            s sVarC2 = aVar2.c(i3);
            if (a(sVarC2.f866b)) {
                this.z.add(sVarC2);
                this.y.add(null);
            }
        }
    }

    private void a(t tVar, t tVar2) {
        androidx.b.a<View, s> aVar = new androidx.b.a<>(tVar.f867a);
        androidx.b.a<View, s> aVar2 = new androidx.b.a<>(tVar2.f867a);
        for (int i2 = 0; i2 < this.x.length; i2++) {
            switch (this.x[i2]) {
                case 1:
                    a(aVar, aVar2);
                    break;
                case 2:
                    a(aVar, aVar2, tVar.d, tVar2.d);
                    break;
                case 3:
                    a(aVar, aVar2, tVar.f868b, tVar2.f868b);
                    break;
                case 4:
                    a(aVar, aVar2, tVar.c, tVar2.c);
                    break;
            }
        }
        b(aVar, aVar2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void a(android.view.ViewGroup r21, androidx.i.t r22, androidx.i.t r23, java.util.ArrayList<androidx.i.s> r24, java.util.ArrayList<androidx.i.s> r25) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.i.m.a(android.view.ViewGroup, androidx.i.t, androidx.i.t, java.util.ArrayList, java.util.ArrayList):void");
    }

    boolean a(View view) {
        int id = view.getId();
        if (this.o != null && this.o.contains(Integer.valueOf(id))) {
            return false;
        }
        if (this.p != null && this.p.contains(view)) {
            return false;
        }
        if (this.q != null) {
            int size = this.q.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.q.get(i2).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.r != null && androidx.core.g.q.n(view) != null && this.r.contains(androidx.core.g.q.n(view))) {
            return false;
        }
        if ((this.f848b.size() == 0 && this.c.size() == 0 && ((this.n == null || this.n.isEmpty()) && (this.m == null || this.m.isEmpty()))) || this.f848b.contains(Integer.valueOf(id)) || this.c.contains(view)) {
            return true;
        }
        if (this.m != null && this.m.contains(androidx.core.g.q.n(view))) {
            return true;
        }
        if (this.n != null) {
            for (int i3 = 0; i3 < this.n.size(); i3++) {
                if (this.n.get(i3).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static androidx.b.a<Animator, a> q() {
        androidx.b.a<Animator, a> aVar = A.get();
        if (aVar != null) {
            return aVar;
        }
        androidx.b.a<Animator, a> aVar2 = new androidx.b.a<>();
        A.set(aVar2);
        return aVar2;
    }

    protected void e() {
        j();
        androidx.b.a<Animator, a> aVarQ = q();
        Iterator<Animator> it = this.G.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (aVarQ.containsKey(next)) {
                j();
                a(next, aVarQ);
            }
        }
        this.G.clear();
        k();
    }

    private void a(Animator animator, final androidx.b.a<Animator, a> aVar) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.i.m.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    m.this.f.add(animator2);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    aVar.remove(animator2);
                    m.this.f.remove(animator2);
                }
            });
            a(animator);
        }
    }

    public m b(View view) {
        this.c.add(view);
        return this;
    }

    public m c(View view) {
        this.c.remove(view);
        return this;
    }

    public List<Integer> f() {
        return this.f848b;
    }

    public List<View> g() {
        return this.c;
    }

    public List<String> h() {
        return this.m;
    }

    public List<Class> i() {
        return this.n;
    }

    void a(ViewGroup viewGroup, boolean z) {
        a(z);
        if ((this.f848b.size() > 0 || this.c.size() > 0) && ((this.m == null || this.m.isEmpty()) && (this.n == null || this.n.isEmpty()))) {
            for (int i2 = 0; i2 < this.f848b.size(); i2++) {
                View viewFindViewById = viewGroup.findViewById(this.f848b.get(i2).intValue());
                if (viewFindViewById != null) {
                    s sVar = new s();
                    sVar.f866b = viewFindViewById;
                    if (z) {
                        a(sVar);
                    } else {
                        b(sVar);
                    }
                    sVar.c.add(this);
                    c(sVar);
                    if (z) {
                        a(this.v, viewFindViewById, sVar);
                    } else {
                        a(this.w, viewFindViewById, sVar);
                    }
                }
            }
            for (int i3 = 0; i3 < this.c.size(); i3++) {
                View view = this.c.get(i3);
                s sVar2 = new s();
                sVar2.f866b = view;
                if (z) {
                    a(sVar2);
                } else {
                    b(sVar2);
                }
                sVar2.c.add(this);
                c(sVar2);
                if (z) {
                    a(this.v, view, sVar2);
                } else {
                    a(this.w, view, sVar2);
                }
            }
        } else {
            c(viewGroup, z);
        }
        if (z || this.I == null) {
            return;
        }
        int size = this.I.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i4 = 0; i4 < size; i4++) {
            arrayList.add(this.v.d.remove(this.I.b(i4)));
        }
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = (View) arrayList.get(i5);
            if (view2 != null) {
                this.v.d.put(this.I.c(i5), view2);
            }
        }
    }

    private static void a(t tVar, View view, s sVar) {
        tVar.f867a.put(view, sVar);
        int id = view.getId();
        if (id >= 0) {
            if (tVar.f868b.indexOfKey(id) >= 0) {
                tVar.f868b.put(id, null);
            } else {
                tVar.f868b.put(id, view);
            }
        }
        String strN = androidx.core.g.q.n(view);
        if (strN != null) {
            if (tVar.d.containsKey(strN)) {
                tVar.d.put(strN, null);
            } else {
                tVar.d.put(strN, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (tVar.c.c(itemIdAtPosition) >= 0) {
                    View viewA = tVar.c.a(itemIdAtPosition);
                    if (viewA != null) {
                        androidx.core.g.q.a(viewA, false);
                        tVar.c.b(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                androidx.core.g.q.a(view, true);
                tVar.c.b(itemIdAtPosition, view);
            }
        }
    }

    void a(boolean z) {
        if (z) {
            this.v.f867a.clear();
            this.v.f868b.clear();
            this.v.c.c();
        } else {
            this.w.f867a.clear();
            this.w.f868b.clear();
            this.w.c.c();
        }
    }

    private void c(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        if (this.o == null || !this.o.contains(Integer.valueOf(id))) {
            if (this.p == null || !this.p.contains(view)) {
                if (this.q != null) {
                    int size = this.q.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.q.get(i2).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    s sVar = new s();
                    sVar.f866b = view;
                    if (z) {
                        a(sVar);
                    } else {
                        b(sVar);
                    }
                    sVar.c.add(this);
                    c(sVar);
                    if (z) {
                        a(this.v, view, sVar);
                    } else {
                        a(this.w, view, sVar);
                    }
                }
                if (view instanceof ViewGroup) {
                    if (this.s == null || !this.s.contains(Integer.valueOf(id))) {
                        if (this.t == null || !this.t.contains(view)) {
                            if (this.u != null) {
                                int size2 = this.u.size();
                                for (int i3 = 0; i3 < size2; i3++) {
                                    if (this.u.get(i3).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                                c(viewGroup.getChildAt(i4), z);
                            }
                        }
                    }
                }
            }
        }
    }

    public s a(View view, boolean z) {
        if (this.d != null) {
            return this.d.a(view, z);
        }
        return (z ? this.v : this.w).f867a.get(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0030, code lost:
    
        if (r3 < 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0032, code lost:
    
        if (r8 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0034, code lost:
    
        r7 = r6.z;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0037, code lost:
    
        r7 = r6.y;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0040, code lost:
    
        return r7.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.i.s b(android.view.View r7, boolean r8) {
        /*
            r6 = this;
            androidx.i.q r0 = r6.d
            if (r0 == 0) goto Lb
            androidx.i.q r0 = r6.d
            androidx.i.s r7 = r0.b(r7, r8)
            return r7
        Lb:
            if (r8 == 0) goto L10
            java.util.ArrayList<androidx.i.s> r0 = r6.y
            goto L12
        L10:
            java.util.ArrayList<androidx.i.s> r0 = r6.z
        L12:
            r1 = 0
            if (r0 != 0) goto L16
            return r1
        L16:
            int r2 = r0.size()
            r3 = -1
            r4 = 0
        L1c:
            if (r4 >= r2) goto L30
            java.lang.Object r5 = r0.get(r4)
            androidx.i.s r5 = (androidx.i.s) r5
            if (r5 != 0) goto L27
            return r1
        L27:
            android.view.View r5 = r5.f866b
            if (r5 != r7) goto L2d
            r3 = r4
            goto L30
        L2d:
            int r4 = r4 + 1
            goto L1c
        L30:
            if (r3 < 0) goto L40
            if (r8 == 0) goto L37
            java.util.ArrayList<androidx.i.s> r7 = r6.z
            goto L39
        L37:
            java.util.ArrayList<androidx.i.s> r7 = r6.y
        L39:
            java.lang.Object r7 = r7.get(r3)
            r1 = r7
            androidx.i.s r1 = (androidx.i.s) r1
        L40:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.i.m.b(android.view.View, boolean):androidx.i.s");
    }

    public void d(View view) {
        if (this.E) {
            return;
        }
        androidx.b.a<Animator, a> aVarQ = q();
        int size = aVarQ.size();
        al alVarB = ad.b(view);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            a aVarC = aVarQ.c(i2);
            if (aVarC.f852a != null && alVarB.equals(aVarC.d)) {
                androidx.i.a.a(aVarQ.b(i2));
            }
        }
        if (this.F != null && this.F.size() > 0) {
            ArrayList arrayList = (ArrayList) this.F.clone();
            int size2 = arrayList.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ((c) arrayList.get(i3)).b(this);
            }
        }
        this.D = true;
    }

    public void e(View view) {
        if (this.D) {
            if (!this.E) {
                androidx.b.a<Animator, a> aVarQ = q();
                int size = aVarQ.size();
                al alVarB = ad.b(view);
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    a aVarC = aVarQ.c(i2);
                    if (aVarC.f852a != null && alVarB.equals(aVarC.d)) {
                        androidx.i.a.b(aVarQ.b(i2));
                    }
                }
                if (this.F != null && this.F.size() > 0) {
                    ArrayList arrayList = (ArrayList) this.F.clone();
                    int size2 = arrayList.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        ((c) arrayList.get(i3)).c(this);
                    }
                }
            }
            this.D = false;
        }
    }

    void a(ViewGroup viewGroup) {
        a aVar;
        this.y = new ArrayList<>();
        this.z = new ArrayList<>();
        a(this.v, this.w);
        androidx.b.a<Animator, a> aVarQ = q();
        int size = aVarQ.size();
        al alVarB = ad.b(viewGroup);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            Animator animatorB = aVarQ.b(i2);
            if (animatorB != null && (aVar = aVarQ.get(animatorB)) != null && aVar.f852a != null && alVarB.equals(aVar.d)) {
                s sVar = aVar.c;
                View view = aVar.f852a;
                s sVarA = a(view, true);
                s sVarB = b(view, true);
                if (!(sVarA == null && sVarB == null) && aVar.e.a(sVar, sVarB)) {
                    if (animatorB.isRunning() || animatorB.isStarted()) {
                        animatorB.cancel();
                    } else {
                        aVarQ.remove(animatorB);
                    }
                }
            }
        }
        a(viewGroup, this.v, this.w, this.y, this.z);
        e();
    }

    public boolean a(s sVar, s sVar2) {
        if (sVar == null || sVar2 == null) {
            return false;
        }
        String[] strArrA = a();
        if (strArrA != null) {
            for (String str : strArrA) {
                if (!a(sVar, sVar2, str)) {
                }
            }
            return false;
        }
        Iterator<String> it = sVar.f865a.keySet().iterator();
        while (it.hasNext()) {
            if (a(sVar, sVar2, it.next())) {
            }
        }
        return false;
        return true;
    }

    private static boolean a(s sVar, s sVar2, String str) {
        Object obj = sVar.f865a.get(str);
        Object obj2 = sVar2.f865a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    protected void a(Animator animator) {
        if (animator == null) {
            k();
            return;
        }
        if (b() >= 0) {
            animator.setDuration(b());
        }
        if (c() >= 0) {
            animator.setStartDelay(c());
        }
        if (d() != null) {
            animator.setInterpolator(d());
        }
        animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.i.m.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                m.this.k();
                animator2.removeListener(this);
            }
        });
        animator.start();
    }

    protected void j() {
        if (this.C == 0) {
            if (this.F != null && this.F.size() > 0) {
                ArrayList arrayList = (ArrayList) this.F.clone();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((c) arrayList.get(i2)).d(this);
                }
            }
            this.E = false;
        }
        this.C++;
    }

    protected void k() {
        this.C--;
        if (this.C == 0) {
            if (this.F != null && this.F.size() > 0) {
                ArrayList arrayList = (ArrayList) this.F.clone();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((c) arrayList.get(i2)).a(this);
                }
            }
            for (int i3 = 0; i3 < this.v.c.b(); i3++) {
                View viewC = this.v.c.c(i3);
                if (viewC != null) {
                    androidx.core.g.q.a(viewC, false);
                }
            }
            for (int i4 = 0; i4 < this.w.c.b(); i4++) {
                View viewC2 = this.w.c.c(i4);
                if (viewC2 != null) {
                    androidx.core.g.q.a(viewC2, false);
                }
            }
            this.E = true;
        }
    }

    public m a(c cVar) {
        if (this.F == null) {
            this.F = new ArrayList<>();
        }
        this.F.add(cVar);
        return this;
    }

    public m b(c cVar) {
        if (this.F == null) {
            return this;
        }
        this.F.remove(cVar);
        if (this.F.size() == 0) {
            this.F = null;
        }
        return this;
    }

    public void a(g gVar) {
        if (gVar == null) {
            this.J = i;
        } else {
            this.J = gVar;
        }
    }

    public g l() {
        return this.J;
    }

    public void a(b bVar) {
        this.H = bVar;
    }

    public b m() {
        return this.H;
    }

    public void a(p pVar) {
        this.g = pVar;
    }

    public p n() {
        return this.g;
    }

    void c(s sVar) {
        String[] strArrA;
        if (this.g == null || sVar.f865a.isEmpty() || (strArrA = this.g.a()) == null) {
            return;
        }
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= strArrA.length) {
                z = true;
                break;
            } else if (!sVar.f865a.containsKey(strArrA[i2])) {
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            return;
        }
        this.g.a(sVar);
    }

    public String toString() {
        return a(BuildConfig.FLAVOR);
    }

    @Override // 
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public m clone() {
        try {
            m mVar = (m) super.clone();
            mVar.G = new ArrayList<>();
            mVar.v = new t();
            mVar.w = new t();
            mVar.y = null;
            mVar.z = null;
            return mVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String p() {
        return this.j;
    }

    String a(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f847a != -1) {
            str2 = str2 + "dur(" + this.f847a + ") ";
        }
        if (this.k != -1) {
            str2 = str2 + "dly(" + this.k + ") ";
        }
        if (this.l != null) {
            str2 = str2 + "interp(" + this.l + ") ";
        }
        if (this.f848b.size() <= 0 && this.c.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f848b.size() > 0) {
            String str4 = str3;
            for (int i2 = 0; i2 < this.f848b.size(); i2++) {
                if (i2 > 0) {
                    str4 = str4 + ", ";
                }
                str4 = str4 + this.f848b.get(i2);
            }
            str3 = str4;
        }
        if (this.c.size() > 0) {
            for (int i3 = 0; i3 < this.c.size(); i3++) {
                if (i3 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.c.get(i3);
            }
        }
        return str3 + ")";
    }

    /* compiled from: Transition.java */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        View f852a;

        /* renamed from: b, reason: collision with root package name */
        String f853b;
        s c;
        al d;
        m e;

        a(View view, String str, m mVar, al alVar, s sVar) {
            this.f852a = view;
            this.f853b = str;
            this.c = sVar;
            this.d = alVar;
            this.e = mVar;
        }
    }
}
