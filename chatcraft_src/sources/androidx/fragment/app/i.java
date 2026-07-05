package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: FragmentManager.java */
/* loaded from: classes.dex */
final class i extends androidx.fragment.app.h implements LayoutInflater.Factory2 {
    static final Interpolator F = new DecelerateInterpolator(2.5f);
    static final Interpolator G = new DecelerateInterpolator(1.5f);
    static final Interpolator H = new AccelerateInterpolator(2.5f);
    static final Interpolator I = new AccelerateInterpolator(1.5f);

    /* renamed from: a, reason: collision with root package name */
    static boolean f731a = false;
    static Field q;
    ArrayList<j> C;
    androidx.fragment.app.j D;

    /* renamed from: b, reason: collision with root package name */
    ArrayList<h> f732b;
    boolean c;
    SparseArray<Fragment> f;
    ArrayList<androidx.fragment.app.a> g;
    ArrayList<Fragment> h;
    ArrayList<androidx.fragment.app.a> i;
    ArrayList<Integer> j;
    ArrayList<h.b> k;
    androidx.fragment.app.g m;
    androidx.fragment.app.e n;
    Fragment o;
    Fragment p;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    String v;
    boolean w;
    ArrayList<androidx.fragment.app.a> x;
    ArrayList<Boolean> y;
    ArrayList<Fragment> z;
    int d = 0;
    final ArrayList<Fragment> e = new ArrayList<>();
    private final CopyOnWriteArrayList<f> J = new CopyOnWriteArrayList<>();
    int l = 0;
    Bundle A = null;
    SparseArray<Parcelable> B = null;
    Runnable E = new Runnable() { // from class: androidx.fragment.app.i.1
        @Override // java.lang.Runnable
        public void run() {
            i.this.g();
        }
    };

    /* compiled from: FragmentManager.java */
    private static final class f {

        /* renamed from: a, reason: collision with root package name */
        final h.a f749a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f750b;
    }

    /* compiled from: FragmentManager.java */
    static class g {

        /* renamed from: a, reason: collision with root package name */
        public static final int[] f751a = {R.attr.name, R.attr.id, R.attr.tag};
    }

    /* compiled from: FragmentManager.java */
    interface h {
        boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    public static int b(int i, boolean z) {
        if (i == 4097) {
            return z ? 1 : 2;
        }
        if (i == 4099) {
            return z ? 5 : 6;
        }
        if (i != 8194) {
            return -1;
        }
        return z ? 3 : 4;
    }

