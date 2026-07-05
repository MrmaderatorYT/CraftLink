package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

/* compiled from: StateListAnimator.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<a> f3832b = new ArrayList<>();
    private a c = null;

    /* renamed from: a, reason: collision with root package name */
    ValueAnimator f3831a = null;
    private final Animator.AnimatorListener d = new AnimatorListenerAdapter() { // from class: com.google.android.material.internal.g.1
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (g.this.f3831a == animator) {
                g.this.f3831a = null;
            }
        }
    };

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        a aVar = new a(iArr, valueAnimator);
        valueAnimator.addListener(this.d);
        this.f3832b.add(aVar);
    }

    public void a(int[] iArr) {
        a aVar;
        int size = this.f3832b.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.f3832b.get(i);
            if (StateSet.stateSetMatches(aVar.f3834a, iArr)) {
                break;
            } else {
                i++;
            }
        }
        if (aVar == this.c) {
            return;
        }
        if (this.c != null) {
            b();
        }
        this.c = aVar;
        if (aVar != null) {
            a(aVar);
        }
    }

    private void a(a aVar) {
        this.f3831a = aVar.f3835b;
        this.f3831a.start();
    }

    private void b() {
        if (this.f3831a != null) {
            this.f3831a.cancel();
            this.f3831a = null;
        }
    }

    public void a() {
        if (this.f3831a != null) {
            this.f3831a.end();
            this.f3831a = null;
        }
    }

    /* compiled from: StateListAnimator.java */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        final int[] f3834a;

        /* renamed from: b, reason: collision with root package name */
        final ValueAnimator f3835b;

        a(int[] iArr, ValueAnimator valueAnimator) {
            this.f3834a = iArr;
            this.f3835b = valueAnimator;
        }
    }
}
