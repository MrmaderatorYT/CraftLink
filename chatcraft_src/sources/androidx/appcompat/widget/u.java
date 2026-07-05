package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.a;
import java.lang.reflect.InvocationTargetException;

/* compiled from: AppCompatSeekBarHelper.java */
/* loaded from: classes.dex */
class u extends r {

    /* renamed from: a, reason: collision with root package name */
    private final SeekBar f430a;

    /* renamed from: b, reason: collision with root package name */
    private Drawable f431b;
    private ColorStateList c;
    private PorterDuff.Mode d;
    private boolean e;
    private boolean f;

    u(SeekBar seekBar) {
        super(seekBar);
        this.c = null;
        this.d = null;
        this.e = false;
        this.f = false;
        this.f430a = seekBar;
    }

    @Override // androidx.appcompat.widget.r
    void a(AttributeSet attributeSet, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.a(attributeSet, i);
        as asVarA = as.a(this.f430a.getContext(), attributeSet, a.j.AppCompatSeekBar, i, 0);
        Drawable drawableB = asVarA.b(a.j.AppCompatSeekBar_android_thumb);
        if (drawableB != null) {
            this.f430a.setThumb(drawableB);
        }
        a(asVarA.a(a.j.AppCompatSeekBar_tickMark));
        if (asVarA.g(a.j.AppCompatSeekBar_tickMarkTintMode)) {
            this.d = ab.a(asVarA.a(a.j.AppCompatSeekBar_tickMarkTintMode, -1), this.d);
            this.f = true;
        }
        if (asVarA.g(a.j.AppCompatSeekBar_tickMarkTint)) {
            this.c = asVarA.e(a.j.AppCompatSeekBar_tickMarkTint);
            this.e = true;
        }
        asVarA.a();
        d();
    }

    void a(Drawable drawable) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f431b != null) {
            this.f431b.setCallback(null);
        }
        this.f431b = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f430a);
            androidx.core.graphics.drawable.a.b(drawable, androidx.core.g.q.f(this.f430a));
            if (drawable.isStateful()) {
                drawable.setState(this.f430a.getDrawableState());
            }
            d();
        }
        this.f430a.invalidate();
    }

    private void d() {
        if (this.f431b != null) {
            if (this.e || this.f) {
                this.f431b = androidx.core.graphics.drawable.a.g(this.f431b.mutate());
                if (this.e) {
                    androidx.core.graphics.drawable.a.a(this.f431b, this.c);
                }
                if (this.f) {
                    androidx.core.graphics.drawable.a.a(this.f431b, this.d);
                }
                if (this.f431b.isStateful()) {
                    this.f431b.setState(this.f430a.getDrawableState());
                }
            }
        }
    }

    void b() {
        if (this.f431b != null) {
            this.f431b.jumpToCurrentState();
        }
    }

    void c() {
        Drawable drawable = this.f431b;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f430a.getDrawableState())) {
            this.f430a.invalidateDrawable(drawable);
        }
    }

    void a(Canvas canvas) {
        if (this.f431b != null) {
            int max = this.f430a.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f431b.getIntrinsicWidth();
                int intrinsicHeight = this.f431b.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f431b.setBounds(-i, -i2, i, i2);
                float width = ((this.f430a.getWidth() - this.f430a.getPaddingLeft()) - this.f430a.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.f430a.getPaddingLeft(), this.f430a.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.f431b.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }
}
