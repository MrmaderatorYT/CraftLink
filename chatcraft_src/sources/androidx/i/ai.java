package androidx.i;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.i.a;
import androidx.i.m;
import java.lang.reflect.InvocationTargetException;

/* compiled from: Visibility.java */
/* loaded from: classes.dex */
public abstract class ai extends m {
    private static final String[] h = {"android:visibility:visibility", "android:visibility:parent"};
    private int i = 3;

    public Animator a(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        return null;
    }

    public Animator b(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        return null;
    }

    /* compiled from: Visibility.java */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        boolean f815a;

        /* renamed from: b, reason: collision with root package name */
        boolean f816b;
        int c;
        int d;
        ViewGroup e;
        ViewGroup f;

        b() {
        }
    }

    public void a(int i) {
        if ((i & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.i = i;
    }

    @Override // androidx.i.m
    public String[] a() {
        return h;
    }

    private void d(s sVar) {
        sVar.f865a.put("android:visibility:visibility", Integer.valueOf(sVar.f866b.getVisibility()));
        sVar.f865a.put("android:visibility:parent", sVar.f866b.getParent());
        int[] iArr = new int[2];
        sVar.f866b.getLocationOnScreen(iArr);
        sVar.f865a.put("android:visibility:screenLocation", iArr);
    }

    @Override // androidx.i.m
    public void a(s sVar) {
        d(sVar);
    }

    @Override // androidx.i.m
    public void b(s sVar) {
        d(sVar);
    }

    private b b(s sVar, s sVar2) {
        b bVar = new b();
        bVar.f815a = false;
        bVar.f816b = false;
        if (sVar != null && sVar.f865a.containsKey("android:visibility:visibility")) {
            bVar.c = ((Integer) sVar.f865a.get("android:visibility:visibility")).intValue();
            bVar.e = (ViewGroup) sVar.f865a.get("android:visibility:parent");
        } else {
            bVar.c = -1;
            bVar.e = null;
        }
        if (sVar2 != null && sVar2.f865a.containsKey("android:visibility:visibility")) {
            bVar.d = ((Integer) sVar2.f865a.get("android:visibility:visibility")).intValue();
            bVar.f = (ViewGroup) sVar2.f865a.get("android:visibility:parent");
        } else {
            bVar.d = -1;
            bVar.f = null;
        }
        if (sVar != null && sVar2 != null) {
            if (bVar.c == bVar.d && bVar.e == bVar.f) {
                return bVar;
            }
            if (bVar.c != bVar.d) {
                if (bVar.c == 0) {
                    bVar.f816b = false;
                    bVar.f815a = true;
                } else if (bVar.d == 0) {
                    bVar.f816b = true;
                    bVar.f815a = true;
                }
            } else if (bVar.f == null) {
                bVar.f816b = false;
                bVar.f815a = true;
            } else if (bVar.e == null) {
                bVar.f816b = true;
                bVar.f815a = true;
            }
        } else if (sVar == null && bVar.d == 0) {
            bVar.f816b = true;
            bVar.f815a = true;
        } else if (sVar2 == null && bVar.c == 0) {
            bVar.f816b = false;
            bVar.f815a = true;
        }
        return bVar;
    }

    @Override // androidx.i.m
    public Animator a(ViewGroup viewGroup, s sVar, s sVar2) {
        b bVarB = b(sVar, sVar2);
        if (!bVarB.f815a) {
            return null;
        }
        if (bVarB.e == null && bVarB.f == null) {
            return null;
        }
        if (bVarB.f816b) {
            return a(viewGroup, sVar, bVarB.c, sVar2, bVarB.d);
        }
        return b(viewGroup, sVar, bVarB.c, sVar2, bVarB.d);
    }

    public Animator a(ViewGroup viewGroup, s sVar, int i, s sVar2, int i2) {
        if ((this.i & 1) != 1 || sVar2 == null) {
            return null;
        }
        if (sVar == null) {
            View view = (View) sVar2.f866b.getParent();
            if (b(b(view, false), a(view, false)).f815a) {
                return null;
            }
        }
        return a(viewGroup, sVar2.f866b, sVar, sVar2);
    }

    public Animator b(ViewGroup viewGroup, s sVar, int i, s sVar2, int i2) throws IllegalAccessException, IllegalArgumentException {
        int id;
        if ((this.i & 2) != 2) {
            return null;
        }
        final View viewA = sVar != null ? sVar.f866b : null;
        View view = sVar2 != null ? sVar2.f866b : null;
        if (view == null || view.getParent() == null) {
            if (view != null) {
                viewA = view;
            } else {
                if (viewA != null) {
                    if (viewA.getParent() != null) {
                        if (viewA.getParent() instanceof View) {
                            View view2 = (View) viewA.getParent();
                            if (!b(a(view2, true), b(view2, true)).f815a) {
                                viewA = r.a(viewGroup, viewA, view2);
                            } else if (view2.getParent() != null || (id = view2.getId()) == -1 || viewGroup.findViewById(id) == null || !this.e) {
                                viewA = null;
                            }
                        }
                    }
                }
                viewA = null;
                view = null;
            }
            view = null;
        } else if (i2 == 4 || viewA == view) {
            viewA = null;
        } else {
            if (!this.e) {
                viewA = r.a(viewGroup, viewA, (View) viewA.getParent());
            }
            view = null;
        }
        if (viewA == null || sVar == null) {
            if (view == null) {
                return null;
            }
            int visibility = view.getVisibility();
            ad.a(view, 0);
            Animator animatorB = b(viewGroup, view, sVar, sVar2);
            if (animatorB != null) {
                a aVar = new a(view, i2, true);
                animatorB.addListener(aVar);
                androidx.i.a.a(animatorB, aVar);
                a(aVar);
            } else {
                ad.a(view, visibility);
            }
            return animatorB;
        }
        int[] iArr = (int[]) sVar.f865a.get("android:visibility:screenLocation");
        int i3 = iArr[0];
        int i4 = iArr[1];
        int[] iArr2 = new int[2];
        viewGroup.getLocationOnScreen(iArr2);
        viewA.offsetLeftAndRight((i3 - iArr2[0]) - viewA.getLeft());
        viewA.offsetTopAndBottom((i4 - iArr2[1]) - viewA.getTop());
        final w wVarA = x.a(viewGroup);
        wVarA.a(viewA);
        Animator animatorB2 = b(viewGroup, viewA, sVar, sVar2);
        if (animatorB2 == null) {
            wVarA.b(viewA);
        } else {
            animatorB2.addListener(new AnimatorListenerAdapter() { // from class: androidx.i.ai.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    wVarA.b(viewA);
                }
            });
        }
        return animatorB2;
    }

    @Override // androidx.i.m
    public boolean a(s sVar, s sVar2) {
        if (sVar == null && sVar2 == null) {
            return false;
        }
        if (sVar != null && sVar2 != null && sVar2.f865a.containsKey("android:visibility:visibility") != sVar.f865a.containsKey("android:visibility:visibility")) {
            return false;
        }
        b bVarB = b(sVar, sVar2);
        if (bVarB.f815a) {
            return bVarB.c == 0 || bVarB.d == 0;
        }
        return false;
    }

    /* compiled from: Visibility.java */
    private static class a extends AnimatorListenerAdapter implements a.InterfaceC0051a, m.c {

        /* renamed from: a, reason: collision with root package name */
        boolean f813a = false;

        /* renamed from: b, reason: collision with root package name */
        private final View f814b;
        private final int c;
        private final ViewGroup d;
        private final boolean e;
        private boolean f;

        @Override // androidx.i.m.c
        public void d(m mVar) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        a(View view, int i, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f814b = view;
            this.c = i;
            this.d = (ViewGroup) view.getParent();
            this.e = z;
            a(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.i.a.InterfaceC0051a
        public void onAnimationPause(Animator animator) throws IllegalAccessException, IllegalArgumentException {
            if (this.f813a) {
                return;
            }
            ad.a(this.f814b, this.c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.i.a.InterfaceC0051a
        public void onAnimationResume(Animator animator) throws IllegalAccessException, IllegalArgumentException {
            if (this.f813a) {
                return;
            }
            ad.a(this.f814b, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f813a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            a();
        }

        @Override // androidx.i.m.c
        public void a(m mVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            a();
            mVar.b(this);
        }

        @Override // androidx.i.m.c
        public void b(m mVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            a(false);
        }

        @Override // androidx.i.m.c
        public void c(m mVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            a(true);
        }

        private void a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (!this.f813a) {
                ad.a(this.f814b, this.c);
                if (this.d != null) {
                    this.d.invalidate();
                }
            }
            a(false);
        }

        private void a(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (!this.e || this.f == z || this.d == null) {
                return;
            }
            this.f = z;
            x.a(this.d, z);
        }
    }
}
