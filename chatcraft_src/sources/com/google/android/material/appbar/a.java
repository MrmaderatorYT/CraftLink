package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.g.q;

/* compiled from: HeaderBehavior.java */
/* loaded from: classes.dex */
abstract class a<V extends View> extends c<V> {

    /* renamed from: a, reason: collision with root package name */
    OverScroller f3729a;

    /* renamed from: b, reason: collision with root package name */
    private Runnable f3730b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private VelocityTracker g;

    boolean c(V v) {
        return false;
    }

    void e(CoordinatorLayout coordinatorLayout, V v) {
    }

    public a() {
        this.d = -1;
        this.f = -1;
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = -1;
        this.f = -1;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.f < 0) {
            this.f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.c) {
            return true;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.c = false;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (c(v) && coordinatorLayout.a(v, x, y)) {
                    this.e = y;
                    this.d = motionEvent.getPointerId(0);
                    d();
                    break;
                }
                break;
            case 1:
            case 3:
                this.c = false;
                this.d = -1;
                if (this.g != null) {
                    this.g.recycle();
                    this.g = null;
                    break;
                }
                break;
            case 2:
                int i = this.d;
                if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                    int y2 = (int) motionEvent.getY(iFindPointerIndex);
                    if (Math.abs(y2 - this.e) > this.f) {
                        this.c = true;
                        this.e = y2;
                        break;
                    }
                }
                break;
        }
        if (this.g != null) {
            this.g.addMovement(motionEvent);
        }
        return this.c;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b5  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b(androidx.coordinatorlayout.widget.CoordinatorLayout r12, V r13, android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r11.f
            if (r0 >= 0) goto L12
            android.content.Context r0 = r12.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r11.f = r0
        L12:
            int r0 = r14.getActionMasked()
            r1 = 1
            r2 = -1
            r3 = 0
            switch(r0) {
                case 0: goto L8e;
                case 1: goto L59;
                case 2: goto L1e;
                case 3: goto L7d;
                default: goto L1c;
            }
        L1c:
            goto Lb1
        L1e:
            int r0 = r11.d
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r2) goto L27
            return r3
        L27:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r2 = r11.e
            int r2 = r2 - r0
            boolean r3 = r11.c
            if (r3 != 0) goto L46
            int r3 = java.lang.Math.abs(r2)
            int r4 = r11.f
            if (r3 <= r4) goto L46
            r11.c = r1
            if (r2 <= 0) goto L43
            int r3 = r11.f
            int r2 = r2 - r3
            goto L46
        L43:
            int r3 = r11.f
            int r2 = r2 + r3
        L46:
            r6 = r2
            boolean r2 = r11.c
            if (r2 == 0) goto Lb1
            r11.e = r0
            int r7 = r11.b(r13)
            r8 = 0
            r3 = r11
            r4 = r12
            r5 = r13
            r3.b(r4, r5, r6, r7, r8)
            goto Lb1
        L59:
            android.view.VelocityTracker r0 = r11.g
            if (r0 == 0) goto L7d
            android.view.VelocityTracker r0 = r11.g
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.g
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.g
            int r4 = r11.d
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.a(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.a(r6, r7, r8, r9, r10)
        L7d:
            r11.c = r3
            r11.d = r2
            android.view.VelocityTracker r12 = r11.g
            if (r12 == 0) goto Lb1
            android.view.VelocityTracker r12 = r11.g
            r12.recycle()
            r12 = 0
            r11.g = r12
            goto Lb1
        L8e:
            float r0 = r14.getX()
            int r0 = (int) r0
            float r2 = r14.getY()
            int r2 = (int) r2
            boolean r12 = r12.a(r13, r0, r2)
            if (r12 == 0) goto Lb0
            boolean r12 = r11.c(r13)
            if (r12 == 0) goto Lb0
            r11.e = r2
            int r12 = r14.getPointerId(r3)
            r11.d = r12
            r11.d()
            goto Lb1
        Lb0:
            return r3
        Lb1:
            android.view.VelocityTracker r12 = r11.g
            if (r12 == 0) goto Lba
            android.view.VelocityTracker r12 = r11.g
            r12.addMovement(r14)
        Lba:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.a.b(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    int a_(CoordinatorLayout coordinatorLayout, V v, int i) {
        return a(coordinatorLayout, (CoordinatorLayout) v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int iA;
        int iC = c();
        if (i2 == 0 || iC < i2 || iC > i3 || iC == (iA = androidx.core.c.a.a(i, i2, i3))) {
            return 0;
        }
        a(iA);
        return iC - iA;
    }

    int b() {
        return c();
    }

    final int b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return a(coordinatorLayout, (CoordinatorLayout) v, b() - i, i2, i3);
    }

    final boolean a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        if (this.f3730b != null) {
            v.removeCallbacks(this.f3730b);
            this.f3730b = null;
        }
        if (this.f3729a == null) {
            this.f3729a = new OverScroller(v.getContext());
        }
        this.f3729a.fling(0, c(), 0, Math.round(f), 0, 0, i, i2);
        if (this.f3729a.computeScrollOffset()) {
            this.f3730b = new RunnableC0082a(coordinatorLayout, v);
            q.a(v, this.f3730b);
            return true;
        }
        e(coordinatorLayout, v);
        return false;
    }

    int b(V v) {
        return -v.getHeight();
    }

    int a(V v) {
        return v.getHeight();
    }

    private void d() {
        if (this.g == null) {
            this.g = VelocityTracker.obtain();
        }
    }

    /* compiled from: HeaderBehavior.java */
    /* renamed from: com.google.android.material.appbar.a$a, reason: collision with other inner class name */
    private class RunnableC0082a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private final CoordinatorLayout f3732b;
        private final V c;

        RunnableC0082a(CoordinatorLayout coordinatorLayout, V v) {
            this.f3732b = coordinatorLayout;
            this.c = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c == null || a.this.f3729a == null) {
                return;
            }
            if (a.this.f3729a.computeScrollOffset()) {
                a.this.a_(this.f3732b, this.c, a.this.f3729a.getCurrY());
                q.a(this.c, this);
            } else {
                a.this.e(this.f3732b, this.c);
            }
        }
    }
}
