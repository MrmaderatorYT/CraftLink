package androidx.i;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TransitionManager.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: b, reason: collision with root package name */
    private static m f855b = new b();
    private static ThreadLocal<WeakReference<androidx.b.a<ViewGroup, ArrayList<m>>>> c = new ThreadLocal<>();

    /* renamed from: a, reason: collision with root package name */
    static ArrayList<ViewGroup> f854a = new ArrayList<>();

    static androidx.b.a<ViewGroup, ArrayList<m>> a() {
        androidx.b.a<ViewGroup, ArrayList<m>> aVar;
        WeakReference<androidx.b.a<ViewGroup, ArrayList<m>>> weakReference = c.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        androidx.b.a<ViewGroup, ArrayList<m>> aVar2 = new androidx.b.a<>();
        c.set(new WeakReference<>(aVar2));
        return aVar2;
    }

    private static void b(ViewGroup viewGroup, m mVar) {
        if (mVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(mVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    /* compiled from: TransitionManager.java */
    private static class a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a, reason: collision with root package name */
        m f856a;

        /* renamed from: b, reason: collision with root package name */
        ViewGroup f857b;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        a(m mVar, ViewGroup viewGroup) {
            this.f856a = mVar;
            this.f857b = viewGroup;
        }

        private void a() {
            this.f857b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f857b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            o.f854a.remove(this.f857b);
            ArrayList<m> arrayList = o.a().get(this.f857b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<m> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().e(this.f857b);
                }
            }
            this.f856a.a(true);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!o.f854a.remove(this.f857b)) {
                return true;
            }
            final androidx.b.a<ViewGroup, ArrayList<m>> aVarA = o.a();
            ArrayList<m> arrayList = aVarA.get(this.f857b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                aVarA.put(this.f857b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f856a);
            this.f856a.a(new n() { // from class: androidx.i.o.a.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // androidx.i.n, androidx.i.m.c
                public void a(m mVar) {
                    ((ArrayList) aVarA.get(a.this.f857b)).remove(mVar);
                }
            });
            this.f856a.a(this.f857b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((m) it.next()).e(this.f857b);
                }
            }
            this.f856a.a(this.f857b);
            return true;
        }
    }

    private static void c(ViewGroup viewGroup, m mVar) {
        ArrayList<m> arrayList = a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<m> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().d(viewGroup);
            }
        }
        if (mVar != null) {
            mVar.a(viewGroup, true);
        }
        l lVarA = l.a(viewGroup);
        if (lVarA != null) {
            lVarA.a();
        }
    }

    public static void a(ViewGroup viewGroup, m mVar) {
        if (f854a.contains(viewGroup) || !androidx.core.g.q.x(viewGroup)) {
            return;
        }
        f854a.add(viewGroup);
        if (mVar == null) {
            mVar = f855b;
        }
        m mVarClone = mVar.clone();
        c(viewGroup, mVarClone);
        l.a(viewGroup, null);
        b(viewGroup, mVarClone);
    }
}
