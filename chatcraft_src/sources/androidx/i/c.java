package androidx.i;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* compiled from: ChangeBounds.java */
/* loaded from: classes.dex */
public class c extends m {
    private static final String[] h = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> i = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") { // from class: androidx.i.c.1

        /* renamed from: a, reason: collision with root package name */
        private Rect f819a = new Rect();

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f819a);
            this.f819a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f819a);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f819a);
            return new PointF(this.f819a.left, this.f819a.top);
        }
    };
    private static final Property<a, PointF> j = new Property<a, PointF>(PointF.class, "topLeft") { // from class: androidx.i.c.3
        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(a aVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(a aVar, PointF pointF) {
            aVar.a(pointF);
        }
    };
    private static final Property<a, PointF> k = new Property<a, PointF>(PointF.class, "bottomRight") { // from class: androidx.i.c.4
        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(a aVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(a aVar, PointF pointF) {
            aVar.b(pointF);
        }
    };
    private static final Property<View, PointF> l = new Property<View, PointF>(PointF.class, "bottomRight") { // from class: androidx.i.c.5
        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            ad.a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    };
    private static final Property<View, PointF> m = new Property<View, PointF>(PointF.class, "topLeft") { // from class: androidx.i.c.6
        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            ad.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    };
    private static final Property<View, PointF> n = new Property<View, PointF>(PointF.class, "position") { // from class: androidx.i.c.7
        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int iRound = Math.round(pointF.x);
            int iRound2 = Math.round(pointF.y);
            ad.a(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
        }
    };
    private static k r = new k();
    private int[] o = new int[2];
    private boolean p = false;
    private boolean q = false;

    @Override // androidx.i.m
    public String[] a() {
        return h;
    }

    private void d(s sVar) {
        View view = sVar.f866b;
        if (!androidx.core.g.q.x(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        sVar.f865a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        sVar.f865a.put("android:changeBounds:parent", sVar.f866b.getParent());
        if (this.q) {
            sVar.f866b.getLocationInWindow(this.o);
            sVar.f865a.put("android:changeBounds:windowX", Integer.valueOf(this.o[0]));
            sVar.f865a.put("android:changeBounds:windowY", Integer.valueOf(this.o[1]));
        }
        if (this.p) {
            sVar.f865a.put("android:changeBounds:clip", androidx.core.g.q.z(view));
        }
    }

    @Override // androidx.i.m
    public void a(s sVar) {
        d(sVar);
    }

    @Override // androidx.i.m
    public void b(s sVar) {
        d(sVar);
    }

    private boolean a(View view, View view2) {
        if (!this.q) {
            return true;
        }
        s sVarB = b(view, true);
        if (sVarB == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == sVarB.f866b) {
            return true;
        }
        return false;
    }

    @Override // androidx.i.m
    public Animator a(final ViewGroup viewGroup, s sVar, s sVar2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i2;
        final View view;
        int i3;
        Rect rect;
        ObjectAnimator objectAnimatorOfObject;
        Animator animatorA;
        if (sVar == null || sVar2 == null) {
            return null;
        }
        Map<String, Object> map = sVar.f865a;
        Map<String, Object> map2 = sVar2.f865a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        final View view2 = sVar2.f866b;
        if (a(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) sVar.f865a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) sVar2.f865a.get("android:changeBounds:bounds");
            int i4 = rect2.left;
            final int i5 = rect3.left;
            int i6 = rect2.top;
            final int i7 = rect3.top;
            int i8 = rect2.right;
            final int i9 = rect3.right;
            int i10 = rect2.bottom;
            final int i11 = rect3.bottom;
            int i12 = i8 - i4;
            int i13 = i10 - i6;
            int i14 = i9 - i5;
            int i15 = i11 - i7;
            Rect rect4 = (Rect) sVar.f865a.get("android:changeBounds:clip");
            final Rect rect5 = (Rect) sVar2.f865a.get("android:changeBounds:clip");
            if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
                i2 = 0;
            } else {
                i2 = (i4 == i5 && i6 == i7) ? 0 : 1;
                if (i8 != i9 || i10 != i11) {
                    i2++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i2++;
            }
            if (i2 <= 0) {
                return null;
            }
            if (!this.p) {
                view = view2;
                ad.a(view, i4, i6, i8, i10);
                if (i2 == 2) {
                    if (i12 == i14 && i13 == i15) {
                        animatorA = f.a(view, n, l().a(i4, i6, i5, i7));
                    } else {
                        final a aVar = new a(view);
                        ObjectAnimator objectAnimatorA = f.a(aVar, j, l().a(i4, i6, i5, i7));
                        ObjectAnimator objectAnimatorA2 = f.a(aVar, k, l().a(i8, i10, i9, i11));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(objectAnimatorA, objectAnimatorA2);
                        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: androidx.i.c.8
                            private a mViewBounds;

                            {
                                this.mViewBounds = aVar;
                            }
                        });
                        animatorA = animatorSet;
                    }
                } else if (i4 != i5 || i6 != i7) {
                    animatorA = f.a(view, m, l().a(i4, i6, i5, i7));
                } else {
                    animatorA = f.a(view, l, l().a(i8, i10, i9, i11));
                }
            } else {
                view = view2;
                ad.a(view, i4, i6, Math.max(i12, i14) + i4, Math.max(i13, i15) + i6);
                ObjectAnimator objectAnimatorA3 = (i4 == i5 && i6 == i7) ? null : f.a(view, n, l().a(i4, i6, i5, i7));
                if (rect4 == null) {
                    i3 = 0;
                    rect = new Rect(0, 0, i12, i13);
                } else {
                    i3 = 0;
                    rect = rect4;
                }
                Rect rect6 = rect5 == null ? new Rect(i3, i3, i14, i15) : rect5;
                if (rect.equals(rect6)) {
                    objectAnimatorOfObject = null;
                } else {
                    androidx.core.g.q.a(view, rect);
                    k kVar = r;
                    Object[] objArr = new Object[2];
                    objArr[i3] = rect;
                    objArr[1] = rect6;
                    objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", kVar, objArr);
                    objectAnimatorOfObject.addListener(new AnimatorListenerAdapter() { // from class: androidx.i.c.9
                        private boolean h;

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            this.h = true;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (this.h) {
                                return;
                            }
                            androidx.core.g.q.a(view, rect5);
                            ad.a(view, i5, i7, i9, i11);
                        }
                    });
                }
                animatorA = r.a(objectAnimatorA3, objectAnimatorOfObject);
            }
            if (view.getParent() instanceof ViewGroup) {
                final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                x.a(viewGroup4, true);
                a(new n() { // from class: androidx.i.c.10

                    /* renamed from: a, reason: collision with root package name */
                    boolean f820a = false;

                    @Override // androidx.i.n, androidx.i.m.c
                    public void a(m mVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                        if (!this.f820a) {
                            x.a(viewGroup4, false);
                        }
                        mVar.b(this);
                    }

                    @Override // androidx.i.n, androidx.i.m.c
                    public void b(m mVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                        x.a(viewGroup4, false);
                    }

                    @Override // androidx.i.n, androidx.i.m.c
                    public void c(m mVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                        x.a(viewGroup4, true);
                    }
                });
            }
            return animatorA;
        }
        int iIntValue = ((Integer) sVar.f865a.get("android:changeBounds:windowX")).intValue();
        int iIntValue2 = ((Integer) sVar.f865a.get("android:changeBounds:windowY")).intValue();
        int iIntValue3 = ((Integer) sVar2.f865a.get("android:changeBounds:windowX")).intValue();
        int iIntValue4 = ((Integer) sVar2.f865a.get("android:changeBounds:windowY")).intValue();
        if (iIntValue == iIntValue3 && iIntValue2 == iIntValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.o);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(bitmapCreateBitmap));
        final BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
        final float fC = ad.c(view2);
        ad.a(view2, 0.0f);
        ad.a(viewGroup).a(bitmapDrawable);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, i.a(i, l().a(iIntValue - this.o[0], iIntValue2 - this.o[1], iIntValue3 - this.o[0], iIntValue4 - this.o[1])));
        objectAnimatorOfPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: androidx.i.c.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ad.a(viewGroup).b(bitmapDrawable);
                ad.a(view2, fC);
            }
        });
        return objectAnimatorOfPropertyValuesHolder;
    }

    /* compiled from: ChangeBounds.java */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f828a;

        /* renamed from: b, reason: collision with root package name */
        private int f829b;
        private int c;
        private int d;
        private View e;
        private int f;
        private int g;

        a(View view) {
            this.e = view;
        }

        void a(PointF pointF) {
            this.f828a = Math.round(pointF.x);
            this.f829b = Math.round(pointF.y);
            this.f++;
            if (this.f == this.g) {
                a();
            }
        }

        void b(PointF pointF) {
            this.c = Math.round(pointF.x);
            this.d = Math.round(pointF.y);
            this.g++;
            if (this.f == this.g) {
                a();
            }
        }

        private void a() {
            ad.a(this.e, this.f828a, this.f829b, this.c, this.d);
            this.f = 0;
            this.g = 0;
        }
    }
}
