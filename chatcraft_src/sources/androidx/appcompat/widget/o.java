package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: AppCompatImageView.java */
/* loaded from: classes.dex */
public class o extends ImageView implements androidx.core.g.p, androidx.core.widget.k {

    /* renamed from: a, reason: collision with root package name */
    private final f f420a;

    /* renamed from: b, reason: collision with root package name */
    private final n f421b;

    public o(Context context) {
        this(context, null);
    }

    public o(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public o(Context context, AttributeSet attributeSet, int i) {
        super(ap.a(context), attributeSet, i);
        this.f420a = new f(this);
        this.f420a.a(attributeSet, i);
        this.f421b = new n(this);
        this.f421b.a(attributeSet, i);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (this.f421b != null) {
            this.f421b.a(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.f421b != null) {
            this.f421b.d();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.f421b != null) {
            this.f421b.d();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.f421b != null) {
            this.f421b.d();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f420a != null) {
            this.f420a.a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f420a != null) {
            this.f420a.a(drawable);
        }
    }

    @Override // androidx.core.g.p
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f420a != null) {
            this.f420a.a(colorStateList);
        }
    }

    @Override // androidx.core.g.p
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f420a != null) {
            return this.f420a.a();
        }
        return null;
    }

    @Override // androidx.core.g.p
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f420a != null) {
            this.f420a.a(mode);
        }
    }

    @Override // androidx.core.g.p
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f420a != null) {
            return this.f420a.b();
        }
        return null;
    }

    @Override // androidx.core.widget.k
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f421b != null) {
            this.f421b.a(colorStateList);
        }
    }

    @Override // androidx.core.widget.k
    public ColorStateList getSupportImageTintList() {
        if (this.f421b != null) {
            return this.f421b.b();
        }
        return null;
    }

    @Override // androidx.core.widget.k
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f421b != null) {
            this.f421b.a(mode);
        }
    }

    @Override // androidx.core.widget.k
    public PorterDuff.Mode getSupportImageTintMode() {
        if (this.f421b != null) {
            return this.f421b.c();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f420a != null) {
            this.f420a.c();
        }
        if (this.f421b != null) {
            this.f421b.d();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f421b.a() && super.hasOverlappingRendering();
    }
}
