package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.appcompat.a;

/* compiled from: AppCompatImageButton.java */
/* loaded from: classes.dex */
public class m extends ImageButton implements androidx.core.g.p, androidx.core.widget.k {

    /* renamed from: a, reason: collision with root package name */
    private final f f416a;

    /* renamed from: b, reason: collision with root package name */
    private final n f417b;

    public m(Context context) {
        this(context, null);
    }

    public m(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0018a.imageButtonStyle);
    }

    public m(Context context, AttributeSet attributeSet, int i) {
        super(ap.a(context), attributeSet, i);
        this.f416a = new f(this);
        this.f416a.a(attributeSet, i);
        this.f417b = new n(this);
        this.f417b.a(attributeSet, i);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.f417b.a(i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.f417b != null) {
            this.f417b.d();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.f417b != null) {
            this.f417b.d();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.f417b != null) {
            this.f417b.d();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f416a != null) {
            this.f416a.a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f416a != null) {
            this.f416a.a(drawable);
        }
    }

    @Override // androidx.core.g.p
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f416a != null) {
            this.f416a.a(colorStateList);
        }
    }

    @Override // androidx.core.g.p
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f416a != null) {
            return this.f416a.a();
        }
        return null;
    }

    @Override // androidx.core.g.p
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f416a != null) {
            this.f416a.a(mode);
        }
    }

    @Override // androidx.core.g.p
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f416a != null) {
            return this.f416a.b();
        }
        return null;
    }

    @Override // androidx.core.widget.k
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f417b != null) {
            this.f417b.a(colorStateList);
        }
    }

    @Override // androidx.core.widget.k
    public ColorStateList getSupportImageTintList() {
        if (this.f417b != null) {
            return this.f417b.b();
        }
        return null;
    }

    @Override // androidx.core.widget.k
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f417b != null) {
            this.f417b.a(mode);
        }
    }

    @Override // androidx.core.widget.k
    public PorterDuff.Mode getSupportImageTintMode() {
        if (this.f417b != null) {
            return this.f417b.c();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f416a != null) {
            this.f416a.c();
        }
        if (this.f417b != null) {
            this.f417b.d();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f417b.a() && super.hasOverlappingRendering();
    }
}
