package androidx.appcompat.widget;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* compiled from: TooltipCompatHandler.java */
/* loaded from: classes.dex */
class av implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {
    private static av j;
    private static av k;

    /* renamed from: a, reason: collision with root package name */
    private final View f375a;

    /* renamed from: b, reason: collision with root package name */
    private final CharSequence f376b;
    private final int c;
    private final Runnable d = new Runnable() { // from class: androidx.appcompat.widget.av.1
        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            av.this.a(false);
        }
    };
    private final Runnable e = new Runnable() { // from class: androidx.appcompat.widget.av.2
        @Override // java.lang.Runnable
        public void run() {
            av.this.a();
        }
    };
    private int f;
    private int g;
    private aw h;
    private boolean i;

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    public static void a(View view, CharSequence charSequence) {
        if (j != null && j.f375a == view) {
            a((av) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            if (k != null && k.f375a == view) {
                k.a();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new av(view, charSequence);
    }

    private av(View view, CharSequence charSequence) {
        this.f375a = view;
        this.f376b = charSequence;
        this.c = androidx.core.g.r.a(ViewConfiguration.get(this.f375a.getContext()));
        d();
        this.f375a.setOnLongClickListener(this);
        this.f375a.setOnHoverListener(this);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) throws Resources.NotFoundException {
        this.f = view.getWidth() / 2;
        this.g = view.getHeight() / 2;
        a(true);
        return true;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.h != null && this.i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f375a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                d();
                a();
            }
        } else if (this.f375a.isEnabled() && this.h == null && a(motionEvent)) {
            a(this);
        }
        return false;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        a();
    }

    void a(boolean z) throws Resources.NotFoundException {
        long longPressTimeout;
        if (androidx.core.g.q.A(this.f375a)) {
            a((av) null);
            if (k != null) {
                k.a();
            }
            k = this;
            this.i = z;
            this.h = new aw(this.f375a.getContext());
            this.h.a(this.f375a, this.f, this.g, this.i, this.f376b);
            this.f375a.addOnAttachStateChangeListener(this);
            if (this.i) {
                longPressTimeout = 2500;
            } else if ((androidx.core.g.q.o(this.f375a) & 1) == 1) {
                longPressTimeout = 3000 - ViewConfiguration.getLongPressTimeout();
            } else {
                longPressTimeout = 15000 - ViewConfiguration.getLongPressTimeout();
            }
            this.f375a.removeCallbacks(this.e);
            this.f375a.postDelayed(this.e, longPressTimeout);
        }
    }

    void a() {
        if (k == this) {
            k = null;
            if (this.h != null) {
                this.h.a();
                this.h = null;
                d();
                this.f375a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (j == this) {
            a((av) null);
        }
        this.f375a.removeCallbacks(this.e);
    }

    private static void a(av avVar) {
        if (j != null) {
            j.c();
        }
        j = avVar;
        if (j != null) {
            j.b();
        }
    }

    private void b() {
        this.f375a.postDelayed(this.d, ViewConfiguration.getLongPressTimeout());
    }

    private void c() {
        this.f375a.removeCallbacks(this.d);
    }

    private boolean a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.f) <= this.c && Math.abs(y - this.g) <= this.c) {
            return false;
        }
        this.f = x;
        this.g = y;
        return true;
    }

    private void d() {
        this.f = Integer.MAX_VALUE;
        this.g = Integer.MAX_VALUE;
    }
}
