package org.adw.library.widgets.discreteseekbar.a.b;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* compiled from: StateDrawable.java */
/* loaded from: classes.dex */
public abstract class c extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private ColorStateList f5290a;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f5291b;
    private int c;
    private int d = 255;

    abstract void a(Canvas canvas, Paint paint);

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public c(ColorStateList colorStateList) {
        b(colorStateList);
        this.f5291b = new Paint(1);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f5290a.isStateful() || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return a(iArr) || super.setState(iArr);
    }

    private boolean a(int[] iArr) {
        int colorForState = this.f5290a.getColorForState(iArr, this.c);
        if (colorForState == this.c) {
            return false;
        }
        this.c = colorForState;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f5291b.setColor(this.c);
        this.f5291b.setAlpha(b(Color.alpha(this.c)));
        a(canvas, this.f5291b);
    }

    public void b(ColorStateList colorStateList) {
        this.f5290a = colorStateList;
        this.c = colorStateList.getDefaultColor();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.d = i;
        invalidateSelf();
    }

    int b(int i) {
        return (i * (this.d + (this.d >> 7))) >> 8;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f5291b.setColorFilter(colorFilter);
    }
}
