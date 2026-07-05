package com.google.android.material.c;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.google.android.material.c.d;

/* compiled from: CircularRevealHelper.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int f3771a;

    /* renamed from: b, reason: collision with root package name */
    private final a f3772b;
    private final View c;
    private final Path d;
    private final Paint e;
    private final Paint f;
    private d.C0083d g;
    private Drawable h;
    private boolean i;
    private boolean j;

    /* compiled from: CircularRevealHelper.java */
    interface a {
        void a(Canvas canvas);

        boolean c();
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f3771a = 2;
        } else if (Build.VERSION.SDK_INT >= 18) {
            f3771a = 1;
        } else {
            f3771a = 0;
        }
    }

    public void a() {
        if (f3771a == 0) {
            this.i = true;
            this.j = false;
            this.c.buildDrawingCache();
            Bitmap drawingCache = this.c.getDrawingCache();
            if (drawingCache == null && this.c.getWidth() != 0 && this.c.getHeight() != 0) {
                drawingCache = Bitmap.createBitmap(this.c.getWidth(), this.c.getHeight(), Bitmap.Config.ARGB_8888);
                this.c.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                this.e.setShader(new BitmapShader(drawingCache, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            }
            this.i = false;
            this.j = true;
        }
    }

    public void b() {
        if (f3771a == 0) {
            this.j = false;
            this.c.destroyDrawingCache();
            this.e.setShader(null);
            this.c.invalidate();
        }
    }

    public void a(d.C0083d c0083d) {
        if (c0083d == null) {
            this.g = null;
        } else {
            if (this.g == null) {
                this.g = new d.C0083d(c0083d);
            } else {
                this.g.a(c0083d);
            }
            if (com.google.android.material.e.a.b(c0083d.c, b(c0083d), 1.0E-4f)) {
                this.g.c = Float.MAX_VALUE;
            }
        }
        g();
    }

    public d.C0083d c() {
        if (this.g == null) {
            return null;
        }
        d.C0083d c0083d = new d.C0083d(this.g);
        if (c0083d.a()) {
            c0083d.c = b(c0083d);
        }
        return c0083d;
    }

    public void a(int i) {
        this.f.setColor(i);
        this.c.invalidate();
    }

    public int d() {
        return this.f.getColor();
    }

    public Drawable e() {
        return this.h;
    }

    public void a(Drawable drawable) {
        this.h = drawable;
        this.c.invalidate();
    }

    private void g() {
        if (f3771a == 1) {
            this.d.rewind();
            if (this.g != null) {
                this.d.addCircle(this.g.f3777a, this.g.f3778b, this.g.c, Path.Direction.CW);
            }
        }
        this.c.invalidate();
    }

    private float b(d.C0083d c0083d) {
        return com.google.android.material.e.a.a(c0083d.f3777a, c0083d.f3778b, 0.0f, 0.0f, this.c.getWidth(), this.c.getHeight());
    }

    public void a(Canvas canvas) {
        if (h()) {
            switch (f3771a) {
                case 0:
                    canvas.drawCircle(this.g.f3777a, this.g.f3778b, this.g.c, this.e);
                    if (i()) {
                        canvas.drawCircle(this.g.f3777a, this.g.f3778b, this.g.c, this.f);
                        break;
                    }
                    break;
                case 1:
                    int iSave = canvas.save();
                    canvas.clipPath(this.d);
                    this.f3772b.a(canvas);
                    if (i()) {
                        canvas.drawRect(0.0f, 0.0f, this.c.getWidth(), this.c.getHeight(), this.f);
                    }
                    canvas.restoreToCount(iSave);
                    break;
                case 2:
                    this.f3772b.a(canvas);
                    if (i()) {
                        canvas.drawRect(0.0f, 0.0f, this.c.getWidth(), this.c.getHeight(), this.f);
                        break;
                    }
                    break;
                default:
                    throw new IllegalStateException("Unsupported strategy " + f3771a);
            }
        } else {
            this.f3772b.a(canvas);
            if (i()) {
                canvas.drawRect(0.0f, 0.0f, this.c.getWidth(), this.c.getHeight(), this.f);
            }
        }
        b(canvas);
    }

    private void b(Canvas canvas) {
        if (j()) {
            Rect bounds = this.h.getBounds();
            float fWidth = this.g.f3777a - (bounds.width() / 2.0f);
            float fHeight = this.g.f3778b - (bounds.height() / 2.0f);
            canvas.translate(fWidth, fHeight);
            this.h.draw(canvas);
            canvas.translate(-fWidth, -fHeight);
        }
    }

    public boolean f() {
        return this.f3772b.c() && !h();
    }

    private boolean h() {
        boolean z = this.g == null || this.g.a();
        return f3771a == 0 ? !z && this.j : !z;
    }

    private boolean i() {
        return (this.i || Color.alpha(this.f.getColor()) == 0) ? false : true;
    }

    private boolean j() {
        return (this.i || this.h == null || this.g == null) ? false : true;
    }
}
