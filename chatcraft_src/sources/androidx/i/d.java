package androidx.i;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: Fade.java */
/* loaded from: classes.dex */
public class d extends ai {
    public d(int i) {
        a(i);
    }

    public d() {
    }

    @Override // androidx.i.ai, androidx.i.m
    public void a(s sVar) {
        super.a(sVar);
        sVar.f865a.put("android:fade:transitionAlpha", Float.valueOf(ad.c(sVar.f866b)));
    }

    private Animator a(final View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        ad.a(view, f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, ad.f803a, f2);
        objectAnimatorOfFloat.addListener(new a(view));
        a(new n() { // from class: androidx.i.d.1
            @Override // androidx.i.n, androidx.i.m.c
            public void a(m mVar) {
                ad.a(view, 1.0f);
                ad.e(view);
                mVar.b(this);
            }
        });
        return objectAnimatorOfFloat;
    }

    @Override // androidx.i.ai
    public Animator a(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        float fA = a(sVar, 0.0f);
        return a(view, fA != 1.0f ? fA : 0.0f, 1.0f);
    }

    @Override // androidx.i.ai
    public Animator b(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        ad.d(view);
        return a(view, a(sVar, 1.0f), 0.0f);
    }

    private static float a(s sVar, float f) {
        Float f2;
        return (sVar == null || (f2 = (Float) sVar.f865a.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }

    /* compiled from: Fade.java */
    private static class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final View f832a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f833b = false;

        a(View view) {
            this.f832a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (androidx.core.g.q.r(this.f832a) && this.f832a.getLayerType() == 0) {
                this.f833b = true;
                this.f832a.setLayerType(2, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ad.a(this.f832a, 1.0f);
            if (this.f833b) {
                this.f832a.setLayerType(0, null);
            }
        }
    }
}
