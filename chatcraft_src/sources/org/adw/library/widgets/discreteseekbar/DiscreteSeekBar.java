package org.adw.library.widgets.discreteseekbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.core.g.h;
import androidx.core.g.q;
import java.util.Formatter;
import java.util.Locale;
import org.adw.library.widgets.discreteseekbar.a;
import org.adw.library.widgets.discreteseekbar.a.a.a;
import org.adw.library.widgets.discreteseekbar.a.b.b;
import org.adw.library.widgets.discreteseekbar.a.b.e;

/* loaded from: classes.dex */
public class DiscreteSeekBar extends View {

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f5265b;
    private float A;
    private int B;
    private float C;
    private float D;
    private Runnable E;
    private b.a F;

    /* renamed from: a, reason: collision with root package name */
    Formatter f5266a;
    private org.adw.library.widgets.discreteseekbar.a.b.d c;
    private e d;
    private e e;
    private Drawable f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private String q;
    private c r;
    private StringBuilder s;
    private d t;
    private boolean u;
    private int v;
    private Rect w;
    private Rect x;
    private org.adw.library.widgets.discreteseekbar.a.b y;
    private org.adw.library.widgets.discreteseekbar.a.a.a z;

    public interface d {
        void a(DiscreteSeekBar discreteSeekBar);

        void a(DiscreteSeekBar discreteSeekBar, int i, boolean z);

        void b(DiscreteSeekBar discreteSeekBar);
    }

    protected void a() {
    }

    protected void a(int i) {
    }

    protected void b() {
    }

    public static abstract class c {
        public abstract int a(int i);

        public boolean a() {
            return false;
        }

        public String b(int i) {
            return String.valueOf(i);
        }
    }

    private static class b extends c {
        @Override // org.adw.library.widgets.discreteseekbar.DiscreteSeekBar.c
        public int a(int i) {
            return i;
        }

        private b() {
        }
    }

    static {
        f5265b = Build.VERSION.SDK_INT >= 21;
    }

    public DiscreteSeekBar(Context context) {
        this(context, null);
    }

