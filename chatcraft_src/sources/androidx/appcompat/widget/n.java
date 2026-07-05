package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.a;

/* compiled from: AppCompatImageHelper.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private final ImageView f418a;

    /* renamed from: b, reason: collision with root package name */
    private aq f419b;
    private aq c;
    private aq d;

    public n(ImageView imageView) {
        this.f418a = imageView;
    }

    public void a(AttributeSet attributeSet, int i) {
        int iG;
        as asVarA = as.a(this.f418a.getContext(), attributeSet, a.j.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.f418a.getDrawable();
            if (drawable == null && (iG = asVarA.g(a.j.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = androidx.appcompat.a.a.a.b(this.f418a.getContext(), iG)) != null) {
                this.f418a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                ab.b(drawable);
            }
            if (asVarA.g(a.j.AppCompatImageView_tint)) {
                androidx.core.widget.e.a(this.f418a, asVarA.e(a.j.AppCompatImageView_tint));
            }
            if (asVarA.g(a.j.AppCompatImageView_tintMode)) {
                androidx.core.widget.e.a(this.f418a, ab.a(asVarA.a(a.j.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            asVarA.a();
        }
    }

    public void a(int i) {
        if (i != 0) {
            Drawable drawableB = androidx.appcompat.a.a.a.b(this.f418a.getContext(), i);
            if (drawableB != null) {
                ab.b(drawableB);
            }
            this.f418a.setImageDrawable(drawableB);
        } else {
            this.f418a.setImageDrawable(null);
        }
        d();
    }

    boolean a() {
        return Build.VERSION.SDK_INT < 21 || !(this.f418a.getBackground() instanceof RippleDrawable);
    }

    void a(ColorStateList colorStateList) {
        if (this.c == null) {
            this.c = new aq();
        }
        this.c.f364a = colorStateList;
        this.c.d = true;
        d();
    }

    ColorStateList b() {
        if (this.c != null) {
            return this.c.f364a;
        }
        return null;
    }

    void a(PorterDuff.Mode mode) {
        if (this.c == null) {
            this.c = new aq();
        }
        this.c.f365b = mode;
        this.c.c = true;
        d();
    }

    PorterDuff.Mode c() {
        if (this.c != null) {
            return this.c.f365b;
        }
        return null;
    }

    void d() {
        Drawable drawable = this.f418a.getDrawable();
        if (drawable != null) {
            ab.b(drawable);
        }
        if (drawable != null) {
            if (e() && a(drawable)) {
                return;
            }
            if (this.c != null) {
                j.a(drawable, this.c, this.f418a.getDrawableState());
            } else if (this.f419b != null) {
                j.a(drawable, this.f419b, this.f418a.getDrawableState());
            }
        }
    }

    private boolean e() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f419b != null : i == 21;
    }

    private boolean a(Drawable drawable) {
        if (this.d == null) {
            this.d = new aq();
        }
        aq aqVar = this.d;
        aqVar.a();
        ColorStateList colorStateListA = androidx.core.widget.e.a(this.f418a);
        if (colorStateListA != null) {
            aqVar.d = true;
            aqVar.f364a = colorStateListA;
        }
        PorterDuff.Mode modeB = androidx.core.widget.e.b(this.f418a);
        if (modeB != null) {
            aqVar.c = true;
            aqVar.f365b = modeB;
        }
        if (!aqVar.d && !aqVar.c) {
            return false;
        }
        j.a(drawable, aqVar, this.f418a.getDrawableState());
        return true;
    }
}
