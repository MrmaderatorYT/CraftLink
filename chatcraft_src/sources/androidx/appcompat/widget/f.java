package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.a;

/* compiled from: AppCompatBackgroundHelper.java */
/* loaded from: classes.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    private final View f404a;
    private aq d;
    private aq e;
    private aq f;
    private int c = -1;

    /* renamed from: b, reason: collision with root package name */
    private final j f405b = j.a();

    f(View view) {
        this.f404a = view;
    }

    void a(AttributeSet attributeSet, int i) {
        as asVarA = as.a(this.f404a.getContext(), attributeSet, a.j.ViewBackgroundHelper, i, 0);
        try {
            if (asVarA.g(a.j.ViewBackgroundHelper_android_background)) {
                this.c = asVarA.g(a.j.ViewBackgroundHelper_android_background, -1);
                ColorStateList colorStateListB = this.f405b.b(this.f404a.getContext(), this.c);
                if (colorStateListB != null) {
                    b(colorStateListB);
                }
            }
            if (asVarA.g(a.j.ViewBackgroundHelper_backgroundTint)) {
                androidx.core.g.q.a(this.f404a, asVarA.e(a.j.ViewBackgroundHelper_backgroundTint));
            }
            if (asVarA.g(a.j.ViewBackgroundHelper_backgroundTintMode)) {
                androidx.core.g.q.a(this.f404a, ab.a(asVarA.a(a.j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            asVarA.a();
        }
    }

    void a(int i) {
        this.c = i;
        b(this.f405b != null ? this.f405b.b(this.f404a.getContext(), i) : null);
        c();
    }

    void a(Drawable drawable) {
        this.c = -1;
        b((ColorStateList) null);
        c();
    }

    void a(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new aq();
        }
        this.e.f364a = colorStateList;
        this.e.d = true;
        c();
    }

    ColorStateList a() {
        if (this.e != null) {
            return this.e.f364a;
        }
        return null;
    }

    void a(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new aq();
        }
        this.e.f365b = mode;
        this.e.c = true;
        c();
    }

    PorterDuff.Mode b() {
        if (this.e != null) {
            return this.e.f365b;
        }
        return null;
    }

    void c() {
        Drawable background = this.f404a.getBackground();
        if (background != null) {
            if (d() && b(background)) {
                return;
            }
            if (this.e != null) {
                j.a(background, this.e, this.f404a.getDrawableState());
            } else if (this.d != null) {
                j.a(background, this.d, this.f404a.getDrawableState());
            }
        }
    }

    void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new aq();
            }
            this.d.f364a = colorStateList;
            this.d.d = true;
        } else {
            this.d = null;
        }
        c();
    }

    private boolean d() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.d != null : i == 21;
    }

    private boolean b(Drawable drawable) {
        if (this.f == null) {
            this.f = new aq();
        }
        aq aqVar = this.f;
        aqVar.a();
        ColorStateList colorStateListT = androidx.core.g.q.t(this.f404a);
        if (colorStateListT != null) {
            aqVar.d = true;
            aqVar.f364a = colorStateListT;
        }
        PorterDuff.Mode modeU = androidx.core.g.q.u(this.f404a);
        if (modeU != null) {
            aqVar.c = true;
            aqVar.f365b = modeU;
        }
        if (!aqVar.d && !aqVar.c) {
            return false;
        }
        j.a(drawable, aqVar, this.f404a.getDrawableState());
        return true;
    }
}
