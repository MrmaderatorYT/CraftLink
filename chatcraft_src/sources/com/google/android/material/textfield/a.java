package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;

/* compiled from: CutoutDrawable.java */
/* loaded from: classes.dex */
class a extends GradientDrawable {

    /* renamed from: a, reason: collision with root package name */
    private final Paint f3877a = new Paint(1);

    /* renamed from: b, reason: collision with root package name */
    private final RectF f3878b;
    private int c;

    a() {
        c();
        this.f3878b = new RectF();
    }

    private void c() {
        this.f3877a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f3877a.setColor(-1);
        this.f3877a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    boolean a() {
        return !this.f3878b.isEmpty();
    }

    void a(float f, float f2, float f3, float f4) {
        if (f == this.f3878b.left && f2 == this.f3878b.top && f3 == this.f3878b.right && f4 == this.f3878b.bottom) {
            return;
        }
        this.f3878b.set(f, f2, f3, f4);
        invalidateSelf();
    }

    void a(RectF rectF) {
        a(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    void b() {
        a(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        a(canvas);
        super.draw(canvas);
        canvas.drawRect(this.f3878b, this.f3877a);
        c(canvas);
    }

    private void a(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (a(callback)) {
            ((View) callback).setLayerType(2, null);
        } else {
            b(canvas);
        }
    }

    private void b(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.c = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        } else {
            this.c = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
        }
    }

    private void c(Canvas canvas) {
        if (a(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.c);
    }

    private boolean a(Drawable.Callback callback) {
        return callback instanceof View;
    }
}
