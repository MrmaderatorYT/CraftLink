package org.adw.library.widgets.discreteseekbar.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.g.q;
import org.adw.library.widgets.discreteseekbar.a;
import org.adw.library.widgets.discreteseekbar.a.a.c;
import org.adw.library.widgets.discreteseekbar.a.b.b;

/* compiled from: Marker.java */
/* loaded from: classes.dex */
public class a extends ViewGroup implements b.a {

    /* renamed from: a, reason: collision with root package name */
    org.adw.library.widgets.discreteseekbar.a.b.b f5272a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f5273b;
    private int c;
    private int d;

    public a(Context context, AttributeSet attributeSet, int i, String str, int i2, int i3) {
        super(context, attributeSet, i);
        setVisibility(0);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.DiscreteSeekBar, a.C0126a.discreteSeekBarStyle, a.b.Widget_DiscreteSeekBar);
        int i4 = ((int) (displayMetrics.density * 4.0f)) * 2;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(a.c.DiscreteSeekBar_dsb_indicatorTextAppearance, a.b.Widget_DiscreteIndicatorTextAppearance);
        this.f5273b = new TextView(context);
        this.f5273b.setPadding(i4, 0, i4, 0);
        this.f5273b.setTextAppearance(context, resourceId);
        this.f5273b.setGravity(17);
        this.f5273b.setText(str);
        this.f5273b.setMaxLines(1);
        this.f5273b.setSingleLine(true);
        c.a(this.f5273b, 5);
        this.f5273b.setVisibility(4);
        setPadding(i4, i4, i4, i4);
        a(str);
        this.d = i3;
        this.f5272a = new org.adw.library.widgets.discreteseekbar.a.b.b(typedArrayObtainStyledAttributes.getColorStateList(a.c.DiscreteSeekBar_dsb_indicatorColor), i2);
        this.f5272a.setCallback(this);
        this.f5272a.a(this);
        this.f5272a.a(i4);
        q.a(this, typedArrayObtainStyledAttributes.getDimension(a.c.DiscreteSeekBar_dsb_indicatorElevation, displayMetrics.density * 8.0f));
        if (Build.VERSION.SDK_INT >= 21) {
            c.a((View) this, this.f5272a);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void a(String str) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f5273b.setText("-" + str);
        this.f5273b.measure(View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, Integer.MIN_VALUE));
        this.c = Math.max(this.f5273b.getMeasuredWidth(), this.f5273b.getMeasuredHeight());
        removeView(this.f5273b);
        addView(this.f5273b, new FrameLayout.LayoutParams(this.c, this.c, 51));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.f5272a.draw(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        measureChildren(i, i2);
        setMeasuredDimension(this.c + getPaddingLeft() + getPaddingRight(), this.c + getPaddingTop() + getPaddingBottom() + (((int) ((this.c * 1.41f) - this.c)) / 2) + this.d);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        this.f5273b.layout(paddingLeft, paddingTop, this.c + paddingLeft, this.c + paddingTop);
        this.f5272a.setBounds(paddingLeft, paddingTop, width, height);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f5272a || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    public void setValue(CharSequence charSequence) {
        this.f5273b.setText(charSequence);
    }

    public CharSequence getValue() {
        return this.f5273b.getText();
    }

    public void c() {
        this.f5272a.stop();
        this.f5272a.b();
    }

    public void d() {
        this.f5272a.stop();
        this.f5273b.setVisibility(4);
        this.f5272a.c();
    }

    @Override // org.adw.library.widgets.discreteseekbar.a.b.b.a
    public void b() {
        this.f5273b.setVisibility(0);
        if (getParent() instanceof b.a) {
            ((b.a) getParent()).b();
        }
    }

    @Override // org.adw.library.widgets.discreteseekbar.a.b.b.a
    public void a() {
        if (getParent() instanceof b.a) {
            ((b.a) getParent()).a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f5272a.stop();
    }
}
