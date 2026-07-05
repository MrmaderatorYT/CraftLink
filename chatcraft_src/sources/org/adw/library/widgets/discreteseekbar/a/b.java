package org.adw.library.widgets.discreteseekbar.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.IBinder;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import org.adw.library.widgets.discreteseekbar.a.a.c;
import org.adw.library.widgets.discreteseekbar.a.b.b;

/* compiled from: PopupIndicator.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private final WindowManager f5281b;
    private boolean c;
    private a d;
    private b.a e;
    private int[] f = new int[2];

    /* renamed from: a, reason: collision with root package name */
    Point f5280a = new Point();

    private int c(int i) {
        return (i & (-426521)) | 32768 | 8 | 16 | 512;
    }

    public b(Context context, AttributeSet attributeSet, int i, String str, int i2, int i3) {
        this.f5281b = (WindowManager) context.getSystemService("window");
        this.d = new a(context, attributeSet, i, str, i2, i3);
    }

    public void a(String str) {
        c();
        if (this.d != null) {
            this.d.f5285b.a(str);
        }
    }

    public void a(b.a aVar) {
        this.e = aVar;
    }

    private void d() {
        this.d.measure(View.MeasureSpec.makeMeasureSpec(this.f5280a.x, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f5280a.y, Integer.MIN_VALUE));
    }

    public void a(CharSequence charSequence) {
        this.d.f5285b.setValue(charSequence);
    }

    public boolean a() {
        return this.c;
    }

    public void a(View view, Rect rect) {
        if (!a()) {
            IBinder windowToken = view.getWindowToken();
            if (windowToken != null) {
                WindowManager.LayoutParams layoutParamsA = a(windowToken);
                layoutParamsA.gravity = 8388659;
                a(view, layoutParamsA, rect.bottom);
                this.c = true;
                b(rect.centerX());
                a(layoutParamsA);
                return;
            }
            return;
        }
        this.d.f5285b.c();
    }

    public void a(int i) {
        if (a()) {
            b(i);
        }
    }

    public void b() {
        this.d.f5285b.d();
    }

    public void c() {
        if (a()) {
            this.c = false;
            this.f5281b.removeViewImmediate(this.d);
        }
    }

    private void a(View view, WindowManager.LayoutParams layoutParams, int i) {
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        this.f5280a.set(displayMetrics.widthPixels, displayMetrics.heightPixels);
        d();
        int measuredHeight = this.d.getMeasuredHeight();
        int paddingBottom = this.d.f5285b.getPaddingBottom();
        view.getLocationInWindow(this.f);
        layoutParams.x = 0;
        layoutParams.y = (this.f[1] - measuredHeight) + i + paddingBottom;
        layoutParams.width = this.f5280a.x;
        layoutParams.height = measuredHeight;
    }

    private void b(int i) {
        this.d.a(i + this.f[0]);
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        this.f5281b.addView(this.d, layoutParams);
        this.d.f5285b.c();
    }

    private WindowManager.LayoutParams a(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 8388659;
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.format = -3;
        layoutParams.flags = c(layoutParams.flags);
        layoutParams.type = 1000;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = 3;
        layoutParams.setTitle("DiscreteSeekBar Indicator:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* compiled from: PopupIndicator.java */
    private class a extends FrameLayout implements b.a {

        /* renamed from: b, reason: collision with root package name */
        private org.adw.library.widgets.discreteseekbar.a.a f5285b;
        private int c;

        public a(Context context, AttributeSet attributeSet, int i, String str, int i2, int i3) {
            super(context);
            this.f5285b = new org.adw.library.widgets.discreteseekbar.a.a(context, attributeSet, i, str, i2, i3);
            addView(this.f5285b, new FrameLayout.LayoutParams(-2, -2, 51));
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            measureChildren(i, i2);
            setMeasuredDimension(View.MeasureSpec.getSize(i), this.f5285b.getMeasuredHeight());
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int measuredWidth = this.c - (this.f5285b.getMeasuredWidth() / 2);
            this.f5285b.layout(measuredWidth, 0, this.f5285b.getMeasuredWidth() + measuredWidth, this.f5285b.getMeasuredHeight());
        }

        public void a(int i) {
            this.c = i;
            this.f5285b.offsetLeftAndRight((i - (this.f5285b.getMeasuredWidth() / 2)) - this.f5285b.getLeft());
            if (c.a((View) this)) {
                return;
            }
            invalidate();
        }

        @Override // org.adw.library.widgets.discreteseekbar.a.b.b.a
        public void a() {
            if (b.this.e != null) {
                b.this.e.a();
            }
            b.this.c();
        }

        @Override // org.adw.library.widgets.discreteseekbar.a.b.b.a
        public void b() {
            if (b.this.e != null) {
                b.this.e.b();
            }
        }
    }
}
