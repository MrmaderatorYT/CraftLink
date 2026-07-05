package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.squareup.picasso.t;

/* compiled from: ImageViewAction.java */
/* loaded from: classes.dex */
class l extends a<ImageView> {
    e m;

    l(t tVar, ImageView imageView, w wVar, int i, int i2, int i3, Drawable drawable, String str, Object obj, e eVar, boolean z) {
        super(tVar, imageView, wVar, i, i2, i3, drawable, str, obj, z);
        this.m = eVar;
    }

    @Override // com.squareup.picasso.a
    public void a(Bitmap bitmap, t.d dVar) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", this));
        }
        ImageView imageView = (ImageView) this.c.get();
        if (imageView == null) {
            return;
        }
        u.a(imageView, this.f4099a.c, bitmap, dVar, this.d, this.f4099a.k);
        if (this.m != null) {
            this.m.a();
        }
    }

    @Override // com.squareup.picasso.a
    public void a(Exception exc) {
        ImageView imageView = (ImageView) this.c.get();
        if (imageView == null) {
            return;
        }
        Object drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        if (this.g != 0) {
            imageView.setImageResource(this.g);
        } else if (this.h != null) {
            imageView.setImageDrawable(this.h);
        }
        if (this.m != null) {
            this.m.a(exc);
        }
    }

    @Override // com.squareup.picasso.a
    void a() {
        super.a();
        if (this.m != null) {
            this.m = null;
        }
    }
}
