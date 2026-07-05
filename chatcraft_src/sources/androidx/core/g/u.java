package androidx.core.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* compiled from: ViewPropertyAnimatorCompat.java */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    Runnable f644a = null;

    /* renamed from: b, reason: collision with root package name */
    Runnable f645b = null;
    int c = -1;
    private WeakReference<View> d;

    u(View view) {
        this.d = new WeakReference<>(view);
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    static class a implements v {

        /* renamed from: a, reason: collision with root package name */
        u f650a;

        /* renamed from: b, reason: collision with root package name */
        boolean f651b;

        a(u uVar) {
            this.f650a = uVar;
        }

        @Override // androidx.core.g.v
        public void a(View view) {
            this.f651b = false;
            if (this.f650a.c > -1) {
                view.setLayerType(2, null);
            }
            if (this.f650a.f644a != null) {
                Runnable runnable = this.f650a.f644a;
                this.f650a.f644a = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            v vVar = tag instanceof v ? (v) tag : null;
            if (vVar != null) {
                vVar.a(view);
            }
        }

        @Override // androidx.core.g.v
        public void b(View view) {
            if (this.f650a.c > -1) {
                view.setLayerType(this.f650a.c, null);
                this.f650a.c = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.f651b) {
                if (this.f650a.f645b != null) {
                    Runnable runnable = this.f650a.f645b;
                    this.f650a.f645b = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                v vVar = tag instanceof v ? (v) tag : null;
                if (vVar != null) {
                    vVar.b(view);
                }
                this.f651b = true;
            }
        }

        @Override // androidx.core.g.v
        public void c(View view) {
            Object tag = view.getTag(2113929216);
            v vVar = tag instanceof v ? (v) tag : null;
            if (vVar != null) {
                vVar.c(view);
            }
        }
    }

    public u a(long j) {
        View view = this.d.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public u a(float f) {
        View view = this.d.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public u b(float f) {
        View view = this.d.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public long a() {
        View view = this.d.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public u a(Interpolator interpolator) {
        View view = this.d.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public u b(long j) {
        View view = this.d.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public void b() {
        View view = this.d.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public void c() {
        View view = this.d.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public u a(v vVar) {
        View view = this.d.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                a(view, vVar);
            } else {
                view.setTag(2113929216, vVar);
                a(view, new a(this));
            }
        }
        return this;
    }

    private void a(final View view, final v vVar) {
        if (vVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() { // from class: androidx.core.g.u.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    vVar.c(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    vVar.b(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    vVar.a(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    public u a(final x xVar) {
        final View view = this.d.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(xVar != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.g.u.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    xVar.a(view);
                }
            } : null);
        }
        return this;
    }
}
