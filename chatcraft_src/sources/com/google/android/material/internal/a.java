package com.google.android.material.internal;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* compiled from: CircularBorderDrawable.java */
/* loaded from: classes.dex */
public class a extends Drawable {
    float e;
    private int f;
    private int g;
    private int h;
    private int i;
    private ColorStateList j;
    private int k;
    private float m;

    /* renamed from: b, reason: collision with root package name */
    final Rect f3821b = new Rect();
    final RectF c = new RectF();
    final C0085a d = new C0085a();
    private boolean l = true;

    /* renamed from: a, reason: collision with root package name */
    final Paint f3820a = new Paint(1);

    public a() {
        this.f3820a.setStyle(Paint.Style.STROKE);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.d;
    }

    public void a(int i, int i2, int i3, int i4) {
        this.f = i;
        this.g = i2;
        this.h = i3;
        this.i = i4;
    }

    public void a(float f) {
        if (this.e != f) {
            this.e = f;
            this.f3820a.setStrokeWidth(f * 1.3333f);
            this.l = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.l) {
            this.f3820a.setShader(a());
            this.l = false;
        }
        float strokeWidth = this.f3820a.getStrokeWidth() / 2.0f;
        RectF rectF = this.c;
        copyBounds(this.f3821b);
        rectF.set(this.f3821b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.m, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.f3820a);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iRound = Math.round(this.e);
        rect.set(iRound, iRound, iRound, iRound);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f3820a.setAlpha(i);
        invalidateSelf();
    }

    public void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.k = colorStateList.getColorForState(getState(), this.k);
        }
        this.j = colorStateList;
        this.l = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3820a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.e > 0.0f ? -3 : -2;
    }

    public final void b(float f) {
        if (f != this.m) {
            this.m = f;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.l = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return (this.j != null && this.j.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState;
        if (this.j != null && (colorForState = this.j.getColorForState(iArr, this.k)) != this.k) {
            this.l = true;
            this.k = colorForState;
        }
        if (this.l) {
            invalidateSelf();
        }
        return this.l;
    }

    private Shader a() {
        copyBounds(this.f3821b);
        float fHeight = this.e / r0.height();
        return new LinearGradient(0.0f, r0.top, 0.0f, r0.bottom, new int[]{androidx.core.graphics.a.a(this.f, this.k), androidx.core.graphics.a.a(this.g, this.k), androidx.core.graphics.a.a(androidx.core.graphics.a.b(this.g, 0), this.k), androidx.core.graphics.a.a(androidx.core.graphics.a.b(this.i, 0), this.k), androidx.core.graphics.a.a(this.i, this.k), androidx.core.graphics.a.a(this.h, this.k)}, new float[]{0.0f, fHeight, 0.5f, 0.5f, 1.0f - fHeight, 1.0f}, Shader.TileMode.CLAMP);
    }

    /* compiled from: CircularBorderDrawable.java */
    /* renamed from: com.google.android.material.internal.a$a, reason: collision with other inner class name */
    private class C0085a extends Drawable.ConstantState {
        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        private C0085a() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return a.this;
        }
    }
}
