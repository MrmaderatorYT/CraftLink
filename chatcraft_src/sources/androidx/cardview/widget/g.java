package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.cardview.a;

/* compiled from: RoundRectDrawableWithShadow.java */
/* loaded from: classes.dex */
class g extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    static a f512a;

    /* renamed from: b, reason: collision with root package name */
    private static final double f513b = Math.cos(Math.toRadians(45.0d));
    private final int c;
    private Paint e;
    private Paint f;
    private final RectF g;
    private float h;
    private Path i;
    private float j;
    private float k;
    private float l;
    private ColorStateList m;
    private final int o;
    private final int p;
    private boolean n = true;
    private boolean q = true;
    private boolean r = false;
    private Paint d = new Paint(5);

    /* compiled from: RoundRectDrawableWithShadow.java */
    interface a {
        void a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    g(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.o = resources.getColor(a.b.cardview_shadow_start_color);
        this.p = resources.getColor(a.b.cardview_shadow_end_color);
        this.c = resources.getDimensionPixelSize(a.c.cardview_compat_inset_shadow);
        b(colorStateList);
        this.e = new Paint(5);
        this.e.setStyle(Paint.Style.FILL);
        this.h = (int) (f + 0.5f);
        this.g = new RectF();
        this.f = new Paint(this.e);
        this.f.setAntiAlias(false);
        a(f2, f3);
    }

    private void b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.m = colorStateList;
        this.d.setColor(this.m.getColorForState(getState(), this.m.getDefaultColor()));
    }

    private int d(float f) {
        int i = (int) (f + 0.5f);
        return i % 2 == 1 ? i - 1 : i;
    }

    void a(boolean z) {
        this.q = z;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.d.setAlpha(i);
        this.e.setAlpha(i);
        this.f.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.n = true;
    }

    private void a(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        }
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        }
        float fD = d(f);
        float fD2 = d(f2);
        if (fD > fD2) {
            if (!this.r) {
                this.r = true;
            }
            fD = fD2;
        }
        if (this.l == fD && this.j == fD2) {
            return;
        }
        this.l = fD;
        this.j = fD2;
        this.k = (int) ((fD * 1.5f) + this.c + 0.5f);
        this.n = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(a(this.j, this.h, this.q));
        int iCeil2 = (int) Math.ceil(b(this.j, this.h, this.q));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    static float a(float f, float f2, boolean z) {
        if (!z) {
            return f * 1.5f;
        }
        double d = f * 1.5f;
        double d2 = 1.0d - f513b;
        double d3 = f2;
        Double.isNaN(d3);
        Double.isNaN(d);
        return (float) (d + (d2 * d3));
    }

    static float b(float f, float f2, boolean z) {
        if (!z) {
            return f;
        }
        double d = f;
        double d2 = 1.0d - f513b;
        double d3 = f2;
        Double.isNaN(d3);
        Double.isNaN(d);
        return (float) (d + (d2 * d3));
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.m.getColorForState(iArr, this.m.getDefaultColor());
        if (this.d.getColor() == colorForState) {
            return false;
        }
        this.d.setColor(colorForState);
        this.n = true;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return (this.m != null && this.m.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.d.setColorFilter(colorFilter);
    }

    void a(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
        }
        float f2 = (int) (f + 0.5f);
        if (this.h == f2) {
            return;
        }
        this.h = f2;
        this.n = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.n) {
            b(getBounds());
            this.n = false;
        }
        canvas.translate(0.0f, this.l / 2.0f);
        a(canvas);
        canvas.translate(0.0f, (-this.l) / 2.0f);
        f512a.a(canvas, this.g, this.h, this.d);
    }

    private void a(Canvas canvas) {
        float f = (-this.h) - this.k;
        float f2 = this.h + this.c + (this.l / 2.0f);
        float f3 = f2 * 2.0f;
        boolean z = this.g.width() - f3 > 0.0f;
        boolean z2 = this.g.height() - f3 > 0.0f;
        int iSave = canvas.save();
        canvas.translate(this.g.left + f2, this.g.top + f2);
        canvas.drawPath(this.i, this.e);
        if (z) {
            canvas.drawRect(0.0f, f, this.g.width() - f3, -this.h, this.f);
        }
        canvas.restoreToCount(iSave);
        int iSave2 = canvas.save();
        canvas.translate(this.g.right - f2, this.g.bottom - f2);
        canvas.rotate(180.0f);
        canvas.drawPath(this.i, this.e);
        if (z) {
            canvas.drawRect(0.0f, f, this.g.width() - f3, (-this.h) + this.k, this.f);
        }
        canvas.restoreToCount(iSave2);
        int iSave3 = canvas.save();
        canvas.translate(this.g.left + f2, this.g.bottom - f2);
        canvas.rotate(270.0f);
        canvas.drawPath(this.i, this.e);
        if (z2) {
            canvas.drawRect(0.0f, f, this.g.height() - f3, -this.h, this.f);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        canvas.translate(this.g.right - f2, this.g.top + f2);
        canvas.rotate(90.0f);
        canvas.drawPath(this.i, this.e);
        if (z2) {
            canvas.drawRect(0.0f, f, this.g.height() - f3, -this.h, this.f);
        }
        canvas.restoreToCount(iSave4);
    }

    private void g() {
        RectF rectF = new RectF(-this.h, -this.h, this.h, this.h);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.k, -this.k);
        if (this.i == null) {
            this.i = new Path();
        } else {
            this.i.reset();
        }
        this.i.setFillType(Path.FillType.EVEN_ODD);
        this.i.moveTo(-this.h, 0.0f);
        this.i.rLineTo(-this.k, 0.0f);
        this.i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.i.arcTo(rectF, 270.0f, -90.0f, false);
        this.i.close();
        this.e.setShader(new RadialGradient(0.0f, 0.0f, this.h + this.k, new int[]{this.o, this.o, this.p}, new float[]{0.0f, this.h / (this.h + this.k), 1.0f}, Shader.TileMode.CLAMP));
        this.f.setShader(new LinearGradient(0.0f, (-this.h) + this.k, 0.0f, (-this.h) - this.k, new int[]{this.o, this.o, this.p}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f.setAntiAlias(false);
    }

    private void b(Rect rect) {
        float f = this.j * 1.5f;
        this.g.set(rect.left + this.j, rect.top + f, rect.right - this.j, rect.bottom - f);
        g();
    }

    float a() {
        return this.h;
    }

    void a(Rect rect) {
        getPadding(rect);
    }

    void b(float f) {
        a(f, this.j);
    }

    void c(float f) {
        a(this.l, f);
    }

    float b() {
        return this.l;
    }

    float c() {
        return this.j;
    }

    float d() {
        return (Math.max(this.j, this.h + this.c + (this.j / 2.0f)) * 2.0f) + ((this.j + this.c) * 2.0f);
    }

    float e() {
        return (Math.max(this.j, this.h + this.c + ((this.j * 1.5f) / 2.0f)) * 2.0f) + (((this.j * 1.5f) + this.c) * 2.0f);
    }

    void a(ColorStateList colorStateList) {
        b(colorStateList);
        invalidateSelf();
    }

    ColorStateList f() {
        return this.m;
    }
}