    public DiscreteSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0126a.discreteSeekBarStyle);
    }

    public DiscreteSeekBar(Context context, AttributeSet attributeSet, int i) {
        int integer;
        int integer2;
        super(context, attributeSet, i);
        this.m = 1;
        this.n = false;
        this.o = true;
        this.p = true;
        this.w = new Rect();
        this.x = new Rect();
        this.E = new Runnable() { // from class: org.adw.library.widgets.discreteseekbar.DiscreteSeekBar.2
            @Override // java.lang.Runnable
            public void run() {
                DiscreteSeekBar.this.m();
            }
        };
        this.F = new b.a() { // from class: org.adw.library.widgets.discreteseekbar.DiscreteSeekBar.3
            @Override // org.adw.library.widgets.discreteseekbar.a.b.b.a
            public void b() {
            }

            @Override // org.adw.library.widgets.discreteseekbar.a.b.b.a
            public void a() {
                DiscreteSeekBar.this.c.b();
            }
        };
        setFocusable(true);
        setWillNotDraw(false);
        this.D = ViewConfiguration.get(context).getScaledTouchSlop();
        float f = context.getResources().getDisplayMetrics().density;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.DiscreteSeekBar, i, a.b.Widget_DiscreteSeekBar);
        this.n = typedArrayObtainStyledAttributes.getBoolean(a.c.DiscreteSeekBar_dsb_mirrorForRtl, this.n);
        this.o = typedArrayObtainStyledAttributes.getBoolean(a.c.DiscreteSeekBar_dsb_allowTrackClickToDrag, this.o);
        this.p = typedArrayObtainStyledAttributes.getBoolean(a.c.DiscreteSeekBar_dsb_indicatorPopupEnabled, this.p);
        this.g = typedArrayObtainStyledAttributes.getDimensionPixelSize(a.c.DiscreteSeekBar_dsb_trackHeight, (int) (1.0f * f));
        this.h = typedArrayObtainStyledAttributes.getDimensionPixelSize(a.c.DiscreteSeekBar_dsb_scrubberHeight, (int) (4.0f * f));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(a.c.DiscreteSeekBar_dsb_thumbSize, (int) (12.0f * f));
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(a.c.DiscreteSeekBar_dsb_indicatorSeparation, (int) (5.0f * f));
        this.i = Math.max(0, (((int) (f * 32.0f)) - dimensionPixelSize) / 2);
        int i2 = a.c.DiscreteSeekBar_dsb_max;
        int i3 = a.c.DiscreteSeekBar_dsb_min;
        int i4 = a.c.DiscreteSeekBar_dsb_value;
        TypedValue typedValue = new TypedValue();
        int integer3 = 100;
        if (typedArrayObtainStyledAttributes.getValue(i2, typedValue)) {
            if (typedValue.type == 5) {
                integer3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(i2, 100);
            } else {
                integer3 = typedArrayObtainStyledAttributes.getInteger(i2, 100);
            }
        }
        if (!typedArrayObtainStyledAttributes.getValue(i3, typedValue)) {
            integer = 0;
        } else if (typedValue.type == 5) {
            integer = typedArrayObtainStyledAttributes.getDimensionPixelSize(i3, 0);
        } else {
            integer = typedArrayObtainStyledAttributes.getInteger(i3, 0);
        }
        if (!typedArrayObtainStyledAttributes.getValue(i4, typedValue)) {
            integer2 = 0;
        } else if (typedValue.type == 5) {
            integer2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(i4, 0);
        } else {
            integer2 = typedArrayObtainStyledAttributes.getInteger(i4, 0);
        }
        this.k = integer;
        this.j = Math.max(integer + 1, integer3);
        this.l = Math.max(integer, Math.min(integer3, integer2));
        f();
        this.q = typedArrayObtainStyledAttributes.getString(a.c.DiscreteSeekBar_dsb_indicatorFormatter);
        ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(a.c.DiscreteSeekBar_dsb_trackColor);
        ColorStateList colorStateList2 = typedArrayObtainStyledAttributes.getColorStateList(a.c.DiscreteSeekBar_dsb_progressColor);
        ColorStateList colorStateList3 = typedArrayObtainStyledAttributes.getColorStateList(a.c.DiscreteSeekBar_dsb_rippleColor);
        boolean zIsInEditMode = isInEditMode();
        colorStateList3 = (zIsInEditMode || colorStateList3 == null) ? new ColorStateList(new int[][]{new int[0]}, new int[]{-12303292}) : colorStateList3;
        colorStateList = (zIsInEditMode || colorStateList == null) ? new ColorStateList(new int[][]{new int[0]}, new int[]{-7829368}) : colorStateList;
        colorStateList2 = (zIsInEditMode || colorStateList2 == null) ? new ColorStateList(new int[][]{new int[0]}, new int[]{-16738680}) : colorStateList2;
        this.f = org.adw.library.widgets.discreteseekbar.a.a.c.a(colorStateList3);
        if (f5265b) {
            org.adw.library.widgets.discreteseekbar.a.a.c.a(this, this.f);
        } else {
            this.f.setCallback(this);
        }
        this.d = new e(colorStateList);
        this.d.setCallback(this);
        this.e = new e(colorStateList2);
        this.e.setCallback(this);
        this.c = new org.adw.library.widgets.discreteseekbar.a.b.d(colorStateList2, dimensionPixelSize);
        this.c.setCallback(this);
        this.c.setBounds(0, 0, this.c.getIntrinsicWidth(), this.c.getIntrinsicHeight());
        if (!zIsInEditMode) {
            this.y = new org.adw.library.widgets.discreteseekbar.a.b(context, attributeSet, i, d(this.j), dimensionPixelSize, this.i + dimensionPixelSize + dimensionPixelSize2);
            this.y.a(this.F);
        }
        typedArrayObtainStyledAttributes.recycle();
        setNumericTransformer(new b());
    }

    public void setIndicatorFormatter(String str) {
        this.q = str;
        c(this.l);
    }

    public void setNumericTransformer(c cVar) {
        if (cVar == null) {
            cVar = new b();
        }
        this.r = cVar;
        e();
        c(this.l);
    }

    public c getNumericTransformer() {
        return this.r;
    }

    public void setMax(int i) {
        this.j = i;
        if (this.j < this.k) {
            setMin(this.j - 1);
        }
        f();
        if (this.l < this.k || this.l > this.j) {
            setProgress(this.k);
        }
        e();
    }

    public int getMax() {
        return this.j;
    }

    public void setMin(int i) {
        this.k = i;
        if (this.k > this.j) {
            setMax(this.k + 1);
        }
        f();
        if (this.l < this.k || this.l > this.j) {
            setProgress(this.k);
        }
    }

    public int getMin() {
        return this.k;
    }

    public void setProgress(int i) {
        a(i, false);
    }

    private void a(int i, boolean z) {
        int iMax = Math.max(this.k, Math.min(this.j, i));
        if (c()) {
            this.z.a();
        }
        if (this.l != iMax) {
            this.l = iMax;
            b(iMax, z);
            c(iMax);
            k();
        }
    }

    public int getProgress() {
        return this.l;
    }

    public void setOnProgressChangeListener(d dVar) {
        this.t = dVar;
    }

    public void setScrubberColor(int i) {
        this.e.b(ColorStateList.valueOf(i));
    }

    public void setScrubberColor(ColorStateList colorStateList) {
        this.e.b(colorStateList);
    }

    public void setRippleColor(int i) {
        setRippleColor(new ColorStateList(new int[][]{new int[0]}, new int[]{i}));
    }

    public void setRippleColor(ColorStateList colorStateList) {
        org.adw.library.widgets.discreteseekbar.a.a.c.a(this.f, colorStateList);
    }

    public void setTrackColor(int i) {
        this.d.b(ColorStateList.valueOf(i));
    }

    public void setTrackColor(ColorStateList colorStateList) {
        this.d.b(colorStateList);
    }

    public void setIndicatorPopupEnabled(boolean z) {
        this.p = z;
    }

    private void e() {
        if (isInEditMode()) {
            return;
        }
        if (this.r.a()) {
            this.y.a(this.r.b(this.j));
        } else {
            this.y.a(d(this.r.a(this.j)));
        }
    }

    private void b(int i, boolean z) {
        if (this.t != null) {
            this.t.a(this, i, z);
        }
        a(i);
    }

    private void a(boolean z) {
        if (z) {
            a();
        } else {
            b();
        }
    }

    private void f() {
        int i = this.j - this.k;
        if (this.m == 0 || i / this.m > 20) {
            this.m = Math.max(1, Math.round(i / 20.0f));
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), this.c.getIntrinsicHeight() + getPaddingTop() + getPaddingBottom() + (this.i * 2));
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            removeCallbacks(this.E);
            if (!isInEditMode()) {
                this.y.c();
            }
            g();
        }
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        super.scheduleDrawable(drawable, runnable, j);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int intrinsicWidth = this.c.getIntrinsicWidth();
        int intrinsicHeight = this.c.getIntrinsicHeight();
        int i5 = this.i;
        int i6 = intrinsicWidth / 2;
        int paddingLeft = getPaddingLeft() + i5;
        int paddingRight = getPaddingRight();
        int height = (getHeight() - getPaddingBottom()) - i5;
        this.c.setBounds(paddingLeft, height - intrinsicHeight, intrinsicWidth + paddingLeft, height);
        int iMax = Math.max(this.g / 2, 1);
        int i7 = paddingLeft + i6;
        int i8 = height - i6;
        this.d.setBounds(i7, i8 - iMax, ((getWidth() - i6) - paddingRight) - i5, iMax + i8);
        int iMax2 = Math.max(this.h / 2, 2);
        this.e.setBounds(i7, i8 - iMax2, i7, i8 + iMax2);
        k();
    }

    @Override // android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        if (!f5265b) {
            this.f.draw(canvas);
        }
        super.onDraw(canvas);
        this.d.draw(canvas);
        this.e.draw(canvas);
        this.c.draw(canvas);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        g();
    }

    private void g() {
        int[] drawableState = getDrawableState();
        boolean z = false;
        boolean z2 = false;
        for (int i : drawableState) {
            if (i == 16842908) {
                z = true;
            } else if (i == 16842919) {
                z2 = true;
            }
        }
        if (isEnabled() && ((z || z2) && this.p)) {
            removeCallbacks(this.E);
            postDelayed(this.E, 150L);
        } else {
            n();
        }
        this.c.setState(drawableState);
        this.d.setState(drawableState);
        this.e.setState(drawableState);
        this.f.setState(drawableState);
    }

    private void c(int i) {
        if (isInEditMode()) {
            return;
        }
        if (this.r.a()) {
            this.y.a((CharSequence) this.r.b(i));
        } else {
            this.y.a((CharSequence) d(this.r.a(i)));
        }
    }

    private String d(int i) {
        String str = this.q != null ? this.q : "%d";
        if (this.f5266a == null || !this.f5266a.locale().equals(Locale.getDefault())) {
            int length = str.length() + String.valueOf(this.j).length();
            if (this.s == null) {
                this.s = new StringBuilder(length);
            } else {
                this.s.ensureCapacity(length);
            }
            this.f5266a = new Formatter(this.s, Locale.getDefault());
        } else {
            this.s.setLength(0);
        }
        return this.f5266a.format(str, Integer.valueOf(i)).toString();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        switch (h.a(motionEvent)) {
            case 0:
                this.C = motionEvent.getX();
                a(motionEvent, h());
                return true;
            case 1:
                if (!i() && this.o) {
                    a(motionEvent, false);
                    a(motionEvent);
                }
                j();
                return true;
            case 2:
                if (i()) {
                    a(motionEvent);
                    return true;
                }
                if (Math.abs(motionEvent.getX() - this.C) <= this.D) {
                    return true;
                }
                a(motionEvent, false);
                return true;
            case 3:
                j();
                return true;
            default:
                return true;
        }
    }

    private boolean h() {
        return org.adw.library.widgets.discreteseekbar.a.a.c.a(getParent());
    }

    private boolean a(MotionEvent motionEvent, boolean z) {
        Rect rect = this.x;
        this.c.copyBounds(rect);
        rect.inset(-this.i, -this.i);
        this.u = rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        if (!this.u && this.o && !z) {
            this.u = true;
            this.v = (rect.width() / 2) - this.i;
            a(motionEvent);
            this.c.copyBounds(rect);
            rect.inset(-this.i, -this.i);
        }
        if (this.u) {
            setPressed(true);
            l();
            a(motionEvent.getX(), motionEvent.getY());
            this.v = (int) ((motionEvent.getX() - rect.left) - this.i);
            if (this.t != null) {
                this.t.a(this);
            }
        }
        return this.u;
    }

    private boolean i() {
        return this.u;
    }

    private void j() {
        if (this.t != null) {
            this.t.b(this);
        }
        this.u = false;
        setPressed(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L29
            int r0 = r4.getAnimatedProgress()
            switch(r5) {
                case 21: goto L1c;
                case 22: goto L10;
                default: goto Lf;
            }
        Lf:
            goto L29
        L10:
            int r3 = r4.j
            if (r0 < r3) goto L15
            goto L27
        L15:
            int r3 = r4.m
            int r0 = r0 + r3
            r4.b(r0)
            goto L27
        L1c:
            int r3 = r4.k
            if (r0 > r3) goto L21
            goto L27
        L21:
            int r3 = r4.m
            int r0 = r0 - r3
            r4.b(r0)
        L27:
            r0 = 1
            goto L2a
        L29:
            r0 = 0
        L2a:
            if (r0 != 0) goto L32
            boolean r5 = super.onKeyDown(r5, r6)
            if (r5 == 0) goto L33
        L32:
            r1 = 1
        L33:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.adw.library.widgets.discreteseekbar.DiscreteSeekBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    private int getAnimatedProgress() {
        return c() ? getAnimationTarget() : this.l;
    }

    boolean c() {
        return this.z != null && this.z.b();
    }

    void b(int i) {
        float animationPosition = c() ? getAnimationPosition() : getProgress();
        if (i < this.k) {
            i = this.k;
        } else if (i > this.j) {
            i = this.j;
        }
        if (this.z != null) {
            this.z.a();
        }
        this.B = i;
        this.z = org.adw.library.widgets.discreteseekbar.a.a.a.a(animationPosition, i, new a.InterfaceC0127a() { // from class: org.adw.library.widgets.discreteseekbar.DiscreteSeekBar.1
            @Override // org.adw.library.widgets.discreteseekbar.a.a.a.InterfaceC0127a
            public void a(float f) {
                DiscreteSeekBar.this.setAnimationPosition(f);
            }
        });
        this.z.a(250);
        this.z.c();
    }

    private int getAnimationTarget() {
        return this.B;
    }

    void setAnimationPosition(float f) {
        this.A = f;
        a((f - this.k) / (this.j - this.k));
    }

    float getAnimationPosition() {
        return this.A;
    }

    private void a(MotionEvent motionEvent) {
        a(motionEvent.getX(), motionEvent.getY());
        int x = (int) motionEvent.getX();
        int iWidth = this.c.getBounds().width() / 2;
        int i = this.i;
        int i2 = (x - this.v) + iWidth;
        int paddingLeft = getPaddingLeft() + iWidth + i;
        int width = getWidth() - ((getPaddingRight() + iWidth) + i);
        if (i2 < paddingLeft) {
            i2 = paddingLeft;
        } else if (i2 > width) {
            i2 = width;
        }
        float f = (i2 - paddingLeft) / (width - paddingLeft);
        if (d()) {
            f = 1.0f - f;
        }
        a(Math.round((f * (this.j - this.k)) + this.k), true);
    }

    private void a(float f) {
        int iWidth = this.c.getBounds().width() / 2;
        int i = this.i;
        int width = (getWidth() - ((getPaddingRight() + iWidth) + i)) - ((getPaddingLeft() + iWidth) + i);
        int iRound = Math.round(((this.j - this.k) * f) + this.k);
        if (iRound != getProgress()) {
            this.l = iRound;
            b(this.l, true);
            c(iRound);
        }
        e((int) ((f * width) + 0.5f));
    }

    private void k() {
        int intrinsicWidth = this.c.getIntrinsicWidth();
        int i = this.i;
        int i2 = intrinsicWidth / 2;
        e((int) ((((this.l - this.k) / (this.j - this.k)) * ((getWidth() - ((getPaddingRight() + i2) + i)) - ((getPaddingLeft() + i2) + i))) + 0.5f));
    }

    private void e(int i) {
        int paddingLeft;
        int i2;
        int intrinsicWidth = this.c.getIntrinsicWidth();
        int i3 = intrinsicWidth / 2;
        if (d()) {
            paddingLeft = (getWidth() - getPaddingRight()) - this.i;
            i2 = (paddingLeft - i) - intrinsicWidth;
        } else {
            paddingLeft = getPaddingLeft() + this.i;
            i2 = i + paddingLeft;
        }
        this.c.copyBounds(this.w);
        this.c.setBounds(i2, this.w.top, intrinsicWidth + i2, this.w.bottom);
        if (d()) {
            this.e.getBounds().right = paddingLeft - i3;
            this.e.getBounds().left = i2 + i3;
        } else {
            this.e.getBounds().left = paddingLeft + i3;
            this.e.getBounds().right = i2 + i3;
        }
        Rect rect = this.x;
        this.c.copyBounds(rect);
        if (!isInEditMode()) {
            this.y.a(rect.centerX());
        }
        this.w.inset(-this.i, -this.i);
        rect.inset(-this.i, -this.i);
        this.w.union(rect);
        org.adw.library.widgets.discreteseekbar.a.a.c.a(this.f, rect.left, rect.top, rect.right, rect.bottom);
        invalidate(this.w);
    }

    private void a(float f, float f2) {
        androidx.core.graphics.drawable.a.a(this.f, f, f2);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.c || drawable == this.d || drawable == this.e || drawable == this.f || super.verifyDrawable(drawable);
    }

    private void l() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (isInEditMode()) {
            return;
        }
        this.c.a();
        this.y.a(this, this.c.getBounds());
        a(true);
    }

    private void n() {
        removeCallbacks(this.E);
        if (isInEditMode()) {
            return;
        }
        this.y.b();
        a(false);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.E);
        if (isInEditMode()) {
            return;
        }
        this.y.c();
    }

    public boolean d() {
        return q.f(this) == 1 && this.n;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.f5270a = getProgress();
        aVar.f5271b = this.j;
        aVar.c = this.k;
        return aVar;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(a.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        setMin(aVar.c);
        setMax(aVar.f5271b);
        a(aVar.f5270a, false);
        super.onRestoreInstanceState(aVar.getSuperState());
    }

    static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: org.adw.library.widgets.discreteseekbar.DiscreteSeekBar.a.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i) {
                return new a[i];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private int f5270a;

        /* renamed from: b, reason: collision with root package name */
        private int f5271b;
        private int c;

        public a(Parcel parcel) {
            super(parcel);
            this.f5270a = parcel.readInt();
            this.f5271b = parcel.readInt();
            this.c = parcel.readInt();
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f5270a);
            parcel.writeInt(this.f5271b);
            parcel.writeInt(this.c);
        }
    }
}
