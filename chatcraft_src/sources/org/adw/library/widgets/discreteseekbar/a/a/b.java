package org.adw.library.widgets.discreteseekbar.a.a;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import org.adw.library.widgets.discreteseekbar.a.a.a;

/* compiled from: AnimatorCompatV11.java */
@TargetApi(11)
/* loaded from: classes.dex */
public class b extends a {

    /* renamed from: a, reason: collision with root package name */
    ValueAnimator f5276a;

    public b(float f, float f2, final a.InterfaceC0127a interfaceC0127a) {
        this.f5276a = ValueAnimator.ofFloat(f, f2);
        this.f5276a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.adw.library.widgets.discreteseekbar.a.a.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                interfaceC0127a.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
    }

    @Override // org.adw.library.widgets.discreteseekbar.a.a.a
    public void a() {
        this.f5276a.cancel();
    }

    @Override // org.adw.library.widgets.discreteseekbar.a.a.a
    public boolean b() {
        return this.f5276a.isRunning();
    }

    @Override // org.adw.library.widgets.discreteseekbar.a.a.a
    public void a(int i) {
        this.f5276a.setDuration(i);
    }

    @Override // org.adw.library.widgets.discreteseekbar.a.a.a
    public void c() {
        this.f5276a.start();
    }
}
