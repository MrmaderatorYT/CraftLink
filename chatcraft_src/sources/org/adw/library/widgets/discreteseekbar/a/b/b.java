package org.adw.library.widgets.discreteseekbar.a.b;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

/* compiled from: MarkerDrawable.java */
/* loaded from: classes.dex */
public class b extends c implements Animatable {

    /* renamed from: a, reason: collision with root package name */
    Path f5287a;

    /* renamed from: b, reason: collision with root package name */
    RectF f5288b;
    Matrix c;
    private float d;
    private Interpolator e;
    private long f;
    private boolean g;
    private boolean h;
    private int i;
    private float j;
    private float k;
    private int l;
    private int m;
    private int n;
    private a o;
    private final Runnable p;

    /* compiled from: MarkerDrawable.java */
    public interface a {
        void a();

        void b();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
    }

    public b(ColorStateList colorStateList, int i) {
        super(colorStateList);
        this.d = 0.0f;
        this.g = false;
        this.h = false;
        this.i = 250;
        this.f5287a = new Path();
        this.f5288b = new RectF();
        this.c = new Matrix();
        this.p = new Runnable() { // from class: org.adw.library.widgets.discreteseekbar.a.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                long jUptimeMillis = SystemClock.uptimeMillis();
                long j = jUptimeMillis - b.this.f;
                if (j < b.this.i) {
                    float interpolation = b.this.e.getInterpolation(j / b.this.i);
                    b.this.scheduleSelf(b.this.p, jUptimeMillis + 16);
                    b.this.a(interpolation);
                } else {
                    b.this.unscheduleSelf(b.this.p);
                    b.this.h = false;
                    b.this.a(1.0f);
                    b.this.d();
                }
            }
        };
        this.e = new AccelerateDecelerateInterpolator();
        this.j = i;
        this.m = colorStateList.getColorForState(new int[]{R.attr.state_enabled, R.attr.state_pressed}, colorStateList.getDefaultColor());
        this.n = colorStateList.getDefaultColor();
    }

    public void a(int i) {
        this.l = i;
    }

    @Override // org.adw.library.widgets.discreteseekbar.a.b.c
    void a(Canvas canvas, Paint paint) {
        if (this.f5287a.isEmpty()) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(a(this.m, this.n, this.d));
        canvas.drawPath(this.f5287a, paint);
    }

    public Path a() {
        return this.f5287a;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a(rect);
    }

    private void a(Rect rect) {
        float f = this.d;
        Path path = this.f5287a;
        RectF rectF = this.f5288b;
        Matrix matrix = this.c;
        path.reset();
        int iMin = Math.min(rect.width(), rect.height());
        float f2 = this.j;
        float f3 = f2 + ((iMin - f2) * f);
        float f4 = f3 / 2.0f;
        float f5 = 1.0f - f;
        float f6 = f4 * f5;
        rectF.set(rect.left, rect.top, rect.left + f3, rect.top + f3);
        path.addRoundRect(rectF, new float[]{f4, f4, f4, f4, f4, f4, f6, f6}, Path.Direction.CCW);
        matrix.reset();
        matrix.postRotate(-45.0f, rect.left + f4, rect.top + f4);
        matrix.postTranslate((rect.width() - f3) / 2.0f, 0.0f);
        matrix.postTranslate(0.0f, ((rect.bottom - f3) - this.l) * f5);
        path.transform(matrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f) {
        float f2 = this.k;
        this.d = f2 + (((this.g ? 0.0f : 1.0f) - f2) * f);
        a(getBounds());
        invalidateSelf();
    }

    public void b() {
        unscheduleSelf(this.p);
        this.g = false;
        if (this.d < 1.0f) {
            this.h = true;
            this.k = this.d;
            this.i = (int) ((1.0f - this.d) * 250.0f);
            this.f = SystemClock.uptimeMillis();
            scheduleSelf(this.p, this.f + 16);
            return;
        }
        d();
    }

    public void c() {
        this.g = true;
        unscheduleSelf(this.p);
        if (this.d > 0.0f) {
            this.h = true;
            this.k = this.d;
            this.i = 250 - ((int) ((1.0f - this.d) * 250.0f));
            this.f = SystemClock.uptimeMillis();
            scheduleSelf(this.p, this.f + 16);
            return;
        }
        d();
    }

    public void a(a aVar) {
        this.o = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.o != null) {
            if (this.g) {
                this.o.a();
            } else {
                this.o.b();
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        unscheduleSelf(this.p);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.h;
    }

    private static int a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((Color.alpha(i) * f) + (Color.alpha(i2) * f2)), (int) ((Color.red(i) * f) + (Color.red(i2) * f2)), (int) ((Color.green(i) * f) + (Color.green(i2) * f2)), (int) ((Color.blue(i) * f) + (Color.blue(i2) * f2)));
    }
}
