package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.squareup.picasso.t;

/* compiled from: PicassoDrawable.java */
/* loaded from: classes.dex */
final class u extends BitmapDrawable {
    private static final Paint e = new Paint();

    /* renamed from: a, reason: collision with root package name */
    Drawable f4164a;

    /* renamed from: b, reason: collision with root package name */
    long f4165b;
    boolean c;
    int d;
    private final boolean f;
    private final float g;
    private final t.d h;

    /* JADX WARN: Multi-variable type inference failed */
    static void a(ImageView imageView, Context context, Bitmap bitmap, t.d dVar, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        imageView.setImageDrawable(new u(context, bitmap, drawable, dVar, z, z2));
    }

    static void a(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof Animatable) {
            ((Animatable) imageView.getDrawable()).start();
        }
    }

    u(Context context, Bitmap bitmap, Drawable drawable, t.d dVar, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.d = 255;
        this.f = z2;
        this.g = context.getResources().getDisplayMetrics().density;
        this.h = dVar;
        if ((dVar == t.d.MEMORY || z) ? false : true) {
            this.f4164a = drawable;
            this.c = true;
            this.f4165b = SystemClock.uptimeMillis();
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.c) {
            super.draw(canvas);
        } else {
            float fUptimeMillis = (SystemClock.uptimeMillis() - this.f4165b) / 200.0f;
            if (fUptimeMillis >= 1.0f) {
                this.c = false;
                this.f4164a = null;
                super.draw(canvas);
            } else {
                if (this.f4164a != null) {
                    this.f4164a.draw(canvas);
                }
                super.setAlpha((int) (this.d * fUptimeMillis));
                super.draw(canvas);
                super.setAlpha(this.d);
            }
        }
        if (this.f) {
            a(canvas);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.d = i;
        if (this.f4164a != null) {
            this.f4164a.setAlpha(i);
        }
        super.setAlpha(i);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f4164a != null) {
            this.f4164a.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.f4164a != null) {
            this.f4164a.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    private void a(Canvas canvas) {
        e.setColor(-1);
        canvas.drawPath(a(0, 0, (int) (this.g * 16.0f)), e);
        e.setColor(this.h.d);
        canvas.drawPath(a(0, 0, (int) (this.g * 15.0f)), e);
    }

    private static Path a(int i, int i2, int i3) {
        Path path = new Path();
        float f = i;
        float f2 = i2;
        path.moveTo(f, f2);
        path.lineTo(i + i3, f2);
        path.lineTo(f, i2 + i3);
        return path;
    }
}
