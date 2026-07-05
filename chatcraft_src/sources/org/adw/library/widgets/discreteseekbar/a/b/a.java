package org.adw.library.widgets.discreteseekbar.a.b;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

/* compiled from: AlmostRippleDrawable.java */
/* loaded from: classes.dex */
public class a extends c implements Animatable {

    /* renamed from: a, reason: collision with root package name */
    private float f5282a;

    /* renamed from: b, reason: collision with root package name */
    private Interpolator f5283b;
    private long c;
    private boolean d;
    private boolean e;
    private int f;
    private float g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private final Runnable m;

    private int a(int i) {
        return (i * 100) >> 8;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
    }

    public a(ColorStateList colorStateList) {
        super(colorStateList);
        this.f5282a = 0.0f;
        this.d = false;
        this.e = false;
        this.f = 250;
        this.m = new Runnable() { // from class: org.adw.library.widgets.discreteseekbar.a.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                long jUptimeMillis = SystemClock.uptimeMillis();
                long j = jUptimeMillis - a.this.c;
                if (j < a.this.f) {
                    float interpolation = a.this.f5283b.getInterpolation(j / a.this.f);
                    a.this.scheduleSelf(a.this.m, jUptimeMillis + 16);
                    a.this.a(interpolation);
                } else {
                    a.this.unscheduleSelf(a.this.m);
                    a.this.e = false;
                    a.this.a(1.0f);
                }
            }
        };
        this.f5283b = new AccelerateDecelerateInterpolator();
        a(colorStateList);
    }

    public void a(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.i = colorStateList.getColorForState(new int[]{R.attr.state_enabled, R.attr.state_focused}, defaultColor);
        this.h = colorStateList.getColorForState(new int[]{R.attr.state_enabled, R.attr.state_pressed}, defaultColor);
        this.j = colorStateList.getColorForState(new int[]{-16842910}, defaultColor);
        this.i = a(130, this.i);
        this.h = a(130, this.h);
        this.j = a(130, this.j);
    }

    private static int a(int i, int i2) {
        return Color.argb((Color.alpha(i2) * (i + (i >> 7))) >> 8, Color.red(i2), Color.green(i2), Color.blue(i2));
    }

    @Override // org.adw.library.widgets.discreteseekbar.a.b.c
    public void a(Canvas canvas, Paint paint) {
        Rect bounds = getBounds();
        int iMin = Math.min(bounds.width(), bounds.height());
        float f = this.f5282a;
        int i = this.k;
        int i2 = this.l;
        float f2 = iMin / 2;
        float f3 = f2 * f;
        if (f > 0.0f) {
            if (i2 != 0) {
                paint.setColor(i2);
                paint.setAlpha(a(Color.alpha(i2)));
                canvas.drawCircle(bounds.centerX(), bounds.centerY(), f2, paint);
            }
            if (i != 0) {
                paint.setColor(i);
                paint.setAlpha(b(Color.alpha(i)));
                canvas.drawCircle(bounds.centerX(), bounds.centerY(), f3, paint);
            }
        }
    }

    @Override // org.adw.library.widgets.discreteseekbar.a.b.c, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        boolean z = false;
        for (int i : getState()) {
            if (i == 16842919) {
                z = true;
            }
        }
        super.setState(iArr);
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = false;
        for (int i2 : iArr) {
            if (i2 == 16842908) {
                z4 = true;
            } else if (i2 == 16842919) {
                z3 = true;
            } else if (i2 == 16842910) {
                z2 = false;
            }
        }
        if (z2) {
            unscheduleSelf(this.m);
            this.k = this.j;
            this.l = 0;
            this.f5282a = 0.5f;
            invalidateSelf();
        } else if (z3) {
            a();
            int i3 = this.h;
            this.l = i3;
            this.k = i3;
        } else if (z) {
            int i4 = this.h;
            this.l = i4;
            this.k = i4;
            b();
        } else if (z4) {
            this.k = this.i;
            this.l = 0;
            this.f5282a = 1.0f;
            invalidateSelf();
        } else {
            this.k = 0;
            this.l = 0;
            this.f5282a = 0.0f;
            invalidateSelf();
        }
        return true;
    }

    public void a() {
        unscheduleSelf(this.m);
        if (this.f5282a < 1.0f) {
            this.d = false;
            this.e = true;
            this.g = this.f5282a;
            this.f = (int) ((1.0f - ((this.g - 0.0f) / 1.0f)) * 250.0f);
            this.c = SystemClock.uptimeMillis();
            scheduleSelf(this.m, this.c + 16);
        }
    }

    public void b() {
        unscheduleSelf(this.m);
        if (this.f5282a > 0.0f) {
            this.d = true;
            this.e = true;
            this.g = this.f5282a;
            this.f = (int) ((1.0f - ((this.g - 1.0f) / (-1.0f))) * 250.0f);
            this.c = SystemClock.uptimeMillis();
            scheduleSelf(this.m, this.c + 16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f) {
        float f2 = this.g;
        this.f5282a = f2 + (((this.d ? 0.0f : 1.0f) - f2) * f);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.e;
    }
}
