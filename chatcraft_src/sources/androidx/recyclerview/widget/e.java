package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DefaultItemAnimator.java */
/* loaded from: classes.dex */
public class e extends o {
    private static TimeInterpolator i;
    private ArrayList<RecyclerView.x> j = new ArrayList<>();
    private ArrayList<RecyclerView.x> k = new ArrayList<>();
    private ArrayList<b> l = new ArrayList<>();
    private ArrayList<a> m = new ArrayList<>();

    /* renamed from: a, reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.x>> f1080a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    ArrayList<ArrayList<b>> f1081b = new ArrayList<>();
    ArrayList<ArrayList<a>> c = new ArrayList<>();
    ArrayList<RecyclerView.x> d = new ArrayList<>();
    ArrayList<RecyclerView.x> e = new ArrayList<>();
    ArrayList<RecyclerView.x> f = new ArrayList<>();
    ArrayList<RecyclerView.x> g = new ArrayList<>();

    /* compiled from: DefaultItemAnimator.java */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.x f1100a;

        /* renamed from: b, reason: collision with root package name */
        public int f1101b;
        public int c;
        public int d;
        public int e;

        b(RecyclerView.x xVar, int i, int i2, int i3, int i4) {
            this.f1100a = xVar;
            this.f1101b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.x f1098a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.x f1099b;
        public int c;
        public int d;
        public int e;
        public int f;

        private a(RecyclerView.x xVar, RecyclerView.x xVar2) {
            this.f1098a = xVar;
            this.f1099b = xVar2;
        }

        a(RecyclerView.x xVar, RecyclerView.x xVar2, int i, int i2, int i3, int i4) {
            this(xVar, xVar2);
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f1098a + ", newHolder=" + this.f1099b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public void a() {
        boolean z = !this.j.isEmpty();
        boolean z2 = !this.l.isEmpty();
        boolean z3 = !this.m.isEmpty();
        boolean z4 = !this.k.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.x> it = this.j.iterator();
            while (it.hasNext()) {
                u(it.next());
            }
            this.j.clear();
            if (z2) {
                final ArrayList<b> arrayList = new ArrayList<>();
                arrayList.addAll(this.l);
                this.f1081b.add(arrayList);
                this.l.clear();
                Runnable runnable = new Runnable() { // from class: androidx.recyclerview.widget.e.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            b bVar = (b) it2.next();
                            e.this.b(bVar.f1100a, bVar.f1101b, bVar.c, bVar.d, bVar.e);
                        }
                        arrayList.clear();
                        e.this.f1081b.remove(arrayList);
                    }
                };
                if (z) {
                    androidx.core.g.q.a(arrayList.get(0).f1100a.f1052a, runnable, g());
                } else {
                    runnable.run();
                }
            }
            if (z3) {
                final ArrayList<a> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.m);
                this.c.add(arrayList2);
                this.m.clear();
                Runnable runnable2 = new Runnable() { // from class: androidx.recyclerview.widget.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            e.this.a((a) it2.next());
                        }
                        arrayList2.clear();
                        e.this.c.remove(arrayList2);
                    }
                };
                if (z) {
                    androidx.core.g.q.a(arrayList2.get(0).f1098a.f1052a, runnable2, g());
                } else {
                    runnable2.run();
                }
            }
            if (z4) {
                final ArrayList<RecyclerView.x> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.k);
                this.f1080a.add(arrayList3);
                this.k.clear();
                Runnable runnable3 = new Runnable() { // from class: androidx.recyclerview.widget.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            e.this.c((RecyclerView.x) it2.next());
                        }
                        arrayList3.clear();
                        e.this.f1080a.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    androidx.core.g.q.a(arrayList3.get(0).f1052a, runnable3, (z ? g() : 0L) + Math.max(z2 ? e() : 0L, z3 ? h() : 0L));
                } else {
                    runnable3.run();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.o
    public boolean a(RecyclerView.x xVar) {
        v(xVar);
        this.j.add(xVar);
        return true;
    }

    private void u(final RecyclerView.x xVar) {
        final View view = xVar.f1052a;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f.add(xVar);
        viewPropertyAnimatorAnimate.setDuration(g()).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.e.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.l(xVar);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                view.setAlpha(1.0f);
                e.this.i(xVar);
                e.this.f.remove(xVar);
                e.this.c();
            }
        }).start();
    }

    @Override // androidx.recyclerview.widget.o
    public boolean b(RecyclerView.x xVar) {
        v(xVar);
        xVar.f1052a.setAlpha(0.0f);
        this.k.add(xVar);
        return true;
    }

    void c(final RecyclerView.x xVar) {
        final View view = xVar.f1052a;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.d.add(xVar);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(f()).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.e.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.n(xVar);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                e.this.k(xVar);
                e.this.d.remove(xVar);
                e.this.c();
            }
        }).start();
    }

    @Override // androidx.recyclerview.widget.o
    public boolean a(RecyclerView.x xVar, int i2, int i3, int i4, int i5) {
        View view = xVar.f1052a;
        int translationX = i2 + ((int) xVar.f1052a.getTranslationX());
        int translationY = i3 + ((int) xVar.f1052a.getTranslationY());
        v(xVar);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            j(xVar);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX(-i6);
        }
        if (i7 != 0) {
            view.setTranslationY(-i7);
        }
        this.l.add(new b(xVar, translationX, translationY, i4, i5));
        return true;
    }

    void b(final RecyclerView.x xVar, int i2, int i3, int i4, int i5) {
        final View view = xVar.f1052a;
        final int i6 = i4 - i2;
        final int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.e.add(xVar);
        viewPropertyAnimatorAnimate.setDuration(e()).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.e.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.m(xVar);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (i6 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i7 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                e.this.j(xVar);
                e.this.e.remove(xVar);
                e.this.c();
            }
        }).start();
    }

    @Override // androidx.recyclerview.widget.o
    public boolean a(RecyclerView.x xVar, RecyclerView.x xVar2, int i2, int i3, int i4, int i5) {
        if (xVar == xVar2) {
            return a(xVar, i2, i3, i4, i5);
        }
        float translationX = xVar.f1052a.getTranslationX();
        float translationY = xVar.f1052a.getTranslationY();
        float alpha = xVar.f1052a.getAlpha();
        v(xVar);
        int i6 = (int) ((i4 - i2) - translationX);
        int i7 = (int) ((i5 - i3) - translationY);
        xVar.f1052a.setTranslationX(translationX);
        xVar.f1052a.setTranslationY(translationY);
        xVar.f1052a.setAlpha(alpha);
        if (xVar2 != null) {
            v(xVar2);
            xVar2.f1052a.setTranslationX(-i6);
            xVar2.f1052a.setTranslationY(-i7);
            xVar2.f1052a.setAlpha(0.0f);
        }
        this.m.add(new a(xVar, xVar2, i2, i3, i4, i5));
        return true;
    }

    void a(final a aVar) {
        RecyclerView.x xVar = aVar.f1098a;
        final View view = xVar == null ? null : xVar.f1052a;
        RecyclerView.x xVar2 = aVar.f1099b;
        final View view2 = xVar2 != null ? xVar2.f1052a : null;
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(h());
            this.g.add(aVar.f1098a);
            duration.translationX(aVar.e - aVar.c);
            duration.translationY(aVar.f - aVar.d);
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.e.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.b(aVar.f1098a, true);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    e.this.a(aVar.f1098a, true);
                    e.this.g.remove(aVar.f1098a);
                    e.this.c();
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.g.add(aVar.f1099b);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(h()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.e.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    e.this.b(aVar.f1099b, false);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorAnimate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    e.this.a(aVar.f1099b, false);
                    e.this.g.remove(aVar.f1099b);
                    e.this.c();
                }
            }).start();
        }
    }

    private void a(List<a> list, RecyclerView.x xVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = list.get(size);
            if (a(aVar, xVar) && aVar.f1098a == null && aVar.f1099b == null) {
                list.remove(aVar);
            }
        }
    }

    private void b(a aVar) {
        if (aVar.f1098a != null) {
            a(aVar, aVar.f1098a);
        }
        if (aVar.f1099b != null) {
            a(aVar, aVar.f1099b);
        }
    }

    private boolean a(a aVar, RecyclerView.x xVar) {
        boolean z = false;
        if (aVar.f1099b == xVar) {
            aVar.f1099b = null;
        } else {
            if (aVar.f1098a != xVar) {
                return false;
            }
            aVar.f1098a = null;
            z = true;
        }
        xVar.f1052a.setAlpha(1.0f);
        xVar.f1052a.setTranslationX(0.0f);
        xVar.f1052a.setTranslationY(0.0f);
        a(xVar, z);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public void d(RecyclerView.x xVar) {
        View view = xVar.f1052a;
        view.animate().cancel();
        int size = this.l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.l.get(size).f1100a == xVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                j(xVar);
                this.l.remove(size);
            }
        }
        a(this.m, xVar);
        if (this.j.remove(xVar)) {
            view.setAlpha(1.0f);
            i(xVar);
        }
        if (this.k.remove(xVar)) {
            view.setAlpha(1.0f);
            k(xVar);
        }
        for (int size2 = this.c.size() - 1; size2 >= 0; size2--) {
            ArrayList<a> arrayList = this.c.get(size2);
            a(arrayList, xVar);
            if (arrayList.isEmpty()) {
                this.c.remove(size2);
            }
        }
        for (int size3 = this.f1081b.size() - 1; size3 >= 0; size3--) {
            ArrayList<b> arrayList2 = this.f1081b.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).f1100a == xVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    j(xVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f1081b.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f1080a.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.x> arrayList3 = this.f1080a.get(size5);
            if (arrayList3.remove(xVar)) {
                view.setAlpha(1.0f);
                k(xVar);
                if (arrayList3.isEmpty()) {
                    this.f1080a.remove(size5);
                }
            }
        }
        this.f.remove(xVar);
        this.d.remove(xVar);
        this.g.remove(xVar);
        this.e.remove(xVar);
        c();
    }

    private void v(RecyclerView.x xVar) {
        if (i == null) {
            i = new ValueAnimator().getInterpolator();
        }
        xVar.f1052a.animate().setInterpolator(i);
        d(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean b() {
        return (this.k.isEmpty() && this.m.isEmpty() && this.l.isEmpty() && this.j.isEmpty() && this.e.isEmpty() && this.f.isEmpty() && this.d.isEmpty() && this.g.isEmpty() && this.f1081b.isEmpty() && this.f1080a.isEmpty() && this.c.isEmpty()) ? false : true;
    }

    void c() {
        if (b()) {
            return;
        }
        i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public void d() {
        int size = this.l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            b bVar = this.l.get(size);
            View view = bVar.f1100a.f1052a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            j(bVar.f1100a);
            this.l.remove(size);
        }
        for (int size2 = this.j.size() - 1; size2 >= 0; size2--) {
            i(this.j.get(size2));
            this.j.remove(size2);
        }
        int size3 = this.k.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.x xVar = this.k.get(size3);
            xVar.f1052a.setAlpha(1.0f);
            k(xVar);
            this.k.remove(size3);
        }
        for (int size4 = this.m.size() - 1; size4 >= 0; size4--) {
            b(this.m.get(size4));
        }
        this.m.clear();
        if (b()) {
            for (int size5 = this.f1081b.size() - 1; size5 >= 0; size5--) {
                ArrayList<b> arrayList = this.f1081b.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    b bVar2 = arrayList.get(size6);
                    View view2 = bVar2.f1100a.f1052a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    j(bVar2.f1100a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f1081b.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f1080a.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.x> arrayList2 = this.f1080a.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.x xVar2 = arrayList2.get(size8);
                    xVar2.f1052a.setAlpha(1.0f);
                    k(xVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f1080a.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.c.size() - 1; size9 >= 0; size9--) {
                ArrayList<a> arrayList3 = this.c.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    b(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.c.remove(arrayList3);
                    }
                }
            }
            a(this.f);
            a(this.e);
            a(this.d);
            a(this.g);
            i();
        }
    }

    void a(List<RecyclerView.x> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).f1052a.animate().cancel();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean a(RecyclerView.x xVar, List<Object> list) {
        return !list.isEmpty() || super.a(xVar, list);
    }
}
