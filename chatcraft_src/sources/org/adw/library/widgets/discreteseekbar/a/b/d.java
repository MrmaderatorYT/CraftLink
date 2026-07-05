package org.adw.library.widgets.discreteseekbar.a.b;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.os.SystemClock;

/* compiled from: ThumbDrawable.java */
/* loaded from: classes.dex */
public class d extends c implements Animatable {

    /* renamed from: a, reason: collision with root package name */
    private final int f5292a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5293b;
    private boolean c;
    private Runnable d;

    @Override // android.graphics.drawable.Animatable
    public void start() {
    }

    public d(ColorStateList colorStateList, int i) {
        super(colorStateList);
        this.d = new Runnable() { // from class: org.adw.library.widgets.discreteseekbar.a.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.f5293b = true;
                d.this.invalidateSelf();
                d.this.c = false;
            }
        };
        this.f5292a = i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f5292a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f5292a;
    }

    @Override // org.adw.library.widgets.discreteseekbar.a.b.c
    public void a(Canvas canvas, Paint paint) {
        if (this.f5293b) {
            return;
        }
        Rect bounds = getBounds();
        canvas.drawCircle(bounds.centerX(), bounds.centerY(), this.f5292a / 2, paint);
    }

    public void a() {
        scheduleSelf(this.d, SystemClock.uptimeMillis() + 100);
        this.c = true;
    }

    public void b() {
        this.f5293b = false;
        this.c = false;
        unscheduleSelf(this.d);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        b();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.c;
    }
}