    public static int d(int i) {
        if (i == 4097) {
            return 8194;
        }
        if (i != 4099) {
            return i != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    LayoutInflater.Factory2 x() {
        return this;
    }

    i() {
    }

    static boolean a(c cVar) {
        if (cVar.f744a instanceof AlphaAnimation) {
            return true;
        }
        if (cVar.f744a instanceof AnimationSet) {
            List<Animation> animations = ((AnimationSet) cVar.f744a).getAnimations();
            for (int i = 0; i < animations.size(); i++) {
                if (animations.get(i) instanceof AlphaAnimation) {
                    return true;
                }
            }
            return false;
        }
        return a(cVar.f745b);
    }

    static boolean a(Animator animator) {
        if (animator == null) {
            return false;
        }
        if (animator instanceof ValueAnimator) {
            for (PropertyValuesHolder propertyValuesHolder : ((ValueAnimator) animator).getValues()) {
                if ("alpha".equals(propertyValuesHolder.getPropertyName())) {
                    return true;
                }
            }
        } else if (animator instanceof AnimatorSet) {
            ArrayList<Animator> childAnimations = ((AnimatorSet) animator).getChildAnimations();
            for (int i = 0; i < childAnimations.size(); i++) {
                if (a(childAnimations.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean a(View view, c cVar) {
        return view != null && cVar != null && Build.VERSION.SDK_INT >= 19 && view.getLayerType() == 0 && androidx.core.g.q.r(view) && a(cVar);
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new androidx.core.f.b("FragmentManager"));
        if (this.m != null) {
            try {
                this.m.a("  ", (FileDescriptor) null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
                throw runtimeException;
            }
        }
        try {
            a("  ", (FileDescriptor) null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e3) {
            Log.e("FragmentManager", "Failed dumping state", e3);
            throw runtimeException;
        }
    }

    @Override // androidx.fragment.app.h
    public n a() {
        return new androidx.fragment.app.a(this);
    }

    @Override // androidx.fragment.app.h
    public boolean b() {
        y();
        return a((String) null, -1, 0);
    }

    @Override // androidx.fragment.app.h
    public void a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        a((h) new C0047i(null, i, i2), false);
    }

    private boolean a(String str, int i, int i2) {
        androidx.fragment.app.h hVarR;
        g();
        c(true);
        if (this.p != null && i < 0 && str == null && (hVarR = this.p.r()) != null && hVarR.b()) {
            return true;
        }
        boolean zA = a(this.x, this.y, str, i, i2);
        if (zA) {
            this.c = true;
            try {
                b(this.x, this.y);
            } finally {
                z();
            }
        }
        h();
        C();
        return zA;
    }

    @Override // androidx.fragment.app.h
    public void a(h.b bVar) {
        if (this.k == null) {
            this.k = new ArrayList<>();
        }
        this.k.add(bVar);
    }

    @Override // androidx.fragment.app.h
    public void a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.o < 0) {
            a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.o);
    }

    @Override // androidx.fragment.app.h
    public Fragment a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        Fragment fragment = this.f.get(i);
        if (fragment == null) {
            a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        return fragment;
    }

    @Override // androidx.fragment.app.h
    public List<Fragment> c() {
        List<Fragment> list;
        if (this.e.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.e) {
            list = (List) this.e.clone();
        }
        return list;
    }

    @Override // androidx.fragment.app.h
    public Fragment.c a(Fragment fragment) {
        Bundle bundleO;
        if (fragment.o < 0) {
            a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.k <= 0 || (bundleO = o(fragment)) == null) {
            return null;
        }
        return new Fragment.c(bundleO);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        if (this.o != null) {
            androidx.core.f.a.a(this.o, sb);
        } else {
            androidx.core.f.a.a(this.m, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    @Override // androidx.fragment.app.h
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        String str2 = str + "    ";
        if (this.f != null && (size5 = this.f.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i = 0; i < size5; i++) {
                Fragment fragmentValueAt = this.f.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragmentValueAt);
                if (fragmentValueAt != null) {
                    fragmentValueAt.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size6 = this.e.size();
        if (size6 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size6; i2++) {
                Fragment fragment = this.e.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        if (this.h != null && (size4 = this.h.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size4; i3++) {
                Fragment fragment2 = this.h.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        if (this.g != null && (size3 = this.g.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                androidx.fragment.app.a aVar = this.g.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.i != null && (size2 = this.i.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i5 = 0; i5 < size2; i5++) {
                    Object obj = (androidx.fragment.app.a) this.i.get(i5);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println(obj);
                }
            }
            if (this.j != null && this.j.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.j.toArray()));
            }
        }
        if (this.f732b != null && (size = this.f732b.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i6 = 0; i6 < size; i6++) {
                Object obj2 = (h) this.f732b.get(i6);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(obj2);
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.m);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.n);
        if (this.o != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.o);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.l);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.s);
        printWriter.print(" mStopped=");
        printWriter.print(this.t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.u);
        if (this.r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.r);
        }
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.v);
        }
    }

    static c a(Context context, float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(F);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(G);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new c(animationSet);
    }

    static c a(Context context, float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(G);
        alphaAnimation.setDuration(220L);
        return new c(alphaAnimation);
    }

    c a(Fragment fragment, int i, boolean z, int i2) throws Resources.NotFoundException {
        int iB;
        int iU = fragment.U();
        Animation animationA = fragment.a(i, z, iU);
        if (animationA != null) {
            return new c(animationA);
        }
        Animator animatorB = fragment.b(i, z, iU);
        if (animatorB != null) {
            return new c(animatorB);
        }
        if (iU != 0) {
            boolean zEquals = "anim".equals(this.m.g().getResources().getResourceTypeName(iU));
            boolean z2 = false;
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.m.g(), iU);
                    if (animationLoadAnimation != null) {
                        return new c(animationLoadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(this.m.g(), iU);
                    if (animatorLoadAnimator != null) {
                        return new c(animatorLoadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (zEquals) {
                        throw e3;
                    }
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(this.m.g(), iU);
                    if (animationLoadAnimation2 != null) {
                        return new c(animationLoadAnimation2);
                    }
                }
            }
        }
        if (i == 0 || (iB = b(i, z)) < 0) {
            return null;
        }
        switch (iB) {
            case 1:
                return a(this.m.g(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return a(this.m.g(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return a(this.m.g(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return a(this.m.g(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return a(this.m.g(), 0.0f, 1.0f);
            case 6:
                return a(this.m.g(), 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.m.d()) {
                    i2 = this.m.e();
                }
                return i2 == 0 ? null : null;
        }
    }

    public void b(Fragment fragment) {
        if (fragment.U) {
            if (this.c) {
                this.w = true;
            } else {
                fragment.U = false;
                a(fragment, this.l, 0, 0, false);
            }
        }
    }

    private static void b(View view, c cVar) {
        if (view == null || cVar == null || !a(view, cVar)) {
            return;
        }
        if (cVar.f745b != null) {
            cVar.f745b.addListener(new d(view));
            return;
        }
        Animation.AnimationListener animationListenerA = a(cVar.f744a);
        view.setLayerType(2, null);
        cVar.f744a.setAnimationListener(new a(view, animationListenerA));
    }

    private static Animation.AnimationListener a(Animation animation) {
        try {
            if (q == null) {
                q = Animation.class.getDeclaredField("mListener");
                q.setAccessible(true);
            }
            return (Animation.AnimationListener) q.get(animation);
        } catch (IllegalAccessException e2) {
            Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
            return null;
        } catch (NoSuchFieldException e3) {
            Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e3);
            return null;
        }
    }

    boolean a(int i) {
        return this.l >= i;
    }

    /* JADX WARN: Removed duplicated region for block: B:212:0x043d A[FALL_THROUGH, PHI: r11
      0x043d: PHI (r11v2 int) = (r11v1 int), (r11v1 int), (r11v1 int), (r11v1 int), (r11v1 int), (r11v1 int), (r11v1 int), (r11v3 int), (r11v3 int) binds: [B:139:0x02f2, B:141:0x02f6, B:184:0x03c7, B:206:0x0428, B:210:0x0432, B:209:0x042e, B:41:0x0068, B:133:0x02c8, B:137:0x02e4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:219:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void a(androidx.fragment.app.Fragment r15, int r16, int r17, int r18, boolean r19) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1162
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.i.a(androidx.fragment.app.Fragment, int, int, int, boolean):void");
    }

    private void a(final Fragment fragment, c cVar, int i) {
        final View view = fragment.S;
        final ViewGroup viewGroup = fragment.R;
        viewGroup.startViewTransition(view);
        fragment.c(i);
        if (cVar.f744a != null) {
            e eVar = new e(cVar.f744a, viewGroup, view);
            fragment.a(fragment.S);
            eVar.setAnimationListener(new b(a(eVar)) { // from class: androidx.fragment.app.i.2
                @Override // androidx.fragment.app.i.b, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    viewGroup.post(new Runnable() { // from class: androidx.fragment.app.i.2.1
                        @Override // java.lang.Runnable
                        public void run() throws Resources.NotFoundException {
                            if (fragment.Z() != null) {
                                fragment.a((View) null);
                                i.this.a(fragment, fragment.ab(), 0, 0, false);
                            }
                        }
                    });
                }
            });
            b(view, cVar);
            fragment.S.startAnimation(eVar);
            return;
        }
        Animator animator = cVar.f745b;
        fragment.a(cVar.f745b);
        animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.i.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) throws Resources.NotFoundException {
                viewGroup.endViewTransition(view);
                Animator animatorAa = fragment.aa();
                fragment.a((Animator) null);
                if (animatorAa == null || viewGroup.indexOfChild(view) >= 0) {
                    return;
                }
                i.this.a(fragment, fragment.ab(), 0, 0, false);
            }
        });
        animator.setTarget(fragment.S);
        b(fragment.S, cVar);
        animator.start();
    }

    void c(Fragment fragment) throws Resources.NotFoundException {
        a(fragment, this.l, 0, 0, false);
    }

    void d(Fragment fragment) {
        if (!fragment.w || fragment.z) {
            return;
        }
        fragment.b(fragment.h(fragment.l), (ViewGroup) null, fragment.l);
        if (fragment.S != null) {
            fragment.T = fragment.S;
            fragment.S.setSaveFromParentEnabled(false);
            if (fragment.K) {
                fragment.S.setVisibility(8);
            }
            fragment.a(fragment.S, fragment.l);
            a(fragment, fragment.S, fragment.l, false);
            return;
        }
        fragment.T = null;
    }

    void e(final Fragment fragment) throws Resources.NotFoundException {
        if (fragment.S != null) {
            c cVarA = a(fragment, fragment.V(), !fragment.K, fragment.W());
            if (cVarA != null && cVarA.f745b != null) {
                cVarA.f745b.setTarget(fragment.S);
                if (fragment.K) {
                    if (fragment.ad()) {
                        fragment.j(false);
                    } else {
                        final ViewGroup viewGroup = fragment.R;
                        final View view = fragment.S;
                        viewGroup.startViewTransition(view);
                        cVarA.f745b.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.i.4
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                viewGroup.endViewTransition(view);
                                animator.removeListener(this);
                                if (fragment.S != null) {
                                    fragment.S.setVisibility(8);
                                }
                            }
                        });
                    }
                } else {
                    fragment.S.setVisibility(0);
                }
                b(fragment.S, cVarA);
                cVarA.f745b.start();
            } else {
                if (cVarA != null) {
                    b(fragment.S, cVarA);
                    fragment.S.startAnimation(cVarA.f744a);
                    cVarA.f744a.start();
                }
                fragment.S.setVisibility((!fragment.K || fragment.ad()) ? 0 : 8);
                if (fragment.ad()) {
                    fragment.j(false);
                }
            }
        }
        if (fragment.u && fragment.O && fragment.P) {
            this.r = true;
        }
        fragment.Y = false;
        fragment.b(fragment.K);
    }

    void f(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        int iMin = this.l;
        if (fragment.v) {
            if (fragment.h()) {
                iMin = Math.min(iMin, 1);
            } else {
                iMin = Math.min(iMin, 0);
            }
        }
        a(fragment, iMin, fragment.V(), fragment.W(), false);
        if (fragment.S != null) {
            Fragment fragmentQ = q(fragment);
            if (fragmentQ != null) {
                View view = fragmentQ.S;
                ViewGroup viewGroup = fragment.R;
                int iIndexOfChild = viewGroup.indexOfChild(view);
                int iIndexOfChild2 = viewGroup.indexOfChild(fragment.S);
                if (iIndexOfChild2 < iIndexOfChild) {
                    viewGroup.removeViewAt(iIndexOfChild2);
                    viewGroup.addView(fragment.S, iIndexOfChild);
                }
            }
            if (fragment.X && fragment.R != null) {
                if (fragment.Z > 0.0f) {
                    fragment.S.setAlpha(fragment.Z);
                }
                fragment.Z = 0.0f;
                fragment.X = false;
                c cVarA = a(fragment, fragment.V(), true, fragment.W());
                if (cVarA != null) {
                    b(fragment.S, cVarA);
                    if (cVarA.f744a != null) {
                        fragment.S.startAnimation(cVarA.f744a);
                    } else {
                        cVarA.f745b.setTarget(fragment.S);
                        cVarA.f745b.start();
                    }
                }
            }
        }
        if (fragment.Y) {
            e(fragment);
        }
    }

    void a(int i, boolean z) {
        if (this.m == null && i != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.l) {
            this.l = i;
            if (this.f != null) {
                int size = this.e.size();
                for (int i2 = 0; i2 < size; i2++) {
                    f(this.e.get(i2));
                }
                int size2 = this.f.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    Fragment fragmentValueAt = this.f.valueAt(i3);
                    if (fragmentValueAt != null && ((fragmentValueAt.v || fragmentValueAt.L) && !fragmentValueAt.X)) {
                        f(fragmentValueAt);
                    }
                }
                e();
                if (this.r && this.m != null && this.l == 4) {
                    this.m.c();
                    this.r = false;
                }
            }
        }
    }

    void e() {
        if (this.f == null) {
            return;
        }
        for (int i = 0; i < this.f.size(); i++) {
            Fragment fragmentValueAt = this.f.valueAt(i);
            if (fragmentValueAt != null) {
                b(fragmentValueAt);
            }
        }
    }

    void g(Fragment fragment) {
        if (fragment.o >= 0) {
            return;
        }
        int i = this.d;
        this.d = i + 1;
        fragment.a(i, this.o);
        if (this.f == null) {
            this.f = new SparseArray<>();
        }
        this.f.put(fragment.o, fragment);
        if (f731a) {
            Log.v("FragmentManager", "Allocated fragment index " + fragment);
        }
    }

    void h(Fragment fragment) {
        if (fragment.o < 0) {
            return;
        }
        if (f731a) {
            Log.v("FragmentManager", "Freeing fragment index " + fragment);
        }
        this.f.put(fragment.o, null);
        fragment.y();
    }

    public void a(Fragment fragment, boolean z) {
        if (f731a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        g(fragment);
        if (fragment.L) {
            return;
        }
        if (this.e.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.e) {
            this.e.add(fragment);
        }
        fragment.u = true;
        fragment.v = false;
        if (fragment.S == null) {
            fragment.Y = false;
        }
        if (fragment.O && fragment.P) {
            this.r = true;
        }
        if (z) {
            c(fragment);
        }
    }

    public void i(Fragment fragment) {
        if (f731a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.A);
        }
        boolean z = !fragment.h();
        if (!fragment.L || z) {
            synchronized (this.e) {
                this.e.remove(fragment);
            }
            if (fragment.O && fragment.P) {
                this.r = true;
            }
            fragment.u = false;
            fragment.v = true;
        }
    }

    public void j(Fragment fragment) {
        if (f731a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.K) {
            return;
        }
        fragment.K = true;
        fragment.Y = true ^ fragment.Y;
    }

    public void k(Fragment fragment) {
        if (f731a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.K) {
            fragment.K = false;
            fragment.Y = !fragment.Y;
        }
    }

    public void l(Fragment fragment) {
        if (f731a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.L) {
            return;
        }
        fragment.L = true;
        if (fragment.u) {
            if (f731a) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            synchronized (this.e) {
                this.e.remove(fragment);
            }
            if (fragment.O && fragment.P) {
                this.r = true;
            }
            fragment.u = false;
        }
    }

    public void m(Fragment fragment) {
        if (f731a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.L) {
            fragment.L = false;
            if (fragment.u) {
                return;
            }
            if (this.e.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            if (f731a) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            synchronized (this.e) {
                this.e.add(fragment);
            }
            fragment.u = true;
            if (fragment.O && fragment.P) {
                this.r = true;
            }
        }
    }

    public Fragment b(int i) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            Fragment fragment = this.e.get(size);
            if (fragment != null && fragment.H == i) {
                return fragment;
            }
        }
        if (this.f == null) {
            return null;
        }
        for (int size2 = this.f.size() - 1; size2 >= 0; size2--) {
            Fragment fragmentValueAt = this.f.valueAt(size2);
            if (fragmentValueAt != null && fragmentValueAt.H == i) {
                return fragmentValueAt;
            }
        }
        return null;
    }

    @Override // androidx.fragment.app.h
    public Fragment a(String str) {
        if (str != null) {
            for (int size = this.e.size() - 1; size >= 0; size--) {
                Fragment fragment = this.e.get(size);
                if (fragment != null && str.equals(fragment.J)) {
                    return fragment;
                }
            }
        }
        if (this.f == null || str == null) {
            return null;
        }
        for (int size2 = this.f.size() - 1; size2 >= 0; size2--) {
            Fragment fragmentValueAt = this.f.valueAt(size2);
            if (fragmentValueAt != null && str.equals(fragmentValueAt.J)) {
                return fragmentValueAt;
            }
        }
        return null;
    }

    public Fragment b(String str) {
        Fragment fragmentA;
        if (this.f == null || str == null) {
            return null;
        }
        for (int size = this.f.size() - 1; size >= 0; size--) {
            Fragment fragmentValueAt = this.f.valueAt(size);
            if (fragmentValueAt != null && (fragmentA = fragmentValueAt.a(str)) != null) {
                return fragmentA;
            }
        }
        return null;
    }

    private void y() {
        if (d()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.v == null) {
            return;
        }
        throw new IllegalStateException("Can not perform this action inside of " + this.v);
    }

    @Override // androidx.fragment.app.h
    public boolean d() {
        return this.s || this.t;
    }

    public void a(h hVar, boolean z) {
        if (!z) {
            y();
        }
        synchronized (this) {
            if (!this.u && this.m != null) {
                if (this.f732b == null) {
                    this.f732b = new ArrayList<>();
                }
                this.f732b.add(hVar);
                f();
                return;
            }
            if (!z) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    void f() {
        synchronized (this) {
            boolean z = false;
            boolean z2 = (this.C == null || this.C.isEmpty()) ? false : true;
            if (this.f732b != null && this.f732b.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.m.h().removeCallbacks(this.E);
                this.m.h().post(this.E);
            }
        }
    }

    public int a(androidx.fragment.app.a aVar) {
        synchronized (this) {
            if (this.j != null && this.j.size() > 0) {
                int iIntValue = this.j.remove(this.j.size() - 1).intValue();
                if (f731a) {
                    Log.v("FragmentManager", "Adding back stack index " + iIntValue + " with " + aVar);
                }
                this.i.set(iIntValue, aVar);
                return iIntValue;
            }
            if (this.i == null) {
                this.i = new ArrayList<>();
            }
            int size = this.i.size();
            if (f731a) {
                Log.v("FragmentManager", "Setting back stack index " + size + " to " + aVar);
            }
            this.i.add(aVar);
            return size;
        }
    }

    public void a(int i, androidx.fragment.app.a aVar) {
        synchronized (this) {
            if (this.i == null) {
                this.i = new ArrayList<>();
            }
            int size = this.i.size();
            if (i < size) {
                if (f731a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + aVar);
                }
                this.i.set(i, aVar);
            } else {
                while (size < i) {
                    this.i.add(null);
                    if (this.j == null) {
                        this.j = new ArrayList<>();
                    }
                    if (f731a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.j.add(Integer.valueOf(size));
                    size++;
                }
                if (f731a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + aVar);
                }
                this.i.add(aVar);
            }
        }
    }

    public void c(int i) {
        synchronized (this) {
            this.i.set(i, null);
            if (this.j == null) {
                this.j = new ArrayList<>();
            }
            if (f731a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.j.add(Integer.valueOf(i));
        }
    }

    private void c(boolean z) {
        if (this.c) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.m == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        }
        if (Looper.myLooper() != this.m.h().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            y();
        }
        if (this.x == null) {
            this.x = new ArrayList<>();
            this.y = new ArrayList<>();
        }
        this.c = true;
        try {
            a((ArrayList<androidx.fragment.app.a>) null, (ArrayList<Boolean>) null);
        } finally {
            this.c = false;
        }
    }

    public void b(h hVar, boolean z) {
        if (z && (this.m == null || this.u)) {
            return;
        }
        c(z);
        if (hVar.a(this.x, this.y)) {
            this.c = true;
            try {
                b(this.x, this.y);
            } finally {
                z();
            }
        }
        h();
        C();
    }

    private void z() {
        this.c = false;
        this.y.clear();
        this.x.clear();
    }

    public boolean g() {
        c(true);
        boolean z = false;
        while (c(this.x, this.y)) {
            this.c = true;
            try {
                b(this.x, this.y);
                z();
                z = true;
            } catch (Throwable th) {
                z();
                throw th;
            }
        }
        h();
        C();
        return z;
    }

    private void a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        int iIndexOf;
        int iIndexOf2;
        int size = this.C == null ? 0 : this.C.size();
        int i = 0;
        while (i < size) {
            j jVar = this.C.get(i);
            if (arrayList != null && !jVar.f754a && (iIndexOf2 = arrayList.indexOf(jVar.f755b)) != -1 && arrayList2.get(iIndexOf2).booleanValue()) {
                jVar.e();
            } else if (jVar.c() || (arrayList != null && jVar.f755b.a(arrayList, 0, arrayList.size()))) {
                this.C.remove(i);
                i--;
                size--;
                if (arrayList != null && !jVar.f754a && (iIndexOf = arrayList.indexOf(jVar.f755b)) != -1 && arrayList2.get(iIndexOf).booleanValue()) {
                    jVar.e();
                } else {
                    jVar.d();
                }
            }
            i++;
        }
    }

    private void b(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) throws Resources.NotFoundException {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        a(arrayList, arrayList2);
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!arrayList.get(i).t) {
                if (i2 != i) {
                    a(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (arrayList2.get(i).booleanValue()) {
                    while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).t) {
                        i2++;
                    }
                }
                a(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            a(arrayList, arrayList2, i2, size);
        }
    }

    private void a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) throws Resources.NotFoundException {
        int i3;
        int i4 = i;
        boolean z = arrayList.get(i4).t;
        if (this.z == null) {
            this.z = new ArrayList<>();
        } else {
            this.z.clear();
        }
        this.z.addAll(this.e);
        Fragment fragmentW = w();
        boolean z2 = false;
        for (int i5 = i4; i5 < i2; i5++) {
            androidx.fragment.app.a aVar = arrayList.get(i5);
            if (!arrayList2.get(i5).booleanValue()) {
                fragmentW = aVar.a(this.z, fragmentW);
            } else {
                fragmentW = aVar.b(this.z, fragmentW);
            }
            z2 = z2 || aVar.i;
        }
        this.z.clear();
        if (!z) {
            o.a(this, arrayList, arrayList2, i, i2, false);
        }
        b(arrayList, arrayList2, i, i2);
        if (z) {
            androidx.b.b<Fragment> bVar = new androidx.b.b<>();
            b(bVar);
            int iA = a(arrayList, arrayList2, i, i2, bVar);
            a(bVar);
            i3 = iA;
        } else {
            i3 = i2;
        }
        if (i3 != i4 && z) {
            o.a(this, arrayList, arrayList2, i, i3, true);
            a(this.l, true);
        }
        while (i4 < i2) {
            androidx.fragment.app.a aVar2 = arrayList.get(i4);
            if (arrayList2.get(i4).booleanValue() && aVar2.m >= 0) {
                c(aVar2.m);
                aVar2.m = -1;
            }
            aVar2.b();
            i4++;
        }
        if (z2) {
            i();
        }
    }

    private void a(androidx.b.b<Fragment> bVar) {
        int size = bVar.size();
        for (int i = 0; i < size; i++) {
            Fragment fragmentB = bVar.b(i);
            if (!fragmentB.u) {
                View viewU = fragmentB.u();
                fragmentB.Z = viewU.getAlpha();
                viewU.setAlpha(0.0f);
            }
        }
    }

    private int a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, androidx.b.b<Fragment> bVar) throws Resources.NotFoundException {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            androidx.fragment.app.a aVar = arrayList.get(i4);
            boolean zBooleanValue = arrayList2.get(i4).booleanValue();
            if (aVar.g() && !aVar.a(arrayList, i4 + 1, i2)) {
                if (this.C == null) {
                    this.C = new ArrayList<>();
                }
                j jVar = new j(aVar, zBooleanValue);
                this.C.add(jVar);
                aVar.a(jVar);
                if (zBooleanValue) {
                    aVar.f();
                } else {
                    aVar.b(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, aVar);
                }
                b(bVar);
            }
        }
        return i3;
    }

    void a(androidx.fragment.app.a aVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            aVar.b(z3);
        } else {
            aVar.f();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            o.a(this, (ArrayList<androidx.fragment.app.a>) arrayList, (ArrayList<Boolean>) arrayList2, 0, 1, true);
        }
        if (z3) {
            a(this.l, true);
        }
        if (this.f != null) {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                Fragment fragmentValueAt = this.f.valueAt(i);
                if (fragmentValueAt != null && fragmentValueAt.S != null && fragmentValueAt.X && aVar.b(fragmentValueAt.I)) {
                    if (fragmentValueAt.Z > 0.0f) {
                        fragmentValueAt.S.setAlpha(fragmentValueAt.Z);
                    }
                    if (z3) {
                        fragmentValueAt.Z = 0.0f;
                    } else {
                        fragmentValueAt.Z = -1.0f;
                        fragmentValueAt.X = false;
                    }
                }
            }
        }
    }

    private Fragment q(Fragment fragment) {
        ViewGroup viewGroup = fragment.R;
        View view = fragment.S;
        if (viewGroup == null || view == null) {
            return null;
        }
        for (int iIndexOf = this.e.indexOf(fragment) - 1; iIndexOf >= 0; iIndexOf--) {
            Fragment fragment2 = this.e.get(iIndexOf);
            if (fragment2.R == viewGroup && fragment2.S != null) {
                return fragment2;
            }
        }
        return null;
    }

    private static void b(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            androidx.fragment.app.a aVar = arrayList.get(i);
            if (arrayList2.get(i).booleanValue()) {
                aVar.a(-1);
                aVar.b(i == i2 + (-1));
            } else {
                aVar.a(1);
                aVar.f();
            }
            i++;
        }
    }

    private void b(androidx.b.b<Fragment> bVar) throws Resources.NotFoundException {
        if (this.l < 1) {
            return;
        }
        int iMin = Math.min(this.l, 3);
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = this.e.get(i);
            if (fragment.k < iMin) {
                a(fragment, iMin, fragment.U(), fragment.V(), false);
                if (fragment.S != null && !fragment.K && fragment.X) {
                    bVar.add(fragment);
                }
            }
        }
    }

    private void A() {
        if (this.C != null) {
            while (!this.C.isEmpty()) {
                this.C.remove(0).d();
            }
        }
    }

    private void B() throws Resources.NotFoundException {
        int size = this.f == null ? 0 : this.f.size();
        for (int i = 0; i < size; i++) {
            Fragment fragmentValueAt = this.f.valueAt(i);
            if (fragmentValueAt != null) {
                if (fragmentValueAt.Z() != null) {
                    int iAb = fragmentValueAt.ab();
                    View viewZ = fragmentValueAt.Z();
                    Animation animation = viewZ.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        viewZ.clearAnimation();
                    }
                    fragmentValueAt.a((View) null);
                    a(fragmentValueAt, iAb, 0, 0, false);
                } else if (fragmentValueAt.aa() != null) {
                    fragmentValueAt.aa().end();
                }
            }
        }
    }

    private boolean c(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            if (this.f732b != null && this.f732b.size() != 0) {
                int size = this.f732b.size();
                boolean zA = false;
                for (int i = 0; i < size; i++) {
                    zA |= this.f732b.get(i).a(arrayList, arrayList2);
                }
                this.f732b.clear();
                this.m.h().removeCallbacks(this.E);
                return zA;
            }
            return false;
        }
    }

    void h() {
        if (this.w) {
            this.w = false;
            e();
        }
    }

    void i() {
        if (this.k != null) {
            for (int i = 0; i < this.k.size(); i++) {
                this.k.get(i).E_();
            }
        }
    }

    void b(androidx.fragment.app.a aVar) {
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.add(aVar);
    }

    boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        int size;
        if (this.g == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size2 = this.g.size() - 1;
            if (size2 < 0) {
                return false;
            }
            arrayList.add(this.g.remove(size2));
            arrayList2.add(true);
        } else {
            if (str != null || i >= 0) {
                size = this.g.size() - 1;
                while (size >= 0) {
                    androidx.fragment.app.a aVar = this.g.get(size);
                    if ((str != null && str.equals(aVar.h())) || (i >= 0 && i == aVar.m)) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size--;
                    while (size >= 0) {
                        androidx.fragment.app.a aVar2 = this.g.get(size);
                        if ((str == null || !str.equals(aVar2.h())) && (i < 0 || i != aVar2.m)) {
                            break;
                        }
                        size--;
                    }
                }
            } else {
                size = -1;
            }
            if (size == this.g.size() - 1) {
                return false;
            }
            for (int size3 = this.g.size() - 1; size3 > size; size3--) {
                arrayList.add(this.g.remove(size3));
                arrayList2.add(true);
            }
        }
        return true;
    }

    androidx.fragment.app.j j() {
        a(this.D);
        return this.D;
    }

    private static void a(androidx.fragment.app.j jVar) {
        if (jVar == null) {
            return;
        }
        List<Fragment> listA = jVar.a();
        if (listA != null) {
            Iterator<Fragment> it = listA.iterator();
            while (it.hasNext()) {
                it.next().N = true;
            }
        }
        List<androidx.fragment.app.j> listB = jVar.b();
        if (listB != null) {
            Iterator<androidx.fragment.app.j> it2 = listB.iterator();
            while (it2.hasNext()) {
                a(it2.next());
            }
        }
    }

    void k() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        androidx.fragment.app.j jVar;
        if (this.f != null) {
            arrayList = null;
            arrayList2 = null;
            arrayList3 = null;
            for (int i = 0; i < this.f.size(); i++) {
                Fragment fragmentValueAt = this.f.valueAt(i);
                if (fragmentValueAt != null) {
                    if (fragmentValueAt.M) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(fragmentValueAt);
                        fragmentValueAt.s = fragmentValueAt.r != null ? fragmentValueAt.r.o : -1;
                        if (f731a) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragmentValueAt);
                        }
                    }
                    if (fragmentValueAt.D != null) {
                        fragmentValueAt.D.k();
                        jVar = fragmentValueAt.D.D;
                    } else {
                        jVar = fragmentValueAt.E;
                    }
                    if (arrayList2 == null && jVar != null) {
                        arrayList2 = new ArrayList(this.f.size());
                        for (int i2 = 0; i2 < i; i2++) {
                            arrayList2.add(null);
                        }
                    }
                    if (arrayList2 != null) {
                        arrayList2.add(jVar);
                    }
                    if (arrayList3 == null && fragmentValueAt.F != null) {
                        arrayList3 = new ArrayList(this.f.size());
                        for (int i3 = 0; i3 < i; i3++) {
                            arrayList3.add(null);
                        }
                    }
                    if (arrayList3 != null) {
                        arrayList3.add(fragmentValueAt.F);
                    }
                }
            }
        } else {
            arrayList = null;
            arrayList2 = null;
            arrayList3 = null;
        }
        if (arrayList == null && arrayList2 == null && arrayList3 == null) {
            this.D = null;
        } else {
            this.D = new androidx.fragment.app.j(arrayList, arrayList2, arrayList3);
        }
    }

    void n(Fragment fragment) {
        if (fragment.T == null) {
            return;
        }
        if (this.B == null) {
            this.B = new SparseArray<>();
        } else {
            this.B.clear();
        }
        fragment.T.saveHierarchyState(this.B);
        if (this.B.size() > 0) {
            fragment.m = this.B;
            this.B = null;
        }
    }

    Bundle o(Fragment fragment) {
        Bundle bundle;
        if (this.A == null) {
            this.A = new Bundle();
        }
        fragment.n(this.A);
        d(fragment, this.A, false);
        if (this.A.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.A;
            this.A = null;
        }
        if (fragment.S != null) {
            n(fragment);
        }
        if (fragment.m != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.m);
        }
        if (!fragment.V) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.V);
        }
        return bundle;
    }

    Parcelable l() throws Resources.NotFoundException {
        int[] iArr;
        int size;
        A();
        B();
        g();
        this.s = true;
        androidx.fragment.app.b[] bVarArr = null;
        this.D = null;
        if (this.f == null || this.f.size() <= 0) {
            return null;
        }
        int size2 = this.f.size();
        l[] lVarArr = new l[size2];
        boolean z = false;
        for (int i = 0; i < size2; i++) {
            Fragment fragmentValueAt = this.f.valueAt(i);
            if (fragmentValueAt != null) {
                if (fragmentValueAt.o < 0) {
                    a(new IllegalStateException("Failure saving state: active " + fragmentValueAt + " has cleared index: " + fragmentValueAt.o));
                }
                l lVar = new l(fragmentValueAt);
                lVarArr[i] = lVar;
                if (fragmentValueAt.k > 0 && lVar.k == null) {
                    lVar.k = o(fragmentValueAt);
                    if (fragmentValueAt.r != null) {
                        if (fragmentValueAt.r.o < 0) {
                            a(new IllegalStateException("Failure saving state: " + fragmentValueAt + " has target not in fragment manager: " + fragmentValueAt.r));
                        }
                        if (lVar.k == null) {
                            lVar.k = new Bundle();
                        }
                        a(lVar.k, "android:target_state", fragmentValueAt.r);
                        if (fragmentValueAt.t != 0) {
                            lVar.k.putInt("android:target_req_state", fragmentValueAt.t);
                        }
                    }
                } else {
                    lVar.k = fragmentValueAt.l;
                }
                if (f731a) {
                    Log.v("FragmentManager", "Saved state of " + fragmentValueAt + ": " + lVar.k);
                }
                z = true;
            }
        }
        if (!z) {
            if (f731a) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size3 = this.e.size();
        if (size3 > 0) {
            iArr = new int[size3];
            for (int i2 = 0; i2 < size3; i2++) {
                iArr[i2] = this.e.get(i2).o;
                if (iArr[i2] < 0) {
                    a(new IllegalStateException("Failure saving state: active " + this.e.get(i2) + " has cleared index: " + iArr[i2]));
                }
                if (f731a) {
                    Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.e.get(i2));
                }
            }
        } else {
            iArr = null;
        }
        if (this.g != null && (size = this.g.size()) > 0) {
            bVarArr = new androidx.fragment.app.b[size];
            for (int i3 = 0; i3 < size; i3++) {
                bVarArr[i3] = new androidx.fragment.app.b(this.g.get(i3));
                if (f731a) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i3 + ": " + this.g.get(i3));
                }
            }
        }
        k kVar = new k();
        kVar.f758a = lVarArr;
        kVar.f759b = iArr;
        kVar.c = bVarArr;
        if (this.p != null) {
            kVar.d = this.p.o;
        }
        kVar.e = this.d;
        k();
        return kVar;
    }

    void a(Parcelable parcelable, androidx.fragment.app.j jVar) {
        List<androidx.fragment.app.j> listB;
        List<androidx.lifecycle.r> listC;
        if (parcelable == null) {
            return;
        }
        k kVar = (k) parcelable;
        if (kVar.f758a == null) {
            return;
        }
        if (jVar != null) {
            List<Fragment> listA = jVar.a();
            listB = jVar.b();
            listC = jVar.c();
            int size = listA != null ? listA.size() : 0;
            for (int i = 0; i < size; i++) {
                Fragment fragment = listA.get(i);
                if (f731a) {
                    Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                }
                int i2 = 0;
                while (i2 < kVar.f758a.length && kVar.f758a[i2].f761b != fragment.o) {
                    i2++;
                }
                if (i2 == kVar.f758a.length) {
                    a(new IllegalStateException("Could not find active fragment with index " + fragment.o));
                }
                l lVar = kVar.f758a[i2];
                lVar.l = fragment;
                fragment.m = null;
                fragment.A = 0;
                fragment.x = false;
                fragment.u = false;
                fragment.r = null;
                if (lVar.k != null) {
                    lVar.k.setClassLoader(this.m.g().getClassLoader());
                    fragment.m = lVar.k.getSparseParcelableArray("android:view_state");
                    fragment.l = lVar.k;
                }
            }
        } else {
            listB = null;
            listC = null;
        }
        this.f = new SparseArray<>(kVar.f758a.length);
        int i3 = 0;
        while (i3 < kVar.f758a.length) {
            l lVar2 = kVar.f758a[i3];
            if (lVar2 != null) {
                Fragment fragmentA = lVar2.a(this.m, this.n, this.o, (listB == null || i3 >= listB.size()) ? null : listB.get(i3), (listC == null || i3 >= listC.size()) ? null : listC.get(i3));
                if (f731a) {
                    Log.v("FragmentManager", "restoreAllState: active #" + i3 + ": " + fragmentA);
                }
                this.f.put(fragmentA.o, fragmentA);
                lVar2.l = null;
            }
            i3++;
        }
        if (jVar != null) {
            List<Fragment> listA2 = jVar.a();
            int size2 = listA2 != null ? listA2.size() : 0;
            for (int i4 = 0; i4 < size2; i4++) {
                Fragment fragment2 = listA2.get(i4);
                if (fragment2.s >= 0) {
                    fragment2.r = this.f.get(fragment2.s);
                    if (fragment2.r == null) {
                        Log.w("FragmentManager", "Re-attaching retained fragment " + fragment2 + " target no longer exists: " + fragment2.s);
                    }
                }
            }
        }
        this.e.clear();
        if (kVar.f759b != null) {
            for (int i5 = 0; i5 < kVar.f759b.length; i5++) {
                Fragment fragment3 = this.f.get(kVar.f759b[i5]);
                if (fragment3 == null) {
                    a(new IllegalStateException("No instantiated fragment for index #" + kVar.f759b[i5]));
                }
                fragment3.u = true;
                if (f731a) {
                    Log.v("FragmentManager", "restoreAllState: added #" + i5 + ": " + fragment3);
                }
                if (this.e.contains(fragment3)) {
                    throw new IllegalStateException("Already added!");
                }
                synchronized (this.e) {
                    this.e.add(fragment3);
                }
            }
        }
        if (kVar.c != null) {
            this.g = new ArrayList<>(kVar.c.length);
            for (int i6 = 0; i6 < kVar.c.length; i6++) {
                androidx.fragment.app.a aVarA = kVar.c[i6].a(this);
                if (f731a) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i6 + " (index " + aVarA.m + "): " + aVarA);
                    PrintWriter printWriter = new PrintWriter(new androidx.core.f.b("FragmentManager"));
                    aVarA.a("  ", printWriter, false);
                    printWriter.close();
                }
                this.g.add(aVarA);
                if (aVarA.m >= 0) {
                    a(aVarA.m, aVarA);
                }
            }
        } else {
            this.g = null;
        }
        if (kVar.d >= 0) {
            this.p = this.f.get(kVar.d);
        }
        this.d = kVar.e;
    }

    private void C() {
        if (this.f != null) {
            for (int size = this.f.size() - 1; size >= 0; size--) {
                if (this.f.valueAt(size) == null) {
                    this.f.delete(this.f.keyAt(size));
                }
            }
        }
    }

    public void a(androidx.fragment.app.g gVar, androidx.fragment.app.e eVar, Fragment fragment) {
        if (this.m != null) {
            throw new IllegalStateException("Already attached");
        }
        this.m = gVar;
        this.n = eVar;
        this.o = fragment;
    }

    public void m() {
        this.D = null;
        this.s = false;
        this.t = false;
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = this.e.get(i);
            if (fragment != null) {
                fragment.N();
            }
        }
    }

    public void n() {
        this.s = false;
        this.t = false;
        e(1);
    }

    public void o() {
        this.s = false;
        this.t = false;
        e(2);
    }

    public void p() {
        this.s = false;
        this.t = false;
        e(3);
    }

    public void q() {
        this.s = false;
        this.t = false;
        e(4);
    }

    public void r() {
        e(3);
    }

    public void s() {
        this.t = true;
        e(2);
    }

    public void t() {
        e(1);
    }

    public void u() {
        this.u = true;
        g();
        e(0);
        this.m = null;
        this.n = null;
        this.o = null;
    }

    private void e(int i) {
        try {
            this.c = true;
            a(i, false);
            this.c = false;
            g();
        } catch (Throwable th) {
            this.c = false;
            throw th;
        }
    }

    public void a(boolean z) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            Fragment fragment = this.e.get(size);
            if (fragment != null) {
                fragment.h(z);
            }
        }
    }

    public void b(boolean z) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            Fragment fragment = this.e.get(size);
            if (fragment != null) {
                fragment.i(z);
            }
        }
    }

    public void a(Configuration configuration) {
        for (int i = 0; i < this.e.size(); i++) {
            Fragment fragment = this.e.get(i);
            if (fragment != null) {
                fragment.a(configuration);
            }
        }
    }

    public void v() {
        for (int i = 0; i < this.e.size(); i++) {
            Fragment fragment = this.e.get(i);
            if (fragment != null) {
                fragment.O();
            }
        }
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        if (this.l < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (int i = 0; i < this.e.size(); i++) {
            Fragment fragment = this.e.get(i);
            if (fragment != null && fragment.b(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.h != null) {
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                Fragment fragment2 = this.h.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.z();
                }
            }
        }
        this.h = arrayList;
        return z;
    }

    public boolean a(Menu menu) {
        if (this.l < 1) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.e.size(); i++) {
            Fragment fragment = this.e.get(i);
            if (fragment != null && fragment.c(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean a(MenuItem menuItem) {
        if (this.l < 1) {
            return false;
        }
        for (int i = 0; i < this.e.size(); i++) {
            Fragment fragment = this.e.get(i);
            if (fragment != null && fragment.c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean b(MenuItem menuItem) {
        if (this.l < 1) {
            return false;
        }
        for (int i = 0; i < this.e.size(); i++) {
            Fragment fragment = this.e.get(i);
            if (fragment != null && fragment.d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void b(Menu menu) {
        if (this.l < 1) {
            return;
        }
        for (int i = 0; i < this.e.size(); i++) {
            Fragment fragment = this.e.get(i);
            if (fragment != null) {
                fragment.d(menu);
            }
        }
    }

    public void p(Fragment fragment) {
        if (fragment != null && (this.f.get(fragment.o) != fragment || (fragment.C != null && fragment.p() != this))) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        this.p = fragment;
    }

    public Fragment w() {
        return this.p;
    }

    void a(Fragment fragment, Context context, boolean z) {
        if (this.o != null) {
            androidx.fragment.app.h hVarP = this.o.p();
            if (hVarP instanceof i) {
                ((i) hVarP).a(fragment, context, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f750b) {
                next.f749a.a(this, fragment, context);
            }
        }
    }

    void b(Fragment fragment, Context context, boolean z) {
        if (this.o != null) {
            androidx.fragment.app.h hVarP = this.o.p();
            if (hVarP instanceof i) {
                ((i) hVarP).b(fragment, context, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f750b) {
                next.f749a.b(this, fragment, context);
            }
        }
    }

    void a(Fragment fragment, Bundle bundle, boolean z) {
        if (this.o != null) {
            androidx.fragment.app.h hVarP = this.o.p();
            if (hVarP instanceof i) {
                ((i) hVarP).a(fragment, bundle, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f750b) {
                next.f749a.a(this, fragment, bundle);
            }
        }
    }

    void b(Fragment fragment, Bundle bundle, boolean z) {
        if (this.o != null) {
            androidx.fragment.app.h hVarP = this.o.p();
            if (hVarP instanceof i) {
                ((i) hVarP).b(fragment, bundle, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f750b) {
                next.f749a.b(this, fragment, bundle);
            }
        }
    }

    void c(Fragment fragment, Bundle bundle, boolean z) {
        if (this.o != null) {
            androidx.fragment.app.h hVarP = this.o.p();
            if (hVarP instanceof i) {
                ((i) hVarP).c(fragment, bundle, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f750b) {
                next.f749a.c(this, fragment, bundle);
            }
        }
    }

    void a(Fragment fragment, View view, Bundle bundle, boolean z) {
        if (this.o != null) {
            androidx.fragment.app.h hVarP = this.o.p();
            if (hVarP instanceof i) {
                ((i) hVarP).a(fragment, view, bundle, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f750b) {
                next.f749a.a(this, fragment, view, bundle);
            }
        }
    }

    void b(Fragment fragment, boolean z) {
        if (this.o != null) {
            androidx.fragment.app.h hVarP = this.o.p();
            if (hVarP instanceof i) {
                ((i) hVarP).b(fragment, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f750b) {
                next.f749a.a(this, fragment);
            }
        }
    }

    void c(Fragment fragment, boolean z) {
        if (this.o != null) {
            androidx.fragment.app.h hVarP = this.o.p();
            if (hVarP instanceof i) {
                ((i) hVarP).c(fragment, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f750b) {
                next.f749a.b(this, fragment);
            }
        }
    }

    void d(Fragment fragment, boolean z) {
        if (this.o != null) {
            androidx.fragment.app.h hVarP = this.o.p();
            if (hVarP instanceof i) {
                ((i) hVarP).d(fragment, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f750b) {
                next.f749a.c(this, fragment);
            }
        }
    }

    void e(Fragment fragment, boolean z) {
        if (this.o != null) {
            androidx.fragment.app.h hVarP = this.o.p();
            if (hVarP instanceof i) {
                ((i) hVarP).e(fragment, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f750b) {
                next.f749a.d(this, fragment);
            }
        }
    }

    void d(Fragment fragment, Bundle bundle, boolean z) {
        if (this.o != null) {
            androidx.fragment.app.h hVarP = this.o.p();
            if (hVarP instanceof i) {
                ((i) hVarP).d(fragment, bundle, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f750b) {
                next.f749a.d(this, fragment, bundle);
            }
        }
    }

    void f(Fragment fragment, boolean z) {
        if (this.o != null) {
            androidx.fragment.app.h hVarP = this.o.p();
            if (hVarP instanceof i) {
                ((i) hVarP).f(fragment, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f750b) {
                next.f749a.e(this, fragment);
            }
        }
    }

    void g(Fragment fragment, boolean z) {
        if (this.o != null) {
            androidx.fragment.app.h hVarP = this.o.p();
            if (hVarP instanceof i) {
                ((i) hVarP).g(fragment, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f750b) {
                next.f749a.f(this, fragment);
            }
        }
    }

    void h(Fragment fragment, boolean z) {
        if (this.o != null) {
            androidx.fragment.app.h hVarP = this.o.p();
            if (hVarP instanceof i) {
                ((i) hVarP).h(fragment, true);
            }
        }
        Iterator<f> it = this.J.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f750b) {
                next.f749a.g(this, fragment);
            }
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        Fragment fragment;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f751a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(0);
        }
        String str2 = attributeValue;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        String string = typedArrayObtainStyledAttributes.getString(2);
        typedArrayObtainStyledAttributes.recycle();
        if (!Fragment.a(this.m.g(), str2)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
        }
        Fragment fragmentB = resourceId != -1 ? b(resourceId) : null;
        if (fragmentB == null && string != null) {
            fragmentB = a(string);
        }
        if (fragmentB == null && id != -1) {
            fragmentB = b(id);
        }
        if (f731a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + fragmentB);
        }
        if (fragmentB == null) {
            Fragment fragmentA = this.n.a(context, str2, null);
            fragmentA.w = true;
            fragmentA.H = resourceId != 0 ? resourceId : id;
            fragmentA.I = id;
            fragmentA.J = string;
            fragmentA.x = true;
            fragmentA.B = this;
            fragmentA.C = this.m;
            fragmentA.a(this.m.g(), attributeSet, fragmentA.l);
            a(fragmentA, true);
            fragment = fragmentA;
        } else {
            if (fragmentB.x) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
            }
            fragmentB.x = true;
            fragmentB.C = this.m;
            if (!fragmentB.N) {
                fragmentB.a(this.m.g(), attributeSet, fragmentB.l);
            }
            fragment = fragmentB;
        }
        if (this.l < 1 && fragment.w) {
            a(fragment, 1, 0, 0, false);
        } else {
            c(fragment);
        }
        if (fragment.S == null) {
            throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.S.setId(resourceId);
        }
        if (fragment.S.getTag() == null) {
            fragment.S.setTag(string);
        }
        return fragment.S;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: androidx.fragment.app.i$i, reason: collision with other inner class name */
    private class C0047i implements h {

        /* renamed from: a, reason: collision with root package name */
        final String f752a;

        /* renamed from: b, reason: collision with root package name */
        final int f753b;
        final int c;

        C0047i(String str, int i, int i2) {
            this.f752a = str;
            this.f753b = i;
            this.c = i2;
        }

        @Override // androidx.fragment.app.i.h
        public boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
            androidx.fragment.app.h hVarR;
            if (i.this.p == null || this.f753b >= 0 || this.f752a != null || (hVarR = i.this.p.r()) == null || !hVarR.b()) {
                return i.this.a(arrayList, arrayList2, this.f752a, this.f753b, this.c);
            }
            return false;
        }
    }

    /* compiled from: FragmentManager.java */
    static class j implements Fragment.b {

        /* renamed from: a, reason: collision with root package name */
        final boolean f754a;

        /* renamed from: b, reason: collision with root package name */
        final androidx.fragment.app.a f755b;
        private int c;

        j(androidx.fragment.app.a aVar, boolean z) {
            this.f754a = z;
            this.f755b = aVar;
        }

        @Override // androidx.fragment.app.Fragment.b
        public void a() {
            this.c--;
            if (this.c != 0) {
                return;
            }
            this.f755b.f714a.f();
        }

        @Override // androidx.fragment.app.Fragment.b
        public void b() {
            this.c++;
        }

        public boolean c() {
            return this.c == 0;
        }

        public void d() {
            boolean z = this.c > 0;
            i iVar = this.f755b.f714a;
            int size = iVar.e.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = iVar.e.get(i);
                fragment.a((Fragment.b) null);
                if (z && fragment.ac()) {
                    fragment.I();
                }
            }
            this.f755b.f714a.a(this.f755b, this.f754a, !z, true);
        }

        public void e() {
            this.f755b.f714a.a(this.f755b, this.f754a, false, false);
        }
    }

    /* compiled from: FragmentManager.java */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        public final Animation f744a;

        /* renamed from: b, reason: collision with root package name */
        public final Animator f745b;

        c(Animation animation) {
            this.f744a = animation;
            this.f745b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        c(Animator animator) {
            this.f744a = null;
            this.f745b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* compiled from: FragmentManager.java */
    private static class b implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        private final Animation.AnimationListener f743a;

        b(Animation.AnimationListener animationListener) {
            this.f743a = animationListener;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (this.f743a != null) {
                this.f743a.onAnimationStart(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (this.f743a != null) {
                this.f743a.onAnimationEnd(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            if (this.f743a != null) {
                this.f743a.onAnimationRepeat(animation);
            }
        }
    }

    /* compiled from: FragmentManager.java */
    private static class a extends b {

        /* renamed from: a, reason: collision with root package name */
        View f741a;

        a(View view, Animation.AnimationListener animationListener) {
            super(animationListener);
            this.f741a = view;
        }

        @Override // androidx.fragment.app.i.b, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (androidx.core.g.q.A(this.f741a) || Build.VERSION.SDK_INT >= 24) {
                this.f741a.post(new Runnable() { // from class: androidx.fragment.app.i.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f741a.setLayerType(0, null);
                    }
                });
            } else {
                this.f741a.setLayerType(0, null);
            }
            super.onAnimationEnd(animation);
        }
    }

    /* compiled from: FragmentManager.java */
    private static class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        View f746a;

        d(View view) {
            this.f746a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f746a.setLayerType(2, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f746a.setLayerType(0, null);
            animator.removeListener(this);
        }
    }

    /* compiled from: FragmentManager.java */
    private static class e extends AnimationSet implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final ViewGroup f747a;

        /* renamed from: b, reason: collision with root package name */
        private final View f748b;
        private boolean c;
        private boolean d;
        private boolean e;

        e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.e = true;
            this.f747a = viewGroup;
            this.f748b = view;
            addAnimation(animation);
            this.f747a.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            this.e = true;
            if (this.c) {
                return !this.d;
            }
            if (!super.getTransformation(j, transformation)) {
                this.c = true;
                r.a(this.f747a, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.e = true;
            if (this.c) {
                return !this.d;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.c = true;
                r.a(this.f747a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.c && this.e) {
                this.e = false;
                this.f747a.post(this);
            } else {
                this.f747a.endViewTransition(this.f748b);
                this.d = true;
            }
        }
    }
}
