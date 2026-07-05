package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* compiled from: ForwardingListener.java */
/* loaded from: classes.dex */
public abstract class ae implements View.OnAttachStateChangeListener, View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private final float f329a;

    /* renamed from: b, reason: collision with root package name */
    private final int f330b;
    final View c;
    private final int d;
    private Runnable e;
    private Runnable f;
    private boolean g;
    private int h;
    private final int[] i = new int[2];

    public abstract androidx.appcompat.view.menu.s a();

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    public ae(View view) {
        this.c = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f329a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f330b = ViewConfiguration.getTapTimeout();
        this.d = (this.f330b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.g;
        if (z2) {
            z = b(motionEvent) || !c();
        } else {
            z = a(motionEvent) && b();
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.c.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.g = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.g = false;
        this.h = -1;
        if (this.e != null) {
            this.c.removeCallbacks(this.e);
        }
    }

    protected boolean b() {
        androidx.appcompat.view.menu.s sVarA = a();
        if (sVarA == null || sVarA.d()) {
            return true;
        }
        sVarA.a();
        return true;
    }

    protected boolean c() {
        androidx.appcompat.view.menu.s sVarA = a();
        if (sVarA == null || !sVarA.d()) {
            return true;
        }
        sVarA.c();
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean a(MotionEvent motionEvent) {
        View view = this.c;
        if (!view.isEnabled()) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.h = motionEvent.getPointerId(0);
                if (this.e == null) {
                    this.e = new a();
                }
                view.postDelayed(this.e, this.f330b);
                if (this.f == null) {
                    this.f = new b();
                }
                view.postDelayed(this.f, this.d);
                return false;
            case 1:
            case 3:
                e();
                return false;
            case 2:
                int iFindPointerIndex = motionEvent.findPointerIndex(this.h);
                if (iFindPointerIndex >= 0 && !a(view, motionEvent.getX(iFindPointerIndex), motionEvent.getY(iFindPointerIndex), this.f329a)) {
                    e();
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    private void e() {
        if (this.f != null) {
            this.c.removeCallbacks(this.f);
        }
        if (this.e != null) {
            this.c.removeCallbacks(this.e);
        }
    }

    void d() {
        e();
        View view = this.c;
        if (view.isEnabled() && !view.isLongClickable() && b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.g = true;
        }
    }

    private boolean b(MotionEvent motionEvent) throws IllegalAccessException, IllegalArgumentException {
        ac acVar;
        View view = this.c;
        androidx.appcompat.view.menu.s sVarA = a();
        if (sVarA == null || !sVarA.d() || (acVar = (ac) sVarA.e()) == null || !acVar.isShown()) {
            return false;
        }
        MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        b(view, motionEventObtainNoHistory);
        a(acVar, motionEventObtainNoHistory);
        boolean zA = acVar.a(motionEventObtainNoHistory, this.h);
        motionEventObtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return zA && (actionMasked != 1 && actionMasked != 3);
    }

    private static boolean a(View view, float f, float f2, float f3) {
        float f4 = -f3;
        return f >= f4 && f2 >= f4 && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.i);
        motionEvent.offsetLocation(-r0[0], -r0[1]);
        return true;
    }

    private boolean b(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.i);
        motionEvent.offsetLocation(r0[0], r0[1]);
        return true;
    }

    /* compiled from: ForwardingListener.java */
    private class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = ae.this.c.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* compiled from: ForwardingListener.java */
    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ae.this.d();
        }
    }
}
