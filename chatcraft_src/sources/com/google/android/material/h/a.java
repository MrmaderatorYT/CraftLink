package com.google.android.material.h;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.appcompat.b.a.c;
import com.google.android.material.a;

/* compiled from: ShadowDrawableWrapper.java */
/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: a, reason: collision with root package name */
    static final double f3803a = Math.cos(Math.toRadians(45.0d));

    /* renamed from: b, reason: collision with root package name */
    final Paint f3804b;
    final Paint c;
    final RectF d;
    float e;
    Path f;
    float g;
    float h;
    float i;
    float j;
    private boolean k;
    private final int l;
    private final int m;
    private final int n;
    private boolean o;
    private float p;
    private boolean q;

    @Override // androidx.appcompat.b.a.c, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public a(Context context, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.k = true;
        this.o = true;
        this.q = false;
        this.l = androidx.core.a.a.c(context, a.c.design_fab_shadow_start_color);
        this.m = androidx.core.a.a.c(context, a.c.design_fab_shadow_mid_color);
        this.n = androidx.core.a.a.c(context, a.c.design_fab_shadow_end_color);
        this.f3804b = new Paint(5);
        this.f3804b.setStyle(Paint.Style.FILL);
        this.e = Math.round(f);
        this.d = new RectF();
        this.c = new Paint(this.f3804b);
        this.c.setAntiAlias(false);
        a(f2, f3);
    }

    private static int c(float f) {
        int iRound = Math.round(f);
        return iRound % 2 == 1 ? iRound - 1 : iRound;
    }

    public void a(boolean z) {
        this.o = z;
        invalidateSelf();
    }

    @Override // androidx.appcompat.b.a.c, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        super.setAlpha(i);
        this.f3804b.setAlpha(i);
        this.c.setAlpha(i);
    }

    @Override // androidx.appcompat.b.a.c, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.k = true;
    }

    public void a(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float fC = c(f);
        float fC2 = c(f2);
        if (fC > fC2) {
            if (!this.q) {
                this.q = true;
            }
            fC = fC2;
        }
        if (this.j == fC && this.h == fC2) {
            return;
        }
        this.j = fC;
        this.h = fC2;
        this.i = Math.round(fC * 1.5f);
        this.g = fC2;
        this.k = true;
        invalidateSelf();
    }

    public void a(float f) {
        a(f, this.h);
    }

    public float b() {
        return this.j;
    }

    @Override // androidx.appcompat.b.a.c, android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(a(this.h, this.e, this.o));
        int iCeil2 = (int) Math.ceil(b(this.h, this.e, this.o));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    public static float a(float f, float f2, boolean z) {
        if (!z) {
            return f * 1.5f;
        }
        double d = f * 1.5f;
        double d2 = 1.0d - f3803a;
        double d3 = f2;
        Double.isNaN(d3);
        Double.isNaN(d);
        return (float) (d + (d2 * d3));
    }

    public static float b(float f, float f2, boolean z) {
        if (!z) {
            return f;
        }
        double d = f;
        double d2 = 1.0d - f3803a;
        double d3 = f2;
        Double.isNaN(d3);
        Double.isNaN(d);
        return (float) (d + (d2 * d3));
    }

    @Override // androidx.appcompat.b.a.c, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.k) {
            a(getBounds());
            this.k = false;
        }
        a(canvas);
        super.draw(canvas);
    }

    public final void b(float f) {
        if (this.p != f) {
            this.p = f;
            invalidateSelf();
        }
    }

    private void a(Canvas canvas) {
        int i;
        float f;
        int i2;
        float f2;
        float f3;
        float f4;
        int iSave = canvas.save();
        canvas.rotate(this.p, this.d.centerX(), this.d.centerY());
        float f5 = (-this.e) - this.i;
        float f6 = this.e;
        float f7 = f6 * 2.0f;
        boolean z = this.d.width() - f7 > 0.0f;
        boolean z2 = this.d.height() - f7 > 0.0f;
        float f8 = this.j - (this.j * 0.25f);
        float f9 = f6 / ((this.j - (this.j * 0.5f)) + f6);
        float f10 = f6 / (f8 + f6);
        float f11 = f6 / ((this.j - (this.j * 1.0f)) + f6);
        int iSave2 = canvas.save();
        canvas.translate(this.d.left + f6, this.d.top + f6);
        canvas.scale(f9, f10);
        canvas.drawPath(this.f, this.f3804b);
        if (z) {
            canvas.scale(1.0f / f9, 1.0f);
            i = iSave2;
            f = f11;
            i2 = iSave;
            f2 = f10;
            canvas.drawRect(0.0f, f5, this.d.width() - f7, -this.e, this.c);
        } else {
            i = iSave2;
            f = f11;
            i2 = iSave;
            f2 = f10;
        }
        canvas.restoreToCount(i);
        int iSave3 = canvas.save();
        canvas.translate(this.d.right - f6, this.d.bottom - f6);
        float f12 = f;
        canvas.scale(f9, f12);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f, this.f3804b);
        if (z) {
            canvas.scale(1.0f / f9, 1.0f);
            f3 = f2;
            f4 = f12;
            canvas.drawRect(0.0f, f5, this.d.width() - f7, (-this.e) + this.i, this.c);
        } else {
            f3 = f2;
            f4 = f12;
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        canvas.translate(this.d.left + f6, this.d.bottom - f6);
        canvas.scale(f9, f4);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f, this.f3804b);
        if (z2) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f5, this.d.height() - f7, -this.e, this.c);
        }
        canvas.restoreToCount(iSave4);
        int iSave5 = canvas.save();
        canvas.translate(this.d.right - f6, this.d.top + f6);
        float f13 = f3;
        canvas.scale(f9, f13);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f, this.f3804b);
        if (z2) {
            canvas.scale(1.0f / f13, 1.0f);
            canvas.drawRect(0.0f, f5, this.d.height() - f7, -this.e, this.c);
        }
        canvas.restoreToCount(iSave5);
        canvas.restoreToCount(i2);
    }

    private void c() {
        RectF rectF = new RectF(-this.e, -this.e, this.e, this.e);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.i, -this.i);
        if (this.f == null) {
            this.f = new Path();
        } else {
            this.f.reset();
        }
        this.f.setFillType(Path.FillType.EVEN_ODD);
        this.f.moveTo(-this.e, 0.0f);
        this.f.rLineTo(-this.i, 0.0f);
        this.f.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f.arcTo(rectF, 270.0f, -90.0f, false);
        this.f.close();
        float f = -rectF2.top;
        if (f > 0.0f) {
            float f2 = this.e / f;
            this.f3804b.setShader(new RadialGradient(0.0f, 0.0f, f, new int[]{0, this.l, this.m, this.n}, new float[]{0.0f, f2, ((1.0f - f2) / 2.0f) + f2, 1.0f}, Shader.TileMode.CLAMP));
        }
        this.c.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.l, this.m, this.n}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.c.setAntiAlias(false);
    }

    private void a(Rect rect) {
        float f = this.h * 1.5f;
        this.d.set(rect.left + this.h, rect.top + f, rect.right - this.h, rect.bottom - f);
        a().setBounds((int) this.d.left, (int) this.d.top, (int) this.d.right, (int) this.d.bottom);
        c();
    }
}
